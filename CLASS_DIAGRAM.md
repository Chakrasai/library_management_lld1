# Class Diagram & Relationships

Visual guide to understand how classes work together.

---

## 🏗️ Simple Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                      LIBRARY (Main Manager)                 │
│                                                              │
│  - name: String                                             │
│  - books: List<Book>                                        │
│  - patrons: List<Patron>                                    │
│  - transactions: List<Transaction>                          │
│                                                              │
│  + addBook(book)                                            │
│  + findBook(isbn)                                           │
│  + registerPatron(patron)                                   │
│  + checkoutBook(patronId, isbn)                             │
│  + returnBook(patronId, isbn)                               │
│  + printStatistics()                                        │
└─────────────────────────────────────────────────────────────┘
           │                      │                    │
           │ contains             │ contains          │ contains
           ▼                      ▼                    ▼
    ┌─────────────┐      ┌──────────────┐    ┌──────────────┐
    │    BOOK     │      │    PATRON    │    │ TRANSACTION  │
    ├─────────────┤      ├──────────────┤    ├──────────────┤
    │ isbn        │      │ patronId     │    │ patronId     │
    │ title       │      │ name         │    │ isbn         │
    │ author      │      │ email        │    │ borrowDate   │
    │ isAvailable │      └──────────────┘    │ returnDate   │
    └─────────────┘                          └──────────────┘
```

---

## 📊 Class Relationships

### Library "HAS-A" Relationship

```
Library
├── List<Book>          → Stores many books
├── List<Patron>        → Stores many members
└── List<Transaction>   → Stores all borrowing records
```

### Data Flow

```
User Action          →  Library Method  →  Updates Collections

1. Add Book          →  addBook()       →  Add to books list
2. Register Member   →  registerPatron()→  Add to patrons list
3. Checkout Book     →  checkoutBook()  →  Add to transactions,
                                          Mark book unavailable
4. Return Book       →  returnBook()    →  Update transaction,
                                          Mark book available
```

---

## 🔄 Workflow with Classes

```
┌────────────────────────────────────────────────────────────────┐
│                    CREATE LIBRARY                              │
│  library = new Library("City Library")                          │
└───────────────────────────┬────────────────────────────────────┘
                            │
        ┌───────────────────┴───────────────────┐
        │                                       │
        ▼                                       ▼
   ┌──────────────┐                    ┌──────────────┐
   │ ADD BOOKS    │                    │ ADD PATRONS  │
   │              │                    │              │
   │  Book 1 ──┐  │                    │  Patron 1 ─┐ │
   │  Book 2 ──┤  │ stored in          │  Patron 2 ─┤ │ stored in
   │  Book 3 ──┘  │ books list         │  Patron 3 ─┘ │ patrons list
   │  ...         │                    │  ...         │
   └──────┬───────┘                    └──────┬───────┘
          │                                   │
          └───────────────────┬───────────────┘
                              │
                    ┌─────────▼─────────┐
                    │  CHECKOUT BOOKS   │
                    │                   │
                    │ Patron "P001"     │
                    │    borrows        │
                    │ Book "ISBN001"    │
                    │                   │
                    │ ✓ Create          │
                    │   Transaction     │
                    │ ✓ Mark book as    │
                    │   unavailable     │
                    └─────────┬─────────┘
                              │
                    ┌─────────▼─────────┐
                    │  RETURN BOOKS     │
                    │                   │
                    │ Patron "P001"     │
                    │    returns        │
                    │ Book "ISBN001"    │
                    │                   │
                    │ ✓ Update          │
                    │   Transaction     │
                    │ ✓ Mark book as    │
                    │   available       │
                    └─────────┬─────────┘
                              │
                    ┌─────────▼─────────┐
                    │ VIEW STATISTICS   │
                    │                   │
                    │ Total Books:    5 │
                    │ Available:      3 │
                    │ Borrowed:       2 │
                    │ Patrons:        3 │
                    │ Transactions:   4 │
                    └───────────────────┘
```

---

## 🎯 How Classes Communicate

```
User calls
    │
    ├─→ library.addBook(book)
    │       │
    │       └─→ book.getIsbn()
    │       └─→ books.add(book)
    │
    ├─→ library.checkoutBook(patronId, isbn)
    │       │
    │       ├─→ findPatron(patronId)
    │       ├─→ findBook(isbn)
    │       ├─→ book.setAvailable(false)
    │       └─→ transactions.add(new Transaction(...))
    │
    └─→ library.returnBook(patronId, isbn)
            │
            ├─→ findBook(isbn)
            ├─→ book.setAvailable(true)
            └─→ transaction.setReturnDate(LocalDate.now())
