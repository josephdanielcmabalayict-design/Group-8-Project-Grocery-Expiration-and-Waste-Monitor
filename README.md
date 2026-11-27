# Grocery Expiration and Waste Monitor

## Project Overview

The Grocery Expiration and Waste Monitor is a Java-based console application designed to help users organize their grocery inventory and monitor expiration dates.

The application allows users to add, view, edit, search, and delete grocery records while keeping track of item quantities, expiration dates, and prices.

It also provides features for recording consumed and wasted grocery items, reviewing waste history, and generating waste reports that display estimated losses.

Grocery and waste records are stored in local text files, allowing information to be loaded again when the program is executed.

This project demonstrates the application of Object-Oriented Programming (OOP) principles and file handling in Java.

## Features

| Feature | Description |
|---|---|
| View Current Groceries | Displays the grocery items currently recorded in the inventory. |
| Add Grocery | Records a grocery item's name, category, quantity, expiration date, and total price. |
| Edit Grocery | Allows users to update information about an existing grocery item. |
| Search Grocery | Finds grocery records using the item's name. |
| Delete Grocery | Removes a selected item from the active inventory after confirmation. |
| Expiration Alerts | Checks for items that are expired or approaching their expiration date. |
| Log Consumed Grocery | Records consumed quantities and updates the remaining inventory quantity. |
| Log Wasted Grocery | Records wasted quantities, reasons, and estimated losses. |
| View Waste History | Displays previously recorded waste entries. |
| View Waste Report | Generates a report based on recorded waste information. |
| Save and Exit | Saves inventory and waste records before closing the application. |

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language used to develop the application. |
| ArrayList | Stores grocery items and waste records while the program is running. |
| LocalDate | Handles grocery expiration dates and waste record dates. |
| Java File I/O | Reads and writes grocery and waste information to local text files. |
| Scanner | Accepts user input through the console. |
| UUID | Generates unique identifiers for waste records. |
| GitHub | Hosts the source code and supports project collaboration. |

## Object-Oriented Programming Concepts

The Grocery Expiration and Waste Monitor applies the four major Object-Oriented Programming (OOP) principles: encapsulation, abstraction, inheritance, and polymorphism. These principles help organize the code, protect data, and reduce unnecessary repetition.

### Encapsulation

Encapsulation means keeping an object's data private and controlling how it can be accessed or modified.

The `GroceryItem` class demonstrates encapsulation by declaring its fields, such as ID, name, category, quantity, expiration date, price, and unit price, as private.

Other classes access or modify these fields through getter and setter methods. The setters also apply validation, such as rejecting zero or negative quantities and preventing invalid prices.

Additionally, changing the quantity recalculates the total price based on the unit price, helping maintain consistency between the item's quantity and price.

### Abstraction

Abstraction means hiding implementation details and exposing only the operations necessary for other parts of the program to use.

The `Report` class demonstrates abstraction by defining the methods that every report must provide, such as `getTitle()` and `printBody()`, without specifying their complete implementation.

The `displayReport()` method handles the general reporting process, allowing the caller to display a report without knowing its internal details.

Abstraction is also demonstrated when `Main` calls methods such as `groceryManager.logWasted()`. The caller does not need to know the internal steps involved in finding the grocery item, updating its quantity, creating a waste record, and saving the data.

### Inheritance

Inheritance allows a class to reuse and extend the behavior of another class.

The `WasteReport` class extends the abstract `Report` class. It inherits the shared reporting behavior, including the `displayReport()` method, instead of implementing the entire reporting process again.

The `Report` class provides the general structure and shared logic, while `WasteReport` supplies the waste-specific implementation, such as the report title, waste calculations, and empty-data message.

This reduces code duplication and allows the reporting structure to be extended with additional report types.

### Polymorphism

Polymorphism allows the same method call to produce different behavior depending on the actual object being used.

The `WasteReport` class overrides methods inherited from `Report`, including `getTitle()`, `printBody()`, `hasData()`, and `getEmptyMessage()`.

When the inherited `displayReport()` method calls these methods, Java executes the overridden implementations belonging to the actual `WasteReport` object.

The `showReport(Report report)` method in `Main` also demonstrates polymorphism because it accepts a `Report` reference. This allows different report subclasses to be passed to the same method, provided they follow the `Report` structure.

### Summary

The application uses these OOP principles to improve code organization, maintainability, data protection, and separation of responsibilities.

## System Requirements

### Hardware Requirements

- Desktop or laptop computer
- Keyboard and monitor
- Sufficient storage for the project and saved data files

### Software Requirements

- Java Development Kit (JDK) installed
- A Java-supported IDE or editor, such as:
  - IntelliJ IDEA
  - Eclipse
  - Visual Studio Code with Java support
- An operating system that supports the installed Java version

## Installation and Execution

### Downloading the Project

