# ProgressBar

## What

- Make a component that allows a user to add a progress bar to their application.
- This progress bar can be notified by a thread to let it know the progress of a particular activity.
- This will allow the user to continue working with their application while the progress bar continues to show progress through a task. 

## Design

- create a `Window` class as the main GUI for adding new tasks and showing progress
  - add a `JButton` to the window, when the button is clicked, `createTask()` and `addProgressBar()`
- create a `Task` class, when the task is initiated, create a new thread for this task
  - calling `getProgress()` to know the progress of the task
- create a `Monitor` class to monitor the task progress and update the window
  - when it's initiated, a new thread will be created for this class
  - when it's initiated, need to pass in the window instance
  - when a new task is created, needed to `register()` in monitor 
