/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FinancialManagerRole;

import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.Resource;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sushr
 */
public class ViewDonationJPanelF extends javax.swing.JPanel {
    JPanel userProcessContainer;
DonationWorkRequest dwr;
    /**
     * Creates new form ViewDonationJPanelF
     */
    public ViewDonationJPanelF(JPanel userProcessContainer,DonationWorkRequest dwr) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.dwr=dwr;
        setValues();
        
        
    }

    private void setValues()
    {
        jTextFieldDonationName.setText(dwr.getTitle());
        jTextFieldDonationName.setEnabled(false);
        long m=dwr.getCreatedDate();
        Date d=new Date(m);
        jTextFieldCreateDate.setText(String.valueOf(d));
        jTextFieldCreateDate.setEnabled(false);
        jTextAreaDesc.setText(dwr.getMessage());
        jTextAreaDesc.setEnabled(false);
        jTextFieldDonorCompany.setText(dwr.getEnterpriseName());
        jTextFieldDonorCompany.setEnabled(false);
        
        populateTable();
    }
    private void populateTable()
    {
        DefaultTableModel dtm = (DefaultTableModel) jTableResources.getModel();
        dtm.setRowCount(0);
        jTableResources.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (Resource r : dwr.getResourceList()) {
            Object[] row = new Object[2];
            row[0] = r;
            row[1] = r.getQuantity();
            dtm.addRow(row);
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
        jTableResources = new javax.swing.JTable();
        jTextFieldDonationName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCreateDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDesc = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDonorCompany = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, 177));
        add(jTextFieldDonationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Donation Name*");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("View Donation");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));
        add(jTextFieldCreateDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 170, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Created Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, -1, -1));

        jTextAreaDesc.setColumns(20);
        jTextAreaDesc.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDesc);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));
        add(jTextFieldDonorCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 160, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Donor Company");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        backJButton.setText(" Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 28, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Purple.PNG"))); // NOI18N
        jLabel6.setText("jLabel6");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
                userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        FinancialManagerWorkAreaJPanel emwajp = (FinancialManagerWorkAreaJPanel) component;
        emwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableResources;
    private javax.swing.JTextArea jTextAreaDesc;
    private javax.swing.JTextField jTextFieldCreateDate;
    private javax.swing.JTextField jTextFieldDonationName;
    private javax.swing.JTextField jTextFieldDonorCompany;
    // End of variables declaration//GEN-END:variables
}