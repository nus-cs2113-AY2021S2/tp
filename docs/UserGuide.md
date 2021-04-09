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

Expected output:

```
-------------------------------------
The following are several accepted commands by Diliveri:

'help': Displays this help message
'profile': Displays your profile
'edit': Allows you to edit your profile details
'start': Loads up an allocated delivery assignment into the delivery list
'list': Displays the list of deliveries in your assignment
'view <number>': Displays details of the selected delivery
'complete <number>': Marks the selected delivery as completed
'record': Displays the list of completed deliveries and the respective income earned
'route': Displays optimised delivery path
'bye': Ends Deliviri App 
-------------------------------------
```

### Profile: `profile`
Returns the current profile details of the user. 

Format: `profile`

Expected output:

```
-------------------------------------
Name: Obi Wan
Vehicle Model: YT-1300
License Plate: HIGHGROUND
Max Weight: 40
-------------------------------------
```

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

Expected output:

```
-------------------------------------
Based on your input:
 Name: Obi-Wan
 Vehicle Model: BMW X-Wing
 License plate: SJU7606F
 Max Weight: 20
-------------------------------------
```

### Load Delivery Assignment: `start`
Loads a delivery assignment into the deliverylist.

Format: `start`

Expected output:

```
-------------------------------------
File loaded boi...lets gooooooo!
-------------------------------------
```

### Display list of Deliveries: `list`
Shows consolidated list of deliveries present in assignment

Format: `list`

Expected output:

```

```

### Display Recommended Travel Route: `route`
Displays a recommended travel route, determined by distance

Format: `route`

Expected output:

```
-------------------------------------
NTU Hall 3
	|
	V
NTU Hall 5
	|
	V
NTU Hall Oween
	|
	V
END OF JOB!!
-------------------------------------
```

### View Delivery Details: `view`
Returns a detailed view of a specified delivery - containing
details about the items present in the delivery

Format: `view <delivery number>`

Example of usage:

`view 2`

Expected output:

```
-------------------------------------
1002 [N] NTU Hall 3 Manika
1: 
Item Number: 13
Item Weight: 5
2: 
Item Number: 16
Item Weight: 2
-------------------------------------
```

### Mark Delivery as Completed: `complete`
Marks a selected delivery as completed. This will remove the delivery
from future route calculations and adds the delivery to the 'record'

Format: `complete <delivery number>`

Example of usage:

`complete 2`

Expected output:

```
-------------------------------------
The following delivery has been marked as completed:
1002 [Y] NTU Hall 3 Manika
-------------------------------------
```

### Display Record of Completed Deliveries: `record`
Displays the list of completed deliveries, together with
the amount earned thus far.

Format: `record`

Expected output:

```
-------------------------------------
Congratulations on completing the following deliveries:
 Number | ID | Location | Earned Amount 
1 | 1002 | NTU Hall 3 | 3.0
Total Earnings: 3.0
-------------------------------------
```

### End application: `bye`
Terminates user session

Format: `bye`

Expected output:

```
-------------------------------------
Safe travels! Goodbye!
-------------------------------------
```

## FAQ

**Q**: How do I get started? 

**A**: Type start to load deliveries

**Q**: I can't seem to load any deliveries

**A**: Your max weight in profile might be too low. Setting a higher number and restarting the app will fix this issue.

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
* End Deliviri session `bye`
