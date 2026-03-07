FROM maven:3.9-eclipse-temurin-23 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests clean package

FROM tomcat:10.1-jdk21
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]