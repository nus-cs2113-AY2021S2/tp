# Sim Bowen - Project Portfolio Page for NUSMaze

## Overview
**NUSMaze** is a Command Line Interface (CLI) based application that aims to **simplify NUS Computer Engineering students’ journey** from one point to another within the NUS Engineering and Computing buildings. 
The application allows users to find the shortest route from one block to another, locate the nearest eatery, add personal notes to the location and many more. 
The main target audience of NUSMaze are freshmen who are unfamiliar with the campus and need help travelling between Engineering and computing.

## Summary of Contributions
This section shows a brief summary of my contributions to the team project, including coding, documentation and other helpful contribution through the development of NUSMaze.

### Code contributed
The link to the code contributed by me can be found
[here](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=09&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=zoom&zA=SimBowen&zR=AY2021S2-CS2113T-T09-2%2Ftp%5Bmaster%5D&zACS=130.65156794425087&zS=2021-03-05&zFS=09&zU=2021-04-06&zMG=undefined&zFTF=commit&zFGS=groupByRepos&zFR=false&zFT=docs~functional-code~test-code~other&until=2021-04-06).

### Enhancements Implemented
####Routing
I implemented the basic routing functionality together with Choi Wonjae (wjChoi0712).<br>

**What it does:** <br>
The user may use the `go` command to activate the routing feature. Upon activation, NUSMaze will prompt the user for a Starting location and a destination. The application will then run a modified breath first search algorithm using the graph of the map of Computing and Engineering that we have pre-defined and show the user the shortest sheltered route as defined using the official map on NUS website [here](http://map.nus.edu.sg/#page=map&long=103.7725819000000000&lat=1.2979695610000000).

**Justification:** <br>
The routing feature is the main reason for the creation of NUSMaze. The name of the app came about due to our focus on navigation throughout the campus. The routing feature is useful for all users who are unsure of how to travel between the Engineering and Computing faculties. 
<br>

####Daily Route

I implemented the daily route feature of NUSMaze.<br>


**What it does:** <br>
The user may use the `add daily route` command to activate the add daily route function. Upon activation, NUSMaze will prompt the user to choose a day. The application will then prompt the user to enter locations of their activities until the user enters `END`. The day chosen is then mapped to the schedule entered by the user and stored.

The user may use the `show daily route` command to activate the show daily route function. Upon activation, NUSMaze will prompt the user to choose a day that has a schedule tagged to it. Upon user selection, the location of activities and routes to get to there based on the location of the previous activity is shown to the user using the routing function.

The user may use the `delete daily route` command to activate the delete daily route function. Upon activation, NUSMaze will prompt the user to choose a day that has a schedule tagged to it. Upon user selection, the schedule tagged to the day is cleared.

**Justification:** <br>
This is an extension of the routing function and serves to help store the daily schedule of users. This function was implemented to help our main target audience who are freshmen and may not remember their schedule clearly.
<br>

### Contributions to the UG
I contributed to the overall formatting of the document and wrote the content page, Sections 2, 3, 4.5, 5, 6 and 7.

### Contributions to the DG
I contributed to the parts of the DG that describe and explain the implementation of finding the shortest route feature and daily route planning feature, including the UML diagrams.

### Contributions to team-based tasks:
I managed release v1.0 (1 release) on GitHub <br>
I vetted issues and assigned to members accordingly. <br>
I maintained the cohesiveness in language and formatting of the documentations. <br>
I contributed to developer testing for NUSMaze by creating JUnit tests to ensure that the behaviour of the application does not defer from intended.

###Review contributions
The link to PR reviews by me can be found [here](https://github.com/AY2021S2-CS2113T-T09-2/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3ASimBowen+).

### Contributions beyond the project team:
I contributed in helping to identify bugs for other teams which can be found [here](https://github.com/AY2021S2-CS2113-T10-3/tp/issues) (
[1](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/60)
[2](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/59)
[3](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/58)
[4](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/57)
[5](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/56)
[6](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/55)
[7](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/54)
[8](https://github.com/AY2021S2-CS2113-T10-3/tp/issues/53)
)