(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first-c] deck]
    first-c) 
)

(defn second-card
  "Returns the second card from deck."
  [deck]
    (let [[_ second-c] deck]
    second-c) 
)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[first-c second-c & remaining] deck]
    (concat [second-c first-c] remaining))
)

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
    (let [[first-c & remaining] deck]
    [first-c remaining])
)

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[jack queen king] face-cards
        [first-c & remaining] deck]
    (cond (= [] deck) face-cards
          :else (concat [first-c jack queen king] remaining)) 
    )
)
