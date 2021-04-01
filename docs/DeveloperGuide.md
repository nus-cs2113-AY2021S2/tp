# Developer Guide
## Table of Contents
[1.Preface](#1.-Preface) <br>
[2.How to use this document](#2.-How-to-use-this-document)<br>
[3.Setting up](#3.-Setting-up)<br />
&nbsp;&nbsp;[3.1. Prerequisites](#Prerequisites) <br>
&nbsp;&nbsp;[3.2. Setting up the project in your computer](#Setting-up-the-project-in-your-computer) <br>
&nbsp;&nbsp;[3.3. Verifying the setup](#Verifying-the-setup) <br>
&nbsp;&nbsp;[3.4. Configure coding style](#Configure-the-coding-style) <br>
[4. Design](#Design) <br>
&nbsp;&nbsp;[4.1. Architecture: High Level View](#Architecture:-High-Level-View)<br />
&nbsp;&nbsp;[4.2. UI & Messages component](#UI-component)<br />
&nbsp;&nbsp;[4.3. Parser component](#Parser-component)<br />
&nbsp;&nbsp;[4.4. Review component](#Review-componenet)<br />
&nbsp;&nbsp;[4.5. Recommendation component](#Review-componenet)<br />
&nbsp;&nbsp;[4.6. Commands component](#Commands-component)<br />
&nbsp;&nbsp;[4.7. Sorter component](#Sorter-component)<br />
&nbsp;&nbsp;[4.8. Storage component](#Storage-component)<br />
[4. Implementation](#Implementation) <br>
&nbsp;&nbsp;[4.1. Mode Switch Feature](#Mode-switch-feature) <br>
&nbsp;&nbsp;[4.2. Review Mode](#Review-Mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.1. Add a Review Feature](#Add-a-Review-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.2. List Reviews Feature](#List-Reviews-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.3. Sort Reviews Feature](#Sort-Reviews-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.4. View a Review Feature](#View-a-Review-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.5. Edit a Review Feature](#Edit-a-Review-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.6. Delete a Review Feature](#Delete-a-Review-feature) <br>
&nbsp;&nbsp;[4.3. Recommendation Mode](#43-notebook-mode) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.1. Add a Recommendation Feature](#Add-a-Recommendation-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.2. List Recommendation Feature](#List-Recommendation-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.3.3. Edit a Recommendation Feature](#Edit-a-Recommendation-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.5. Delete a Recommendation Feature](#Delete-a-Recommendation-feature) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.2.6. Review a Recommendation Feature](#Review-a-Recommendation-feature) <br>
&nbsp;&nbsp;[4.4. Storage](#44-storage) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.1. Storage Format](#441-storage-format) <br>
&nbsp;&nbsp;&nbsp;&nbsp;[4.4.2. Implementation](#442-implementation) <br>
&nbsp;&nbsp;[4.5. Error handling](#45-error-handling) <br>
&nbsp;&nbsp;[4.6. Personalised Messages](#46-personalised-messages) <br>
[6. Planned Features](#Planned-Features) <br>
[5. Documentation](#5-documentation) <br>
&nbsp;&nbsp;[5.1. Setting up and maintaining the project website](#51-setting-up-and-maintaining-the-project-website) <br>
&nbsp;&nbsp;[5.2. Style guidance](#52-style-guidance) <br>
&nbsp;&nbsp;[5.3. Diagrams](#53-diagrams) <br>
[6. Testing](#6-testing) <br>
&nbsp;&nbsp;[6.1. Running tests](#61-running-tests) <br>
&nbsp;&nbsp;[6.2. Types of tests](#62-types-of-tests) <br>
[Appendix A: Product Scope](#appendix-a-product-scope) <br>
[Appendix B: User Stores](#appendix-b-user-stories) <br>
[Appendix C: Use Cases](#appendix-c-use-cases) <br>
[Appendix D: Non-Functional Requirements](#appendix-d-non-functional-requirements) <br>
[Appendix E: Glossary](#appendix-e-glossary) <br>
[Appendix F: Instructions for manual testing](#appendix-e-glossary) <br>
   
##1. Preface
Connoisseur is a desktop application for managing and storing a list of personal reviews on experiences, and a list of 
recommendations to try next.

The Developer Guide for Connoisseur v2.1 is designed for developers intending to improve Connoisseur, by fixing bugs, 
or perhaps adding entirely new features. It explains how the project is set up, the architecture used, and the code 
style you should adopt when contributing code to the project.

##2. How to use this document

##3. Setting up
The following section describes how to set up the coding environment on your own computer, in order to start writing 
code to improve Connoisseur.

###3.1 Prerequisites
1. JDK 11 <br>
   [Download JDK 11](#https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html)
2.  *Recommended integrated development environment for coding* : IntelliJ IDEA<br>
   [Download IntelliJ IDEA](#https://www.jetbrains.com/idea/)
   
###3.2 Setting up the project in your computer
><p>&#10071 Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.

1. **Fork** this repo, and **clone** the fork into your computer.
2. Open IntelliJ (if you are not in the welcome screen, click **`File`** > **`Close Project`** to close the existing project dialog first).
3. Set up the correct JDK version for Gradle  
   a. Click **`Configure`** > **`Project Defaults`** > **`Project Structure`**  
   b. Click **`New...`** and find the directory of the JDK.
4. Click **`Import Project`**.
5. Locate the **`build.gradle`** file and select it. Click **`OK`**.
6. Click **`Open as Project`**.
7. Click **`OK`** to accept the default settings.

###3.3 Verifying the setup

###3.4 Configure Coding style
If using IDEA, follow the guide [[se-edu/guides] IDEA: Configuring the code style](https://se-education.org/guides/tutorials/intellijCodeStyle.html)
to set up IDEA’s coding style to match ours.

>Optionally, you can follow the guide [[se-edu/guides] Using Checkstyle](https://se-education.org/guides/tutorials/checkstyle.html)
>to find how to use the CheckStyle within IDEA e.g., to report problems as you write code.

##4. Design
The following section describes the design and implementation of the product. We use UML diagrams and code snippets
to explain some aspects of the code. If you are unfamiliar with UML, the diagrams should still be fairly
understandable. However, you may wish to consult [[CS2113/T] Modeling](https://nus-cs2113-ay2021s1.github.io/website/se-book-adapted/chapters/modeling.html) for a quick introduction to UML.

###4.1 Architecture: High Level View

**How the architecture components interact with each other**

The following diagram provides a rough overview of how **Connoisseur** is built.
Given below is a quick overview of each component.