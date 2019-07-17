(ns semantic-ui-example.core
    (:require
      [reagent.core :as r]
     ["semantic-ui-react" :as ui]))

(defonce state (r/atom 0))

(defn home-page []
  [:div [:h2 "Welcome to Semantic UI"]
   [:> ui/Label {:color :blue}
    [:> ui/Label.Detail "Clicks: " @state]]
   [:> ui/Button
    {:basic    true
     :color    "red"
     :on-click (fn [] (swap! state inc))}
    "count up"]])

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
