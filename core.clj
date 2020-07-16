(ns lclojure.core
  (:require [clojure.string :as cstr]
            [clojure.java.io :as io]
            [clojure.java.javadoc])
  (:import java.util.Date)
  (:import java.text.SimpleDateFormat)
  (:import java.text.ParseException)
  (:import java.io.File))

(defn velocity [v] (* v (Math/pow v -3)))

(defn inertial-force [fluid-density, fluid-velocity, dimension]
  "Density: kg/m**3, Velocity: m/sec, Dimension: m"
  (* fluid-density (velocity fluid-velocity) dimension))

(defn viscous-force [viscosity]
  "slows the flow"
  (float(+ 0 viscosity)))

(defn Reynolds-tube [fluid-density, fluid-velocity, dimension, fluid-viscosity]
  "INERTIAL-FORCE / VISCOUS-FORCE
   Turbulent-Flow (4K~)^Flow moves in random direction
   Transition-Flow (2K-4K)^Flow moves Straight & Random direction
   Laminar-Flow (~2K)^Flow moves in Straight direction" 
  (/ (* fluid-density (velocity fluid-velocity) dimension) fluid-viscosity))

(defn Flow [velocity, radius]
  (* velocity (* Math/PI (Math/pow radius 2) )))

(defn Continuity-equation [Velocity, Area]
  "degree of the velocity change is to the square of the diameter change...
   velocity of the fluid times the cross-sectional area of the tube it's traveling
   through"
  ())


