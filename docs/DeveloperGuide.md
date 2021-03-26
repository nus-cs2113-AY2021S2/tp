# Developer Guide

##Introduction

###What is Connoisseur
Connoisseur is a desktop app for managing and storing personal reviews that students would like to keep. It is a revolutionary app that not only provides an organised user friendly database for its users, but provides customisable categories to enhance the user experience. Through its intuitive command line interface, students would be able to store and share their recommendations easily.

###Purpose and Scope
The purpose of this developer guide is to describe the architecture and software design decisions for our application. This guide will cover our program architecture, logical view of major components and functionalities of our features.

##Setting up, getting started

###Setting up
There are 2 pre-requisites for Connoisseur to run:

1. JDK 11
    1. Configure the JDK: Follow the guide [se-edu/guides] IDEA: Configuring the JDK to to ensure Intellij is configured to use JDK 11.
      
2. Intellij IDEA (highly recommended)

###Getting Started

<div class="alert alert-block alert-warning">
<b>Caution:</b> Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.
</div>

1. First, **fork** this repo, and **clone** the fork into your computer.
   
2. **Import the project as Gradle project**
    1. Follow the guide [[se-edu/guides] IDEA: Importing a Gradle project](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) to import the project into IDEA

3. **Verify the setup:**
    1. Run the `seedu.address.connoisseur` and try a few commands.
    2. Run the [tests](https://github.com/AY2021S2-CS2113T-F08-3/tp/tree/master/src/test/java/seedu/connoisseur) to ensure they all pass.
<div class="alert alert-block alert-info">
<b>Note:</b>  Importing a Gradle project is slightly different from importing a normal Java project.</div>

## Design & implementation
{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
