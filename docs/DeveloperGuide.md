###Storage component
The storage component is responsible for creating and loading modules and their respective data, as well as saving the data each time a change is made. It consists of two components:

The Loader,
* Loads the list of modules from the “Data” directory
* Loads lesson and task data from the selected module’s “.txt” file

The Writer,
* Creates all the directories required 
* Deletes files and directories
* Creates the “.txt” file that saves the module’s lessons and tasks
* Writes changes to the “.txt” file that saves the module’s lessons and tasks

Structure of storage:
* Data directory
    * Module directory
        * Module data text file
        * Cheat-sheet directory
            * Cheat-sheet text file
    
&nbsp; &nbsp;
###Common classes
Classes that are used by multiple components:
* CommonMethods: Stores methods that are used by multiple components
* Constants: Stores constants
* Messages: Stores strings that are printed by the UI
* DashboardCommands: Enum of commands that can be used outside a module
* ModuleCommands: Enum of commands that can be used inside a module
