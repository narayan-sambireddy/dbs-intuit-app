rm -Rf ../tomcat/webapps/dbs* && mvn clean install -DskipTests && cp target/dbs-intuit-app.war ../tomcat/webapps/
