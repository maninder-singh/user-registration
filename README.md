# User Registration App using Ember.js

Step to run application 

1. run export-user_registration.sql file to any dataabse.
2. open src/main/resources/config.properties file and change fields accordingly.
2. Open terminal / command prompt.
2. Go to root folder of application.
3. mvn install -Dmaven.test.skip=true
4. mvn package -Dmaven.test.skip=true
5. mvn clean package
5. copy target/user-registration folder to {application-server}/webapps/
6. copy target/user-registration.war file to {application-server}/webapps/
7. open browser and go to url - http://{domain}/user-registration/index.html.
