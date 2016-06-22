(ns personal-space-site.core
  (:require ))

(enable-console-print!)

(println "This text is printed from src/personal-space-site/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

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
