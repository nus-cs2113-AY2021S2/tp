
# Movie Booking System User Guide

## Introduction

MovieApp is a desktop app for users to see the upcoming shows, book a movie and read movie reviews.
The app is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, MovieApp can help you view and book movies conveniently.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `MovieApp` from [here](https://github.com/AY2021S2-CS2113-T10-3/tp/releases/tag/v2.1).
3. Copy the file to the directory you want to use as the home directory for your MovieApp.
4. Open your terminal / command prompt. Direct it to the folder which contains MovieApp file. Type `java -jar tp.jar` to run the app. This interface should appear if you successfully run it.
```
___  ___           _       ___                    
|  /  |          (_)     / _                  
| .  . | _____   ___  ___/ /_ _ __  _ __      
| |/| |/ _   / / |/ _   _  | '_ | '_  
| |  | | (_)  V /| |  __/ | | | |_) | |_) |     
_|  |_/___/ _/ |_|____| |_/ .__/| .__/  
                               | |   | |          
                               |_|   |_|            
-------------------Login----------------
Enter Name: (input "out" to quit the application)
```

5. Launching the application for the first time will automatically create four new files in the current directory.

6. Enter the credentials to utilize the application as either an admin or a customer using the sample below.

## Features
### General User Guide

```
-------------------Login----------------  
Enter Name: (input "out" to quit the application)  
Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!
Enter Password :
```

**1. Login: `username password`**
Allowing to choose the mode “Admin” or “Customer” based on user’s account.

**Format**: `USERNAME  PASSWORD`

**Example**:
1. Customer Account
   Input:
```
   customer1  
   password1
```

<details><summary markdown="span"> <strong>Display:</strong> </summary>

```
 ___  ___           _       ___                    
 |  \/  |          (_)     / _ \                 
 | .  . | _____   ___  ___/ /_\ \_ __  _ __      
 | |\/| |/ _ \ \ / / |/ _ \  _  | '_ \| '_ \ 
 | |  | | (_) \ V /| |  __/ | | | |_) | |_) |     
 \_|  |_/\___/ \_/ |_|\___\_| |_/ .__/| .__/  
                                | |   | |          
                                |_|   |_|            
 -------------------Login----------------
 Enter Name: (input "out" to quit the application)
 customer1
 Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!
 Enter Password :
 password1
 
 Welcome, CUSTOMER1
 
 ======== Menu Choice =======
  1 View Movies
  2 Exit
 ============================
 Please indicate your choice:
```

</details>

2. Admin Account
   Input:
```
   admin1  
   password1
```
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
  ___  ___           _       ___                    
  |  \/  |          (_)     / _ \                 
  | .  . | _____   ___  ___/ /_\ \_ __  _ __      
  | |\/| |/ _ \ \ / / |/ _ \  _  | '_ \| '_ \ 
  | |  | | (_) \ V /| |  __/ | | | |_) | |_) |     
  \_|  |_/\___/ \_/ |_|\___\_| |_/ .__/| .__/  
                                 | |   | |          
                                 |_|   |_|            
  -------------------Login----------------
  Enter Name: (input "out" to quit the application)
  admin1
  Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!
  Enter Password :
  password1
  
  Welcome, ADMIN1
  
  ======== Menu Choice =======
   1 View Movies
   2 Add Movie
   3 Delete Movie
   4 Update Movie
   5 Logout
  ============================
  Please indicate your choice:
```
</details>

**2. Exit the app: `out`**  
Exit the app from login page

**Format**: `out`

<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
 Thank you for your time.
 Have a good day!

 System Exiting…
```
</details>
 ___________  

###  Customer Main Menu

```
======== Menu Choice =======   
1 View Movies   
2 Exit  
============================
Please indicate your choice:
```

**1. View all movies and all movie filter: `1`**  
View all movies and movie filters.

