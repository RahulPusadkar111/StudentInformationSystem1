/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package studentinformationsystem1;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class NewCertificateDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewCertificateDialog
     */
    public NewCertificateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ImageIcon icon1=new ImageIcon("C:\\Users\\Hp\\Documents\\HTML AND CSS 10 Project\\PROJECT3\\images\\image1.png");
        Image img=icon1.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        jLabel9.setIcon(icon2);
        jTextField1.setText(""+getNextCertificateId());
        showStudentId();
        showCertificationStudents();
    }
    void showCertificationStudents()
    {
         String columnnames[]={"StudentName","CertificateNumber","StudentId"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnnames);
        jTable1.setModel(model);
        String name,cernum ,sid;
        name ="";
        cernum="";
         sid="";
        try{ 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
      
        Statement st = con.createStatement();
        String sql ="SELECT master.Name,certification.Certification_number,Master.Id FROM elit_students.master INNER JOIN elit_students.certification WHERE master.Id=certification.Id ORDER BY Certification_number ;";
        
        ResultSet rs =st.executeQuery(sql);
        while(rs.next())
        {
            name = rs.getString(1);
            cernum=rs.getString(2);
            sid=rs.getString(3);
            model.addRow(new Object[] {name,cernum,sid});
        }
        
       
        }
        catch(SQLException e)
        {
           jLabel7.setText("ERROR :"+ e);
        }
    }
    int getNextCertificateId()
    {  
        int ncer_id=0;
        try{ 
           
            
            
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
        Statement st = con.createStatement();
        String sql="SELECT * FROM elit_students.certification ORDER BY Certification_number DESC;";
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next())
        {
            ncer_id =rs.getInt(1);
        }   
        
        }
        catch(SQLException e)
        {
           jLabel4.setText("ERROR :"+ e);
        }  
        return ncer_id+1;
    }
    void showStudentId()
    {
        try{ 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
        
        Statement st = con.createStatement();
        String sql1 = "SELECT Id FROM elit_students.master ";
        ResultSet rs1 = st.executeQuery(sql1);
        
       
        while(rs1.next())
        {         
           jComboBox1.addItem(rs1.getString(1));          
        }       
        }
        catch(SQLException e)
       {
           jLabel7.setText("ERROR :"+ e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cerificate Information");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 52, 192));
        jLabel1.setText("CERTIFICATE NO");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 91, 130, -1));

        jLabel2.setBackground(new java.awt.Color(0, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 52, 192));
        jLabel2.setText("Student Name");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 120, -1));

        jLabel3.setBackground(new java.awt.Color(0, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 52, 192));
        jLabel3.setText("Student Id");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 84, -1));

        jLabel4.setBackground(new java.awt.Color(0, 255, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 52, 192));
        jLabel4.setText("Fees Paid");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 247, 84, -1));

        jLabel5.setBackground(new java.awt.Color(0, 255, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 52, 192));
        jLabel5.setText("Course Fees");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 298, 90, -1));

        jLabel6.setBackground(new java.awt.Color(0, 255, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 52, 192));
        jLabel6.setText("Issue Date");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 344, 74, -1));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 88, 109, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 192, 200, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 244, 120, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 295, 130, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 136, 154, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 390, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 390, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 900, 30));

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        getContentPane().add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 341, 126, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 0, 51));
        jButton3.setText("Show");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 255), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 136, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "StudentsName", "Certificate Number", "studentid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 295, 290, 278));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("STUDENTS THOSE HAVE CERITIFICATE CREATED");
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 232, 320, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hp\\Documents\\HTML AND CSS 10 Project\\PROJECT3\\images\\image1.png")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try{ 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
        String selectedValue=jComboBox1.getSelectedItem().toString();
        int id=Integer.parseInt(selectedValue);
        String sql = "SELECT master.Name, master.Fees FROM elit_students.master  WHERE  master.Id='"+id+"';";
        Statement st = con.createStatement();
        
        
        ResultSet rs =st.executeQuery(sql);
       
        
          if(rs.next())
          {
            
            jTextField2.setText(rs.getString(1));
            jTextField4.setText(rs.getString(2));
            
            
          }
          
        
        
       
        }
           
        catch(SQLException e)
        {
           jLabel7.setText("ERROR :"+ e);
        }
          try{ 
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
           String selectedValue=jComboBox1.getSelectedItem().toString();
           int id=Integer.parseInt(selectedValue);
           String sql = "SELECT SUM(Amount) FROM elit_students.fees_collection WHERE fees_collection.Id="+id+";";
           Statement st = con.createStatement();
        
        
           ResultSet rs =st.executeQuery(sql);
       
        int feepaid=0;
          if(rs.next())
          {
            
            feepaid=rs.getInt(1);
          } 
          jTextField3.setText(""+feepaid);
          
       
        }
        catch(SQLException e)
        {
           jLabel7.setText("ERROR :"+ e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{ 
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root/elit_students","root","Rahul@123456");
           int coursefees,feespaid;
           String sql,date;
           coursefees=Integer.parseInt(jTextField4.getText());
           feespaid=Integer.parseInt(jTextField3.getText());
           String selectedValue=jComboBox1.getSelectedItem().toString();
           int id=Integer.parseInt(selectedValue);
           date=jFormattedTextField1.getText();
           sql = "INSERT INTO elit_students.certification (Id,Issue_date) VALUES ("+id+",'"+date+"');";
           Statement st = con.createStatement();
           if(feespaid==coursefees)
           {
               st.executeUpdate(sql);
               jLabel7.setText("CERTIFICATE CREATED");
               jTextField1.setText(""+getNextCertificateId());
               jTextField2.setText("");
               jTextField3.setText("");
               jTextField4.setText("");
               jFormattedTextField1.setText("");
               showCertificationStudents();
               
           }
           else
           {
               jLabel7.setText("Cant Give Certificate Fees Not Completed");
           }

        }
        catch(SQLException e)
        {
           jLabel7.setText("ERROR :"+ e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewCertificateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCertificateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCertificateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCertificateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewCertificateDialog dialog = new NewCertificateDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
