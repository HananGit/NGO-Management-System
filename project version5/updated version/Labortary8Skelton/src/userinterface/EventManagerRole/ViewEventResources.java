/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EventManagerRole;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventResourcesWorkRequest;
import Business.WorkQueue.Resource;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sneha
 */
public class ViewEventResources extends javax.swing.JPanel {
JPanel userProcessContainer;
    UserAccount ua;
    EventResourcesWorkRequest wr;
    /**
     * Creates new form RequestEventResources
     */
    public ViewEventResources(JPanel userProcessContainer, EventResourcesWorkRequest wr,UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.setSize(1100,800);
        this.wr=wr;
        this.ua=ua;
        jTextAreaMessage.setEnabled(true);
        jTextAreaMessage.setText(wr.getMessage());
        jTextAreaMessage.setEnabled(false);
        enableFields();
        setValues();
        disableFields();
        saveJButton.setEnabled(false);
        jButtonComplete.setVisible(false);
        populateTable();
        if(wr.getStatus().equals("Approved"))
        {
            jButtonComplete.setVisible(true);
            saveJButton.setVisible(false);
            updateJButton.setVisible(false);
            
        }
    }

    
    private void disableFields()
    {
        jDateChooserRequiredDate.setEnabled(false);
        requestJTextField.setEnabled(false);
        descriptionJTextArea.setEnabled(false);
        jButtonAdd.setEnabled(false);
        jButtonRemove.setEnabled(false);
        resourceJTextField.setEnabled(false);
        quantityJTextField.setEnabled(false);
        
    }
    private void setValues()
    {
        
        requestJTextField.setText(wr.getTitle());
        descriptionJTextArea.setText(wr.getDesc());
        long millis = wr.getRequiredDate();
        Date d = new Date(millis);
        jDateChooserRequiredDate.setDate(d);
        
        
    }
    private void enableFields()
    {
        jDateChooserRequiredDate.setEnabled(true);
        requestJTextField.setEnabled(true);
        descriptionJTextArea.setEnabled(true);
        jButtonAdd.setEnabled(true);
        jButtonRemove.setEnabled(true);
        resourceJTextField.setEnabled(true);
        quantityJTextField.setEnabled(true);
        
    }

    
    public void populateTable()
    {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for(Resource r : wr.getResourceList())
        {
            Object[] row = new Object[2];
            row[0]=r;
            row[1]=r.getQuantity();
            
            
            dtm.addRow(row);
            
        }
    }
       
            private boolean validateData()
    {
        if(!(requestJTextField.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Request Title field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(!( descriptionJTextArea.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Description field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
           else if(wr.getResourceList().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter at least one resource","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
            
        }
        
       /* else if(!(resourceJTextField.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Resource field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
           else if(!isNumber(quantityJTextField.getText().trim())){
           JOptionPane.showMessageDialog(null,"Quantity field is non numeric","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }*/
        else{
          return true;  
        }
        
    }
    
    private boolean validateDate(){
      
        Date date=new Date();
        long i = date.getTime()+86400000;//this gets todays date and adds 24 hours in it  
        Date reqdDate = jDateChooserRequiredDate.getDate();
        long j = reqdDate.getTime();
        if(j<i)// we are checking requested date is greater than todays date by 24 hours     
        {
            JOptionPane.showMessageDialog(null, "Requested/Required date should be atleast 48 hours more than todays date");//copy me
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        requestJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jDateChooserRequiredDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        resourceJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantityJTextField = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionJTextArea = new javax.swing.JTextArea();
        jButtonRemove = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        jButtonComplete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Request Event Resources");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 28, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Required Date :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 147, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Request Title :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 202, -1, -1));
        add(requestJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 202, 140, -1));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 29, -1, -1));
        add(jDateChooserRequiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 147, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Resource : ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 398, -1, -1));
        add(resourceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 395, 180, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 398, -1, -1));

        quantityJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityJTextFieldActionPerformed(evt);
            }
        });
        add(quantityJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 395, 122, -1));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Add.GIF"))); // NOI18N
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 389, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Description :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 259, 191, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 456, 617, 191));

        descriptionJTextArea.setColumns(20);
        descriptionJTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionJTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 259, 499, -1));

        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Delete.GIF"))); // NOI18N
        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 456, -1, -1));

        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        saveJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/save.GIF"))); // NOI18N
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 160, 70));

        updateJButton.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        updateJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/edit.GIF"))); // NOI18N
        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, -1, -1));

        jButtonComplete.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonComplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/complete.PNG"))); // NOI18N
        jButtonComplete.setText("Complete");
        jButtonComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompleteActionPerformed(evt);
            }
        });
        add(jButtonComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 670, -1, 60));

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jScrollPane3.setViewportView(jTextAreaMessage);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 94, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Remarks");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 94, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/EventManagerRole/Orange.PNG"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

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

    private void quantityJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityJTextFieldActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        Resource resource = new Resource();
         if(resourceJTextField.getText().trim().length() > 0){
            resource.setResourceName(resourceJTextField.getText()); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Resource field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return;
           }
        if(quantityJTextField.getText().trim().length()>0 && isNumber(quantityJTextField.getText().trim())&& Integer.parseInt(quantityJTextField.getText())>0){
                resource.setQuantity(Integer.parseInt(quantityJTextField.getText()));
           }
           else{
           JOptionPane.showMessageDialog(null,"Quantity field should be greater than zero and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        populateTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>=0)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "would you like to delete the resource details?", "warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Resource r = (Resource)jTable1.getValueAt(selectedRow,0);
                wr.getResourceList().remove(r);
                populateTable();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row from table first","Warning",JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        
       if(validateDate() && validateData()){
        wr.setMessage("Request for event resources has been modified");
        wr.setSender(ua);
        wr.setStatus("Requested");
        wr.setTitle(requestJTextField.getText());
        wr.setDesc(descriptionJTextArea.getText());
        Date d = jDateChooserRequiredDate.getDate();
        long m = d.getTime();
        wr.setRequiredDate(m);
        
        wr.setChanged(true);
        disableFields();
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Record successfuly modified","Message",JOptionPane.INFORMATION_MESSAGE);
       }
       else
           return;
        // TODO add your handling code here:
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        enableFields();
        updateJButton.setEnabled(false);
        saveJButton.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void jButtonCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompleteActionPerformed
        
        
            wr.setMessage("Request for event resources has been completed");
//        wr.setSender(ua);
        wr.setStatus("Completed");
            
        JOptionPane.showMessageDialog(null, "Record successfuly modified","Message",JOptionPane.INFORMATION_MESSAGE);
        backJButton.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCompleteActionPerformed
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
    private javax.swing.JTextArea descriptionJTextArea;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonComplete;
    private javax.swing.JButton jButtonRemove;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JTextField requestJTextField;
    private javax.swing.JTextField resourceJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}
