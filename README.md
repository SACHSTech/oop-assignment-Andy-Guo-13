[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4831635&assignment_repo_type=AssignmentRepo)
# ICS4U OOP Assignment

![Class Diagram](https://user-images.githubusercontent.com/82901825/120579442-8161b480-c3f5-11eb-8be8-17f2fc808166.png)  

## Summary
The system that is being modeled is a database for the chain of command of an air cadet squadron. The first thing we must do is to create a person object, that includes general information like name, ID number, rank, email and password. There are more specific classes of persons, which are cadets and officers. Cadets are persons with summer training experience, as well as marks on evaluations, while officers are persons with a salary.

Flights are the air equivalent of a platoon: groups of cadets, normally containing about 20-30 cadets. In this program, the flight class is a class that contains an array of cadets, as well as an additional special cadet who is the flight commander (as well as having a name).

Squadrons are the air equivalent of a company; they usually contain about 4-5 flights, and have both an NCM (cadet) and comissiend officer in charge of the squadron. In this program, the squadron class contains an array of flights, as well as a special cadet, who is chief of the squadron, and a commanding officer. It also contains an array of officer who work at the squadron.
