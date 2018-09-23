# Train coding exercise

Coding exercise, implementing solutions to various train problems. Please see the provided .doc for full specifications. 

Developed and tested using Java 8. Solution consists of a standard Maven project, using Spring Boot and MongoDB for the database exercise and JUnit for unit tests.

## Notes:
- Solutions focus on good input from the user.
- Each solution is in its own package: exerciseone, exercisetwo, exercisethree.
- The main methods to run for each solutions are: TrainDetailsEx1, TrainDetailsEx2, TrainDetailsEx3.
- To run the solution for Exercise 3, please ensure MongoDB is installed: https://docs.mongodb.com/manual/installation/
- Once installed, start a server using the `mongod` command in a console window.

To test via console (from project's root directory):

`mvn test`

To run via console (from project's root directory):

`mvn clean install`

`java -jar target/trainexercises-1.0-SNAPSHOT.jar`

Please note the default jar deployed is TrainDetailsEx1. To change which .jar is built, simply change the `<mainClass>` property in the pom.xml to the appropriate main class.

### Extra note:

For exercise 2, user input to produce example is as follows:

Waterloo,Surbiton,Esher,Hersham,Walton-on-Thames,Woking

0,400,500,650,450,200

450,0,235,350,250,250

250,350,0,200,340,150

150,230,220,0,310,350

230,150,320,225,0,320

250,340,95,245,230,0