# Wildlife-Tracker
### By **Peter Njenga**
## Description
A java A java-Spark application that allows Rangers to track wildlife sightings in the area.
## Setup/Installation Requirements
* Open Terminal {Ctrl+Alt+T}
* clone ```https://github.com/han254/Wildlife-Tracker.git```.
* Enter into the folder (cd Wildlife-Tracker ).
* open your IDE (e.g  IntelliJ IDEA)

### SQL Installation/ Setup.
1.Launch postgres

2.Type in psql

Run these commands

3. CREATE DATABASE Wildlife_Tracker;

4. \c wildlife_tracker;

5. CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);

6. CREATE TABLE Wildlife_Tracker=# CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar);

7. CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;



### Author's Information
* Github: [Peter Njenga](https://github.com/han254)
* Twitter handle: [https://twitter.com/Hanselpeter4]
* LinkedIn: [www.linkedin.com/in/peter-njenga]
## Technologies Used
* Java
* Spark
* CSS
* SQL
### Support and contact details

You can contact me through my email[peternjenga1706@gmail.com]

### License

Copyright (c) 2022 [click here to view license](LICENSE)