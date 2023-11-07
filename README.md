# QrPay

## Steps to execute the project.

1: Download the SQL file which has the schema and various tables 
<br/>2: Execute the dump using either mysql admin tools or the Mysql command line tool 
<br/>3: The project runs on Java application server eg glassfish or tomcat. 
<br/>4: the project runs on JDK version 8 and beyond 
<br/>5: Once you have installed jdk and suitable IDE(netbeans/eclipse) you can proceed to run your project 
<br/>6:Ensure you have restored the database and the jndi as specified in the url https://www.javacodegeeks.com/2018/04/how-to-setup-jndi-database-connection-pool-in-tomcat-spring-tutorial-example.html
<br/>7: Requests are made to REST services in the formats below 


## Sample request
1: for user addition 
<br/>
http://localhost/QrPay/db.users/{id}
<br/>
<br/>
The function to consume the data is contained in the code below in the file path QrPay-main/src/java/Bean/service/UsersFacadeREST.java
```java
@PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Users entity) {
        super.edit(entity);
    }
```

