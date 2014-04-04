(ns com.github.kemlg.semantweets.core
  (require [clj-http.client :as client]
           [clojure.data.json :as json]
           [incanter.distributions :as incd]
           [clojure.math.combinatorics :as combo]))

(import (org.tempuri ILookupService LookupService))

(def ngram-service (-> (LookupService.) .getWSHttpBindingILookupService))
;(def ngram-model (last (into [] (. (. ngram-service getModels) getString))))
(def ngram-model-prefix "urn:ngram:bing-body:apr10:")
(def auth-token "c3db7705-c676-4bfd-b918-281c1bf84c4f")

; Optimisation problem: arg max(s1,...,sm) C(d) | Sum(C(si),i=1,m)

; We define stickiness function by using the generalized Symmetric Conditional Probability (SCP)
; for n-grams with n ≥ 2, supported by statistical information
; derived from Microsoft Web N-Gram service6 and Wikipedia.
; SCP is defined to measure the "cohesiveness" of a segment
; s = ⟨w1 ...wn ⟩ (n > 1) by considering all possible binary segmentations,
; as shown in the following equation, where Pr(·) denotes
; the prior probability derived from Microsoft Web N-Gram service.
(defn m-prior-probability [s]
  {:post [(and (>= % 0.0) (<= % 1.0))]}
  (let [ngram-model (str ngram-model-prefix (min 5 (count s)))]
    ; (println "using model: " ngram-model)
    (let [prob-log (. ngram-service getProbability auth-token ngram-model (apply str (interpose " " s)))
          prob (Math/pow 10 prob-log)]
      ; (println "prior-probability " s " = " prob)
      prob)))

(def prior-probability
  (memoize m-prior-probability))

(defn split-segment [l i]
  [(take (+ i 1) l) (drop (+ i 1) l)])

