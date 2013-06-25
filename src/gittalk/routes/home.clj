(ns gittalk.routes.home
  (:use compojure.core)
  (:require [gittalk.views.layout :as layout]
            [gittalk.util :as util]))

(defn home-page []
  (layout/base "Introduction to Git"))

(defroutes home-routes
  (GET "/" [] (home-page)))
