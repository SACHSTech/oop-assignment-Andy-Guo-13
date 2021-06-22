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

## Other useful information
Air cadet squadrons in Canada have a number as well as a name (usually of an aicraft). For example:
* 8 Globemaster
* 778 Banshee
* 351 Silver star

The squadron I created has is called "ICS4U", which is the course code of our computer science class, and the squadron number 21 represents the year 2021 in which this course took place.

Something else you might find useful is the ranks. There are 2 sets of ranks - cadet ranks, and officer ranks. Cadet ranks can be related to a NCM (non-commissioned member) rank (as cadets are not officially part of the military), but the officers that run cadet squadrons are very much real commissioned officers. In our program, the and officer ranks are the short form of the ranks. From lowest to highest, here are the cadet ranks:

1. Cdt - Cadet: This is the lowest rank
2. LAC - Leading Air Cadet: 6 months after joining cadets, your are elegible to be promoted to LAC
3. Cpl - Corporal: after completing your first year of training, and at least 6 months as LAC, you can be promoted to Cpl
4. FCpl - Flight Corporal: after completing your second year of training, and at least 6 months as Cpl, you can be promoted to FCpl. The CF equivalent of FCpl would be MCpl (master corporal)
5. Sgt - Sergeant: after completing your third year of training, and at least 6 months as FCpl, you are elegible for promotion to Sgt. You must also be recommended by an officer for this promotion.
6. FSgt - Flight Sergeant: after completing your fourth year of training, and at least 6 months as Sgt, you are elegible for promotion to FSgt. You must also be recommended by an officer for this promotion. FSgt's usually become flight commanders. There is no CF equivalent to FSgt (there is no master sergeant); the closest rank would be warrant officer (WO).
7. WO2 - Warrant Officer Second Class: The first rank where you are addressed as "sir" or "ma'am". From WO2 upwards (including all officer ranks), you address the person as "sir"/"ma'am". You must have been FSgt for at least 6 months, recommended by an officer, and pass a merit review board (which includes a file review and a physical interview). The CF equivalent to WO2 would be master warrant officer (MWO).
8. WO1 - Warrant Officer First Class: The final rank a cadet can achieve. You must have been a WO2 for at least 6 months, recommended by an officer, and gone through a merit review board. WO1 is particularly difficult to achieve as generally, each squadron only has one of them. WO1's generally are the chief warrant officer of the squadron. The CF equivalent to WO1 would be CWO (chief warrant officer) as a rank, rather than a position of power.

I'm not 100% sure how officers work, but I know their ranks from bottom to top. Officers automatically outrank any NCM or cadet, and are all addressed as "sir"/"ma'am". With the exception of OCdt, all other officers must be saluted (assuming you have the correct headdress). Here they are:

1. OCdt - Officer Cadet
2. 2Lt - Second Lieutenant (pronounced "Left-tenant")
3. Lt - Lieutenant
4. Capt - Captain (usually the CO of a smaller cadet squadron)
5. Maj - Major (usually the CO of a larger cadet squadron)
6. LCol - Lieutenant Colonel ("Left-tenant kernal")
7. Col - Colonel
8. BGen - Brigadier-General
9. MGen - Major-General
10. LGen - Lieutenant-General
11. Gen - General