(ns day2
  (:require [input.day2 :refer [input]]))

(defn parse [line]
  (let [[_ min max l p] (re-matches #"(\d+)-(\d+) (\w): (\w+)" line)]
    [(Integer/parseInt min) (Integer/parseInt max) (first l) p]))

(defn valid-password? [min max l p]
  (<= min (get (frequencies p) l 0) max))

(defn count-valid [ps]
  (count (filter identity (map #(apply valid-password? (parse %)) ps))))

(defn -main []
  (println (count-valid input)))