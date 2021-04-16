# Li Kexuan - Project Portfolio Page

## Overview

easyLog helps home-based business owners better manage their item inventory and orders through a carefully optimized
Command Line Interface(CLI). easyLog can manage logistics related matters faster than using just pen and paper.

## Summary of Contributions

### Code contributed

RepoSense code contribution: <br>
* [My RepoSense Report](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&zFR=false&tabType=authorship&tabAuthor=Cocokkkk&tabRepo=AY2021S2-CS2113T-T09-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)


### Features implemented

1. Items Add feature.
2. Items Update feature.
3. Orders Delete feature.

### Enhancements implemented

1. Items Update feature: <br>
   Ensured easyLog will keep asking users to input the item index to be updated, the item field as well as
   the revised price or stock while executing `items update` command when encountering an error instead of exiting the 
   command causing confusion.
2. Items Stats feature: <br>
   Ensured the number of sales of relevant items will decrease correspondingly when executing `orders delete`
   command to delete an order.
3. Orders delete feature: <br>
   Extracted a method to combine the number of sales will decrease, and the items will be added 
   back to item list when deleting an order,such another teammate can call this method when he implemented another
   feature to improve code re-usability.
4. Exceptions for features: <br>
   Ensured exception can be caught correctly and easyLog will show correct error messages.
5. JUnitTest: <br>
   Added some JUnitTest codes to do testing.

### Contributions to user guide

1. Section 2.1 (Viewing help)
2. Section 2.2.1 (Show items-related commands)
3. Section 2.2.2 (items add feature)
4. Section 2.2.3 (items list feature)
5. Section 2.2.6 (items update feature)
6. Section 2.3.1 (Show orders-related commands)
7. Section 2.3.4 (orders delete feature)


### Contributions to developer guide

1. Section 3.4 (Items Add)
2. Appendix C: Non-Functional Requirements
3. Appendix D: Glossary

### Contributions to team-based tasks

1. Used issue tracker to add necessary issues.
2. Did some smoke-tests to test the features.
3. Added header comments to the non-private classes/methods.
4. Updated user/developer docs that are not specific to a feature.

### Review/mentoring contributions

1. Gave some suggestions to others and tried to answer some questions from others.

### Contributions beyond the project team

Reported bugs in other team's project during PE-Dry [Here](https://github.com/Cocokkkk/ped/issues).
