/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author sushr
 */
public class EnterpriseRelationDirectory {
    private ArrayList<EnterpriseRelation> relationList;

    public EnterpriseRelationDirectory() {
        relationList = new ArrayList<EnterpriseRelation>();
    }
    

    public ArrayList<EnterpriseRelation> getRelationList() {
        return relationList;
    }
    
    public EnterpriseRelation createRelation(String cName,String cType){
        EnterpriseRelation er = new EnterpriseRelation();
        er.setCompanyName(cName);
        er.setCompanyType(cType);
        relationList.add(er);
        return er;
    }
    public void deleteRelation(EnterpriseRelation er)
    {
        relationList.remove(er);
        
    }
    public void deleteRelation(String s)
    {
        for(int i=0;i<relationList.size();i++)
        {
            if(relationList.get(i).getCompanyName().equals(s))
                relationList.remove(i);
        }
        
        
    }
    
    public void setRelationList(ArrayList<EnterpriseRelation> relationList) {
        this.relationList = relationList;
    }

}
