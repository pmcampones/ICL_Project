# ICL Project - Interpreter and Compiler for the CALC Language

### Project Status: _In Progress_

This project consists on the implementation of an interpreter and compiler for the programming language CALC, created specifically for this purpose.

## How to Run

The project can be run as either an interpreter or a compiler.

### Interpreter: 
`java InterpreterMain`

The file InterpreterMain runs the program as an interpreter. Upon running it, a shell is opened and the user can input an indefinite number of expressions; the interpreter reads the user input written according to the CALC sintax and produces the result.

### Compiler:
`java CompilerMain fileName [directory] [framesDirectory]`

The file CompilerMain runs the program as a compiler. Upon running it, a shell is opened and the user inputs a single expression. This expression is compiled into Java Bytecode.

The name of the compiled file is received as an argument of the program. This is the only mandatory argument. The name in the arguments mustn't include the termination type of the file. Eg: _expression0_ is correct but _expression0.j_ is incorrect.

The remaining optional arguments are "directory" and "framesDirectory". 
The first optional argument specifies the directory of the compiled program, relative to the project working directory.
The last argument specifies the directory where the Frame auxiliary classes are to be compiled, relative to the directory specified in the previous argument.

If the optional arguments are not given, default directories are used for the compiled programs and the Frames.
The default directory for the compiled files is CompiledPrograms, and the default frames directory is CompiledPrograms/Frames
If the user wants to have all programs in the project root directory, the optional arguments should have the value "."

Upon having the Java bytecodes, these can be assembled into JVM _.class_ programs through the use of the Jasmin assembler.

_Assemble_: `java -jar jasmin.jar CompiledPrograms/compiledFile.j CompiledPrograms/Frames/frame_0.j CompiledPrograms/Frames/frame_1.j`

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

### Dinamic Stack Allocation

For any given expression, the compiler identifies the maximum memory the program will require and will allocate a stack with that exact size.
This is accomplished by attributing each operation a value representing its induced variation in the stack. Eg: `stackChange(push) = +1  stackChange(pop) = -1`.
