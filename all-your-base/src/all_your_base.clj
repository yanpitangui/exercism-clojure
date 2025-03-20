(ns all-your-base 
  (:require
   [clojure.math :as math]))

(defn to_base_10 [input_base input_digits] 
  (int (reduce (fn [acc [i digit]]
              (+ acc (* digit (math/pow input_base (- (count input_digits) i 1)))))
            0
            (map-indexed vector input_digits)))
  )

(defn convert [input_base input_digits output-base] ;; <- arglist goes here
  ;; your code goes here '
  (let [actual-digits (drop-while zero? input_digits)
        invalid  (or (< input_base 2) (< output-base 2)
                    (some #(or (>= % input_base) (neg? %)) actual-digits)) 
        ]
   
   (cond invalid nil
         (empty? input_digits) ()
         (every? zero? input_digits) (seq [0])
         :else (loop [n (to_base_10 input_base input_digits)
                      res []]  ;; Start with an empty list
                 (if (zero? n)
                   (reverse res)
                   (recur (quot n output-base) (conj res (mod n output-base)))))))
)
