# gwt-email-app

This app is able to send an email using Google Mail API.

**PREREQUISITES:**
- Java 8 or higher
- GWT Plugin to your IDE of choice

Before using please check if your email address is going to work with Google Mail API.

https://cloud.google.com/appengine/docs/standard/java/mail/#who_can_send_mail

Please override your email address and password in lines 19-20 located in the file below:

  /src/com/ncdc/emailApp/server/ServiceImpl.java
  
After running the app should show two UIs. The second one is using UI Binder. Besides that fact they work in the same way.
