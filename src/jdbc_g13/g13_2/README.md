# Requerements:

The database contains information about the home video library: **films, actors, directors.**

For **movies**, you must store:
 - name;
 - names of actors;
 - release date;
 - the country in which the film was released.

For **actors** and **directors** it is necessary to keep: 
 - name;
 - date of birth.

### Features:
- [x] 1 Find all movies released on the screen this year and last year.
- [x] 2 Extract information about the actors who acted in the given film.
- [x] 3 Extract information about actors who have appeared in at least N films.
- [x] 4 Extract information about actors who have been directed at least od-
from movies.

## Server mode in H2 database
To use the server mode in H2 database, you need to start the H2 database in server mode instead of embedded mode. Here are the steps to do that:

1. Make sure you have the H2 database server JAR file (h2-*.jar) available.

2. Start the H2 database server by running the following command in your terminal or command prompt:

java -cp h2-*.jar org.h2.tools.Server -tcp -web
This command starts the H2 database server in TCP and web mode. The server will listen for incoming connections on the default TCP port 9092 and the default web port 8082.

Once the server is started, you can access the H2 database using a browser by opening the following URL:

http://localhost:8082
This will open the H2 web console, where you can interact with the database.

In your application code, you can connect to the H2 database server using the JDBC URL:

jdbc:h2:tcp://localhost:9092/~/your-database-name
Replace your-database-name with the name of your database.


By starting the H2 database in server mode, you allow multiple processes or applications to connect to the same database concurrently. This is useful when you need to share the database among different clients or when you want to access the database remotely.