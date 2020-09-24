# HygeaHealth - An electronic health record system

**Warning: This project was created in September 2019. Contains messy code. Use this as a reference only to understand the basic concepts of JSP, Servlets, JDBC and how they work together in a Simple Java EE Application.**

## Introduction

An Electronic Health Record (EHR) is an electronic version of a patients medical history, that is maintained by the
provider over time, and may include all of the key administrative clinical data relevant to that persons care under
a particular provider, including demographics, progress notes, problems, medications, vital signs, past medical history, immunizations, laboratory data and radiology reports.

A basic electronic health record application built on the Java EE Architecture which uses JSP, Servlets and PostGreSQL. This software contains a very basic and mininal UI, build using Materialize CSS.

This project is done as part of the (15CSE376) Net Centric Programming course.

## Requirements

- Apache Tomcat Server (used v8.5.46 for development)
- Netbeans IDE 8.2
- PostgreSQL Connector (JDBC) (used v42.2.8 for development)
- PostgreSQL 10 and Postico Client (Mac) or PgAdmin (Windows/Mac)

## Running the Application

Based on the assumption that the software will be running a PostgreSQL database. For this software to work according to its design. Initialise a local PostgreSQL Database instance, in the system that intends to run this program.

Make changes to the local postgresql server location, username and password fields in the DBListener.java and LoginServlet.java files.

```
Class.forName("org.postgresql.Driver");
String db_url = "jdbc:postgresql://yourlocalurl";
String db_username = "yourUsername";
String db_password = "yourPassword";
```

In order to use any other database instances, add the nessesary jar **(postgres-sql-connector-jar)** files in the
`project-root/web/WEB-INF/lib/`
folder and change the JDBC fields accordingly.

## Hygea Health User Interface

### Homepage

![HomePage](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/1.%20Homepage.png)

### Admin Dashboard

![AdminDB](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/2.%20Admin%20Dashboard.png)

### Admin-Views

![Admin-Views](<https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/3.%20Admin%20(View%20All%20Doctors).png>)
![](<https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/3.%20Admin%20(View%20All%20Patients).png>)
![](<https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/3.%20Admin%20(View%20Users).png>)

### Receptionist Dashboard

![RecepDB](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/4.%20Receptionist%20Dashboard.png)

### Receptionist-Views

![](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/4.%20View%20Doctor%20Details.png)
![](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/4.%20View%20Medical%20Record.png)

### Receptionist (Patient Registration)

![RecepReg](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/4.%20Add%20Patient%20Demographics.png)
![RecepReg2](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/4.%20Add%20Medical%20Records.png)

### Doctor Dashboard

![DocDB](https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/5.%20Doctor%20Dashboard.png)

### Searching Patient Records via Doctor Dashboard

![DocSP](<https://github.com/JaganKaartik/Hygea-Health/blob/master/Media/5.%20Doctor%20(Search%20Records).png>)
