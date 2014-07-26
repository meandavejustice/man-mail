(ns man-mail-redux.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route])
  (:use [clojure.java.shell :only [sh]]
        man-mail-redux.views))

(def cmds '("ls" "man" "cat"))

(defn get-manpage [cmd]
  (:out (sh "man" cmd "| man2html -bare")))

(defroutes app-routes
  (GET "/man/:cmd" [cmd]
       (if (some #{cmd} cmds)
         (manpage (get-manpage cmd))
         (str "<h1>Enter a command at /{here} to get a man page</h1>")))
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
