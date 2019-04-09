## **Alternative routes service**

Alternative routes service has a database record for the customer service that will route the requests for calls to
different versions of customer service.

## **Technology stack**

* Java 8
* Spring Boot 2
* Spring Cloud 2
* Spring Data 2

* jUnit 4
* Mockito

* Maven
* Docker

## **Building**

To compile source code and build Docker image:
```
mvn clean package docker:build
```

## **Running**

To start service in Docker container:
```
docker run marinasavchenko/onlinestore-alternativesrv:v1
```

## **Running the tests**

To run tests via Maven:
```
mvn clean test
```