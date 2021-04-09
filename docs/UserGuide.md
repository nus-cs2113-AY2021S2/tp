# User Guide

## Introduction

Welcome to Diliveri. The ultimate smart assistant for deliverymen.
Not just the men, but the women and children too!

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `Diliveri` from [here](http://link.to/duke).

## Features 


### Help: `help`
Returns a help message containing a list of accepted commands accepted by Diliveri 

Format: `help`

### Profile: `profile`
Returns the current profile details of the user. 

Format: `profile`

### Edit Profile: `editprofile`
Edits the current profile details of the user. 

Format: `editprofile n/NAME v/VEHICLE_MODEL l/LICENSE_PLATE w/WEIGHT`

* The `NAME` can be in a natural language format.
* The `VEHICLE_MODEL` can be in a natural language format.
* The `LICENSE_PLATE` cannot contain punctuation.
* The `WEIGHT` must be a numeric value.

Example of usage: 

`edit n/Obi-Wan v/BMW X-Wing l/SJU7606F w/20`

`edit n/General Kenobi v/Jedi Interceptor l/SKJ9856H w/60`

### Load Delivery Assignment: `start`
Loads a delivery assignment into the deliverylist.

Format: `start`

### Display list of Deliveries: `list`
Shows consolidated list of deliveries present in assignment

Format: `list`

### Display Recommended Travel Route: `route`
Displays a recommended travel route, determined by distance

Format: `route`

### View Delivery Details: `view`
Returns a detailed view of a specified delivery - containing
details about the items present in the delivery

Format: `view <delivery number>`

Example of usage:

`view 2`

### Mark Delivery as Completed: `complete`
Marks a selected delivery as completed. This will remove the delivery
from future route calculations and adds the delivery to the 'record'

Format: `complete <delivery number>`

Example of usage:

`complete 2`

### Display Record of Completed Deliveries: `record`
Displays the list of completed deliveries, together with
the amount earned thus far.

Format: `record`

### Display Recommened Route for Delivery: `route`
Displays best route available from undelivered deliveries.

Format: `route`

### End application: `bye`
Terminates user session

Format: `bye`

## FAQ

**Q**: How do I get started? 

**A**: Type start to load deliveries

## Command Summary

* Show help menu `help`
* Show profile `profile`
* Edit profile `editprofile n/NAME v/VEHICLE_MODEL l/LICENSE_PLATE w/WEIGHT`
* Load deliveries `start`
* Display list of deliveries `list`
* Display optimal route `route`
* View delivery details `view <delivery number>`
* Mark delivery as complete `complete <delivery number>`
* Display completed deliveries `record`