**Format**: 1  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
======= Movie Filter =======   
1 Filter by genre   
2 Filter by rating   
3 Filter by showing status   
4 Filter by cineplex   
5 Filter by title
6 Select movie   
7 Clear all filters   
8 Back to Main Menu
============================   
Please indicate your choice:
```
</details>

**2. Exit the app: `2`**  
Exit and terminate the app.

**Format**: `2`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Thank you for your time.   
Have a good day!

Logging out...
```

</details>
  ___________  

### View Movie Guide


```
======= Movie Filter =======   
1 Filter by genre   
2 Filter by rating   
3 Filter by showing status   
4 Filter by cineplex   
5 Filter by title
6 Select movie   
7 Clear all filters   
8 Back to Main Menu
============================
```

**1. Filter by genre: 1**  
Filter movies by genre.

**Format**: 1
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Please indicate your choice:
1
===== Filter by Genre ======
======= Select Genre =======
 1 Sci-fi
 2 Action
 3 Comedy
 4 Family
 5 Horror
 6 Romance
 7 Drama
============================
```
</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


` 2 `


**Display**:

```
===== Filter by Genre ======
======= Select Genre =======
 1 Sci-fi
 2 Action
 3 Comedy
 4 Family
 5 Horror
 6 Romance
 7 Drama
============================
Please indicate your choice:
2
The selected genre is: Action

============================
Movie List:
1. Tenet (5.0)
2. Wonder Woman 1984 (3.0)
3. Birds of Prey (3.3)
4. Avengers: Endgame (3.0)
5. Charlie's Angels (1.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.
```
</details>



**2. Filter by rating: `2`**  
Filter movie by the rating .

**Format**: 2  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
Please indicate your choice:
2
===== Filter by Rating =====
Select the cut-off rating (0-5):
```

</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>

`3`  

**Display**:

```
===== Filter by Rating =====
Select the cut-off rating (0-5): 
3
The selected cut-off rating is: 3.0

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
5. The Invisible Man (3.0)
6. Avengers: Endgame (3.0)
7. Toy Story 4 (5.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.
```

</details>

**3. Filter by status: `3`**  
Filter by show status (Coming Soon, Pre-Order, Now Showing, End of Showing).

**Format**: `3`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
= Filter by Showing Status =
======= Select Genre =======
== Select Showing Status ===
 1 Coming Soon
 2 Pre-Order
 3 Now Showing
 4 End of Showing
============================
Please indicate your choice:
```

</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>

`3` 

**Display**:


```
= Filter by Showing Status =
======= Select Genre =======
== Select Showing Status ===
 1 Coming Soon
 2 Pre-Order
 3 Now Showing
 4 End of Showing
============================
Please indicate your choice:
3

The selected showing status is: NOWSHOWING

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.
```

</details>

**4. Filter by cineplex: `4`**  
Filter by cinema location (Coming Soon, Pre-Order, Now Showing, End of Showing).

**Format**: `4`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Please indicate your choice:
4
==== Filter by Cineplex ====
 1 Jurong Point
 2 VivoCity
 3 Bishan
============================
Please indicate your choice:
```
</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


 `2` 

**Display**:


```
==== Filter by Cineplex ====
 1 Jurong Point
 2 VivoCity
 3 Bishan
============================
Please indicate your choice:
1
The selected cineplex is: Jurong Point

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.
```

</details>

**5. Filter by title: `5`**  
Filter movie by title keyword.

**Format**: `5`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Please indicate your choice:
5
===== Filter by Title ======
Search: 
```
</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


 `The`

**Display**:


```
===== Filter by Title ======
Search: 
The
The selected keyword is: The

