## Build automation

This project uses Gradle for **build automation and dependency management. You are recommended to refer
to [Gradle Tutorial](https://se-education.org/guides/tutorials/gradle.html) by the se-edu.

The following is how Gradle can be used for the project tasks.

* `clean`: Deletes the files that are created during the previous build tasks. The files are usually kep in the `build`
  folder. e.g. `./gradlew clean`
* `shadowJar`: Uses the ShadowJar plugin to create a fat JAR file in the `build/lib` folder if the current file is
  outdated. e.g. `./gradlew shadowJar`
* `run`: Builds and runs the application.
* `runShadow`: Builds the application as a fat JAR and run it.
* `checkstyleMain`: Run the code style check for the main code base.
* `checkstyleTest`: Run the code style check for the test code base.
* `test`: Run all the tests.
    * `./gradlew test` - Run all tests
    * `./gradlew clean test` - Clean the project and run tests

## Continuous Integration (CI)

This project uses GitHUb Actions for Continous Integration. The project comes with necessary GitHub Action configuration
files, in the `.github/workflws` folder. There are no further setting up needed.

## Making a release

1. Generate a fat JAR file using Gradle (e.g. `gradle shadow`).
2. Tag the repository with the version number (e.g. `v2.0`).
3. [Create a new release with GitHub](https://docs.github.com/en/github/administering-a-repository/managing-releases-in-a-repository)
. Upload the JAR file created.