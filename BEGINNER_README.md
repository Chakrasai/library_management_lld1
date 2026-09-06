# Library Management System - Beginner Edition

A simple Library Management System in Java designed for beginners to understand basic Object-Oriented Programming (OOP) concepts.

## 🎯 What You'll Learn

- **Object-Oriented Programming (OOP)**: Classes, objects, encapsulation
- **Data Structures**: Lists, Collections
- **Core Concepts**: Inheritance, Methods, Getters/Setters
- **Real-world Application**: Building a functional library system

## 📚 Simple Architecture

```
Book.java          → Represents a book
Patron.java        → Represents a library member
Transaction.java   → Tracks book borrowing
Library.java       → Manages everything
Main.java          → Demo application
```

## 🚀 Quick Start

### Compile
```bash
cd library_management_lld
javac Book.java Patron.java Transaction.java Library.java Main.java
```

### Run
```bash
java Main
```

## 📖 Core Classes

### Book
Represents a book with basic information.

```java
Book book = new Book("ISBN001", "The Great Gatsby", "F. Scott Fitzgerald");
book.getTitle();       // Get book title
book.isAvailable();    // Check if available
book.setAvailable(true);  // Mark as available/unavailable
```

**Key Properties:**
- `isbn`: Unique book identifier
- `title`: Book name
- `author`: Book author
- `isAvailable`: Availability status

### Patron
Represents a library member.

```java
Patron patron = new Patron("P001", "Alice Johnson", "alice@email.com");
patron.getName();      // Get patron name
patron.getEmail();     // Get email
```

**Key Properties:**
- `patronId`: Unique patron identifier
- `name`: Patron name
- `email`: Contact email

### Transaction
Tracks when a book is borrowed and returned.

```java
Transaction trans = new Transaction("P001", "ISBN001");
trans.getBorrowDate();  // When book was borrowed
trans.getReturnDate();  // When book was returned
```

**Key Properties:**
- `patronId`: Who borrowed
- `isbn`: Which book
- `borrowDate`: Borrow date
- `returnDate`: Return date

### Library
Main manager class that coordinates all operations.

```java
Library library = new Library("City Library");

// Add books
library.addBook(new Book("ISBN001", "Book Title", "Author Name"));

// Register patrons
library.registerPatron(new Patron("P001", "John Doe", "john@email.com"));

// Checkout book
library.checkoutBook("P001", "ISBN001");

// Return book
library.returnBook("P001", "ISBN001");

// Search books
library.searchByTitle("Great");
library.searchByAuthor("Orwell");

// Get statistics
library.printStatistics();
```

## 💡 Key Methods

### Book Management
```java
library.addBook(book)              // Add a book
library.removeBook("ISBN001")      // Remove a book
library.findBook("ISBN001")        // Search by ISBN
library.searchByTitle("title")     // Search by title
library.searchByAuthor("author")   // Search by author
library.getAvailableBooks()        // Get all available books
```

### Patron Management
```java
library.registerPatron(patron)    // Register new patron
library.findPatron("P001")        // Find patron by ID
library.getAllPatrons()           // Get all patrons
```

### Lending Operations
```java
library.checkoutBook("P001", "ISBN001")   // Borrow a book
library.returnBook("P001", "ISBN001")     // Return a book
library.showPatronHistory("P001")         // View borrowing history
```

### Library Info
```java
library.printStatistics()         // Show statistics
library.getName()                 // Get library name
```

## 🔍 Example Usage

