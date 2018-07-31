# rebrickable API implementation

### This repo is built as part of a project of a coding bootcamp (CodingNomads)

## Description
This project demonstrates how to implement the rebrickable API (a LEGO library/database) so that LEGO fans can easily use make calls to create LEGO lists or search for existing LEGO parts and sets. Useful for any fan who needs to keep track of needed parts for an MOC, or who wants to create a curated lists of LEGO sets. Users of this repo can also connect this to their SQL database to add LEGO parts.

## Getting Started

This repo requires a [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  to be
installed on the machine you are going to use to run the program.


Required:
* [JDK 8](ttp://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](http://maven.apache.org/download.cgi)

## Functionality
#### SQL Connection
* As stated in the description, this repo allows users to create a table called PartsResults to add LEGO parts to the database or perpetuate these parts from rebrickable.
* Users of this repo can also add a table LEGO sets or LEGO themes to their database (SetsResults/ThemesResults)
* Users are advised to create these empty tables with the appropriate names beforehand. The column names and descriptions are found in the [mappers](https://github.com/pomlego/rebrickableAPI/tree/master/src/main/java/rebrickable/mappers) folder.

#### API Security
Users of this repo also have the option of having this project only accessible when authenticated through a users' API Key. For this, you must create a User schema and users table in your local database and add this (or remove the //) to your controllers

```
@Annotation
    public ReturnType MethodName(
            @RequestParam("api-key") String apikey) throws InvalidAPIKeyException {

        if (securityService.authenticate(apikey)) {
            // whatever method
            
        } else {
            throw new InvalidAPIKeyException("Your API key is invalid");
            }
    }
```
#### RDS/EC2
This repo can also be deployed to AWS.
* Add your RDS connection to the [application.properties](https://github.com/pomlego/rebrickableAPI/blob/master/src/main/resources/application.properties) under spring.datasource
* Add to your class ```extends SpringBootServletInitializer``` and this method:
```
@Override
protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
```
* Add this dependency to your [pom.xml](https://github.com/pomlego/rebrickableAPI/blob/master/pom.xml) file:
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
```

#### Caching
Still a work in progress

#### Exception Handling
Still a work in progress
