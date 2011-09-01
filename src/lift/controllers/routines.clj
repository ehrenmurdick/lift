(ns lift.controllers.routines
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [lift.views.routines :as views]
            [lift.models.routine :as model]))

(defn index []
  (views/index (model/all)))

(defn create [params]
  (let [lift (:name params)]
    (println (str params))
    (when-not (str/blank? lift)
      (model/create lift)))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" {params :params} (create params)))
