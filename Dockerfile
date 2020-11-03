FROM maven:3.6.3-openjdk-16
LABEL author = "Sergey Andruhovich sergeyandr1998@gmail.com"
WORKDIR /app
COPY src /app/src
COPY pom.xml /app/
RUN mvn package
CMD java -jar /app/target/demo-0.0.1-SNAPSHOT.jar