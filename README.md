# Coding Challenge - Users Hierarchy

## Pre-requisites

This project requires [maven](https://maven.apache.org/) 
and [Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).

## How to execute the project

Clone the git project  
Open a terminal in the project directory  
And run the following commands

for *main:* `mvn clean install exec:java -DskipTests`  

for *tests:* `mvn test`

## Implementation choices

Usage of [Java 8](https://en.wikipedia.org/wiki/Java_version_history#Java_SE_8)

Usage of [Apache Maven](https://en.wikipedia.org/wiki/Apache_Maven) to manage libraries.

Usage of [Gson](https://en.wikipedia.org/wiki/Gson) to deserialize the resources (list of roles and users) 
stored as json files in the project's resource folder.

Usage of [JUnit 5](https://junit.org/junit5/) for unit testing.

Usage of recursion to find subordinate-role-ids from the list of roles.

No use of logging, just standard console output.
