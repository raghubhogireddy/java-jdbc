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



