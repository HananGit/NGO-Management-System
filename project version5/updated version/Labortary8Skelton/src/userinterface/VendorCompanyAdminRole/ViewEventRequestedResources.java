/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VendorCompanyAdminRole;

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
public class ViewEventRequestedResources extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount ua;
    EventResourcesWorkRequest wr;
    /**
     * Creates new form RequestEvent
     */
    public ViewEventRequestedResources(JPanel userProcessContainer, EventResourcesWorkRequest wr,UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.wr=wr;
        this.ua=ua;
        enableFields();
        setValues();
        disableFields();
                populateTable();
        jButtonUpdate.setEnabled(false);
    }
           private boolean validateData()
    {
        if(!(requestTitleJTextField.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Request Title field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(!( descriptionJTextArea.getText().trim().length() > 0)){
           JOptionPane.showMessageDialog(null,"Description field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
      /*  else if(!(resourceJTextField.getText().trim().length() > 0)){
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
        Date reqdDate = requiredDateJDateChooser.getDate();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionJTextArea = new javax.swing.JTextArea();
        requiredDateJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        requestTitleJTextField = new javax.swing.JTextField();
        jButtonRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        resourceJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantityJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonModify = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        jLabel1.setText("Viewing Requested Resources");

        jLabel3.setText("Required Date :");

        descriptionJTextArea.setColumns(20);
        descriptionJTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionJTextArea);

        jLabel4.setText("Request Title :");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jLabel5.setText("Resource : ");

        jLabel6.setText("Quantity :");

        quantityJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityJTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Description :");

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

        jButtonModify.setText("Modify");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backJButton)
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(227, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButtonModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpdate)
                .addGap(216, 216, 216))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(resourceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quantityJTextField))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonAdd)
                                .addComponent(jButtonRemove)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(requiredDateJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(requestTitleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModify)
                    .addComponent(jButtonUpdate))
                .addGap(78, 78, 78))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(requiredDateJDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(requestTitleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resourceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdd))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemove))
                    .addContainerGap(136, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enableFields()
    {
        requestTitleJTextField.setEnabled(true);
        requiredDateJDateChooser.setEnabled(true);
        jButtonAdd.setEnabled(true);
        jButtonRemove.setEnabled(true);
        resourceJTextField.setEnabled(true);
        quantityJTextField.setEnabled(true);
        descriptionJTextArea.setEnabled(true);
    }
    private void setValues()
    {
        requestTitleJTextField.setText(wr.getTitle());
        long millis = wr.getRequiredDate();
        Date d = new Date(millis);
        requiredDateJDateChooser.setDate(d);
        
        
        descriptionJTextArea.setText(wr.getDesc());
        
    }
    private void disableFields()
    {
        requestTitleJTextField.setEnabled(false);
        requiredDateJDateChooser.setEnabled(false);
        jButtonAdd.setEnabled(false);
        jButtonRemove.setEnabled(false);
        resourceJTextField.setEnabled(false);
        quantityJTextField.setEnabled(false);
        descriptionJTextArea.setEnabled(false);
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
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        Resource resource = new Resource();
       if(resourceJTextField.getText().trim().length()==0){
         
            JOptionPane.showMessageDialog(null,"Resource field is empty","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

       if(quantityJTextField.getText().trim().length()==0 || !isNumber(quantityJTextField.getText().trim())|| Integer.parseInt(quantityJTextField.getText())<=0){
   
           JOptionPane.showMessageDialog(null,"Quantity field should be greater than zero and not null","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        wr.getResourceList().add(resource);
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

    private void quantityJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityJTextFieldActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed

        if(validateDate() && validateData()){
        wr.setMessage("Request for event resources has been modified");
        wr.setSender(ua);
        wr.setStatus("Requested");
        wr.setTitle(requestTitleJTextField.getText());
        wr.setDesc(descriptionJTextArea.getText());
        Date d = requiredDateJDateChooser.getDate();
        long m = d.getTime();
        wr.setRequiredDate(m);
        
        wr.setChanged(true);
        disableFields();
        jButtonUpdate.setEnabled(false);
        jButtonModify.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Record successfuly modified","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            return;

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        enableFields();
        jButtonModify.setEnabled(false);
        jButtonUpdate.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VendorCompanyWorkAreaJPanel emwajp = (VendorCompanyWorkAreaJPanel) component;
        emwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

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
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JTextField requestTitleJTextField;
    private com.toedter.calendar.JDateChooser requiredDateJDateChooser;
    private javax.swing.JTextField resourceJTextField;
    // End of variables declaration//GEN-END:variables
}