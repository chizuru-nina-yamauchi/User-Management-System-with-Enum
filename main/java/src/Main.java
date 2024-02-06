import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Creating a User instance
        User edwardNewgate = new User(1, "Edward", "Newgate", LocalDate.of(1450,4,6) , "EastBlue", UserRole.ADMIN);
        // Printing the User information above using overridden toString() method
        System.out.println(edwardNewgate.toString());

        try {
            // Trying to find a user role by name
            UserRole foundUserRole = UserRole.findRoleByName("ADMIN");
            System.out.println("Role found by name 'ADMIN': " + foundUserRole);

            // Trying to find a use role by label
            UserRole foundUserRole2 = UserRole.findRoleByLabel("Moderator");
            System.out.println("Role found by label 'Moderator': " + foundUserRole2);

            // Trying to find use roles by specific privileges(ex. read, writeSelf, writeOthers: true, true, true)
            List<UserRole> foundUserRoleByPrivileges = UserRole.findRolesByPrivileges(false, true, false);
            System.out.println("Role found by privileges 'false, true, false': " + foundUserRoleByPrivileges);
        }catch (IllegalArgumentException e){
            // Exception handling with messages in UserRole class
            System.out.println(e.getMessage());
        }


    }


}
