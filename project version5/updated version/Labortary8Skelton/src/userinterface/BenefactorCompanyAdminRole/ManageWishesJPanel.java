/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BenefactorCompanyAdminRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Contributor;
import Business.WorkQueue.WishWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sushr
 */
public class ManageWishesJPanel extends javax.swing.JPanel {
    UserAccount account;
    Enterprise enterprise;
    JPanel userProcessContainer;
    WishWorkRequest wr;
    /**
     * Creates new form ManageWishesJPanel
     */
    public ManageWishesJPanel(JPanel userProcessContainer,WishWorkRequest wr,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account=account;
        this.wr=wr;
         enableFields();
        setValues();
        disableFields();
        populateTable();
        populateCost();
    }

    private void populateCost()
    {
        
        
        if(wr.getContributorList().isEmpty())
        {
            jTextFieldTotalCollected.setText("0");
            jTextFieldTotalNeeded.setText(jTextFieldCost.getText());
        }
        else
        {
            int count=0;
            for(Contributor c:wr.getContributorList())
            {
                count=count+c.getAmount();
                
                
            }
            jTextFieldTotalCollected.setText(String.valueOf(count));
            int z=Integer.parseInt(jTextFieldCost.getText());
            int diff=z-count;
            jTextFieldTotalNeeded.setText(String.valueOf(diff));
            
        }
    }
    private void populateTable()
    {
        if(wr.getContributorList().isEmpty())
        {
            DefaultTableModel dtm = (DefaultTableModel) jTableContributors.getModel();
            dtm.setRowCount(0);
        }
        else{
            DefaultTableModel dtm = (DefaultTableModel) jTableContributors.getModel();
            dtm.setRowCount(0);
        for(Contributor c:wr.getContributorList())
        {
//            System.out.println("in table populate");
            
            Object[] row = new Object[2];
            row[0]=c;
            row[1]=c.getAmount();
            dtm.addRow(row);
            
                    
        }
        }
    }
    
