(ns armstrong-numbers 
  (:require
   [clojure.math :as math]))



(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))))

(defn exp [x n]
  (apply * (repeat n x)))

(defn armstrong?
  "Returns true if the given number is an Armstrong number; otherwise, returns false"
  [num]
  (let [dts (digits num)]
    (->> dts
         (map #(exp % (count dts)))
         (apply +)
         (= num))))
