/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BenefactorCompanyAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.EnterpriseRelation;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.WishWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hanan
 */
public class BenefactorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BenefactorWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    EcoSystem business;
    Enterprise enterprise;
    EnterpriseDirectory ed;
//    private ArrayList<String> operatingList;
    private ArrayList<String> targetList;

    public BenefactorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.setSize(1100,800);
        
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.organization = organization;
        this.business = business;
        
        targetList = new ArrayList<>();
        loop:
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().equals(enterprise.getName())) {
                    ed = n.getEnterpriseDirectory();
                    break loop;
                }
            }
        }

        populateTable();
//        findTargetList();
    }
    public void populateSelfTable()
    {
        for(WorkRequest wr:account.getWorkQueue().getWorkRequestList())
        {
            DefaultTableModel dtm = (DefaultTableModel) jTableCompleted.getModel();
            Object[]row= new Object[4];
            dtm.setRowCount(0);
            row[0]=wr;
            
            Date d = new Date(wr.getCreatedDate());
            row[2]=d;
            
            if(wr instanceof DonationWorkRequest)
            {
                row[3]="Donation";
                DonationWorkRequest ewr = (DonationWorkRequest) wr;
                row[1]=ewr.getTitle();
            }
            
            dtm.addRow(row);
        }
    }

    private void findTargetList() {
        for (EnterpriseRelation er : enterprise.getEnterpriseRelationDirectory().getRelationList()) {
//                System.out.println("Relation>>>"+er.getCompanyName());
            for (Enterprise e : ed.getEnterpriseList()) {
//                System.out.println("Checking company"+e.getName());
                if (er.getCompanyName().equals(e.getName())) {
//                    System.out.println("matched"+er.getCompanyName()+" + "+e.getName());
                    for (EnterpriseRelation entrel : e.getEnterpriseRelationDirectory().getRelationList()) {
//                        System.out.println(" showing operating related>>"+entrel.getCompanyName());
                              if (entrel.getCompanyType().equals("TargetCompany")) {
                            targetList.add(entrel.getCompanyName());
//                            System.out.println("ok"+entrel.getCompanyName());
////
                        }
//
                    }
//
                }
            }

        }

//        for(String s:targetList)
//        {
//            System.out.println("inside new arraylist "+s);
//        }
    }
    

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTableWishes.getModel();
        model.setRowCount(0);
        jTableWishes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        System.out.println("In table");
//        if (ngoCompanyComboBox.getSelectedIndex() == 0) {
//            for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
//                if (request instanceof DonationWorkRequest) {
////                    model.setRowCount(0);
//                    Object[] row = new Object[4];
//                    row[0] = request;
//                    row[1] = request.getSender().getEmployee().getName();
////            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//                    long millis = request.getRequiredDate();
//                    Date d = new Date(millis);
//                    row[2] = d;
//                    row[3] = request.getStatus();
//                    model.addRow(row);
//
//                }
//            }
//        }
        if (ngoCompanyComboBox.getSelectedIndex() == 0) {
        //                                model.setRowCount(0);
            findTargetList();
//            System.out.println(""+targetList.size());
            for (String s : targetList) {
                for (Enterprise e : ed.getEnterpriseList()) {
                    if (s.equals(e.getName())) {
                        for (WorkRequest request : e.getWorkQueue().getWorkRequestList()) {
//                            System.out.println(""+request.getStatus());
                            if (request instanceof WishWorkRequest && request.getStatus().equals("Posted")) {

                                Object[] row = new Object[4];
                                row[0] = request;
                                row[1] = request.getSender().getEmployee().getName();
                                long millis = request.getRequiredDate();
                                Date d = new Date(millis);
                                row[2] = d;
                                row[3] = request.getStatus();
                                model.addRow(row);

                            }
                        }

                    }
                }

            }

        }
        
        targetList.clear();
        populateSelfTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWishes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ngoCompanyComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        manageDonationBtn = new javax.swing.JButton();
        jButtonView = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCompleted = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableWishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Sender", "Requested Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableWishes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 180, 634, 198));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Type :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 116, -1, -1));

        ngoCompanyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wishes", "Donations" }));
        ngoCompanyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngoCompanyComboBoxActionPerformed(evt);
            }
        });
        add(ngoCompanyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 113, 231, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Benefactor Company's Admin Screen");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 28, -1, -1));

        manageDonationBtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        manageDonationBtn.setText("Manage Donations");
        manageDonationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDonationBtnActionPerformed(evt);
            }
        });
        add(manageDonationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 600, 263, -1));

        jButtonView.setBackground(new java.awt.Color(255, 255, 255));
        jButtonView.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/View.GIF"))); // NOI18N
        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });
        add(jButtonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, -1, -1));

        jTableCompleted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Title", "Create Date", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableCompleted);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 480, 246));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/View.GIF"))); // NOI18N
        jButton1.setText("View");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/BenefactorCompanyAdminRole/Blue.PNG"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ngoCompanyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngoCompanyComboBoxActionPerformed
        populateTable();
        // TODO add your handling code here:

    }//GEN-LAST:event_ngoCompanyComboBoxActionPerformed

    private void manageDonationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDonationBtnActionPerformed
        ManageDonationsJPanel mdjp = new ManageDonationsJPanel(userProcessContainer, enterprise, account,business);
        userProcessContainer.add("ManageDonationsJPanel", mdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_manageDonationBtnActionPerformed

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
                        int selectedRow=jTableWishes.getSelectedRow();
        if (selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table first to view details","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(ngoCompanyComboBox.getSelectedIndex()==1)
                {
            DonationWorkRequest wr=(DonationWorkRequest)jTableWishes.getValueAt(selectedRow,0);
            ViewDonationJPanel viewDonationJPanel = new ViewDonationJPanel(userProcessContainer,wr,business,enterprise,account);
        userProcessContainer.add("ViewDonationJPanel", viewDonationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else if(ngoCompanyComboBox.getSelectedIndex()==0)
                {
            WishWorkRequest wr=(WishWorkRequest)jTableWishes.getValueAt(selectedRow,0);
            ManageWishesJPanel manageWishesJPanel = new ManageWishesJPanel(userProcessContainer,wr,account);
        userProcessContainer.add("ManageWishesJPanel", manageWishesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCompleted;
    private javax.swing.JTable jTableWishes;
    private javax.swing.JButton manageDonationBtn;
    private javax.swing.JComboBox ngoCompanyComboBox;
    // End of variables declaration//GEN-END:variables
}
