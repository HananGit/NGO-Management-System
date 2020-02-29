/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EventManagerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseRelation;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventWorkRequest;
import Business.emailclass;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sneha
 */
public class AddEventJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
Enterprise enterprise;
UserAccount ua;

    /**
     * Creates new form AddEvent
     */

    public AddEventJPanel(JPanel userProcessContainer, Enterprise enterprise,UserAccount ua) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.setSize(1100,800);
        this.enterprise= enterprise;
        this.ua=ua;
        jTextFieldStartTime.setText("0");
        jTextFieldBudget.setText("0");
        jTextFieldZip.setText("0");
        jTextFieldVolunteersAvailable.setText("0");
        jTextFieldDuration.setText("0");
        Date d = new Date();
        jDateChooserEventDate.setDate(d);
        jDateChooserRequiredDate.setDate(d);
        populateComboBox();
    }
    
    private void populateComboBox()
    {
        jComboBoxAffiliatedCompany.addItem("None");
        for(EnterpriseRelation er:enterprise.getEnterpriseRelationDirectory().getRelationList())
        {
            if(er.getCompanyType().equals("TargetCompany"))
            {
        
                
            }
        
        }
    }

           public void resetFields(){          
        jTextFieldEventName.setText("");
        jTextFieldEventDesc.setText("");
        jTextFieldStartTime.setText("0");
        jTextFieldDuration.setText("0");
        jTextFieldBudget.setText("0");
        jTextFieldVolunteersAvailable.setText("0");
        jTextFieldVolunteersAvailable.setText("0");
        jTextFieldZip.setText("0");
        jTextFieldStreetAdd.setText("");
        jTextFieldCity.setText("");
        Date d = new Date();
        jDateChooserEventDate.setDate(d);
        jDateChooserRequiredDate.setDate(d);
    }
        
    private boolean validateData()
    {
        if(!(jTextFieldEventName.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Event Name field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(!(jTextFieldEventDesc.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Event Description field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(!(jTextFieldStartTime.getText().trim().length() > 2)|| !isNumber(jTextFieldStartTime.getText().trim()) || Integer.parseInt(jTextFieldStartTime.getText())<=0){
           JOptionPane.showMessageDialog(null,"Start Time field should be greater than 2 digits and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
           else if(!(jTextFieldDuration.getText().trim().length() > 0)|| !isNumber(jTextFieldDuration.getText().trim())|| Integer.parseInt(jTextFieldDuration.getText())<=0){
           JOptionPane.showMessageDialog(null,"Duration field should be greater than zero and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
          else if(!(jTextFieldBudget.getText().trim().length()>0)||!isNumber(jTextFieldBudget.getText().trim())|| Integer.parseInt(jTextFieldBudget.getText())<=0){
           JOptionPane.showMessageDialog(null,"Estimated Budget field should be greater than zero and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
           else if(!(jTextFieldStreetAdd.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Street Address field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
            else if(!(jTextFieldZip.getText().trim().length()>4)||!isNumber(jTextFieldZip.getText().trim())|| Integer.parseInt(jTextFieldZip.getText())<=0){
           JOptionPane.showMessageDialog(null,"Zip Code field should be greater than 4 digits and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
          return true;  
        }
        
    }
    private boolean validateDate()
    {
        Date date=new Date();//copy me
        long i = date.getTime()+86400000;//this gets todays date and adds 24 hours in it     copy me
        Date reqdDate = jDateChooserRequiredDate.getDate();//copy me
        long j = reqdDate.getTime();//copy me
        Date eventDate = jDateChooserEventDate.getDate();
        long k = eventDate.getTime();
        if(j<i)// we are checking requested date is greater than todays date by 24 hours     copy me
        {
            JOptionPane.showMessageDialog(null, "Requested/Required date should be atleast 48 hours more than todays date");//copy me
            return false;
        }
        else if(k<j+86400000)
        {
              JOptionPane.showMessageDialog(null, "Event date should be atleast 48 hours more than Requested/Required date");
              return false;
        }
        else
        {
            return true;
        }
                
        
        
        
    }
  /*  private void checkVolunteers()
    {
        validateDate();
        int count=0;
        if(jDateChooserEventDate.getDate().equals("null"))
        {
            JOptionPane.showMessageDialog(null, "Please select date");
            return;
        }
        else{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = jDateChooserEventDate.getDate();
        String b=sdf.format(d);
        for(Organization o:enterprise.getOrganizationDirectory().getOrganizationList())
        {
//            EventWorkRequest ewr = (EventWorkRequest) wr; 
//            Date date2=wr.get
            if(o instanceof VolunteerOrganization)
            {
                for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList())
                {
                    for(String s:ua.getEventDatesList())
                    {
                        if(!(s.equals(b)))
                        {
                            count++;
                        }
                    }
                    
                }
                
            }
        }
        
        }
        
        
     jTextFieldVolunteersAvailable.setText(String.valueOf(count));   
    }*/
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEventName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldEventDesc = new javax.swing.JTextField();
        jTextFieldStartTime = new javax.swing.JTextField();
        jTextFieldDuration = new javax.swing.JTextField();
        jTextFieldBudget = new javax.swing.JTextField();
        jTextFieldVolunteersAvailable = new javax.swing.JTextField();
        jTextFieldStreetAdd = new javax.swing.JTextField();
        jTextFieldCity = new javax.swing.JTextField();
        jTextFieldZip = new javax.swing.JTextField();
        jTextFieldState = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();
        bacjJButton = new javax.swing.JButton();
        jDateChooserEventDate = new com.toedter.calendar.JDateChooser();
        jDateChooserRequiredDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxAffiliatedCompany = new javax.swing.JComboBox<>();
        jTextFieldVolunteers1 = new javax.swing.JTextField();
        jTextFieldVolunteers2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add New Event");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 11, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Event Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 96, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Event Description :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 153, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Time :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 212, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Duration :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 280, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Location :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 478, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estimated Budget :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 347, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Volunteers Available :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, -1));
        add(jTextFieldEventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 93, 299, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Street Address:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 530, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("City :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 585, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Zip Code :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 585, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("State :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 585, -1, -1));

        jTextFieldEventDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEventDescActionPerformed(evt);
            }
        });
        add(jTextFieldEventDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 150, 299, -1));
        add(jTextFieldStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 209, 299, -1));
        add(jTextFieldDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 277, 299, -1));
        add(jTextFieldBudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 344, 299, -1));
        add(jTextFieldVolunteersAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 299, -1));
        add(jTextFieldStreetAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 527, 863, -1));
        add(jTextFieldCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 582, 441, -1));
        add(jTextFieldZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 582, 114, -1));
        add(jTextFieldState, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 582, 200, -1));

        submitJButton.setBackground(new java.awt.Color(255, 255, 255));
        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, -1, 71));

        bacjJButton.setBackground(new java.awt.Color(255, 255, 255));
        bacjJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        bacjJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        bacjJButton.setText("Back");
        bacjJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacjJButtonActionPerformed(evt);
            }
        });
        add(bacjJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 16, -1, -1));
        add(jDateChooserEventDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 93, -1, -1));
        add(jDateChooserRequiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 150, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Required Date:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Event Date:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Affiliated Company:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 212, -1, -1));

        jComboBoxAffiliatedCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAffiliatedCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAffiliatedCompanyActionPerformed(evt);
            }
        });
        add(jComboBoxAffiliatedCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 209, 181, -1));
        add(jTextFieldVolunteers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 411, 299, -1));
        add(jTextFieldVolunteers2, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 411, 299, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Volunteers Required :");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 414, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/EventManagerRole/Orange.PNG"))); // NOI18N
        jLabel16.setText("jLabel16");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEventDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEventDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEventDescActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
      if(validateData() && validateDate()){
        EventWorkRequest request = new EventWorkRequest();
        request.setMessage("New event has been created");
        request.setSender(ua);
        request.setStatus("Proposed");
        request.setEventName(jTextFieldEventName.getText());
        request.setEventDesc(jTextFieldEventDesc.getText());
        request.setStartTime(Integer.parseInt(jTextFieldStartTime.getText()));
        request.setDuration(Integer.parseInt(jTextFieldDuration.getText()));
        request.setBudget(Integer.parseInt(jTextFieldBudget.getText()));
        request.setVolunteers(Integer.parseInt(jTextFieldVolunteersAvailable.getText()));
        request.setStreetAdd(jTextFieldStreetAdd.getText());
        request.setCity(jTextFieldCity.getText());
        request.setZip(Integer.parseInt(jTextFieldZip.getText()));
        request.setState(jTextFieldState.getText());
        Date d = jDateChooserEventDate.getDate();
        long m = d.getTime();
        request.setEventDate(m);
        d=jDateChooserRequiredDate.getDate();
        m = d.getTime();
        request.setRequiredDate(m);
        request.setChanged(false);
//        System.out.println(""+m);
//        System.out.println(""+request);
        
        
//        Organization org = null;
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof EventManagementOrganization){
//                org = organization;
//                break;
//            }
//        }
//        if (org!=null){
//            org.getWorkQueue().getWorkRequestList().add(request);
            ua.getWorkQueue().getWorkRequestList().add(request);
            enterprise.getWorkQueue().getWorkRequestList().add(request);
//            System.out.println("Added in both lists");
//        }


String sendTo=null;
        int count=0;
        
                    for (Organization o:enterprise.getOrganizationDirectory().getOrganizationList()) {
                        {
                            if(o instanceof FinanceOrganization)
                            {
                                count=0;
                                for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList())
                                {
                                    if(count==0){
                                    sendTo=ua.getEmail();
                                    count++;
                                    }
                                    else
                                    {
                                        String temp=sendTo+" ,"+ua.getEmail();
                                        sendTo=temp;
                                    }
                                }
                                
                            }
                            
                        }
             
        }

                    //*************** email code ***********
                                try{
            emailclass.generateAndSendEmailEvent(sendTo,request);
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }

        JOptionPane.showMessageDialog(null, "Request has been created");
        //bacjJButton.doClick();
        resetFields();
      }
      else
          return;
        // TODO add your handling code here:
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void bacjJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacjJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        EventManagerWorkAreaJPanel emwajp = (EventManagerWorkAreaJPanel) component;
        emwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_bacjJButtonActionPerformed

    private void jComboBoxAffiliatedCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAffiliatedCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAffiliatedCompanyActionPerformed
        private boolean isNumber(String str) {
        int num;
        try{
            num = Integer.parseInt(str);
            
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bacjJButton;
    private javax.swing.JComboBox<String> jComboBoxAffiliatedCompany;
    private com.toedter.calendar.JDateChooser jDateChooserEventDate;
    private com.toedter.calendar.JDateChooser jDateChooserRequiredDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldBudget;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldDuration;
    private javax.swing.JTextField jTextFieldEventDesc;
    private javax.swing.JTextField jTextFieldEventName;
    private javax.swing.JTextField jTextFieldStartTime;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStreetAdd;
    private javax.swing.JTextField jTextFieldVolunteers1;
    private javax.swing.JTextField jTextFieldVolunteers2;
    private javax.swing.JTextField jTextFieldVolunteersAvailable;
    private javax.swing.JTextField jTextFieldZip;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
