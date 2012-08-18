(ns clotwilio.test.sms
  (:use [clotwilio.sms] 
        [clojure.test]))

;; test the message URL building
(deftest test-bld-msg-url []
  (is (= (str SMS_URL "/Messages.json")
         (bld-msg-url :json)))
  (is (= (str SMS_URL "/Messages.Xml")
         (bld-msg-url :xml))))