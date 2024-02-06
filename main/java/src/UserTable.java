import java.util.HashMap;
import java.util.Map;

public class UserTable {
    // Attributes
    private final Map<Integer, User> users;

    // Constructor
    public UserTable() {
        this.users = new HashMap<>();
    }

    public User findUserByID(Integer targetUserID){
        return users.get(targetUserID);
    }

    public void addUser(Integer currentUserId, User newUser) throws IllegalArgumentException{
        User currentUser = users.get(currentUserId);
        if(currentUser != null && currentUser.getRole().equals(UserRole.ADMIN)){
            users.put(newUser.getUserID(), newUser);
        }else{
            throw new IllegalArgumentException("Only admins can add new users");
        }
    }

    public void deleteUserByID(Integer currentUserID, Integer targetUserID){

    }
}
