# ICL Project - Interpreter and Compiler for the CALC Language

### Project Status: _Main Project: COMPLETE / Bonus Part: HALFWAY COMPLETE_

This project consists on the implementation of an interpreter and compiler for the programming language CALC.

### For Professor Caires:

The deliveries of the project are in the branch **Delivery**<br>
The first phase delivery is the commit titled **Delivery Phase 1**<br>
The final phase delivery is in the commit titled **Delivery Phase 2 Final**<br>
The bonus phase delivery is in the commit titled **Delivery Bonus**

## How to Run

The project can be run as either an interpreter or a compiler.

### Interpreter: 
`java InterpreterMain`

The file InterpreterMain runs the program as an interpreter. Upon running it, a shell is opened and the user can input an indefinite number of expressions; the interpreter reads the user input written according to the CALC sintax and produces the result.

### Compiler:

There are two files that can be called to compile code: the *TerminalCompilerMain* and *FileCompilerMain*.

**TerminalCompilerMain**

This program can be run thus:<br>
`java TerminalCompilerMain target [directory] [framesDirectory]`

The file *TerminalCompilerMain* runs the program as a compiler. Upon running it, a shell is opened and the user inputs a single expression. This expression is compiled into Java Bytecode.

The name of the compiled file is received as the argument *target*. This is the only mandatory argument. The name in the arguments mustn't include the termination type of the file. Eg: *expression0* is correct but *expression0.j* is incorrect.

The remaining optional arguments are *directory* and *framesDirectory*. 
The first optional argument specifies the directory of the compiled program, relative to the project working directory.
The last argument specifies the directory where the *Frame* auxiliary classes are to be compiled, relative to the directory specified in the previous argument.

If the optional arguments are not given, default directories are used for the compiled programs and the *Frames*.
The default directory for the compiled files is *CompiledPrograms*, and the default frames directory is *CompiledPrograms/Frames*
If the user wants to have all programs in the project root directory, the optional arguments should have the value "*.*"

Upon having the Java bytecodes, these can be assembled into JVM *.class* programs through the use of the Jasmin assembler.

*Assemble*:<br>
`java -jar jasmin.jar CompiledPrograms/compiledFile.j CompiledPrograms/Frames/frame_0.j CompiledPrograms/Frames/frame_1.j`

**FileCompilerMain**

This program can be run thus:<br>
`java FileCompilerMain source target [directory] [framesDirectory]`

The file *FileCompilerMain* works similarly to the previous, with all common arguments having the same meaning. However, instead of opening a shell and allowing the user to input the desired expression this program compiles the code in a file whose pathname relative to the origin is *source*.

Unlike with *target*, the value of the argument *source* may have the file termination.

*Assemble*:<br>
`java -jar jasmin.jar sourceCode.calc CompiledPrograms/compiledFile.j CompiledPrograms/Frames/frame_0.j CompiledPrograms/Frames/frame_1.j`

## Features

Currently the language supports the computation of complex arithmetic operations and the definition of imutable variables in several scopes.
Some of the project's highlights:

### Left to Right Evaluation of Expressions:
Operations such as _1024/2/2_ are evaluated as _(1024/2)/2 = 256_. This order of the operations coincides with the evaluation done by most machines and is not the default behaviour given in the project's genesis.

### Correct Use of Spagheti Stack for Frame Ordering
Our program supports expressions such as:
* `def x = 1 y = 2 in x + y + (def x = x + 1 in 2 * x end) + (def w = x + y in w + 2 end) end`

This operation contains 3 frames, however, the last two of these have the same frame as their static link. This differs from most examples where a frame's static link is always the previously declared frame.

Another highlight of the program is the fact that the same identifier can be declared once per scope, instead of once per program. The identifier `x` in the example is defined in two scopes.

### Extensive JUnit Testing

There is a variety of JUnit tests for both the interpreter and the compiler.
The compiler tests have only been successfully experimented on a Linux system with a bash terminal. The tests compile the expressions into Java bytecodes and assemble the results using Jasmin. It is assumed `jasmin.jar` is in the project root; the failure to comply to this assumption leads to an error in the tests.

The tests cover all uses of the language, starting from testing simple arithmetic operations and ending with computing the fibonacci sequence.

### Dinamic Stack Allocation

For any given expression, the compiler identifies the maximum memory the program will require and will allocate a stack with that exact size.
This is accomplished by attributing each operation a value representing its induced variation in the stack. Eg:<br>
`stackChange(push) = +1`<br>
`stackChange(pop) = -1`

### Static and Dynamic Typechecking

The language supports both static and dynamic typechecking. Because all variables are initialized upon being declared and there are no non-deterministic operations that attribute a value (such as would happen if in an _if_ operation if the _then_ and _else_ fields returned a value), it's possible to infer their type.

In this language all the following three expressions are valid and correctly evaluated:<br>
`def x = 1 y = 2 in x + y end`<br>
`def x : int = 1 y : int = 2 in x + y end`<br>
`def x = 1 y : int = 2 in x + y end`

## Bonus

The Bonus part of the project is incomplete as only the *Interpreter* has que required features implemented.

In the interpreter it's possible to define functions, and declare global variables. Aditionally, a *println* operation has been added allowing the display of values that are not returned.
