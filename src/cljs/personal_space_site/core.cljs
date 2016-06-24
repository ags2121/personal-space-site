(ns personal-space-site.core
  (:require [reagent.core :as r]
            [cljs.spec :as s]))

(enable-console-print!)

(def page? #{:home :music :shows :pix :about :$$$})

(s/def ::page page?)

(defonce app-state (r/atom {:text "Hello world!"}))

(.addEventListener (.querySelector js/document ".em") "click"
                   (fn [_]
                     (.setAttribute (.querySelector js/document ".main") "class" "hidden")
                     (-> (.querySelector js/document "html")
                         (.-classList)
                         (.add "email"))))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
