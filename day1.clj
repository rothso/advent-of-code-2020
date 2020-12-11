(ns day1
  (:require [input.day1 :refer [input]]))

;; Returns the product of two numbers in xs that sum to t, or nil if no such numbers exist
(defn find-sum-product [xs t]
  (some-> (some (set xs) (map (partial - t) xs)) (#(* % (- t %)))))

;; Returns the product of three numbers in xs that sum to t, or nil if no such numbers exist
(defn find-triplet-product [xs t]
  (some identity (map #(some-> (find-sum-product xs %) (* (- t %))) (map (partial - t) xs))))

(defn -main []
  (println (find-sum-product input 2020))
  (println (find-triplet-product input 2020)))
