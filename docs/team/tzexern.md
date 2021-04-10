# Tan Tze Xern's Project Portfolio Page

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

Contributions can be found on 
[RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=tzexern&tabRepo=AY2021S2-CS2113T-W09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

### Contribution to Implementation

#### Record, Loan, Expense classes

I was tasked to do up these simple yet foundational building blocks of our application. I was working with Gerard where
he worked on the remaining building block classes Saving and RecordList. We worked on them as soon as possible as it is
really crucial for other parts of the application where testing requires these classes. 
I have also worked on the inner methods and the `toString()` for output.

#### Validators

Along with Andy and Mark, we have introduced several validators to validate inputs and parameters to make sure that the
values are in the correct format before being utilized. I was responsible for the `validateIndex` to make sure that the
indices given are not symbols, alphabets, negative numbers, unknown symbols, etc. `validateIndex` makes sure that the
index is benign and in the wanted format.

#### RemoveCommand

I've taken over this task from Mark as help was needed to help spread out the workload a bit. This command was partially
done and I included some of my own implementations for better usability. This command is used hand in hand with the
`validateIndex` and hence I took up this.

#### UI

I was responsible for making sure that the output for some commands look consistent and readable. Multiple changes
and improvements have been done throughout the project with peer-review feedbacks in mind.

---

### Contributions to UG

My groupmate Andy has designed the UG skeleton with reference to my 
[individualProject(iP)](https://tzexern.github.io/ip/). \
I have also given feedback with regards on the layout of the UG and made some fixes. \
I'm tasked to finish the `3.5 remove`, `3.6 creditscore` and `3.7 exit` under our `3. Features` section. \
I have also taken all the screenshots used in our UG and updated them whenever necessary.


---

### Contributions to DG

I have provided my team with an improved version of DG skeleton building on top of Mark's. These include proper headers
and hyperlinks after we have finalized our rough template for DG. \
I'm also tasked to complete several subsections of the DG, these include `Introduction`, `Setting Up`, `UI Component`
under `Design`, `Remove Feature` under `Implementation`, `Appendix B: User Stories`, 
`Appendix C: Non-Functional Requirements` and part of `Appendix D: Instructions for Manual Testing`. \
`Appendix D: Instructions for Manual Testing` was done together by me and Jonah.

---

### Contributions to Team-based Tasks

1. Initiated to have a better documentation system to better facilitate each meeting for our team.
1. Contributed in maintaining each meetings' Agenda.
1. Contribtued in maintaining each meetings' Meeting Minutes.
1. Contribtued in maintaining Project Log.
1. Facilitated meetings along with Andy.
1. Made sure that deliverables are submitted and gave proper reminders from time to time.

---

### Contributions Beyond Project Team

1. Gave peer-review feedbacks to coursemates in terms of their UG and DG for possible improvement.
1. Gave verbal feedbacks to other teams on their application.

