/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.EventManagementDepartment.getValue())){
            organization = new EventManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FinanceDepartment.getValue())){
            organization = new FinanceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HumanResourceDepartment.getValue())){
            organization = new HumanResourceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Benefactor.getValue())){
            organization = new BenefactorAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Target.getValue())){
            organization = new TargetAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Vendor.getValue())){
            organization = new VendorAdminOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}