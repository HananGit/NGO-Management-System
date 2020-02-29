/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.VolunteerRole.VolunteerRoleJPanel;

/**
 *
 * @author raunak
 */
public class VolunteerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new VolunteerRoleJPanel(userProcessContainer, account, organization,enterprise, business);
        return new VolunteerRoleJPanel();
    }
    
}
