# ZH Liu — Project Portfolio Page

## Overview
Patient Manager is a _Command Line Interface_ (CLI) application for **_general practitioners_** (GP)
who work in polyclinics to manage their patient list.

My teammate, together with me, developed this application as a team project for CS2113T module of NUS.
This project aimed to develop a program targetting a current problem using Java with Object-oriented
programming as model.

The entire development cycle, excluding the planning stage which consists of a few weeks before actual
development, includes three iterations. V1.0 is the minimum viable product, and V2.0 is the one with most
of the features in. For v2.1, the last iteration, we focused on bug fixing and improvements in product
documentation.

## Summary of Contributions

### Code Contributed

This is a link to the RepoSense dashboard, which has a detailed analysis of the lines of code contributed by me:

https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?breakdown=true&search=fsgmhoward

### Enhancement Implemented

* Drafted overall structure of the program. This includes the organization and placeholders
  of command classes, Parser, models, UI class, etc.
* `command.Command` class — This is the parent class for all commands that enforce some common constraints.
* `Parser` class — This class handles the parsing and initializing of command classes.
* `Data` class, and model classes like `Patient` and `Record` classes — These classes are in charge of the data
  storage and manipulation of the application.
* Migration of exception handling from using the generic `Exception` to the custom classes, such as
  `InvalidInputException`. This includes the drafting of `BaseException` class.
* Restructured the main class `PatientManager` to be more OOP.
* Added `current` command for printing out the current patient being loaded.
* Integrated `Storage` into various command classes.
* Other generic bug fixes for the entire project. This includes bug reported by peer teams during PE-D.

### Contribution to User Guide

* The part that explains how white spaces and order of input arguments affect command output
* General formatting and fixing

### Contribution to Developer Guide

* Explanation of design decision for Parser, as well as a detailed implementation steps
* Explanation of design decision for all exception class and how they are used
* Explanation for common classes
* General formatting and fixing

### Contribution to Team-Based Tasks

* Necessary general code enhancements
* Tagging a number of issues raised in PE-D for fixing
* Release management

### Review/Mentoring Contributions

Along the way of development, I have reviewed a number of pull requests opened by other team members. This
is a non-exhaustive list:

* https://github.com/AY2021S2-CS2113T-W09-4/tp/pull/54
* https://github.com/AY2021S2-CS2113T-W09-4/tp/pull/58
* https://github.com/AY2021S2-CS2113T-W09-4/tp/pull/66
* https://github.com/AY2021S2-CS2113T-W09-4/tp/pull/70
* https://github.com/AY2021S2-CS2113T-W09-4/tp/pull/125
* ... and more

For a full list of PRs reviewed by me, you may refer to this link:

https://github.com/AY2021S2-CS2113T-W09-4/tp/pulls?q=is%3Apr+reviewed-by%3Afsgmhoward+

Other than PR reviews, I have also provided general help given to teammates encountering technical difficulties
along the way of development.

### Contribution Beyond Project Team

I have reviewed other peer teams' product and documentation during tutorials and PE-D. The list of bugs reported
in PE-D can be accessed by clicking the following link:

https://github.com/fsgmhoward/ped/issues