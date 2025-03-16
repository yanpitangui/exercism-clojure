(ns raindrops)

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
    (cond-> nil 
          (zero? (rem num 3)) (str "Pling")
          (zero? (rem num 5)) (str "Plang")
          (zero? (rem num 7))  (str "Plong")
          :always (or (str num)))
  );; function body
  
