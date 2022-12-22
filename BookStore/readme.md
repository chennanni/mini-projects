# Book Store

design a web service that supports below APIs:

**books**

list all books: name, price, count

- GET `/bookstore/books`

**cash**

list the cash balance of the store

- GET `/bookstore/cash`

**order**

sell books to customers or add books to inventory, will change cash balance

- POST `bookstore/order/out/book_id`
- POST `bookstore/order/in/book_id`

**inv**

change the inventories' items

- POST `/bookstore/inv/books/in/book_id`
- POST `/bookstore/inv/books/out/book_id`
- POST `/bookstore/inv/cash/in/cash_amount`
- POST `/bookstore/inv/cash/out/cash_amount`