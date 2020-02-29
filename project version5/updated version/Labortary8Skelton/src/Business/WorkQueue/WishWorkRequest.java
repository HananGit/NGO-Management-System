/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WishWorkRequest extends WorkRequest {
private String wishTitle;
private String wishDetails;
private String wishDesc;
private String operatingOrgName;
private String targetOrgName;
private int cost;

private ArrayList <Contributor> contributorList;

    public WishWorkRequest() {
        contributorList = new ArrayList<>();
                
    }

    public ArrayList<Contributor> getContributorList() {
        return contributorList;
    }

    public void setContributorList(ArrayList<Contributor> contributorList) {
        this.contributorList = contributorList;
    }
    
    
    public String getWishTitle() {
        return wishTitle;
    }

    public void setWishTitle(String wishTitle) {
        this.wishTitle = wishTitle;
    }

    public String getWishDetails() {
        return wishDetails;
    }

    public void setWishDetails(String wishDetails) {
        this.wishDetails = wishDetails;
    }

    public String getWishDesc() {
        return wishDesc;
    }

    public void setWishDesc(String wishDesc) {
        this.wishDesc = wishDesc;
    }

    public String getOperatingOrgName() {
        return operatingOrgName;
    }

    public void setOperatingOrgName(String operatingOrgName) {
        this.operatingOrgName = operatingOrgName;
    }

    public String getTargetOrgName() {
        return targetOrgName;
    }

    public void setTargetOrgName(String targetOrgName) {
        this.targetOrgName = targetOrgName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return wishTitle;
    }
    
}
