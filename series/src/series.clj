(ns series 
  (:require
   [clojure.string :as str]))

(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  ;; function body
  (let [string_len (count s)
        string_slices (partition n 1 (seq s))] 
    (cond 
      (str/blank? s) (throw (IllegalArgumentException. "series cannot be empty"))
      (neg? n) (throw (IllegalArgumentException. "slice length cannot be negative"))
      (zero? n) (throw (IllegalArgumentException. "slice length cannot be zero"))
      (> n string_len) (throw (IllegalArgumentException. "slice length cannot be greater than series length" ) )
      :else (mapv #(apply str %) string_slices)
      )) 
  )
