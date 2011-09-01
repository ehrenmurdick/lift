(ns lift.views.routines
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-field submit-button]])
  (:require [lift.views.layout :as layout]))

(defn lift-form []
  [:div {:id "routine-form"}
    (form-to [:post "/"]
      (label "name" "name")
      (text-field "name")
      (submit-button "Save"))])

(defn display-lifts [lifts]
  [:div {}
   (map
    (fn [lift] [:h2 {:class "lift"} (h (:name lift))])
    lifts)])

(defn index [lifts]
  (layout/common "LIFT"
    (lift-form)
    [:div {:class "clear"}]
    (display-lifts lifts)))
