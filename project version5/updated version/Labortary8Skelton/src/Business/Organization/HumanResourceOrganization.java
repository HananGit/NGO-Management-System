/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HumanResourceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HumanResourceOrganization extends Organization{

    public HumanResourceOrganization() {
        super(Organization.Type.HumanResourceDepartment.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HumanResourceManagerRole());
        return roles;
    }
     
}
