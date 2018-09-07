(ns sprue.core
  "Ties together card data, card templates, and sheet templates."
  (:import java.io.StringReader
           org.apache.batik.transcoder.image.PNGTranscoder)
  (:require [clojure.xml :as xml])
  (:use sprue.card sprue.sheet))

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
; TODO

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [t (PNGTranscoder.)]
    (transcode t
               (poker-card {:tag :rect
                            :attrs {:x "1in"
                                    :y "1in"
                                    :width "1in"
                                    :height "1in"
                                    :style "fill: black;"}})
               "output.png")))
