(ns sprue.sheet
  "Sheets convert a seq of SVG data into a seq of rasterized image files."
  (:import [org.apache.batik.transcoder TranscoderInput TranscoderOutput])
  (:require [clojure.xml :as xml]))

(defn transcode
  [transcoder input output]
  (with-open [reader (java.io.StringReader. (with-out-str (xml/emit input)))
              writer (clojure.java.io/output-stream output)]
    (let [in (TranscoderInput. reader)
          out (TranscoderOutput. writer)]
      (.transcode transcoder in out)
      (.flush writer))))

(defn png-1up ; TODO(#2): implement.
  [cards & opts]
  )
