(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s 
      (str/replace #" " "_")
      (str/replace #"[\u0000-\u001F\u007F-\u009F]" "CTRL") 
      (str/replace #"-(\p{L})" #(str/upper-case (%1 1)))
      (str/replace #"[^\p{L}_]|[α-ω]" "")
      )
  )
