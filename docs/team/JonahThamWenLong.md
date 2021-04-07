# Jonah Tham Wen Long's Project Portfolio Page

---

## Overview
Finux is a Command-Line Interface (CLI) application that allows you to record your expenses, savings and loans all 
in one consolidated platform. With these information made readily available at your fingertips, it will allow you to 
better adjust your expenditure or work harder towards your savings goal. Finux also includes a way for you to keep 
track of the loans you have made to your friends, or the tabs for the dinners you have paid for first.

As the Finux application is inspired entirely by the *Nix operating systems, and if you are familiar with the CLI 
command interface, you will definitely enjoy the benefits of the application. You will also be able to speed up your 
financial management and planning with the Finux application as compared to the traditional finance management 
applications in the market.

Finux was designed with the intention of speeding up one's finance management by integrating the usual fields in
finance management applications with a new loan and creditscore feature that is implemented by us. Coupled with the
fact that Finux is also made to be cross-platform, users can easily use and port their data over should they decide to
use another personal computer.

---

## Summary of Contributions

### Code Contribution

Contributions can be found on [RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=jonahtwl&tabRepo=AY2021S2-CS2113T-W09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code).

---

### Contribution to Implementation

#### Storage class
As with all applications, our finance management application, Finux, would also require a feature to store its data
locally. I took up this feature during the team's initial discussion when splitting the work. As I had previously found
ways to break my own code during the iP, I have worked around those flaws and strengthened Finux's storage feature.
Instead of solely just checking the identifier of the type, I have augmented it such that the data in the local saved
text file follow a strict regex pattern. By doing so, this will in return prevent the many problems the application
will face when loading the saved file. This method was learnt and adapted from my teammate Mark, and I strengthened his
previous implementation into the one that is currently used by the team. As with the save function, the load function
of the storage class was also implemented by myself. Building on the regex pattern previously, the load function was
designed to only and successfully start when all data are loaded correctly. The intention of that was so that the user's
data have minimal chance of breaking the program nor corrupting his other data. The parts that saved and loaded the 
Hashmap was done up by Gerard when he included the credit score feature in the later iterations of our application. 

#### UI & Finux classes
As I had to start with a working application to write the storage functions and methods, I created the base skeleton
code of both the UI and Finux classes. This is then later also used by the team to be improved and work on to our final
product.

#### Record types and Commands
I have also worked with Mark to come up with a very raw and base commands and record types (expenses, savings, 
loans), as these are also required initially to enable my storage feature to be tested.

---

### Contributions to UG
As with the features implemented, I have documented the storage feature of our application and wrote the introduction
of our application.

Other contributions to the UG are:
* Rewritten the UG to be more user-friendly (added personal touches to the UG) 
* Simplified some explanations
* Added relatable examples to the features (e.g. Mark bought a bread for lunch at $3.45)
* Frequently Asked Questions

---

### Contributions to the DG
I have also documented on the same features implemented by myself on the DG. That being the storage component, this
also includes the object and sequence diagrams. I have also worked with Jason to do up the manual testing section in
Appendix D

---

### Contributions to Team-based Tasks

1. Vetting of UG & DG
1. General code enhancements
1. General editing of language in UG
1. Worked as a shadow for Andy (There to advice and discuss what's next, but behind the scenes) 
1. Bug hunting the team's features and components.
1. Maintained a small portion of issues in the issue tracker 

---

### Contributions Beyond Project Team

1. Bug hunting on other team's applications
1. Discussed with other teams on better ways to improve both our applications
