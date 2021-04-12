# Lew Poh Chen Douglas - Project Portfolio Page

## Project: All-in-oneNUS

All-in-oneNUS is a desktop application for making university life easier in NUS. 
It has 4 different tools, and is optimized for use via a Command Line Interface (CLI). 
It is written in Java and has about 4 kLoC

Given below are my contributions to the project.


## TeamPlanner
***

###Summary of team planner feature
The feature that I invested a great deal of time and effort into is the ability to add tasks to each team member
and show the tasks(sorted by order of priority) that have been assigned to each team member as this feature involved
using a task manager class for each team member class and each task had to be sorted in order of priority level.
I feel that this feature has a wide range of real world applications as it will allow easy delegation of tasks
and priority ranking of tasks for each team member, especially in a large team setting. Given below are the features
that I have implemented for the team planner.

### Core Features

#### Add team member
Adds a team member to the team. A password prompt will appear and user will have to input the password for the team
member to be added.

#### Delete team member
Deletes a team member from the team. A password prompt will appear and user will have to input the password for the team
member to be deleted.

#### Show team
Shows the current members in the team without the tasks assigned to each team member.

#### Clear team
Clears all the members in the team and all the tasks in the team. A password prompt will appear and user will have to
input the password for the team details to be cleared.
This will prompt the user to re-enter all information fields, such as
the team leader, size of the team, team members, as well as the password.

#### Show commands
Lists the commands available

#### Add a task to a team member
Adds a task to a team member on the team. The output will show the task added to the member with a priority level.
The lower the priority level value, the higher the priority of the task.

#### Delete a task from a team member
Deletes a task from a team member on the team.

#### Mark task as done
Marks a task assigned to a team member as done

#### Show tasks
Displays the tasks assigned to each team member. Tasks with a higher priority for a member will be
higher up the list while tasks with a lower priority will be lower down the list.

***

###Code Contribution:


***

### Documentation

* User Guide
  * Documented features of TeamPlanner

* Developer Guide
  * Overall Architecture for TeamPlanner
  * User stories for TeamPlanner