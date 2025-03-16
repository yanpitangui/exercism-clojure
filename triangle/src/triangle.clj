(ns triangle)


(defn is_triangle
  [a b c]
  (let [side_right (fn [aa bb cc]
                     (>= (+ aa bb) cc))]
    (and (side_right a b c)
         (side_right b c a)
         (side_right a c b) 
         (> a 0)
         (> b 0)
         (> c 0) 
         )
    )
  )

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  ;; function body
  
  (and (is_triangle a b c)
       (= a b c)) 
  )

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  ;; function body
    (and (is_triangle a b c)
       (or (= a b) (= b c) (= a c))) 
  )

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  ;; function body
    (and (is_triangle a b c)
         (not= a b) (not= b c) (not= a c)) 
  )

