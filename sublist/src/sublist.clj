(ns sublist)

(defn sublist
  [coll1 coll2]
    (some #{coll1} (partition (count coll1) 1 coll2))
  )


(defn classify
  [coll1 coll2]
  ;; function body
  (cond (= coll1 coll2) :equal
        (sublist coll2 coll1) :superlist
        (sublist coll1 coll2) :sublist 
        :else :unequal)
  )