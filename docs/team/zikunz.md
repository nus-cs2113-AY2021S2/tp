# Zhu Zikun - Project Portfolio Page

## Overview

easyLog helps home-based business owners better manage their item inventory and orders through a carefully designed
Command Line Interface (CLI). The features of easyLog fit together to form a cohesive whole, solve the needs and wants
of a clearly specified and narrowed down target user (i.e., home-based business owners) and are optimized for fast
typists.

## Summary of Contributions

### **Code contributed**

My overall code contribution can be
found [here](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=zikunz&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=zikunz&tabRepo=AY2021S2-CS2113T-T09-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)
.

### **Major Enhancements Implemented**
I have implemented large
parts of the final working version of `items add`, `items stats` and
`items update` (in descending order). I have also implemented the full final version of `items clear` and `orders clear`
. I also wrote exhaustive exceptions to deal with all possible "unusual" but not entirely unexpected situations for `items add`, `items update`, `items clear`,
`items stats` and `orders clear` features.
Most major enhancements made by me are for `items add` and `orders clear`.
+ **items add**
    + I checked whether the item description consists of purely empty spaces. If so, a relevant error message will be
      shown to notify that item descriptions cannot be empty.
    + I designed `items add` command to keep asking the users for a valid item unit price
      and item stock. If an invalid input is given, a specific error message will be shown to the users before they
      retry. This is to be consistent with `orders add` feature which keeps asking for a pair of valid of item index
      and item stock.
    + I used BigDecimal rather than float or double as float or double are less suitable for
      monetary calculations due to loss of significance.
    + I rounded all item prices and store them in exactly 2 decimal places (e.g., 10.555 -> 10.56 and 10.554 -> 10.55).

+ **orders clear**
    + After clearing all orders, items belonging to these orders are added back to the item inventory.

### **Contributions to team-based tasks**
+ I checked other teammates' code in terms of code quality and suggested changes, if any.
+ I proofreaded others groupmates work in the documentation and propose changes, if any.
+ I created relevant GitHub issues with an appropriate task definition and assignment.
+ I made some code base for other members to implement their features easily.

### **Review/mentoring contributions**
+ I reviewed some pull requests mostly for documentation changes.
+ I proposed relevant features during meetings.
+ I helped my teammates by answering their questions in all aspects during the course of this module.
+ I coordinated the group to make it work even better together.

### **Contributions beyond the project team**
+ I reported Developer Guide bugs for another team during a tutorial lesson.
+ I reported bugs by testing another group's jar file and propose changes to their User Guide during the Practical Exam
  (Dry Run).
+ I answered some questions in the course forum and helped friends from another team for tutorial questions.

### **Contributions to the User Guide**
Our user guide can be found [here](https://github.com/AY2021S2-CS2113T-T09-4/tp/blob/master/docs/UserGuide.md).
I have written the following parts: Introduction, `items add`, `items update`, `items clear`, `items stats`, `orders clear` and FAQ.

### **Contributions to the Developer Guide**
Our developer guide can be found [here](https://github.com/AY2021S2-CS2113T-T09-4/tp/blob/master/docs/DeveloperGuide.md).
I have written the following parts: Introduction, `Model Component`, `items update`, `Documentation`, `Testing` and `Dev Ops`.
