/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Enterprise.BenefactorCompanyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.EnterpriseRelation;
import Business.Enterprise.OperatingCompanyEnterprise;
import Business.Enterprise.TargetCompanyEnterprise;
import Business.Enterprise.VendorCompanyEnterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sushr
 */
public class ManageRelationship extends javax.swing.JPanel {
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    EnterpriseDirectory enterpriseDirectory;
    /**
     * Creates new form ManageRelationshipOperatingCompany
     */
    public ManageRelationship(JPanel userProcessContainer,EcoSystem business,Enterprise enterprise) {
        initComponents();
        this.setSize(1100,800);
        this.userProcessContainer = userProcessContainer;
        this.business=business;
        this.enterprise=enterprise;


        
        loop:        for(Network n:business.getNetworkList())
             {
                 for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList())
                 {
                     if(e.equals(enterprise))
                     {
                         enterpriseDirectory=n.getEnterpriseDirectory();
                         break loop;
                         
                     }
                     
                 }
                 
             }

    
            
        populateRelatedTable();
        populateComboBox();
    }

    public void populateComboBox()
    {
//        jComboBoxCompanyType.removeAllItems();
        if((enterprise instanceof BenefactorCompanyEnterprise)){
        jComboBoxCompanyType.removeItem("Benefactor");
        jComboBoxCompanyType.removeItem("Vendor");
            jComboBoxCompanyType.removeItem("Target");
        }
        if((enterprise instanceof OperatingCompanyEnterprise))
//            jComboBoxCompanyType.addItem("Operating");
            jComboBoxCompanyType.removeItem("Operating");
        if((enterprise instanceof VendorCompanyEnterprise)){
            jComboBoxCompanyType.removeItem("Benefactor");
            jComboBoxCompanyType.removeItem("Vendor");
            jComboBoxCompanyType.removeItem("Target");
        }
        if((enterprise instanceof TargetCompanyEnterprise)){
            
            jComboBoxCompanyType.removeItem("Target");
            jComboBoxCompanyType.removeItem("Benefactor");
            jComboBoxCompanyType.removeItem("Vendor");}
        
        
    }
   
    public void populateRelatedTable()
    {   
        DefaultTableModel model = (DefaultTableModel)jTableRelated.getModel();
        jTableRelated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.setRowCount(0);
        if(!(enterprise.getEnterpriseRelationDirectory().getRelationList().isEmpty()))
        for(EnterpriseRelation er: enterprise.getEnterpriseRelationDirectory().getRelationList())
        {   
            Object[] row = new Object[2];
            row[0] = er;
            row[1] = er.getCompanyType();
            model.addRow(row);
            
        }
        populateUnrelatedTable();
    }

    public void populateUnrelatedTable(){
                
        
        
        String companyType=(String)jComboBoxCompanyType.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel)jTableUnrelated.getModel();
        jTableRelated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.setRowCount(0);
        switch(companyType)
        {
            case "Benefactor":
            {
                boolean flag=false;
                
                for(Enterprise er : enterpriseDirectory.getEnterpriseList()){
                    if(!(enterprise.getEnterpriseRelationDirectory().getRelationList().isEmpty())){
                        flag=false;
                    for(EnterpriseRelation erelation: enterprise.getEnterpriseRelationDirectory().getRelationList())
                    {
                        if(erelation.getCompanyName().equals(er.getName()))
                            flag=true;
                        
                    }
                    }
                    if(!(er.equals(enterprise)) && er instanceof BenefactorCompanyEnterprise && !flag){
                        Object[] row = new Object[2];
                        row[0] = er;
                        row[1] = er.getEnterpriseType().getValue();
                        model.addRow(row);
                    }
                }

                break;
            }
            case "Vendor":
            {
                boolean flag=false;
                for(Enterprise er : enterpriseDirectory.getEnterpriseList()){
                    if(!(enterprise.getEnterpriseRelationDirectory().getRelationList().isEmpty())){
                        flag=false;
                 
                    for(EnterpriseRelation erelation: enterprise.getEnterpriseRelationDirectory().getRelationList())
                    {
                        if(erelation.getCompanyName().equals(er.getName()))
                            flag=true;
                        
                    }
                }
                    if(!(er.equals(enterprise)) && er instanceof VendorCompanyEnterprise && !flag){
                        Object[] row = new Object[2];
                        row[0] = er;
                        row[1] = er.getEnterpriseType().getValue();
                        model.addRow(row);
                    }
                }
                break;
            }
            case "Target":
            {
                boolean flag=false;
                for(Enterprise er : enterpriseDirectory.getEnterpriseList()){
                    if(!(enterprise.getEnterpriseRelationDirectory().getRelationList().isEmpty())){
                        flag=false;
                    for(EnterpriseRelation erelation: enterprise.getEnterpriseRelationDirectory().getRelationList())
                    {
                        if(erelation.getCompanyName().equals(er.getName()))
                            flag=true;
                        
                    }
                    }
                    if(!(er.equals(enterprise)) && er instanceof TargetCompanyEnterprise && !flag){
                        Object[] row = new Object[2];
                        row[0] = er;
                        row[1] = er.getEnterpriseType().getValue();
                        model.addRow(row);
                    }
                }
                break;
            }
            case "Operating":
            {
                boolean flag=false;
                for(Enterprise er : enterpriseDirectory.getEnterpriseList()){
                    if(!(enterprise.getEnterpriseRelationDirectory().getRelationList().isEmpty())){
                        flag=false;
                    for(EnterpriseRelation erelation: enterprise.getEnterpriseRelationDirectory().getRelationList())
                    {
                        if(erelation.getCompanyName().equals(er.getName()))
                            flag=true;
                        
                    }
                    }
                    if(!(er.equals(enterprise)) && er instanceof OperatingCompanyEnterprise && !flag){
                        Object[] row = new Object[2];
                        row[0] = er;
                        row[1] = er.getEnterpriseType().getValue();
                        model.addRow(row);
                    }
                }
                break;
            }
                
        }
