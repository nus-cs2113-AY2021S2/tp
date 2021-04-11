# Developer Guide

## Table of Contents

1. [Preface](#1-preface)

2. [How to use this document](#2-how-to-use-this-document)

3. [Setting up](#3-setting-up)

   3.1 [Prerequisites](#31-prerequisites)

   3.2 [Setting up the project in your computer](#32-setting-up-the-project-in-your-computer)

   3.3 [Verifying the setup](#33-verifying-the-setup)
   3.4 [Configure coding style](#34-configure-the-coding-style)

4. [Design](#4-design)

   4.1 [Architecture: High Level View](#41-architecture-high-level-view)

   4.2 [UI and Messages component](#42-ui-and-component)

   4.3 [Parser component](#43-parser-component)

   4.4 [Review component](#44-review-componenet)

   4.5 [Recommendation component](#45-review-componenet)

   4.6 [Commands component](#46-commands-component)

   4.7 [Sorter component](#47-sorter-component)

   4.8 [Storage component](#48-storage-component)

5. [Implementation](#5-implementation)

   5.1 [Mode Switch Feature](#51-mode-switch-feature)

   5.2 [Review Mode](#52-review-Mode)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.1 [Add a Review Feature](#521-add-a-review-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.2 [List Reviews Feature](#522-list-reviews-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.3 [Sort Reviews Feature](#523-sort-reviews-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.4 [View a Review Feature](#524-view-a-review-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.5 [Edit a Review Feature](#525-edit-a-review-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2.6 [Delete a Review Feature](#526-delete-a-review-feature)

   5.3 [Recommendation Mode](#53-recommendation-mode)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.1 [Add a Recommendation Feature](#531-add-a-recommendation-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.2 [List Recommendation Feature](#532-list-recommendation-feature)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3.3 [Edit a Recommendation Feature](#533-edit-a-recommendation-feature)

   5.4 [Storage](#54-storage)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4.1 [Storage Format](#541-storage-format)

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4.2 [Implementation](#542-implementation)

   5.5 [Error handling](#55-error-handling)

   5.6 [Personalised Messages](#56-personalised-messages)

6. [Planned Features](#6-planned-features)

7. [Documentation](#7-documentation)

   7.1 [Setting up and maintaining the project website](#71-setting-up-and-maintaining-the-project-website)

   7.2 [Style guidance](#72-style-guidance)

   7.3 [Diagrams](#73-diagrams)

8. [Testing](#8-testing)

   8.1 [Running tests](#81-running-tests)

   8.2 [Types of tests](#82-types-of-tests)

9. [Appendix](#appendix)

   Appendix A: [Product Scope](#appendix-a-product-scope)
    * [Target User Profile](#target-user-profile)
    * [Value Proposition](#value-proposition)

   Appendix B: [User Stores](#appendix-b-user-stories)

   Appendix C: [Use Cases](#appendix-c-use-cases)

   Appendix D: [Non-Functional Requirements](#appendix-d-non-functional-requirements)

   Appendix E: [Instructions for manual testing](#appendix-e-glossary)
   <ul>Launch and Shutdown</ul>
   <ul>Adding a Review</ul>
   <ul>Editing a Review</ul>
   <ul>Listing Reviews</ul>
   <ul>Sorting Reviews</ul>
   <ul>Deleting a review</ul>
   <ul>Viewing the full details of a review</ul>
   <ul>Adding a Recommendation</ul>
   <ul>Editing a Recommendation</ul>
   <ul>Listing Recommendations</ul>
   <ul>Deleting a Recommendation</ul>
   <ul>Marking a Recommendation as Done</ul>
   <ul>Help</ul>
   <ul>Data storage</ul>

   Appendix F: [Glossary](#appendix-f-glossary)

## 1. Preface

Connoisseur is a desktop application for managing and storing a list of personal reviews on experiences, and a list of
recommendations to try next.

The Developer Guide for Connoisseur v2.1 is designed for developers intending to improve Connoisseur, by fixing bugs, or
perhaps adding entirely new features. It explains how the project is set up, the architecture used, and the code style
you should adopt when contributing code to the project.

## 2. How to use this document

//TODO//

## 3. Setting up

The following section describes how to set up the coding environment on your own computer, in order to start writing
code to improve Connoisseur.

### 3.1 Prerequisites

1. JDK 11 <br>
   [Download JDK 11](#https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html)
2. *Recommended integrated development environment for coding* : IntelliJ IDEA<br>
   [Download IntelliJ IDEA](#https://www.jetbrains.com/idea/)

### 3.2 Setting up the project in your computer

> <p>&#10071 Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.

1. **Fork** this repo, and **clone** the fork into your computer.
2. Open IntelliJ (if you are not in the welcome screen, click **`File`** > **`Close Project`** to close the existing
   project dialog first).
3. Set up the correct JDK version for Gradle  
   a. Click **`Configure`** > **`Project Defaults`** > **`Project Structure`**  
   b. Click **`New...`** and find the directory of the JDK.
4. Click **`Import Project`**.
5. Locate the **`build.gradle`** file and select it. Click **`OK`**.
6. Click **`Open as Project`**.
7. Click **`OK`** to accept the default settings.

### 3.3 Verifying the setup

### 3.4 Configure Coding style

If using IDEA, follow the
guide [[se-edu/guides] IDEA: Configuring the code style](https://se-education.org/guides/tutorials/intellijCodeStyle.html)
to set up IDEA’s coding style to match ours.

> Optionally, you can follow the guide [[se-edu/guides] Using Checkstyle](https://se-education.org/guides/tutorials/checkstyle.html)
> to find how to use the CheckStyle within IDEA e.g., to report problems as you write code.

## 4. Design

The following section describes the design and implementation of the product. We use UML diagrams and code snippets to
explain some aspects of the code. If you are unfamiliar with UML, the diagrams should still be fairly understandable.
However, you may wish to
consult [[CS2113/T] Modeling](https://nus-cs2113-ay2021s1.github.io/website/se-book-adapted/chapters/modeling.html) for
a quick introduction to UML.

### 4.1 Architecture: High Level View

**How the architecture components interact with each other**

The following Figure 1, provides a rough overview of how **Connoisseur** is built.<br>

Figure 1. Architecture Diagram of Connoisseur <br>
//TODO ADD PLANTUML DIAGRAM !missing! sorter component// <br>

As shown in Figure 1, the user interacts with the`UI` component and types in input. Messages displayed to the user by
the `UI` component comes from the `Messages` component. Input from user is passed to the `parser` component, which is
interpreted as a command and passed to the `Commands` component. Either `Storage`, `ReviewList` or `RecommendationList`
component executes the command input by the user. These components may produce outputs which are passed to the `UI`
component and seen by the user. This is explained in more detail in the following sections.

### 4.2 UI and Messages component

The user interface of Connoisseur is provided by the classes UI & Messages. It is instantiated once in the connoisseur()
method.<br>
//can add code snippet here//

* The ui.printGreeting() method is called to display the welcome message to the user.
* The ui.println(COMMAND_PROMPT) method is called to prompt the user for input, where COMMAND_PROMPT is a message from
  the `Messages` component
* The ui.readCommand() method reads the input which is then passed on to the `parser` component

### 4.3. Parser component

### 4.4. Review component

### 4.5. Recommendation component

### 4.6. Commands component

### 4.7. Sorter component

### 4.8. Storage component

## 5. Implementation

### 5.1 Mode Switch Feature

### 5.2 Review Mode

### 5.2.1 Add a Review Feature

### 5.2.2 List Reviews Feature

### 5.2.3 Sort Reviews Feature

### 5.2.4 View a Review Feature

### 5.2.5 Edit a Review Feature

### 5.2.6 Delete a Review Feature

### 5.3 Recommendation Mode

### 5.3.1 Add a Recommendation Feature

When the user attempts to add a new recommendation,

### 5.3.2 List Recommendation Feature

### 5.3.3 Edit a Recommendation Feature

### 5.3.4 Delete a Recommendation Feature

### 5.3.5 Review a Recommendation Feature

### 5.4 Storage

### 5.4.1 Storage Format

### 5.4.2 Implementation

### 5.5 Error handling

Connoisseur provides default error handling. The default error handling system handles invalid input format and invalid
file errors with exceptions. Connoisseur also has a customized exception, the duplicate exception. You can also choose
to define your own custom error handling by creating custom exceptions.

*Duplicate Exception*
The Duplicate Exception is used to handle titles of reviews or recommendations that are input by the user. If the title
input is found, duplicate exception will be thrown.

The Duplicate Exception is thrown in addRecommendationDetails(), if the checkAndPrintDuplicateRecommendation(title)
returns true. This error will be caught in the addRecommendation() method.

### 5.6 Personalised Messages

## 6. Planned Features

## 7. Documentation

### 7.1 Setting up and maintaining the project website

### 7.2 Style guidance

### 7.3 Diagrams

## 8. Testing

### 8.1 Running tests

### 8.2 Types of tests

## Appendix

### Appendix A: Product Scope

**Target User Profile**

* is a university student
* has a desire to record a significant number of experiences
* wants to manage a bucket list
* can type fast and prefers typing over mouse interactions
* is comfortable using the command line interface

**Value Proposition**

* Connoisseur helps users to consolidate their experiences in an organised way. The user just needs to

### Appendix B: User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v1.0|user|see the number of recommendations I have|keep track of the number of reviews I've made|
|v1.0|user|be able to save my previous recommendations|refer to the old entries that I have|
|v1.0|busy user|be able to do quick ratings|save time|
|v1.0|user|delete selected items that I no longer wish to recommend|edit my list according to my liking|
|v1.0|busy user|have a template to guide my reviews|input my reviews quickly|
|v2.0|indecisive user|change my review and opinnions on things|record my opinions accurately at all times|
|v2.0|forgetful user|be prompted of an existing review|avoid duplicates in my list|
|v2.0|lazy user|have my sorting preferences saved|avoid having to input my preferred sorting method all the time|

### Appendix C: Non-Functional Requirements

1. Should work on any *mainstream OS* as long as it has `Java 11` installed.
2. A user with above average typing speed for regular English text should be able to use the features of Connoisseur
   faster than by using the mouse.

3. A user who wants to modify the save file can do so by using an application that is able to edit JSON files.

### Appendix D: Instructions for manual testing

Given below are instructions to test the app manually.

**Launch and Shutdown**

1. Initial launch

   &nbsp;i. Ensure that you have **Java 11** or above installed.

   &nbsp;ii. Download the latest version of **Connoisseur** here (add link later)

   &nbsp;iii. Copy the downloaded Connoisseur.jar into your **Desktop**.

   &nbsp;iv. Open terminal and enter `cd Desktop`.

   &nbsp;v. Then, enter `java -jar Connoisseur.jar`. &nbsp;&nbsp;**Expected**: Shows the command line interface with
   welcome message.


2. Shutdown Connoisseur &nbsp;i. Enter `exit` or `bye` into terminal while **Connoisseur** is running. &nbsp;&nbsp;**
   Expected**: A farewell message by Connoisseur will be shown.

### Appendix E: Other Guides: Documentation, Testing, Dev-ops
This section contains links to other relevant guides that may be of use.
* [Documentation guide](DocumentationGuide.md)
* [Testing guide](TestingGuide.md)
* [Dev-ops guide](DevopsGuide.md)

### Appendix F: Glossary

* Mainstream OS: Windows, Linux, Unix, OS-X
* Review: An experience a user has experienced, and intends to record. It could be a movie, restaurant, activity, etc.
* Recommendation: An experience a user wishes to experience, and wishes to record. It could be a movie, restaurant,
  activity, etc. It can be converted to a review after a user marks it as done.
* Command: An instruction meant to update the ReviewList or RecommendationList in a certain way.