1. Open the project repository:

   [Grocery Expiration and Waste Monitor - GitHub Repository](https://github.com/josephdanielcmabalayict-design/Group-8-Project-Grocery-Expiration-and-Waste-Monitor)

2. Download the repository as a ZIP file or clone it using Git.
3. If you downloaded a ZIP file, extract it into a folder.
4. Open the project folder in a Java-supported IDE.
5. Make sure all Java source files are included in the project.
6. Locate and run `Main.java`.
7. Follow the options displayed in the console.

### Running Through the Terminal

If all Java source files are in the same folder and do not require package-specific commands, open a terminal in that folder and compile the files:

```bash
javac *.java
```

Then start the application:

```bash
java Main
```

### Data Files

The application uses local text files for persistent storage.

Expected data files include:

| File | Purpose |
|---|---|
| `groceries.txt` | Stores grocery inventory records. |
| `waste_records.txt` | Stores waste history records. |

Use the program's **Save and Exit** option before closing it to ensure the latest changes are saved.

## How to Use the Program

When the application starts, it loads saved records, if available, checks expiration dates, and displays the main menu.

### Main Menu

| Option | Menu Item | Description |
|---|---|---|
| 1 | View Current Groceries | Displays the items currently in the inventory. |
| 2 | Add Grocery | Allows users to enter a new grocery item's details. |
| 3 | Edit Grocery | Updates information for an existing grocery item using its ID. |
| 4 | Search Grocery | Searches for grocery items using their names. |
| 5 | Delete Grocery | Removes a grocery item after confirmation. |
| 6 | Log Consumed Grocery | Records consumed quantities and updates the remaining stock. |
| 7 | Log Wasted Grocery | Records wasted quantities, reasons, and estimated losses. |
| 8 | View Waste History | Displays recorded waste entries. |
| 9 | View Waste Report | Displays the waste report. |
| 10 | Save and Exit | Saves the records and closes the application. |

### Example: Adding a Grocery

Select **Option 2 - Add Grocery** and enter the requested details.

Example input:

| Field | Example Input |
|---|---|
| Item Name | Milk |
| Category | Dairy |
| Quantity | 5 |
| Expiration Date | 2026-12-01 |
| Total Price | 350 |

The program should add the grocery record and display its details or generated ID.

### Example: Recording Wasted Grocery

1. Select **Option 7 - Log Wasted Grocery**.
2. Enter the ID of the grocery item.
3. Enter the quantity wasted.
4. Enter the reason for waste, such as expired or spoiled.
5. Review the recorded entry and estimated loss.

## Test Cases

The following test cases can be used to verify the application's main functions.

Run each test using the program and fill in the **Actual Result** and **Status** columns based on the observed behavior.

| Test ID | Test Scenario | Test Input / Steps | Expected Result | Actual Result / Status |
|---|---|---|---|---|
| TC-01 | Add a grocery with valid details | Enter a name, category, positive quantity, valid date, and non-negative price. | The grocery item is added to the inventory. | To be tested |
| TC-02 | Add a grocery with invalid quantity | Enter zero or a negative quantity. | The program rejects the invalid quantity or requests valid input. | To be tested |
| TC-03 | Add a grocery with invalid date | Enter a date that does not follow `YYYY-MM-DD`. | The program rejects the invalid date or requests a valid date. | To be tested |
| TC-04 | View grocery inventory | Select View Current Groceries when records exist. | The recorded grocery items are displayed. | To be tested |
| TC-05 | Search for an existing grocery | Search using the name of an item in the inventory. | The matching grocery record is displayed. | To be tested |
| TC-06 | Search for a missing grocery | Search using a name that is not in the inventory. | The program displays a no-match or not-found message. | To be tested |
| TC-07 | Edit an existing grocery | Enter a valid grocery ID and update one field. | The selected grocery record is updated. | To be tested |
| TC-08 | Delete an existing grocery | Enter a valid grocery ID and confirm deletion. | The item is removed from the active inventory. | To be tested |
| TC-09 | Cancel grocery deletion | Select a grocery and decline the confirmation. | The grocery item remains in the inventory. | To be tested |
| TC-10 | Log consumed quantity | Enter a valid grocery ID and a quantity within the available stock. | The consumed quantity is recorded and the remaining quantity is updated. | To be tested |
| TC-11 | Consume more than available | Enter a quantity greater than the item's available quantity. | The program prevents the invalid consumption entry. | To be tested |
| TC-12 | Log wasted grocery | Enter a valid grocery ID, waste quantity, and reason. | A waste record is created and the estimated loss is recorded. | To be tested |
| TC-13 | View waste history | Select View Waste History after recording waste. | The saved waste entries are displayed. | To be tested |
| TC-14 | View waste report | Select View Waste Report after recording waste. | The report displays information based on recorded waste entries. | To be tested |
| TC-15 | Save and reload records | Save and exit, then run the program again. | Previously saved grocery and waste records are loaded. | To be tested |
| TC-16 | Expiration alert check | Run the program with items that are expired or nearing expiration. | The applicable expiration alerts are displayed. | To be tested |

---

**Developed as an Object-Oriented Programming project using Java.**
