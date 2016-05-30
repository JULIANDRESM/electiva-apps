from urllib2 import *
import urllib
import json
import sys

MY_API_KEY="AIzaSyAKlJak7xLKdtxOsZZGv2qQZCie3spmsho"

messageTitle = sys.argv[1]
messageBody = sys.argv[2]

data={
    "to" : "/topics/my_little_topic",
    "notification" : {
        "body" : messageBody,
        "title" : messageTitle,
        "icon" : "ic_notify"
    }
}

dataAsJSON = json.dumps(data)

request = Request(
    "https://gcm-http.googleapis.com/gcm/send",
    dataAsJSON,
    { "Authorization" : "key="+MY_API_KEY,
      "Content-type" : "application/json"
    }
)

print urlopen(request).read()