(defproject clojy "0.0.1"
  :description "From Clojure to Python and back"
  :url "https://bitbucket.org/userzimmermann/clojy"

  :dependencies
  [[org.scala-lang/scala-library "2.11.7"]
   [org.python/jython "2.7.1b1"]
   [org.clojure/clojure "1.7.0"]
   [org.clojure/algo.generic "0.1.2"]]

  :source-paths ["clj"]
  :java-source-paths ["src"]

  :plugins
  [[lein-zinc "1.0.0"]]

  :pom-plugins
  [[org.scala-tools/maven-scala-plugin "2.15.2"
    {:executions [:execution [:goals [:goal "compile"]]]}]])
