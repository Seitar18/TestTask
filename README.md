# Testing task. UI-tests for booking.com

## CONFIGURING ENVIRONMENT FOR STARTING TESTS

1. Use Windows 10 x64 and Chrome 60 x64 with defined JAVA_HOME(doesn't tested on other environments)
2. Clone project from github.
3. Run command **gradlew init** from project directory.

## RUNNING TESTS

For running tests use command **gradlew clean test** from project directory 

## PROJECT STRUCTURE

/test/java/com/:

1. **test** directory - package with test-classes with test-methods inside.
2. **pages** directory - package with page-objects files, all page-methods and locators inside.
3. **initializations** directory - package with only one file - Wrappers.java, which is used for wrapping Selenium methods.

/test:
**Resources** directory - resources with ChromeDriver for Windows and test-suite file TestNG.xml.

## TESTS STRUCTURE

All tests presented in /test/Resources/TestNG.xml test-suite file
There is one required parameter in the test-suite file:

**domain** - for testing domain link(prod, dev, local, etc.), "https://booking.com" by default

