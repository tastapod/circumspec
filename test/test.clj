(ns test
  (:use circumspec 
        clojure.contrib.str-utils))

(defn test-files
  "Please make this helper part of some core lib somewhere..."
  []
  (filter
   #(re-find #"_test.clj$" %) 
   (map
    #(.getName %)
    (file-seq (java.io.File. "test")))))

(defn run-tests! []
  (reset! circumspec/registered-descriptions [])
  (reset! circumspec/assertions 0)
  (let [names (map #(re-sub #".clj" "" %) (test-files))]
    (doseq [f names]
      (load f))
    (run-tests)))
