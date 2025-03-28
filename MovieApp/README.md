## Sample Database Application

This is a command line Java application that demonstrates the use of a relational database. 

## Folder Structure

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `bin`: the compiled output files, e.g., the class files go here

## JDBC Driver

The application assumes that you are using MariaDB. You can download the MariaDB JDBC driver
from [its website](https://mariadb.com/downloads/connectors/connectors-data-access/), e.g.,
on the top level of the directory, run

```bash
wget https://dlm.mariadb.com/4234102/Connectors/java/connector-java-3.5.3/mariadb-java-client-3.5.3.jar -O lib/mariadb-java-client-3.5.3.jar
```
## Run the Application

First, you should create a `db.properties` file using the `db_template.properpties` file as
a template. Replace `HOST_IP_ADDRESS`, `DB_USER`, `DB_PASSWORD`, and `DB_NAME` with actual
IP address, database username, database user password, and database name.

To run the application on the Windows system, on the top level of the directory:

```bash
java -D"db.config.file=db.properties" -cp "bin;lib/mariadb-java-client-3.5.3.jar" MovieApp
```

To run the application on a Unix/Unix-like system, e.g., Linux or OS X:

```bash
java -Ddb.config.file=db.properties -cp bin:lib/mariadb-java-client-3.5.3.jar MovieApp
```


