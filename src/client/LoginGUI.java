/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JOptionPane;
import businesslogic.LoginValidate;
import businesslogic.SysAdminGUI;

/**
 *
 * @author ugobarbato
 */
public class LoginGUI extends javax.swing.JFrame {

    private SysAdminGUI admin;
    private PlannerGUI planner;
    private MaintainerGUI maintainer;

    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
        admin = new SysAdminGUI();
        planner = new PlannerGUI();
        maintainer = new MaintainerGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginGUI = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        ComboBoxUsers = new javax.swing.JComboBox<>();
        selectLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Maintenance App");
        setLocation(new java.awt.Point(300, 300));
        setResizable(false);

        LoginGUI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        titleLabel.setText("Smart Maintenance App Login");

        usernameLabel.setText("USERNAME");

        passwordLabel.setText("PASSWORD");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        ComboBoxUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "System Administrator", "Maintainer", "Planner" }));

        selectLabel.setText("LOGIN AS");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N

        javax.swing.GroupLayout LoginGUILayout = new javax.swing.GroupLayout(LoginGUI);
        LoginGUI.setLayout(LoginGUILayout);
        LoginGUILayout.setHorizontalGroup(
            LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginGUILayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginGUILayout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginGUILayout.createSequentialGroup()
                        .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(210, 210, 210))))
            .addGroup(LoginGUILayout.createSequentialGroup()
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginGUILayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel4))
                    .addGroup(LoginGUILayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(loginButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginGUILayout.setVerticalGroup(
            LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginGUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectLabel))
                .addGap(18, 18, 18)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(18, 18, 18)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:

        LoginValidate log = new LoginValidate();
        if (ComboBoxUsers.getSelectedItem().equals("System Administrator")) {
            if (!log.isValidSysAdmin(usernameTextField.getText(), passwordField.getText())) {
                JOptionPane.showMessageDialog(LoginGUI, "Wrong username or password", "Login", JOptionPane.ERROR_MESSAGE);
            } else {
                this.setVisible(false);
                admin.setLocationRelativeTo(this);
                admin.setVisible(true);
            }
        } else {
            if (ComboBoxUsers.getSelectedItem().equals("Planner")) {
                if (!log.isValidUser(usernameTextField.getText(), passwordField.getText(), "planner")) {
                    JOptionPane.showMessageDialog(LoginGUI, "Wrong username or password", "Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    this.setVisible(false);
                    planner.setLocationRelativeTo(this);
                    planner.setVisible(true);
                }
            } else {
                if (!log.isValidUser(usernameTextField.getText(), passwordField.getText(), "maintainer")) {
                    JOptionPane.showMessageDialog(LoginGUI, "Wrong username or password", "Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    this.setVisible(false);
                    planner.setLocationRelativeTo(this);
                    planner.setVisible(true);
                }
            }

        }


    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxUsers;
    private javax.swing.JPanel LoginGUI;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
