# NBA Predict API

API server for this [nba predict UI](https://github.com/Step-henC/nba-predict-ui). Receives player career data and performs linear regression to predict an NBA player's next season. All players must be associated with an user. 

# How To Run

Make sure you have maven installed and Java 17. Git clone and in root directory of this app run `mvn clean install -U`

Then, run `mvn spring-boot-run`.

A user will be created with name `test` and password `test` on start up. This user will have one mock record.

For Swagger UI, go to browser and enter `http://localhost:8080/swagger-ui.html`

For H2 console, go to browser and enter `http://localhost:8080/h2-console`. User is `sa` and password is `password`. 


## No Maven, No Problem
  Running locally with Docker

  run `docker build -t yourtag/here .`
  then executed `docker run -p 8080:8080 yourtag/here`

# Future Directions
Dockerize. Unit test. Error handle -> check for duplicate user names. Hash and salt user passwords. Use a DB not in-mem. Include JWTs and ramp up security.