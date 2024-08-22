# Automation Framework

Welcome to this Automation Framework that uses Java programming language, TestNG testing tool and Maven

### MUST BE INSTALLED BEFORE CLONING:

- Java JDK (I suggest version 17): https://www.oracle.com/java/technologies/downloads/
- Maven: https://maven.apache.org/download.cgi
- You can use any code editor, I suggest Eclipse (https://www.eclipse.org/downloads/)

### HOW TO EXECUTE TESTS:

1. Open Eclipse
2. Open the project
3. Currently, the configuration runs API testing and UI tests for Chrome and Firefox. In case you need to change that, open testng.xml file and you can comment out the test block for the corresponding browser that you don't want to run. In case you want to run in another browser, uncomment the test blocks for Safari or Edge.
4. On project explorer panel, look for testng.xml file, right click --> Run As --> TestNG Suite
5. Tests will start to be executed

### HOW TO CHECK REPORT:

1. Once tests finished running, _test-output_ folder will be automatically generated
2. Expand it and look for _emailable-report.html_ file
3. Right click --> Open with --> Web Browser
4. For checking screenshots in case of test failures, go to root of project and look for screenshots folder. Screenshots follow the format "{testMethodName}_{browser}_{year}{month}{day}{hours}{minutes}{seconds}"
