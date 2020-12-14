/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import businesslogic.GUIFactory;
import businesslogic.Maintainer;
import businesslogic.Planner;
import businesslogic.activity.MaintenanceActivity;
import exceptions.TimeExceededException;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Egidio
 */
public class MaintainerWeekAvailabilityDialog extends javax.swing.JDialog {
    
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;
    private Planner planner;
    private Maintainer maintainer;
    private String username;
    private int id;
    private String day;
    private String skills;

    /**
     * Creates new form MaintainerWeekAvailability
     */
    public MaintainerWeekAvailabilityDialog(java.awt.Frame parent, boolean modal, int id, String username, String day, String skills) throws ClassNotFoundException, SQLException {
        super(parent, modal);
        this.username = username;
        this.day = day;
        this.id = id;
        this.skills=skills;
        initComponents();
        initialization();
        initDialog();

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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        notesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        dayLabel = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        weekNumberLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintainerTable = new javax.swing.JTable();
        sendButton = new javax.swing.JButton();
        activityToAssignLabel = new javax.swing.JLabel();
        activityLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        percentageLabel = new javax.swing.JLabel();
        availabilityLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        hoursTable = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                float valueFloat = Float.parseFloat(getModel().getValueAt(rowIndex,columnIndex).toString());
                float min = 60;

                int value = (int) ((valueFloat/min) *100);

                if(value == 100){
                    componenet.setBackground(new Color(0,102,51));
                    componenet.setForeground(Color.BLACK);
                }else if(value >= 80 && value < 100){
                    componenet.setBackground(new Color(0,204,51));
                    componenet.setForeground(Color.BLACK);
                }else if(value >= 50 && value < 80){
                    componenet.setBackground(new Color(255,255,0));
                    componenet.setForeground(Color.BLACK);
                }else if(value >= 20 && value < 50){
                    componenet.setBackground(new Color(255,153,0));
                    componenet.setForeground(Color.BLACK);
                }else if(value > 0 && value < 20){
                    componenet.setBackground(new Color(255,153,0));
                    componenet.setForeground(Color.BLACK);
                } else if(value == 0){
                    componenet.setBackground(Color.RED);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;
            }

        }
        ;

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setForeground(new java.awt.Color(255, 153, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        notesLabel.setBackground(new java.awt.Color(255, 204, 102));
        notesLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notesLabel.setText("WORKSPACE NOTES");
        notesLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        notesLabel.setOpaque(true);

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane1.setViewportView(notesTextArea);

        dayLabel.setBackground(new java.awt.Color(255, 255, 255));
        dayLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel.setText("Day");
        dayLabel.setOpaque(true);

        weekLabel.setBackground(new java.awt.Color(255, 255, 255));
        weekLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weekLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekLabel.setText("Week");
        weekLabel.setOpaque(true);

        weekNumberLabel.setBackground(new java.awt.Color(204, 204, 204));
        weekNumberLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weekNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekNumberLabel.setText("Num");
        weekNumberLabel.setOpaque(true);

        maintainerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maintainer", "skills"
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
        maintainerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(maintainerTable);
        if (maintainerTable.getColumnModel().getColumnCount() > 0) {
            maintainerTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            maintainerTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        }

        sendButton.setBackground(new java.awt.Color(204, 204, 204));
        sendButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        activityToAssignLabel.setBackground(new java.awt.Color(255, 255, 255));
        activityToAssignLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activityToAssignLabel.setText("Activity to assign");
        activityToAssignLabel.setOpaque(true);

        activityLabel.setBackground(new java.awt.Color(204, 204, 204));
        activityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        activityLabel.setText("jLabel4");
        activityLabel.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        percentageLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageLabel.setText("Num");

        availabilityLabel.setBackground(new java.awt.Color(255, 204, 102));
        availabilityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        availabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availabilityLabel.setText("AVAILABILITY");
        availabilityLabel.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(availabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(percentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availabilityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        percentageLabel.setVisible(false);

        hoursTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "8-9", "9-10", "10-11", "11-12", "14-15", "15-16", "16-17"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hoursTable.getTableHeader().setReorderingAllowed(false);
        hoursTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hoursTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(hoursTable);
        if (hoursTable.getColumnModel().getColumnCount() > 0) {
            hoursTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            hoursTable.getColumnModel().getColumn(1).setPreferredWidth(35);
            hoursTable.getColumnModel().getColumn(2).setResizable(false);
            hoursTable.getColumnModel().getColumn(2).setPreferredWidth(35);
            hoursTable.getColumnModel().getColumn(3).setResizable(false);
            hoursTable.getColumnModel().getColumn(3).setPreferredWidth(35);
            hoursTable.getColumnModel().getColumn(4).setResizable(false);
            hoursTable.getColumnModel().getColumn(4).setPreferredWidth(35);
            hoursTable.getColumnModel().getColumn(5).setResizable(false);
            hoursTable.getColumnModel().getColumn(5).setPreferredWidth(35);
            hoursTable.getColumnModel().getColumn(6).setResizable(false);
            hoursTable.getColumnModel().getColumn(6).setPreferredWidth(35);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weekLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(weekNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(activityToAssignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(activityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weekLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activityToAssignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initialization() throws ClassNotFoundException, SQLException {
        tableModel = (DefaultTableModel) maintainerTable.getModel();
        tableModel2 = (DefaultTableModel) hoursTable.getModel();
        planner = new Planner();
        maintainer = new Maintainer();
        hoursTable.setCellSelectionEnabled(true);
        maintainerTable.setRowSelectionAllowed(false);
    }

    private void initDialog() {
        try {
            MaintenanceActivity scheduledActivity = planner.getScheduledActivityFromId(id);

            weekNumberLabel.setText(String.valueOf(scheduledActivity.getWeek()));
            dayLabel.setText(day);
            notesTextArea.setText(String.valueOf(scheduledActivity.getWorkspaceNotes()));
            String[] site = scheduledActivity.getSite().split("-");
            String activity = String.valueOf(id) + " - " + site[0] + " " + site[1] + " - " + scheduledActivity.getType() + " - " + String.valueOf(scheduledActivity.getEstimatedInterventionTime());
            activityLabel.setText(activity);

        
            Integer[][] hours = new Integer[7][7];
            hours = maintainer.getHoursAvailability(username);
            String row[] = new String[2];
            Integer row2[] = new Integer[7];
            int i = planner.getWeekDayNumber(day);
            
            row[0] = username;
            row[1]= skills;

            for (int j = 0; j < 7; j++) {
                row2[j] = hours[i][j];
            }
            tableModel.addRow(row);
            tableModel2.addRow(row2);

        } catch (SQLException ex) {
            Logger.getLogger(ActivityVerificationDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        sendButton.setEnabled(false);
    }
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        int i = hoursTable.getSelectedColumn();
        try {
            MaintenanceActivity activity = planner.getScheduledActivityFromId(id);
            int minutesAvailable = (Integer) tableModel2.getValueAt(0, i);
            if(minutesAvailable < activity.getEstimatedInterventionTime()) {
                throw new TimeExceededException("Impossible to assign activity at this time!");
            }
            planner.assignActivity(username, id, day, getDayHour(i), activity.getEstimatedInterventionTime(), minutesAvailable, i);
            JOptionPane.showMessageDialog(rootPane, "Activity Successfully Assigned");
            this.setVisible(false);

        } catch (SQLException | TimeExceededException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_sendButtonActionPerformed

    private void hoursTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hoursTableMouseClicked

        int i = hoursTable.getSelectedColumn();
        float num = Float.parseFloat(tableModel2.getValueAt(0, i).toString());
        num = (int) (num / 60 * 100);
        percentageLabel.setVisible(true);
        percentageLabel.setText("" + num + "%");
        sendButton.setEnabled(true);

    }//GEN-LAST:event_hoursTableMouseClicked

    private int getDayHour(int column) {
        if (column == 0) {
            return 8;
        } else if (column == 1) {
            return 9;
        } else if (column == 2) {
            return 10;
        } else if (column == 3) {
            return 11;
        } else if (column == 4) {
            return 14;
        } else if (column == 5) {
            return 15;
        } else {
            return 16;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityLabel;
    private javax.swing.JLabel activityToAssignLabel;
    private javax.swing.JLabel availabilityLabel;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTable hoursTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable maintainerTable;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel percentageLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JLabel weekNumberLabel;
    // End of variables declaration//GEN-END:variables
}
