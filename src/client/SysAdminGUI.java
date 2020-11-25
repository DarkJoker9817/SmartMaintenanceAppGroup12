/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import database.Repository;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gioca
 */
public class SysAdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form SysAdminGUI
     */
    private DefaultTableModel model;
    Repository repository;
    
    public SysAdminGUI() {
        initComponents();
        
        repository = new Repository();
        model = new DefaultTableModel();
        Object[] columns = {"Username","Password","Role"};
        model.setColumnIdentifiers(columns);
        usersTable.setModel(model);
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

        usersManagementTabbedPane = new javax.swing.JTabbedPane();
        CrudOperationsTab = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Administrator");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                SysAdminGUI.this.windowActivated(evt);
            }
        });

        Title.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        Title.setText("System Administrator Area");

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        roleLabel.setText("Role");

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maintainer", "Planner" }));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password");

        usernameLabel.setText("Username");

        javax.swing.GroupLayout CrudOperationsTabLayout = new javax.swing.GroupLayout(CrudOperationsTab);
        CrudOperationsTab.setLayout(CrudOperationsTabLayout);
        CrudOperationsTabLayout.setHorizontalGroup(
            CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudOperationsTabLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameLabel)
                    .addComponent(createButton)
                    .addComponent(passwordLabel)
                    .addComponent(roleLabel))
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrudOperationsTabLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrudOperationsTabLayout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrudOperationsTabLayout.createSequentialGroup()
                        .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(251, 251, 251))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrudOperationsTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        CrudOperationsTabLayout.setVerticalGroup(
            CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudOperationsTabLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(18, 18, 18)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleLabel)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(CrudOperationsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        usersManagementTabbedPane.addTab("Users Management", CrudOperationsTab);
        usersManagementTabbedPane.addTab("tab2", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usersManagementTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersManagementTabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        Object[] row = new Object[3];
        row[0] = usernameTextField.getText();
        row[1] = passwordTextField.getText();
        row[2] = roleComboBox.getSelectedItem();
        
        if (usernameTextField.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insert an username", "INSERT ERROR", JOptionPane.ERROR_MESSAGE);
        else if (passwordTextField.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Insert a password", "INSERT ERROR", JOptionPane.ERROR_MESSAGE);
        else
            try {
                repository.insert("insert into \"user\"(username, password, role) values('" + row[0] + "','" + row[1] + "','" + row[2] + "')");
                model.addRow(row);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Username already exists!!", "INSERT ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
    }//GEN-LAST:event_createButtonActionPerformed
                                           
    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int i = usersTable.getSelectedRow();
        String username = (String)model.getValueAt(i, 0);
        
        Object[] row = new Object[3];
        row[0] = usernameTextField.getText();
        row[1] = passwordTextField.getText();
        row[2] = (String)roleComboBox.getSelectedItem();
        
        try {
            repository.update("update \"user\" set username='" + row[0] + "', password='" + row[1] + "', role='" + row[2] + "' where username='" + username + "'");
            model.removeRow(i);
            model.addRow(row);
            
        } catch (SQLException ex) {
            Logger.getLogger(SysAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        disableButtons();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void windowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowActivated
        disableButtons();
    }//GEN-LAST:event_windowActivated

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        enableButtons();
        
        int i = usersTable.getSelectedRow();
        String username = (String)model.getValueAt(i, 0);
        String password = (String)model.getValueAt(i, 1);
        String role = (String)model.getValueAt(i, 2);
        usernameTextField.setText(username);
        passwordTextField.setText(password);
        ComboBoxModel<String> comboBoxModel = roleComboBox.getModel();
        comboBoxModel.setSelectedItem(role);
        
    }//GEN-LAST:event_usersTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        int i = usersTable.getSelectedRow();
        String username = (String)model.getValueAt(i, 0);
        
        model.removeRow(i);
        
        try {
            repository.delete("delete from \"user\" where username='" + username + "'");
        } catch (SQLException ex) {
            Logger.getLogger(SysAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        disableButtons();
    }
    
    private void fillTable() {
        Object[] row = new Object[3];
        
        try {
            ResultSet res= repository.select("select * from \"user\"; ");
            while (res.next()) {
                row[0] = res.getString("username");
                row[1] = res.getString("password");
                row[2] = res.getString("role");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SysAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SysAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SysAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SysAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SysAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SysAdminGUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CrudOperationsTab;
    private javax.swing.JLabel Title;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTabbedPane usersManagementTabbedPane;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
