/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rvkul
 */
public class Admin_view_regandbooking extends javax.swing.JFrame {

    /**
     * Creates new form view_re
     */
    public Admin_view_regandbooking() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        admin_id = new javax.swing.JTextField();
        admin_pass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View all Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(298, 159, 121, 25);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin ID ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(172, 24, 121, 40);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(172, 80, 101, 44);
        getContentPane().add(admin_id);
        admin_id.setBounds(298, 21, 185, 46);
        getContentPane().add(admin_pass);
        admin_pass.setBounds(298, 80, 185, 44);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\rvkul\\Documents\\NetBeansProjects\\myproj\\src\\myproj\\image\\java.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 650, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String id =admin_id.getText();
       String pass=admin_pass.getText();
  //     TableModel table1 = table.getModel();
         Connection con=null;
        PreparedStatement pst=null;
        ResultSet rst=null;
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","dbms1414");  
             
                 
//    query for insert data into table 

                  pst=con.prepareStatement("  Select id,password from admin where id=? and password=?");
                
            pst.setString(1,id);
            pst.setString(2,pass);
            
              rst= pst.executeQuery();
          if (rst.next()) 
					{
                        // new home().setVisible(true);
                        //this.setVisible(false);	
                        JOptionPane.showMessageDialog(null, "access granted");
                        new admin_table().setVisible(true);
                        this.setVisible(false);	
                    } 
         
          else 
					{
                        JOptionPane.showMessageDialog(null, "access denied");
                    }
				  
    
				  
			//new home().setVisible(true);
                        //this.setVisible(false);			
				
            
      // new reginfo().setVisible(true);

          // this.setVisible(false);     
}catch(Exception e){ System.out.println(e);}         
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_view_regandbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_view_regandbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_view_regandbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_view_regandbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_view_regandbooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admin_id;
    private javax.swing.JTextField admin_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
