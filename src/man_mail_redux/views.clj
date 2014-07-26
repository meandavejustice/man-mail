(ns man-mail-redux.views)

;; holy shit I need a templating library

(defn head []
  (str "<head><link rel='stylesheet' type='text/css' href='/css/index.css'/></head>"))

(defn index []
  (str "<html>"
       (head) "<body>Welcome</body><html>"))

(defn manpage [manual]
  (str "<html>"
       (head) "<body><pre>"manual"</pre></body><html>"))
