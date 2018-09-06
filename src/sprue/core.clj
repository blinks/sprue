(ns sprue.core
  (:require [clojure.xml :as xml])
  (:import org.apache.batik.transcoder.TranscoderInput)
  (:gen-class))

; Three points of user interaction:
; 1. Card data, slurped in from a record-oriented data file.
;    Anything that can produce a seq of maps.
(def data
  [{:name "Foo" :text "1"}
   {:name "Bar" :text "2"}])

; 2. Card layout, as SVG and perhaps CSS.
;    Anything that can generate a valid SVG document.
; 3. Sheet layout, as SVG and Batik Transcoder options.
;    https://xmlgraphics.apache.org/batik/using/transcoder.html

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, world!"))
