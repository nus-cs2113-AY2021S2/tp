# Gerard Tan Wei Kiat’s Project Portfolio Page

---

## Overview
Finux is a Command-Line Interface (CLI) application that allows you to record your expenses, savings and loans all
in one consolidated platform for fast-typists. It enhances the user experience by integrating of different features into one to remove
the hassle of constantly using different applications.

---

## Summary of Contributions

### Code Contribution

Contributions can be found on
[RepoSense](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=gerardtwk&tabRepo=AY2021S2-CS2113T-W09-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

### Contribution to Implementation

#### Savings, RecordList classes

I was tasked to design and build the foundation of Finux’s data structures alongside with Tze Xern. 
During our collaboration, we discussed several approaches that we can adopt in our implementation. 
Some approaches included data structures that were taught back in CS2040C. We then agreed on creating
two separate classes, the first is the RecordList class and the Second is an abstract Record class.
I am responsible for the RecordList class and the Savings subclass.



#### CreditScore Feature
Jason implemented the calculation on the difference between two dates, while Jonah came up with the formula for
credit score calculation.

I implemented the execution of the credit score formula in both CreditScoreCommand and ReturnCommand. 
I resolved several issues including avoiding double counting of the credit score. I also designed the
CreditScoreReturnedLoansMap class and implemented saving of the credit scores into finux.txt, while not disrupting
the existing RecordList save feature implemented by Jonah.

#### FinuxLogger
I implemented the FinuxLogger class so that our team can have a proper way to log Finux error messages into 
a log file, and not let the logging messages appear in the user interface of our application.

#### Displaying of the Loans, Expense and Savings lists.
I implemented the printing of Loans, Expense and Savings lists, for the ListCommand

### Contributions to UG
* Worked on the first version of Explanations for Expense, Loan and Saving record output formats at Section 2.4
* Worked on description for List command at Section 3.2 and Mark a loan as returned at Section 3.4
* Worked on Frequently Asked Questions at Section 4 with Jonah and Andy.
* Helped populate the command summary table at Section 5.

### Contributions to DG
* Worked on RecordList and CreditScoreReturnedLoansMap component.
* Worked on Credit Score Feature


### Contributions to Team-based Tasks
* Helped merge PRs
* Vetting of UG, helped paraphrase a few descriptions and fix broken links.
* Vetting of DG, helped spot a few sequence diagram mistakes.
* Worked on JavaDocs for undocumented classes
* Asked a few probing questions during team meetings that helped with idea generation.

### Contributions Beyond Project Team
*  Helped spot a few bugs during PE dry run. Link at [here](https://github.com/gerardtwk/ped/issues/).
*  Gave peer-review feedback to coursemates in terms of their UG and DG for possible improvement.
*  Gave verbal feedback to other teams on their application.

