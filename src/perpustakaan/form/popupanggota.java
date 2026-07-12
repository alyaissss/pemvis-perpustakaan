package perpustakaan.form;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import perpustakaan.form.nota;
import koneksi.koneksi;

public class popupanggota extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public nota anggota = null;
    public popupanggota() {
        initComponents();
        datatable();
    }

protected void datatable(){
    Object[] Baris = {"ID Anggota","Nama","Jenis Kelamin","Kelas","Tanggal Registrasi"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari2.getText();
    
    try {
        String sql = "SELECT * FROM anggota where id_anggota like '%"+cariitem+"%' or nama_anggota like '%"+cariitem+"%' order by id_anggota asc";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            tabmode.addRow(new Object[]{
                hasil.getString(1),
                hasil.getString(2),
                hasil.getString(3),
                hasil.getString(4),
                hasil.getString(5),
            });
        }
        tabelanggota.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtcari2 = new javax.swing.JTextField();
        bcarib = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelanggota = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 128, 214));

        txtcari2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtcari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcari2ActionPerformed(evt);
            }
        });
        txtcari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcari2KeyPressed(evt);
            }
        });

        bcarib.setText("Cari");
        bcarib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribActionPerformed(evt);
            }
        });

        tabelanggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelanggota.setGridColor(new java.awt.Color(0, 0, 0));
        tabelanggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelanggotaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelanggota);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Anggota Perpustakaan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtcari2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcarib, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcarib)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcari2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcari2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcari2KeyPressed

    private void bcaribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribActionPerformed
        datatable();
    }//GEN-LAST:event_bcaribActionPerformed

    private void tabelanggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelanggotaMouseClicked
        int tabelAnggota = tabelanggota.getSelectedRow();
        anggota.id = tabelanggota.getValueAt(tabelAnggota, 0).toString();
        anggota.nama = tabelanggota.getValueAt(tabelAnggota, 1).toString();
        anggota.jk = tabelanggota.getValueAt(tabelAnggota, 2).toString();
        anggota.kelas = tabelanggota.getValueAt(tabelAnggota, 3).toString();
        anggota.tgl_registrasi = tabelanggota.getValueAt(tabelAnggota, 4).toString();
        anggota.itemTerpilih();
        this.dispose();
    }//GEN-LAST:event_tabelanggotaMouseClicked

    private void txtcari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcari2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcari2ActionPerformed

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
            java.util.logging.Logger.getLogger(popupanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popupanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popupanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popupanggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popupanggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcarib;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelanggota;
    private javax.swing.JTextField txtcari2;
    // End of variables declaration//GEN-END:variables
}