```java
// Create library
Library library = new Library("My Library");

// Add some books
library.addBook(new Book("ISBN001", "The Great Gatsby", "F. Scott Fitzgerald"));
library.addBook(new Book("ISBN002", "1984", "George Orwell"));

// Register patrons
library.registerPatron(new Patron("P001", "Alice", "alice@email.com"));
library.registerPatron(new Patron("P002", "Bob", "bob@email.com"));

// Search for books
List<Book> results = library.searchByTitle("Gatsby");
System.out.println("Found: " + results.get(0).getTitle());

// Checkout books
library.checkoutBook("P001", "ISBN001");  // Alice borrows Gatsby
library.checkoutBook("P002", "ISBN002");  // Bob borrows 1984

// Show available books
for (Book book : library.getAvailableBooks()) {
    System.out.println("Available: " + book.getTitle());
}

// Return books
library.returnBook("P001", "ISBN001");    // Alice returns Gatsby

// View borrowing history
library.showPatronHistory("P001");

// Show statistics
library.printStatistics();
```

## 📋 Program Flow

```
1. Create Library
   ↓
2. Add Books
   ↓
3. Register Patrons
   ↓
4. Search for Books
   ↓
5. Checkout Books
   ↓
6. View Available Books
   ↓
7. View Borrowing History
   ↓
8. Return Books
   ↓
9. View Updated Available Books
   ↓
10. View Statistics
```

## 🎓 OOP Concepts Demonstrated

### Encapsulation
Private fields with public getters/setters:
```java
private String title;
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
```

### Classes & Objects
Creating and using objects:
```java
Book book = new Book("ISBN001", "Title", "Author");
Patron patron = new Patron("P001", "Name", "email");
```

### Collections
Using Lists to store objects:
```java
private List<Book> books = new ArrayList<>();
books.add(book);
```

### Methods
Functions inside classes:
```java
public void checkoutBook(String patronId, String isbn) { ... }
public List<Book> searchByTitle(String title) { ... }
```

## 📊 Statistics

The system tracks:
- Total number of books in the library
- Number of available books
- Number of borrowed books
- Total patrons registered
- Total transactions (borrowing events)

## ❓ Common Questions

**Q: How do I add a book?**
A: `library.addBook(new Book("ISBN", "Title", "Author"));`

**Q: How do I checkout a book?**
A: `library.checkoutBook("PatronID", "ISBN");`

**Q: Can a patron borrow multiple books?**
A: Yes! The system supports multiple checkouts.

**Q: How do I see borrowing history?**
A: `library.showPatronHistory("PatronID");`

## 🎯 Learning Path

1. **Start with Book.java** → Understand basic class structure
2. **Move to Patron.java** → Learn about different entities
3. **Study Transaction.java** → See how to track events
4. **Review Library.java** → Understand how classes work together
5. **Run Main.java** → See a complete example in action

## 📝 Practice Exercises

1. **Add a phone number field to Patron**
   - Add private field
   - Create getter and setter

2. **Add a genre field to Book**
   - Add private field
   - Create getter and setter
   - Use it in searchByGenre() method

3. **Add a fine calculation feature**
   - Track return dates
   - Calculate fines for late returns

4. **Add a reservation system**
   - Allow patrons to reserve unavailable books
   - Notify when book becomes available

## 🔗 File Descriptions

| File | Purpose |
|------|---------|
| Book.java | Represents a single book with title, author, ISBN |
| Patron.java | Represents a library member with name and email |
| Transaction.java | Tracks borrowing and returning of books |
| Library.java | Main coordinator managing all operations |
| Main.java | Demo program showing how to use the system |

## ✅ Compilation & Execution Checklist

- [ ] Save all Java files in same directory
- [ ] Open terminal in project directory
- [ ] Run: `javac *.java` or `javac Book.java Patron.java Transaction.java Library.java Main.java`
- [ ] Run: `java Main`
- [ ] Verify output appears without errors

## 🎉 Success!

If you see the library statistics printed at the end, your program is working correctly!

## 📚 Next Steps After Mastering This

- Add database storage (SQL/JDBC)
- Create a GUI (Swing/JavaFX)
- Implement advanced features (multi-branch, recommendations)
- Add error handling (try-catch blocks)
- Write unit tests (JUnit)

---

**Happy Learning! 🚀**

This simplified version focuses on core concepts without overwhelming complexity. Once you master this, check out the advanced version with design patterns!
