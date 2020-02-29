/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author sushr
 */
public class FundsWorkRequest extends WorkRequest {
private ArrayList<Resource> donationList;
private String benefactorName;

    public FundsWorkRequest() {
        donationList=new ArrayList<>();
    }


    public ArrayList<Resource> getDonationList() {
        return donationList;
    }

    public void setDonationList(ArrayList<Resource> donationList) {
        this.donationList = donationList;
    }

    public String getBenefactorName() {
        return benefactorName;
    }

    public void setBenefactorName(String benefactorName) {
        this.benefactorName = benefactorName;
    }
    
}
