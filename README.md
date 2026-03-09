
# Java Customer Relationship Management (CRM) System

Course project for Software Engineering demonstrating the design and implementation of a modular **Customer Relationship Management (CRM) system** built in Java.

The system applies object-oriented design principles and several common **software design patterns** to manage customer data and communication workflows in a structured and scalable way.

---

## Key Concepts Implemented

- Object-Oriented Programming (OOP)
- Modular software architecture
- Design patterns for maintainability and scalability

### Design Patterns Used

**Singleton Pattern**

Ensures a single instance of the CRM system manages global application state.

**Factory Pattern**

Handles the creation of CRM objects such as customers, tasks, and communications.

**Observer Pattern**

Allows system components to react to changes in customer data or communication updates.

---

## Assignment Information

**Course:** Software Engineering  
**Project ID:** CS1OP-CW1  
**Actual Hours Spent:** 30  
**AI Tools Used:** OpenAI/ChatGPT and GitHub Copilot

---

## How to Run the CRM

### Prerequisites

- Java 21 or higher
- Maven 3.x
- A web browser

### Running the Application

1. **Set JAVA_HOME** (if not already set):

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
```

2. **Navigate to the project directory**

```powershell
cd path\to\cs1op-cw1
```

3. **Run the application**

```powershell
mvn exec:java
```

**Alternative (compile first then run):**

```powershell
mvn clean compile
mvn exec:java
```

4. **Access the application**

Open your browser and go to:

    http://localhost:4567

5. **Stop the application**

Press Ctrl+C in the terminal.
