
# Inditex Test

------

![](https://img.shields.io/badge/Lenguaje-java-blue.svg?style=for-the-badge)![](https://img.shields.io/badge/version-v0.0.1-success.svg?style=for-the-badge)

------
## Introduction

InditexTest is a service developed in Java which manages prices and feeds of products for several shops.


## Technologies
- Java 17
- Spring Boot 3.1.5
- Spring Data JPA 3.1.5
- Springdoc Openapi 2.0.2
- H2 2.1.214
- Lombok 1.18.30
- Mapstruct 1.5.5.Final

## Architecture
- Hexagonal architecture

## Design Patterns
- Repository Pattern

## Launch

To run this project manually, execute:
```
$ cd ./inditex-test
$ mvn package
$ java -jar target/inditex-test-0.0.1-SNAPSHOT.jar
```

To run this project with docker, execute:
```
$ cd ./inditex-test
$ mvn package
$ docker run -d --name inditexTest  -p 8080:8080 gft/inditex-test:latest
```

See swagger UI in the following address [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Exposing services

#### **GET** **/price**
Obtain the final price and the price list to be applied for a brand product

##### Example of request
```
curl -X 'GET' \
  'http://localhost:8080/price?brandId=1&productId=35455&date=2020-06-24T19%3A19%3A57' \
  -H 'accept: */*'
```
##### Example of response
```
{
  "brandId": 1,
  "productId": 35455,
  "priceList": 4,
  "startDate": "2020-06-15T16:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 38.95
}
```

## Funcional Tests

To execute functional tests:
1. Launch application.
2. Open [Postman](https://www.postman.com/) and import the Postman collection file [Inditex Test API.postman_collection.json](Inditex%20Test%20API.postman_collection.json).
3. Select **Inditex Test API** collection and click Run option.

