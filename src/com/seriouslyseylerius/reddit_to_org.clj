(ns com.seriouslyseylerius.reddit-to-org
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn filter-json
  "Filter reddit json down to just title, text & links"
  [data]
  (let [useful-keys [:domain :subreddit :selftext :url :title :link_title :body :link_url :link_id :id]]
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