```

---

## 📋 Method Relationships

### Library Methods & What They Use

```
┌─────────────────────────────────────────────────────────┐
│  addBook(Book book)                                     │
│  ├─ Uses: books (List)                                  │
│  └─ Modifies: Add book to list                          │
├─────────────────────────────────────────────────────────┤
│  findBook(String isbn)                                  │
│  ├─ Uses: books (List)                                  │
│  └─ Returns: Book or null                               │
├─────────────────────────────────────────────────────────┤
│  registerPatron(Patron patron)                          │
│  ├─ Uses: patrons (List)                                │
│  └─ Modifies: Add patron to list                        │
├─────────────────────────────────────────────────────────┤
│  checkoutBook(String patronId, String isbn)             │
│  ├─ Uses: findPatron(), findBook(), book.setAvailable() │
│  ├─ Creates: New Transaction                            │
│  └─ Modifies: Books list, Transactions list             │
├─────────────────────────────────────────────────────────┤
│  returnBook(String patronId, String isbn)               │
│  ├─ Uses: findBook(), transactions.setReturnDate()      │
│  └─ Modifies: Book availability, Transaction state      │
├─────────────────────────────────────────────────────────┤
│  searchByTitle(String title)                            │
│  ├─ Uses: books (List)                                  │
│  └─ Returns: List of matching books                     │
├─────────────────────────────────────────────────────────┤
│  getAvailableBooks()                                    │
│  ├─ Uses: books (List), book.isAvailable()              │
│  └─ Returns: List of available books                    │
└─────────────────────────────────────────────────────────┘
```

---

## 🔗 Object Connections

### When You Create a Library:

```
library:Library ─→ (empty lists)
                   ├─ books: List = []
                   ├─ patrons: List = []
                   └─ transactions: List = []
```

### After Adding Books:

```
library:Library
├─ books: List = [
│   ├─ Book { isbn: "ISBN001", title: "Book A", isAvailable: true }
│   └─ Book { isbn: "ISBN002", title: "Book B", isAvailable: true }
│ ]
├─ patrons: List = []
└─ transactions: List = []
```

### After Adding Patrons:

```
library:Library
├─ books: List = [...]
├─ patrons: List = [
│   ├─ Patron { patronId: "P001", name: "Alice", email: "..." }
│   └─ Patron { patronId: "P002", name: "Bob", email: "..." }
│ ]
└─ transactions: List = []
```

### After Checkout:

```
library:Library
├─ books: List = [
│   ├─ Book { isbn: "ISBN001", title: "Book A", isAvailable: false } ✗
│   └─ Book { isbn: "ISBN002", title: "Book B", isAvailable: true }
│ ]
├─ patrons: List = [...]
└─ transactions: List = [
    └─ Transaction { patronId: "P001", isbn: "ISBN001", 
                     borrowDate: 2026-09-05, returnDate: null }
  ]
```

### After Return:

```
library:Library
├─ books: List = [
│   ├─ Book { isbn: "ISBN001", title: "Book A", isAvailable: true } ✓
│   └─ Book { isbn: "ISBN002", title: "Book B", isAvailable: true }
│ ]
├─ patrons: List = [...]
└─ transactions: List = [
    └─ Transaction { patronId: "P001", isbn: "ISBN001", 
                     borrowDate: 2026-09-05, returnDate: 2026-09-05 }
  ]
```

---

## 🎓 Class Interactions Explained

### Example 1: Adding a Book

```java
library.addBook(new Book("ISBN001", "Title", "Author"));

Step-by-step:
1. Library receives Book object
2. Library stores Book in books list
3. Book becomes part of library's inventory
```

### Example 2: Checking Out a Book

```java
library.checkoutBook("P001", "ISBN001");

Step-by-step:
1. Library finds Patron "P001" from patrons list
2. Library finds Book "ISBN001" from books list
3. Library marks Book as unavailable (isAvailable = false)
4. Library creates new Transaction record
5. Library stores Transaction in transactions list
```

### Example 3: Returning a Book

```java
library.returnBook("P001", "ISBN001");

Step-by-step:
1. Library finds Book "ISBN001" from books list
2. Library marks Book as available (isAvailable = true)
3. Library finds Transaction for P001 & ISBN001
4. Library updates Transaction with return date
```

---

## 📦 Data Structure Summary

```
LIBRARY Container
│
├─ List<Book> books
│  ├─ Book 1: { isbn, title, author, isAvailable }
│  ├─ Book 2: { isbn, title, author, isAvailable }
│  └─ Book 3: { isbn, title, author, isAvailable }
│
├─ List<Patron> patrons
│  ├─ Patron 1: { patronId, name, email }
│  ├─ Patron 2: { patronId, name, email }
│  └─ Patron 3: { patronId, name, email }
│
└─ List<Transaction> transactions
   ├─ Transaction 1: { patronId, isbn, borrowDate, returnDate }
   ├─ Transaction 2: { patronId, isbn, borrowDate, returnDate }
   └─ Transaction 3: { patronId, isbn, borrowDate, returnDate }
```

---

## ✨ Key Takeaway

```
Library = Manager
  └─ Stores and manages:
     ├─ Books (what can be borrowed)
     ├─ Patrons (who can borrow)
     └─ Transactions (who borrowed what when)

When a user interacts with the library:
  1. Library looks up objects in its lists
  2. Library modifies their state (e.g., isAvailable)
  3. Library records the action (in transactions)
```

This simple relationship makes the whole system work! 🎉
