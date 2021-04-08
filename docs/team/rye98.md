# Shuhao (Rye98) - Project Portfolio Page for NUSMaze

## Overview
**NUSMaze** is a Command Line Interface (CLI) based application that aims to **simplify NUS Computer Engineering students’ journey** from one point to another within the NUS Engineering and Computing buildings.
The application allows users to find the shortest route from one block to another, locate the nearest eatery, add personal notes to the location and many more.
Although this application is targeted mainly at Engineering and Computing freshman, this app can provide help to anyone trying to navigate through the engineering and computing blocks.

## Summary of Contributions
This section shows a brief summary of my contributions towards the **NUSMaze** project.

### Code Contributed
The link to the code contributed by me can be found 
[here](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=09&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)

### Enhancements implemented

#### History
I implemented the history feature, which acts as a storage to keep track of 10 of the most recent route searches.

**What it does:**

When a user finishes the  `go` command with valid inputs, a string containing the starting block and destination block is immediately stored into an `<ArrayList>`.

**Justification:**

The user can choose to repeat a route search, which had been done via the `go` command in the past, without the need to repeat the `go` command process nor keying in the possibly long destination names.

#### Favourites

Together with Choi Wonjae (wjChoi0712), we implemented the `favourites` feature.

**What it does:**

This allows the user to save favourite routes consisting of a starting block, and a destination block.

**Justification:**

Due to the `history` feature only storing 10 of the most recent searches, this `favourites` feature allows users to store additional important routes, and these routes will not be deleted (unless the user invokes the `delete favourite` command). This allows the user to store additional routes without going through the `go` command, and without worrying about exceeding the storage capacity of the app.

#### Contributions to User Guide

I contributed to the information under **features**, namely the `history` and `favourite route` features.

#### Contributions to Developer Guide

I contributed to the information under **features**, namely the `history` and `favourite route` features.

#### Contributions to team-based tasks

I added some JUnit tests for the `history` and `favourites` to ensure that the implementations of methods from these two classes are working as intended when additional code is added.

#### Review Contributions

The link to PR reviews by me can be found [here](https://github.com/AY2021S2-CS2113T-T09-2/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3ARye98+).

### Contributions beyond the project team:

I contributed in helping to identify potential bugs in other team's project, which can be found [here](https://github.com/AY2021S2-CS2113-F10-2/tp): (
[1](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/128), 
[2](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/127), 
[3](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/126), 
[4](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/125), 
[5](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/124), 
[6](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/123), 
[7](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/122), 
[8](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/121), 
[9](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/120), 
[10](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/119), 
[11](https://github.com/AY2021S2-CS2113-F10-2/tp/issues/118)
)