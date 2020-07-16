(ns lclojure.core 
  (:require [libpython-clj.require :refer [require-python]]
            [libpython-clj.python :as py :refer [py. py.. py.-]]
           ))

(py/initialize!)

(require '[datascript.core :as d])

(require-python '[seaborn :as sns])
(require-python '[matplotlib.pyplot :as pyplot])
(require-python '[pandas :as pd])
(require-python '[numpy :as np])

;https://tbc-python.fossee.in/convert-notebook/Fundamentals_of_Fluid_Mechanics



(def T(np/array [60 80 100 120 140 160]))
(def d(np/array [2.07 2.06 2.05 2.04 2.03 2.02]))
(def vis(np/array [0.04 0.019 0.0038 0.00044 0.000092 0.000023]))
(def Q 0.5)
(def T1 100.0)
(def l 6.0)
(def D 3.0)
(def pdiff(/ (* 128 l Q (second vis)) (Math/pow (* Math/PI (/ D 12)) 4)))
(def V (/ Q (* Math/PI (/ (Math/pow(/ D 12) 2) 4))))

 (def example01 {:T (np/array [60 80 100 120 140 160])
 :d (np/array [2.07 2.06 2.05 2.04 2.03 2.02])
 :vis (np/array [0.04 0.019 0.0038 0.00044 0.000092 0.000023])
 :Q 0.5
 :T1 100.0
 :l 6.0
 :D 3.0
 :pdiff (/  (* 128 l Q (second vis)) (Math/pow (* Math/PI (/ D 12)) 4))
 :V (/ Q (* Math/PI (/ (Math/pow(/ D 12) 2) 4)))}
)

(def schema {:car/model {:db/unique :db.unique/identity}
             :car/maker {:db/type :db.type/ref}
             :car/colors {:db/cardinality :db.cardinality/many}
             })

(def conn (d/create-conn schema))

(d/transact! conn [{:maker/email "ceo@bmw.com"
                    :maker/name "BMW"}
                   {:car/model "E38393"
                    :car/maker [:maker/email "ceo@bmw.com"]
                    :car/name "2003 530i"}])


