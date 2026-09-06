/**
 * Simple demo application for beginners
 * Shows basic Library Management System usage
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("LIBRARY MANAGEMENT SYSTEM - BEGINNER VERSION");
        System.out.println("=".repeat(50));
        
        // Create a library
        Library library = new Library("City Library");
        
        // ============ ADD BOOKS ============
        System.out.println("\n--- Adding Books ---");
        library.addBook(new Book("ISBN001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("ISBN002", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("ISBN003", "1984", "George Orwell"));
        library.addBook(new Book("ISBN004", "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book("ISBN005", "Clean Code", "Robert Martin"));
        
        // ============ REGISTER PATRONS ============
        System.out.println("\n--- Registering Patrons ---");
        library.registerPatron(new Patron("P001", "Alice Johnson", "alice@email.com"));
        library.registerPatron(new Patron("P002", "Bob Smith", "bob@email.com"));
        library.registerPatron(new Patron("P003", "Carol White", "carol@email.com"));
        
        // ============ SEARCH BOOKS ============
        System.out.println("\n--- Searching Books ---");
        
        // Search by title
        System.out.println("\nBooks containing 'Great':");
        for (Book book : library.searchByTitle("Great")) {
            System.out.println("  • " + book.getTitle());
        }
        
        // Search by author
        System.out.println("\nBooks by George Orwell:");
        for (Book book : library.searchByAuthor("George Orwell")) {
            System.out.println("  • " + book.getTitle());
        }
        
        // ============ CHECKOUT BOOKS ============
        System.out.println("\n--- Checking Out Books ---");
        library.checkoutBook("P001", "ISBN001");  // Alice borrows The Great Gatsby
        library.checkoutBook("P001", "ISBN002");  // Alice borrows To Kill a Mockingbird
        library.checkoutBook("P002", "ISBN003");  // Bob borrows 1984
        library.checkoutBook("P003", "ISBN005");  // Carol borrows Clean Code
        
        // ============ SHOW AVAILABLE BOOKS ============
        System.out.println("\n--- Available Books ---");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("  • " + book.getTitle());
        }
        
        // ============ SHOW BORROWING HISTORY ============
        System.out.println("\n--- Patron Information ---");
        library.showPatronHistory("P001");
        library.showPatronHistory("P002");
        library.showPatronHistory("P003");
        
        // ============ RETURN BOOKS ============
        System.out.println("\n--- Returning Books ---");
        library.returnBook("P001", "ISBN001");  // Alice returns The Great Gatsby
        library.returnBook("P002", "ISBN003");  // Bob returns 1984
        
        // ============ SHOW UPDATED AVAILABLE BOOKS ============
        System.out.println("\n--- Available Books After Returns ---");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("  • " + book.getTitle());
        }
        
        // ============ STATISTICS ============
        library.printStatistics();
        
        System.out.println("=".repeat(50));
        System.out.println("Demo completed successfully!");
        System.out.println("=".repeat(50) + "\n");
    }
}
