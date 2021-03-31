# Connoisseur User Guide

## Table of Contents

1. [Introduction](#Introduction)
1. [About this Guide](#About-this-Guide)<br />
   2.1 [What's in Connoisseur](#What-is-in-Connoisseur)<br />
   2.2 [Formatting in the Guide](#Formatting-in-the-Guide)
1. [Quick start](#Quick-Start)
1. [Features](#Features) <br />
    4.1 [Command Format](#Command-Format)<br />
    4.2 [Review Mode](#Review-Mode) <br />
        4.2.1 [Add a Review](#Add-a-review)<br />
        4.2.2 [List Reviews](#List-reviews)<br />
        4.2.3 [Sort Reviews](#Sort-reviews)<br />
        4.2.4 [View a Review](#View-a-review)<br />
        4.2.5 [Edit a Review](#Edit-a-review)<br />
        4.2.6 [Delete a Review](#Delete-a-review)<br />
    4.3 [Recommendation Mode](#Recommendation-Mode)<br />
        4.3.1 [Add a Recommendation](#Add-a-Recommendation)<br />
        4.3.2 [Edit a Recommendation](#Edit-a-Recommendation)<br />
        4.3.3 [Review a Recommendation](#Review-a-Recommendation)<br />
   4.4 [View Help](#View-Help)<br />
   4.5 [Exit & Save Connoisseur](#Exit-&-Save-Connoisseur)
1. [Command Summary](#Command-Summary)
1. [FAQ](#FAQ)
##1. Introduction

Welcome to the user guide for our application, Connoisseur! 
With over 4.6 thousand restaurants in Singapore, endless number of entertainment options and never-ending list of
streaming shows and movies, to watch many of us are left deciding for a long time on what is worthwhile spending our 
limited leisure time on. Fret-not!

Connoisseur is a desktop application for managing and storing personal reviews on experiences and recommendations to 
try next, that you would like to keep. It is a revolutionary app that not only provides an organised user-friendly 
database, but provides customisable categories to enhance your experience. Through its intuitive command line interface, 
you will be able to store and access your reviews & recommendation easily.

##2. About this Guide
This guide gives you an overview of the features in Connoisseur and shows you how to get started using Connoisseur. 
Choose a link in the [Feature](#Table-of-Contents) section to get a step-by-step instruction, and understand how to use Connoisseur.

###2.1 What is in Connoisseur
In our Review mode, you can add a review about an experience, rate it out of 5 stars, delete or edit a review, 
view the entire list of your reviews or one particular review. You can also sort the list from the highest to lowest 
rating, by category, title and date of entry.

For our Recommendation mode, you can have a list of things you would like to try, the location and the price range 
of the experience! Already tried out the experience? Nice! You can now move it to your review list in the review mode 
and record your thoughts on how good or bad the experience was!

###2.2 Formatting in the guide
Note the following formatting used in this document:



##3. Quick Start
If you are tired of lengthy and problematic installation processes, Connoisseur is perfect for you. 
The setup is minimal and can be completed in a few simple steps. Follow the instructions below to try it out!

1. Ensure that you have Java 11 or above installed. The latest version of Java can be found 
   [here](https://java.com/en/download/)
2. Download the latest version of Connoisseur from [here](https://github.com/AY2021S2-CS2113T-F08-3/tp/releases).
   To do so, look for the file connoisseur.jar and click on it. Please refer to Figure 1 if you require assistance with 
   locating the file. Figure 1 shows how to download version 2.1 of Connoisseur. Connoisseur.jar has been highlighted in 
   red for your convenience.   
   ![Figure 1 - How to download Connoisseur](./images/ug/jarfile.png)
   Figure 1. How to download Connoisseur
   
3. Copy the file to the folder you want to use as the _home folder_ for Connoisseur
   ![Figure 2 - Copying connoisseur.jar into a folder](./images/ug/downloading1.PNG)
   Figure 2. Copying connoisseur.jar into a folder
4. Open terminal and navigate to the directory of the folder you just copied into. 
5. In your terminal, type `java -jar Connoisseur.jar` and press enter. This should start Connoisseur.
   ![Figure 3 - Starting Connoisseur](./images/ug/downloading2.png)
   Figure 3. Starting Connoisseur
6. You may now use Connoisseur by typing in commands and pressing Enter to execute it. 
    Refer to the [Command summary](#command-summary) for a list of recognised commands. 
7. You should notice a new _data folder_ created in the _home folder_ you have chosen in step 3. The data for 
   Connoisseur is saved in `connoisseur.json` in the _data folder_. 
   
##4. Features
This section covers all the commands that you can type into the Command Box of Connoisseur when it prompts you -
`Please enter a command: ` 

The commands are categorised into the two modes offered by Connoisseur, Review and Recommendation mode. If it is the 
first time that you are using the command, we recommend that you refer to Command Format used in this guide
to find out how to interpret the format of the commands.

###4.1 Command Format used in this guide
* Words in [user input] are the fields to be supplied by the user. <br /> e.g. in `list [sorting_method]` sorting_method 
is the field input by the user.
###4.2 Review Mode
Connoisseur has 2 modes. The first is the review mode, where you can add your own reviews of experiences. 
The review mode can be accessed  using the `review` command. 

#### Viewing Help
View help on commands recognised by Connoisseur. You can specify a command to get detailed help on it. 

Command: `help [command_name]`

`[command_name]`: optional argument specifying command on which help is needed. 

![](images/ug/help_general.png)

![](images/ug/help_new.png)

#### Adding a Review
Add a new review. Choice of quick review or long review. 

Command: `add [quick | long]`, `new [quick | long]`

`[quick | long]` : optional argument to specify quick or long review. 

![](images/ug/new_quick.png)

![](images/ug/new_long.png)

#### Listing Reviews
List your current reviews. You can specify a one-off sorting method by which to sort the reviews. 

Command: `list [sorting_method]`

`[sorting_method]` : temporary sort method by which to sort the reviews. Leaving this blank would allow Connoisseur to use the saved sort method. Currently supported methods are: 
* `title`
* `category`
* `rating`
* `earliest`
* `latest`

![](images/ug/list_review.png)

![](images/ug/list_review_rating.png)

#### Sorting Reviews
Change the saved sorting method. 

Command: `sort <sorting_method>`

`<sorting_method>` : sort method to be used. Default sorting method is `latest`. Refer above for a list of recognised sorting methods. 

![](images/ug/sort_review.png)

#### Viewing a Review
View details of a review. 

Command: `view <title_of_review>`

`<title_of_review>` : title of review that you want to view. 

![](images/ug/view_review.png)

#### Deleting a Review
Delete a review that you no longer need. 

Command: `delete <title_of_review>`

`<title_of_review>` : title of review that you want to delete. 

![](images/ug/delete_review.png)

### Recommendation Mode

#### Adding a todo: `todo`

Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
