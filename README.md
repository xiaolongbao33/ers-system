# ERS-Template
This repository contains the skeleton for the ERS Project.
The [milestones.md](./milestones.md) can provide insight on helpful benchmarks.

> ERS, or Expense Reimbursement System, The Java Expense Reimbursement System is a full-stack web application that allows employees to submit reimbursement requests for work related expenses. Users can log in using their email and password. Employees are able to submit new reimbursement requests, and managers are able to view all submitted requests. Managers are also able to filter these requests based on their status.
 
> You will be required to present a demo of your application and its features.
> 
> Presentation date: Monday, March 21, 2022


# Requirements

## User Stories - Status 3/23
- User should be able to log in, using a username and password. 
  - CHECK - If the user is a manager, a successful login should redirect the request to the manager's 'all-reimbursement' page. 
  - CHECK - If the user is not a manager, a successful login should redirect to the employee's 'submit-reimbursement' page.
- Managers should be able to view all reimbursement requests (view provided).
  - CHECK, just add to clear browser cache to update all-reimbursement.js ;-P - Managers should be able to view pending, approved, and denied requests.
- Employees should be able to submit a new reimbursement request.
  - CHECK -Upon successfully submitting a reimbursement, an employee should be redirected to a page notifying them of its success and giving them an option to return to submit any additional reimbursements.
- CHECK, receiving 200 response in Postman, and update to DB - Managers should be able to update the status of a reimbursement (through postman only, no view required).

### Bonus User Stories 
- Employees should be able to view their specific reimbursements on the 'my-reimbursements' page (view provided).
  - Employees names should be populated in the select options.
  - Selecting an employee's name should populate their corresponding reimbursements.

## Project Views
### Required Views:
- Login page
- Submit reimbursement page
- Submit successful page
- All reimbursements page (provided)

### Bonus Views:
- My reimbursements page (provided)
- Any additional views you'd like to include to improve the user experience (e.g. employee landing page with the ability to navigate to the "my reimbursement" and "submit reimbursement" pages

## Project API

### Required HTTP Specification 
Your applications must support the following HTTP requests:

- GET /reimbursements
  - optional query param: 'status' - supports values 'pending', 'denied', 'approved'
  - returns: 
    - 200 - array type of reimbursement objects -  e.g. `[{ { "id": 1, "description": "dinner","status": "PENDING", "amount": 120.25, "date": [ 2022, 2, 11 ]}, ... }]` (required json properties: "id", "description", "status"="PENDING";"DENIED";"APPROVED", "amount", "date"=LocalDate.class)

- POST /reimbursements
  - required form params: 'employee-id', 'description', 'amount'
  - optional form params: 'date', 'status'
  - returns:
    - redirect to a success page
    - redirect to an error page

- PUT /reimbursements
  - required form params: 'reimbursement-id', 'status'
  - returns:
    - 200 - upon successful update
    - 400 - upon receiving insufficient or improperly formatted parameters 

- POST /login
  - required form params: 'username', 'password'
  - returns:
    - redirect to all reimbursement page upon successful manager login
    - redirect to submit reimbursement page upon successful employee login
    - redirect back to login page after unsuccessful attempt

### Bonus HTTP Specification
- GET /employees
  - optional query param: 'is-manager' - supports values 'true', 'false'
  - returns:
    - 200 - array type of employee objects - e.g. `[{ { "id": 1, "description": "dinner","status": "PENDING", "amount": 120.25, "date": [ 2022, 2, 11 ]}, ... }]` (required json properties: "id", "description", "status"="PENDING";"DENIED";"APPROVED", "amount", "date"=LocalDate.class)
- GET /employees/{id}/reimbursements
  - returns: array type of reimbursements - e.g. `[{ "id": 1, "username": "jshmo@gmail.com", ... }]` (required json properties: "id", "username")

## Other Project Goals 
- All application data is stored with AWS RDS.
- Database is in the third normal form.
- Java application organized with proper package structure, and uses proper Java naming conventions.

### Optionally
- Style web pages using CSS/Bootstrap.
- Protect user passwords using password hashing before storing them in the database.

## Tech Stack
- Java 8
- Apache Maven
- PostgreSQL
- AWS RDS
- Servlets
- JDBC
- HTML
