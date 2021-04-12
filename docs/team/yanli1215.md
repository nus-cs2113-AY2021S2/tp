# Liu Yanli's Project Portfolio Page

## Overview: Project MojoHr
MojoHr is a command line interface that allow the user, HR personnel to clear
emails more efficiently by streamlining the process.
This will help reduce the time spent on clearing emails and allow the user to focus on more productive things.

## Summary of Contributions

### Code Contributed

* Storage part in MojoHr: 
    1. Design the structure of the json file to store emails for an email account;
    2. Load the data from json file to ArrayList with the help of googlecode.json-simple package;
    3. Save the updated emails or password back to the user's json file;
    
* Features implemented:
    1. Delete emails to delete folder;
    2. Archive emails to archive folder;
    3. Find emails by keywords;
    4. Reset the password;
    
Refer to this [link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=yanli&sort=groupTitle&sortWithin=title&since=2021-03-05&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)
to see the contributed code.

### Enhancements implemented
#### 1. DeleteCommand
The delete command allows user to move an email to the delete box or remove an email from delete box forever.

1. If the displayed email list is not delete emails, move the email at the specified `INDEX` to the junk box.
2. If the displayed email list is delete emails, remove the email at the specified `INDEX` from the account forever.

#### 2. ArchiveCommand

The archive command allows user archive a not-archived email to the archive box.

1. If the displayed email list is not archived emails, move the email at the specified `INDEX` to the archive box.
2. If the displayed email list is archived emails, no action will be done.

#### 3. FindCommand
The find command `find KEYWORD`allows users to find emails that containing certain keywords.
1. Extract the keyword from user's input;
2. Look through all emails' subject or content that contains the keyword(case-ignored).
3. Return the emails;


#### 4. Check the validation of the password when resetting the password
1. User should type the old password correctly to gain the authority to modify the password;

2. The new password should not be the same as the old one.

3. The password should meet a certain requirements
4. update the new password in account.json file
5. update the new password in the loginInfo.txt file;

### Documentation
#### 1. User Guide
* Added documentation for the following features `delete`, `archive`, `find`, `reset`

#### 2. Developer Guide
* Added documentation (Architecture, Implementation, Manual Testing) for features `delete`, `archive`, `find`, `reset`

### Contributions to team-based tasks
1. Necessary general code enhancements
2. Maintaining the issue tracker
3. Updating user/developer docs that are not specific to a feature(e.g. user stories, quick start)
