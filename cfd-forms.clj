(ns lamturb.core)


(defn velocity [v] (* v (Math/pow v -3)))

(defn inertial-force [fluid-density, fluid-velocity, dimension]
  "Density: kg/m**3, Velocity: m/sec, Dimension: m"
  (* fluid-density (velocity fluid-velocity) dimension))

(defn viscous-force [viscosity]
  "slows the flow"
  (float(+ 0 viscosity)))

(defn Reynolds [fluid-density, fluid-velocity, dimension, fluid-viscosity]
  "INERTIAL-FORCE / VISCOUS-FORCE
   Turbulent-Flow (4K~)^Flow moves in random direction
   Transition-Flow (2K-4K)^Flow moves Straight & Random direction
   Laminar-Flow (~2K)^Flow moves in Straight direction" 
  (/ (* fluid-density (velocity fluid-velocity) dimension) fluid-viscosity))

(defn Flow [velocity, radius]
  (* velocity (* Math/PI (Math/pow radius 2) )))

;; https://tbc-python.fossee.in/convert-notebook/Fundamentals_of_Fluid_Mechanics/Ch_8.ipynb
;; Example 8.1 Page 405

(def vis-er #(* % (Math/pow 10 -5)))
(def flows {:laminar 2100
            :turbulent 4000})

(def D
  "Unit: Inches"
  0.73)

(def D-12
  "frequently appearing quotient"
  (/ D 12))

(/ (* 1.94 D) 12)

(def vol
  "Unit: Cubic-foot"
  0.0125)

(def T1
  "Unit: Farenheit"
  50.0)

(def T2
  "Unit: Farenheit"
  140.0)

(def vis1
  ^{:unit "lb*s/ft**2 at 50 degree farenheit"}
  (vis-er 2.73))

(def vis2
  ^{:unit "lb*s/ft**2 at 140 degree farenheit"}
  (vis-er 0.974))

;; (def V1 (/ (* (:laminar flows) vis1) (* 1.94 D-12)))
;; (def t1 (/ vol (* V1 (/ (* Math/PI (Math/pow D-12 2)) 4))))

;; (def V2 (/ (* (:turbulent flows) vis1) (* 1.94 D-12)))
;; (def t2 (/ vol (* V2 (/ (* Math/PI (Math/pow D-12 2)) 4))))

;; (def V3 (/ (* (:laminar flows) vis2) (* 1.94 D-12)))
;; (def t3 (/ vol (* V3 (/ (* Math/PI (Math/pow D-12 2)) 4))))

;; (def V4 (/ (* (:turbulent flows) vis2) (* 1.94 D-12)))
;; (def t4 (/ vol (* V4 (/ (* Math/PI (Math/pow D-12 2)) 4))))

;;2nd Iteration

(def Vfun #(/ (* %1 %2) (* 1.94 D-12)))
(def tfun #(/ vol (* % (/ (* Math/PI (Math/pow D-12 2)) 4))))

(def v1 (Vfun (:laminar flows) vis1))
(def t1 (tfun v1))

(def v2 (Vfun (:turbulent flows) vis1))
(def t2 (tfun v2))

(def v3 (Vfun (:laminar flows) vis2))
(def t3 (tfun v3))

(def v4 (Vfun (:turbulent flows) vis2))
(def t4 (tfun v4))


; unit conversion stuff
(def kilogram
"Ready to use properties of Numbers"
{:unit "kg"
:imperial '(/ x 2.22)
:log '(Math/log)
:reciprocal '(/ 1 x)
:negative '(* x -1)
 })

