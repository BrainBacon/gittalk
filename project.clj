(defproject gittalk "1.0"
  :description "Website for Git presentation"
  :url "http://brian-jesse.com/gittalk"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [lib-noir "0.6.2"]
                 [compojure "1.1.5" :exclusions [org.clojure/tools.macro ring/ring-core]]
                 [ring-server "0.2.8"]
                 [clabango "0.5"]
                 [com.taoensso/timbre "2.1.2"]
                 [com.postspectacular/rotor "0.1.0"]
                 [com.taoensso/tower "1.7.1"]
                 [hiccup "1.0.3"]
                 [markdown-clj "0.9.26"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler gittalk.handler/war-handler
         :init    gittalk.handler/init
         :destroy gittalk.handler/destroy}
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.1.8"]]}}
  :min-lein-version "2.0.0")
