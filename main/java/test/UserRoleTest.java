import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleTest {
    @Test
    public void testUserRoleMethods() {
        try {
            // Trying to find a user role by name
            UserRole foundUserRole = UserRole.findRoleByName("ADMIN");
            assertEquals(UserRole.ADMIN, foundUserRole);

            // Trying to find a use role by label
            UserRole foundUserRole2 = UserRole.findRoleByLabel("Moderator");
            assertEquals(UserRole.MOD, foundUserRole2);

            // Trying to find use roles by specific privileges (ex. read, writeSelf, writeOthers: true, true, true)
            List<UserRole> foundUserRoleByPrivileges = UserRole.findRolesByPrivileges(false, true, false);
            assertEquals(List.of(UserRole.MOD), foundUserRoleByPrivileges);
        } catch (IllegalArgumentException e) {
            // Exception handling with messages in UserRole class
            assertEquals("No role found with specified privileges", e.getMessage());
        }
    }

}