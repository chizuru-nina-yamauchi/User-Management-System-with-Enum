import java.time.LocalDate;

// User class representing a user entry
public class User {
    private static int userIDCounter = 1;

    // Attributes
    private final int userID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String location;
    private  UserRole role;

    // Constructor
    public User(String firstName, String lastName, LocalDate dateOfBirth, String location, UserRole role) {
        this.userID = userIDCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.role = role;
    }

    // Getter and setter
    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", location='" + location + '\'' +
                ", role=" + role +
                '}';
    }
}