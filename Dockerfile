FROM tomcat:10
LABEL authors="Nikita Milenin"

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
COPY ./target/Telephones.war /usr/local/tomcat/webapps/Telephones.war

CMD ["catalina.sh", "run"]