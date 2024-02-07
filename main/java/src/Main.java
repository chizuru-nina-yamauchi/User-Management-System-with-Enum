
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Creating a User instance
        User edwardNewgate = new User("Edward", "Newgate", LocalDate.of(1450,4,6) , "EastBlue", UserRole.ADMIN);
        User nicoRObin = new User("Nico", "Robin",LocalDate.of(1524,2,6),"Ohara",UserRole.ADMIN);
        // Printing the User information above using overridden toString() method
        System.out.println(edwardNewgate);
        System.out.println(nicoRObin);

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

        System.out.println("User Interaction Start.");


        UserTable userTable = new UserTable();
        userTable.addUserInitially(edwardNewgate);
        userTable.addUserInitially(nicoRObin);

        Scanner scanner = new Scanner(System.in);

        try {
            try {
            while (true) {
                System.out.println("----------------");
                System.out.println("Choose an option:");
                System.out.println("1. Login and add User");
                System.out.println("2. Find User by ID");
                System.out.println("3. Exit");

                String optionInput = scanner.nextLine();
                int option = Integer.parseInt(optionInput);

                switch (option) {

                        case 1:
                            System.out.println("Enter user ID to login");
                            String userIDInput = scanner.nextLine();
                            int userID = Integer.parseInt(userIDInput);
                            User loginUser = userTable.findUserById(userID);

                            if (loginUser != null) {
                                System.out.println("Login successful. Welcome, " + loginUser.getFirstName() + " " + loginUser.getLastName() + " .");
                                if (loginUser != null && loginUser.getRole() == UserRole.ADMIN) {
                                    System.out.println("Enter new user details:");
                                    System.out.print("First Name: ");
                                    String firstName = scanner.nextLine();

                                    System.out.print("Last Name: ");
                                    String lastName = scanner.nextLine();
                                    System.out.print("Date of Birth (YYYY-MM-DD): ");
                                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
                                    System.out.print("Location: ");
                                    String location = scanner.nextLine();
                                    System.out.print("User Role (REGULAR, MOD, ADMIN): ");
                                    UserRole role = UserRole.valueOf(scanner.nextLine());

                                    User newUser = new User(firstName, lastName, dateOfBirth, location, role);

                                    userTable.addUser(loginUser.getUserID(), newUser);
                                    System.out.println("User added successfully.\n New User Info: \n" + newUser);
                                } else {
                                    System.out.println("You need to log in as an admin to add a new user.");
                                }
                            } else {
                                System.out.println("User not found. Please try again.");
                            }

                            break;
                        case 2:
                            System.out.println("Enter user ID to find:");
                            String targetUserIDInput = scanner.nextLine();
                            int targetUserID = Integer.parseInt(targetUserIDInput);
                            User foundUser = userTable.findUserById(targetUserID);

                            if (foundUser != null) {
                                System.out.println("User found: " + foundUser);
                            } else {
                                System.out.println("User not found.");
                            }
                            break;
                        case 3:
                            System.out.println("Exiting the program.");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                        }
                    }

                }catch (DateTimeParseException e){
                    System.out.println("Please enter the date with the right format 'YYYY-MM-DD'.");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid format. Try again with number.");
            }

        }


    }


