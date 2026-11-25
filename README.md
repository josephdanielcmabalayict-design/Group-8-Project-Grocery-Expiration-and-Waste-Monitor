# Grocery & Waste Manager v1.0

A Java-based console application for managing grocery inventories, monitoring expiration dates, and tracking food waste.

## 1. Project Overview

Grocery & Waste Manager is a console-based inventory management application developed using Java and Object-Oriented Programming (OOP) principles. It is designed to help users organize their grocery items, monitor expiration dates, and keep track of consumed and wasted groceries.

The application provides features for adding, viewing, editing, and removing grocery records, as well as recording consumed or wasted items. It also includes expiration alerts and waste reports to help users monitor their inventory and become more aware of food waste and its associated financial losses.

The project aims to provide a simple and accessible way of managing household groceries while demonstrating the practical application of Object-Oriented Programming concepts and file handling in Java.

## 2. Features

The application includes the following functionalities:

- **View Inventory** – Displays the currently stored grocery items, including their names, categories, quantities, expiration dates, and total prices.
- **Add Grocery** – Allows users to add new grocery items to the inventory.
- **Edit Grocery** – Allows users to modify the information of existing grocery records.
- **Log Consumption** – Records the quantity of groceries consumed and updates the remaining inventory.
- **Log Waste** – Records discarded groceries along with the corresponding disposal reason.
- **Remove Grocery** – Removes a grocery item from the active inventory while maintaining its previously recorded waste history.
- **Expiration Alerts** – Identifies expired groceries and items approaching their expiration dates within the next three days.
- **Waste Report** – Provides a summary of recorded food waste, including the estimated financial losses associated with discarded groceries.
- **Data Persistence** – Stores grocery and waste records in local files to preserve information between program executions.

## 3. Technologies Used

The project utilizes the following technologies and Java features:

| Technology | Purpose |
|---|---|
| Java | Primary programming language used to develop the application. |
| Java Collections Framework | Manages and stores grocery and waste records during program execution. |
| Java I/O | Handles reading and writing data to local files. |
| Local File Storage | Preserves application records between executions. |
| Java Time API | Handles expiration dates and date comparisons. |
| Object-Oriented Programming | Organizes the application into classes and applies OOP principles. |

## 4. Object-Oriented Programming Concepts

The application demonstrates the following Object-Oriented Programming principles:

**Encapsulation**

Encapsulation means keeping an object's data private and controlling how it can be accessed or changed. Every class in the program does this. In GroceryItem, all the fields (ID, name, category, quantity, expiration date, price, unit price) are private, so other classes can only reach them through getters and setters. The setters protect the data: setQuantity rejects zero or negative values, and setPrice rejects negative or invalid numbers. Changing the quantity also recalculates the total price from the unit price, so the two values stay consistent

**Abstraction**

Abstraction means hiding the details and showing only what the user of a class needs. The Report class is the clearest example. It is an abstract class that defines what every report must provide (getTitle() and printBody()) without saying how. Whoever calls displayReport() doesn't need to know how the report is built or printed. Other classes show it too. Main calls groceryManager.logWasted(...) without knowing that it finds the item, reduces the quantity, creates a waste record and saves the data.

**Inheritance**

Inheritance means a child class reuses and extends a parent class. WasteReport extends Report, so it gets the parent's displayReport() behavior without rewriting it. The parent holds the shared logic (check for data, print the title, print the body), and the child only supplies what is specific to waste: the title "WASTE REPORT", the computation of total loss and the most wasted category, and the empty-data message. The hasData() and getEmptyMessage() methods have default versions in the parent that the child can override when needed.

**Polymorphism**

Polymorphism means the same method call can behave differently depending on the actual object. WasteReport overrides getTitle(), printBody(), hasData() and getEmptyMessage(), so when displayReport() in the parent calls them, it runs the waste-specific versions. In Main, the method showReport(Report report) accepts the parent type, so any report subclass can be passed to it and it will work the same way.
The application uses these principles to improve code organization, maintainability, and separation of responsibilities.

## 5. System Requirements

The following are required to run the application:

- A computer running Windows, Linux, or macOS.
- Java Development Kit (JDK).
- A Java-compatible command-line terminal or integrated development environment (IDE).
- Sufficient storage space for the application files and saved records.

A compatible Java version must be installed to compile and execute the application.

## 6. Installation and Execution

Follow these steps to run the application:

**Step 1: Download or clone the repository**

Clone the repository using Git:

```bash
git clone https://github.com/your-username/grocery-waste-manager.git
```

Alternatively, download the repository as a ZIP file and extract its contents.

**Step 2: Open the project directory**

Navigate to the extracted project folder using your preferred terminal or IDE.

**Step 3: Compile the Java source files**

If the source files are located in the same directory and do not use packages, compile them using:

```bash
javac *.java
```

If the project uses packages or a different directory structure, compile the files according to that structure.

**Step 4: Run the application**

Execute the main class:

```bash
java Main
```

Replace `Main` with the actual name of the class containing the application's `main()` method, if different.

## 7. How to Use the Program

Once the application is launched, users can interact with it through the main menu.

The general workflow is as follows:

1. **Launch the application.** The program displays expiration alerts for groceries that are already expired or approaching their expiration dates.
2. **View the inventory.** Check the currently stored grocery records.
3. **Manage groceries.** Add new items, edit existing records, or remove items from the inventory.
4. **Record consumption or waste.** Select a grocery item and specify the quantity consumed or discarded.
5. **Review expiration alerts.** Identify groceries that require attention before they expire.
6. **Generate waste reports.** View recorded waste information and estimated financial losses.
7. **Exit the application.** Close the program and preserve the stored records.

Users interact with the application by selecting options from the menu and providing the required information through the console.

## 8. Data Storage

The application uses local file storage to preserve grocery inventory and waste records between program executions.

Instead of relying exclusively on temporary data stored in memory, the application reads previously saved records when launched and writes updated information to local files.

The storage system is intended to maintain the following information:

- **Grocery Records** – Stores the information of currently registered grocery items, including their names, categories, quantities, expiration dates, and prices.
- **Waste Records** – Stores information about discarded groceries, including their quantities, disposal reasons, and estimated financial losses.

Maintaining separate grocery and waste records allows the application to manage active inventory independently from previously recorded waste information.

This approach provides basic data persistence without requiring an external database management system.
