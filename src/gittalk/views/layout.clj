(ns gittalk.views.layout
  (:use noir.request)
  (:require [gittalk.util :as util]
            [hiccup.core :as hiccup]))

(defn add-context [url] (str (:context *request*) url)) 

(defn include-css [& filenames]
  (for [filename filenames]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href (str (add-context (str "/css/" filename)))}]))

(defn include-js [& filenames]
  (for [filename filenames]
    [:script {:type "text/javascript"
              :src (str (add-context (str "/js/" filename)))}]))

(defn base [title]
  (hiccup/html
    "<!doctype html>"
    [:html
     [:head
       [:meta {:charset "utf-8"}]
       [:meta {:name "description" :content "Git talk presentation app"}]
       [:meta {:name "author" :content "Brian Jesse"}]
       [:meta {:name "apple-mobile-web-app-capable" :content "yes"}]
       [:meta {:name "apple-mobile-web-app-status-bar-style" :content "black-translucent"}]
       [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"}]
       [:title title]
       (include-css "bootstrap.css" "reveal.min.css" "zenburn.css")
       [:link#theme {:rel "stylesheet" :href "/css/theme/solarized.css"}]
       (include-css "screen.css")
       [:script {:type "text/javascript"}
         (str "var context='" (:context *request*) "';")]]
     [:body
         [:div.reveal
           [:div.slides
             [:section {:data-markdown (add-context "/md/gittalk.md") :data-seperator "^\\n---\\n$" :data-vertical "^\\n--\\n$"}]]]
         [:script
           {:src "//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"}]
         (include-js "head.min.js" "reveal.js" "bootstrap.min.js" "app.js")]]))


(defn render [content]
  (hiccup/html (util/md->html content)))

