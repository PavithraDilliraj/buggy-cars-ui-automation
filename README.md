# buggy-cars-ui-automation
This repository is to create, update and run selenium tests scripts for buggy cars application.


Requirements:
Java (min 8)
Download link - https://www.java.com/en/download/apple.jsp
Installation guide - https://www.geeksforgeeks.org/how-to-install-java-on-macos/
Maven build tool
Download link - https://maven.apache.org/download.cgi
Installation guide - https://maven.apache.org/download.cgi
IntelliJ (IDE) - https://www.jetbrains.com/idea/download/#section=mac [Community Edition]
Maven dependencies
Selenium Webdriver (3.141.59) - https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
TestNG for test runner - https://mvnrepository.com/artifact/org.testng/testng/6.14.3
JSON for handing inputs - https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1
 
 
Instructions:
Download and Install Java
java -version => should print version
Download and Install Maven (set Java path)
mvn -version => should print version
Install IntelliJ IDE
Import the project
Open cmd and run "mvn test -Dtest=BuggyCarsTest"

The project was built in MAC, to run in windows please update the chromedriver file to .exe file. Also in all paths update the "/" to "\\".


Update username:
If you are running the test again, please update the "username" field in src/main/resources/data.json
