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
    
    private Repository rep;
    private Map<String, User> users;
    
    public SysAdmin() {
        this.rep = new Repository();
        this.users = new HashMap<>();
    }
    
    public void createUser(String username, String password, String role) throws SQLException {
        User user = UserFactory.getUser(role);
        user.setPassword(password);
        user.setUsername(username);
                
        rep.insert("insert into \"user\"(username, password, role) values('" + username + "','" + password + "','" + role + "')");
        
        users.put(username, user);
    }
    
    public void updateUser(String oldUsername, String newUsername, String password, String role) throws SQLException {
        rep.update("update \"user\" set username='" + newUsername + "', password='" + password + "', role='" + role + "' where username='" + oldUsername + "'");
        
        users.remove(oldUsername);
        
        User user = UserFactory.getUser(role);
        user.setPassword(password);
        user.setUsername(newUsername);
        
        users.put(newUsername, user);
    }
    
    public void deleteUser(String username) throws SQLException {
        rep.delete("delete from \"user\" where username='" + username + "'");
        
        users.remove(username);
    }

    public Map<String, User> getUsers() throws SQLException {
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
