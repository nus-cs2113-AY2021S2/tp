##Parser component
**API**: `Parser.java`

* Determines the command entered by the user

* Parses the parameters needed by the `Command` object (for commands which require additional details)

* Checks the validity of parsed parameters, in some instances calling methods from other relevant classes, e.g. calling a method from the `Lessons` class to verify parsed lesson links.

* May instruct `UI` to print warnings and prompts to users, e.g. when users enter invalid parameters.

* Returns a new `Command` object with all the necessary attributes filled

&nbsp;

**Lesson:**

The `Lesson` class contains attributes related to a typical course lesson

* Lesson type, e.g. Lab, Tutorial or Lecture

* Time and day of the lesson

* Link to the lesson session

* Teaching staff information

&nbsp;

**Teaching staff:**

The `TeachingStaff` class contains attributes related to the teacher(s) of a particular lesson

* Name of the teacher

* Email address of the teacher

&nbsp;

**Task:**

The Task class contains attributes related to an assignment, deadline or task in a university setting

* Description of task

* Deadline of task

* Remarks

* Done status

* Graded status
