; CLOJURE

(def a 0)

(defn increment1 []
  (def a (+ a 1)))

(print a)
(increment1)
(print a)

(def b 0)
(defn increment2 [a] (+ a 1))
(increment2 b)

(def names ["Mary", "Isla", "Sam"])
(pprint names)
(map count names)

(map #(* % %) [0 1 2 3 4])


; now we are getting silly

(defn assign-codes [names]
  (let [code-names ["Mr. Pink" "Mr. Orange" "Mr. Blonde"]]
    (loop [acc []
           length (count names) ]
      (if (= 0 length)
        acc
        (recur (conj acc (rand-nth code-names)), (- length 1))))))

(assign-codes names)

; lol!

(def code-names ["Mr. Pink" "Mr. Orange" "Mr. Blonde"])
(print code-names)
(map (fn [x]
       (rand-nth code-names))
     names)

; (lol!)

(print names)
(map (fn[e] (hash e)) names)


(reduce + [0 1 2 3 4])


(def people [{"name" "Mary" "height" 160}
             {"name" "Isla" "height" 80}
             {"name" "Sam"}])

(contains? (people 0) "height")



(defn avgheight [people]
  (let [heights (for [person (filter
                               #(contains? % "height")
                               people)]
                  (person "height"))]
    (/ (reduce + heights) (count heights))))

(avgheight people)


(do
    (println (first [ 1 2 3 ]))
    (println (rest [ 1 2 3 ])))

(defn race
  "this function is not done"
  ([] (race 5))
  ([timer]
   (loop [car-positions [1 1 1]
         timer timer]
     (if (= 0 timer)
       nil
       (do 
           (println (map #(repeat % "-") car-positions))
           (recur car-positions (- timer 1)))))))

(race)


