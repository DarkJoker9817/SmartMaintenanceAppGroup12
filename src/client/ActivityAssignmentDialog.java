/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import businesslogic.Maintainer;
import businesslogic.Planner;
import businesslogic.User;
import businesslogic.UserFactory;
import businesslogic.activity.ActivityFactory;
import businesslogic.activity.MaintenanceActivity;
import database.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ugobarbato
 */
public class ActivityAssignmentDialog extends javax.swing.JDialog {

    private Repository rep;
    private DefaultTableModel maintainersTableModel;
    private DefaultTableModel availabilityTableModel;
    private Planner planner;
    private Maintainer maintainer;
    private MaintenanceActivity scheduledActivity;
    private int id;
    
    /**
     * Creates new form ActivityAssignmentDialog
     */
    public ActivityAssignmentDialog(java.awt.Frame parent, boolean modal, int id) throws ClassNotFoundException, SQLException {
        super(parent, modal);
        initComponents();
        initialize();
        initDialog(id);
        this.id = id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        weekLabel = new javax.swing.JLabel();
        weekNumberLabel = new javax.swing.JLabel();
        activityLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        skillsLabel = new javax.swing.JLabel();
        availabilityLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        skillsList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        availabilityTable = new javax.swing.JTable();
        forwardButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        maintainersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        weekLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weekLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekLabel.setText("Week");
        weekLabel.setOpaque(true);

        weekNumberLabel.setBackground(new java.awt.Color(153, 153, 153));
        weekNumberLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weekNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        weekNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekNumberLabel.setOpaque(true);

        activityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activityLabel.setText("Activity to assign");
        activityLabel.setOpaque(true);

        infoLabel.setBackground(new java.awt.Color(153, 153, 153));
        infoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setOpaque(true);

        skillsLabel.setBackground(new java.awt.Color(255, 204, 102));
        skillsLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        skillsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        skillsLabel.setText("Skills needed");
        skillsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        skillsLabel.setOpaque(true);

        availabilityLabel.setBackground(new java.awt.Color(255, 204, 102));
        availabilityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        availabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availabilityLabel.setText("Maintainer AVAILABILITY");
        availabilityLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        availabilityLabel.setOpaque(true);

        jScrollPane1.setViewportView(skillsList);

        availabilityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        availabilityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availabilityTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(availabilityTable);
        if (availabilityTable.getColumnModel().getColumnCount() > 0) {
            availabilityTable.getColumnModel().getColumn(0).setResizable(false);
            availabilityTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(1).setResizable(false);
            availabilityTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(2).setResizable(false);
            availabilityTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(3).setResizable(false);
            availabilityTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(4).setResizable(false);
            availabilityTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(5).setResizable(false);
            availabilityTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            availabilityTable.getColumnModel().getColumn(6).setResizable(false);
            availabilityTable.getColumnModel().getColumn(6).setPreferredWidth(70);
        }

        forwardButton.setText("Forward");
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });

        maintainersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maintainer", "Skills"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(maintainersTable);
        if (maintainersTable.getColumnModel().getColumnCount() > 0) {
            maintainersTable.getColumnModel().getColumn(1).setResizable(false);
            maintainersTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(weekLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(weekNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(skillsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(availabilityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(activityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(activityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(weekLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(weekNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skillsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forwardButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initialize() throws ClassNotFoundException, SQLException {
        rep = Repository.getIstance();
        planner =  new Planner();
        maintainer = new Maintainer();
        maintainersTableModel = (DefaultTableModel) maintainersTable.getModel();
        availabilityTableModel = (DefaultTableModel) availabilityTable.getModel();
        fillTableMaintainers();
        
    }
    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        this.setVisible(false);
        int row = availabilityTable.getSelectedRow();
        int column = availabilityTable.getSelectedColumn();
        String nameDay = availabilityTable.getColumnName(column);
        String username = (String) maintainersTableModel.getValueAt(row, 0);
        
        try {
            new MaintainerWeekAvailabilityDialog(null, true, id, username, nameDay).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActivityAssignmentDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActivityAssignmentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void availabilityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availabilityTableMouseClicked
        forwardButton.setEnabled(true);
    }//GEN-LAST:event_availabilityTableMouseClicked
    
    private void initDialog(int id) throws SQLException {
        scheduledActivity = planner.getScheduledActivityFromId(id);
        weekNumberLabel.setText(String.valueOf(scheduledActivity.getWeek()));
        String[] site = scheduledActivity.getSite().split("-");
        String activity = String.valueOf(id) + " - " + site[0] + " " + site[1] +
                          " - " + scheduledActivity.getType() + " - " + 
                          String.valueOf(scheduledActivity.getEstimatedInterventionTime() + "'");
        infoLabel.setText(activity);
        
        forwardButton.setEnabled(false);
        availabilityTable.setCellSelectionEnabled(true);
        maintainersTable.setRowSelectionAllowed(false);  
    }

    private void fillTableMaintainers() throws ClassNotFoundException, SQLException {
        
        String[] maintainersRow = new String[2];
        List<Maintainer> maintainersList = new ArrayList<>();
        
        maintainersList = planner.getMaintainers();
        for(Maintainer m : maintainersList) {
            maintainersRow[0] = m.getUsername();
            maintainersTableModel.addRow(maintainersRow);
            availabilityTableModel.addRow(m.getDaysAvailability(maintainersRow[0]));
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityLabel;
    private javax.swing.JLabel availabilityLabel;
    private javax.swing.JTable availabilityTable;
    private javax.swing.JButton forwardButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable maintainersTable;
    private javax.swing.JLabel skillsLabel;
    private javax.swing.JList<String> skillsList;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JLabel weekNumberLabel;
    // End of variables declaration//GEN-END:variables
}
