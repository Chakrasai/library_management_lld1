import java.time.LocalDate;

/**
 * Simple transaction record for beginners
 * Tracks book borrowing
 */
public class Transaction {
    private String patronId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    
    public Transaction(String patronId, String isbn) {
        this.patronId = patronId;
        this.isbn = isbn;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }
    
    // Getters
    public String getPatronId() {
        return patronId;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    // Setters
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    @Override
    public String toString() {
        return "Transaction{" +
                "patronId='" + patronId + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
