# Resource-Server

Spring boot RESTful services for providing banking system with needed rest resources.
In this show case you'll see the following in action:

* The simplest possible @Controller
* Mapping Requests
* Obtaining Request Data
* Generating Responses
* Exception Handling
* JPA Repository
* jUnit

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


To get the code:
-------------------

Clone the repository:

    $ git clone git@github.com:accentation/resource-server.git

If this is your first time using Github, review http://help.github.com to learn the basics.

## Prerequisites

What things you need to install the software and how to install them
* Eclipse Spring tools
* Maven
* JDK 1.8

### Installing

A step by step series of examples that tell you have to get a development env running

```
mvn clean install
```

## Running the tests

Explain how to run the automated tests for this system

```
mvn clean test
```

## Deployment

Add additional notes about how to deploy this on a live system

```
mvn spring-boot:run
```

## Implementation -- Good Practises
* All dates are stored in GMT, and the resource server MUST only manage dates in UTC over input and output operations.
* API REST must be accomplished with HATEOAS
* Source must be written in english and must contain comments and javadoc.

## Authors

See also the list of [contributors](https://github.com/orgs/accentation/people) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

