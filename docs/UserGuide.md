# MojoHR User Guide
=======

# MojoHr User Guide

## Content Page

1. [Introduction](#introduction)
1. [Quick Start](#quick-start)
1. [Logging in](#logging-in)
    1. [Log in to Main Application](#log-in-to-main-application-1)
    1. [Register as a New User](#register-as-a-new-user-2)
    1. [Exit Application before log in](#exit-application-before-log-in-3)
1. [Features](#features)
    1. [Listing an Email](#listing-an-email-list)
    1. [Opening an Email](#opening-an-email-read)
    1. [Deleting an Email](#deleting-an-email-delete)
    1. [Archiving an Email](#archiving-an-email-archive)
    1. [Finding an Email](#finding-an-email-find)
    1. [Tagging an Email](#tagging-an-email-tag)
    1. [Composing an Email](#composing-an-email-compose)
    1. [Sending an Email](#sending-an-email-send)
    1. [Editing an Email](#editing-an-email-edit)
    1. [Counting Number of Email](#count-number-of-email-number)
    1. [Sorting an Email](#sorting-an-email-sort)
    1. [Resetting the Password](#resetting-the-password-reset)
    1. [Printing the Help Menu](#printing-the-help-menu-help)
    1. [Exiting the Application](#exiting-the-application-bye)
1. [FAQ](#faq)
1. [Command Summary](#command-summary)

## Introduction

The HR department receives many emails from job seekers. A large portion of their day is spent clearing emails. Thus,
our product seeks to allow the user to clear emails more efficiently by streamlining the process. This will reduce the
time spent on clearing emails.

## Quick Start

1. Ensure that you have Java 11 or above installed.

2. Download the latest version of `MojoHr` from [here](https://github.com/AY2021S2-CS2113-W10-2/tp/releases).

3. `cd` to locate the file path of the JAR file that you have downloaded

4. Run the following command: `java -jar [JAR file name]`

## Logging in

### Log in to main application: `1`

Format
`1`

Enter email address: `12312@gmail.com`

Enter password: `5678`

Example of usage:

```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice:
1
Enter email address:
12312@gmail.com
Enter password:
5678
```

### Register as a new user: `2`

**Constrains for Creating of New Account(s)**

**1. Supported email domains for the current version of software are:**

* gmail.com, yahoo.com, outlook.com, hotmail.com.

**2. Password Constrains are:**

* Password should not contain any space.
* Password should contain at least one digit(0-9).
* Password length should be between 8 to 15 characters.
* Password should contain at least one lowercase letter(a-z).
* Password should contain at least one uppercase letter(A-Z).
* Password should contain at least one special character ( @, #, %, &, !, $, etc….).

Format
`2`

Enter email address: `joey@gmail.com`

Enter password: `joey987`

Example of usage:

```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice: 
2
Enter email address:
joey@gmail.com
Enter password:
joey987
```

### Exit Application before log in: `3`

Format
`3`

Example of usage:

```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice: 
3
Logging off... Hope to see you again in MojoHr!

```

## Features

### listing an email: `list`

list different types of emails

Format: `list TYPE`

* The `TYPE` refers to the type of emails they you want to display
* `TYPES` are limited to `list allemails`, `list inbox`, `list archive`, `list deleted`, `list draft`, `list junk`
  , `list sent`
* If you are a new user, you will have to compose some emails, if not email account is empty and `list TYPE` will return
  be empty

Example of usage

```
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
3. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
```

### opening an email: `read`

Format: `read INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* User must `list TYPE` first before they can read an email.

Example of usage:

````
____________________________________________________________
Enter Command:
list Inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
3. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
Enter Command:
read 1
____________________________________________________________
[Inbox][READ]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
|| Content: 
C1
____________________________________________________________
````

### Deleting an email: `delete`

Delete an email to the delete box or remove an email from delete box forever.

Format: `delete INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

* If the displayed email list is not delete emails, move the email at the specified `INDEX` to the junk box.
* If the displayed email list is delete emails, remove the email at the specified `INDEX` from the account forever.

Example of usage:

````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
3. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
Enter Command:
delete 3
____________________________________________________________
Move this email to deleted folder
____________________________________________________________
Enter Command:
list deleted
____________________________________________________________
1. [Deleted][UNREAD]
|| Subject: This is subject 3
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T08:30:00
|| Tags: [CS2113]
2. [Deleted][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: [School]
3. [Deleted][UNREAD]
|| Subject: This is subject 8
|| From: 12312@gmail.com --> To: [11111@gmail.com]
|| Time: 2021-02-20T13:30:00
|| Tags: [IMPT]
4. [Deleted][UNREAD]
|| Subject: This is subject 11
|| From: 21312@gmail.com --> To: [12312@gmail.com, 12313@gmail.com, 12314@gmail.com]
|| Time: 2021-02-20T16:30:00
|| Tags: []
5. [Deleted][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
6. [Deleted][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
````

### Archiving an email: `archive`

Archive a not-archived email to the archive box.

Format: `archive INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

* If the displayed email list is not archived emails, move the email at the specified `INDEX` to the archive box.
* If the displayed email list is archived emails, no action will be done.

Example of usage:

````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
Enter Command:
archive 1
____________________________________________________________
Move this email to archive folder
____________________________________________________________
Enter Command:
list archive
____________________________________________________________
1. [Archive][UNREAD]
|| Subject: This is subject 5
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T10:30:00
|| Tags: []
2. [Archive][UNREAD]
|| Subject: This is subject 6
|| From: 11312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T11:30:00
|| Tags: []
3. [Archive][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: []
4. [Archive][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
````

### Finding an email: `find`

Find emails that contain a certain keyword.

Format: `find KEYWORD`
* The `KEYWORD` refers to the keyword that the email's subject or content should contain.
* The `KEYWORD` can be any non-empty string.
* The `KEYWORD` is case-ignored during the find.

Example of usage:

````
____________________________________________________________
Enter Command:
list deleted
____________________________________________________________
1. [Archive][UNREAD]
|| Subject: This is subject 5
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T10:30:00
|| Tags: []
2. [Archive][UNREAD]
|| Subject: This is subject 6
|| From: 11312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T11:30:00
|| Tags: []
3. [Archive][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: []
4. [Archive][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
Enter Command:
find 11
____________________________________________________________
1. [Deleted][UNREAD]
|| Subject: This is subject 11
|| From: 21312@gmail.com --> To: [12312@gmail.com, 12313@gmail.com, 12314@gmail.com]
|| Time: 2021-02-20T16:30:00
|| Tags: []
____________________________________________________________
````

### tagging an email: `tag`

Tag an email with labels

Format: `tag INDEX TAG1 TAG2 ...`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `TAG#` is a single word label that user wants to add.
* User can add multiple tags to their email.
* New tags overwrite old tags.
* To remove tags, leave the tag field empty, i.e. `tag INDEX`
* User must `list TYPE` first before they can tag an email.

Example of usage:

````
____________________________________________________________
1. [Inbox][READ]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
3. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
____________________________________________________________
Enter Command:
tag 1 CS2113 PE
____________________________________________________________
You have successfully set the following tags [CS2113, PE]
____________________________________________________________
````

### composing an email: `compose`

Compose an email which will be saved to draft. The software will prompt user to enter the necessary details.

Format: `compose`

* The program will ask for receiver's email, email subject and content, and user should enter accordingly
* User must enter `/end` to signify that it is the end of content

Example of usage:

```
____________________________________________________________
Enter Command:
compose
____________________________________________________________
Please enter the details below in the correct order:
To:
Subject:
Content:
You can send to multiple recipents by appending email address with ";"
e.g: Alice@gmail.com;Bob@gmail.com
You should end content by typing "/end" in a newline
____________________________________________________________
test@gmail.com
testSubject
Dear Sir,

This is test content.

Regards,
user
/end
____________________________________________________________
Email saved to draft at 2021-04-02T18:50:14
____________________________________________________________
```

### sending an email: `send`

Sends email(s) from draft

Format: `send INDEX/MULTIPLE INDICES`

* The `INDEX` refers to the index number of email in the draft list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `MULTIPLE INDICES` refers to the option of sending multiple emails in the draft list by separating each index with
  a space
* User must `list draft` first before they can send an email
* User must ensure that the email address of receiver exists in MojoHR's system.

Example of usage:

```
____________________________________________________________
Enter Command:
list draft
____________________________________________________________
1. [Draft][UNREAD]
|| Subject: This is subject 3
|| From: 12312@gmail.com --> To: [test@yahoo.com]
|| Time: 2021-02-20T08:30:00
|| Tags: []
2. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T15:30:09
|| Tags: []
____________________________________________________________
Enter Command:
send 1
____________________________________________________________
Email successfully sent to: [test@yahoo.com] at 2021-04-12T17:08:17
____________________________________________________________
```

### Editing an email: `edit`

Edits an email in draft

Format: `edit INDEX`

* The `INDEX` refers to the index number of email in the draft list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* User must `list draft` first before they can send an email
* The program will ask user if they want to edit the receiver's email, subject or content
* User should enter `to`, `subject`, or `content` when prompted and immediately enter the parts that the user wish to
  edit
* If user wants to edit content, remember to enter `/end` to signify that it is the end of content

Example of usage:

```
____________________________________________________________
Enter Command:
list draft
____________________________________________________________
1. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T15:30:09
|| Tags: []
____________________________________________________________
Enter Command:
edit 1
____________________________________________________________
What would you like to edit? It must be one of [to, subject, content].
to
test@gmail.com
Email "to" successfully edited.
____________________________________________________________
```

### count number of email: `number`

Counts the number of a specific type of email

Format: `number TYPE`

* The `TYPE` refers to the types of email.
* Example of `TYPE`: `inbox, archive, deleted, draft, junk, sent, and allemails. 'Emails' refer to all emails

Example of usage:

```
____________________________________________________________
Enter Command:
number inbox
____________________________________________________________
You have a total of 3 INBOX emails
____________________________________________________________
```

### sorting an email: `sort`

Sorts order of emails according to time or Lexicographic order of sender's email and prints them out.

Format: `sort TYPE`

* The `TYPE` refers to the types of sorting methods.
* Types of sorting methods: sender, time

Example of usage:

```
____________________________________________________________
Enter Command:
sort time
____________________________________________________________
Emails are sorted according to time
1. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: S2
|| From: testA@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
3. [Inbox][UNREAD]
|| Subject: S1
|| From: testC@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-04-09T13:08:33
|| Tags: []
4. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T15:30:09
|| Tags: []
5. [Deleted][UNREAD]
|| Subject: This is subject 11
|| From: 21312@gmail.com --> To: [12312@gmail.com, 12313@gmail.com, 12314@gmail.com]
|| Time: 2021-02-20T16:30:00
|| Tags: []
6. [Deleted][UNREAD]
|| Subject: This is subject 8
|| From: 12312@gmail.com --> To: [11111@gmail.com]
|| Time: 2021-02-20T13:30:00
|| Tags: [IMPT]
7. [Sent][UNREAD]
|| Subject: This is subject 7
|| From: 12312@gmail.com --> To: [12332@gmail.com]
|| Time: 2021-02-20T12:30:00
|| Tags: [CS2113, IMPT]
8. [Archive][UNREAD]
|| Subject: This is subject 6
|| From: 11312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T11:30:00
|| Tags: []
9. [Archive][UNREAD]
|| Subject: This is subject 5
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T10:30:00
|| Tags: []
10. [Deleted][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: [School]
11. [Archive][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: []
12. [Deleted][UNREAD]
|| Subject: This is subject 3
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T08:30:00
|| Tags: [CS2113]
13. [Draft][UNREAD]
|| Subject: This is subject 3
|| From: 12312@gmail.com --> To: [test@yahoo.com]
|| Time: 2021-02-20T08:30:00
|| Tags: []
14. [Deleted][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
____________________________________________________________
```

### Resetting the password: `reset`

Reset the password for the user's email account.

Format: `reset`

* The program will aks for the old password from user.
* If the old password is correct, the program will ask for the new password from user.
* The number of wrong attempt is 3.
* If the old password is wrong for 3 times, the program will back to main menu asking for command.
* The new password should meet the following requirements:
   1. Password should not be the same as the old one.
   2. Password should not contain any space.
   3. Password should contain at least one digit(0-9).
   4. Password length should be between 8 to 15 characters.
   5. Password should contain at least one lowercase letter(a-z).
   6. Password should contain at least one uppercase letter(A-Z).
   7. Password should contain at least one special character ( @, #, %, &, !, $, etc….)

Example of usage:

```
____________________________________________________________
Enter Command:
reset
____________________________________________________________
Please enter your old password:
12312
Sorry your old password is wrong. Please try again!(2 times left!)
____________________________________________________________
Please enter your old password:
5678
____________________________________________________________
Please be careful!
* Password should not contain any space.
* Password should contain at least one digit(0-9).
* Password length should be between 8 to 15 characters.
* Password should contain at least one lowercase letter(a-z).
* Password should contain at least one uppercase letter(A-Z).
* Password should contain at least one special character ( @, #, %, &, !, $, etc….).
Please enter your new password:
Aa12312
____________________________________________________________
Your password has changed successfully!
____________________________________________________________
```

### Printing the help menu: `help`

Displays the list of commands and how to use them

Format: `help`

Example of usage:

```
____________________________________________________________
Enter Command:
help
____________________________________________________________
Hello! I'm MojoHR
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|
What can I do for you?
> Use the keyword "LIST (type) " to print the emails by types
!!! type must be one of: [allemails, inbox, archive, deleted, draft, junk, sent]!!!
> Use the keyword "READ (index) " to open the selected email
> Use the keyword "COMPOSE " to create a draft email
> Use the keyword "SEND (index of draft) " to send email in the draft folder
> Use the keyword "DELETE (index) " to delete the selected email
> Use the keyword "FIND (keyword) " to find the  email by keywords
> Use the keyword "ARCHIVE (index) " to move the selected email to the archive folder
> Use the keyword "TAG (index)" to select the email for tagging labels
> Use the keyword "RESET" to reset the your account password
> Use the keyword "HELP" to print the menu
> Use the keyword "BYE" to exit
____________________________________________________________
```

### Exiting the application: `bye`

Exits the application

Format: `bye`

Example of usage:

```
____________________________________________________________
Enter Command:
bye 
____________________________________________________________
Logging off... Hope to see you again in MojoHr!

```

## FAQ

**Q**: How can I send emails to others?

**A**: Firstly, you should compose an email as a draft. Then, send the draft by `send index`.

**Q**: Can I edit the data files outside the software?

**A**: Users are not advised to edit data files as it would potentially corrupt them. Furthermore, in future versions,
data files should be encrypted for security purpose.

**Q**: What are the supported email domains?

**A**: The supported email domains for the current version of software are 
[gmail.com, yahoo.com, outlook.com, hotmail.com]. More email domains would be supported
in future versions.

## Command Summary

* List emails by type `list TYPE`
* Opening an email to see the content `read INDEX`
* Composing an email: `compose`
* Sending email(s): `send INDEX/MULTIPLE INDICES`
* Edit an email: `edit INDEX`
* Delete emails to junk box `delete INDEX`
* Find emails by keywords `find KEYWORD`
* Archive emails `archive INDEX`
* Tagging an email: `tag INDEX`
* Get number of emails by type `number TYPE`
* Sort order of emails by type `sort TYPE`
* Reset the account's password `reset`
* Print help menu `help`
* Exit application `bye`

Action | Format, Examples
--------|------------------
**list** | `list TYPE` e.g., `list inbox`
**read** | `read INDEX` e.g., `read 1`
**compose** | `compose`
**send** | `send INDEX/MULTIPLE INDICES` e.g., `send 1`, `send 1 2`
**edit** | `edit INDEX` e.g., `edit 1`
**delete** | `delete INDEX` e.g., `delete 1`
**find** | `find KEYWORD` e.g., `find content`
**archive** | `archive INDEX` e.g., `archive 1`
**tag** | `tag INDEX` e.g., `tag 1`
**number** | `number TYPE` e.g., `number archive`
**sort** | `sort TYPE` e.g., `sort time`
**reset**| `reset`
**help**| `help`
**bye**| `bye`

| Command             | Example                                                                                                    |
|---------------------|------------------------------------------------------------------------------------------------------------|
| **Login**           |
|log in               | Enter Choice: `1`  <br/> Email Address: `12321@gmail.com` <br/> Password:`5678`
|Register as new user | Enter Choice: `2`  <br/> Email Address: `joey@gmail.com` <br/> Password:`9999`
|Log out              | Enter Choice: `3`
| **List
Command**    |                                                                                                            |
|all emails           | `list allemails`
|inbox                | `list inbox`
|archive              | `list archive`
|deleted              | `list deleted`
|draft                | `list draft`
|junk                 | `list junk`
|sent                 | `list sent`
| **Compose Command** |
|compose              | `compose` <br> `example@gmail.com` <br> `example subject` <br> `example content` <br> `/end`
| **Edit Command**    |
|edit                 | `edit INDEX`
|*to*                 |`to` <br> `newExample@gmail.com` <br>
|*subject*            |`subject` <br> `new example subject` <br>
|*content*            |`content` <br>`this is new example content` <br> `/end`
| **Send Command**    |
|send                 | `send INDEX/MULTIPLE INDICES`
| **Read Command**    |
|read                 | `read INDEX`
| **Delete Command**    |
|delete                 | `delete INDEX`
| **Archive Command**    |
|archive                 | `archive INDEX`
| **Find Command**    |
|find                 | `find KEYWORD`
| **Tag Command**     |
|tag                  | `tag INDEX TAG1 TAG2 ...`
| **Number Command**  |
|all emails           | `number allemails`
|inbox                | `number inbox`
|archive              | `number archive`
|deleted              | `number deleted`
|draft                | `number draft`
|junk                 | `number junk`
|sent                 | `number sent`
| **Sort Command**    |
|time                 | `sort time`
|sender               | `sort sender`
| **Reset Command**    |
|reset                | `reset`
| **Help Command**    |
|help                 | `help`
| **Bye Command**     |
|bye                  | `bye`       
       