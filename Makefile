JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
LIB_DIR = lib

CLASSPATH = $(LIB_DIR)/jl1.0.1.jar:$(LIB_DIR)/jaudiotagger-2.2.6-SNAPSHOT.jar

SOURCES = $(wildcard $(SRC_DIR)/*.java)

all: compile

compile:
	mkdir -p $(BIN_DIR)
	$(JAVAC) -cp $(CLASSPATH) -d $(BIN_DIR) $(SOURCES)

run: compile
	$(JAVA) -cp $(CLASSPATH):$(BIN_DIR) Mp3Frame &

clean:
	rm -rf $(BIN_DIR)
	rm -f $(SRC_DIR)/*.class

cleanall: clean

PREFIX ?= $(HOME)/.local
BINDIR = $(PREFIX)/bin
SHAREDIR = $(PREFIX)/share/mp3-player

install: compile
	mkdir -p $(BINDIR)
	mkdir -p $(SHAREDIR)/lib
	mkdir -p $(SHAREDIR)/bin
	cp -r $(BIN_DIR)/* $(SHAREDIR)/bin/
	cp $(LIB_DIR)/*.jar $(SHAREDIR)/lib/
	echo '#!/bin/bash' > $(BINDIR)/mp3-player
	echo 'java -cp $(SHAREDIR)/lib/jl1.0.1.jar:$(SHAREDIR)/lib/jaudiotagger-2.2.6-SNAPSHOT.jar:$(SHAREDIR)/bin Mp3Frame "$$@" > /dev/null 2>&1 &' >> $(BINDIR)/mp3-player
	chmod +x $(BINDIR)/mp3-player
	@echo "Installed to $(BINDIR)/mp3-player"

uninstall:
	rm -f $(BINDIR)/mp3-player
	rm -rf $(SHAREDIR)
	@echo "Uninstalled mp3-player"
