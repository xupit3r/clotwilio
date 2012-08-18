(ns clotwilio.core)

;; base URL for twilio requests
(def TWILIO_API_BASE_URL "https://api.twilio.com")

;; API version
(def TWILIO_API_VERSION "2010-04-01")

;; Account SID (you will need to enter this)
(def TWILIO_ACCOUNT_SID "<REPLACE-ME>")

;; Account authorization token
(def TWILIO_ACCOUNT_AUTH_TOKEN "<REPLACE-ME>")

;; Accounts Location
(def TWILIO_ACCOUNTS_LOCATION "Accounts")

;; Accounts endpoint URL
(def ACCOUNTS_URL
  (str TWILIO_API_BASE_URL "/"
       TWILIO_API_VERSION "/"
       TWILIO_ACCOUNTS_LOCATION "/"
       TWILIO_ACCOUNT_SID))

;; Response types
(def RESPONSE_TYPES 
  {:json "json"
   :xml "Xml"})

;; authorization pair for HTTP calls
(def AUTH_PAIR [TWILIO_ACCOUNT_SID
                TWILIO_ACCOUNT_AUTH_TOKEN])
