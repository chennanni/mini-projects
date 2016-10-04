# Alarm Clock 2

## What
- Simple implementation of an alarm clock with multiple threads.
- Take system input as name and count down time, print alert message when the time is up.
- The system runs constantly and wait for user input for creating new alarm unless you enter "q" for quit

## Run instruction
Import necessary lib, compile the java file under app package, run the `main()` inside `Clock.java`.

## Design
- Use `java.util.Timer` for timing.
- Use `java.util.Scanner` for system input.
- When user wants to create a new alarm, create a new thread to start `java.util.TimerTask`.
- Close `Timer` and `Scanner` when the program exits to prevent resource leak.
