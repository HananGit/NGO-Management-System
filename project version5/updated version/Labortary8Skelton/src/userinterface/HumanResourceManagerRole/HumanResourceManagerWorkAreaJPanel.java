/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HumanResourceManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventResourcesWorkRequest;
import Business.WorkQueue.EventWorkRequest;
import Business.WorkQueue.WorkRequest;
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
 * @author sushr
 */
public class HumanResourceManagerWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    EcoSystem business;
    Enterprise enterprise;

    /**
     * Creates new form HumanResourceManagerWorkArea
     */
    public HumanResourceManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
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

    

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) jTableEvent.getModel();
        model.setRowCount(0);
        jTableEvent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        System.out.println("In table");
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request instanceof EventWorkRequest && request.getStatus().equals("Approved")) {
//                model.setRowCount(0);
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                long millis = request.getRequiredDate();
                Date d = new Date(millis);
                row[2] = d;
                row[3] = request.getStatus();

                model.addRow(row);

            }
        }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEvent = new javax.swing.JTable();
        allocatedResourcesJButton = new javax.swing.JButton();
        jButtonManageSkill = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCompleted = new javax.swing.JTable();

        jTableEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Event Name", "Sender", "Requested Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEvent);

        allocatedResourcesJButton.setText("Allocate Resources");
        allocatedResourcesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allocatedResourcesJButtonActionPerformed(evt);
            }
        });

        jButtonManageSkill.setText("Manage Volunteers Skill set");
        jButtonManageSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageSkillActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonManageSkill)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(allocatedResourcesJButton)))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allocatedResourcesJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonManageSkill)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void allocatedResourcesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allocatedResourcesJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            EventWorkRequest wr = (EventWorkRequest) jTableEvent.getValueAt(selectedRow, 0);
            AllocateResources manageVolunteers = new AllocateResources(userProcessContainer, wr, account, enterprise);
            userProcessContainer.add("ManageVolunteers", manageVolunteers);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_allocatedResourcesJButtonActionPerformed

    private void jButtonManageSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageSkillActionPerformed
        // TODO add your handling code here:

        int count = 0;
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof VolunteerOrganization) {
                count = 0;
                for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                    count++;

                }

            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No users exist");
        } else {
            ManageVolunteerSkillSet manageVolunteersSkills = new ManageVolunteerSkillSet(userProcessContainer, enterprise);
            userProcessContainer.add("manageVolunteersSkills", manageVolunteersSkills);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_jButtonManageSkillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allocatedResourcesJButton;
    private javax.swing.JButton jButtonManageSkill;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCompleted;
    private javax.swing.JTable jTableEvent;
    // End of variables declaration//GEN-END:variables
}
