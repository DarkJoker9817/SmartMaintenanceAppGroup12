/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import businesslogic.MaintenanceType;
import businesslogic.Planner;
import java.time.LocalDate;
import java.time.temporal.*;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Egidio
 */
public class PlannerGUI extends javax.swing.JFrame {

    /**
     * Creates new form PlannerGUI
     */
    private Planner planner;
    private DefaultTableModel model;

    public PlannerGUI() {
        initComponents();
        planner = new Planner("pippo", "pippo");
        model = (DefaultTableModel) maintenanceTable.getModel();
        setCurrentWeek();
        fillTable();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        procedureLabel = new javax.swing.JLabel();
        interruptibleCheckBox = new javax.swing.JCheckBox();
        typeComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        procedureTextArea = new javax.swing.JTextArea();
        weekTextField = new javax.swing.JTextField();
        siteTextField = new javax.swing.JTextField();
        timeTextField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        materialsLabel = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        siteLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        createButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        materialsTextField = new javax.swing.JTextField();
        interruptibleLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planner");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        procedureLabel.setForeground(new java.awt.Color(0, 0, 0));
        procedureLabel.setText("Procedure");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mechanical", "Electronic", "Electrical", "Hydraulic" }));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(descriptionTextArea);

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane3.setViewportView(notesTextArea);

        procedureTextArea.setColumns(20);
        procedureTextArea.setRows(5);
        procedureTextArea.setBorder(null);
        jScrollPane4.setViewportView(procedureTextArea);

        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID");

        materialsLabel.setForeground(new java.awt.Color(0, 0, 0));
        materialsLabel.setText("materials");

        weekLabel.setForeground(new java.awt.Color(0, 0, 0));
        weekLabel.setText("week");

        siteLabel.setForeground(new java.awt.Color(0, 0, 0));
        siteLabel.setText("site");

        typeLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeLabel.setText("type");

        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Description");

        timeLabel.setForeground(new java.awt.Color(0, 0, 0));
        timeLabel.setText("time (min)");

        maintenanceTable.setBackground(new java.awt.Color(255, 255, 255));
        maintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "materials", "week", "site", "type", "description", "time", "interruptible", "notes", "procedure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        maintenanceTable.setGridColor(new java.awt.Color(255, 255, 255));
        maintenanceTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        maintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(maintenanceTable);

        createButton.setText("create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        interruptibleLabel.setForeground(new java.awt.Color(0, 0, 0));
        interruptibleLabel.setText("interruptible");

        notesLabel.setForeground(new java.awt.Color(0, 0, 0));
        notesLabel.setText("Notes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idLabel)
                            .addComponent(siteLabel)
                            .addComponent(timeLabel)
                            .addComponent(typeLabel)
                            .addComponent(interruptibleLabel)
                            .addComponent(materialsLabel)
                            .addComponent(weekLabel))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(weekTextField)
                                    .addComponent(materialsTextField)
                                    .addComponent(siteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(interruptibleCheckBox)
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(notesLabel)
                            .addComponent(descriptionLabel)
                            .addComponent(procedureLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(jScrollPane4)
                                .addComponent(jScrollPane2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(createButton)
                    .addComponent(updateButton))
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weekLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materialsLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siteLabel))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interruptibleCheckBox)
                    .addComponent(interruptibleLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notesLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procedureLabel))
                .addContainerGap(121, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jTabbedPane1.addTab("Activity Management", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceTableMouseClicked
        enableButtons();
        fillForm();
    }//GEN-LAST:event_maintenanceTableMouseClicked

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        MaintenanceType type = getComboBoxType();
        try {
            if (planner.createActivity(Integer.parseInt(idTextField.getText()), null, Integer.parseInt(weekTextField.getText()), null, type, descriptionTextArea.getText(), Integer.parseInt(timeTextField.getText()), interruptibleCheckBox.isSelected(), notesTextArea.getText(), null) == null) {
                addTableRow();
            } else {
                JOptionPane.showMessageDialog(this, "Activity ID already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
        disableButtons();
        maintenanceTable.clearSelection();

    }//GEN-LAST:event_createButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int i = maintenanceTable.getSelectedRow();
        Integer id = (Integer) model.getValueAt(i, 0);

        model.removeRow(i);
        planner.deleteActivity(id);

        disableButtons();
        clearFields();
        maintenanceTable.clearSelection();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        disableButtons();
    }//GEN-LAST:event_formWindowActivated

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int i = maintenanceTable.getSelectedRow();
        Integer id = (Integer) model.getValueAt(i, 0);
        MaintenanceType type = getComboBoxType();
        try {
            if (planner.modifyActivity(id, null, Integer.parseInt(weekTextField.getText()), null, type, descriptionTextArea.getText(), Integer.parseInt(timeTextField.getText()), interruptibleCheckBox.isSelected(), notesTextArea.getText(), null) != null) {
                modifyTableRow(i);
            } else {
                JOptionPane.showMessageDialog(this, "Activity ID not found!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
        disableButtons();
        maintenanceTable.clearSelection();
    }//GEN-LAST:event_updateButtonActionPerformed

    private MaintenanceType getComboBoxType() {
        if (typeComboBox.getSelectedItem() == "Mechanical") {
            return MaintenanceType.MECHANICAL;
        } else if (typeComboBox.getSelectedItem() == "Electronic") {
            return MaintenanceType.ELECTRONIC;
        } else if (typeComboBox.getSelectedItem() == "Electrical") {
            return MaintenanceType.ELECTRICAL;
        }
        return MaintenanceType.HYDRAULIC;
    }

    private void setComboBoxType(String type) {
        if ("MECHANICAL".equals(type)) {
            typeComboBox.setSelectedItem("Mechanical");
        } else if ("ELECTRONIC".equals(type)) {
            typeComboBox.setSelectedItem("Electronic");
        } else if ("ELECTRICAL".equals(type)) {
            typeComboBox.setSelectedItem("Electrical");
        } else {
            typeComboBox.setSelectedItem("Hydraulic");
        }
    }

    private void addTableRow() {
        Object[] row = new Object[10];
        row[0] = Integer.parseInt(idTextField.getText());
        row[1] = null;
        row[2] = Integer.parseInt(weekTextField.getText());
        row[3] = null;
        row[4] = getComboBoxType();
        row[5] = descriptionTextArea.getText();
        row[6] = Integer.parseInt(timeTextField.getText());
        row[7] = interruptibleCheckBox.isSelected();
        row[8] = notesTextArea.getText();
        row[9] = null;
        model.addRow(row);
    }

    private void modifyTableRow(int i) {
        model.setValueAt(Integer.parseInt(weekTextField.getText()), i, 2);
        model.setValueAt(getComboBoxType(), i, 4);
        model.setValueAt(descriptionTextArea.getText(), i, 5);
        model.setValueAt(Integer.parseInt(timeTextField.getText()), i, 6);
        model.setValueAt(interruptibleCheckBox.isSelected(), i, 7);
        model.setValueAt(notesTextArea.getText(), i, 8);
    }

    private void enableCreateButton() {
        if (createButton.isEnabled()) {
            createButton.setEnabled(false);
        } else {
            createButton.setEnabled(true);
        }
    }

    private void disableButtons() {
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void enableButtons() {
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    private void clearFields() {
        idTextField.setText("");
        materialsTextField.setText("");
        siteTextField.setText("");
        weekTextField.setText("");
        timeTextField.setText("");
        notesTextArea.setText("");
        descriptionTextArea.setText("");
        procedureTextArea.setText("");
        interruptibleCheckBox.setSelected(false);
    }

    private void fillTable() {
        planner.createActivity(1, null, 34, null, MaintenanceType.ELECTRICAL, "Replacement of robot 23 welding cables", 90, true, "The plant is closed on 00/00/00", null);
        planner.createActivity(2, null, 36, null, MaintenanceType.HYDRAULIC, "Replacement of pipe", 60, false, "The plant is closed on 00/00/00", null);
        planner.getScheduledActivity();
        Object[] row1 = new Object[10];
        row1[0] = planner.getScheduledActivity().get(1).getId();
        row1[1] = planner.getScheduledActivity().get(1).getMaterials();
        row1[2] = planner.getScheduledActivity().get(1).getWeek();
        row1[3] = null;
        row1[4] = planner.getScheduledActivity().get(1).getType();
        row1[5] = planner.getScheduledActivity().get(1).getDescription();
        row1[6] = planner.getScheduledActivity().get(1).getEstimatedInterventionTime();
        row1[7] = planner.getScheduledActivity().get(1).isInterruptible();
        row1[8] = planner.getScheduledActivity().get(1).getWorkspaceNotes();
        row1[9] = null;
        model.addRow(row1);
        Object[] row2 = new Object[10];
        row2[0] = planner.getScheduledActivity().get(2).getId();
        row2[1] = planner.getScheduledActivity().get(2).getMaterials();
        row2[2] = planner.getScheduledActivity().get(2).getWeek();
        row2[3] = null;
        row2[4] = planner.getScheduledActivity().get(2).getType();
        row2[5] = planner.getScheduledActivity().get(2).getDescription();
        row2[6] = planner.getScheduledActivity().get(2).getEstimatedInterventionTime();
        row2[7] = planner.getScheduledActivity().get(2).isInterruptible();
        row2[8] = planner.getScheduledActivity().get(2).getWorkspaceNotes();
        row2[9] = null;
        model.addRow(row2);

    }

    private void setCurrentWeek() {
        LocalDate date = LocalDate.now();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = date.get(woy);
        System.out.println(weekNumber);
    }

    private void fillForm() {
        int i = maintenanceTable.getSelectedRow();
        Integer id = (Integer) model.getValueAt(i, 0);
        String materials = (String) model.getValueAt(i, 1);
        Integer week = (Integer) model.getValueAt(i, 2);
        String site = (String) model.getValueAt(i, 3);
        String type = String.valueOf(model.getValueAt(i, 4));
        String description = (String) model.getValueAt(i, 5);
        Integer time = (Integer) model.getValueAt(i, 6);
        Boolean interruptible = (Boolean) model.getValueAt(i, 7);
        String notes = (String) model.getValueAt(i, 8);
        String procedure = (String) model.getValueAt(i, 9);

        idTextField.setText(String.valueOf(id));
        materialsTextField.setText(materials);
        weekTextField.setText(String.valueOf(week));
        siteTextField.setText(site);
        setComboBoxType(type);
        descriptionTextArea.setText(description);
        timeTextField.setText(String.valueOf(time));
        interruptibleCheckBox.setSelected(interruptible);
        notesTextArea.setText(notes);
        procedureTextArea.setText(procedure);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlannerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlannerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JCheckBox interruptibleCheckBox;
    private javax.swing.JLabel interruptibleLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable maintenanceTable;
    private javax.swing.JLabel materialsLabel;
    private javax.swing.JTextField materialsTextField;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel procedureLabel;
    private javax.swing.JTextArea procedureTextArea;
    private javax.swing.JLabel siteLabel;
    private javax.swing.JTextField siteTextField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JTextField weekTextField;
    // End of variables declaration//GEN-END:variables
}
