(ns lift.controllers.routines
  (:use [compojure.core :only [defroutes GET POST DELETE]])
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

(defn destroy [params]
  (let [id (:id params)]
    (prn "destroying:" params)
    (when-not (str/blank? id)
      (model/destroy id)))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (DELETE "/:id" {params :params} (destroy params))
  (POST "/" {params :params} (create params)))
