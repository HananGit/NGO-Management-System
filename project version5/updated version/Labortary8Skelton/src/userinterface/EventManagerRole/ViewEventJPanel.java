/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EventManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseRelation;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sneha
 */
public class ViewEventJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    UserAccount ua;
    EventWorkRequest wr;
    EcoSystem business;
    Enterprise enterprise;
    /**
     * Creates new form ViewEvents
     */
    public ViewEventJPanel(JPanel userProcessContainer, EventWorkRequest wr,UserAccount ua,EcoSystem business,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.setSize(1100,800);
        this.wr=wr;
        this.ua=ua;
    this.enterprise=enterprise;    
        enableFields();
        setValues();
        disableFields();
        saveJButton.setEnabled(false);
             
        jTextAreaMessage.setEnabled(true);
        jTextAreaMessage.setText(wr.getMessage());
        jTextAreaMessage.setEnabled(false);
        
    }

   
    private void disableFields()
    {
        jTextFieldEventName.setEnabled(false);
        jTextFieldEventDesc.setEnabled(false);
        jTextFieldStartTime.setEnabled(false);
        jTextFieldDuration.setEnabled(false);
        jTextFieldBudget.setEnabled(false);
        jTextFieldVolunteers.setEnabled(false);
        jTextFieldStreetAdd.setEnabled(false);
        jTextFieldCity.setEnabled(false);
        jTextFieldZip.setEnabled(false);
        jTextFieldState.setEnabled(false);
        jDateChooserEventDate.setEnabled(false);
        jDateChooserRequiredDate.setEnabled(false);
        jComboBoxAffiliatedCompany.setEnabled(false);
        
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
    private void setValues()
    {
        jTextFieldEventName.setText(wr.getEventName());
        jTextFieldEventDesc.setText(wr.getEventDesc());
        jTextFieldStartTime.setText(String.valueOf(wr.getStartTime()));
        jTextFieldDuration.setText(String.valueOf(wr.getDuration()));
        jTextFieldBudget.setText(String.valueOf(wr.getBudget()));
        jTextFieldVolunteers.setText(String.valueOf(wr.getVolunteers()));
        jTextFieldStreetAdd.setText(wr.getStreetAdd());
        jTextFieldCity.setText(wr.getCity());
        jTextFieldZip.setText(String.valueOf(wr.getZip()));
        jTextFieldState.setText(wr.getState());
        long millis = wr.getEventDate();
        Date d = new Date(millis);
        jDateChooserEventDate.setDate(d);
        millis = wr.getRequiredDate();
        d = new Date(millis);
        jDateChooserRequiredDate.setDate(d);
        jComboBoxAffiliatedCompany.setSelectedItem(wr.getAffiliatedCompany());
        
        
        
    }
    private void enableFields()
    {
        jTextFieldEventName.setEnabled(true);
        jTextFieldEventDesc.setEnabled(true);
        jTextFieldStartTime.setEnabled(true);
        jTextFieldDuration.setEnabled(true);
        jTextFieldBudget.setEnabled(true);
        jTextFieldVolunteers.setEnabled(true);
        jTextFieldStreetAdd.setEnabled(true);
        jTextFieldCity.setEnabled(true);
        jTextFieldZip.setEnabled(true);
        jTextFieldState.setEnabled(true);
        jDateChooserEventDate.setEnabled(true);
        jDateChooserRequiredDate.setEnabled(true);
jComboBoxAffiliatedCompany.setEnabled(true);
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
        else if(!(jTextFieldStartTime.getText().trim().length() > 2)||!isNumber(jTextFieldStartTime.getText().trim())|| Integer.parseInt(jTextFieldStartTime.getText())<=0){
           JOptionPane.showMessageDialog(null,"Start Time field should be greater than 2 digits and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
           else if(!(jTextFieldDuration.getText().trim().length() > 0)||!isNumber(jTextFieldDuration.getText().trim())|| Integer.parseInt(jTextFieldDuration.getText())<=0){
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
            else if(!(jTextFieldZip.getText().trim().length() > 4)||!isNumber(jTextFieldZip.getText().trim())|| Integer.parseInt(jTextFieldZip.getText())<=0){
           JOptionPane.showMessageDialog(null,"Zip Code field should be greater than 4 digits and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
          return true;  
        }
        
    }
    private boolean validateDate()
    {
        Date date=new Date();
        long i = date.getTime()+86400000;//this gets todays date and adds 24 hours in it     
        Date reqdDate = jDateChooserRequiredDate.getDate();
        long j = reqdDate.getTime();
        Date eventDate = jDateChooserEventDate.getDate();
        long k = eventDate.getTime();
        if(j<i)// we are checking requested date is greater than todays date by 24 hours     
        {
            JOptionPane.showMessageDialog(null, "Requested/Required date should be atleast 48 hours more than todays date");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        updateJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldEventDesc = new javax.swing.JTextField();
        jTextFieldStartTime = new javax.swing.JTextField();
        jTextFieldDuration = new javax.swing.JTextField();
        jTextFieldBudget = new javax.swing.JTextField();
        jTextFieldVolunteers = new javax.swing.JTextField();
        jTextFieldStreetAdd = new javax.swing.JTextField();
        jTextFieldCity = new javax.swing.JTextField();
        jTextFieldZip = new javax.swing.JTextField();
        jTextFieldState = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserEventDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserRequiredDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEventName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxAffiliatedCompany = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveJButton.setBackground(new java.awt.Color(255, 255, 255));
        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        saveJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/save.GIF"))); // NOI18N
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 623, 160, 60));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 12, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View/Modify Event");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 11, -1, -1));

        updateJButton.setBackground(new java.awt.Color(255, 255, 255));
        updateJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        updateJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/edit.GIF"))); // NOI18N
        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 623, 188, 54));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Street Address:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 514, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("City :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 569, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Zip Code :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 569, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("State :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 569, -1, -1));

        jTextFieldEventDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEventDescActionPerformed(evt);
            }
        });
        add(jTextFieldEventDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 134, 302, -1));
        add(jTextFieldStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 193, 299, -1));
        add(jTextFieldDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 261, 299, -1));
        add(jTextFieldBudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 328, 299, -1));
        add(jTextFieldVolunteers, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 395, 302, -1));
        add(jTextFieldStreetAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 511, 839, -1));
        add(jTextFieldCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 566, 367, -1));
        add(jTextFieldZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 566, 114, -1));
        add(jTextFieldState, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 566, 200, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Event Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 80, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Event Description :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 137, -1, -1));
        add(jDateChooserEventDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 77, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Time :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 196, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Duration :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 264, -1, -1));
        add(jDateChooserRequiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 134, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Required Date");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 137, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Location :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 462, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Event Date");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 80, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estimated Budget :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 331, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Volunteers Required :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 398, -1, -1));
        add(jTextFieldEventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 77, 302, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Remarks");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 196, -1, -1));

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jScrollPane3.setViewportView(jTextAreaMessage);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 193, -1, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Affiliated Company:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        jComboBoxAffiliatedCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAffiliatedCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAffiliatedCompanyActionPerformed(evt);
            }
        });
        add(jComboBoxAffiliatedCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 330, 170, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/EventManagerRole/Orange.PNG"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -60, 1100, 860));
    }// </editor-fold>//GEN-END:initComponents

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        if(validateData() && validateDate()){
        wr.setMessage("Event has been modified");
        wr.setSender(ua);
        wr.setStatus("Proposed");
        wr.setEventName(jTextFieldEventName.getText());
        wr.setEventDesc(jTextFieldEventDesc.getText());
        wr.setStartTime(Integer.parseInt(jTextFieldStartTime.getText()));
        wr.setDuration(Integer.parseInt(jTextFieldDuration.getText()));
        wr.setBudget(Integer.parseInt(jTextFieldBudget.getText()));
        wr.setVolunteers(Integer.parseInt(jTextFieldVolunteers.getText()));
        wr.setStreetAdd(jTextFieldStreetAdd.getText());
        wr.setCity(jTextFieldCity.getText());
        wr.setZip(Integer.parseInt(jTextFieldZip.getText()));
        wr.setState(jTextFieldState.getText());
        Date d = jDateChooserEventDate.getDate();
        long m = d.getTime();
        wr.setEventDate(m);
        d=jDateChooserRequiredDate.getDate();
        m = d.getTime();
        wr.setRequiredDate(m);    
        wr.setChanged(true);
        disableFields();
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Record successfuly modified","Message",JOptionPane.INFORMATION_MESSAGE);
        // TODO add your handling code here:
        }
        else
            return;
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        EventManagerWorkAreaJPanel emwajp = (EventManagerWorkAreaJPanel) component;
        emwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jTextFieldEventDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEventDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEventDescActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        enableFields();
        updateJButton.setEnabled(false);
        saveJButton.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_updateJButtonActionPerformed

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
    private javax.swing.JButton backJButton;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField jTextFieldBudget;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldDuration;
    private javax.swing.JTextField jTextFieldEventDesc;
    private javax.swing.JTextField jTextFieldEventName;
    private javax.swing.JTextField jTextFieldStartTime;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStreetAdd;
    private javax.swing.JTextField jTextFieldVolunteers;
    private javax.swing.JTextField jTextFieldZip;
    private javax.swing.JButton saveJButton;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}
