# Developer Guide

## Design 

##Implementation
For public users, the list of commands is shown below:

* Display selected store sample menu: `menu`
* Display all reviews of the selected store : `reviews`
* Add a new review of the selected store: `add`
* Goes back to home page to select canteen: `home`
* Display all the stores of the selected canteen: `list`
* Exiting the application: `exit`


For admin, the list of commands is shown below:

 1. View canteens
 2. Add canteen
 3. Add store in canteen
 4. Delete canteen
 5. Delete store in canteen
 6. Delete reviews
 7. Exit


<!-- NOT TOO SURE HOW THIS PART FITS IN

#### Sequence Diagram for `admin`
When the user enters `2` to go into the admin page, the AdminVerification() is called. It will ask the user to input 
the password. Then it will check the input against the set password. If fails then the user have to enter again or enter
`exit` to exit the application.
--> 


### Main NusFoodReviews

#### Implementation
![Main Sequence Diagram](./img/Main.png)

When the application is launched, a Ui object and Parser object is instantiated.
To instantiate the Parser object, the main NusFoodReviews and Ui object is passed.

### [Public user] Display Menus Feature
#### Implementation
![DisplayMenus Sequence Diagram](./img/DisplayMenus.png)

To display menus, `DisplayMenusCommand.execute()` is called, passing in
an ArrayList of canteens and the Ui object instantiated in NusFoodReviews.

When DisplayMenusCommand was first instantiated, the relevant Store object was passed 
into the constructor. `DisplayMenusCommand.execute()` will then call `getMenus()` on the 
store object to get an ArrayList of menus, before passing the ArrayList to the ui object 
to be displayed by calling `Ui#showDisplayMenu()`.


###[Public user] Read reviews feature
#### Implementation

![ReadReviews](./img/ReadReviews.png)

To read reviews, `ReadReviewsCommand.execute()` is called passing in an ArrayList of
canteens and the Ui object instantiated in nusFoodReviews.

When ReadReviewsCommand was first instantiated, the relevant Store object was passed
into the constructor. `ReadReviewsCommand.execute()` will then call `getReviews()` on the
store object to get an ArrayList of reviews, then calling `getAverageRating()` to get the 
average rating of the store. After that, `getStoreName()` is also called to get the store
name of the store. These parameters are then passed to the ui object to be displayed by calling 
`Ui.showReviews()`

### Reset Store Feature
#### Implementation
![DisplayMenus Sequence Diagram](./img/ResetStore.png)

To reset the store index in nusFoodReviews, `ResetStoreCommand#execute()` is called, 
passing in an ArrayList of canteens, and the ui object instantiated in NusFoodReviews.

When `ResetStoreCommand` is first called, we pass the main NusFoodReviews object to the 
constructor. This allows the `Command` to interact with the main object when `execute` is called.

### Home Feature
#### Implementation
![DisplayMenus Sequence Diagram](./img/HomeCommand.png)

To reset the store and canteen index in nusFoodReviews, `HomeCommand#execute()` is called,
passing in an ArrayList of canteens, and the ui object instantiated in NusFoodReviews.

When `HomeCommand` is first called, we pass the main NusFoodReviews object to the
constructor. This allows the `Command` to interact with the main object when `execute` is called.


### Admin Capabilities
#### Implementation
![Admin Sequence Diagram](./img/Admin.png)

Once admin is verified in NusFoodReviews, `Parser#parseAdminCommand()` is called.
A switch class is then used to determine the command to instantiate.
To add a new canteen, the user must enter '2'.

<!--can someone add switch case and separate refs for each switch case maybe-->

### [Admin] Add Canteen
#### Implementation
![AddCanteen Sequence Diagram](./img/AddCanteen.png)

<!--this part should be in the switchcase ref-->
`Ui#showAddCanteen()` is called to display the add canteen prompt.
User input for canteen name will then be read using `Ui#readCommand()`.
A new AddCanteenCommand object is instantiated, with the canteen name passed into the constructor.
`Parser#parseAdminCommand()` returns the AddCanteenCommand object.
<!--this part should be in the switchcase ref-->

To add a canteen, `AddCanteenCommand#execute()` is called, passing in 
an ArrayList of canteens and the Ui object instantiated in NusFoodReviews.

A new Canteen object is then instantiated, and added to the ArrayList of canteens.
`Ui#showAddCanteenSuccess()` is called to display canteen added confirmation.

### [Admin] Delete Canteen
#### Implementation
![DeleteCanteen Sequence Diagram](./img/DeleteCanteen.png)

To delete a canteen, `DeleteCanteenCommand#execute()` is called, passing in
an ArrayList of canteens and the Ui object instantiated in NusFoodReviews.

The canteen object is removed from the canteens ArrayList. 
`Ui#showCanteenDeleted()` is called to display the canteen deleted message.

### [Admin] Delete Stores
#### Implementation

![DeleteStores](./img/DeleteStores.png)

When DeleteStoreCommand was first instantiated, the relevant canteen index 
and store index was passed into the constructor. To delete a store, `DeleteStoreCommand.execute()` 
is called, passing in an ArrayList of canteens and the Ui object instantiated in 
NusFoodReviews.`DeleteStoreCommand.execute()`will then call `get(canteenIndex)` on the canteen object 
to get the current Canteen before calling deleteStore(storeIndex) to delete the store.

### [Admin] Delete Reviews
#### Implementation

![DeleteReviews](img/DeleteReviews.png)

When DeleteReviewCommand was first instantiated, the relevant canteen index, review,
and store index was passed into the constructor. To delete a review, `DeleteReviewCommand.execute()`
is called, passing in an ArrayList of canteens and the Ui object instantiated in
NusFoodReviews.`DeleteReviewCommand.execute()`will then call `get(canteenIndex)` on the canteen object
to get the current Canteen before calling getStore(storeIndex) to get current Store. After that, deleteReview(review)
is called on the store object. Ui.reviewDeleted() displays a message to show that the review was deleted.

## Product scope
### Target user profile

{Describe the target user profile}
The target user would be NUS students/staffs who wish 
to get updated reviews about the food places in NUS.

### Value proposition

{Describe the value proposition: what problem does it solve?}
By consolidating food reviews from NUS canteens from students/staffs, 
it aims to allow new students/staffs to have a better experience at these food stores.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|see list of stores|to find good food|
|v1.0|user|read reviews|decide on where to eat|
|v1.0|user|view menu and price of items|know the type of food sold|
|v1.0|user|add reviews and rating|provide feedback on store|
|v1.0|admin|login|verify myself|
|v2.0|admin|add a new canteen 
|v2.0|admin|delete an existing canteen
|v2.0|admin|delete a store|update availability of stores
|v2.0|admin|delete a review|restrict inappropriate reviews




## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
