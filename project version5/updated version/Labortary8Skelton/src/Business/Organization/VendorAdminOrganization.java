/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.VendorCompanyAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Hanan
 */
public class VendorAdminOrganization extends Organization {
    
    public VendorAdminOrganization() {
    super(Organization.Type.Vendor.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VendorCompanyAdminRole());
        return roles;
    }
     
}
