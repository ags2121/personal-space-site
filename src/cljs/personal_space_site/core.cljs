(ns personal-space-site.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def component-names [:home :music :shows :pix :about :$$$])

(defrecord SocialMedia [name url])
(def social-medias [(->SocialMedia :soundcloud "https://soundcloud.com/personal_space")
                    (->SocialMedia :facebook "https://www.facebook.com/personalspaceband/")
                    (->SocialMedia :instagram "https://www.instagram.com/personal____space/")
                    (->SocialMedia :youtube "https://www.youtube.com/channel/UCi6-1v_qFCnKHJKy544srlw")
                    (->SocialMedia :twitter "https://twitter.com/PersonalSpacers")
                    (->SocialMedia :mail "")])

(defonce current-component (r/atom :home))

(defn social []

  [:ul.links
   (for [social-media social-medias]
     [:li {:key (:name social-media)}
      [:a {:href (:url social-media) :target "_blank"}
       [:img {:src (str "/assets/" (-> social-media :name name) ".svg")}]]])])

(defn menu []
  [:ul.menu
   (for [component-name component-names]
     (if (not= component-name :home)
       [:li {:key component-name}
        [:a {:class component-name :on-click #(reset! current-component component-name)}
         (clojure.string/upper-case (name component-name))]]))])

(defn component [name & body]
  (fn []
    (let [displayed-component-name @current-component
          hidden? (not= name displayed-component-name)
          component-base [:div {:class (str name " " (if hidden? "hidden"))}]]
      (into component-base body))))

(defn app []
  [:div.root
   [menu]
   [:div.components
    [component :home [:h1.test "Ecstatic Burbs"] [:h3 "Personal Space"]]
    [component :music [:h5 "Check these dope tunes."]]
    [component :shows [:h5 "We got shows."]]
    [component :pix [:h5 "We got pix"]]
    [component :about [:h5 "Personal Space is a band."]]
    [component :$$$ [:h5 "You can buy our music."]]]
   [social]
   ])
;
(defn ^:export run []
  (r/render [app]
            (js/document.getElementById "app")))

(run)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
