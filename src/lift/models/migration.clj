(ns lift.models.migration
  (:use [lift.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn create-routines []
  (sql/with-connection db
    (sql/create-table :routines
                      [:id :serial "PRIMARY KEY"]
                      [:name :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn -main []
  (print "Migrating database...") (flush)
  (create-routines)
  (println " done"))
