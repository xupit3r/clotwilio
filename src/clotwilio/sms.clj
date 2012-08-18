(ns clotwilio.sms
  (:require [clotwilio.core :as core] 
            [clj-http.client :as client])
  (:use [clojure.data.json :only (read-json)]))

;; SMS Location
(def TWILIO_SMS_LOCATION "SMS")

;; Messages Location
(def TWILIO_MESSAGES_LOCATION "Messages")

;; Short Codes Location
(def TWILIO_SHORT_CODES_LOCATION "ShortCodes")

;; SMS URL
(def SMS_URL 
  (str core/ACCOUNTS_URL "/"
       TWILIO_SMS_LOCATION))

;;;; sending messages ;;;;;

(defn bld-msg-url [resp-type]
  (str SMS_URL "/"
       TWILIO_MESSAGES_LOCATION
       "." (resp-type core/RESPONSE_TYPES)))

;; sends an SMS message
;; expects a map of parameters
;; and a response type key
(defn send-msg [params]
  (read-json
    (:body
      (client/post
        (bld-msg-url :json)
        {:form-params params
         :basic-auth core/AUTH_PAIR}
        {:as :json}))))


;;;; short codes ;;;;

(defn bld-scodes-url 
  ([resp-type] 
    (bld-scodes-url false resp-type))
  ([scode resp-type]
    (str SMS_URL "/"
         TWILIO_SHORT_CODES_LOCATION "/"
         (when scode (str scode "/"))
         "." (resp-type core/RESPONSE_TYPES))))

;; retrieve information on a short code
(defn get-scode-info [scode]
  (read-json
    (:body
      (client/get
        (bld-scodes-url scode :json)
        {:basic-auth core/AUTH_PAIR}
        {:as :json}))))

;; retrieve information on all short 
;; codes associated with this accound
(defn get-scodes [scode]
  (read-json
    (:body
      (client/get
        (bld-scodes-url :json)
        {:basic-auth core/AUTH_PAIR}
        {:as :json}))))