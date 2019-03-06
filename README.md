## **Alternative routes service**

Alternative routes service has a database record for the customer service that will route the requests for calls to the customer service 50%
of the time to the existing customer service and 50% of the time to an alternative customer service.

## **Building**

1. To compile source code and build Docker image:
```
mvn clean package docker:build
```

## **Running**

1. To start service in Docker container:
```
docker run marinasavchenko/onlinestore-alternativesrv:v1
```

## **Running the tests**

1.To run tests via Maven:
```
mvn clean test
```

## **Technology stack**

* Java 8
* Spring Boot
* Spring Cloud
* Spring Data

* jUnit
* Mockito

* Maven
* Docker