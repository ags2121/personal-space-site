(ns personal-space-site.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def component-names [:home :music :shows :pix :vidz :about :buy])

(defrecord SocialMedia [name url image])

(def social-medias [(->SocialMedia
                      :soundcloud
                      "https://soundcloud.com/tinyengines/sets/personal-space-ecstatic-burbs"
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M69.845,285.636c-1.392,0-2.503,1.105-2.589,2.573l-3.202,39.49l3.202,41.525\n\tc0.09,1.461,1.198,2.567,2.589,2.567c1.371,0,2.478-1.106,2.584-2.563l3.634-41.529l-3.634-39.505\n\tC72.328,286.733,71.219,285.636,69.845,285.636z M100.962,245.538c-1.745,0-3.17,1.426-3.249,3.246\n\tc0,0.004-2.813,78.938-2.813,78.938l2.82,41.266c0.075,1.806,1.497,3.23,3.242,3.23c1.728,0,3.158-1.426,3.245-3.251l3.179-41.245\n\tl-3.182-78.938C104.112,246.957,102.695,245.538,100.962,245.538z M54.471,282.884c-1.193,0-2.168,0.966-2.266,2.246l-3.394,42.573\n\tl3.394,41.188c0.095,1.272,1.068,2.234,2.266,2.234c1.175,0,2.154-0.962,2.26-2.234l3.858-41.188l-3.858-42.581\n\tC56.62,283.846,55.65,282.884,54.471,282.884z M85.334,260.549c-1.552,0-2.837,1.286-2.907,2.92l-3.014,64.247l3.014,41.521\n\tc0.078,1.621,1.355,2.902,2.907,2.902c1.548,0,2.828-1.287,2.918-2.91v0.012l3.411-41.523l-3.414-64.247\n\tC88.163,261.834,86.878,260.549,85.334,260.549z M39.221,284.352c-1.013,0-1.822,0.801-1.928,1.906\n\tc0,0.003-3.595,41.432-3.595,41.432l3.595,39.92c0.102,1.107,0.911,1.91,1.928,1.91c1.002,0,1.815-0.799,1.93-1.899l4.082-39.931\n\tl-4.078-41.432C41.033,285.146,40.223,284.352,39.221,284.352z M24.097,291.193c-0.817,0-1.493,0.662-1.607,1.567\n\tc0,0.017-3.783,34.921-3.783,34.921l3.783,34.146c0.11,0.915,0.786,1.579,1.607,1.579c0.806,0,1.465-0.646,1.599-1.568l4.305-34.154\n\tl-4.302-34.922C25.565,291.836,24.906,291.193,24.097,291.193z M9.863,304.562c-0.805,0-1.441,0.625-1.548,1.525l-2.812,21.594\n\tl2.816,21.228c0.106,0.899,0.738,1.524,1.548,1.524c0.782,0,1.411-0.621,1.54-1.519l3.336-21.233l-3.336-21.601\n\tC11.282,305.188,10.642,304.562,9.863,304.562z M197.085,214.774c-2.845,0-5.182,2.357-5.221,5.256l-2.137,107.744l2.141,39.104\n\tc0.036,2.857,2.373,5.21,5.217,5.21c2.839,0,5.169-2.353,5.21-5.254v0.048l2.325-39.107l-2.325-107.751\n\tC202.254,217.135,199.924,214.774,197.085,214.774z M343.151,276.771c-6.49,0-12.686,1.327-18.318,3.712\n\tc-3.772-43.107-39.563-76.921-83.214-76.921c-10.682,0-21.092,2.126-30.291,5.716c-3.573,1.399-4.521,2.841-4.559,5.623v151.801\n\tc0.041,2.924,2.283,5.364,5.117,5.649c0.119,0.01,130.41,0.084,131.257,0.084c26.151,0,47.353-21.412,47.353-47.836\n\tC390.496,298.188,369.303,276.771,343.151,276.771z M180.923,224.053c-2.66,0-4.852,2.204-4.887,4.919l-1.838,98.746\n\tc0,0.069,1.838,39.716,1.838,39.716c0.039,2.687,2.239,4.892,4.887,4.892c2.647,0,4.835-2.21,4.879-4.918l2.062-39.646\n\tl-2.062-98.792C185.764,226.265,183.571,224.053,180.923,224.053z M116.708,238.624c-1.941,0-3.511,1.572-3.575,3.579\n\tc0,0.004-2.624,85.529-2.624,85.529l2.624,40.832c0.064,1.994,1.626,3.561,3.571,3.561c1.924,0,3.496-1.564,3.572-3.574\n\tl2.954-40.818l-2.95-85.538C120.2,240.191,118.633,238.624,116.708,238.624z M132.576,235.398c-2.125,0-3.844,1.717-3.898,3.921\n\tl-2.427,88.417l2.431,40.584c0.056,2.182,1.771,3.897,3.895,3.897c2.121,0,3.821-1.717,3.897-3.905v-0.006l2.733-40.566\n\tl-2.733-88.421C136.405,237.124,134.688,235.398,132.576,235.398z M164.679,240.152c-2.502,0-4.51,2.016-4.561,4.589l-2.036,83.013\n\tl2.036,39.945c0.051,2.539,2.054,4.554,4.561,4.554c2.502,0,4.494-2.008,4.558-4.582v0.033l2.286-39.944l-2.283-83.026\n\tC169.172,242.164,167.181,240.152,164.679,240.152z M148.563,237.339c-2.317,0-4.184,1.866-4.231,4.247l-2.23,86.164l2.235,40.188\n\tc0.05,2.357,1.913,4.233,4.229,4.233c2.303,0,4.166-1.873,4.227-4.256v0.035l2.508-40.208l-2.511-86.157\n\tC152.729,239.202,150.866,237.339,148.563,237.339z"}]])

                    (->SocialMedia
                      :facebook
                      "https://www.facebook.com/personalspaceband/"
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M326.334,95.503H69.675c-35.293,0-64.172,28.878-64.172,64.176v256.645\n\tc0,35.319,28.878,64.172,64.168,64.172H326.33c35.301,0.004,64.166-28.853,64.166-64.172V159.683\n\tC390.496,124.39,361.631,95.507,326.334,95.503L326.334,95.503z M332.82,288h-62.633v168.435H198V288h-34.786v-55.104H198v-35.789\n\tc0-48.627,20.975-77.546,78.154-77.546h65.889v59.62h-53.814c-15.977-0.027-17.955,8.328-17.955,23.877l-0.09,29.833h72.191\n\tl-9.551,55.107V288H332.82z"}]])

                    (->SocialMedia
                      :instagram
                      "https://www.instagram.com/personal____space/"
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M350.408,92.503H45.592c-23.739,0-42.986,19.257-42.986,43.013v304.971\n\tc0,23.757,19.247,43.009,42.986,43.009h304.816c23.738,0,42.983-19.252,42.983-43.009V135.516\n\tC393.391,111.761,374.144,92.503,350.408,92.503z M197.785,212.93c41.318,0,74.816,33.513,74.816,74.855\n\tc0,41.338-33.498,74.852-74.816,74.852s-74.815-33.514-74.815-74.852S156.463,212.93,197.785,212.93z M347.668,422.115\n\tc0,8.639-6.993,15.636-15.628,15.636H63.71c-8.634,0-15.629-7.001-15.629-15.636V258.297h33.946\n\tc-2.351,9.375-3.607,19.179-3.607,29.284c0,66.28,53.699,120.008,119.944,120.008c66.248,0,119.944-53.728,119.944-120.008\n\tc0-10.105-1.256-19.909-3.606-29.284h32.968L347.668,422.115L347.668,422.115z M348.668,196.731c0,8.638-6.997,15.636-15.63,15.636\n\th-44.379c-8.636,0-15.627-7.003-15.627-15.636v-44.406c0-8.638,6.997-15.635,15.627-15.635h44.379c8.637,0,15.63,7,15.63,15.635\n\tV196.731z"}]])
                    (->SocialMedia
                      :youtube
                      "https://www.youtube.com/channel/UCi6-1v_qFCnKHJKy544srlw"
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M385.006,194.501c-3.954-21.167-21.578-36.962-41.817-38.913c-48.335-3.1-96.85-5.616-145.271-5.647\n\tc-48.423-0.027-96.754,2.437-145.095,5.489c-20.316,1.966-37.936,17.68-41.879,38.925c-4.492,30.596-6.734,61.489-6.734,92.372\n\tc0,30.882,2.246,61.771,6.734,92.369c3.94,21.245,21.56,38.845,41.879,40.791c48.354,3.056,96.655,6.172,145.095,6.172\n\tc48.403,0,96.956-2.721,145.271-5.848c20.239-1.966,37.863-20.086,41.817-41.242c4.533-30.545,6.785-61.398,6.785-92.25\n\tC391.791,255.886,389.529,225.049,385.006,194.501z M154.061,342.37V229.752l104.884,56.311L154.061,342.37z"}]])
                    (->SocialMedia
                      :twitter
                      "https://twitter.com/PersonalSpacers"
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M394.998,164.919c-14.433,6.436-29.938,10.787-46.219,12.744c16.61-10.019,29.373-25.881,35.39-44.785\n\tc-15.552,9.278-32.771,16.011-51.106,19.646c-14.678-15.734-35.597-25.565-58.74-25.565c-44.446,0-80.481,36.24-80.481,80.945\n\tc0,6.344,0.708,12.521,2.081,18.449c-66.884-3.383-126.183-35.604-165.877-84.581c-6.925,11.96-10.895,25.865-10.895,40.699\n\tc0,28.086,14.209,52.866,35.804,67.381c-13.193-0.418-25.605-4.058-36.448-10.123c-0.007,0.34-0.007,0.679-0.007,1.021\n\tc0,39.221,27.742,71.936,64.558,79.374c-6.757,1.854-13.861,2.844-21.202,2.844c-5.187,0-10.227-0.508-15.142-1.45\n\tc10.243,32.153,39.962,55.562,75.177,56.215c-27.542,21.711-62.245,34.649-99.949,34.649c-6.496,0-12.9-0.385-19.196-1.129\n\tc35.615,22.968,77.919,36.373,123.361,36.373c148.025,0,228.974-123.353,228.974-230.324c0-3.51-0.079-6.996-0.236-10.474\n\tC370.562,195.407,384.209,181.146,394.998,164.919z"}]])
                    (->SocialMedia
                      :mail
                      ""
                      [:svg {:y "0px", :xml:space "preserve", :width "100%", :height "100%", :viewBox "0 30 400 500", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink", :id "facebook-square", :x "0px", :version "1.1", :enable-background "new 0 95.503 396 384.993"}
                       [:path {:class "color", :d "M198.5,91.503C90.254,91.503,2.503,179.253,2.503,287.5S90.254,483.496,198.5,483.496\n\tc108.247,0,195.996-87.749,195.996-195.996S306.747,91.503,198.5,91.503z M100.501,189.501h195.997c3.498,0,6.895,0.752,10.01,2.167\n\tL198.5,317.675L90.494,191.666C93.609,190.249,97.005,189.498,100.501,189.501L100.501,189.501z M76.002,361V214.001\n\tc0-0.512,0.02-1.024,0.057-1.531l71.838,83.809L76.85,367.332C76.294,365.286,76.007,363.163,76.002,361L76.002,361z\n\t M296.498,385.498H100.501c-2.164,0-4.288-0.29-6.333-0.846l69.715-69.717l34.616,40.387l34.612-40.381l69.713,69.713\n\tC300.786,385.208,298.664,385.498,296.498,385.498L296.498,385.498z M320.998,361c0,2.163-0.29,4.286-0.846,6.332l-71.045-71.053\n\tl71.84-83.811c0.032,0.507,0.057,1.019,0.057,1.531L320.998,361L320.998,361z"}]])])

(defonce current-component (r/atom :home))

(defn social []
  [:ul.links
   (for [social-media social-medias]
     [:li {:key (:name social-media)}
      [:a
       (if (= (:name social-media) :mail)
         {:on-click #(reset! current-component (:name social-media))}
         {:href (:url social-media) :target "_blank"}
         )

       (if (:image social-media)
         (:image social-media)
         [:img {:src (str "/assets/" (-> social-media :name name) ".svg")}])]])])

(defn menu []
  [:ul.menu
   (for [component-name component-names]
     (if (not= component-name :home)
       [:li {:key component-name}
        [:a (merge {:class component-name}
                   (if (= component-name :buy)
                     {:href "http://tinyengines.limitedrun.com/products/577089-personal-space-ecstatic-burbs-pre-order" :target "blank_"}
                     {:on-click #(reset! current-component component-name)}))
         (clojure.string/upper-case (name component-name))]]))])

(defn component [component-name & body]
  (fn []
    (let [displayed-component-name @current-component
          hidden? (not= component-name displayed-component-name)
          component-base [:div {:class (str (name component-name) " " (if hidden? "hidden"))}]]
      (into component-base body))))


(defonce did-click-page? (r/atom false))

(.addEventListener js/document "click"
                   (fn []
                     (if (not @did-click-page?)
                       (-> (.querySelector js/document "body")
                           (.-classList)
                           (.add "no-back")))))

(defn app []
  [:div.root
   [menu]
   [:div.components
    [component :home [:h1.test "Ecstatic Burbs"] [:h3 "Personal Space"]]
    [component :music
     [:iframe {:src "https://embed.spotify.com/?uri=spotify%3Aalbum%3A0mEY0s1Is12S3wtltSmonS", :width "100%", :height "380", :frameborder "0", :allowtransparency "true"}]
     ]
    [component :shows
     [:a {:href "http://www.bandsintown.com/Personal%20Space", :class "bit-widget-initializer", :data-artist "Personal Space"} "Personal Space Tour Dates"]
     ]
    [component :pix
     [:div
      (for [i (range 1 12)]
        [:img {:src (str "/assets/ps"
                         (let [s (str "00" i)
                               f (subs s (- (count s) 2))]
                           f)
                         ".jpg")
               :key i}])]]
    [component :vidz
     [:iframe {:width "100%", :height "360", :src "https://www.youtube.com/embed/k6XJsi4OChI", :frameborder "none", :allowfullscreen "allowfullscreen" } " "]
     ]
    [component :about
     [:div
      [:p "\"Personal Space released their debut EP, The Early Universe Was Entirely Opaque, in the Spring of 2014. It was a promising glimpse into a band ripe with talent and ideas. But Personal Space would stay relatively quiet in the months to follow as the lineup shifted and a more focused version of the band would begin to take shape. Fast forward to the beginning of 2016, and Personal Space emerged from the studio with a complete, realized vision on their debut full-length. The LP, entitled Ecstatic Burbs, is amazingly accomplished for a debut album. With a mixture of styles and influences, Ecstatic Burbs is polished progressive pop for the indie rock crowd perhaps not seen since the likes of the great The Dismemberment Plan. And much like that band, Personal Space delves into heavy topics with charming abandon. Ecstatic Burbs surveys the saccharine, surreal landscape of early-aughts suburban coming of age, and all the weird contradictions thereof: the impossibility of violence in a world saturated with it; maladaptive responses to burgeoning male identity and sexuality, forged via internet world; over-determined life paths that turn out to have nothing to do with actual desires or reality. Yet, Personal Space infuses all of this with remarkable depth and humor. From the innocence of childhood to the confusion of adolescence and into the chaos of adulthood, the band hopes to find some sanity beyond it all. Ecstatic Burbs is quite simply, a rousing introduction to the masses for Personal Space.\""]
      "- "
      [:a {:href "http://www.tinyengines.net/bands/personal-space"} "TE"]
      ]
     ]
    [component :mail
     [:img {:src "/assets/mail.png"}]]
    ]
   [social]])

(defn ^:export run []
  (r/render [app]
            (js/document.getElementById "app")))

(run)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
