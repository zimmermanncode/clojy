; clojy
;
; From Clojure to Python and back
;
; Copyright (C) 2015 Stefan Zimmermann <zimmermann.code@gmail.com>
;
; clojy is free software: you can redistribute it and/or modify
; it under the terms of the GNU Lesser General Public License as published by
; the Free Software Foundation, either version 3 of the License, or
; (at your option) any later version.
;
; clojy is distributed in the hope that it will be useful,
; but WITHOUT ANY WARRANTY; without even the implied warranty of
; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
; GNU Lesser General Public License for more details.
;
; You should have received a copy of the GNU Lesser General Public License
; along with clojy. If not, see <http://www.gnu.org/licenses/>.

(ns clojy
  (:use clojure.algo.generic.arithmetic)
  (:import (org.clojy package ClojyObject)
           (org.python.core PyObject)))


(defmacro defpython [name]
  `(let [py# (new org.python.util.PythonInterpreter)]

     (defmacro ~name [code# & args#]
       (let [obj# (package/py2clj (.eval py# (str code#)))]
         (if args# (apply obj# args#) obj#)))

     (defn ~(symbol (str name "-eval")) [code#]
       (.eval py# code#))

     (defn ~(symbol (str name "-exec")) [code#]
       (.exec py# code#))

     (defmacro ~(symbol (str name "-import")) [module#]
       (.exec py# (str "import " module#)))

     ;; (defmacro ~(symbol (str name "-import->fn")) [fname# module#]
     ;;   (let [module# (str module#)]
     ;;        (.exec py# (str "import " module#))
     ;;        (let [obj# (.get py# module#)]

     ;;             (defn fname# [more#]
     ;;               obj#))))
     ;;               ;; (.__call__ obj# more#)))))
     py#))


(defmethod + [ClojyObject ClojyObject] [x y]
  (.add x y))

(defmethod + [ClojyObject Object] [x y]
  (.add x y))

(defmethod + [Object ClojyObject] [x y]
  (.radd y x))


(defmethod + [PyObject PyObject] [x y]
  (package/py2clj (._add x y)))

(defmethod + [PyObject Object] [x y]
  (package/py2clj (._add x (package/clj2py y))))

(defmethod + [Object PyObject] [x y]
  (package/py2clj (._add (package/clj2py x) y)))


(defmethod - [ClojyObject ClojyObject] [x y]
  (.sub x y))

(defmethod - [ClojyObject Object] [x y]
  (.sub x y))

(defmethod - [Object ClojyObject] [x y]
  (.rsub y x))


(defmethod - [PyObject PyObject] [x y]
  (package/py2clj (._sub x y)))

(defmethod - [PyObject Object] [x y]
  (package/py2clj (._sub x (package/clj2py y))))

(defmethod - [Object PyObject] [x y]
  (package/py2clj (._sub (package/clj2py x) y)))


(defmethod * [ClojyObject ClojyObject] [x y]
  (.mul x y))

(defmethod * [ClojyObject Object] [x y]
  (.mul x y))

(defmethod * [Object ClojyObject] [x y]
  (.rmul y x))


(defmethod * [PyObject PyObject] [x y]
  (package/py2clj (._mul x y)))

(defmethod * [PyObject Object] [x y]
  (package/py2clj (._mul x (package/clj2py y))))

(defmethod * [Object PyObject] [x y]
  (package/py2clj (._mul (package/clj2py x) y)))


(defmethod / [ClojyObject ClojyObject] [x y]
  (.div x y))

(defmethod / [ClojyObject Object] [x y]
  (.div x y))

(defmethod / [Object ClojyObject] [x y]
  (.rdiv y x))


(defmethod / [PyObject PyObject] [x y]
  (package/py2clj (._div x y)))

(defmethod / [PyObject Object] [x y]
  (package/py2clj (._div x (package/clj2py y))))

(defmethod / [Object PyObject] [x y]
  (package/py2clj (._div (package/clj2py x) y)))


;(python bla)

;(bla-eval "2")
