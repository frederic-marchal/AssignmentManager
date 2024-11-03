# AssignmentManager project

## Overview
This project is a Java program that manages a catalog of assignments, allowing users to add, modify, and remove assignments.

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)
- [UML Diagram](#uml-diagram)

## Introduction

The `AssignmentManager` project is a simple Java program that allows users to manage assignments with details such as name, description, deadline, and priority.

## Installation

### Prerequisites
- Java 11+
- Git

### Steps

1. Clone the repository:
    ```bash
    git clone https://github.com/frederic-marchal/AssignmentManager.git
    ```

2. Navigate to the project directory:
    ```bash
    cd AssignmentManager
    ```

3. Compile the Java files into the `bin` directory using the Makefile:
    ```bash
    make compile
    ```

4. Package the application into a JAR file:
    ```bash
    make jar
    ```

5. Generate Javadoc documentation:
    ```bash
    make javadoc
    ```

## Usage

To run the application from the compiled classes:

```bash
make run
```

To run the application using the JAR file:

```bash
make run-jar
```

### Example Commands

- **Add Assignment**: Follow the instructions to input assignment details.
- **View Assignments**: Displays all current assignments.
- **Edit or Delete Assignments**: Select an assignment by index to edit or delete it.

## License

This project is licensed under the Apache License 2.0. See the `LICENSE` file for more details.

## UML Diagram

![UML Diagram](AssignmentManagerUML.png)