    private void enableFields()
    {
        jTextFieldCost.setEnabled(true);
        jTextFieldWishTitle.setEnabled(true);
        jDateChooserRequiredDate.setEnabled(true);
        textAreaWishDesc.setEnabled(true);
        textAreaWisherDetails.setEnabled(true);
        
    }
    private void setValues()
    {
        
        long millis = wr.getRequiredDate();
        Date d = new Date(millis);
        jTextFieldCost.setText(String.valueOf(wr.getCost()));
        jTextFieldWishTitle.setText(wr.getWishTitle());
        jDateChooserRequiredDate.setDate(d);
        textAreaWishDesc.setText(wr.getWishDesc());
        textAreaWisherDetails.setText(wr.getWishDetails());
//        int c=Integer.parseInt(jTextFieldCost.getText());
        if(wr.getContributorList().isEmpty())
        {
            jTextFieldTotalCollected.setText("0");
            jTextFieldTotalNeeded.setText(jTextFieldCost.getText());
        }
        else
        {
            int count=0;
            for(Contributor c:wr.getContributorList())
            {
                count=count+c.getAmount();
                
                
            }
            jTextFieldTotalCollected.setText(String.valueOf(count));
            int z=Integer.parseInt(jTextFieldCost.getText());
            int diff=z-count;
            jTextFieldTotalNeeded.setText(String.valueOf(diff));
            
        }
        
    }
    private void disableFields()
    {
        jTextFieldCost.setEnabled(false);
        jTextFieldWishTitle.setEnabled(false);
        jDateChooserRequiredDate.setEnabled(false);
        textAreaWishDesc.setEnabled(false);
        textAreaWisherDetails.setEnabled(false);
        jTextFieldTotalNeeded.setEnabled(false);
        jTextFieldTotalCollected.setEnabled(false);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaWisherDetails = new javax.swing.JTextArea();
        Cost = new javax.swing.JLabel();
        jTextFieldWishTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaWishDesc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        Cost1 = new javax.swing.JLabel();
        jTextFieldCost = new javax.swing.JTextField();
        jDateChooserRequiredDate = new com.toedter.calendar.JDateChooser();
        jTextFieldTotalCollected = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTotalNeeded = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContributors = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jButtonAddAmount = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage Wishes Screen");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jScrollPane3.setToolTipText("");

        textAreaWisherDetails.setColumns(20);
        textAreaWisherDetails.setRows(5);
        jScrollPane3.setViewportView(textAreaWisherDetails);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 260, 114));

        Cost.setForeground(new java.awt.Color(255, 255, 255));
        Cost.setText("Total Cost:");
        Cost.setToolTipText("");
        add(Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        jTextFieldWishTitle.setToolTipText("");
        add(jTextFieldWishTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 220, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Required Date:");
        jLabel4.setToolTipText("");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Wish Title:");
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jScrollPane4.setToolTipText("");

        textAreaWishDesc.setColumns(20);
        textAreaWishDesc.setRows(5);
        jScrollPane4.setViewportView(textAreaWishDesc);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 250, 114));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Wish Description:");
        jLabel7.setToolTipText("");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        Cost1.setForeground(new java.awt.Color(255, 255, 255));
        Cost1.setText("Wisher Details:");
        Cost1.setToolTipText("");
        add(Cost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jTextFieldCost.setToolTipText("");
        add(jTextFieldCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 140, -1));

        jDateChooserRequiredDate.setToolTipText("");
        add(jDateChooserRequiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 180, 220, -1));
        add(jTextFieldTotalCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 570, 270, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Collected:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Needed:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 620, -1, -1));
        add(jTextFieldTotalNeeded, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 620, 270, -1));

        jTableContributors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Contributor", "Amount Contributed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableContributors);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 520, 258));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Amount:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, 30));
        add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 220, -1));

        jButtonAddAmount.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddAmount.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonAddAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        jButtonAddAmount.setText("Add");
        jButtonAddAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAmountActionPerformed(evt);
            }
        });
        add(jButtonAddAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/BenefactorCompanyAdminRole/Blue.PNG"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
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

    private void jButtonAddAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAmountActionPerformed
        int amount = Integer.parseInt(jTextFieldAmount.getText());
        jTextFieldTotalNeeded.setEnabled(true);
        int neededAmount =  Integer.parseInt(jTextFieldTotalNeeded.getText());
        jTextFieldTotalNeeded.setEnabled(false);
        boolean flag=true;
        if(amount>neededAmount)
        {
            JOptionPane.showMessageDialog(null, "Invalid amount");
        }
        else{
            for(Contributor c:wr.getContributorList())
            {
                flag=true;
                if(account.getName().equals(c.getContributorName()))
                {
                    flag=false;
                    int a=amount;
                    if(a>neededAmount)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid amount");
                        break;
                        
                    }
                    else
                    {
                        a+=c.getAmount();
                        c.setAmount(a);
                        populateTable();
                        populateCost();
                        boolean w=true;
                        for(WorkRequest work:account.getWorkQueue().getWorkRequestList())
                        {
                            WishWorkRequest wwr=(WishWorkRequest)work;
                            if(wwr.getCost()==wr.getCost() && wwr.getWishTitle().equals(wr)&& wwr.getWishDesc().equals(wr.getWishDesc()))
                            {
                                w=false;
                                break;
                            }
                            
                            
                        }
                        if(w)
                        {
                            account.getWorkQueue().getWorkRequestList().add(wr);
                            System.out.println("ok");
                        }
                    }
                }
                
                
            }
            
            if(flag){
        Contributor c = new Contributor();
        wr.getContributorList().add(c);
        c.setAmount(amount);
        c.setContributorName(account.getName());
        populateTable();
        populateCost();
        
        int a=Integer.parseInt(jTextFieldTotalCollected.getText());
        int b=Integer.parseInt(jTextFieldCost.getText());
        if(a==b)
        {
            wr.setStatus("Granted");
            jButtonAddAmount.setEnabled(false);
            // need to write email code to send target company
        }
        
            }
            
        }
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cost;
    private javax.swing.JLabel Cost1;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton jButtonAddAmount;
    private com.toedter.calendar.JDateChooser jDateChooserRequiredDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableContributors;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldCost;
    private javax.swing.JTextField jTextFieldTotalCollected;
    private javax.swing.JTextField jTextFieldTotalNeeded;
    private javax.swing.JTextField jTextFieldWishTitle;
    private javax.swing.JTextArea textAreaWishDesc;
    private javax.swing.JTextArea textAreaWisherDetails;
    // End of variables declaration//GEN-END:variables
}
