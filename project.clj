(defproject com.seriouslyseylerius/reddit-to-org "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [reddit.clj "0.4.0"]]
  :main ^:skip-aot com.seriouslyseylerius.reddit-to-org
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
