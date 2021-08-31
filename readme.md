<h2>Final Task Requirments</h2>

Capstone project description

Your final project must be published on GitHub!
Create Spring MVC Maven project.

Take PhoneBook application as an example and create Spring MVC (REST) application as follow:<br>
GET - receive all phoneBook records<br>
GET/{name} - all phones for the given name<br>
PUT/{name}; phoneNumber - add phone to existing name<br>
POST/; {“name”:”YourName”, “phoneNumber”: “+79998887711”} - create a new record in the phoneBook<br>
DELETE/{name} - removes record by name completely (including associated phone numbers<br>

Rest resources must be located under api/v1/customers.<br>
Use JSON as request/response body.<br>
All records can be kept in memory.<br>
DELETE/{name} - must throw an exception if there is no such phone in the
PhoneBook. The exception must be handled and reason must be printed out as a JSON object.<br>
Ensure that appropriate HTTP status codes are returned for ALL methods.
Java configuration of Spring MVC is a must.


<h3>Please use /resources/phonebook_db.sql to import data to database.</h3>

**Examples**

api/v1/customer

GET 
api/v1/customers

GET/{name} 
api/v1/customers/Alex

PUT/{name}; phoneNumber
api/v1/customers/Billy?phone=555

POST/; {“name”:”YourName”, 
“phoneNumber”: “+79998887711”}
api/v1/customers
{
"name": "Jack",
"phone": "+79998887711"
}

DELETE/{name}
localhost:8080/api/v1/customers/Alex