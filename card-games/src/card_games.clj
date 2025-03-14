(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (+ n 1) (+ n 2))
  )

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2)
  )

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (.contains l n)
  )

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double   (/ (reduce + hand) (count hand)))
  )

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [median (double (nth hand (/ (count hand) 2)))
        first-last (double (card-average [(first hand) (last hand)])) 
        average (card-average hand)]
    (or (== median average)
        (== first-last average)))
  )

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (== 
    (card-average (take-nth 2 hand)) (card-average (take-nth 2 (rest hand))))
  )

(defn list-update-in [l i x]
  (let [newlist (take i l)
        newlist (concat newlist (list x))
        newlist (concat newlist (drop (+ 1 i) l))]
    newlist))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (== 11 (last hand)) 
    (list-update-in hand (- (count hand) 1) (* 2 (last hand)))
    hand)
  )
