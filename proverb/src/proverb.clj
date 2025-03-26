(ns proverb 
  (:require
    [clojure.string :as str]))


(defn make-quote [pair]
  (format "For want of a %s the %s was lost." (get pair 0) (get pair 1))
  
  )

(defn recite [quotes]
  (if (empty? quotes)
    ""
    (let [sentences (->> quotes
                         (partition 2 1)
                         (mapv vec)
                         (map make-quote))]
    (->> (concat sentences [(format "And all for the want of a %s." (first quotes))])
         (str/join "\n")))))

