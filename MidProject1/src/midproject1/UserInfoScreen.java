/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package midproject1;

import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class UserInfoScreen extends javax.swing.JFrame {

    /**
     * Creates new form UserPanel
     */
    public UserInfoScreen() {
        initComponents();
        // Get the currently logged-in user
        User currentUser = User.currentUser;

        // Find the task assigned to the current user
        Task userTask = findUserTask(currentUser);
        // If no task is assigned, notify the user and close this screen
        if (userTask == null) {
            JOptionPane.showMessageDialog(this, "No task assigned to you.");
            this.setVisible(false);
            return;
        }

        // Find the project and team associated with the task
        Project project = findProjectByTask(userTask);
        Team team = ProjectManager.findTeamByUserAndProject(currentUser, project);

        // Display project and task details on the screen
        txtUsername.setText("Welcome " + currentUser.getUsername());
        txtProjectName.setText("Project name: " + project.getProjectName());
        txtDescription.setText("Description: " + project.getDescription());
        txtTeamName.setText("Your team: " + team.getTeamName());
        txtTask.setText("Your task: " + userTask.getTitle());

        // Format and show the task's due date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        txtDate.setText("Due date: " + userTask.getEndTime().format(formatter)); // Görevin bitiş tarihini gösteriyoruz 

        // If the task is already done, disable the status combo box
        if ("Done".equals(userTask.getStatus())) {
            jComboBox1.setEnabled(false);
            jComboBox1.setSelectedItem("Done");
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

        btnBack = new javax.swing.JButton();
        txtUsername = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JLabel();
        txtDescription = new javax.swing.JLabel();
        txtTask = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTeamName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUsername.setText("Welcome");

        txtProjectName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtProjectName.setText("Project name: ");

        txtDescription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDescription.setText("Description: ");

        txtTask.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTask.setText("Your task:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "In progress", "Not completed" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txtDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDate.setText("Due date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("User Info Screen");

        txtTeamName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTeamName.setText("Your team:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 236, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription)
                            .addComponent(txtProjectName)
                            .addComponent(txtTask)
                            .addComponent(txtUsername)
                            .addComponent(txtTeamName)
                            .addComponent(txtDate)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProjectName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescription)
                .addGap(12, 12, 12)
                .addComponent(txtTeamName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Back button event: return to the login screen
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    // Find the task assigned to the given user by searching all projects
    private Task findUserTask(User user) {
        for (Project project : ProjectManager.getAllProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getAssignedUser() != null && task.getAssignedUser().equals(user)) {
                    return task;
                }
            }
        }
        return null;
    }

    // Find the project associated with the given task
    private Project findProjectByTask(Task userTask) {
        for (Project project : ProjectManager.getAllProjects()) {
            if (project.getTasks().contains(userTask)) {
                return project;
            }
        }
        return null;
    }

    // Handle combo box status update
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Task userTask = findUserTask(User.currentUser);
        if (userTask != null) {
            String selectedStatus = (String) jComboBox1.getSelectedItem();

            // Prevent changing the status if it is already "Done"
            if ("Done".equals(userTask.getStatus())) {
                jComboBox1.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Task is already marked as Done. You cannot change it.");
                return;
            }

            // Update task status
            userTask.setStatus(selectedStatus);
            JOptionPane.showMessageDialog(null, "Task status updated: " + selectedStatus);

            // If marked as Done, disable the combo box
            if ("Done".equals(selectedStatus)) {
                jComboBox1.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No task was found assigned to you.");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (User.currentUser == null) {
                    JOptionPane.showMessageDialog(null, "No user logged in. Redirecting to login screen.");
                    new LoginScreen().setVisible(true);
                } else {
                    new UserInfoScreen().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JLabel txtProjectName;
    private javax.swing.JLabel txtTask;
    private javax.swing.JLabel txtTeamName;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
