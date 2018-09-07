(ns sprue.card
  "A card is a tree of nested SVG templates called with card data.")

(defn poker-card ; TODO(#3): implement.
  [& content]
  {:tag :svg
   :attrs {:xmlns "http://www.w3.org/2000/svg"
           :width "2.5in"
           :height "3.5in"}
   :content content})
