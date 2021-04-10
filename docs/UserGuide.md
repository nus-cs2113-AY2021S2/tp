# Connoisseur User Guide

## Table of Contents

1. [Introduction](#1-introduction)
2. [About this Guide](#2-about-this-guide)

   2.1 [What is in Connoisseur](#21-what-is-in-connoisseur)

   2.2 [How to use this Guide](#22-how-to-use-this-guide)

3. [Quick start](#3-quick-start)
4. [Features](#4-features)

   4.1 [Review Mode](#41-review-mode)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.1 [Add a Review](#411-adding-a-review)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.2 [List Reviews](#412-list-reviews)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.3 [Sort Reviews](#413-sort-reviews)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.4 [View a Review](#414-view-a-review)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.5 [Edit a Review](#415-edit-a-review)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1.6 [Delete a Review](#416-delete-a-review)

   4.2 [Recommendation Mode](#42-recommendation-mode)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2.1 [Add a Recommendation](#421-adding-a-recommendation)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2.2 [List Recommendation](#422-list-recommendation)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2.3 [Edit a Recommendation](#423-edit-a-recommendation)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2.4 [Delete a Recommendation](#424-delete-a-recommendation)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2.5 [Review a Recommendation](#425-review-a-recommendation)

   4.3 [View Help](#43-view-help)

   4.4 [Exit and Save](#44-exit-and-save-connoisseur)
5. [Command Summary](#5-command-summary)
6. [FAQ](#6-faq)

## 1. Introduction

Welcome to the user guide for our application, Connoisseur!
With over 4.6 thousand restaurants in Singapore, endless number of entertainment options and never-ending list of
streaming shows and movies, to watch many of us are left deciding for a long time on what is worthwhile spending our
limited leisure time on. Fret-not!

Connoisseur is a desktop application for managing and storing personal reviews on experiences and recommendations to try
next, that you would like to keep. It is a revolutionary app that not only provides an organised user-friendly database,
but provides customisable categories to enhance your experience. Through its intuitive command line interface, you will
be able to store and access your reviews & recommendation easily.

## 2. About this Guide

This guide gives you an overview of the features in Connoisseur and shows you how to get started using Connoisseur.
Choose a link in the [Feature](#table-of-contents) section to get a step-by-step instruction, and understand how to use
Connoisseur.

### 2.1 What is in Connoisseur

In our Review mode, you can add a review about an experience, rate it out of 5 stars, delete or edit a review, view the
entire list of your reviews or one particular review. You can also sort the list from the highest to the lowest rating, by
category, title and date of entry.

For our Recommendation mode, you can have a list of things you would like to try, the location and the price range of
the experience. Already tried out the experience? You can now move it to your review list in the review mode and
record your thoughts on how good or bad the experience was.

### 2.2 How to use this Guide

The following formats are used in this document:

* A grey highlight (called a mark-up) indicates a keyword. It is often used to indicate i) a field or command that can be typed into the 
  command line and executed by Connoisseur; or ii) the prompts displayed by Connoisseur. <br> e.g.`list [SORTING METHOD]`
* Words in UPPER CASE in square bracket [USER INPUT] are the fields to be supplied by the user.<br> e.g.
  in `list [SORTING METHOD]`
  SORTING METHOD is the field input by the user and examples of valid commands are:`list rating`,`list title` etc.
* Word in lower case are given commands. <br> e.g. in `new [quick | long]` the user can input either the command
  `new quick`or `new long`
* <span>&#10071;</span> symbol will be followed by additional information to take note of for that section.
* A light blue font color indicates a Hyperlink that you can click on and be transferred to the corresponding section 
  in Connoisseur.<br> e.g. [How to use this Guide](#22-how-to-use-this-guide) 

## 3. Quick Start

If you are tired of lengthy and problematic installation processes, Connoisseur is perfect for you. The setup is minimal
and can be completed in a few simple steps. Follow the instructions below to try it out!

1. Ensure that you have Java 11 or above installed. The latest version of Java can be found
   [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
2. Download the latest version of Connoisseur from [here](https://github.com/AY2021S2-CS2113T-F08-3/tp/releases). To do
   so, look for the file connoisseur.jar and click on it. Please refer to Figure 1 if you require assistance with
   locating the file. Figure 1 shows how to download version 2.1 of Connoisseur. Connoisseur.jar has been highlighted in
   red for your convenience.   
   ![Figure 1 - How to download Connoisseur](./images/ug/jarfile.png)
   Figure 1. How to download Connoisseur

3. Copy the file to the folder you want to use as the _home folder_ for Connoisseur
   ![Figure 2 - Copying connoisseur.jar into a folder](./images/ug/downloading1.PNG)
   <p text-align="center">Figure 2. Copying connoisseur.jar into a folder</p>
4. Open terminal and navigate to the directory of the folder you just copied into.
5. In your terminal, type `java -jar Connoisseur.jar` and press enter. This should start Connoisseur.
   ![Figure 3 - Starting Connoisseur](images/ug/downloading2.png)
   <p align="center">Figure 3. Starting Connoisseur</p>
6. You may now use Connoisseur by typing in commands and pressing Enter to execute it. Refer to
   the [Command summary](#5.-command-summary) for a list of recognised commands.
7. You should notice a new _data folder_ created in the _home folder_ you have chosen in step 3 The data for
   Connoisseur is saved in `connoisseur.json` in the _data folder_.

## 4. Features

This section covers all the commands that you can type into the Command Box of Connoisseur when it prompts you -
`Please enter a command: `

The commands are categorised into the two modes offered by Connoisseur, Review and Recommendation mode. If it is the
first time that you are using the command, we recommend that you refer
to [How to use the Guide](#22-how-to-use-this-guide) to better interpret the format of the commands.

### 4.1 Review Mode

Connoisseur is in Review mode by default. In this mode you can maintain a list of reviews of experiences of any
category. The review mode can be accessed using the `review` command as shown in the figure below.

![img_1.png](images/ug/review_mode.png)
<p align="center">Figure 4. Entering 'Review' mode</p>
<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are 
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> This command is case-insensitive.
#### 4.1.1 Adding a Review

This feature allows you to add a new review. There is a choice of quick review or full review.

Command: `add [quick | full]`, `new [quick | full]`<br>
`[quick | full]` : optional arguments to specify quick or full review. <br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the two words in the command. <br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

If quick review is specified, Connoisseur will then prompt you to enter the title, category and rating of the review, as
shows in _Figure 5_.<br />

![img_2.png](images/ug/quick_Review.png)
<p align="center">Figure 5. Adding a quick review </p>

If full review is specified, there is an additional prompt to input description of the experience as shown in _Figure 6_
![img_3.png](images/ug/full_review.png)
<p align="center">Figure 6. Adding a full review </p>

If you do not specify `[quick | full]` and simply input the command: `add` or `new`, Connoisseur will ask you to
specify if you would like to input a quick review. Input the command: `y` for quick review or `n` for full review
 as shown in _Figure 7_.<br />

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the 'add' or 'new' command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The commands are case-insensitive. <br>

<span>&#10071;</span> Ensure when typing 'y' or 'n' command do not type any additional blank spaces. Otherwise, Connoisseur will 
detect an invalid command and prompt you to enter y/n again <br>

![img_4.png](images/ug/add_Review.png)
<p align="center">Figure 7. Adding a quick or long review </p>

<span>&#10071;</span> Ensure the rating is an integer whole number from 0 to 5. Inputting -0 is treated as 0 and is not an invalid number.
If you input an invalid number Connoisseur will prompt you until a valid number is input. <br />

<span>&#10071;</span> Ensure the title of the review added is unique and does not already exist in the list. Connoisseur 
checks for duplicate by comparing spelling, and the number of blank spaces in between words in the title. Refer to table 1 below for examples.
If you attempt to add a pre-existing review title, Connoisseur will prompt you of the existence of duplicate in the list and ask you 
to enter a unique title. <br>

![img.png](images/ug/guidelines_duplicate_titles.png)
Table 1. Guidelines on duplicate and unique title

#### 4.1.2 List Reviews

This feature allows you to view a list of all your reviews. You can specify a one-off sorting method by which to sort
the reviews.

Command: `list [SORTING METHOD]`

`[SORTING METHOD]` : (optional argument) temporary sort method by which to sort the reviews. Leaving this blank would
allow Connoisseur to use the saved _sort method_ (refer to [4.1.3](#413-sort-reviews)) as shown in Figure 8. Currently, supported methods are:

* `title`
* `category`
* `rating`
* `earliest`
* `latest`
  
<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the commmand. If blank spaces are
  typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'list' is case-insensitive. On the other hand, when inputting sorting method ensure it is in lower case.<br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the two words in the command. <br>

![img_5.png](images/ug/list_rating.png)
<p align="center">Figure 8. Listing Reviews </p>

<span>&#10071;</span> Some terminals may not support the ★ and ✰ symbols. So if you face the error as shown in Figure
9, where the ratings are not displayed correctly, input the command `display asterisks` as shown in Figure 10. The
error should be resolved, and the ratings will now be displayed using `*` symbol instead. To switch back to displaying 
★ and ✰ symbols input the command `display stars`

![img_8.png](images/ug/invalid_character.png)
<p align="center">Figure 9. ★ and ✰ symbols not displayed</p>

![img_6.png](images/ug/list_review.png)
<p align="center">Figure 10. display asterisks command</p>

<span>&#10071;</span> The command 'display' is case-insensitive. On the other hand, when inputting display method 
(either 'asterisks' or 'stars') ensure it is in lower case.<br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the two words in the command. <br>


#### 4.1.3 Sort Reviews

This feature allows you to change the saved sorting method as shows in Figure 11.

Command: `sort [SORTING METHOD]`

`[SORTING METHOD]` : sort method to be used. Default sorting method is `latest`. Refer [above](#4.1.2-list-reviews) for
a list of recognised sorting methods.

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'sort' is case-insensitive. On the other hand, when inputting sorting method ensure it is in lower case.<br>

![img_9.png](images/ug/sort_title.png)
<p align="center">Figure 11. Changing Sorting method to title</p>

<span>&#10071;</span> Ensure you do not enter a sorting method that does not exist. Otherwise Connoisseur will warn you
that with an invalid sorting method message.

#### 4.1.4 View a Review

This feature allows you to view all the details of the specified review as shown in Figure 12.

Command: `view [TITLE_OF_REVIEW]`

`[TITLE_OF_REVIEW]` : title of review that you want to view.

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'view' is case-insensitive.<br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the 'view' and 
'TITLE_OF_REVIEW'  in the command. <br>

![img_10.png](images/ug/view_review.png)
<p align="center">Figure 12. Viewing a Review </p>

<span>&#10071;</span> Ensure the title of the review you want to view already exists in your lists of reviews. Otherwise, Connoisseur will 
prompt you saying that no such review exits. When typing the title you want to view, ensure spelling, and the number of blank spaces in between words is the same as the title in the list.

<span>&#10071;</span> When adding a review, if you did not put in a description for it, the text "No description entered." will appear when viewing the review.

#### 4.1.5 Edit a Review

This feature allows you to make edits to the Title / Category / Rating / Description of the review in your list. <br />

Command : `edit [TITLE_OF_REVIEW] `

`[TITLE_OF_REVIEW]` : title of review that you want to edit.

<span>&#10071;</span> Ensure the title of the review you want to edit already exists in your lists of reviews.
Otherwise, Connoisseur will prompt you saying that no such review exits. When typing the title you want to edit, ensure spelling and the number of blank spaces in between words is the same as the title in the list.

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'edit' is case-insensitive.<br>

<span>&#10071;</span> When extra blank spaces are typed in between the 'edit' and
'TITLE_OF_REVIEW' in the command, Connoisseur will detect it as an invalid command. <br>

As shown in Figure 13 below, Connoisseur will prompt you asking whether you would like to make changes to Title /
Category / Rating / Description. Input either `Title`,`Category`, `Rating` or `Description`.<br>

<span>&#10071;</span> These inputs are case-insensitive and Connoisseur will ignore black spaces typed before or after the inputs.<br>

<span>&#10071;</span> When editing the title, Connoisseur will check for duplicates in the review list. If the changes
made is a duplicate, Connoisseur will prompt you to enter a unique title.

If you would like to continue to make edits to the review, input `y`. Otherwise, input `n`.

Before exiting the _edit_ feature, you have the option to update the date of entry to reflect the date and timing in
which the edit was made. Input `y` if you would like to do so. Otherwise, input`n`.

<span>&#10071;</span> Inputs 'y' and 'n' are case-insensitive. <br>

<span>&#10071;</span> Ensure when typing 'y' or 'n' command do not type any additional blank spaces. Otherwise, Connoisseur will
detect an invalid command and prompt you to enter 'y' or 'n' again <br>

![img_12.png](images/ug/edit_Review.png)
<p align="center">Figure 13. Editing a Review </p>

#### 4.1.6 Delete a Review

This feature allows you to delete a review from your list as shown in Figure 14.

Command: `delete [TITLE_OF_REVIEW]`

`[TITLE_OF_REVIEW]` : title of review that you want to delete.


<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'delete' is case-insensitive.<br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the 'delete' and
'TITLE_OF_REVIEW' in the command. <br>


![img_14.png](images/ug/delete_Review.png)
<p align="center">Figure 14. Deleting a Review </p>

<span>&#10071;</span> Ensure the title of the review you want to delete already exists in your lists of reviews.
Otherwise, Connoisseur will prompt you saying that no such review exits. When typing the title you want to delete, ensure spelling and the number of blank
spaces in between words is the same as the title in the list.

### 4.2 Recommendation Mode

Connoisseur is in Review mode by default. The Recommendation mode can be accessed using the `reco` command when
Connoisseur prompts - `Please enter a command:` as shown in Figure 15. In this mode you can maintain a list of
recommendation of experiences you would like to try in the future. To go back to Review mode, you can use the `review`
command.

<span>&#10071;</span> This command is case-insensitive.

![img_16.png](images/ug/switching_mode.png)
<p align="center">Figure 15. Switching between Review and Recommendation Mode</p>

#### 4.2.1 Adding a Recommendation

This feature allows you to add a new recommendation.

Command: `add ` or `new `

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> Commands 'add' and 'new' are case-insensitive.

Connoisseur will then prompt you to enter the title, category, price range of recommendation, recommended by and where
it is located at as shown in Figure 16.

![img_18.png](images/ug/add_reco.png)
<p align="center">Figure 16. Adding a Recommendation</p>

<span>&#10071;</span>Price range should be numbers up to 2 decimal places between 0.00 to 9999.99 and separated by '-'. If you
input more than 2 decimal places, Connoisseur will round up to the nearest 2 decimal places.

<span>&#10071;</span> Ensure the title of the recommendation added is unique and does not already exist in the list. Connoisseur
checks for duplicate by comparing spelling, and the number of blank spaces in between words in the title. Refer to table 1 in [section 4.1.1](#411-adding-a-review) for examples.
If you attempt to add a pre-existing recommendation title, Connoisseur will prompt you of the existence of duplicate in the list and ask you 
to enter a unique title. <br>

<span>&#10071;</span> If you try to add a Recommendation title that already exists in your Review list, Connoisseur will
warn you. Perhaps you had forgotten that you have already experienced and reviewed the item in the past!
Not to worry, Connoisseur will ask you if you want to exit *adding a recommendation*. Input `y` to exit. 

#### 4.2.2 List Recommendation

This feature allows you to view a list of all your recommendations as shown in Figure 17.

Command: `list`

![img_19.png](images/ug/list_Reco.png)
<p align="center">Figure 17. Listing Recommendations</p>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> 'list' command is case-insensitive.


#### 4.2.3 Edit a Recommendation

This feature allows you to make edits to the Title/ Category/ Price range/ Location/ RecBy of the recommendation in your
list.

Command : `edit [TITLE_OF_RECOMMENDATION] `

`[TITLE_OF_RECOMMENDATION]` : title of recommendation that you want to edit.

<span>&#10071;</span>Ensure the title of the recommendation you want to edit already exists in your lists of recommendations.
Otherwise, Connoisseur will prompt you saying that no such recommendation exists. When typing the title you want to edit, ensure spelling and the number of blank spaces in between words is the same as the title in the list.

<span>&#10071;</span> The command 'edit' is case-insensitive.<br>

<span>&#10071;</span> Connoisseur will ignore the extra blank spaces typed in between the 'edit' and
'TITLE_OF_RECOMMENDATION' in the command. <br>

As shown in Figure 18 below, Connoisseur will prompt you asking whether you would like to make changes to Title/
Category/ Price range/ Location/ RecBy. Input either `Title`,`Category`, `Price range`,`Location` or `RecBy`.

<span>&#10071;</span> These inputs are case-insensitive and Connoisseur will ignore black spaces typed before or after the inputs.<br>

<span>&#10071;</span> When editing the title, Connoisseur will check for duplicates in the review list. If the changes
made to the recommendation title is a duplicate and already exists in the review list, Connoisseur will prompt you to enter a unique title.

If you would like to continue to make edits to the recommendation, input `y`. Otherwise, input `n`.

<span>&#10071;</span> Inputs 'y' and 'n' are case-insensitive. <br>

<span>&#10071;</span> Ensure when typing 'y' or 'n' command do not type any additional blank spaces. Otherwise, Connoisseur will
detect an invalid command and prompt you to enter 'y' or 'n' again <br>

![img_1.png](images/ug/edit_reco.png)
<p align="center">Figure 18. Editing Recommendations</p>

#### 4.2.4 Delete a Recommendation

This feature allows you to delete a recommendation from your list as shown in Figure 19.

Command: `delete [TITLE_OF_RECOMMENDATION]`

`[TITLE_OF_RECOMMENDATION]` : title of recommendation that you want to delete.

![img_2.png](img_2.png)
<p align="center">Figure 19. Deleting a Recommendation</p>

<span>&#10071;</span>Ensure the title of the review you want to delete already exists in your lists of recommendations.
Otherwise, Connoisseur will prompt you saying that no such recommendation exits. When typing the title you want to delete,
ensure spelling and the number of blank spaces in between words is the same as the title in the list.

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed after the command. If blank spaces are
typed before the command, Connoisseur will detect it as an invalid command.

<span>&#10071;</span> The command 'delete' is case-insensitive.<br>

<span>&#10071;</span> Connoisseur will ignore extra blank spaces that are typed in between the 'delete' and
'TITLE_OF_REVIEW' in the command. <br>

#### 4.2.5 Review a Recommendation

This feature allows you to review an item in the recommendation list once you have tried it and transfer it to the
review list.

Command: `done [TITLE_OF_RECOMMENDATION]`

As shown in Figure 20, Connoisseur will prompt you to rate the experience out of 5. You can also add in a description by
inputting `y` or `n` otherwise. Figure 20 shows that the title 'Tipo Pasta' has been successfully transferred from
recommendation to review list.

![img_3.png](images/ug/done_reco.png)
<p align="center">Figure 20. Reviewing a Recommendation</p>

### 4.3 View Help

command: `help[COMMAND_NAME]` eg. `help reco` `help list` etc.

If you encounter any issues using Connoisseur simply key in `help` for a generic help message as show in Figure 21.
![img_4.png](images/ug/genericHelp.png)
<p align="center">Figure 21. Generic Help message</p>

If you want help with a specific command simple key in `help` followed by the `[COMMAND_NAME]` as show in Figure 22.
![img_5.png](images/ug/help_command.png)
<p align="center">Figure 22. Help message for commands</p>

<span>&#10071;</span> The command 'help' is case-insensitive. On the other hand, when inputting command name ensure it is in lower case.<br>

### 4.4 Exit and Save Connoisseur

This feature allows you to exit Connoisseur and all you review and recommendation list will be stored as
`connoisseur.json` in the _data folder_ as shown in Figure 23.

command: `exit` or `bye`
![img_6.png](images/ug/exit.png)
<p align="center"> Figure 23. Exiting Connoisseur</p>
<span>&#10071;</span> The commands are case-insensitive.

## 5. Command Summary

|Action | Command | Examples |
| ----------- | ---------- | -----------|
|[Enter Review Mode](#41-review-mode)|`review`|`review`|
|[Add a Review](#411-adding-a-review)|`add [QUICK/LONG]` `new[QUICK/LONG]`|`add`<br>`new `<br>`add quick`<br>`new long`|
|[List Reviews](#412-list-reviews)|`list [SORTING_METHOD]`|`list`<br> `list title`|
|[Display ratings using Asterisks](#412-list-reviews)|`display asterisks`|`display asterisks`|
|[View Current Sorting Method](#413-sort-reviews)|`sort`| `sort`|
|[Change Sorting Method](#413-sort-reviews)|`sort [SORTING_METHOD]`| `sort title`|
|[View a Review](#414-view-a-review)|`view [TITLE_OF_REVIEW]`|`view Captain America`|
|[Edit a Review](#415-edit-a-review)|`edit [TITLE_OF_REVIEW]`|`edit Armageddon`|
|[Delete a Review](#416-delete-a-review)|`delete [TITLE_OF_REVIEW]`|`delete Armageddon 2`<br>|
|[Enter Recommendation Mode](#42-recommendation-mode)|`reco`|`reco`|
|[Add a Recommendation](#421-adding-a-recommendation)|`add`<br>`new`|`add`<br> `new`|
|[List Recommendations](#422-list-recommendation)|`list`|`list`|
|[Edit a Recommendation](#423-edit-a-recommendation)|`edit [TITLE_OF_RECOMMENDATION]`|`edit Tipo Pasta`|
|[Delete a Recommendation](#424-delete-a-recommendation)|`delete [TITLE_OF_RECOMMENDATION]`|`delete Armageddon 3`<br>|
|[Review a Recommendation](#425-review-a-recommendation)|`done [TITLE_OF_RECOMMENDATION]`| `done Universal Studio`|
|[Help for General usage](#43-view-help)|`help`|`help`|
|[Help for a Specific function](#43-view-help)|`help [COMMAND_NAME]`|`help reco`<br>`help list`|
|[Exit & Save](#44-exit-and-save-connoisseur)|`exit`<br>`bye`|`exit`<br>`bye`|

## 6. FAQ

//TODO
**Q**: How do I transfer my data to another computer?

**A**: Simply move the jar file and data/connoisseur.json into the same directory.