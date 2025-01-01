Spring Boot MapStruct Project

This project is a Spring Boot application using MapStruct for mapping entities to DTOs. It also includes an H2 database with default data and unit tests to ensure the service layer operates correctly.

## Setup Instructions

### Running the Application

1. **Download the project**:
   - Clone or download the repository from GitHub.
   
2. **Run the application locally**:
   - Open the project in your favorite IDE.
   - Run the application directly from the IDE or by executing:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Using Docker**:
   - Open the project and navigate to its root directory.
   - To run the app using Docker, use the following commands:
     - To run and view logs:
       ```bash
       docker-compose up
       ```
     - To run in the background:
       ```bash
       docker-compose up -d
       ```
     - To stop the container:
       ```bash
       docker-compose down
       ```

   - This setup uses the `Dockerfile` to fetch the image and deploy the app.

## API List

- **Get Countries by Name**:
  - URL: `GET http://localhost:8080/api/countries/search?name=us`
  - Description: Retrieves country details matching the given name.
  - Response: Returns a DTO with a `200 OK` status code.

## Database Details

- The application uses an embedded H2 database.
- Default data is preloaded into two tables: `Country` and `Company`.
- Example data for testing is included in the `data.sql` file.

### Default Data:
- **Country Table**:
  - ID: `1`, ISO Code: `US`
  - ID: `2`, ISO Code: `IN`

- **Company Table**:
  - ID: `1`, Name: `Google`, Country ID: `1`
  - ID: `2`, Name: `Infosys`, Country ID: `2`

## Test Coverage

- Unit tests cover all service methods, including:
  - Fetching all records from the database.
  - Validating data is not null or empty.
  - Converting entities to DTOs.
  - Returning data to the controller.

## Example Logs

You can view logs by running the application in Docker:
```bash
docker-compose up
```
Or view logs in detached mode using:
```bash
docker-compose logs
```

To stop the application, run:
```bash
docker-compose down
```

