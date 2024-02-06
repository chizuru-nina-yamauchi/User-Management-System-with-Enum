import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void testUserToString() {
        User user1 = new User("Edward", "Newgate", LocalDate.of(1450,4,6) , "EastBlue", UserRole.ADMIN);
        String expected = "User{userID=1, firstName='Edward', lastName='Newgate', dateOfBirth=1450-04-06, location='EastBlue', role=ADMIN}";
        assertEquals(expected, user1.toString());
        User user2 = new User("Nico", "Robin",LocalDate.of(1524,2,6),"Ohara",UserRole.ADMIN);
        String expected2 = "User{userID=2, firstName='Nico', lastName='Robin', dateOfBirth=1524-02-06, location='Ohara', role=ADMIN}";
        assertEquals(expected2, user2.toString());
    }
}