(defn scp [s]
  {:pre [(vector? s) (> (count s) 0)]}
  "s is a segment <w1 ...wn> (n > 1)"
  ; (println "calculating scp of " s)
  (if (= (count s) 1)
    (do
      (let [result-single (* 2 (Math/log (prior-probability s)))]
        ; (println "result-single: " result-single)
        result-single))
    (let [r (range (- (count s) 1))
          sets (map #(split-segment s %) r)
          probs (map #(* (prior-probability (first %)) (prior-probability (second %))) sets)
          sum-probs (reduce + probs)
          denom (/ sum-probs (- (count s) 1))
          numer (Math/pow (prior-probability s) 2)]
      ; (println "prob: " (prior-probability s) " numer: " numer " denom: " denom " scp: " (Math/log (/ numer denom)))
      (Math/log (/ numer denom)))))

(defn length-preference [s]
  {:pre [(vector? s) (> (count s) 0)]}
  (if (= (count s) 1)
    1
    (/ (- (count s) 1) (count s))))

(defn sigmoid [t]
  (/ 1 (+ 1 (Math/exp (- t)))))

(defn m-query-wikipedia [q]
  (println "url: " (str "http://en.wikipedia.org/w/api.php?" q))
  (->
    (client/get (str "http://en.wikipedia.org/w/api.php?" q))
    :body
    (json/read-str :key-fn keyword)))

(def query-wikipedia (memoize m-query-wikipedia))

(defn m-correct-title [s]
  (let [q (apply str (interpose "%20" s))
        f (->
			    (query-wikipedia (str "action=query&srnamespace=0&srredirects=true&list=search&format=json&srwhat=text&srsearch=" q))
			    :query
		      :search
		      first)
        t (:title f)
        r (into [] (map second (re-seq #"searchmatch'\>(\S+)\</span" (:snippet f))))]
    ; (println r)
    (if (or
          (= (clojure.string/lower-case (apply str (interpose " " s))) (clojure.string/lower-case t))
          (= (clojure.string/lower-case (apply str (interpose " " s))) (clojure.string/lower-case (apply str (interpose " " r)))))
      (clojure.string/split t #" ")
      (do
        ; (println (str "Warning! " s " not found in Wikipedia"))
        s))))

(def correct-title (memoize m-correct-title))

(defn m-number-of-backlinks [s]
  (let [;ct (correct-title s) ; TODO: find a better way 
        ct s
        q (apply str (interpose "%20" ct))
        bl (->
             (query-wikipedia (str "action=query&format=json&bllimit=500&list=backlinks&blnamespace=0&bltitle=" q))
             :query
             :backlinks
             count)]
    (if (nil? bl)
      0
      bl)))

(def number-of-backlinks (memoize m-number-of-backlinks))

(defn m-number-of-hits [s]
  (let [q (apply str (interpose "%20" s))]
	  (->
	    (query-wikipedia (str "action=query&srwhat=text&format=json&srlimit=50&list=search&srnamespace=0&srsearch=%22" q "%22"))
	    :query
	    :searchinfo
	    :totalhits)))

(def number-of-hits (memoize m-number-of-hits))

(defn wikipedia-probability [s]
  {:pre [(vector? s) (> (count s) 0)]}
  (let [hits (number-of-hits s)]
    ; (println "hits:" hits)
    (if (or (nil? hits) (= hits 0))
      0
      (do
        (let [bl (inc (number-of-backlinks s))] ; TODO: Check if inc is adequate... it temporarily serves as a protection against the special case of orphan pages!
          #_(println "backlinks: " bl)
          (if (> bl hits) ;; TODO: Fix this... shouldn't happen too often though.
            1
            (/ bl hits)))))))

(defn m-stickiness [s]
  {:pre [(vector? s)]}
  (let [;ct (correct-title s) ; TODO: find a better way
        ct s]
    ;(println s " is: " ct)
    ;(println "wp: " (wikipedia-probability ct))
    (let [stickiness (* (length-preference ct) (Math/exp (wikipedia-probability ct)) (sigmoid (scp ct)))]
      ; (println "Stickiness: " stickiness " length-preference: " (length-preference ct) " exp wp: " (Math/exp (wikipedia-probability ct)) 
      ;         " sigmoid: " (sigmoid (scp ct)) " scp: " (scp ct) " ct: " ct)
      stickiness)))

(def stickiness (memoize m-stickiness))

(defn number-of-tweets [t]
  10)

(defn expected-tweet-probability [s]
  0.5)

(defn expected-tweets [s t]
  (* (number-of-tweets t) (expected-tweet-probability s)))

(defn tweet-probability [s t]
  (let [est (expected-tweets s t)]
    (incd/normal-distribution est (* est (- 1 (expected-tweet-probability s))))))

(defn tweet-frequency [s t]
  0.5)

(defn bursty-segment [s t]
  (> (tweet-frequency s) (expected-tweets s t)))

(defn sigma [s t]
  (Math/sqrt (* (expected-tweets s t) (- 1 (expected-tweet-probability s)))))

(defn bursty-probability [s t]
  (let [est (expected-tweets s t)
        sst (sigma s t)
        fst (tweet-frequency s t)]
    (if (>= fst (+ est (* 2 sst)))
      1
      (sigmoid (* 10 (/ (- fst (+ est sst)) (sst)))))))

(defn user-frequency [s t]
  50)

(defn weight [s t]
  (* (bursty-probability s t) (Math/log (user-frequency s t))))

(defn top-k [t]
  (Math/sqrt (number-of-tweets t)))

(defn get-tweets [t]
  [["hola", "tranchis"] ["adios", "mooo"]])

(defn construct-tweet-structure [t]
  (let [tweets (get-tweets t)]
    ))

;(stickiness ["sergio" "alvarez"])

(defn get-all-positions [p n]
  (combo/combinations (drop 1 (range n)) p))

(defn get-all-intermediates [n]
  (mapcat #(get-all-positions % n) (range n)))

(defn is-in? [coll k]
  (some #(= (key k) %) coll))

(defn get-values [m]
  (into [] (map val (sort-by key m))))

(defn chop [elems ints]
  (let [r (range (count elems))
        s (apply hash-map (interleave r elems))]
    (map get-values (partition-by #(is-in? ints %) (sort-by key s)))))

(defn get-all-partitions [elems]
  (let [ints (get-all-intermediates (count elems))]
    (map #(chop elems %) ints)))

(defn sum-stickiness [l]
  (reduce + (map stickiness l)))

(defn rank-segments [phrase]
  (let [analysis (pmap #(vec (list % (sum-stickiness %))) (get-all-partitions phrase))
        sorted-analysis (sort-by second > analysis)]
    sorted-analysis))

(defn str-to-json [str]
  (json/read-str str :key-fn keyword))

(defn get-phrase [str]
  (let [str-without-urls (clojure.string/replace str #"((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)" "")]
    (clojure.string/split str-without-urls #"[\p{Punct}\s]+")))

(defn analyze-dump [file]
  (let [contents (map str-to-json (clojure.string/split (slurp file) #"\n"))
        phrases (map #(get-phrase (:text %)) contents)]
    (map rank-segments phrases)))

(defn analyze-dumps [dir-name]
  (let [directory (clojure.java.io/file dir-name)
        files (filter #(not (.isDirectory %)) (file-seq directory))
        file-set files]
    (pmap analyze-dump file-set)))

#_(analyze-dumps "contrib/")
(take 10 (rank-segments (get-phrase ["leo messi is better player than cristiano ronaldo"])))
