(ns day1
  (:require [input.day1 :refer [part1]]))

(defn solve [input]
  (-> (some (set input) (map (partial - 2020) input)) (#(* % (- 2020 %)))))

(defn -main []
  (println (solve part1)))
