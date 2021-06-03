[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4831635&assignment_repo_type=AssignmentRepo)
# ICS4U OOP Assignment

![Class Diagram](https://user-images.githubusercontent.com/82901825/120579442-8161b480-c3f5-11eb-8be8-17f2fc808166.png)  

## Summary
The system that is being modeled is a database for the chain of command of an air cadet squadron. The first thing we must do is to create a person object, that includes general information like name, ID number, rank, email and password. There are more specific classes of persons, which are cadets and officers. Cadets are persons with summer training experience, as well as marks on evaluations, while officers are persons with a salary.

Flights are the air equivalent of a platoon: groups of cadets, normally containing about 20-30 cadets. In this program, the flight class is a class that contains an array of cadets, as well as an additional special cadet who is the flight commander (as well as having a name).

Squadrons are the air equivalent of a company; they usually contain about 4-5 flights, and have both an NCM (cadet) and comissiend officer in charge of the squadron. In this program, the squadron class contains an array of flights, as well as a special cadet, who is chief of the squadron, and a commanding officer. It also contains an array of officer who work at the squadron.

## Instructions
When you start the program, there are a list of instructions. Basically, I have already created a squadron for you to tinker around with when the program is running. The pre-made squadron consists of Mr. Fabroa as the CO, myself as the Chief Warrant Officer, and the 2021 quadmester 4 ICS4U students as cadets in the squadron. They were divided into 3 flights according to alphabetical order, with the person highest up alphabetically being the flight commander (I did not pick favourites). 

The first thing the program will ask you to do is to login as a member of the ICS4U squadron. Everyone is assigned a unique ID number (nothing fancy, it just increments everytime a new person is created). You will need your unique ID and password to login. Assuming no changes are made to the program, mr. Fabroa's ID is **1000017** and password is **pw**. Every user's password is "pw" by default, but you can change your password when you login.

There are 3 types of users. Cadets, Flight commanders and officers. Depending on the type of user that logged in, they have different privileges, which are as follows:

Cadets
* View information on the entire squadron
* Viewing their summer training courses
* Viewing how they did on evaluations (by default, every evaluation gets an "incomplete")
* Changing their password
* Logging out

Flight commanders
* They can do everything cadets can do as well as...
* View information on summer training for cadets in their flight
* View information for evaluations for cadets in their flight
* Add a summer training course for a cadet in their flight
* Modify the mark a cadet receives on one of their evaluations
* Add or remove a cadet from their flight

Officers
* They can do everything flight commanders can, but for the entire squadron, as well as...
* Moving a cadet from one flight to another
* Adding a new flight
* Removing a flight
* Adding or removing an officer to the squadron

Mr. Fabroa's account type is an officer, so he can do everything listed above. As a side note, the chief warrant officer also has an officer type account, even though the chief is a cadet.

If you decide to view information on the entire squadron (or as the program calls it, "print the squadron"), you can see everyone's ID, and role in the squadron, so you can use their ID and password ("pw") to login and explore as a flight commander or cadet.