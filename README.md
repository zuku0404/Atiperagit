# Atiperagit

This application provides an API to list all GitHub repositories of a user that are not forks. 
For each repository, it returns the repository name, owner login, and details of each branch,
including the branch name and last commit SHA.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/zuku0404/Atiperagit.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Atiperagit
    ```
3. Build the project using Maven or Gradle:
    ```bash
     ./gradlew build
    ```
4. Run the application:
    ```bash
     ./gradlew bootRun
    ```

## API Endpoints

### Get Repositories for a User

- **URL:** `/repositories/{username}`
- **Method:** `GET`
- **Headers:**
    - `Accept: application/json`
- **Response:**
    - `200 OK` with the list of repositories (name, owner, branches, and last commit SHA).
      * Example:
        ```json
          [
              {
                  "repositoryInfo": {
                      "name": "myRepo",
                      "owner": {
                          "login": "zuku0404"
                      }
                  },
                  "branchInfo": [
                      {
                          "name": "main",
                          "commit": {
                              "sha": "7638417db6d59f3c431d3e1f261cc637155684cd"
                          }
                      }
                  ]
              }
          ]
          ```
    - `404 Not Found` if the user does not exist.
      * Example:
        ```json
        {
         "status": 404,
         "message": "given github user not existing"
        }
        ```
## Usage

Once the application is running, you can access the API at:
http://localhost:8080/repositories/{username}

Replace `{username}` with the GitHub username for which you want to retrieve repository information.

Example request:
http://localhost:8080/repositories/zuku0404

## Built With

- **[Java 21](https://openjdk.org/projects/jdk/21/)** - The programming language.
- **[Spring Boot 3](https://spring.io/projects/spring-boot)** - A framework to development of Java applications.
- **[Gradle](https://gradle.org/)** - Dependency Management
- **[RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)** - A Spring utility class for making HTTP requests to external APIs.
- **[Jackson](https://github.com/FasterXML/jackson)** - A library used for converting Java objects to JSON and vice versa.
- **[GitHub API](https://docs.github.com/en/rest)** - The API used to fetch repository information.
- **[Lombok](https://projectlombok.org/)** - A library that helps to reduce boilerplate code by providing annotations to auto-generate getters, setters, constructors, etc.

## Authors
* Mateusz Żuk - Initial work

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
 