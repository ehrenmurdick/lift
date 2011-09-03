(ns lift.models.routine
  (:use [lift.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/with-connection db
    (sql/with-query-results results
      ["select * from routines order by id desc"]
      (into [] results))))

(defn create [nom]
  (sql/with-connection db
    (sql/insert-values :routines [:name] [nom])))

(defn destroy [id]
  (sql/with-connection db
    (sql/delete-rows :routines ["id=?" id])))
