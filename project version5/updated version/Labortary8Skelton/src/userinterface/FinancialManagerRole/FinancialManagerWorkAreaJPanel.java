/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FinancialManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.EnterpriseRelation;
import Business.Network.Network;
import Business.Organization.HumanResourceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.EventWorkRequest;
import Business.WorkQueue.FundsWorkRequest;
import Business.WorkQueue.Resource;
import Business.WorkQueue.ResourcesWorkRequest;
import Business.WorkQueue.WishWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.emailclass;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author h
 */
public class FinancialManagerWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    /**
     * Creates new form FinancialManagerWorkAreaJPanel
     */
    UserAccount account;
    Organization organization;
    EcoSystem business;
    Enterprise enterprise;
    private EnterpriseDirectory enterpriseDirectory;

    public FinancialManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.setSize(1100,800);
        this.account = account;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
//        remarksTextArea.setVisible(false);
//       jLabel6.setVisible(false);

        loop:
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.equals(enterprise)) {
                    enterpriseDirectory = n.getEnterpriseDirectory();
                    break loop;

                }

            }

        }

        populateTable();
        jCalendar1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                Date d = jCalendar1.getDate();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String a = dateFormat.format(d);
                for (EventWorkRequest ewr : enterprise.getEventList()) {
                    Date d1 = new Date(ewr.getEventDate());
                    String b = dateFormat.format(d1);
                    if (a.equals(b)) {
                        StringBuilder sb = new StringBuilder(512);
                        sb.append("<html><table><tr><td>Event Name</td><td>Event Description</td><td>Event Location</td></tr>");
                        sb.append("<tr>");
                        sb.append("<td>").append(ewr.getEventName()).append("</td>");
                        sb.append("<td>").append(ewr.getEventDesc()).append("</td>");
                        sb.append("<td>").append(ewr.getStreetAdd()).append("</td>");
                        sb.append("</tr></table></html>");

                        JOptionPane.showMessageDialog(null, sb);
//                JOptionPane.showMessageDialog(null, "ok");
                        sb.setLength(0);
                    }
                }
            }
        });

    }

    public void populateSelfTable() {
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {
            DefaultTableModel dtm = (DefaultTableModel) jTableCompleted.getModel();
            Object[] row = new Object[4];
            dtm.setRowCount(0);
            row[0] = wr;

            Date d = new Date(wr.getCreatedDate());
            row[2] = d;
            if (wr instanceof DonationWorkRequest) {
                row[3] = "Donation";
                DonationWorkRequest dwr = (DonationWorkRequest) wr;
                row[1] = dwr.getTitle();

            }
            if (wr instanceof EventWorkRequest) {
                row[3] = "Event";
                EventWorkRequest ewr = (EventWorkRequest) wr;
                row[1] = ewr.getEventName();
            }
            if (wr instanceof ResourcesWorkRequest) {
                row[3] = "Target Resources";
                ResourcesWorkRequest rwr = (ResourcesWorkRequest) wr;
                row[1] = rwr.getTitle();
            }
            dtm.addRow(row);
        }
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) eventsTbl.getModel();
        dtm.setRowCount(0);
        eventsTbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (typeComboBox.getSelectedItem().equals("Wish")) {
            approveBtn.setVisible(false);
            rejectBtn.setVisible(false);
            Object[] row = new Object[4];
            for (EnterpriseRelation er : enterprise.getEnterpriseRelationDirectory().getRelationList()) {

                for (Enterprise e : enterpriseDirectory.getEnterpriseList()) {
                    if (e.getName().equals(er.getCompanyName())) {
                        for (WorkRequest request : e.getWorkQueue().getWorkRequestList()) {

                            if (request instanceof WishWorkRequest && (request.getStatus().equals("New"))) {
                                row[0] = request;
                                row[1] = request.getStatus();
                                row[2] = request.getSender().getEmployee().getName();
                                long millis = request.getRequiredDate();
                                Date d = new Date(millis);
                                row[3] = d;
                                dtm.addRow(row);
                            }
                        }

                    }

                }
            }
        } else if (typeComboBox.getSelectedItem().equals("Event")) {
            approveBtn.setVisible(true);
            rejectBtn.setVisible(true);
//            DefaultTableModel dtm = (DefaultTableModel) eventsTbl.getModel();
//            dtm.setRowCount(0);
            Object[] row = new Object[4];
            for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
                if (request instanceof EventWorkRequest && request.getStatus().equals("Proposed")) {
                    row[0] = request;
                    row[1] = request.getStatus();
                    row[2] = request.getSender().getEmployee().getName();
                    long millis = request.getRequiredDate();
                    Date d = new Date(millis);
                    row[3] = d;
                    dtm.addRow(row);
                    remarksTextArea.setText("");
                }
            }

        } else if (typeComboBox.getSelectedItem().equals("Donation")) {

            approveBtn.setVisible(true);
            rejectBtn.setVisible(true);
//            DefaultTableModel dtm = (DefaultTableModel) eventsTbl.getModel();
//            dtm.setRowCount(0);
            Object[] row = new Object[4];

            for (EnterpriseRelation er : enterprise.getEnterpriseRelationDirectory().getRelationList()) {
                System.out.println("" + er.getCompanyType());
                for (Network n : business.getNetworkList()) {
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {

                        if (e.getName().equals(er.getCompanyName()) && er.getCompanyType().equals("BenefactorCompany")) {
                            for (WorkRequest request : e.getWorkQueue().getWorkRequestList()) {
                                System.out.println("" + request.getMessage());
                                if (request instanceof DonationWorkRequest && request.getStatus().equals("New")) {
                                    row[0] = request;
                                    row[1] = request.getStatus();
                                    row[2] = request.getSender().getEmployee().getName();
                                    long millis = request.getRequiredDate();
                                    Date d = new Date(millis);
                                    row[3] = d;
                                    dtm.addRow(row);
                                    remarksTextArea.setText("");
                                }
                            }
                        }
                    }
                }
            }
        } else if (typeComboBox.getSelectedItem().equals("Target Resources")) {
            approveBtn.setVisible(true);
            rejectBtn.setVisible(true);
            Object[] row = new Object[4];
            for (EnterpriseRelation er : enterprise.getEnterpriseRelationDirectory().getRelationList()) {
//                System.out.println(""+er.getCompanyName());
                for (Enterprise e : enterpriseDirectory.getEnterpriseList()) {
                    if (e.getName().equals(er.getCompanyName())) {
                        for (WorkRequest request : e.getWorkQueue().getWorkRequestList()) {
//                            System.out.println(""+request.getStatus()+""+request.getSender());
                            if (request instanceof ResourcesWorkRequest && request.getStatus().equals("Requested")) {
//                    System.out.println("inside the last if");
                                row[0] = request;
                                row[1] = request.getStatus();
                                row[2] = request.getSender().getEmployee().getName();
                                long millis = request.getRequiredDate();
                                Date d = new Date(millis);
                                row[3] = d;
                                dtm.addRow(row);
                            }
                        }
                    }

                }
            }

        }
        remarksTextArea.setText("");
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        availableBudgetBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        viewDetailsBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        approveBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCompleted = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 270, 210));

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Remarks:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, -1, -1));

        availableBudgetBtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        availableBudgetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/View.GIF"))); // NOI18N
        availableBudgetBtn.setText("Check Available Budget ");
        availableBudgetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableBudgetBtnActionPerformed(evt);
            }
        });
        jPanel2.add(availableBudgetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        eventsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Status", "Sender", "Required Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(eventsTbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 634, 198));

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 230, 114));

        viewDetailsBtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        viewDetailsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/View.GIF"))); // NOI18N
        viewDetailsBtn.setText("View Details");
        viewDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsBtnActionPerformed(evt);
            }
        });
        jPanel2.add(viewDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 710, -1, -1));

        rejectBtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        rejectBtn.setText("Reject");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });
        jPanel2.add(rejectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        approveBtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });
        jPanel2.add(approveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Finance Manager Work Area");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 36, -1, -1));

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Wish", "Event", "Target Resources", "Donation" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(typeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 160, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Status:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 570, 650, 270));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Purple.PNG"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSplitPane1.setRightComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void availableBudgetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableBudgetBtnActionPerformed
        // TODO add your handling code here:
        BudgetJPanel panel = new BudgetJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("BudgetJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_availableBudgetBtnActionPerformed

    private void viewDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsBtnActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRow = eventsTbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (typeComboBox.getSelectedItem().equals("Event")) {
            EventWorkRequest wr = (EventWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
            ViewEventJPanelF viewEventJPanel = new ViewEventJPanelF(userProcessContainer, wr, account);
            userProcessContainer.add("ViewEventJPanelF", viewEventJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (typeComboBox.getSelectedItem().equals("Wish")) {
            WishWorkRequest wr = (WishWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
            ViewWishJPanelF viewWishJPanel = new ViewWishJPanelF(userProcessContainer, wr, account);
            userProcessContainer.add("ViewWishJPanelF", viewWishJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (typeComboBox.getSelectedItem().equals("Donation")) {
            DonationWorkRequest wr = (DonationWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
            ViewDonationJPanelF viewDonationJPanelF = new ViewDonationJPanelF(userProcessContainer, wr);
            userProcessContainer.add("ViewDonationJPanelF", viewDonationJPanelF);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (typeComboBox.getSelectedItem().equals("Target Resources")) {
            ResourcesWorkRequest wr = (ResourcesWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
            ViewRequestedResourcesF viewRequestedResources = new ViewRequestedResourcesF(userProcessContainer, wr, account);
            userProcessContainer.add("View Requested Resources", viewRequestedResources);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewDetailsBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        if (remarksTextArea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please write remarks for rejection");
        } else {
            int selectedRow = eventsTbl.getSelectedRow();
            if (selectedRow >= 0) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to Reject? ", "message", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
//                    remarksTextArea.setVisible(true);
//                    jLabel6.setVisible(true);
                    if (typeComboBox.getSelectedIndex() == 1) {
                        EventWorkRequest ewr = (EventWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
                        ewr.setSender(account);
                        ewr.setMessage(remarksTextArea.getText());
                        ewr.setStatus("Rejected");

                        populateTable();
                        remarksTextArea.setText("");
                    } else if (typeComboBox.getSelectedIndex() == 2) {
                        ResourcesWorkRequest ewr = (ResourcesWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
                        ewr.setSender(account);
                        ewr.setMessage(remarksTextArea.getText());
                        ewr.setStatus("Rejected");

                        populateTable();
                        remarksTextArea.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed

        int selectedRow = eventsTbl.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "would you like to approve this request?", "message", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (typeComboBox.getSelectedIndex() == 1) {
                    EventWorkRequest ewr = (EventWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
                    String sendTo = ewr.getSender().getEmail();
                    ewr.setMessage("Event has been approved by the finance department");
                    ewr.setStatus("Approved");
                    
                    for(Organization o: enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        if(o instanceof HumanResourceOrganization)
                        {
                            for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList())
                            {
                                String temp = sendTo+" ,"+ua.getEmail();
                                sendTo=temp;
                            }
                        }
                    }
                    
                        
                    
//**************************** email code **************
                    try{
            emailclass.generateAndSendEmailEvent(sendTo,ewr);
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }
                    
                    ewr.setSender(account);
                    
                    account.getWorkQueue().getWorkRequestList().add(ewr);
                    populateSelfTable();
                    populateTable();
                } else if (typeComboBox.getSelectedIndex() == 2) {

                    ResourcesWorkRequest ewr = (ResourcesWorkRequest) eventsTbl.getValueAt(selectedRow, 0);

                    String sendTo = ewr.getSender().getEmail();

                    ewr.setMessage("Resources has been approved by the finance department");
                    ewr.setStatus("Approved");
                    
                    try{
            emailclass.generateAndSendEmailTargetResources(sendTo,ewr);
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }
                    ewr.setSender(account);
                    
                    account.getWorkQueue().getWorkRequestList().add(ewr);
                    populateSelfTable();
                    populateTable();

                } else if (typeComboBox.getSelectedIndex() == 3) {

                    DonationWorkRequest ewr = (DonationWorkRequest) eventsTbl.getValueAt(selectedRow, 0);
                    
                    
                    String sendTo = ewr.getSender().getEmail();
                    ewr.setMessage("Donation has been approved by the finance department");
                    ewr.setStatus("Approved");

                    //      ****************************************** Email code ***************************
            try{
            emailclass.generateAndSendEmailDonation(sendTo,ewr);
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }

                    
                    
                    
                    ewr.setSender(account);
                    
                    FundsWorkRequest fwr = new FundsWorkRequest();
                    enterprise.getWorkQueue().getWorkRequestList().add(fwr);
                    fwr.setBenefactorName(ewr.getEnterpriseName());
                    for (Resource r : ewr.getResourceList()) {
                        fwr.getDonationList().add(r);

                    }
                    account.getWorkQueue().getWorkRequestList().add(ewr);
                    account.getWorkQueue().getWorkRequestList().add(ewr);
                    populateSelfTable();
                    populateTable();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_approveBtnActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_typeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton availableBudgetBtn;
    private javax.swing.JTable eventsTbl;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableCompleted;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JButton viewDetailsBtn;
    // End of variables declaration//GEN-END:variables
}
