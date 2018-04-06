# How to develop RestApi Using SpringBoot

## Introduction

This repository contains the code samples for RESTFul Webservice developed using Spring Boot 2.0. This tutorial would be helpful for beginners who start with implementing REST Api using Spring Boot.

## Prerequisites

You need to install below software(s) before you begin with. If you have them already installed in your Machine, well and good.

* IDE - Any one from below of your choice:
  * [Eclipse](https://www.eclipse.org/downloads/)
  * [Spring Tool Suite](https://spring.io/tools/sts/all)
  * [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
* JDK / JRE - Preferably [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* HTTP Client to test REST Api (Any one from below of your choice):
  * [Post Man](https://www.getpostman.com/) - It also comes as Chrome extension.
  * [Advanced REST Client](https://install.advancedrestclient.com/#/install) - It also comes as Chrome extension.
* Apach Maven - Install only when you build project outside of your IDE. IDE does come with built in Maven.
* Apache Tomcat Server - You need this server only for Example 1

## Code Samples

### Example 1

#### Jersey - REST Example

To quickly get the glimpse of RESTFul webservice, I chose [Jersey](https://jersey.github.io/) framework to understand the REST controller configuration, HTTP Methods, Path and other stuffs. You will find the example handles the GET and POST request. Make sure you test it with HTTP Client.

### Example 2

#### REST using Spring Boot - Hello World

You will dive into Spring Boot World in this example. A quick simple Hello World application (Greets User) that shows the dependencies and other configuration to make REST application running. Greet yourself by making GET request with your name as Request Param.

##### End points

### Example 3

#### Spring Boot - REST - User Service 1.0

Enough introduction. Let's get into actual work. 

You will learn:

* A simple User service is used in the example to demonstrate the CRUD operation using GET, POST, PUT and DELETE HTTP verbs.
* You will play with static User object to retrieve and store User info. 
* You will also learn about setting HTTP Response Codes (404, 500 ..) in reponse header based on the result of CRUD operation. 

##### XML Model

##### JSON Model

##### End points

### Example 4

#### Spring REST JPA - User Service 2.0

You will learn:

* Spring JPA - Java Persistent Api to play with Database. In memory H2 database is used to store and retrieve User information.
* Custom Response Handler - Handles Error/Exception in the Service in most standard way and produces erro response accordingly,
* Swagger 2.0 - Api documentation is discussed well in this example using Swagger api.

##### XML Model

##### JSON Model

##### End points

### Example 5

#### Hateoas (Hypermedia) Rest Example

You will learn:

* Hateoas implementation using Spring Boot.

##### XML Model

##### JSON Model

##### End points

### Example 6

#### Internationalization (i18n)

You will learn:

* Internationalizing REST Api response using Spring Boot. 
* A simple greeting Service is created that respond with 'Good Morning' message based on the Accept-language set in request header. 
* For now it handles, English, French, Tamil and Hindi locale.

##### End points

http://localhost:9001/i18n/ (Make sure the application is running before your try to access the Endpoint)

###### Request Header

Accept-Language: ta (or) Accept-Language: fr (or) Accept-Language: hi

### Demo Project

#### Employee Rest Api 

A simple REST Api is created for maintaining Employee inforamtion in the System.

You will learn:

* CRUD implementation using HTTP verbs
* Swagger 2.O usage
* Custom response handler implementation - To handle error and exception
* JSON and XML Negotiation

Currently am developing an Angular app that talk to this Api to create, read, update and delete Employee information. Soon will post the repository link here.

Also planning to deploy both Angular and Rest service in AWS so that you can see live demo of it.

Watch the space !

##### XML/JSON Model

https://gist.github.com/smartudhaya/842879f043019e74130b1da33b016845

##### End points

Check Swagger UI for all Endpoints  - http://localhost:8080/swagger-ui.html (Make sure you imported the application and it is up & running before you access Endpoint).

## Deployment

For Example 1: Run / Deploy on Apache Tomcat Server.

For other examples, embedded tomcat server that comes with Spring boot will be used.

If you wish to deploy the service in AWS, please follow this link - [Deploying a Spring Boot Application on AWS Using AWS Elastic Beanstalk](https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/).

## Contributing

Please read [CONTRIBUTING.md](https://github.com/smartudhaya/RestApiUsingSpringBoot/blob/master/CONTRIBUTION.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* [Udhayakumar Govindarajan](https://github.com/smartudhaya)

## License

This project is licensed under the Apache License - see the [LICENSE.md](https://github.com/smartudhaya/RestApiUsingSpringBoot/blob/master/LICENSE) file for details

