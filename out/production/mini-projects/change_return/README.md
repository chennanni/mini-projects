# Change Return

## What

- Create a vending machine that shows the user a list of items to buy and their price.
- Then ask the user to pick an item and enter in the amount of money.
- Have the program calculate the change and return it to the user in the form of $25, $10, $5, $1, $0.25, $0.1, $0.01.

## Design

- Flow
  - print menu
  - take user input
  - validate
  - change return calculation
  - display result
- Use greedy algrithom when calculate the change return.
- Be careful when using `double` in transaction calculation bacause of the nature of `Double` value in Java. For example, a `double` value 2.0-1.0 may not result to 1.0, instead, 0.999999999.
  - Better to use formatter to do some conversion and make sure all values having the same decimal points.
