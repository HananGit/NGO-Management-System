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
import userinterface.BenefactorCompanyAdminRole.BenefactorWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class BenefactorCompanyAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new BenefactorWorkAreaJPanel(userProcessContainer, account, organization,enterprise, business);
    }
    
}
