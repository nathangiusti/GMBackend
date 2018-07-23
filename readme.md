Overview:

Program is a RESTful API client implemented in Java using Spring libraries connected to an in memory database (H2).

Usage:

Program loads csv from within JAR into an in memory database and then supports the following get commands. 

/all - returns all reacords

/field_name/value returns all rows in which the field_name is equal to the value

List of acceptable field names:
   created_dt
   client 
   project 
   project_code 
   task 
   hours 
   hours_rounded 
   billable 
   invoiced 
   approved 
   first_name 
   last_name 
   department 
   employee 
   billable_rate 
   cost_rate
   cost_ammount 
   currency 
   url

Ex 
- localhost:8080/all
- localhost:8080first_name/walter

All values are returned as a csv with a header and include all columns for each row. 

Everything is case sensitive except for booleans

Installation:

To run locally download
mvn clean install
mvn package
java -jar target/gmbackend-0.0.1-SNAPSHOT.jar
