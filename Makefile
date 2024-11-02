# Variables
SRC_DIR = src
BIN_DIR = bin
JAR_NAME = AssignmentManager.jar
MAIN_CLASS = application.StartProgram
JAVADOC_DIR = docs
CENSUS_FILE = assignments.csv

# List of all Java files in the source directory
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSPATH = .

# Default target to compile and create the JAR
all: compile jar javadoc

# Compile Java files and place the class files in the bin directory
compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) -cp $(CLASSPATH) $(SOURCES)

# Create the JAR file with manifest and classpath
jar: compile
	echo "Main-Class: $(MAIN_CLASS)" > manifest.txt
	echo "Class-Path: ." >> manifest.txt
	jar cfm $(JAR_NAME) manifest.txt -C $(BIN_DIR) .
	rm manifest.txt

# Generate Javadoc
javadoc:
	mkdir -p $(JAVADOC_DIR)
	javadoc -d $(JAVADOC_DIR) -sourcepath $(SRC_DIR) -subpackages application:domain:presentation

# Clean up compiled files and JAR
clean:
	rm -rf $(BIN_DIR) $(JAR_NAME) $(JAVADOC_DIR)

# Run the program
run:
	java -cp $(BIN_DIR):. $(MAIN_CLASS) $(ARGS)

# Run the program using the JAR file
run-jar: jar
	java -jar $(JAR_NAME) $(ARGS)

# Package additional files: README.md and LICENSE
package: jar
	cp README.md LICENSE $(JAR_NAME)

.PHONY: all compile jar javadoc clean run package
