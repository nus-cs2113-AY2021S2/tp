# Wang Huachen - Project Portfolio Page

## Overview
Connoisseur is a desktop application for managing and storing personal reviews on experiences and recommendations to try next, that you would like to keep. It is a revolutionary app that not only provides an organised user-friendly database, but provides customisable categories to enhance your experience. Through its intuitive command line interface, you will be able to store and access your reviews & recommendation easily.
### Summary of Contributions
#### Code Contributed
My code contribution can be found [here](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=&tabOpen=true&tabType=authorship&tabAuthor=huachen24&tabRepo=AY2021S2-CS2113T-F08-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other). 
#### Basic features implemented
* Ui and Messages class
    * These classes help to compartmentalize the interactions with the user. 
    * Prepares for the future possiblity of implementing GUI, where the output may not be to the terminal. 
* Sorting feature
    * Sorting is a key feature of the reviews mode
    * There are currently 5 methods by which the user can sort their reviews, and each of them have their custom comparator created for the Review object. 
#### Enhancements implemented
* Convert text storage to JSON format
    * Using text to store data could work, but it is very easy to corrupt, especially when all types of characters are allowed in our data. 
    * JSON simplifies this by acting like a dictionary, where we can store data as arrays directly to a keyword. 
* Add price range field to recommendations
* Implement dynamic formatting for whitespace
    * Since we want to display our data in a graphical table, the border characters cannot be hard-coded as they will vary in position with the length of the data. 
    * Implementing a function to calculate the number of whitespaces to append before the border helps dynamically adjust this. 
    * For viewing full reviews, it is natural for the review to be full paragraphs and thus it will exceed the length of the box. Thus, I also implemented a function to split the description field into multiple lines. 
* QOL improvement to allow reattempts after invalid input
    * Before, invalid inputs will be rejected and the user will have to restart their action from the beginning. With this feature, they can simply correct their input and continue with their action, without having to lose their progress. 
* Change display type feature
    * This feature allows the app to use asterisks instead of stars to display ratings, as some users have terminals which have non-monospaced fonts or are unable to parse unicode symbols. 
    * Asterisks are treated as normal characters and are a good workaround to this problem, and this setting can be saved in storage so that they do not need to change this setting everytime the application is restarted. 
    * When the user is somehow able to view the stars after upgrades or reconfigurations, they can easily switch the display type back to stars to fully appreciate the experience. 

#### Contributions to user guide
* Initial commit of the UG
#### Contributions to developer guide
* [Design Section](../DeveloperGuide.md#4-design)
* [Storage Section](../DeveloperGuide.md#54-storage)
* Most of the [UML diagrams](../diagrams)
#### Contributions to team-based tasks
* Set up team repository
* Releases
* Set up milestones and issue tracker
* Set up discord channel for monitoring github activity with webhooks to the team repo and everyone's individual repo
![discord-monitoring](PPP_Screenshots/huachen1.png)
#### Review/mentoring contributions
* [List of reviewed pull requests](https://github.com/AY2021S2-CS2113T-F08-3/tp/pulls?q=reviewed-by%3Ahuachen24)
* Commented on pull requests
    * [#7](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/7)
    * [#35](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/35)
    * [#50](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/50)
    * [#61](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/61)
    * [#78](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/78)
    * [#123](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/123)    
    * [#129](https://github.com/AY2021S2-CS2113T-F08-3/tp/pull/129)

#### Contributions beyond the project team
* Raised [issues](https://github.com/huachen24/ped/issues) on the projects of other groups