(ns reverse-string 
  (:require
   [clojure.string :as str]))

(defn reverse-string
  "Reverses the given string"
  [s]
  (-> s
  (str/reverse)
))
