(ns bob
  (:require [clojure.string :as str]))

(defn silence [s] 
  (str/blank? s))

(defn all-capital-letters [s] 
  (and (= s (str/upper-case s)) (re-find #"[a-zA-z]" s))) 

(defn question [s]
  ( str/ends-with? (str/trim s) "?") )

(defn yell [s]
  (and (question s) (all-capital-letters s)))

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
  (cond 
    (silence s) "Fine. Be that way!" 
    (yell s) "Calm down, I know what I'm doing!"  
    (question s) "Sure."
    (all-capital-letters s) "Whoa, chill out!"
    :else "Whatever.")
)
