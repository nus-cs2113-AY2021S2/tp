# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

###[Proposed] Save feature for visited routes & favourite locations
####Proposed Implementation
The proposed save mechanism is facilitated by `NotesStorage`,`RoutesStorage` and `FavouriteLocationsStorage` subclasses. </br>
They extend `Storage` (superclass) with a feature to save the tagged notes, history of visited routes and favourite locations, stored internally as a `notesList` `routesHistoryList` and `favouritesList`. <br />
Additionally, they implement the following operations:

`NotesStorage#save()` — Saves all notes tagged to a location in its history. <br />
`NotesStorage#load()` — Restores all notes tagged to a location from its history. <br />
`RoutesStorage#save()` — Saves the current list of the 10 most recently visited routes in its history. <br />
`RoutesStorage#load()` — Restores the previous list of the 10 most recently visited routes from its history. <br />
`FavouriteLocationsStorage#save()` — Saves the current list of all the locations that the users are interested in keeping in its history. <br />
`FavouriteLocationsStorage#load()` — Restores the previous list of the all the locations that the users are interested in keeping from its history. <br />

These operations are exposed in the `Storage` class  as `Storage#save()` and `Storage#load()`. <br />
Given below is an example usage scenario and how the save mechanism behaves at each step. <br />
Step 1. The user launches the application for the first time. `NotesStorage`, `RoutesStorage` and `FavouriteLocationsStorage` will be initialized by calling `NotesStorage#load()`, `RoutesStorage#load()`, `FavouriteLocationsStorage#load()` with the initial state of the application. <br /> This is done only once for each time the application is launched. <br />
![img.png](SaveStep1.png) 
<br />
Step 2. The user executes `go` command to show the route from starting location to final location. <br /> The `go` command calls `RoutesStorage#save()`, causing the modified state of the `routesHistoryList` in the application after the `go` command executes to be saved in the `routesHistoryList.txt`. <br />
Step 3. The user executes `add note E4/...` to tag a note to that location. <br /> The `add note` command calls `NotesStorage#save()`, causing  the modified state of the `notesList` to be saved into the `notesList.txt`. <br />
Step 4. The user executes `delete note E4/1` to remove a note with the given note index from that location, assuming that it exists. <br /> The `delete note` command also calls `NotesStorage#save()`, causing  the modified state of the `notesList` to be saved into the `notesList.txt`. <br />
Step 5. The user executes `like E4` command to add a location to favourites. <br /> The `like` command calls `FavouriteLocationsStorage#save()`, causing the modified state of the `favouritesList` to be saved into the `favouritesList.txt`. <br />
Step 6. For all other commands, they do not modify the state of any of the lists `notesList` `routesHistoryList` and `favouritesList`. These other commands do not call `NotesStorage#save()`, `NotesStorage#load()`, `RoutesStorage#save()`, `RoutesStorage#load()`, `FavouriteLocationsStorage#save()` or `FavouriteLocationsStorage#load()`. Thus, the `notesList.txt` `routesHistoryList.txt` and `favouritesList.txt` remains unchanged. <br/>
#### Design Consideration
Alternative 1 (current choice): Saves the entire list of notes tagged, routing history and favourite locations. <br/>
Pros: Easy to implement. <br/>
Cons: Only highly effective when limited to use of one user. <br/>

### Daily route planning when daily schedule is input
####Current Implementation
The current implementation is facilitated by `DailyRoute` class, with the `AddDailyRouteCommand` and `ShowDailyRouteCommand` subclasses invoking methods that the `DailyRoute` class provides. </br>
`AddDailyRouteCommand` and `ShowDailyRouteCommand` extend `Command` (superclass), where `AddDailyRouteCommand` implements the feature of adding the schedule of the day to the `DailyRoute` object and `ShowDailyRouteCommand` accesses the `DailyRoute` object to retrieve an ArrayList with the location schedule provided from the `AddDailyRouteCommand` and run the routing algorithm present in the `Router` object. <br />
`DaySchedulePair` class is implemented to act as a pair between a day input String and schedule ArrayList.
Additionally, they implement the following operations:

`addDailyRoute(String ,ArrayList<String>)` — Maps the inputted day string to the inputted ArrayList of the schedule of the day in a hashmap . <br />
`getDailyRoute(String)` — Returns the schedule of the day that is mapped to the inputted day. <br />

