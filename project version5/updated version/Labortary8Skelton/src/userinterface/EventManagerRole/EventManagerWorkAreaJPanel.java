/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EventManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventResourcesWorkRequest;
import Business.WorkQueue.EventWorkRequest;
import Business.WorkQueue.FundsWorkRequest;
import Business.WorkQueue.Resource;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sneha
 */
public class EventManagerWorkAreaJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    /**
     * Creates new form EventManagerWorkAreaJPanel
     */
    UserAccount account;
    Organization organization;
    EcoSystem business;
    Enterprise enterprise;
    public EventManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.setSize(1100,800);
        
        this.userProcessContainer = userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.business=business;
        this.enterprise=enterprise;
        populateTable();
                jCalendar1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                Date d = jCalendar1.getDate();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");        
        String a=dateFormat.format(d);
                for(EventWorkRequest ewr:enterprise.getEventList())
               {
                   Date d1=new Date(ewr.getEventDate());
                   String b=dateFormat.format(d1);
                if(a.equals(b)){   
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
            
            if(wr instanceof EventWorkRequest)
            {
                row[3]="Event";
                EventWorkRequest ewr = (EventWorkRequest) wr;
                row[1]=ewr.getEventName();
            }
            if(wr instanceof EventResourcesWorkRequest)
            {
                row[3]="Event Resources";
                EventResourcesWorkRequest rwr = (EventResourcesWorkRequest)wr;
                row[1]=rwr.getTitle();
            }
            dtm.addRow(row);
        }
    }
    public void populateTable(){
               
        DefaultTableModel model = (DefaultTableModel)eventsJTable.getModel();
        model.setRowCount(0);
        eventsJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        System.out.println("In table");
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof EventWorkRequest && jComboBoxType.getSelectedIndex()==0 && (request.getStatus().equals("Proposed")|| request.getStatus().equals("Rejected"))){
//                model.setRowCount(0);
                
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            long millis = request.getRequiredDate();
            Date d = new Date(millis);
            row[2] = d;
            row[3] = request.getStatus();
            row[4] = request.isChanged();
            model.addRow(row);

            }
        }
        
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
        
            if(request instanceof EventResourcesWorkRequest && jComboBoxType.getSelectedIndex()==1 && (request.getStatus().equals("Requested")||request.getStatus().equals("Rejected")||request.getStatus().equals("Approved"))){
//                model.setRowCount(0);
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            long millis = request.getRequiredDate();
            Date d = new Date(millis);
            row[2] = d;
            row[3] = request.getStatus();
            row[4] = request.isChanged();
            model.addRow(row);
            
                
            }
        }
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

        jSplitPane = new javax.swing.JSplitPane();
        leftJPanel = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        rightJPanel = new javax.swing.JPanel();
        requestEventResourceJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsJTable = new javax.swing.JTable();
        addEventJButton = new javax.swing.JButton();
        viewEventJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCompleted = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jSplitPane.setDividerLocation(300);
        jSplitPane.setEnabled(false);

        leftJPanel.setBackground(new java.awt.Color(255, 102, 51));
        leftJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        leftJPanel.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 111, -1, -1));

        jSplitPane.setLeftComponent(leftJPanel);

        rightJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestEventResourceJButton.setBackground(new java.awt.Color(255, 255, 255));
        requestEventResourceJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        requestEventResourceJButton.setText("Request Event Resources");
        requestEventResourceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestEventResourceJButtonActionPerformed(evt);
            }
        });
        rightJPanel.add(requestEventResourceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 478, -1, -1));

        eventsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Sender", "Requested Date", "Status", "Changed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(eventsJTable);

        rightJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 187, 786, 147));

        addEventJButton.setBackground(new java.awt.Color(255, 255, 255));
        addEventJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        addEventJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        addEventJButton.setText("Add Event");
        addEventJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventJButtonActionPerformed(evt);
            }
        });
        rightJPanel.add(addEventJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 381, -1, -1));

        viewEventJButton.setBackground(new java.awt.Color(255, 255, 255));
        viewEventJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        viewEventJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/View.GIF"))); // NOI18N
        viewEventJButton.setText("View");
        viewEventJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventJButtonActionPerformed(evt);
            }
        });
        rightJPanel.add(viewEventJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 190, -1));

        deleteJButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        deleteJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Delete.GIF"))); // NOI18N
        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        rightJPanel.add(deleteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 200, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Event  Manager  Work  Area");
        rightJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 56, -1, -1));

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Events", "Event Resources" }));
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });
        rightJPanel.add(jComboBoxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 132, -1, -1));

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

        rightJPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 537, -1, 246));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/EventManagerRole/Orange.PNG"))); // NOI18N
        rightJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSplitPane.setRightComponent(rightJPanel);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addEventJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventJButtonActionPerformed
            // TODO add your handling code here:
        
        AddEventJPanel addEventJPanel = new AddEventJPanel(userProcessContainer, enterprise,account);
        userProcessContainer.add("Add Event JPanel", addEventJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addEventJButtonActionPerformed

    private void viewEventJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventJButtonActionPerformed
         // TODO add your handling code here:
                int selectedRow=eventsJTable.getSelectedRow();
        if (selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table first to view details","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(jComboBoxType.getSelectedItem().equals("Events"))
                {
            EventWorkRequest wr=(EventWorkRequest)eventsJTable.getValueAt(selectedRow,0);
            ViewEventJPanel viewEventJPanel = new ViewEventJPanel(userProcessContainer,wr,account,business,enterprise);
        userProcessContainer.add("View Event JPanelEventWOrk", viewEventJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else if(jComboBoxType.getSelectedItem().equals("Event Resources"))
                {
            EventResourcesWorkRequest wr=(EventResourcesWorkRequest)eventsJTable.getValueAt(selectedRow,0);
                    ViewEventResources viewEventResourcesJPanel = new ViewEventResources(userProcessContainer,wr,account);
        userProcessContainer.add("viewEventResourcesJPanel", viewEventResourcesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }

         
    }//GEN-LAST:event_viewEventJButtonActionPerformed

    private void requestEventResourceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestEventResourceJButtonActionPerformed
        // TODO add your handling code here
       RequestEventResources requestResourcesJPanel = new RequestEventResources(userProcessContainer, enterprise,account,business);
        userProcessContainer.add("Request Event Resources JPanel", requestResourcesJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestEventResourceJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
         // TODO add your handling code here:
         int selectedRow=eventsJTable.getSelectedRow();
        if (selectedRow>=0){
            int dialogResult=JOptionPane.showConfirmDialog(null,"Would you like to delete the computer details?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult==JOptionPane.YES_OPTION){
                WorkRequest request=(WorkRequest)eventsJTable.getValueAt(selectedRow,0);
                enterprise.getWorkQueue().deleteWorkRequest(request);
                populateTable();
            }
        }
        else
        JOptionPane.showMessageDialog(null,"Please select a row from the table first","Warning",JOptionPane.WARNING_MESSAGE);
     
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        populateTable();
//        System.out.println("Action performed");
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JTable eventsJTable;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTable jTableCompleted;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JButton requestEventResourceJButton;
    private javax.swing.JPanel rightJPanel;
    private javax.swing.JButton viewEventJButton;
    // End of variables declaration//GEN-END:variables
}
