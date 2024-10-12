# Device Store CRUD

This Java application, built with **Spring Boot**, provides a complete 
**CRUD (Create, Read, Update, Delete)** system for managing a device store. 
It includes functionality for handling various elements of the business, 
with operations accessible via GraphQL queries and mutations.

## Features

The application supports CRUD operations for the following entities:

1. Appliance Types
2. Components
3. Componentes change
4. Customers
5. Details Components
6. Electronic Devices
7. Factories
8. Repairs

## database

The application uses a MySQL database to store all data related to the store’s operations. To set up the database:

1. Execute the [Database Script](script.sql) to create the necessary tables and schema.
2. A [Second script](data-db.sql) is available to seed the database with 10 sample records for each table, providing initial test data.

## GraphQL API

CRUD operations are executed through GraphQL, offering flexible data retrieval and manipulation through:

 - **Queries:** To fetch data from the database.
 - **Mutations:** To perform create, update, and delete operations.

## Getting Started

1. Clone the repository.
2. Set up the MySQL database by running the provided SQL scripts.
3. Configure the database connection in the application.properties file.
