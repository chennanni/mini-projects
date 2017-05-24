# LeetCodeClone

## What

Design and implement a "Code Problem Test Engine" similar to Leetcode.
- it defines an interface for solving code challenge
- it allows problem admin to create problems and test cases
- it takes user's code as input and shows whether it passes or fails the tests
- it shows error trace message

## Design

- `RunTimeCompiler` reads `Solution.txt` with standard file I/O and converts it to `Solution.java`.
- Then `RunTimeCompiler` using `JavaCompiler.CompilationTask` to load the `Solution` class in the runtime and return the a instance.
- `TestCaseBase` gets the new `Solution` instance and do some basic testing to match method name and input/output parameters.
- `TestCase` then uses the same instance to run against the JUnit test cases.
- `Engine` is the entry point of the application. It calls the execution of the `TestCase`.

![leetcode_engine_clone_workflow](img/leetcode_engine_clone_workflow.PNG)

(NOTICE: in the original design, the purple colored components are intended to be common for all problems, 
but later I found that the `TestCaseBase` still holds specific information about method name and parameters. 
There are still efforts to be made to read these info from config.)
