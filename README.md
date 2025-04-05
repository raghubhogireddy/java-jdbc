RDBMS vs. NoSQL: While relational databases are excellent for data with inherent relationships and large-scale atomic transactions, NoSQL databases are better suited for distributed systems. Both types have their place depending on the use case.

## JDBC
- JDBC is a way for Java programs to connect to and interact with relational databases (like Postgres, Oracle, MySQL, etc.).
- It allows you to use the same code to work with different databases as long as they follow the standard SQL rules.

### How does it work ?
- **Load the Driver**: Think of this as getting the right tool to connect to the database.
- **Connect to the Database**: Use the tool to open a connection to the database.
- **Execute SQL Commands**: Send commands to the database to get or change data.
- **Handle Transactions**: Group a series of commands to make sure they all succeed or fail together.
- **Close the Connection**: When done, close the connection to free up resources.

**Error Handling**: JDBC uses a standard way to handle errors, so you know what went wrong and can fix it.

### Terminology of JDBC
- **Connection**: This is like a bridge between your Java application and the database. It allows communication between the two.
- **DriverManager**: Think of this as a manager that helps you get the connection to the database.
- **DataSource**: A more advanced way to manage connections, often used in larger applications where the framework handles connections for you.
- **Statement**: The representation SQL to be executed against the database. This is where you write your SQL commands that will be sent to the database.
- **ResultSet**: The data you get back from the database after executing a query, organized in a table-like format.
- **PreparedStatement**: A special kind of statement that allows you to safely include user inputs without risking SQL injection attacks.
- **CallableStatement**: Similar to PreparedStatement but used for calling stored procedures in the database.
- **Auto-commit**: A feature where each SQL command is immediately saved in the database.
- **Transaction**: A group of SQL commands that are executed together. If one command fails, all commands in the transaction are rolled back to ensure data consistency.
- **Rollback**: If something goes wrong in a transaction, rollback undoes all the commands in that transaction, as if they never happened.

### CRUD
- CRUD stands for the four main functions you perform on data in a database:
    - **Create**: Adding new data to the database. This is done using an INSERT statement.
    - **Read**: Retrieving data from the database. This is done using a SELECT statement.
    - **Update**: Modifying existing data in the database. This is done using an UPDATE statement.
    - **Delete**: Removing data from the database. This is done using a DELETE statement.
- **Data Manipulation Language (DML)**: CRUD operations are part of DML, which includes commands to insert, update, select, and delete data.
- **Idempotent Operations**
    - **Create (INSERT): Usually not idempotent because inserting the same data multiple times can lead to duplicates.
    - **Read (SELECT)**: Idempotent because reading data doesn't change it.
    - **Update (UPDATE)**: Idempotent if updating with the same values repeatedly results in the same outcome.
    - **Delete (DELETE)**: Idempotent after the first execution because once data is deleted, it can't be deleted again.
- **Constraints**: Rules that ensure data integrity, like not allowing a foreign key to be inserted before its primary key exists.

### DAO pattern

- **Purpose of DAO Pattern**: Provides an abstraction between JDBC and the rest of your code, ensuring a clear separation of concerns.
- **Use of DTOs**: Data Transfer Objects (DTOs) are used to store state between layers, often combined with DAOs to encapsulate data access logic.
- **Separation and Encapsulation**: DAOs help manage complex joins and aggregations, keeping data access code separate from business logic.
- **Common Practices**: Leveraging a common interface for DAOs and using DAO factories for basic CRUD operations can be beneficial, though customization may be necessary for specific data access methods.
