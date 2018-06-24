FROM jboss/keycloak-adapter-wildfly:3.4.3.Final

USER root
RUN yum install maven -y

# copy application source code into container
COPY . .

RUN mvn clean install

ADD target/*.war /opt/jboss/wildfly/standalone/deployments/