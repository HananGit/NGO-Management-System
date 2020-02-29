package userinterface.TargetCompanyAdminRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.TargetAdminOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WishWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hanan
 */
public class WishJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;

    /**
     * Creates new form WishJPanel
     */
    public WishJPanel(JPanel userProcessContainer,Enterprise enterprise,UserAccount account) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.enterprise=enterprise;
        jTextFieldCost.setText("0");
        Date d = new Date();
        jDateChooserRequiredDate.setDate(d);
        jTextFieldCost.setVisible(false);
        Cost.setVisible(false);
    }
       public void resetFields(){          
        jTextFieldWishTitle.setText("");
        jTextFieldCost.setText("");
        textAreaWishDesc.setText("0");
        textAreaWisherDetails.setText("0");
        Date d = new Date();
        jDateChooserRequiredDate.setDate(d);
    }
        
    private boolean validateData()
    {
        if(!(jTextFieldWishTitle.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Wish Title field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        else if(!isNumber(jTextFieldCost.getText().trim())){
           JOptionPane.showMessageDialog(null,"Cost field is non numeric","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
         else if(!(textAreaWishDesc.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Wish Description field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
          else if(!(textAreaWisherDetails.getText().trim().length()>0)){
           JOptionPane.showMessageDialog(null,"Wisher Details field is empty","Warning",JOptionPane.WARNING_MESSAGE);
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

        if(j<i)// we are checking requested date is greater than todays date by 24 hours     
        {
            JOptionPane.showMessageDialog(null, "Requested/Required date should be atleast 24 hours more than todays date");//copy me
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

        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        Cost = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Cost1 = new javax.swing.JLabel();
        jTextFieldCost = new javax.swing.JTextField();
        jDateChooserRequiredDate = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaWisherDetails = new javax.swing.JTextArea();
        jTextFieldWishTitle = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaWishDesc = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bacjJButton = new javax.swing.JButton();

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        Cost.setText("Cost:");
        Cost.setToolTipText("");

        jLabel2.setText("Wish Title:");
        jLabel2.setToolTipText("");

        jLabel4.setText("Required Date");
        jLabel4.setToolTipText("");

        jLabel7.setText("Wish Description:");
        jLabel7.setToolTipText("");

        Cost1.setText("Wisher Details:");
        Cost1.setToolTipText("");

        jTextFieldCost.setToolTipText("");

        jDateChooserRequiredDate.setToolTipText("");

        jScrollPane3.setToolTipText("");

        textAreaWisherDetails.setColumns(20);
        textAreaWisherDetails.setRows(5);
        jScrollPane3.setViewportView(textAreaWisherDetails);

        jTextFieldWishTitle.setToolTipText("");

        jScrollPane4.setToolTipText("");

        textAreaWishDesc.setColumns(20);
        textAreaWishDesc.setRows(5);
        jScrollPane4.setViewportView(textAreaWishDesc);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Make a Wish");
        jLabel9.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jButton1.setText("Submit Wish");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bacjJButton.setText("<< Back");
        bacjJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacjJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldWishTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Cost))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooserRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 309, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bacjJButton)
                        .addGap(280, 280, 280)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Cost1)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bacjJButton))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldWishTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cost)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooserRequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cost1))
                .addGap(112, 112, 112)
                .addComponent(jButton1)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(validateData() && validateDate()){
        WishWorkRequest request = new WishWorkRequest();
        request.setMessage("New wish has been created");
        request.setSender(account);
        request.setStatus("New");
//        request.setOperatingOrgName(jTextFieldOperatingOrg.getText());
//        request.setTargetOrgName(jTextFieldTargetOrg.getText());
        request.setWishTitle(jTextFieldWishTitle.getText());
        
        request.setWishDesc(textAreaWishDesc.getText());
        request.setWishDetails(textAreaWisherDetails.getText());
        Date d = jDateChooserRequiredDate.getDate();
        long m = d.getTime();
        request.setRequiredDate(m);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof TargetAdminOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
            enterprise.getWorkQueue().getWorkRequestList().add(request);
//            System.out.println("Added in both lists");

         JOptionPane.showMessageDialog(null, "Request has been submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
         // bacjJButton.doClick();
         resetFields();
        }
     }
    else
      return;

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bacjJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacjJButtonActionPerformed
                userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TargetCompanyWorkAreaJPanel tcwajp = (TargetCompanyWorkAreaJPanel) component;
        tcwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_bacjJButtonActionPerformed

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
    private javax.swing.JLabel Cost;
    private javax.swing.JLabel Cost1;
    private javax.swing.JButton bacjJButton;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooserRequiredDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldCost;
    private javax.swing.JTextField jTextFieldWishTitle;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextArea textAreaWishDesc;
    private javax.swing.JTextArea textAreaWisherDetails;
    // End of variables declaration//GEN-END:variables
}
