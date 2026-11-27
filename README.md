GROCERY EXPIRATION AND
WASTE MONITOR
1. Project Title
Grocery Expiration and Waste Monitor
2. Project Overview
The Grocery Expiration and Waste Monitor is a Java-based, console application designed to help users organize grocery inventory and monitor expiration dates. It allows users to add, view, edit, search, and delete grocery records while keeping track of item quantities, expiration dates, and prices.
The application also allows users to record consumed and wasted grocery items, review waste history, and view a waste report showing estimated losses. Grocery and waste records are stored in local text files so that information can be loaded again when the program is run. The project demonstrates the use of Object-Oriented Programming and file handling in Java.
3. Features
Feature	Description
View Current Groceries	Displays the grocery items currently recorded in the inventory.
Add Grocery	Records a grocery item's name, category, quantity, expiration date, and total price.
Edit Grocery	Allows the user to update information for an existing grocery item.
Search Grocery	Finds grocery records using the item's name.
Delete Grocery	Removes a selected item from the active inventory after confirmation.
Expiration Alerts	Checks for items that are expired or approaching their expiration date.
Log Consumed Grocery	Records consumed quantities and updates the remaining inventory quantity.
Log Wasted Grocery	Records wasted quantities, reasons, and estimated losses.
View Waste History	Displays previously recorded waste entries.
View Waste Report	Shows a report based on the recorded waste information.
Save and Exit	Saves inventory and waste records before closing the application.

4. Technologies Used
Technology	Purpose
Java	Main programming language used to develop the application.
ArrayList	Stores grocery items and waste records while the program is running.
LocalDate	Handles grocery expiration dates and waste record dates.
Java File I/O	Reads and writes grocery and waste information to local text files.
Scanner	Accepts user input through the console.
UUID	Generates unique identifiers for waste records.
GitHub	Hosts the source code and supports project collaboration.

5. Object-Oriented Programming Concepts
Classes and Objects
The project uses classes such as GroceryItem, GroceryManager, WasteRecord, and FileManager. Objects created from these classes represent grocery records and perform application tasks.
Encapsulation
Private attributes protect the data in classes. Getter and setter methods provide controlled access to the information.
Constructors
Constructors initialize objects with the values required for grocery items and other records.
Abstraction
The program separates responsibilities into classes and methods. For example, inventory operations and file operations are handled separately.
Polymorphism
The reporting structure can use a general Report reference to work with a specific WasteReport implementation, where supported by the project code.
6. System Requirements
Hardware Requirements
●	Desktop or laptop computer
●	Keyboard and monitor
●	Sufficient storage for the project and saved data files
Software Requirements
●	Java Development Kit (JDK) installed
●	A Java-supported IDE or editor (such as IntelliJ IDEA, Eclipse, or Visual Studio Code with Java support)
●	An operating system that supports the installed Java version
7. Installation and Execution
1.	Open the project repository: https://github.com/josephdanielcmabalayict-design/Group-8-Project-Grocery-Expiration-and-Waste-Monitor
2.	Download the repository as a ZIP file or clone it using Git.
3.	If you downloaded a ZIP file, extract it to a folder.
4.	Open the project folder in a Java-supported IDE.
5.	Make sure the Java source files are included in the project.
6.	Locate and run Main.java.
7.	Follow the options displayed in the console.
Running Through the Terminal
If all Java source files are in the same folder and do not require a package-specific command, open a terminal in that folder and compile the files:
javac *.java
Then start the program:
java Main
Data Files
The application uses local text files for persistent storage. The expected files include:
●	groceries.txt – stores grocery inventory records.
●	waste_records.txt – stores waste history records.
Use the program's Save and Exit option before closing it so the latest changes can be saved.
8. How to Use the Program
When the application starts, it loads the saved records (if available), checks expiration dates, and displays the main menu.
Option	Menu Item	How It Works
1	View Current Groceries	Displays the grocery items in the inventory.
2	Add Grocery	Enter the item name, category, quantity, expiration date, and total price when prompted.
3	Edit Grocery	Enter the grocery ID and follow the prompts to update the selected information.
4	Search Grocery	Enter the grocery name to look for matching records.
5	Delete Grocery	Enter the grocery ID and confirm the deletion when prompted.
6	Log Consumed Grocery	Enter the grocery ID and the quantity consumed. The quantity must be available in the inventory.
7	Log Wasted Grocery	Enter the grocery ID, quantity wasted, and reason for waste.
8	View Waste History	Displays recorded waste entries.
9	View Waste Report	Displays the waste report.
10	Save and Exit	Saves the records and closes the application.

Example: Adding a Grocery
Select option 2 and enter the requested details. Example:
Field	Example Input
Item name	Milk
Category	Dairy
Quantity	5
Expiration date	2026-12-01
Total price	350

The program should add the grocery record and show its details or generated ID.
Example: Recording Wasted Grocery
8.	Select option 7 (Log Wasted Grocery).
9.	Enter the ID of the grocery item.
10.	Enter the quantity wasted.
11.	Enter the reason for waste, such as expired or spoiled.
12.	Review the recorded entry and estimated loss.
9. Test Cases
The following test cases can be used to check the main functions of the application. Run each test using the program and fill in the Actual Result and Status columns based on what happens during testing.
Test ID	Test Scenario	Test Input / Steps	Expected Result	Actual Result / Status
TC-01	Add a grocery with valid details	Enter a name, category, positive quantity, valid date, and non-negative price.	The grocery item is added to the inventory.	To be tested
TC-02	Add a grocery with invalid quantity	Enter zero or a negative quantity.	The program rejects the invalid quantity or asks for valid input.	To be tested
TC-03	Add a grocery with invalid date	Enter a date that does not follow YYYY-MM-DD.	The program rejects the invalid date or asks for a valid date.	To be tested
TC-04	View grocery inventory	Select View Current Groceries when records exist.	The recorded grocery items are displayed.	To be tested
TC-05	Search for an existing grocery	Search using the name of an item in the inventory.	The matching grocery record is displayed.	To be tested
TC-06	Search for a missing grocery	Search using a name that is not in the inventory.	The program displays a no-match or not-found message.	To be tested
TC-07	Edit an existing grocery	Enter a valid grocery ID and update one field.	The selected grocery record is updated.	To be tested
TC-08	Delete an existing grocery	Enter a valid grocery ID and confirm deletion.	The item is removed from the active inventory.	To be tested
TC-09	Cancel grocery deletion	Select a grocery and decline the confirmation.	The grocery item remains in the inventory.	To be tested
TC-10	Log consumed quantity	Enter a valid grocery ID and a quantity within the available stock.	The consumed quantity is recorded and the remaining quantity is updated.	To be tested
TC-11	Consume more than available	Enter a quantity greater than the item's available quantity.	The program prevents the invalid consumption entry.	To be tested
TC-12	Log wasted grocery	Enter a valid grocery ID, a valid waste quantity, and a reason.	A waste record is created and the estimated loss is recorded.	To be tested
TC-13	View waste history	Select View Waste History after recording waste.	The saved waste entries are displayed.	To be tested
TC-14	View waste report	Select View Waste Report after recording waste.	The report displays information based on the recorded waste entries.	To be tested
TC-15	Save and reload records	Save and exit, then run the program again.	Previously saved grocery and waste records are loaded.	To be tested
TC-16	Expiration alert check	Run the program with items that are expired or nearing expiration.	The applicable expiration alerts are displayed.	To be tested

