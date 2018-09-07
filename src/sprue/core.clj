(ns sprue.core
  "Ties together card data, card templates, and sheet templates."
  (:import [java.io StringReader]
           [org.apache.batik.transcoder TranscoderInput TranscoderOutput]
           [org.apache.batik.transcoder.image PNGTranscoder])
  (:require [clojure.xml :as xml]
            [clojure.java.io :as io]))

; Three points of user interaction:
; 1. Card data, slurped in from a record-oriented data file.
;    Anything that can produce a seq of maps.
(def data
  [{:name "Foo" :text "1"}
   {:name "Bar" :text "2"}])

; 2. Card layout, as SVG and perhaps CSS.
;    Anything that can generate a valid SVG document.
(defn poker-card ; TODO(#3): implement.
  [& content]
  {:tag :svg
   :attrs {:xmlns "http://www.w3.org/2000/svg" :width "2.5in" :height "3.5in"}
   :content content})

; 3. Sheet layout, as SVG and Batik Transcoder options.
;    https://xmlgraphics.apache.org/batik/using/transcoder.html
; TODO
(defn svg->string [svg] (with-out-str (xml/emit svg)))
(defn svg->png
  [svg png]
  (with-open [reader (StringReader. (svg->string svg))
              writer (io/output-stream png)] ; PNG doesn't support writer.
    (let [tr (PNGTranscoder.)
          in (TranscoderInput. reader)
          out (TranscoderOutput. writer)]
      (.transcode tr in out)
      (.flush writer))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (svg->png
    (poker-card {:tag :text
                 :attrs {:x "1in" :y "1in" :fill "black"}
                 :content ["Hello, world!"]})
    "output.png"))
