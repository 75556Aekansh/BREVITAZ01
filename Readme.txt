This document contains the overview of the API endpoints

BASE URL-http://localhost:8080/api/employees

Error Handling- Standard HTTP status codes are used for indicating operation success or failure. Error responses include descriptive messages where applicable.

Endpoints

1. Get All Employees
Endpoint: GET /api/employees
Description: Retrieves a list of all employees.
Parameters:
page (optional): Page number for pagination.
size (optional): Number of items per page.
for example:-
     GET /api/employees?page=0&size=10
     in above case you will get all 10 datasets in a single page suppose if we write 3 in place of 10 than in that case we will get 3 datasets in single page.
     and if no data are found than you will get this error "404 not found".


2. Create Employee
 Endpoint: POST /api/employees
 Description: Creates a new employee.
 Request Body: JSON format with employee details (firstname, lastname, emailId).
 for example:-
     POST /api/employees
      {
      "firstname" : param
      "lastname"  : veer
      "emailId"   : paramveer@gmail.com
      }
     Successful response : will return the created Employee object with specific id
     {
       "id": 3,
       "firstname": "param",
       "lastname": "veer",
       "emailId": "paramveer@gmail.com"
     }
     Error Responses : 400 Bad Request: If request body is invalid.


3. Update Employee
 Endpoint: PUT /api/employees/{id}
 Description: Updates an existing employee by their ID.
 Path Parameter: {id}: ID of the employee to update.
 Request Body: JSON format with updated employee details (firstname, lastname, emailId).
 for example:-
      PUT api/employee/3
      {
        "firstname": "Param",
        "lastname": "heer",
        "emailId": "paramheer@gmail.com"
      }
      Success Response: Returns the updated Employee object.
       {
             "id": 3,
             "firstname": "param",
             "lastname": "heer",
             "emailId": "paramheer@gmail.com"
       }
       Error Responses:
       404 Not Found: If employee with the specified ID does not exist.
       400 Bad Request: If request body is invalid.


4. Get Employee by ID
  Endpoint: GET /api/employees/{id}
  Description: Retrieves an employee by their ID.
  Path Parameter: {id}: ID of the employee.
  for example:-
      GET /api/employees/1
      {
        "id": 1,
        "firstname": "Aekansh",
        "lastname": "Singh",
        "emailId": "aekanshsingh@gmail.com"
      }
      Success Response : Returns the Employee object with the specified ID.
      Error Responses : 404 Not Found: If employee with the specified ID does not exist.


5. Delete Employee
  Endpoint: DELETE /api/employees/{id}
  Description: Deletes an employee by their ID.
  Path Parameter: {id}: ID of the employee to delete.
  for example:-
      GET /api/employees/1
      Example Response : No content is returned for successful deletion.
      Success Response : Returns 204 No Content if employee is successfully deleted.
      Error Responses  : 404 Not Found: If employee with the specified ID does not exist.

6.Search Employees
  Endpoint: GET /api/employees/search
  Description: Searches for employees by firstname or lastname (case-insensitive).
  Query Parameters: query: Search query string.
  for example:-
      GET /api/employees/search?query=aekansh
      Success Response: Returns a list of Employee objects matching the search criteria.
      {
              "id": 1,
              "firstname": "Aekansh",
              "lastname": "Singh",
              "emailId": "aekanshsingh@gmail.com"
      }
      Error Responses : 400 Bad Request: If query parameter is missing or invalid.




