# Railroad Services #

This project is a collection of business intelligence methods to provide answers to predetermined questions.

### Problem definition ###

The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!
 
The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.
 
Input:  A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town.
 
Output: For test input 1 through 5, if no such route exists, output 'NO SUCH ROUTE'.  Otherwise, follow the route as given; do not make any extra stops!  For example, the first problem means to start at city A, then travel directly to city B (a distance of 5), then directly to city C (a distance of 4).

* The distance of the route A-B-C.
* The distance of the route A-D.
* The distance of the route A-D-C.
* The distance of the route A-E-B-C-D.
* The distance of the route A-E-D.
* The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
* The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
* The length of the shortest route (in terms of distance to travel) from A to C.
* The length of the shortest route (in terms of distance to travel) from B to B.
* The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.


### Running the solution ###

This project was built using Maven to manage dependencies, package, test and build the solution.

**
* To test the application, on the root folder of the project execute: *mvn test*
* To generate a jar file of the solution: *mvn package*
* To run the applicatio, after the package generation: *java -jar target/railroad-services-1.0.jar <path to the input file>*

### Design ###
