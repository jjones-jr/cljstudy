(ns lclojure.core
(:require [libpython-clj.require :refer [require-python]]
          [libpython-clj.python :as py :refer [py. py.. py.-]]
          [clojure.java.shell :as sh]))

(def mplt (py/import-module "matplotlib" ))
(py. mplt "use" "Agg")

(require-python 'matplotlib.pyplot)
(require-python 'matplotlib.backends.backend_agg)
(require-python 'numpy)
(require-python 'pandas)


(def DF (py/pandas.DataFrame)
