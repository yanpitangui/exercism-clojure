(ns binary-search)

(defn search-for
  "Returns the index of num in coll, or -1 if num is not found."
  [num coll]
  ;; function body
  (loop [low 0 
         high (dec (count coll))] 
    
    (let [mid (quot (+ low high) 2)
          mid_value (get coll mid)] 
      
      (cond
        (> low high) -1
        (= mid_value num) mid
        (< mid_value num) (recur (inc mid) high)
        :else (recur low (dec mid))
        )
      ) 
    
    )
  )