//        if(companyType==0){//0Benefactor 1Vendor 2Target 3Operating
        
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
        jTableRelated = new javax.swing.JTable();
        jButtonRelate = new javax.swing.JButton();
        jButtonUnrelate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCompanyType = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUnrelated = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Company Name", "Company Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRelated);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 467, 362, 219));

        jButtonRelate.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonRelate.setText(">>");
        jButtonRelate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelateActionPerformed(evt);
            }
        });
        add(jButtonRelate, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 501, -1, -1));

        jButtonUnrelate.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButtonUnrelate.setText("<<");
        jButtonUnrelate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnrelateActionPerformed(evt);
            }
        });
        add(jButtonUnrelate, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 590, -1, -1));

        jLabel3.setForeground(new java.awt.Color(51, 255, 153));
        jLabel3.setText("Company Type");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/IconsPictures/Icons/Back.GIF"))); // NOI18N
        jButton1.setText(" Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 35, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 153));
        jLabel4.setText("Manage Relationship");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 458, 48));

        jComboBoxCompanyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Benefactor", "Vendor", "Target", "Operating" }));
        jComboBoxCompanyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCompanyTypeActionPerformed(evt);
            }
        });
        add(jComboBoxCompanyType, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 261, -1));

        jTableUnrelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Company Name", "Company Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableUnrelated);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 467, 364, 219));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 153));
        jLabel1.setText("Related");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 361, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 153));
        jLabel2.setText("Unrelated");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 361, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/AdministrativeRole/Green.PNG"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUnrelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnrelateActionPerformed
         int selectedRow = jTableRelated.getSelectedRow();
        if(selectedRow>=0)
        {
                EnterpriseRelation er = (EnterpriseRelation)jTableRelated.getValueAt(selectedRow,0);
                
                
                for(Enterprise e:enterpriseDirectory.getEnterpriseList())
                {
                    if(er.getCompanyName().equals(e.getName()))
                    {
                        e.getEnterpriseRelationDirectory().deleteRelation(er.getCompanyName());
                    }
                    
                }
                enterprise.getEnterpriseRelationDirectory().deleteRelation(er);
//                EnterpriseRelation er = (EnterpriseRelation)jTableRelated.getValueAt(selectedRow,0);
//                list.deleteProduct(er);
//                populateRelatedTable();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row from table first","Warning",JOptionPane.WARNING_MESSAGE);
        }
        populateRelatedTable();


        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUnrelateActionPerformed

    private void jComboBoxCompanyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCompanyTypeActionPerformed
        populateRelatedTable();

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCompanyTypeActionPerformed

    private void jButtonRelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelateActionPerformed
                int selectedRow = jTableUnrelated.getSelectedRow();
        if(selectedRow>=0)
        {
                Enterprise e = (Enterprise)jTableUnrelated.getValueAt(selectedRow,0);
                
                enterprise.getEnterpriseRelationDirectory().createRelation(e.getName(),e.getEnterpriseType().getValue());
                System.out.println(""+e.getEnterpriseType().getValue());
                e.getEnterpriseRelationDirectory().createRelation(enterprise.getName(),enterprise.getEnterpriseType().getValue());
//                EnterpriseRelation er = (EnterpriseRelation)jTableRelated.getValueAt(selectedRow,0);
//                list.deleteProduct(er);
//                populateRelatedTable();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row from table first","Warning",JOptionPane.WARNING_MESSAGE);
        }
        populateRelatedTable();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRelateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonRelate;
    private javax.swing.JButton jButtonUnrelate;
    private javax.swing.JComboBox<String> jComboBoxCompanyType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRelated;
    private javax.swing.JTable jTableUnrelated;
    // End of variables declaration//GEN-END:variables
}
