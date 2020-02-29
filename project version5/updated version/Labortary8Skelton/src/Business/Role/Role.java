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

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        VendorAdmin("Vendor Admin"),
        EventManager("Event Manager Role"),
        TargetCompanyAdmin("Target Company Admin Role"),
        BenefactorCompanyAdmin("Benefactor Company Admin Role"),
        FinanceManager("Finance Manager Role"),
//        OperatingCompanyAdmin("Operating Company Admin Role"),
        HumanResourceManager("Human Resource Admin Role"),
        Employee("Employee");
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return getClass().getTypeName();
    }
    
    
}