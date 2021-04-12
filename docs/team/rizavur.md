# Rizavur - Project Portfolio Page for NUSMaze

## Overview
**NUSMaze** is a Command Line Interface (CLI) based application that aims to **simplify NUS Computer Engineering students’ journey** from one point to another within the NUS Engineering and Computing buildings.
The application allows users to find the shortest route from one block to another, locate the nearest eatery, add personal notes to the location and many more.
The main target audience of NUSMaze are freshmen who are unfamiliar with the campus and need help travelling between Engineering and computing.

## Summary of Contributions
This section shows a brief summary of my contributions to the team project, including coding, documentation and other helpful contribution throughout the development of NUSMaze.

### Code contributed
The link to the code contributed by me can be found
[here](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=09&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=zoom&zFR=false&until=2021-04-06&zA=Rizavur&zR=AY2021S2-CS2113T-T09-2%2Ftp%5Bmaster%5D&zACS=130.1818181818182&zS=2021-03-05&zFS=09&zU=2021-04-06&zMG=undefined&zFTF=commit&zFGS=groupByRepos)

### Enhancements Implemented
#### *User Interface*
I implemented the UI of NUSMaze together with Choi Wonjae (wjChoi0712).<br>

**What it does:** <br>
The UI of NUSMaze provides the users an enjoyable experience as they can easily differentiate between their inputs and the outputs of NUSMaze. The UI of NUSMaze is based on the Command Line Interface.

**Justification:** <br>
The UI is needed to show messages to the user so that they can be affirmed that the application is working correctly or if there are any errors, it will be easier for them to identify what went wrong.
<br>

#### *Command classes*
I implemented the command classes of NUSMaze together with Choi Wonjae (wjChoi0712).<br>

**What it does:** <br>
The command classes of NUSMaze are used to execute the specific commands of the users according to which command they had typed into the command line interface.

**Justification:** <br>
The command classes are needed to clearly differentiate between the various commands that the user wants NUSMaze to execute.
<br>

#### *Show help and venues feature*
I implemented the features to show the help message and to list all possible venues to the user.<br>

**What it does:** <br>
The user may use the `help` command to activate the show help feature which will list down all the possible commands that the user can user in NUSMaze.
The user may use the `show venues` command to activate the show all venues feature which will list down all 40 of the pre-defined venues that the user can use in NUSMaze.

**Justification:** <br>
The show help and venues feature helps new users get accustomed to the application, and it also helps them when troubleshooting any errors.
<br>

#### *Alias feature*
I implemented the alias feature of NUSMaze.<br>

**What it does:** <br>
The user may use the `add alias` command to activate the add alias feature. Upon activation, NUSMaze will prompt the user for a block name and the alias that they wish to set to that block. The application will then store this alias.
The user may use the `show alias` command to activate the show alias feature. Upon activation, NUSMaze will display all the alias names and block pairs that the user has defined thus far.
The user may use the `delete alias` command to activate the delete alias feature. Upon activation, NUSMaze will prompt the user for the alias name that they wish to delete. The application will then remove this alias from the stored list of aliases.

**Justification:** <br>
The user can use their custom defined alias instead of the pre-defined block names when calling the `go` command so as to save time as they would have to type less and the alias might make more sense to them as compared to the pre-defined block names.
<br>

#### *User Data Storage*
I implemented the data storage feature of NUSMaze with Sim Bowen (simbowen), Kimberley (kimideas8) and Choi Wonjae (wjChoi0712). More specifically, I was in charge of the storages for alias and favourites features.<br>

**What it does:** <br>
The storage feature ensures that the user's data for the respective features are saved in the computers memory and can be retrieved even if the user exits and reopens NUSMaze.

**Justification:** <br>
The user can use their saved data to continue customising their NUSMaze experience from where they had previously left off. 
<br>

### Contributions to the UG
I contributed to the information about the alias features namely `Add alias`, `Show alias` and `Delete alias`.

### Contributions to the DG
I contributed to the parts of the DG that describe and explain `UIManager Component`, `Custom Alias Feature` and parts of the `Appendix: Instructions for manual testing`, including the UML diagrams.

### Contributions to team-based tasks
I contributed in the developer testing of NUSMaze by creating JUnit tests ro ensure that NUSMaze runs correctly and any changes in the codebase do not accidentally deviate from the intended outcomes. <br>

### Review contributions
The link to PR reviews by me can be found [here](https://github.com/AY2021S2-CS2113T-T09-2/tp/pulls?q=is%3Apr+is%3Aclosed+author%3ARizavur).

### Contributions beyond the project team

I contributed in helping to improve the Developer Guide for team CS2113T-F08-3 by commenting on their pull request in Week 11 of the project <br>

I contributed in helping to identify bugs for team CS2113-F10-3. My contribution can be found [here](https://github.com/AY2021S2-CS2113-F10-3/tp/issues) (
[1](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/63)
[2](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/64)
[3](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/65)
[4](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/66)
[5](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/67)
[6](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/68)
[7](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/69)
[8](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/70)
[9](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/71)
[10](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/72)
[11](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/73)
[12](https://github.com/AY2021S2-CS2113-F10-3/tp/issues/74)
) <br>
