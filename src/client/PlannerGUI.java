/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import businesslogic.MaintenanceType;
import businesslogic.Planner;
import database.Repository;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.*;
import java.util.*;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
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
    private DefaultListModel listModel;
    private ComboBoxModel<String> comboBoxModel;
    private ComboBoxModel<String> siteModel;
    private Repository rep;
    
    public PlannerGUI() {
        initComponents();
        planner = new Planner("pippo", "pippo");
        rep = new Repository();
        listModel = new DefaultListModel();
        setAttributes();
        fillTable();
        fillMaterialTable();
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
        interruptibleLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        weekComboBox = new javax.swing.JComboBox<>();
        siteComboBox = new javax.swing.JComboBox<>();
        uploadButton = new javax.swing.JButton();
        fileLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        materialList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        materialTable = new javax.swing.JTable();
        removeMaterialButton = new javax.swing.JButton();
        addMaterialButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planner");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        procedureLabel.setText("Procedure");

        interruptibleCheckBox.setBackground(new java.awt.Color(255, 255, 255));

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mechanical", "Electronic", "Electrical", "Hydraulic" }));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(descriptionTextArea);

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane3.setViewportView(notesTextArea);

        idLabel.setText("ID");

        materialsLabel.setText("materials");

        weekLabel.setText("week");

        siteLabel.setText("site");

        typeLabel.setText("type");

        descriptionLabel.setText("Description");

        timeLabel.setText("time (min)");

        maintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "materials", "week", "site", "type", "description", "time", "interruptible", "notes", "procedure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
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
        maintenanceTable.getTableHeader().setReorderingAllowed(false);
        maintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(maintenanceTable);

        createButton.setBackground(new java.awt.Color(255, 255, 255));
        createButton.setText("create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setText("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        interruptibleLabel.setText("interruptible");

        notesLabel.setText("Notes");

        weekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        uploadButton.setBackground(new java.awt.Color(255, 255, 255));
        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        fileLabel.setForeground(new java.awt.Color(0, 0, 0));
        fileLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        materialList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(materialList);

        materialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        materialTable.setGridColor(new java.awt.Color(255, 255, 255));
        materialTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        materialTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(materialTable);

        removeMaterialButton.setBackground(new java.awt.Color(255, 255, 255));
        removeMaterialButton.setText("Remove material");
        removeMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMaterialButtonActionPerformed(evt);
            }
        });

        addMaterialButton.setBackground(new java.awt.Color(255, 255, 255));
        addMaterialButton.setText("Add material");
        addMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMaterialButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(timeLabel)
                                    .addComponent(typeLabel))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(siteLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(interruptibleLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeTextField)
                            .addComponent(siteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(interruptibleCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(notesLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(procedureLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(fileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(uploadButton)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(weekLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeMaterialButton))
                            .addComponent(materialsLabel))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addMaterialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 427, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weekLabel)
                            .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siteLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLabel)
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeLabel))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(interruptibleCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(interruptibleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notesLabel)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(fileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(procedureLabel)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton)
                            .addComponent(deleteButton)
                            .addComponent(updateButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(materialsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeMaterialButton)
                            .addComponent(addMaterialButton))))
                .addGap(183, 183, 183))
        );

        jTabbedPane1.addTab("Activity Management", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setAttributes() {
        model = (DefaultTableModel) maintenanceTable.getModel();
        weekComboBox.setModel(setFromCurrentWeek());
        materialList.setModel(listModel);
        comboBoxModel = setFromCurrentWeek();
        siteModel = new DefaultComboBoxModel(setSiteComboBox());
        siteComboBox.setModel(siteModel);
    }
    
    private Object[] setSiteComboBox() {
        List<Object> row = new ArrayList<>();
        try {
            ResultSet res = rep.select("select * from site");
            while (res.next()) {
                row.add(res.getString("area") + " - " + res.getString("branch_officies"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return row.toArray();
    }
    
    private void fillMaterialTable() {
        DefaultTableModel model = (DefaultTableModel) materialTable.getModel();
        Object row[] = new Object[1];
        try {
            ResultSet res = rep.select("select * from material");
            while (res.next()) {
                row[0] = res.getString("name_material");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void maintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenanceTableMouseClicked
        enableButtons();
        fillForm();
    }//GEN-LAST:event_maintenanceTableMouseClicked
    
    private String getArrayMaterial() {
        String materials = "{";
        for (int i = 0; i < listModel.getSize(); i++) {
            materials += (listModel.getElementAt(i).toString() + (i == listModel.getSize() - 1 ? "" : ","));
        }
        materials += "}";
        return materials;
    }
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        MaintenanceType type = getComboBoxType();
        String materials = getArrayMaterial();
        try {
            rep.insert("insert into activity(materials,week,site,maintenance_type,activity_type,description,estimated_time,interruptible,workspace_notes,maintenance_procedure)"
                    + "values('" + materials + "','" + Integer.parseInt((String) weekComboBox.getSelectedItem()) + "','" + siteComboBox.getSelectedItem() + "','" + type.toString() + "','" + "Planned" + "','"
                    + descriptionTextArea.getText() + "','" + Integer.parseInt(timeTextField.getText()) + "','" + interruptibleCheckBox.isSelected() + "','" + notesTextArea.getText() + "','" + fileLabel.getText() + "');");
            addTableRow();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            if (planner.modifyActivity(id, null, Integer.parseInt((String) weekComboBox.getSelectedItem()), null, type, descriptionTextArea.getText(), Integer.parseInt(timeTextField.getText()), interruptibleCheckBox.isSelected(), notesTextArea.getText(), null) != null) {
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

    private void addMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMaterialButtonActionPerformed
        // TODO add your handling code here:
        if (materialTable.getSelectedRow() == -1) {
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) materialTable.getModel();
        
        listModel.addElement(tableModel.getValueAt(materialTable.getSelectedRow(), 0));
        materialTable.clearSelection();
    }//GEN-LAST:event_addMaterialButtonActionPerformed

    private void removeMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMaterialButtonActionPerformed
        // TODO add your handling code here:
        if (materialList.getSelectedIndex() == -1) {
            return;
        }
        listModel.remove(materialList.getSelectedIndex());
        materialList.clearSelection();
    }//GEN-LAST:event_removeMaterialButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./src/maintenanceprocedure"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileLabel.setText(selectedFile.getName() + ".pdf");
        }

    }//GEN-LAST:event_uploadButtonActionPerformed
    
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
        row[2] = Integer.parseInt((String) weekComboBox.getSelectedItem());
        row[3] = siteComboBox.getSelectedItem();
        row[4] = getComboBoxType();
        row[5] = descriptionTextArea.getText();
        row[6] = Integer.parseInt(timeTextField.getText());
        row[7] = interruptibleCheckBox.isSelected();
        row[8] = notesTextArea.getText();
        row[9] = fileLabel.getText();
        model.addRow(row);
    }
    
    private void modifyTableRow(int i) {
        model.setValueAt(Integer.parseInt((String) weekComboBox.getSelectedItem()), i, 2);
        model.setValueAt(siteComboBox.getSelectedItem(), i, 3);
        model.setValueAt(getComboBoxType(), i, 4);
        model.setValueAt(descriptionTextArea.getText(), i, 5);
        model.setValueAt(Integer.parseInt(timeTextField.getText()), i, 6);
        model.setValueAt(interruptibleCheckBox.isSelected(), i, 7);
        model.setValueAt(notesTextArea.getText(), i, 8);
        model.setValueAt(fileLabel.getText(), i, 9);
        
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
        timeTextField.setText("");
        notesTextArea.setText("");
        descriptionTextArea.setText("");
        fileLabel.setText("");
        interruptibleCheckBox.setSelected(false);
    }
    
    private void fillTable() {
        
    }
    
    private DefaultComboBoxModel<String> setFromCurrentWeek() {
        LocalDate date = LocalDate.now();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = date.get(woy);
        int i = 0;
        String[] weekStr = new String[53 - weekNumber];
        for (int week = weekNumber; week < 53; week++) {
            weekStr[i] = week + "";
            i++;
        }
        return new DefaultComboBoxModel(weekStr);
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
        weekComboBox.setSelectedItem(String.valueOf(week));
        siteComboBox.setSelectedItem(site);
        
        setComboBoxType(type);
        descriptionTextArea.setText(description);
        timeTextField.setText(String.valueOf(time));
        interruptibleCheckBox.setSelected(interruptible);
        notesTextArea.setText(notes);
        fileLabel.setText(procedure);
        disableNotEditableFields();
    }
    
    public void disableNotEditableFields() {
        idTextField.setEnabled(false);
        weekComboBox.setEnabled(false);
        siteComboBox.setEnabled(false);
        descriptionTextArea.setEnabled(false);
        timeTextField.setEnabled(false);
        interruptibleCheckBox.setEnabled(false);
        uploadButton.setEnabled(false);
        typeComboBox.setEnabled(false);
        addMaterialButton.setEnabled(false);
        removeMaterialButton.setEnabled(false);
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
    private javax.swing.JButton addMaterialButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel fileLabel;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable maintenanceTable;
    private javax.swing.JList<String> materialList;
    private javax.swing.JTable materialTable;
    private javax.swing.JLabel materialsLabel;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel procedureLabel;
    private javax.swing.JButton removeMaterialButton;
    private javax.swing.JComboBox<String> siteComboBox;
    private javax.swing.JLabel siteLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton uploadButton;
    private javax.swing.JComboBox<String> weekComboBox;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables
}
