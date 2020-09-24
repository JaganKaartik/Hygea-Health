# JDBC Documentation

## Introduction

JDBC stands for Java Data Base Connectivity. The API for JDBC, is java.sql. package. In order to connect to database, we need a driver.

There are four types of drivers.

1.  JDBC-ODBC bridge driver
2.  Native-API driver (partially java driver)
3.  Network Protocol driver (fully java driver)
4.  Thin driver (fully java driver)

### JDBC-ODBC Driver (Type 1 Driver)

The JDBC-ODBC bridge driver uses ODBC driver to connect to the database. The JDBC-ODBC bridge driver converts JDBC method calls into the ODBC function calls. This is now discouraged because of thin driver.

ODBC Stands for Open Database Connectivity, since ODBC drivers are entirely written in C language, therefore, they are platform dependent and cause the portability issues. Hence, the performance issues.

In Java 8, the JDBC-ODBC Bridge has been removed.

#### Advantages:

- easy to use.
- can be easily connected to any database.

#### Disadvantages:

- Performance degraded because JDBC method call is converted into the ODBC function calls.
- The ODBC driver needs to be installed on the client machine.

### Native-Api Driver (Type 2 Driver)

The Native API driver uses the client-side libraries of the database. The driver converts JDBC method calls into native calls of the database API. It is not written entirely in java.

### Advantage:

- performance upgraded than JDBC-ODBC bridge driver.

### Disadvantage:

- The Native driver needs to be installed on the each client machine.
- The Vendor client library needs to be installed on client machine.

### Network Protocol Driver (Type 3 Driver)

The Network Protocol driver uses middleware (application server) that converts JDBC calls directly or indirectly into the vendor-specific database protocol. It is fully written in java.

#### Advantage:

- No client side library is required because of application server that can perform many tasks like auditing, load balancing, logging etc.

#### Disadvantages:

- Network support is required on client machine.
- Requires database-specific coding to be done in the middle tier.
- Maintenance of Network Protocol driver becomes costly because it requires database-specific coding to be done in the middle tier.

### Thin Driver (Type 4 Driver)

The thin driver converts JDBC calls directly into the vendor-specific database protocol. That is why it is known as thin driver. It is fully written in Java language.

#### Advantage:

- Better performance than all other drivers.
- No software is required at client side or server side.

#### Disadvantage:

- Drivers depend on the Database.

Nowadays, applications are using Type 4 JDBC drivers.

For this application, we are using PostgreSQL among other common types like MySQL, Oracle, MariaDB etc.

## Configuring JDBC via Netbeans

The driver may be either in the form of jar file, or zip file. Please incude this in the `project-root/web/WEB-INF/lib/` folder.

This project was created using PostgreSQL so the directory contains `project-root/web/WEB-INF/lib/postgresql-42.2.8.jar` file.

In order to use any other database instances, add the nessesary jar files in the `project-root/web/WEB-INF/lib/` folder and change the JDBC fields accordingly.

## JDBC Connection

### Steps Involved

1. Load the driver.
2. Create a Connection object (by default, when you create, it will open
   a connection to the database).
3. Create a Statement Object.
4. Execute the statement using an SQL query written in the form of Java
   String.
5. Process the results.
6. Close the connection.

### Loading the Driver

Eg. using PostgreSQL

```java
import java.sql.*;
Class.forName("org.postgresql.Driver");
String db_url = "jdbc:postgresql://yourlocalurl";
String db_username = "yourUsername";
String db_password = "yourPassword";
```

### Connection Object

```java
Connection conn = DriverManager.getConnection(db_url,db_username, db_password);
```

### Statement Object and Prepared Statement Object

```java
Statement stmt = conn.createStatement();
PreparedStatement ps = conn.prepareStatement("insert into *tablename* values (?,?);");
```

### Query Execution

To execute an SQL query, we write the query in the form of String. Then invoke the method executeQuery or executeUpdate on the Statement object.

There are basically two types of queries.

1. To retrieve a set of records from the database table.
2. To insert/modify/delete one or more records in the database table. Hence, we have two methods for executing.
   1. **executeQuery(String query)**:
      This method will return an object of type ResultSet which consists of records retrieved from table.
   2. **executeUpdate(String query)**:
      This method will return an integer, stating the number of records affected because of the statement. Note that both the methods accept a String object.

#### Eg. executeQuery

```java
String query = "select * from public."PatientInformation";
ResultSet rs = stmt.executeQuery(query);
```

#### Eg. executeUpdate

```java
PreparedStatement ps = con.prepareStatement("insert into public.\"PatientInformation\" values (?,?,?,?,?,?,?,?,?,?,?);");

/* Setting the PreparedStatements */

ps.setString(1,pid);
ps.setString(2,first_Name);
ps.setString(3,last_Name);
ps.setString(4,dob);
ps.setString(5,bloodgroup);
ps.setString(6,address);
ps.setString(7,pincode);
ps.setString(8,pno);
ps.setString(9,marstat);
ps.setString(10,age);
ps.setString(11,sex);

int val = ps.executeUpdate();

if(val>0)
{
   out.println("Success!");
   //Success
}
else
{
   out.println("Failed!");
   //fail
}
```

### Processing Results

The ResultSet object is similar to Java collection framework. It has an Iterator, which iterates through the records one by one, or fetch the first record, or fetch the last record.

```java

ResultSet rs = st.executeQuery(sql);

List<Patient> patients = new ArrayList<Patient>();

while(rs.next())
{
     Patient patient_obj = new Patient();

     PatientID = rs.getString(1);
     patient_obj.setPatientID(PatientID);

     First_name = rs.getString(2);
     patient_obj.setFirst_name(First_name);
}
```

- To iterate through every row : `while(rs.next()) // is used `
- To iterate through every ith column in a row `getString(i) // takes that value of the ith column `

### Close the connection

```java
stmt.close();
conn.close();
```

## Using Listeners

`Code Snippet from the source code of Hygea Health`

Using a servlet context listener, we can avoid redundant JDBC connection statements in each and every file that needs to access a database. The below is the syntax of the Servlet Context Listener implemented in this project.

```java
package HealthRecord;

import javax.servlet.*;
import java.sql.*;


public class DBListener implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent event)
    {
		try{
			Class.forName("org.postgresql.Driver");
			String db_url = "jdbc:postgresql://localhost:xxxx/";
	        	String db_username = "*username*";
			String db_password = "*password*";
            		Connection con = DriverManager.getConnection(db_url,db_username,db_password);

			//storing connection object as an attribute in ServletContext

			ServletContext ctx=event.getServletContext();
			ctx.setAttribute("mycon", con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
      }
	public void contextDestroyed(ServletContextEvent arg0){}
}
```

Now, while using Servlet Context Listener, we can write the connection code in one file and use

```java
 ServletContext ctx=getServletContext();
 Connection con=(Connection)ctx.getAttribute("mycon");
```

to access the database connection object in any file.

[Click to access source files](https://github.com/JaganKaartik/Hygea-Health/tree/master/src/java/HealthRecord)

##### To contribute!

- Fork this repository to your local repository using ![](https://img.icons8.com/small/16/000000/code-fork.png) `Fork command`
- Start by fixing Issues! Submitting ![](https://img.icons8.com/windows/16/000000/pull-request.png) `Pull Requests`

Cheers!! :sunglasses:
