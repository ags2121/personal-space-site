(defproject personal-space-site "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.6.1"

  :dependencies [[org.clojure/clojure "1.9.0-alpha7"]
                 [org.clojure/clojurescript "1.9.89"]
                 [org.clojure/core.async "0.2.374"
                  :exclusions [org.clojure/tools.reader]]
                 [reagent "0.6.0-rc"]
                 [overtone/at-at "1.2.0"]
                 [http-kit "2.1.18"]
                 [ring "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [bk/ring-gzip "0.1.1"]
                 [ring.middleware.logger "0.5.0"]
                 [compojure "1.4.0"]
                 [environ "1.0.2"]
                 [clj-tagsoup "0.3.0" :exclusions [org.clojure/clojure]]]

  :plugins [[lein-figwheel "0.5.4-3"]
            [lein-cljsbuild "1.1.3" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src/clj" "src/cljs" "dev"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :uberjar-name "personal-space-site.jar"

  :cljsbuild {:builds
              {:app
               {:source-paths ["src/cljs"]

                     ;; the presence of a :figwheel configuration here
                     ;; will cause figwheel to inject the figwheel client
                     ;; into your build
                     :figwheel     {:on-jsload "personal-space-site.core/on-js-reload"
                                    ;; :open-urls will pop open your application
                                    ;; in the default browser once Figwheel has
                                    ;; started and complied your application.
                                    ;; Comment this out once it no longer serves you.
                                    :open-urls ["http://localhost:3449/index.html"]}

                     :compiler     {:main                 personal-space-site.core
                                    :asset-path           "js/compiled/out"
                                    :output-to            "resources/public/js/compiled/personal_space_site.js"
                                    :output-dir           "resources/public/js/compiled/out"
                                    :source-map-timestamp true}}
               :min
                    {:source-paths ["src"]
                     :compiler     {:output-to     "resources/public/js/compiled/personal_space_site.js"
                                    :main          personal-space-site.core
                                    :optimizations :advanced
                                    :pretty-print  false}}}
              }

  :figwheel {;; :http-server-root "public" ;; default and assumes "resources"
             ;; :server-port 3449 ;; default
             ;; :server-ip "127.0.0.1"

             :css-dirs ["resources/public/css"]             ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process
             ;; :nrepl-port 7888

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server, this is for simple ring servers, if this
             ;; doesn't work for you just run your own server :) (see lien-ring)

             ;; :ring-handler hello_world.server/handler

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             ;; if you are using emacsclient you can just use
             ;; :open-file-command "emacsclient"

             ;; if you want to disable the REPL
             ;; :repl false

             ;; to configure a different figwheel logfile path
             ;; :server-logfile "tmp/logs/figwheel-logfile.log"
             }


  ;; setting up nREPL for Figwheel and ClojureScript dev
  ;; Please see:
  ;; https://github.com/bhauman/lein-figwheel/wiki/Using-the-Figwheel-REPL-within-NRepl


  :profiles {:dev     {:dependencies [[figwheel-sidecar "0.5.4-3"]
                                      [com.cemerick/piggieback "0.2.1"]]
                       ;; need to add dev source path here to get user.clj loaded
                       :source-paths ["src/cljs" "test/cljs" "dev"]
                       ;; for CIDER
                       ;; :plugins [[cider/cider-nrepl "0.12.0"]]
                       :repl-options {; for nREPL dev you really need to limit output
                                      :init             (set! *print-length* 50)
                                      :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}

             :uberjar {:source-paths ^:replace ["src/clj"]
                       :hooks        [leiningen.cljsbuild]
                       :omit-source  true
                       :aot          :all
                       :main         personal-space-site.server
                       :cljsbuild    {:builds
                                      {:app
                                       {:source-paths ^:replace ["src/cljs"]
                                        :compiler
                                                      {:optimizations :advanced
                                                       :pretty-print  false}}}}}}

  )
