/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BenefactorCompanyAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Hanan
 */
public class BenefactorAdminOrganization extends Organization {
    
    public BenefactorAdminOrganization() {
    super(Organization.Type.Benefactor.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BenefactorCompanyAdminRole());
        return roles;
    }
     
}
