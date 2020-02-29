/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TargetCompanyAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Hanan
 */
public class TargetAdminOrganization extends Organization {
    
    public TargetAdminOrganization() {
    super(Organization.Type.Target.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TargetCompanyAdminRole());
        return roles;
    }
     
}
