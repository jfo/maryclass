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
         (doseq [i car-positions] (println (apply str (repeat i "-"))))
         (println)
         (recur (map (fn [n] (if (> (rand) 0.5)
                               (inc n)
                               n))
                     car-positions)
                (- timer 1)))))))


(> (rand) 0.5)
(rand)
(race )


; alan helped with lazyseqs
(defn mynat [x]
  (lazy-seq
    (cons x (mynat (+ x 1)))))

(take 1 (mynat 1))
(take 50 (mynat 1))
(apply str (replicate 5 "-"))

; functionally but subroutines? once again, sillytime!

(def car-positions [1 1 1])
(def timer 5)

(defn move-cars
  ([] (move-cars car-positions))
  ([car-pos]
   (def car-positions
    (for [n car-pos]
      (if (> (rand) 0.3)
        (+ n 1)
        n)))))

(defn draw-car [pos]
  (apply println (replicate pos "-")))

(defn run-step-of-race []
    (do
      (def timer (- timer 1))
      (move-cars)))

(defn draw []
  (for [pos car-positions]
    (str (draw-car pos))))

(while (> timer 0)
  (run-step-of-race)
  (draw))


(draw)
(run-step-of-race)
(str timer)

; blerp blerp works enough


; =============================================
(defn move-cars [car-positions]
  (map #((if (> (rand) 0)
           (+ 1 %)
           %))
       car-positions))

(defn output-car [pos]
  (apply str (replicate pos "-")))

(defn run-step-of-race [state]
  {"time" (- (state "time") 1)
   "car-positions" (move-cars (state "car-positions"))})

(defn draw [state]
  (newline)
  (map #(output-car %) (state "car-positions")))

(defn race [state]
  (draw state)
  (if (> (state "time") 0)
    (race (run-step-of-race state))))

(race {"time" 5 "car-positions" [1 1 1]})

; (AHHHH HOW DO I PRINT ANYTHING:????)
(do
  (print "derp")
  (newline)
  (print "derp"))

; =============================================