============================
Movie List:
1. The Invisible Man (3.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.
```

</details>

**6. Select a movie: `6`**  
Select a movie to view information about the movie and book the code.

**Format**: `6`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Please indicate your choice:
6
======= Select Movie =======

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
5. The Invisible Man (3.0)
6. Avengers: Endgame (3.0)
7. Toy Story 4 (5.0)
8. Joker (No ratings yet. You can start by adding one!)
9. Frozen 2 (No ratings yet. You can start by adding one!)
10. Charlie's Angels (1.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.

Please indicate your choice:
```

</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


 `1`  

**Display**:

```
======= Select Movie =======

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
5. The Invisible Man (3.0)
6. Avengers: Endgame (3.0)
7. Toy Story 4 (5.0)
8. Joker (No ratings yet. You can start by adding one!)
9. Frozen 2 (No ratings yet. You can start by adding one!)
10. Charlie's Angels (1.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.

Please indicate your choice:
1

======== Menu Choice =======
 1 Buy ticket
 2 View movie details
 3 Add review
 4 Go back
============================
Please indicate your choice:
```

</details>

**7. List all filtered movies:  `7`**  
List movies based on the filters performed.

**Format:** `7`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
Please indicate your choice:
7

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
5. The Invisible Man (3.0)
6. Avengers: Endgame (3.0)
7. Toy Story 4 (5.0)
8. Joker (No ratings yet. You can start by adding one!)
9. Frozen 2 (No ratings yet. You can start by adding one!)
10. Charlie's Angels (1.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.

```

</details>

**8. Clear all filters:  `8`**  
Clear all selected filters.

**Format:** `8`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>



```
Please indicate your choice:
8

============================
Movie List:
1. Tenet (5.0)
2. Soul (4.0)
3. Wonder Woman 1984 (3.0)
4. Birds of Prey (3.3)
5. The Invisible Man (3.0)
6. Avengers: Endgame (3.0)
7. Toy Story 4 (5.0)
8. Joker (No ratings yet. You can start by adding one!)
9. Frozen 2 (No ratings yet. You can start by adding one!)
10. Charlie's Angels (1.0)
============================
To select a single movie, select "6 Select movie" from the Movie Filter menu below.

```

</details>

**10. Go back to main menu: `10`**  
Go back to access the main menu.

**Format**: `10`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

[Customer]

```
======== Menu Choice =======   
1 View Movies   
2 Exit  
============================   
Please indicate your choice:
```

</details>

 ___________  

### Selected Movie Menu

```
======== Menu Choice =======   
1 Buy ticket   
2 View movie details  
3 Add review   
4 Go back  
============================
```

**1. Buy ticket:  `1`**  
Buy ticket of the selected movie.

**Format**: `1`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
======== Book Ticket ========

Enter 0 for the timing below: 
--------------------------
[Timing] 2021/5/19 19:12
[Location] Cineplex: Jurong Point -> Cinema: 2

Enter 1 for the timing below: 
--------------------------
[Timing] 2021/5/19 19:12
[Location] Cineplex: Jurong Point -> Cinema: 3

Enter 2 for the timing below: 
--------------------------
[Timing] 2021/5/19 19:12
[Location] Cineplex: VivoCity -> Cinema: 6

Enter 3 for the timing below: 
--------------------------
[Timing] 2021/5/19 19:12
[Location] Cineplex: Bishan -> Cinema: 9

>>Please enter your choice: (input "back" to go back)
2
You have selected: 
--------------------------
[Timing] 2021/5/19 19:12
[Location] Cineplex: VivoCity -> Cinema: 6
There are 30 empty seats.
How many tickets do you need? 
3
---------------- <THE SCREEN>-----------------

columns  1     2     3     4     5     6     
row 1   --    --    --    --    --    --  
row 2   --    --    --    --    --    --  
row 3   --    --    --    --    --    --  
row 4   --    --    --    --    --    --  
row 5   --    --    --    --    --    --  

Please select the seat for buyer No. 1
Please enter the row number:  
2
Please enter the column number: 
4
Buyer no 1's seat = [2, 4]
---------------- <THE SCREEN>-----------------

columns  1     2     3     4     5     6     
row 1   --    --    --    --    --    --  
row 2   --    --    --    XX    --    --  
row 3   --    --    --    --    --    --  
row 4   --    --    --    --    --    --  
row 5   --    --    --    --    --    --  

Please select the seat for buyer No. 2
Please enter the row number:  
1
Please enter the column number: 
6
Buyer no 2's seat = [1, 6]
---------------- <THE SCREEN>-----------------

columns  1     2     3     4     5     6     
row 1   --    --    --    --    --    XX  
row 2   --    --    --    XX    --    --  
row 3   --    --    --    --    --    --  
row 4   --    --    --    --    --    --  
row 5   --    --    --    --    --    --  

Please select the seat for buyer No. 3
Please enter the row number:  
3
Please enter the column number: 
2
Buyer no 3's seat = [3, 2]
---------------- <THE SCREEN>-----------------

columns  1     2     3     4     5     6     
row 1   --    --    --    --    --    XX  
row 2   --    --    --    XX    --    --  
row 3   --    XX    --    --    --    --  
row 4   --    --    --    --    --    --  
row 5   --    --    --    --    --    --  

The Transaction is made, total ticket number: 3 
==========================================
Movie Title:     Tenet
Show Time:       Wed May 19 19:12:32 SGT 2021
Seats Booked:    [2,4] [1,6] [3,2] 
Status:          COMPLETED
Date Booked:     Mon Apr 12 19:21:27 SGT 2021
==========================================
```

</details>


**2. View movie details:  `2`**  
View the details of selected movie.

**Format**: `2`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
====================================================================   Movie Title: Frozen 2   
Overall Rating: 5.0   
Start Date: Mon Dec 02 00:00:00 SGT 2019   
End Date: Fri Feb 14 00:00:00 SGT 2020   Showing
Status: COMINGSOON  
====================================================================   Genre: Comedy   
Director: Jennifer Lee   
Cast:   Idina Menzel,
Kristen Bell,  Jonathan Groff,  Josh Gad   Santino Fontana ,  Evan Rachel Wood   , Alfred Molina     
Synopsis: Elsa the Snow Queen and her
sister Anna embark on an adventure far away from the kingdom of Arendelle. They are joined by friends, Kristoff, Olaf, and Sven.
>
====Reviews====
=======================
Review No. 1:   
Rating: 5   
Rating content: great movie concept!
```

</details>


**3. Add review: `3`**  
Add new review for the selected movie

**Format**: 3  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Comment:   
Rating:
```
</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


```
    It’s very good  
    5  
```

**Display**:

```
Comment:   it's very good!
Rating: 5
The comment 'it's very good!' and the rating 5 have been successfully added to the movie Frozen 2.
Thank you for your review!
```

</details>

**4. Back to main menu: `4`**  
Go back to access the main menu

**Format**: `4`  
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

[Customer]

```
======== Menu Choice =======   
1 View Movies   
2 Exit  
============================   
Please indicate your choice:
```
</details>

 ___________  

###  Admin Main Menu

```
======== Menu Choice =======   
1 View Movies   
2 Add Movie   
3 Delete Movie   
4 Update Movie   
5 Logout  
============================
Please indicate your choice:
```

**1. View all movies and all movie filter: 1**  
Same as Customer Main Menu.


**2. Add Movie: 2**  
Add a new movie to the movie list.

**Format**: `2` 

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>

```
    Hi, Mom
    12
    2
    2021
    1
    2
    2021
    Jia Ling
    Jia Ling, Shen Teng, Zhang Xiaofei, Chen He, Liu Jia, He He, Ding Jiali, Bao Wenjing, Han Yunyun, Wang Lin, Xu Juncong, Qiao Shan
    3
    After her mother Li Huanying is fatally injured in a car accident in 2001, grief-stricken Jia Xiaoling finds herself transported back in time to the year 1981, where she becomes her mother's close friend.
```

**Display**:

```
Movie title: 
Hi, Mom
Hi, Mom
16
Enter movie start date 
Date (DD): 
12
Month (MM): 
2
Year (YYYY): 
2021
Enter movie end date 
Date (DD): 
1
Month (MM): 
5
Year (YYYY): 
2021
Movie director: 
Jia Ling
Movie casts (separated with comma) : 
Jia Ling, Shen Teng, Zhang Xiaofei, Chen He, Liu Jia, He He, Ding Jiali, Bao Wenjing, Han Yunyun, Wang Lin, Xu Juncong, Qiao Shan 
======= Select Genre =======
 1 Sci-fi
 2 Action
 3 Comedy
 4 Family
 5 Horror
 6 Romance
 7 Drama
============================
Please indicate your choice:
3
Movie synopsis: 
After her mother Li Huanying is fatally injured in a car accident in 2001, grief-stricken Jia Xiaoling finds herself transported back in time to the year 1981, where she becomes her mother's close friend.
The new movie "Hi, Mom" have been saved to the database.
```

</details>

**3. Delete Movie: 3**  
Delete a movie in the movie list.

**Format**: `3` 
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Select a movie to be deleted from the list (enter the number)
1. Alita: Battle Angel
2. Avengers: Endgame
3. Toy Story 4
4. Joker
5. Frozen 2
6. Hi, Mom
Please enter your choice: 
```
</details>


<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>


 `6`

**Display**:

```
The movie has been removed from the database. 
```
</details>

**4. Update Movie: 4**  
Update the movie details of a movie in the movie list.

**Format**: `4` 
<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>


```
Select a movie to be edited from the list (enter the number)
1. Alita: Battle Angel
2. Avengers: Endgame
3. Toy Story 4
4. Joker
5. Frozen 2
Please enter your choice: 
```
</details>

<details>
  <summary markdown="span"> <strong>Example:</strong> </summary>

```
    1
    3
    Set several centuries in the future, the abandoned Alita is found in the scrapyard of Iron City by Ido, a compassionate cyber-doctor who takes the unconscious cyborg Alita to his clinic. As Alita learns to navigate her new life and the treacherous streets of Iron City, Ido tries to shield her from her mysterious past.
```

**Display**:

```
You have selected Alita: Battle Angel

======= Edit Movie =======
 1 Edit title
 2 Edit director
 3 Edit synopsis
 ============================
Please indicate your choice:
3
Current synopsis: Set several centuries in the future, the abandoned Alita is found in the scrapyard of Iron City by Ido, a compassionate cyber-doctor who takes the unconscious cyborg Alita to his clinic. When Alita awakens, she has no memory of who she is, nor does she have any recognition of the world she finds herself in. As Alita learns to navigate her new life and the treacherous streets of Iron City, Ido tries to shield her from her mysterious past.
Insert new synopsis:
Set several centuries in the future, the abandoned Alita is found in the scrapyard of Iron City by Ido, a compassionate cyber-doctor who takes the unconscious cyborg Alita to his clinic. As Alita learns to navigate her new life and the treacherous streets of Iron City, Ido tries to shield her from her mysterious past.
The changes have been saved to the database.
```
</details>

**5. Logout: 5**  
Logout current admin user.

**Format**: `5` 

<details>
  <summary markdown="span"> <strong>Display:</strong> </summary>

```
Logging out..
```
</details>

## Command Summary  
### Customer  

| Action      | Input Example  |
| :----------- | :----------- |
| View Movies      | 1         |
| Filter movies   | 1, [1-5 for adding filter, 6 to select choice, 7 to remove filters, 8 to return to main page]     |
| Exit Application   | 2         |

### Administrator

| Action      | Input Example |
| :----------- | :----------- |
| View Movies      | 1       |
| Add Movie      | 2, [key in response to prompts]       |
| Delete Movie    | 3, [key in index of movie to be deleted]|
| Update Movie   | 4, [1 for title,2 for director, 3 for synopsis], [key in response to prompts]      |
| Logout   | 5        |
