# Test Automation Project
<a href="https://www.testrail.com">    
<img src="https://www.testrail.com/wp-content/uploads/2023/03/Frame-4.png" align="right" height="150" />
</a>

### **Overview**
TestRail is a web-based test management tool designed to help software development teams manage and streamline their testing processes. 
TestRail helps teams improve their testing efficiency, ensure quality, and manage their testing  
efforts more effectively.

### **Project Description**
This code represents a set of tests for automated testing of an application using Selenium and TestNG, including API tests. It describes various test scenarios for verifying the functionality of the application, such as logging in, creating and editing projects, creating test cases, sections, milestones and etc.
#

### **Clone the repository into your projects directory:**
https://github.com/marina-kostenko/TestRail_Diploma.git
### Installation:

* IDE: IntelliJ
* Programming Language: JAVA
* Project Type: Maven

### Stack:

* 	Selenium [4.19.1]
* 	TestNG [7.10.1]
* 	JavaFaker [1.0.2]
* 	Lombok [1.18.26]
* 	Log4j [2.23.1]
* 	Jackson [2.12.3]
* 	Rest-Assured [5.5.0]
*   Gson [2.10.1]

### Patterns used:

* 	Page Object
* 	Element Decorators (Wrappers)
* 	Value Object
* 	Builder
* 	Loadable Page

### Reporting:
*	Allure reporting

### Global Usage:

*	GitHub

#
### Checklist:

#### Login

* 	Verify successful login with valid credentials.
* 	Verify unsuccessful login with one empty field.
* 	Verify unsuccessful login with both fields empty.
* 	Verify unsuccessful login with incorrect data.

#### Project
* 	Verify successful project creation with valid data.
* 	Verify unsuccessful project creation with invalid data (empty required fields).
* 	Verify successful project editing with valid data.
* 	Verify unsuccessful project editing with invalid data (empty required fields).
* 	Verify successful project deletion.
* 	Verify unsuccessful project deletion with an invalid project ID.
* 	Verify successful creating a new project using the API with generated data.
* 	Verify successful deleting a project using the API.
* 	Verify successful getting project information using the API.
* 	Verify successful getting all projects using the API.

#### TestCase
* 	Verify successful test case creation with valid data.
* 	Verify unsuccessful test case creation with invalid data (empty required fields).
* 	Verify successful test case editing with valid data.
* 	Verify unsuccessful test case editing with invalid data (empty required fields).
* 	Verify successful test case deletion.
* 	Verify unsuccessful test case deletion with an invalid test case ID.
* 	Verify successful creating a new test case using the API from a JSON file with a section.

#### Section
* 	Verify successful section creation with valid data.
* 	Verify unsuccessful section creation with invalid data (empty required fields).
* 	Verify successful section editing with valid data.
* 	Verify unsuccessful section editing with invalid data (empty required fields).
* 	Verify successful section deletion.
* 	Verify unsuccessful section deletion with an invalid section ID.
* 	Verify successful creating a new section using the API with a suite.
* 	Verify successful getting all sections using the API.
* 	Verify successful updating a section using the API.
* 	Verify successful deleting a section using the API.

#### Milestone
* 	Verify successful milestone creation with valid data.
* 	Verify unsuccessful milestone creation with invalid data (empty required fields).
* 	Verify successful milestone editing with valid data.
* 	Verify unsuccessful milestone editing with invalid data (empty required fields).
* 	Verify successful milestone deletion.
* 	Verify unsuccessful milestone deletion with an invalid milestone ID.
* 	Verify successful creating a milestone using the API from a JSON file.
* 	Verify successful creating a milestone using the API with generated data.
* 	Verify successful updating a milestone using the API.
* 	Verify successful getting milestone information using the API.
* 	Verify successful deleting a milestone using the API.

#### TestRun
* 	Verify successful creating a test run using the API from a JSON file.
* 	Verify successful creating a test run using the API with generated data.
* 	Verify successful getting test run information using the API.
* 	Verify successful updating a test run using the API.
* 	Verify successful deleting a test run using the API.

#### Plan
* 	Verify successful creating and then closing a plan using the API.
* 	Verify successful deleting a plan using the API.
* 	Verify successful updating a plan using the API from a JSON file.
#
> [!NOTE]
> #### Instructions for running of tests:
>1. Open resources directory
>2. Open config.properties file
>3. Change base_url
>4. Change email
>5. Change password
> #### TestNG command for running all tests and getting report:
>-mvn clean test
> 
>-allure generate target/allure-results
> 
>-allure serve target/allure-results

###### By Marina Kostenko 👩🏽‍💻
























