FROM jboss/keycloak-adapter-wildfly:3.4.3.Final

USER root
RUN yum install maven -y

WORKDIR /tmp

# copy application source code into container
COPY . .

#RUN mvn clean verify

#RUN cp target/*.war /opt/jboss/wildfly/standalone/deployments/
ADD target/*.war /opt/jboss/wildfly/standalone/deployments/