# Grocery Expiration and Waste Monitor

## 1. Project Title

**Grocery Expiration and Waste Monitor**

## 2. Project Overview

The Grocery Expiration and Waste Monitor is a Java-based console application designed to help users organize their grocery inventory and monitor expiration dates.

The application allows users to add, view, edit, search, and delete grocery records while keeping track of item quantities, expiration dates, and prices.

It also provides features for recording consumed and wasted grocery items, reviewing waste history, and generating waste reports that display estimated losses.

Grocery and waste records are stored in local text files, allowing information to be loaded again when the program is executed.

This project demonstrates the application of Object-Oriented Programming (OOP) principles and file handling in Java.

## 3. Features

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

## 4. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language used to develop the application. |
| ArrayList | Stores grocery items and waste records while the program is running. |
| LocalDate | Handles grocery expiration dates and waste record dates. |
| Java File I/O | Reads and writes grocery and waste information to local text files. |
| Scanner | Accepts user input through the console. |
| UUID | Generates unique identifiers for waste records. |
| GitHub | Hosts the source code and supports project collaboration. |

## 5. Object-Oriented Programming Concepts

### Classes and Objects

The project uses classes such as `GroceryItem`, `GroceryManager`, `WasteRecord`, and `FileManager`.

Objects created from these classes represent grocery records and perform specific application tasks.

### Encapsulation

Private attributes protect the data within classes. Getter and setter methods provide controlled access to the information.

### Constructors

Constructors initialize objects with the values required for grocery items and other records.

### Abstraction

The application separates responsibilities into different classes and methods. For example, inventory operations and file operations are handled separately.

### Polymorphism

The reporting structure can use a general `Report` reference to work with a specific `WasteReport` implementation, where supported by the project code.

## 6. System Requirements

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

## 7. Installation and Execution

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

## 8. How to Use the Program

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

## 9. Test Cases

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
