## Running Tests

There are two ways to run tests.

### 1. Using IntelliJ JUnit test runner

* To run all the tests, right-click on the `src/test/java` folder and choose `Run 'All Tests'`
* To run a subset of tests, right-click on a test package, class or test, for example, `SortByCategoryTest`and choose
  `Run 'SortByCategoryTest'`

### 2. Using Gradle

* Open a console and run the command `gradlew clean test`. For Mac OS-X or Linux users, run `./gradlew clean test`

Refer to this [Gradle Tutorial](https://se-education.org/guides/tutorials/gradle.html) from se-edu/guides to learn more
about using Gradle.

## Types of Tests

There are three types of tests.

1. *Unit tests* which targets the lowest level methods or classes. e.g. `SortByCategoryTest`
2. *Integration tests* are tests that checks for the integration of code units. &nbsp; This is done on the assumption
   that these units are working.
3. *Hybrids of unit and integration tests.* These tests are used to check multiple code units and how these code units
   are integrated with each other.