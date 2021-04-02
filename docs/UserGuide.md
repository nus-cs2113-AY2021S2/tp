
# Movie Booking System User Guide

## Introduction

Welcome to MovieApp! Here, you can book a movie, see the upcoming shows and read movie reviews to watch!

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `MovieApp` from [here](https://github.com/AY2021S2-CS2113-T10-3/tp/releases/tag/v2.0).
3. Copy the file to the folder you want to use as the home folder for your MovieApp.
4. Open your terminal / command prompt. Direct it to the folder which contains MovieApp file. Type `java -cp MovieApp.jar movieApp.app.MovieApp` to run the app. This interface should appear if you successfully run it.

5. To use the app, follow the instructions given in the app and type the menu of your choice. e.g

   ======== Menu Choice =======

   1 View Movies

   2 Exit

The following will execute if you type:

* `1` : View all movies and choose a search filter.

* `2` : Exit from the application.



## Features
### General User Guide


> -------------------Login----------------  
> Enter Name: (input "out" to quit the application)  
> Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!
> Enter Password :


**1. Login: `username password`**
Allowing to choose the mode “Admin” or “Customer” based on user’s account.

**Format**: `USERNAME  PASSWORD`

**Example**:
1. Customer Account
   Input:
   `alex`  
   `12345`

   Display:
> -------------------Login----------------
> Enter Name: `alex`
> Due to a bug in some IDEs, password masking is disabled. Please only run this
> program on the console!
> Enter Password : `12345`       
> Welcome, alex  
> ======== Menu Choice =======
> 1 View Movies
> 2 Exit ============================
> Please indicate your choice:


2. Admin Account
   Input:
   `IRVIN`  
   `password1`

   Display:

>  -------------------Login----------------
>  Enter Name: `IRVIN`
>  Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!
>  Enter Password : `password1`      
>  Welcome, IRVIN
>  ======== Menu Choice =======
>  1 View Movies
>  2 Add Movie
>  3 Delete Movie
>  4 Update Movie
>  5 Logout ============================
> Please indicate your choice:


**2. Exit the app: `out`**  
Exit the app from login page

**Format**: `out`

**Display:**


>  Thank you for your time.
>  Have a good day!
>
>  System Exiting…

 ___________  

###  Customer Main Menu




> ======== Menu Choice =======   
> 1 View Movies   
> 2 Exit  
============================

Please indicate your choice:

**1. View all movies and all movie filter: `1`**  
View all movies and movie filters.

**Format**: 1  
**Display**:


> ======= Movie Filter =======   
> 1 Filter by genre   
> 2 Filter by rating   
> 3 Filter by showing status   
> 4 Filter by cineplex   
> 5 Filter by title
> 6 Select movie   
> 7 Clear all filters   
> 8 Back to Main Menu
> ============================   Please indicate your choice:

**2. Exit the app: `2`**  
Exit and terminate the app.

**Format**: `2`  
**Display**:

> Thank you for your time.   
> Have a good day!
>
> Logging out...


  ___________  

### View Movie Guide



> ======= Movie Filter =======   
> 1 Filter by genre   
> 2 Filter by rating   
> 3 Filter by showing status   
> 4 Filter by cineplex   
> 5 Filter by title
> 6 Select movie   
> 7 Clear all filters   
> 8 Back to Main Menu
============================

**1. Filter by genre: 1**  
Filter movies by genre.

**Format**: 1
**Display:**

> ===========================
> Movie List:
> 1. Alita: Battle Angel
> 2. Avengers: Endgame
> 3. Toy Story 4
> 4. Joker
> 5. Frozen 2
>
> ===== Filter by Genre ======  
> ======= Select Genre =======   
> 1 Sci-fi  
>  2 Action   
>  3 Comedy   
>  4 Family   
>  5 Horror  
>   6 Romance  
>    7 Drama  
> ============================   Please indicate your choice:



**Example**:

    5 

**Display:**


> The selected genre is: Horror
>
>
> ===========================   Movie List:
> 1. It Chapter Two
> 2. Midsommar
> 3. The Addams Family
> 4. Annabelle Comes Home
     > ===========================




**2. Filter by rating: `2`**  
Filter movie by the rating .

**Format**: 2  
**Display**:
> ===========================   Movie List:
> 1. Alita: Battle Angel
> 2. Incredibles 2    ===========================  
     > ===== Filter by Rating =====   
     > Select the cut-off rating (0-5):

**Example**:

    3  


**Display:**


> The selected cut-off rating is: 3.0     
> ===========================   Movie List:
> 1. Alita: Battle Angel
> 2. Avengers: Endgame
> 3. Toy Story 4
> 4. Joker
> 5. Frozen 2
> 6. Charlie's Angels
> 7. The Lion King    ===========================

**3. Filter by status: `3`**  
Filter by show status (Coming Soon, Pre-Order, Now Showing, End of Showing).

**Format**: `3`  
**Display**:


> = Filter by Showing Status =  
> ======= Select Genre =======  
> ===Select Showing Status ===   
> 1 Coming Soon   
> 2 Pre-Order   
> 3 Now Showing   
> 4 End of Showing  
> ============================   Please indicate your choice:


**Example**:

    2 


**Display:**

> The selected showing status is: PREORDER      
> Sorry! We couldn't find any matches.
> Would you like to try something else?

**4. Filter by cineplex: `4`**  
Filter by cinema location (Coming Soon, Pre-Order, Now Showing, End of Showing).

**Format**: `4`  
**Display:**


> ==== Filter by Cineplex ====   
> 1 Jurong Point   
> 2 VivoCity   
> 3 Bishan  
> ============================   Please indicate your choice:


**Example**:

    2 


**Display**:

> The selected cineplex is: VivoCity     
> ===========================   Movie List:
> 1. Toy Story 4
> 2. Joker
> 3. The Lion King
> 4. Jumanji: The Next Level
> 5. Aladdin
> 6. Maleficent: Mistress of Evil    ===========================



**5. Filter by title: `5`**  
Filter movie by title keyword.

**Format**: `5`  
**Display:**


> ===========================
> Movie List:
> 1. Toy Story 4
> 2. Joker
> 3. The Lion King
> 4. Jumanji: The Next Level
> 5. Aladdin
> 6. Maleficent: Mistress of Evil  
     >  ===========================  
     > ===== Filter by Title ======   
     > Search:

**Example:**

    next


**Display:**

>    movies containing next     
> ===========================   Movie List:
> 1. Jumanji: The Next Level    ===========================


**6. Select a movie: `6`**  
Select a movie to view information about the movie and book the code.

**Format**: `6`  
**Display**:


> ===========================   
> Movie List:
> 1. Alita: Battle Angel
> 2. Avengers: Endgame
> 3. Toy Story 4
> 4. Joker
> 5. Frozen 2
> 6. Charlie's Angels
> 7. The Lion King
> 8. Jumanji: The Next Level
> 9. It Chapter Two    ===========================  
     > ======= Select Movie =======   
     > Please indicate your choice:

**Example:**

    5  

Display:

> ===========================   
> Movie List:
>  Frozen 
> ===========================
> 
> ======== Menu Choice ====== 
> 1. Buy ticket   
> 2. View movie details
> 3. Add review   
> 4. Go back  
> ============================   
> Please indicate your choice:


**7. Clear all filters:  `7`**  
Select a movie to view information about the movie and book the code.

**Format:** `7`  
**Display:**



> ===========================   
> Movie List:
> 1. Alita: Battle Angel
> 2. Avengers: Endgame
> 3. Toy Story 4
> 4. Joker
> 5. Frozen 2
> 6. Charlie's Angels
> 7. The Lion King
> 8. Jumanji: The Next Level
> 9. It Chapter Two
> 10. Captain Marvel
> 11. Midsommar
> 12. Little Women
> 13. The Addams Family
> 14. Aladdin
> 15. Annabelle Comes Home
> 16. Maleficent: Mistress of Evil
> 17. Spider-Man: Far From Home
> 18. Incredibles 2
> 19. Black Panther
> 20. A Star Is Born    ===========================

**8. Go back to main menu: `8`**  
Go back to access the main menu.

**Format**: `8`  
**Display**:
[Customer]


> ======== Menu Choice =======   
> 1 View Movies   
> 2 Exit  
> ============================   Please indicate your choice:


[Admin]


> ======== Menu Choice =======   
> 1 View Movies   
> 2 Add Movie   
> 3 Delete Movie   
> 4 Update Movie   
> 5 Logout  
> ============================   Please indicate your choice:
---

### Selected Movie Menu


> ======== Menu Choice =======   
> 1 Buy ticket   
> 2 View movie details  
>  3 Add review   
>  4 Go back  
============================


**1. Buy ticket:  `1`**  
Buy ticket of the selected movie.

**Format**: `1`  
**Display**:

> ======== Book Ticket ========   
> The movie is not available for sale.
> COMING SOON



**2. View movie details:  `2`**  
View the details of selected movie.

**Format**: `2`  
**Display**:


> ====================================================================   Movie Title: Frozen 2   
> Overall Rating: 5.0   
> Start Date: Mon Dec 02 00:00:00 SGT 2019   
> End Date: Fri Feb 14 00:00:00 SGT 2020   Showing
> Status: COMINGSOON  
> ====================================================================   Genre: Comedy   
> Director: Jennifer Lee   
> Cast:   Idina Menzel  ,
> Kristen Bell  ,  Jonathan Groff  ,  Josh Gad   Santino Fontana ,  Evan Rachel Wood   , Alfred Molina     
>  Synopsis: Elsa the Snow Queen and her
> sister Anna embark on an adventure far away from the kingdom of Arendelle. They are joined by friends, Kristoff, Olaf, and Sven.
>
> ====Reviews====
=======================
> Review No. 1:   
> Rating: 5   
> Rating content: great movie concept!




**3. Add review: `3`**  
Add new review for the selected movie

**Format**: 3  
**Display:**

> Comment:   
> Rating:


Example:

    It’s very good  
    5  

Display:

> Comment:   `it's very good!`   
> Rating: `5`   
> The comment ' it's very good! ' and the rating 5 have been successfully added to the movie Frozen 2.
> Thank you for your review!



**4. Back to main menu: `4`**  
Go back to access the main menu

**Format**: `4`  
**Display**:
[Customer]


> ======== Menu Choice =======   
> 1 View Movies   
> 2 Exit  
> ============================   Please indicate your choice:
