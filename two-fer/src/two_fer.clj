(ns two-fer)

(defn two-fer
  "Return what you will say as you give away the extra cookie"
  ([name]
  ;; function body
  (format "One for %s, one for me."  name))
  ([]
  "One for you, one for me.")
  )
