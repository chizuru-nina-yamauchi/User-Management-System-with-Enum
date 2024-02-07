
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserTable {
    // Attributes
    private final Map<Integer, User> users;

    // Constructor
    public UserTable() {
        this.users = new HashMap<>();
    }



    public User findUserById(Integer targetUserID){
        return users.get(targetUserID);
    }

    public void addUserInitially(User user) {
        users.put(user.getUserID(), user);
    }

    public void addUser(Integer currentUserId, User newUser) throws IllegalArgumentException{
        User currentUser = users.get(currentUserId);
        if(currentUser != null && currentUser.getRole().equals(UserRole.ADMIN)){
            users.put(newUser.getUserID(), newUser);
        }else{
            throw new IllegalArgumentException("Only admins can add new users");
        }
    }

    public void deleteUserById(Integer currentUserID, Integer targetUserID){
        User currentUser = users.get(currentUserID);
        User targetUser = users.get(targetUserID);
        if(currentUser != null && targetUser != null) {
            if (currentUser.getRole().equals(UserRole.ADMIN) && targetUser.getRole().equals(UserRole.MOD)) {
                users.remove(targetUserID);
            } else if (currentUser.getRole().equals(UserRole.MOD) && targetUser.getRole().equals(UserRole.REGULAR)) {
                users.remove(targetUserID);
            } else {
                throw new IllegalArgumentException("The operation is not allowed.");
            }
        }else {
            throw new IllegalArgumentException("Invalid IDs.");
        }


    }
}
