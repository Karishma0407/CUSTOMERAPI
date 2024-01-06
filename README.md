# Customer API

Welcome to the Customer API project! This Spring Boot application provides a simple API for managing customer information, including addresses, cities, and countries.

## Project Structure

The project is organized into separate entities, repositories, services, and controllers to ensure a clean and modular design.

## Entities

- Customer:
Represents a customer with a unique identifier (id), first name, last name, email, and a list of addresses associated with the customer.

- City:
Represents a city with a unique identifier (id), a name, and a many-to-one relationship with a Country.

- Country:
Represents a country with a unique identifier (id) and a name.

- Address:
Represents an address with a unique identifier (id), a street, a many-to-one relationship with a City, and a postal code (postCode).

## Repository

The repository layer manages the interaction with the database for each entity. It includes CRUD operations and any specific queries needed for data retrieval.

## Services

The service layer contains business logic and acts as an intermediary between the controllers and repositories. It ensures separation of concerns and maintainability.

## Controllers

Controllers handle incoming HTTP requests, interact with the service layer, and return appropriate responses. They are responsible for the API endpoints and data validation.

## Library Separation

In this project, we've chosen to create separate libraries for the address and customer entities. This approach provides the following benefits:

- Modularity:
Each library can be developed and tested independently, making it easier to understand and maintain.

- Reusability:
If you have other projects that require similar functionality, you can reuse these libraries without duplicating code.

- Encapsulation:
Libraries encapsulate related functionality, promoting a cleaner and more organized codebase.

- Scalability:
As the project grows, separating concerns into libraries allows for easier scaling and maintenance.
