Running Environment:
	JDK 1.8
	Spring 4
	More detail info please refer to Maven file pom.xml


Worker & Job list REST API:
The URL of REST API for worker list and job list are in application.properties file which in src/main/resource

How to run:
1.	Unzip  the matchingEngine.zip to folder matchingEngine
2.	Go to folder matchingEngine
3.	Run maven command “mvn clean install” to create matchingEngine.war
4.	Copy matchingEngine.war to Tomcat (or other web server)
5.	Run http://localhost:8080/matchingEngine/matchedJob/{id}

Something can be improved
Can add cache to store workers and jobs, so do not need request REST API every time
More test case can be added 

