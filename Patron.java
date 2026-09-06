/**
 * Simple Patron class for beginners
 * Demonstrates basic data management
 */
public class Patron {
    private String patronId;
    private String name;
    private String email;
    
    public Patron(String patronId, String name, String email) {
        this.patronId = patronId;
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getPatronId() {
        return patronId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Patron{" +
                "patronId='" + patronId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
