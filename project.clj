(defproject sprue "0.1.0-SNAPSHOT"
  :description "A prototyping system for card games."
  :url "https://github.com/blinks/sprue"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.xmlgraphics/batik-transcoder "1.10"]]
  :main ^:skip-aot sprue.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
