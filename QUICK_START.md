# Library Management System - Quick Start Guide

A super simple guide to get started in 5 minutes!

## ⚡ 5-Minute Quick Start

### Step 1: Compile (30 seconds)
```bash
cd library_management_lld
javac Book.java Patron.java Transaction.java Library.java Main.java
```

### Step 2: Run (5 seconds)
```bash
java Main
```

### Step 3: See the output! 🎉
The program will:
1. Create a library named "City Library"
2. Add 5 books to it
3. Register 3 patrons
4. Demonstrate searching, borrowing, and returning books
5. Show final statistics

---

## 📚 The 4 Main Classes (Simple Explanation)

### 1️⃣ **Book** - A Book in the Library
```java
Book book = new Book("ISBN001", "1984", "George Orwell");
// book is available ✓
```

**Think of it as:**
- ISBN = Barcode number
- Title = Book name
- Author = Who wrote it
- Available = Is it on the shelf?

### 2️⃣ **Patron** - A Library Member
```java
Patron member = new Patron("P001", "Alice", "alice@email.com");
// Alice is registered in the library
```

**Think of it as:**
- PatronId = Member ID card
- Name = Member name
- Email = Contact info

### 3️⃣ **Transaction** - A Borrowing Record
```java
Transaction record = new Transaction("P001", "ISBN001");
// When Alice borrows book ISBN001
```

**Think of it as:**
- PatronId = Who borrowed
- ISBN = Which book
- BorrowDate = When borrowed
- ReturnDate = When returned

### 4️⃣ **Library** - The Main System
```java
Library lib = new Library("City Library");
// lib manages everything!
```

**Think of it as:**
- The librarian's desk
- Keeps track of all books and members
- Handles borrowing and returning

---

## 🎮 How to Use It

### Create a Library
```java
Library library = new Library("My Library");
```

### Add Books
```java
library.addBook(new Book("ISBN001", "Book Title", "Author Name"));
library.addBook(new Book("ISBN002", "Another Book", "Another Author"));
```

### Register Members
```java
library.registerPatron(new Patron("P001", "John", "john@email.com"));
library.registerPatron(new Patron("P002", "Jane", "jane@email.com"));
```

### Search for Books
```java
// Find by title
List<Book> results = library.searchByTitle("Book");

// Find by author
results = library.searchByAuthor("Author");

// See available books
library.getAvailableBooks();
```

### Borrow a Book (Checkout)
```java
library.checkoutBook("P001", "ISBN001");
// John (P001) borrows Book (ISBN001)
```

### Return a Book
```java
library.returnBook("P001", "ISBN001");
// John returns the book
```

### See Borrowing History
```java
library.showPatronHistory("P001");
// Shows all books John borrowed
```

### See Statistics
```java
library.printStatistics();
// Shows total books, patrons, etc.
```

---

## 🔄 Simple Workflow Example

```
Step 1: Create Library
├─ Library lib = new Library("City Library");

Step 2: Add Books
├─ lib.addBook(new Book("ISBN1", "Book A", "Author A"));
├─ lib.addBook(new Book("ISBN2", "Book B", "Author B"));

Step 3: Register Patrons
├─ lib.registerPatron(new Patron("P1", "Alice", "alice@email.com"));
├─ lib.registerPatron(new Patron("P2", "Bob", "bob@email.com"));

Step 4: Checkout (Borrow)
├─ lib.checkoutBook("P1", "ISBN1");  // Alice borrows Book A

Step 5: Return
├─ lib.returnBook("P1", "ISBN1");    // Alice returns Book A

Step 6: View Statistics
└─ lib.printStatistics();  // See summary
```

---

## 💻 Complete Mini Example

```java
public class SimpleExample {
    public static void main(String[] args) {
        // Create library
        Library lib = new Library("My Library");
        
        // Add 2 books
        lib.addBook(new Book("B001", "Java Basics", "John Doe"));
        lib.addBook(new Book("B002", "Programming", "Jane Smith"));
        
        // Register 2 members
        lib.registerPatron(new Patron("M1", "Alice", "alice@email.com"));
        lib.registerPatron(new Patron("M2", "Bob", "bob@email.com"));
        
        // Alice borrows a book
        lib.checkoutBook("M1", "B001");
        
        // See what books are available
        System.out.println("Available books: " + lib.getAvailableBooks().size());
        
        // Alice returns the book
        lib.returnBook("M1", "B001");
        
        // See statistics
        lib.printStatistics();
    }
}
```

---

## 🎯 Common Tasks

### Task 1: Find all books by an author
```java
List<Book> booksByAuthor = library.searchByAuthor("George Orwell");
for (Book b : booksByAuthor) {
    System.out.println(b.getTitle());
}
```

### Task 2: Find available books
```java
List<Book> available = library.getAvailableBooks();
System.out.println("Available: " + available.size() + " books");
```

### Task 3: See who borrowed what
```java
library.showPatronHistory("P001");
```

### Task 4: Count books in library
```java
System.out.println("Total books: " + library.getAllBooks().size());
```

---

## ❓ Troubleshooting

| Problem | Solution |
|---------|----------|
| "javac not found" | Add Java to PATH or use full path |
| "Main class not found" | Make sure all 5 Java files are in same folder |
| Compilation errors | Check for typos in file names |
| No output | Make sure you ran `java Main` (not `java Main.java`) |

---

## 📚 Understanding the Code

### Classes = Blueprints
```java
public class Book {           // Blueprint for books
    private String isbn;      // What each book has
    private String title;
    
    public Book(...) { }      // How to create a book
}

Book b = new Book(...);       // Create actual book from blueprint
```

### Methods = Actions
```java
library.addBook(book);        // Action: add a book
library.checkoutBook(...);    // Action: borrow a book
library.returnBook(...);      // Action: return a book
```

### Collections = Groups
```java
List<Book> books = new ArrayList<>();  // List to hold many books
books.add(book1);             // Add book to list
books.add(book2);
```

---

## 🚀 Next Level

After running the basic version:

1. **Modify Book class** - Add `genre` field
2. **Modify Patron class** - Add `phoneNumber` field
3. **Add new methods** - Create `searchByGenre()` method
4. **Add features** - Calculate late fees, add reservations

---

## ✨ Key Points to Remember

✅ **Classes** are like blueprints  
✅ **Objects** are things made from blueprints  
✅ **Methods** are actions things can do  
✅ **Collections** hold multiple objects  
✅ **Encapsulation** hides internal details  

---

## 🎓 Learning Tips

- Start with understanding the 4 classes
- Run Main.java first to see how it works
- Modify Main.java to try different operations
- Add print statements to see what's happening
- Try adding new features yourself

---

## 🎯 You're Ready!

You now understand:
- ✅ Object-Oriented Programming basics
- ✅ How classes work together
- ✅ How to use collections
- ✅ How to build a real application

**Go compile and run it!** 🚀

```bash
javac Book.java Patron.java Transaction.java Library.java Main.java
java Main
```

Happy coding! 🎉
