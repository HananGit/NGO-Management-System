/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password) && ua.getStatus().equals("Enabled")){
                return ua;
            }
        return null;
    }
    
    public UserAccount getEmailDetails(String username){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String name,String username, String password, Employee employee, Role role,String status){
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setUsername(username);
        userAccount.setStatus(status);
        
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createUserAccount(String name,String username, String password, Employee employee, Role role,String status,String email){
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setUsername(username);
        userAccount.setStatus(status);
        userAccount.setEmail(email);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createUserAccount(String name,String username, String password, Employee employee, Role role,String status, String email, String emailpassword){
    
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setUsername(username);
        userAccount.setStatus(status);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setEmail(email);
        userAccount.setEmailPassword(emailpassword);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
