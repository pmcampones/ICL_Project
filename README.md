# ICL Project

This is a Java compiler and interpreter. 

## How to Run

### Windows

_To Compile:_ `javac -Xlint Parser.java`

_To Run Interpreter:_ `java Parser`

### Linux

_To Compile:_ `TODO`

_To Run Interpreter:_ `TODO`

## Features

The interpreter has support for:
* **Basic Aritmetic Operations** (Addition, Subtraction, Multiplication and Division);
* **Definitions**

It also includes **Unit Tests** for all supported operations.

### Examples of Supported Operations
* `1+1`
* `def x = 1 in x end`
* `def x = 1 y = 2 in def z = x + y in z + 5 end end`
