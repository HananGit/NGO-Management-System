/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.WorkQueue.EventWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Hanan
 */
public abstract class Enterprise extends Organization{//read why we put it abstract class? and come up with answers
    //error on line 14 cuz we either need to implement all abstract methods (from parent class) or make this class as abstract
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private EnterpriseRelationDirectory enterpriseRelationDirectory;
    private String status;
    private ArrayList<String> donationType;
    private ArrayList<EventWorkRequest> eventList;

    public ArrayList<String> getDonationType() {
        return donationType;
    }

    public void setDonationType(ArrayList<String> donationType) {
        this.donationType = donationType;
    }

    public ArrayList<EventWorkRequest> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<EventWorkRequest> eventList) {
        this.eventList = eventList;
    }
    
    public Enterprise(String name,EnterpriseType enterpriseType) {
        super(name);
        this.enterpriseType=enterpriseType;
        organizationDirectory=new OrganizationDirectory();
        enterpriseRelationDirectory= new EnterpriseRelationDirectory();
        donationType = new ArrayList<>();
        eventList=new ArrayList<>();
    }
    
    public enum EnterpriseType{
        TargetCompany("TargetCompany"),
        VendorCompany("VendorCompany"),
        BenefactorCompany("BenefactorCompany"),
        OperatingCompany("OperatingCompany");
        private String value;

        
        private EnterpriseType(String value){//we added this constructor cuz there was error in line 20: Hospital("Hospital");
            this.value=value;
        }
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        @Override
       public String toString(){
           return value;
       } 
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public EnterpriseRelationDirectory getEnterpriseRelationDirectory() {
        return enterpriseRelationDirectory;
    }

    public void setEnterpriseRelationDirectory(EnterpriseRelationDirectory enterpriseRelationDirectory) {
        this.enterpriseRelationDirectory = enterpriseRelationDirectory;
    }
      
    @Override
    public String toString()
    {
        return getName();
    }
}
