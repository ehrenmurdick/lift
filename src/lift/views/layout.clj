(ns lift.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype include-css]]))

(defn common [title & body]
  (html
    (doctype :html5)
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
      [:title title]]
    [:body
      [:div {:id "header"}
      [:h1 {:class "container"} "Liftr"]]
      [:div {:id "content" :class "container"} body]]))

(defn four-oh-four []
  (common "Page Not Found"
    [:div {:id "four-oh-four"}
      "The page you requested could not be found"]))
