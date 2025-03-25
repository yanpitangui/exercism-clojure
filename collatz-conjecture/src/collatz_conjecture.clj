(ns collatz-conjecture)


(defn when-even [num]
  (/ num 2)
  ) 


(defn when-odd [num]
  (inc (* num 3))
  ) 

(defn -collatz [num]
  (if (odd? num)
    (when-odd num)
    (when-even num))
  )

(defn collatz
  "Returns the number of steps it takes to reach 1 according
  to the rules of the Collatz Conjecture."
  [num]
  ;; function body
  (loop [cnt 0 num num]
    (if (== 1 num) 
      cnt 
        (recur (inc cnt) (-collatz num))
        )
    

    )
)

