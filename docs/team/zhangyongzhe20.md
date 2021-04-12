# Zhang Yongzhe - Project Portfolio Page

## 1 Overview

Location Buddy is a command line application for students to search the location of facilities in campus.

## 2 Summary of Contributions

### 2.1 Code Contributed

Access my contribution on [RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=zhangyongzhe20&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=zhangyongzhe20&tabRepo=AY2021S2-CS2113-T10-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other).

### 2.2 Enhancements Implemented

#### 2.2.1 Entity Classes

Designed the structure of our entity classes with an abstract entity called `Facility`, which inherited by `Canteen`, `Library`, `Lecture Theater`.


#### 2.2.2 Storage

I implemented the storage function of Location Buddy, including the considerations, researching of third-party libraries and the development.
The most difficult portion of implementing the storage function was to load the data of different facilities from multiple text files.  We wanted a robust storage system that is resilient to bugs, especially arising from the use of custom delimiters.


#### 2.2.3 Logging
1. Setup logging configuration file `logger.properties`. 
2. Logging all the users' input and error handling messages. 

### 2.3 Contributions to UG

I documented the sections of logging and data storage.

### 2.4 Contributions to the DG

I documented the sections of logging and data storage.

Other contributions to the DG are:
- User Stories
- The sequence diagram of Data Loading 
- Instructions for building jar

### 2.5 Contributions to Team-based Tasks
1. Managed the milestones, issue tracker and releases for team repository.
2. Setup logging configuration file. (Pull Request: [#85](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/86))
3. Pack all data files in Jar. (Pull Request: [#83](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/83))
4. Other Pull Requests:  
   [#79](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/79)
   [#53](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/53)
   [#39](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/39)
   [#19](https://github.com/AY2021S2-CS2113-T10-2/tp/pull/19)