These operations are exposed in the `DailyRoute` class  as `DailyRoute#addDailyRoute()` and `DailyRoute#getDailyRoute(String)`. <br />
Given below is an example usage scenario and how the addDailyRoute mechanism behaves at each step. <br />
Step 1. The user launches the application.<br />
Step 2. The user executes `add day` command. UI will then prompt the user `Enter the day:`  to input a day. <br /> The UI parser will then check if the inputted day is valid and throw an exception if it is not. <br />
Step 3. The UI then prompts the user to input the next block that is in the day's schedule.  <br /> The inputted location will be appended to an ArrayList. <br />
Step 4. Step 3 is looped until the word `END` is input. <br /> 
Step 5. The inputted day is mapped to the filled Arraylist from step 3 <br /> This is done the `DaySchedulePair` which pairs the Day string and Schedule ArrayList together. <br />
Step 6. This `DaySchedulePair` object is passed into the `DailyRoute` object to be saved in a hashmap. <br /> 


###[Proposed] Custom aliases feature
####Proposed Implementation
The proposed custom aliases for block names feature is facilitated by the `BlockAlias` class which contains the hashmap of custom aliases and block pairs. The hashmap will have the `custom alias name` as the `key` and the `block name` as the `value` for each key-value pair.

The `AddCustomAliasCommand`, `ShowCustomAliasCommand` and `DeleteCustomAliasCommand` classes extends the `Command` class. These command classes contain the respective `execute` functions for adding, viewing and deleting the user's custom aliases.

The `Storage` class has the feature to save the custom aliases into a local file so that users can load back their custom alias names when restarting the app.

Given below is an example usage scenario and how the add/view/delete mechanism behaves at each step:

Step 1. The user launches the application for the first time. If there is a storage file with pre-exisiting alias-block pairs, then the hashmap in `BlockAlias` class will be initialized with those data and an empty hashmap if it does not exist.  

Step 2. The user executes `add alias` command. The user input will be parsed by the `Parser` which will create a new `AddCustomAliasCommand` command. The new command will invoke the UI which will prompt the user `Enter the block:` to input the block name and `Enter the alias name:` to input the alias name that the user wants. The UI parser will then check if the entered block and alias are valid and throw an exception if they are not.  

Step 3. The entered alias and block pair will then be put into a temporary hashmap which will then be merged with the main hashmap in the instance of the BlockAlias.  

Step 4. The user executes `show alias` command. The user input will be parsed by the `Parser` which will create a new `ShowCustomAliasCommand` command. The new command will then invoke the UI which will print `It seems that you do not have any aliases` if the hashmap is empty or it will print the alias-block pairs in new lines when the hashmap has been previously populated.  

Step 5. The user executes `delete alias` command. The user input will be parsed by the `Parser` which will create a new `DeleteCustomAliasCommand` command. The new command will then invoke the UI which will prompt the user `Enter the alias name that you wish to delete:` where the user will enter the alias name that the wish to remove. The user input for the alias to be removed will be checked against the hashmap and return an exception if the key does not exist. If the alias to be removed exists in the hashmap, the key-value pair will be removed and `Got it! Successfully deleted ALIASTOREMOVE from the aliases` will be displayed to the user.  

Step 6. The user executes `bye` and exits the app. This will invoke the instance of the `Storage` class which will convert the hashmap into the text file format and append to the text file to save the alias data locally.    

#### Design Consideration
Alternative 1 (current choice): Each command to add, view and delete are implemented using separate classes.  
Pros: Easy to understand and each command is standalone.  
Cons: Might have to repeat some code fragments.  

Alternative 2: Place all commands (add, view, delete) as functions in 1 command class.  
Pros: Lesser code to be written and hashmap can be shared by the 3 commands in 1 class.  
Cons: Might be confusing since there is less distinction between each command.

### Target user profile

NUSMaze is targeted at NUS engineering freshman, to help new students find their way to their destination blocks.

### Value proposition

The engineering block is extremely huge, and the layout of the blocks may be confusing for new students. To reduce the time wasted on navigating the numerous blocks in Engineering, NUSMaze will provide the shortest route available for students to take.

## User Stories

|Version| As a ... | I want to ... | So that I ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|can refer to them when I forget how to use the application|
|v1.0|user|have a clear path to my destination|will not get lost|
|v1.0|user|be able to pin a note to certain locations as a reminder|do not forget|
|v1.0|user|keep track of my search history|don't have to repeatedly search for the same route.|
|v1.0|user|have a clear interface in which I can enter my commands|can have a good user experience|
|v2.0|user|find the nearest eatery|do not have to starve for longer than necessary|
|v2.0|user|have a list of favorite locations|can access directions to them quickly|
|v2.0|user|have my list of favourites and history stored|can access it every time I start the app|
|v2.0|user|be able to set custom aliases to blocks|can access the blocks more conveniently|
|v2.0|user|be able to store my routing for my daily activities|can access it easily|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
