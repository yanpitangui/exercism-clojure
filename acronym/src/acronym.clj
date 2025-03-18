(ns acronym 
  (:require
    [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (-> phrase
      (str/replace #"[^a-zA-Z0-9\s-]" "")  ;; Remove non-alphanumeric characters except spaces
      (str/split #"[\s-]"))              ;; Split on spaces or hyphens
      (remove str/blank?) ;; remove empty strings
      (map first) ;; get first chars
       (map str/upper-case) ;; make them uppercase
       (apply str) ;; transform vector into string
      )
  
  )              ;; Remove empty strings
