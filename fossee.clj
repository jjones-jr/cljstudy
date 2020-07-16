;; ;; T1=50.0             #degree farenheit
;; D=0.73              #in
;; vol=0.0125        #ft**3
;; T2=140              #degree farenheit

;; vis1=2.73*10**-5                          #lb*s/ft**2 at 50 degree farenheit
;; vis2=0.974*10**-5                        #lb*s/ft**2 at 140 degree farenheit

;; #calculation
;; import math
;; #for 50 degree farenheit
;; #if flow is laminar, maximum Re=2100 Re=d*V*D/vis
;; V1=2100*vis1/(1.94*D/12)
;; t1=vol/(math.pi*((D/12)**2)/4*V1)
;; #if flow is turbulent, minimum Re=4000
;; V2=4000*vis1/(1.94*D/12)
;; t2=vol/(math.pi*((D/12)**2)/4*V2)

;; #for 140 degree farenheit
;; #if flow is laminar, maximum Re=2100 Re=d*V*D/vis
;; V3=2100*vis2/(1.94*D/12)
;; t3=vol/(math.pi*((D/12)**2)/4*V3)
;; #if flow is turbulent, minimum Re=4000
;; V4=4000*vis2/(1.94*D/12)
;; t4=vol/(math.pi*((D/12)**2)/4*V4)

;; #result
;; print("For laminar flow")
;; print "The time taken to fill the glass at 50 degree F=",round(t1,2),"seconds"
;; print "The time taken to fill the glass 100 degree F=",round(t3,2),"seconds"
;; print ("For turbulent flow:")
;; print "The time taken to fill the glass at 50 degree F=",round(t2,2),"seconds"
;; print "The time taken to fill the glass at 140 degree F=",round(t4,2),"seconds")
