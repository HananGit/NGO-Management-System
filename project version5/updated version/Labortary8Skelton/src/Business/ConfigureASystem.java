package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");//here you can give default value to play arount with
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("System Admin","sysadmin", "sysadmin", employee, new SystemAdminRole(),"Enabled","ngo.app.test@gmail.com","apptest123");//here you can give default value to play arount with
        
        return system;
    }
    
}
