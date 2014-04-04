(defproject semantweets "0.1.0-SNAPSHOT"
  :description "Semantic analyzer of Twitter streams"
  :url "http://example.com/FIXME"
  :repositories [["bintray-sdm" "http://dl.bintray.com/kemlg/sdm"]
                 ["bintray" "http://dl.bintray.com/tranchis/clojure-snippets"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.glassfish.metro/metro-runtime-impl "2.2.1-1"]
                 [org.glassfish.metro/webservices-rt "2.2.1-1"]
                 [clj-http "0.6.4"]
                 [org.clojure/data.json "0.2.2"]
                 [incanter "1.5.4"]]
  :java-source-paths ["java"]
  :jvm-opts ["-Xmx1g"
             "-Djava.awt.headless=true"
             "-Dcom.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize=true"]
  :plugins [[no-man-is-an-island/lein-eclipse "2.0.0"]])
