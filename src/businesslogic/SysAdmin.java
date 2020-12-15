/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import database.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ugobarbato
 */
public class SysAdmin extends User {
    /**
     * rep: a Repository object representing the database.
     * users: a data structure representing the users.
     */
    private Repository rep;
    private Map<String, User> users;
    
    public SysAdmin() throws ClassNotFoundException, SQLException {
        this.rep = Repository.getIstance();
        this.users = new HashMap<>();
    }
    
    /**
     * A new user is instantiated with the username, password and role, then are insert in the database.
     * @param username a String representing the username of the user
     * @param password a String representing the password of the user
     * @param role a String representing the role of the user
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void createUser(String username, String password, String role) throws SQLException, ClassNotFoundException {
        User user = UserFactory.getUser(role);
        user.setPassword(password);
        user.setUsername(username);
                
        rep.insert("insert into \"user\"(username, password, role) values('" + username + "','" + password + "','" + role + "')");
        
        users.put(username, user);
    }
    
    /**
     * The user is updated on the database with the new username, password and role,
     * then is removed the user with the old username, and is istantiated a new user with the new data.
     * @param oldUsername a String representing the old username saved of the user
     * @param newUsername a String representing the new username of the user
     * @param password a String representing the password of the user
     * @param role a String representing the role of the user
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateUser(String oldUsername, String newUsername, String password, String role) throws SQLException, ClassNotFoundException {
        rep.update("update \"user\" set username='" + newUsername + "', password='" + password + "', role='" + role + "' where username='" + oldUsername + "'");
        
        users.remove(oldUsername);
        
        User user = UserFactory.getUser(role);
        user.setPassword(password);
        user.setUsername(newUsername);
        
        users.put(newUsername, user);
    }
    
    /**
     * Delete from the database the user with the username, then remove from the user's map.
     * @param username a String representing the username of the user which must be deleted
     * @throws SQLException 
     */
    public void deleteUser(String username) throws SQLException {
        rep.delete("delete from \"user\" where username='" + username + "'");
        
        users.remove(username);
    }

    /**
     * First get all the user from the database, then they are added to the map.
     * @return the users from the map
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Map<String, User> getUsers() throws SQLException, ClassNotFoundException {
        ResultSet res = rep.select("select * from \"user\"; ");
        
        while(res.next()) {
            User user = UserFactory.getUser(res.getString("role"));
            user.setPassword(res.getString("password"));
            user.setUsername(res.getString("username"));
            users.put(res.getString("username"), user);
        }
        return users;
    }
}
