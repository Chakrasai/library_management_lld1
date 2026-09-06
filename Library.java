import java.time.LocalDate;
import java.util.*;

/**
 * Simple Library class for beginners
 * Manages books and patrons
 */
public class Library {
    private String name;
    private List<Book> books;          // List to store all books
    private List<Patron> patrons;      // List to store all patrons
    private List<Transaction> transactions;  // List to track borrowing
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    
    // ============ BOOK MANAGEMENT ============
    
    /**
     * Add a book to the library
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✓ Book added: " + book.getTitle());
    }
    
    /**
     * Remove a book by ISBN
     */
    public void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                System.out.println("✓ Book removed");
                return;
            }
        }
        System.out.println("✗ Book not found");
    }
    
    /**
     * Find a book by ISBN
     */
    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Find books by title
     */
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    /**
     * Find books by author
     */
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    /**
     * Get all available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }
    
    /**
     * Get all books
     */
    public List<Book> getAllBooks() {
        return books;
    }
    
    // ============ PATRON MANAGEMENT ============
    
    /**
     * Register a new patron
     */
    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("✓ Patron registered: " + patron.getName());
    }
    
    /**
     * Find a patron by ID
     */
    public Patron findPatron(String patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronId().equals(patronId)) {
                return patron;
            }
        }
        return null;
    }
    
    /**
     * Get all patrons
     */
    public List<Patron> getAllPatrons() {
        return patrons;
    }
    
    // ============ LENDING OPERATIONS ============
    
    /**
     * Checkout a book to a patron
     */
    public void checkoutBook(String patronId, String isbn) {
        Patron patron = findPatron(patronId);
        Book book = findBook(isbn);
        
        if (patron == null) {
            System.out.println("✗ Patron not found");
            return;
        }
        
        if (book == null) {
            System.out.println("✗ Book not found");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("✗ Book not available");
            return;
        }
        
        // Mark book as unavailable
        book.setAvailable(false);
        
        // Create transaction record
        Transaction transaction = new Transaction(patronId, isbn);
        transactions.add(transaction);
        
        System.out.println("✓ Book checked out to " + patron.getName());
    }
    
    /**
     * Return a book from a patron
     */
    public void returnBook(String patronId, String isbn) {
        Book book = findBook(isbn);
        
        if (book == null) {
            System.out.println("✗ Book not found");
            return;
        }
        
        // Mark book as available
        book.setAvailable(true);
        
        // Update transaction record
        for (Transaction transaction : transactions) {
            if (transaction.getPatronId().equals(patronId) && 
                transaction.getIsbn().equals(isbn) && 
                transaction.getReturnDate() == null) {
                transaction.setReturnDate(LocalDate.now());
                System.out.println("✓ Book returned");
                return;
            }
        }
        
        System.out.println("✗ Transaction not found");
    }
    
    /**
     * Get borrowing history for a patron
     */
    public void showPatronHistory(String patronId) {
        System.out.println("\n--- Borrowing History for Patron " + patronId + " ---");
        
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getPatronId().equals(patronId)) {
                System.out.println("  ISBN: " + transaction.getIsbn() + 
                                 " | Borrowed: " + transaction.getBorrowDate() + 
                                 " | Returned: " + transaction.getReturnDate());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("  No borrowing history");
        }
    }
    
    // ============ LIBRARY INFO ============
    
    /**
     * Display library statistics
     */
    public void printStatistics() {
        System.out.println("\n========== " + name + " STATISTICS ==========");
        System.out.println("Total Books: " + books.size());
        System.out.println("Available Books: " + getAvailableBooks().size());
        System.out.println("Borrowed Books: " + (books.size() - getAvailableBooks().size()));
        System.out.println("Total Patrons: " + patrons.size());
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("=========================================\n");
    }
    
    /**
     * Get library name
     */
    public String getName() {
        return name;
    }
}
