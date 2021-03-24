###UI component
**API**: UI.java

* Facilitates the CLI interface
* Methods to display general messages, prompt messages and error messages
* Reads in user’s input, and used by Command classes to react to user’s inputs
* The UI object created as an attribute in Duke is passed into each command to be executed
* Instances of UI are used by tests in general

&nbsp;&nbsp;
###Model component

[Class diagram for all these objects - include attributes for each of them]

**ModuleList:**
* The ModuleList class keeps an ArrayList of module code strings, 
  and if a user is in a module, the selected module’s code
* Mainly handles operations related to Module objects such as loading
* Also contains methods to sort the other data types in this component
* Acts as a facade between storage and the other components

**Module:**
* The Module class contains attributes related to a course module in NUS
* It also holds an ArrayList for the Lesson and Task model
