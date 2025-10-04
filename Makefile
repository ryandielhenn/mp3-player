# Compiler and flags
JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
LIB_DIR = lib

# Classpath
CLASSPATH = $(LIB_DIR)/jl1.0.1.jar:$(LIB_DIR)/jaudiotagger-2.2.6-SNAPSHOT.jar

# Source files
SOURCES = $(wildcard $(SRC_DIR)/*.java)

# Default target
all: compile

# Create bin directory and compile
compile:
	mkdir -p $(BIN_DIR)
	$(JAVAC) -cp $(CLASSPATH) -d $(BIN_DIR) $(SOURCES)

# Run the program
run: compile
	$(JAVA) -cp $(CLASSPATH):$(BIN_DIR) Mp3Frame &

# Clean compiled files
clean:
	rm -rf $(BIN_DIR)
	rm -f $(SRC_DIR)/*.class

# Remove bin and all class files
cleanall: clean

.PHONY: all compile run clean cleanall
