/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Hanan
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory(){
        
        enterpriseList=new ArrayList<Enterprise>();
    }
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type,String status){
    //same thing here is done in OrganizationDirectory class
    Enterprise enterprise=null;    
        if(type==Enterprise.EnterpriseType.OperatingCompany){
            enterprise= new OperatingCompanyEnterprise(name);
            enterprise.setStatus(status);
            enterpriseList.add(enterprise);
            enterprise.getDonationType().add("Food");
            enterprise.getDonationType().add("Money");
            enterprise.getDonationType().add("Clothes");
            
            
            
        }
        else if(type==Enterprise.EnterpriseType.BenefactorCompany){
            enterprise= new BenefactorCompanyEnterprise(name);
            enterprise.setStatus(status);
            enterpriseList.add(enterprise);
//            System.out.println("IN benefactor");

            
        }
        else if(type==Enterprise.EnterpriseType.TargetCompany){
            enterprise= new TargetCompanyEnterprise(name);
            enterprise.setStatus(status);
            enterpriseList.add(enterprise);
//                        System.out.println("IN Target");
        }
        else if(type==Enterprise.EnterpriseType.VendorCompany){
            enterprise= new VendorCompanyEnterprise(name);
            enterprise.setStatus(status);
            enterpriseList.add(enterprise);
//        System.out.println("IN Vendor");
        }
        return enterprise;
    }
    
}
