import java.util.ArrayList;
import java.util.List;

// Enum representing different user roles and their privileges
public enum UserRole {
    // Enum constants with following privileges
    REGULAR("Regular user",true,true,false),
    MOD("Moderator", true, true, true),
    ADMIN("Administrator", true, true, true);

    // Attributes for each enum constant
    private final String label;
    private final boolean read;
    private final boolean writeSelf;
    private final boolean writeOthers;

    // Constructor for initializing enum constants with privileges(public access modifier is not allowed)
    UserRole(String label, boolean read, boolean writeSelf, boolean writeOthers){
        this.label = label;
        this.read = read;
        this.writeSelf = writeSelf;
        this.writeOthers = writeOthers;
    }

    public String getLabel(){
        return label;
    }
    public boolean isRead(){
        return read;
    }
    public boolean isWriteSelf(){
        return writeSelf;
    }
    public boolean isWriteOthers(){
        return writeOthers;
    }

    /**
     * Finds a user role by its name
     * @param name The name of role to find
     * @return The UserRole with the specified name
     * @throws IllegalArgumentException if no role is found with the given name
     */
    public static UserRole findRoleByName(String name) throws IllegalArgumentException {
        for (UserRole role : values()) {
                if(role.name().equals(name)){
                    return role;
                }
        }
        throw new IllegalArgumentException(String.format("No role found with name '%s'.", name));
    }

    /**
     * FInds a user role by its label
     *
     * @param label The label of the role to find
     * @return The UserRole with the specified label
     * @throws IllegalArgumentException If no role is found with the given label
     */
    public static UserRole findRoleByLabel(String label) throws IllegalArgumentException{
        for (UserRole role : values()) {
            if(role.getLabel().equals(label)){
                return role;
            }
        }
        throw new IllegalArgumentException(String.format("No label found with label %s.", label));
    }

    /**
     *Finds user role based on specified privileges
     *
     * @param read The read privilege
     * @param writeSelf The writeSelf privilege
     * @param writeOthers The writeOthers privilege
     * @return A list of UserRole instances matching the specified privileges
     * @throws IllegalArgumentException If no role is found with the specific privileges
     */

    public static List<UserRole> findRolesByPrivileges(boolean read, boolean writeSelf, boolean writeOthers) throws IllegalArgumentException {
        List<UserRole> matchingRoles = new ArrayList<>();
        for (UserRole role : values()) {
            if (role.isRead() == read && role.isWriteSelf() == writeSelf && role.isWriteOthers() == writeOthers) {
                matchingRoles.add(role);
            }
        }if (matchingRoles.isEmpty()) {
            throw new IllegalArgumentException("No role found with specified privileges");
        }
            return matchingRoles;
        }
    }

