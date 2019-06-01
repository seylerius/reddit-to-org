(ns com.seriouslyseylerius.reddit-to-org
  (:require [clojure.data.json :as json]
            [reddit.clj.core :as reddit])
  (:gen-class))

;; (defn append-saved
;;   "Get the next grouping of saved items, optionally stopping")

;; (defn get-saved
;;   "Retrieve saved items, optionally stopping on a particular item."
;;   ([rc]
;;    )
;;   (loop [count 0 after nil data (reddit/saved rc)] (let [c (+ count 25) a (:name (last data))] (println data) (if data (recur c a (reddit/saved rc c a))))))

(defn saved
  "Get saved items from reddit, marking the end count and the ID of the tail."
  ([rc]
   (let [page (reddit/saved rc)]
     {:page page
      :next [25 (:name (last page))]}))
  ([rc [count after]]
   (let [page (reddit/saved rc count after)]
    {:page page
     :next [(+ count 25) (:name (last page))]})))

(defn filter-json
  "Filter reddit json down to just title, text & links"
  [data]
  (let [useful-keys [:domain :subreddit :selftext :url :title :link_title :body :link_url :link_id :id :name]]
    (->> data
        :data
        :children
        (filter map?)
        (map :data)
        (map #(select-keys % useful-keys)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
