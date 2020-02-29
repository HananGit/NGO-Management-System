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
import userinterface.HumanResourceManagerRole.HumanResourceManagerWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class HumanResourceManagerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HumanResourceManagerWorkAreaJPanel(userProcessContainer, account, organization,enterprise, business);
    }
    
}
