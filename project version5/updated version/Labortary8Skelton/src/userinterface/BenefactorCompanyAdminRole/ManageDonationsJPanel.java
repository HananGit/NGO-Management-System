/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BenefactorCompanyAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseRelation;
import Business.Network.Network;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.Resource;
import Business.emailclass;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hanan
 */
public class ManageDonationsJPanel extends javax.swing.JPanel {

    UserAccount account;
    Enterprise enterprise;
    JPanel userProcessContainer;
    EcoSystem business;
    private ArrayList<Resource> resourceList;

    /**
     * Creates new form ManageDonationsJPanel
     */
    public ManageDonationsJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, EcoSystem business) {
        initComponents();
        this.setSize(1100,800);
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.resourceList = new ArrayList<Resource>();
        this.enterprise = enterprise;
        populateResourceTable();
        populateComboBox();
        populateNGO();

    }

    private void populateNGO() {
        jComboBoxNGO.removeAllItems();

        for (EnterpriseRelation er : enterprise.getEnterpriseRelationDirectory().getRelationList()) {
            jComboBoxNGO.addItem(er.getCompanyName());
        }

    }

    private void populateTable() {

    }

    private void populateResourceTable() {
        DefaultTableModel dtm = (DefaultTableModel) jTableResources.getModel();
        dtm.setRowCount(0);
        jTableResources.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (Resource r : resourceList) {
            Object[] row = new Object[2];
            row[0] = r;
            row[1] = r.getQuantity();
            dtm.addRow(row);
        }

    }

    private void populateComboBox() {
        jComboBoxDonationType.removeAllItems();

        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().equals(jComboBoxNGO.getSelectedItem())) {
                    for (String s : e.getDonationType()) {
                        jComboBoxDonationType.addItem(s);
                    }
                }
            }
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

        backBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxDonationType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNewType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAddDonation = new javax.swing.JButton();
        jTextFieldDonationName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResources = new javax.swing.JTable();
        jButtonAddNewType = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxNGO = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 32, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage Donations Screen");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 33, -1, -1));
        add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 140, -1));

        jButtonSubmit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/save.GIF"))); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });
        add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 730, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Donation Name * :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Donation Type :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        jComboBoxDonationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDonationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDonationTypeActionPerformed(evt);
            }
        });
        add(jComboBoxDonationType, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 230, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Company Name", "Donation Type", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 753, 199));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Amount :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, -1, -1));
        add(jTextFieldNewType, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 280, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Type :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jButtonAddDonation.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddDonation.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonAddDonation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        jButtonAddDonation.setText("Add");
        jButtonAddDonation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDonationActionPerformed(evt);
            }
        });
        add(jButtonAddDonation, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, -1, -1));
        add(jTextFieldDonationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 200, -1));

        jTableResources.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Resource", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableResources);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 650, 177));

        jButtonAddNewType.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddNewType.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonAddNewType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        jButtonAddNewType.setText("Add");
        jButtonAddNewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewTypeActionPerformed(evt);
            }
        });
        add(jButtonAddNewType, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Delete.GIF"))); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Donating to :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

        jComboBoxNGO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNGOActionPerformed(evt);
            }
        });
        add(jComboBoxNGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 350, 200, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/BenefactorCompanyAdminRole/Blue.PNG"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        BenefactorWorkAreaJPanel emwajp = (BenefactorWorkAreaJPanel) component;
        emwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        String sendTo=null;
        if(jTextFieldDonationName.getText().equals(null) || resourceList.size()==0 || jComboBoxNGO.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Donation Name and company name is compulsory and atleast one resource should be added to list");
                    
        }
        else{
        DonationWorkRequest dwr = new DonationWorkRequest();
        dwr.setTitle(jTextFieldDonationName.getText());
        dwr.setSender(account);
        dwr.setStatus("New");
        dwr.setMessage("New Donation has been created");
        dwr.setEnterpriseName(enterprise.getName());
        dwr.setNgoName((String)jComboBoxNGO.getSelectedItem());
        ArrayList<Resource> res=dwr.getResourceList();
        for(int i = 0;i<resourceList.size();i++)
        {
            res.add(i,resourceList.get(i));
        }
        resourceList.clear();
        
        
        int count=0;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().equals(jComboBoxNGO.getSelectedItem())) {
                    for (Organization o:e.getOrganizationDirectory().getOrganizationList()) {
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
                }
            }
        }
        
////      ****************************************** Email code ***************************
            try{
            emailclass.generateAndSendEmailDonation(sendTo,dwr);
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }
        enterprise.getWorkQueue().getWorkRequestList().add(dwr);
        account.getWorkQueue().getWorkRequestList().add(dwr);
        JOptionPane.showMessageDialog(null, "Request has been submitted");
        backBtn.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jComboBoxNGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNGOActionPerformed
        populateComboBox();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNGOActionPerformed

    private void jButtonAddNewTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewTypeActionPerformed
        if(jTextFieldNewType.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "New type can't be null");
        }
        else{
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().equals(jComboBoxNGO.getSelectedItem())) {
                    for(String s:e.getDonationType()){
                        if(s.equals(jTextFieldNewType.getText()))
                        {
                            JOptionPane.showMessageDialog(null, "Already exists");
                            return;
                            
                        }
                        
                    }
                    e.getDonationType().add(jTextFieldNewType.getText());
                    populateComboBox();
                }
            }
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddNewTypeActionPerformed

    private void jButtonAddDonationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDonationActionPerformed
        boolean flag=true;
        if(!(Integer.parseInt(jTextFieldAmount.getText())>0))
        {
            JOptionPane.showMessageDialog(null, "Quantity should be more than 0");
        }
        else{
            for(Resource r:resourceList)
            {
                flag=true;
                if(r.getResourceName().equals((String)jComboBoxDonationType.getSelectedItem()))
                {
//                    System.out.println("inside if");
                    flag=false;
                    int a=r.getQuantity();
                    int b=Integer.parseInt(jTextFieldAmount.getText());
                    r.setQuantity(a+b);
                    populateResourceTable();
                    
                }
            }
            if(flag){
        Resource resource = new Resource();
        resource.setResourceName((String)jComboBoxDonationType.getSelectedItem());
        resource.setQuantity(Integer.parseInt(jTextFieldAmount.getText()));
        resourceList.add(resource); 
        populateResourceTable();}
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddDonationActionPerformed

    private void jComboBoxDonationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDonationTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDonationTypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedrow = jTableResources.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Resource r = (Resource) jTableResources.getValueAt(selectedrow, 0);
            resourceList.remove(r);
            populateResourceTable();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddDonation;
    private javax.swing.JButton jButtonAddNewType;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBoxDonationType;
    private javax.swing.JComboBox<String> jComboBoxNGO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableResources;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldDonationName;
    private javax.swing.JTextField jTextFieldNewType;
    // End of variables declaration//GEN-END:variables
}
