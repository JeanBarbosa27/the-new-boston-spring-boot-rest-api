# The New Boston API
This project was created following the series
[Spring Boot with Kotlin & JUnit 5](https://www.youtube.com/playlist?list=PL6gx4Cwl9DGDPsneZWaOFg0H2wsundyGr) on YouTube,
from [thenewboston channel](https://www.youtube.com/@thenewboston), in order to study Spring Boot with Kotlin. Besides 
of following the tutorial as it is, I'm going to implement some own ideas as:
- [ ] Health Check route;
- [x] Simple API documentation, without making usage of any library (using pure HTML and CSS, just to keep it easy);
- [ ] Evolve the documentation with Swagger and change the current one for a simple presentation linking to Swagger;
- [ ] Integration with real database (once in the tutorial it's only used mocked data).

And that is it for now I want to keep it simple, but if I have more ideas I'll improve.

Basically the tutorial created a CRUD api using data mocked in runtime memory, I think to keep things simple. At the end
of it, was implemented another data source, to retrieve date from the network, connecting with the real The New Boston
api, but I won't implement it here because to really complete it may have an account otherwise I can only retrieve data,
and it's not my goal. Maybe in future I can implement someway to retrieve data from network for something, just to have
this example in the project.

## Technologies used
- Kotlin
- Spring Boot (project generated in [https://start.spring.io/](https://start.spring.io/))
- Gradle

## Run and test locally
I ran and test the project locally using IntelliJ IDEA, but you can use gradle tasks with the commands bellow. Consider
`gradlew` for Windows and `./gradlew` for Unix based machines in front of each of the commands:

- build: Assembles and tests this project
- bootRun: Runs this project as a Spring Boot application
- test: Runs the test suite

You can also run `./gradlew tasks` to see the list of other tasks available.
