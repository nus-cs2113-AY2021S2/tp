**Developer Guide**
===================

**Introduction**
================

### **What is HealthVault**

HealthVault is a desktop app for managing doctor, nurse and patient
information, optimised for use through the command line interface. This
app is for the head nurse of a hospital, if the user can type fast, it
is better than a traditional GUI app.

### **Purpose and scope**

The purpose of this developer guide is to describe the architecture and
software design decisions for our application. This guide will cover our
program architecture, the logical view of major components and how our
functions work.

**Setting Up and Getting Started**
----------------------------------

### **Setting up**

There are 2 prerequisites for this project

1.  Java 11

-   Launch your terminal and type "java -version" to ensure the correct
    > version

2.  Intellij IDEA

### **Getting Started**

1.  Fork this repo, and clone the fork into your computer.

2.  Import the project as a gradle project

3.  Run Duke.main and try a few commands

4.  Run the tests to ensure they all pass.

**Design**
----------

**Architecture**
----------------

![](media/image2.png){width="6.267716535433071in"
height="5.638888888888889in"}

Our application utilises many layers of abstraction which allows each
individual component to be self contained yet able to work with other
components. The Main Menu component allows direct access to other
components as shown in the diagram.

Shared functionalities are placed within the Common Classes component
which will be elaborated on in the section [[Common
Classes]{.ul}](#common-classes)

### 

### **UI component**

1.  Each class has a specified UI class that serves the specific need
    > for the individual class

2.  There is a Main UI Class that shares all common UI functionalities
    > amongst the classes. This will be elaborated in the Common Classes
    > component

> (Insert UI UML diagrams)

### **Logic component**

1.  This component would be the backbone of our program, where the
    > functions of each individual class are crafted and contribute to
    > the program.

2.  Command is passed through the Parser.java class which determines
    > what actions to perform. The actions to be performed are methods
    > called in the classes stated below.

[Actions:]{.ul}

1.  In the menu of Doctor's Appointment, command of "add D12345 Alex M
    > 21012021".

2.  Input is passed along to the Parser.java class where the keyword
    > "add" is detected.

3.  addAppointment() method in the AppointmentActions.java class is
    > called and adds the details into the list

[Classes:]{.ul}

1.  AppointmentActions

2.  DrugActions

3.  NurseScheduleActions

4.  PatientList

5.  StaffList

### **Object Class component**

This component is to distinguish the separate object that has been
instantiated to hold the details of our target users. An object class
allows for a structure that helps store details from user input in the
format that we want to be saved.

[Objects:]{.ul}

1.  DoctorAppointment.java

2.  Drug.java

3.  Patient.java

4.  NurseSchedule.java

5.  Staff.java

### 

### **Storage component**

The difference classes for storages are separated into their respective
architecture for easier management.

> [Methods:]{.ul}

1.  writeToFile() - Calling upon this method whenever there is change to
    > the data array list.

2.  createFile() - Called during the start of the program when
    > loadFile() is called and returns an error, meaning that there are
    > no text files in storage. Thus, this method is called to create a
    > new text file for data storage.

3.  loadFile() - Called during the start of the program, to initialise
    > the array list and load previously saved data.

[Classes:]{.ul}

1.  DoctorAppointmentStorage

2.  DrugStorage

3.  NurseScheduleStorage

4.  PatientStorage

5.  StaffStorage

### **Common classes**

1.  Main UI Class

2.  Main Storage Class

 

**Implementation**
------------------

This section describes how the features are being implemented. The scope
will include the Doctor Appointments / Drugs / Nurse Schedules /
Patients / Staff related features.

Common features that can be identified across the scope include these
distinct functionalities: Adding, Deleting and Listing. For Nurse
Schedules/ Patients / Staff related features, there is an additional
search functionality.

### **Menu-related Features**

**Main Menu**

This feature allows users to select the different menus for Patient /
Staff / Doctor Appointments / Nurse Schedules and Drugs through
inputting commands within the main menu. Failure to input a correct or
recognized command will then prompt the program to generate an exception
that will alert the user of what they have done wrongly, and also prompt
the user to access the help list to view the correct set of commands and
their proper syntaxes.

If the user enters a correct and recognized command, they will be able
to access the functionalities related to the specific Objects (i.e
Staff, Patient, Doctor Appointments, Nurse Schedules, Drugs).

[Implementation:]{.ul}

1.  A command is requested from the user as the application starts,
    > Duke.run() calls UI.scanInput() to read the user's input from the
    > command line.

2.  The user input determines which type of functionalities will be
    > accessed by the user.

**Staff Menu**

[Implementation:]{.ul}

1.  When "Staff" is given as input in the main menu, duke.run() will
    > call StaffParser.run()

2.  StaffParser.run() provides the user a huge range of functionalities
    > to work with the Staff Objects.

3.  StaffParser.run() will request input from the user.

4.  User input will determine the type of actions taken on Staff
    > Objects.

5.  The details of the functionalities related to Staff Object is
    > detailed in the section below under [[Staff-related
    > Features]{.ul}](#staff-related-features).

**Staff Menu**

This feature allows users to select the different menus for Patient /
Staff / Doctor Appointments / Nurse Schedules and Drugs through
inputting commands within the main menu. Failure to input a correct or
recognized command will then prompt the program to generate an exception
that will alert the user of what they have done wrongly, and also prompt
the user to access the help list to view the correct set of commands and
their proper syntaxes.

If the user enters a correct and recognized command, they will be able
to access the functionalities related to the specific Objects (i.e
Staff, Patient, Doctor Appointments, Nurse Schedules, Drugs).

**Doctor Appointment Menu**

This feature of the program can be accessed through the main menu as the
application starts running. Accessing this feature gains access to the
DoctorAppointment package, including the classes
AppointmentActions.java, DoctorAppointment.java,
DoctorAppointmentInstance.java, DoctorAppointmentStorage.java and
Parser.java. The purpose of this feature is to save a database of
patient details when they make an appointment with the doctor.

[Implementation:]{.ul}

6.  When the user types in a command,

    a.  Duke.run() calls UI.scanInput() to read the user's input from
        > the command line.

7.  After scanning the user input, it will be run through case
    > statements in Duke.run() to find the appropriate command that
    > corresponds to the user's input

8.  Depending on the input Duke.run() will then bring the user to the
    > specific instance handler for that feature, which can be
    > Staff.Parser.run() or NurseScheduleInstance.main(). Alternatively,
    > Duke.run() creates either a PatientCommandInstance or
    > DoctorAppointmentInstance or DrugInstance object that may act as
    > an instance handler.

9.  The selected instance handler will then have its own menu that may
    > handle any additional user commands that are inputted to access
    > features within that particular instance.

### **Staff-related Features**

**Adding a new Staff**

[Implementation:]{.ul}

When the user attempts to add a new staff, the StaffStorage, StaffList,
UI, StaffUI classes will be accessed, and the following sequence of
actions is called to prompt execution result to user:

add \[Staff ID\] \[name\] \[age\] \[specialisation\]

> Getting User Input

1.  User inputs add command which is processed by the Staff.Parser.run()

2.  Parser.run() calls StaffUI.inputToCreateStaff() to receive user
    > input for Staff object details.

3.  StaffUI.inputToCreateStaff() calls UI.abortEnabledScanInput() to
    > receive user input for each detail of a Staff Object.

> Creating Staff Object with User Input

4.  As the user inputs the Staff ID, StaffUI.inputToCreateStaff() calls
    > Parser.checkID() to ensure that the Staff ID input is valid.

5.  A Staff Object is created and stored in an existing
    > ArrayList\<Staff\>, StaffList. which contains all the Staff
    > Objects.

> Saving Staff Objects into .txt file

6.  The Parser then calls StaffStorage.writeToFile() which starts the
    > process of writing the details of all existing Staff Objects,
    > within the StaffList into a specified .txt file.

7.  StaffStorage.writeToFile() then calls createFile() which ensures
    > that the specified .txt file exists.

8.  Data is written and saved.

**Deleting a Staff**

[Implementation:]{.ul}

When the user attempts to delete a staff, the StaffStorage, StaffList,
UI, StaffUI classes will be accessed, and the following sequence of
actions is called to prompt execution result to user:

delete Staff ID

> Getting User Input

1.  User inputs delete \[Staff ID\] command

2.  Parser.run() calls checkEmptyInput() to ensure that input is not
    > empty

3.  Parser.run() calls Parser.checkID() to ensure that the Staff ID
    > input is valid.

> Deleting Staff Object with specified Staff ID

4.  Parser.run() calls StaffList.delete() to begin the deletion of the
    > Staff with Staff ID specified.

5.  StaffList.delete() iterates through the ArrayList\<Staff\>, list, to
    > find the specified Staff Object.

6.  If the specified Staff Object is found, it is deleted.

> Prompting result to user

7.  If a deletion occurs, StaffList.delete() calls
    > StaffUI.staffFiredOutput() to output a feedback message.

8.  If no deletion occurs, StaffUI.staffDoesNotExist() is called instead
    > fro a different feedback message.

> Saving Staff Objects into .txt file

9.  The Parser then calls StaffStorage.writeToFile() which starts the
    > process of writing the details of all existing Staff Objects,
    > within the StaffList into a specified .txt file.

10. StaffStorage.writeToFile() then calls createFile() which ensures
    > that the specified .txt file exists.

11. Data is written and saved.

**Viewing all Staff**

[Implementation:]{.ul}

When the user attempts to add a new staff, the StaffStorage, StaffList,
UI, StaffUI classes will be accessed, and the following sequence of
actions is called to prompt execution result to user:

list \[doctors/nurses\]

> Getting User Input

1.  User inputs list command

2.  Parser.run() calls Parser.checkListCommand() to ensure that input is
    > valid (Otherwise, WrongListInputException is called).

3.  Parser.run() calls StaffUI.staffListHeader() to format the output
    > for readability.

> Displaying Staff Object details

4.  Parser.run() calls StaffList.list() to begin the process of
    > displaying details of Staff Objects.

5.  Based on the optional input, StaffList.list() will iterate through
    > the relevant Staff Objects and call StaffList.display() for each
    > Object

6.  StaffList.display() will call UI.prettyPrint() to format the output
    > to the console screen.

**Finding a Staff**

[Implementation:]{.ul}

When the user attempts to find a staff using a certain keyword, the
StaffStorage, StaffList, UI, StaffUI classes will be accessed, and the
following sequence of actions is called to prompt execution result to
user:

find \[keyword\]

> Getting User Input

1.  User inputs find command with a keyword input.

2.  Parser.run() calls checkEmptyInput() to ensure that keyword input is
    > not empty.

3.  Parser.run() calls StaffUI.staffListHeader() to format the output
    > for readability.

> Finding Staff Objects that matches keyword

4.  Parser.run() calls StaffList.find() to begin the process of finding
    > relevant Staff Objects.

5.  StaffList.find() will iterate through all Staff Objects and call
    > StaffList.search() for each Object

6.  StaffList.search() indicates which Staff Object has details that
    > matches the relevant keyword input

7.  For each relevant Staff Object, StaffList.display() will be called
    > to display the Staff Object details to user

**Return to main menu**

[Implementation:]{.ul}

User will be returned the Main Menu upon usage of the return command

return

> Saving Staff Objects into .txt file

1.  User executes return command

2.  Parser.run() calls StaffStorage.writeToFile() which starts the
    > process of writing the details of all existing Staff Objects,
    > within the StaffList into a specified .txt file.

3.  StaffStorage.writeToFile() then calls createFile() which ensures
    > that the specified .txt file exists.

4.  Data is written and saved.

5.  StaffList.resetList() will be called to remove all previous entries
    > of Staff Objects within ArrayList\<Staff\> list.

6.  Parser.run() will cease running and control will be returned to
    > duke.run()

**View relevant Staff commands**

[Implementation:]{.ul}

All commands in the Staff Menu will be displayed with detailed
information on its usage

help

1.  StaffUI.printStaffHelpList() is executed and help commands and
    > instructions are displayed;

Failure to input a correct or recognized command will then prompt the
program to generate an exception that will alert the user of what they
have done wrongly, and also prompt the user to access the help list to
view the correct set of commands and their proper syntaxes.

If the user enters a correct and recognized command, they will then be
put into the respective instance of feature that they selected.

###  

**Patient-related Features**

**Adding a Patient**

add \[Patient ID\] \[name\] \[age\] \[gender\] \[illness\] \[medication
needed\]

This feature allows the user to add a patient to the list of current
patients. If the user fails to correctly input the proper parameters.
Exceptions will be triggered to guide the user on what caused the
exception and the action will be aborted. The user will also be directed
to use the help command to refer to the correct syntax.

If the patient is added successfully, a message showing the name of the
patient added will be shown to the user.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, Patient, PatientList,
PatientParser, PatientStorage.

1.  User Executes command add P12345 Joe 30 M flu panadol

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command add is
        > identified.

    b.  PatientParse then calls lengthCheck() and iDParser() to scan the
        > user input for any errors

    c.  If lengthCheck() and iDParser() throw an exception, the current
        > action will be aborted and the user will be notified with an
        > appropriate error message and once again prompted to enter
        > another command. If successful, the program will move to
        > step 3.

3.  Creating Patient object

    a.  patientParse calls PatientList.addPatient() and creates a
        > Patient object that will be stored in the PatientList Object
        > which contains an ArrayList of Patient objects.

4.  Prompting user that Patient Object has been created

    a.  After successfully creating the Patient Object and adding it to
        > the PatientList object. PatientList.addPatient() calls
        > PatientUI.patientAddedMessage() to print a message notifying
        > the user that a patient has been added.

5.  Saving the current list of patients

    a.  After the new Patient object is created and stored in a
        > PatientList, patientParse returns to the
        > PatientCommandInstance.

    b.  PatientCommandInstance then calls PatientStorage.storePatients()
        > store the updated PatientList object into a text file at a
        > specified directory.

**Listing patients**

list

This feature allows the user to view the list of patients. If the
command is inputted correctly a list showing the current patients in the
order in which they were added to the list will be displayed.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, Patient, PatientList,
PatientParser.

1.  User Executes command list

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command list is
        > identified.

    b.  patientParse then calls lengthCheck() to scan the user input for
        > any errors

    c.  If lengthCheck() throws an exception, the current action will be
        > aborted and the user will be notified with an appropriate
        > error message and once again prompted to enter another
        > command. If successful, the program will move to step 3.

3.  Listing the Patients in the list

    a.  patientParse calls PatientList.listPatients() to list the
        > patients currently in the PatientList, which is an array of
        > current Patients.

4.  Printing the list of Patients

    a.  If there are no patients currently in the list,
        > PatientList.listPatients() calls
        > PatientUI.emptyPatientListMessage(). And displays to the user
        > that there are no patients in the list.

    b.  If there are patients currently in the list,
        > PatientList.listPatients() calls
        > PatientUI.notEmptyPatientListMessage() before iterating
        > through the list and calling PatientUI.printPatientList() to
        > show each individual patient in the list.

**Deleting a Patient:**

delete \[Patient ID\]

This feature allows the user to delete an existing patient in the list
of patients. If the user fails to correctly input the proper parameters.
Exceptions will be triggered that will notify the user on what caused
the exception and the action will be aborted. The user will also be
directed to use the help command to refer to the correct syntax.

If the patient has been successfully deleted from the list they will be
notified with a message showing the deleted patient's name and that they
have been removed from the list.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, Patient, PatientList,
PatientParser, PatientStorage.

1.  User Executes command delete P12345

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command delete is
        > identified.

    b.  patientParse then calls lengthCheck() and iDParser() to scan the
        > user input for any errors

    c.  If lengthCheck() and iDParser() throw an exception, the current
        > action will be aborted and the user will be notified with an
        > appropriate error message and once again prompted to enter
        > another command. If successful, the program will move to
        > step 3.

3.  Deleting the Patient from the list

    a.  patientParse calls PatientList.deletePatient() and the patient
        > specified by the user is deleted from the list through
        > iterating through the patientList and discovering the location
        > of Patient specified before deleting the object from the
        > ArrayList

4.  Notifying user that Patient has been deleted

    a.  After successfully deleting the Patient from the PatientList
        > object. PatientList.deletePatient() calls
        > PatientUI.deletePatientMessage() to print a message notifying
        > the user that the Patient has been deleted.

5.  Saving the current list of patients

    a.  After the new Patient object is deleted from the PatientList,
        > patientParse returns to the PatientCommandInstance.

    b.  PatientCommandInstance then calls PatientStorage.storePatients()
        > store the updated PatientList object into a text file at a
        > specified directory.

**Finding a patient:**

find \[Patient ID\]

This feature allows the user to find an existing patient in the list of
patients. If the user fails to correctly input the proper parameters.
Exceptions will be triggered that will notify the user on what caused
the exception and the action will be aborted. The user will also be
directed to use the help command to refer to the correct syntax.

If the find command is successfully executed. The user will be notified
as the patient they were finding will be listed.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, Patient, PatientList,
PatientParser, PatientStorage.

1.  User Executes command find P12345

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command find is
        > identified.

    b.  patientParse then calls lengthCheck() and iDParser() to scan the
        > user input for any errors.

    c.  If lengthCheck() and iDParser() throw an exception, the current
        > action will be aborted and the user will be notified with an
        > appropriate error message and once again prompted to enter
        > another command. If successful, the program will move to
        > step 3.

3.  Finding the Patient in the list

    a.  patientParse calls PatientList.findPatient() and iterates
        > through the list to find the Patient that matches the input
        > specified by the user.

4.  Notifying user that Patient has been found

    a.  After successfully finding the Patient.
        > PatientList.findPatient() calls PatientUI.printPatientList()
        > to print a message notifying the user that a patient has been
        > found, showing the patients details.

**Help**

help

This feature shows a list of commands usable within the patient-related
functions and their correct syntaxes that must be followed to enable
proper usage.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, PatientParser.

1.  User Executes command help

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command find is
        > identified.

    b.  PatientParse then calls lengthCheck() to scan the user input for
        > any errors.

    c.  If lengthCheck() throws an exception, the current action will be
        > aborted and the user will be notified with an appropriate
        > error message and once again prompted to enter another
        > command. If successful, the program will move to step 3.

3.  Printing the help list for the user to reference

    a.  patientParse calls PatientUI.printPatientHelpList() to print a
        > list of commands and instructions on how to use them.

**Return to main menu**

return

This feature returns the user to the main menu of the program.

[Implementation:]{.ul}

When a user attempts to add a patient the following classes will be
accessed: PatientCommandInstance, UI, PatientUI, PatientParser.

1.  User Executes command return

    a.  PatientCommandInstance calls UI.scanInput() to read the user
        > input

    b.  PatientCommandInstance calls PatientParser.patientParse() to
        > parse the user\'s input into a string array.

2.  Checking user input in parser

    a.  Using the case statements in patientParse, the command return is
        > identified.

    b.  PatientParse then calls lengthCheck() to scan the user input for
        > any errors.

    c.  If lengthCheck() throws an exception, the current action will be
        > aborted and the user will be notified with an appropriate
        > error message and once again prompted to enter another
        > command. If successful, the program will move to step 3.

3.  Notifying user of returning to main menu

    a.  patientParse calls UI.returningToStartMenuMessage() to show the
        > user that they will now exit from the PatientCommandInstance.

4.  Returning to main menu

```{=html}
<!-- -->
```
a.  patientParse returns true to PatientCommandInstance and this causes
    > the PatientCommandInstance to break out of its input loop. Thereby
    > returning to the main menu from the PatientCommandInstance.

### **Nurse Schedule-related Features**

When the user accesses an instance of Nurse Schedules, the
NurseScheduleParser, NurseScheduleActions and NurseScheduleStorage
classes will be accessed. If data is found on the NurseSchedules text
file, it will be loaded into the arraylist, else a new text file is
created.

#### Implementation:

1.  User executes a command

2.  NurseScheduleInstance calls UI.abortEnabledScanInput() to receive
    > user input.

3.  NurseScheduleInstance calls NurseScheduleParser.getFirstWord() to
    > parse user input for specific commands.

4.  Depending on the command, NurseScheduleInstance will call the
    > relevant methods in NurseScheduleActions.

5.  NurseScheduleActions will either add, list or delete a NurseSchedule
    > object.

###### **Adding a new Nurse Schedule**

#### Implementation

When the user attempts to add a new nurse schedule, the
NurseScheduleStorage, NurseScheduleActions, UI and NurseScheduleUI
classes will be assessed, and the following sequence of actions is
called to prompt execution results to user:

*add* \[Nurse ID\] \[Date (DDMMYYYY)\]:

Getting User Input:

1. User inputs add command which is processed by NurseScheduleInstance.runCommandLoopUntilExit().
2. This calls NurseScheduleActions.addSchedule() which calls NurseScheduleUI.inputToCreateSchedule().

Creating NurseSchedule object with User Input:

3. NurseScheduleUI.inputToCreateSchedule() creates a new NurseSchedule object and is stored into an existing ArrayList\<NurseSchedule\>
nurseSchedules which contains all the nurse schedule objects

Saving NurseSchedule objects into .txt file:

4. The command loop then calls NurseScheduleStorage.writeToFile() which starts the process of writing details of all existing Nurse Schedule objects within the ArrayList to the specified .txt file

*list* \[Nurse ID\] or list \[all\]:

#### Implementation:

When the user attempts to list nurse schedules, they will have the
choice of listing all schedules or a specified nurse id's schedule. This
is similar to a search function. This will access the
NurseScheduleActions class.

Getting User Input

1.  User inputs list \[Nurse ID/all\] command.

2.  Command loop calls NurseScheduleActions.listSchedules().

Gathering necessary schedules

3.  listSchedules will call listAllSchedules() if the user inputs all,
    > else it will check if Nurse ID is valid and call
    > getNurseSchedulesById().

Printing schedules

4.  printSchedules() is then called to print all schedules.

```{=html}
<!-- -->
```
1.  delete \[Nurse ID\] \[Date (DDMMYYYY)\]:

-   When a delete command is
    > issued,NurseScheduleActions.deleteSchedule() is called.

-   deleteSchedule() loops through the array list nurseSchedules to find
    > all objects that are equal to given \[Nurse ID\] and \[Date
    > (DDMMYYYY)\].

-   Found objects are then removed by nurseSchedules.remove().

###  

### **Doctor Appointment-related Features**

[Implementation:]{.ul}

1.  User executes command

2.  Depending on the command, the Parser.java Class will determine which
    > method of Appointment Actions to call upon.

3.  Commands includes add, list, delete, help and return.

[Features:]{.ul}

1.  add\[Doctor ID\] \[Patient's Name\] \[Gender\] \[DDMMYYYY\]:

-   When the user inputs the command, the input will be parsed into
    > Parser.java, which will call upon addAppointment() method in the
    > AppointmentActions.java.

-   Within the method, the string input would be split() into an
    > inputArray which will then create a new object of type
    > DoctorAppointment and added into the \<DoctorAppointment\>
    > ArrayList.

2.  list \[Doctor ID\]:

-   When a list command is called, it calls upon the listAppointment()
    > method in the AppointmentActions.java class.

-   The input of the queried doctor ID is passed along as a string into
    > the stated method and it iterates through the ArrayList of saved
    > doctor's appointment with a for loop.

-   Comparing if the Doctor ID while iterating is equals to the input
    > that is passed, the details of the Appointment - ID, Patient's
    > Name, Gender, Date, is printed out for the user.

3.  delete \[Appointment ID\]:

-   When the command delete is called. The Parser.java will recognise
    > the command and call upon deleteAppointment() method in the
    > AppointmentActions.java class.

-   A variable "index" of default value 999 is initialised. A for loop
    > is then called upon to iterate through the current ArrayList of
    > doctor's appointment list to search for the ID that is equal to
    > the input.

-   If there is a match, the variable index would be set to the
    > iteration in which the ID had been matched

-   If the value of index remains at 999, the system recognise that
    > there is no matched ID in the system, else, the system would
    > remove the appointment details from the Doctor Appointment List
    > and call upon writeToFile() method from the storage class to
    > rewrite the file with the most current details.

4.  help:

-   When the command help is called. The Parser.java will recognise the
    > command and call upon helpAppointment() method in the
    > AppointmentActions.java class.

-   The method calls upon doctorAppointmentHelp() method from the UI
    > class which will print the commands that are necessary for the
    > program.

5.  return:

-   When the command return is called, the Parser.java class returns a
    > boolean value of True instead of the default False.

-   This will set the boolean variable, isReturnToStartMenu in the
    > DoctorAppointmentInstance.java class to True.

-   This will prompt the program to return to the staff Menu as if when
    > the program first booted.

 

**Drugs-related features**
--------------------------

This feature can be accessed when the user inputs "5" into the terminal.
The user will gain access to DrugParser, DrugStorage, and DrugActions.
If data is found on the Drugs text file, it will be loaded into the
arraylist, else a new text file is created. The purpose of this feature
is to save a database of all the drugs in the inventory.

[Implementation:]{.ul}

User executes a command. Depending on the command, DrugInstance will
call the relevant methods in DrugActions. DrugActions will either add,
list or delete a Drug object.

add\[Drug name\] \[Price\] \[Quantity\]:

Getting User Input

> User input add command which is processed by DrugInstance.run().

Creating Drug object with User Input

> DrugAction.addDrug() creates a new NurseSchedule object and is stored
> into an existing ArrayList\<Drug\> drug which contains all the drug
> objects.

Saving Drug objects into .txt file

> The command loop then calls DrugStorage.writeToFile() which starts the
> process of writing details of all existing Drug objects within the
> ArrayList to the specified .txt file

list \[Drug name\]:

> When the user inputs this command, the input will be parsed into
> Parser.java, which will call the DrugActions.listDrug() method in the
> DrugActions.java.
>
> The most updated database of drugs saved will be listed.

delete \[Drug name\]:

> When the user inputs this command, the input will be parsed into
> Parser.java, which will call the DrugActions.deleteDrug() method in
> the DrugActions.java.
>
> Everything related to that specific drug will be removed.

help:

> When the user inputs this command, the input will be parsed into
> Parser.java, which will call the DrugUI.printHelpMessage() method in
> the DrugUI.java.
>
> The available features, add, list, delete, help, and return will be
>
> displayed for the user.
>
> The program will wait for the user to input one of the features.

return:

> When the user inputs this command, the input will be parsed into
> Parser.java, it will bring the user back to the main menu of the
> program.

 

**Documentation, logging testing, configuration, dev-ops**
----------------------------------------------------------

### **Product scope**

**Target user profile:**

-   Has a need to manage a huge amount of data like medical records,
    > schedules and doctor info

-   Prefers a no-frills functional app over other types

-   Can type reasonably fast and accurate

-   Does not need a mouse

-   Reasonably comfortable using CLI applications

**Value Proposition:** A hospital management system that is faster and
minimal compared to a typical GUI application

### User stories

  **Priority**   **As a\...**   **I want to\...**                                       **So that I can\...**
  -------------- -------------- ------------------------------------------------------- --------------------------------------------------
  \* \* \*       new user       quickly refer to usage instructions                     quickly get on track with the workflow
  \* \* \*       user           add a new staff/patient                                 
  \* \* \*       user           delete staff/patients                                   remove entries i no longer need
  \* \* \*       user           quickly look up schedules for both nurses and doctors   plan my schedule better
  \* \* \*       user           quickly look up drug inventories                        plan what and when to restock our drug supplies
  \*             user           have the program recognize slight errors in typing      have leeway working in a high-stress environment

### 

### Non-Functional Requirements

1.  Should work on any mainstream OS as long as it has Java 11 or above
    > installed as cross-platform testing has been carried out

2.  Should be able to hold all details of hospitals max capacity without
    > any noticeable decrease in performance

3.  User with average typing speed will be able to fulfil tasks faster
    > than regular GUI application with mouse

Changed section: saved here just in case

[Features:]{.ul}

1.  Staff

-   Staff.Parser.run() method is called to instantiate a new instance of
    > a command handler for staff related commands

2.  Patient

-   A new PatientCommandInstance object: (patient) is being instantiated
    > with the variable "PATIENT_FILE_PATH" which is a constant that
    > stores the location of patient save data

-   patient.run() is then called to run the instance of command handler
    > for patient related commands

3.  Appointment

-   A new DoctorAppointmentInstance object: (appointments) is being
    > instantiated with the variable "APPOINTMENT_FILE_PATH" which is a
    > constant that stores the location of appointment save data

-   appointment.run() is then called to run the instance of command
    > handler for appointment related commands

4.  Schedule

-   NurseScheduleInstance.main() is called to instantiate a new instance
    > of a command handler for nurse schedule related commands

5.  Inventory

-   A new DrugInstance object: (addict) is being instantiated with the
    > variable "DRUG_FILE_PATH" which is a constant that stores the
    > location of inventory save data

-   addict.run() is then called to run the instance of command handler
    > for inventory related commands

6.  Bye

-   Updates the value of the boolean variable "isExit" to "true".

7.  Help

-   Calls the method UI.printStartMenu to print a list of helpful
    > commands for the user to view.





<!-- Original Template -->
# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
