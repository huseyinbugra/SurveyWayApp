# SurveyWayApp
SurveyWayApp is a web api that you can create surveys and survey topics. Topic includes name, question and npm. npm will calculate after every survey submission.  Survey includes topic score and feedback which will support topic score.

## Technologies and Tools:

- Maven
- SpringBoot
- JPA Hibernate
- H2 In-memory database
- REST
- Swagger
- JUnit5

## About Project:

-Project can be accessed [github](https://github.com/huseyinbugra/SurveyWayApp)
-H2 database can be accessed [localhost:8080/h2-console](http://localhost:8080/h2-console)(username:sa   pasword: )
-Swagger can be accessed [http://localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)

## Usage:
- Survey and Topic are main endpoints. **"/surveys(/{id})"** , **"/topics(/{id})"** and **"surveys/topics(/{id})"** accept GET, POST, PUT, DELETE operations.