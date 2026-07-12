package perpustakaan.form;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import perpustakaan.form.nota;
import koneksi.koneksi;

public class popupbuku extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public nota buku = null;
    
    public popupbuku() {
        initComponents();
        datatable();
    }

protected void datatable(){
    Object[] Baris = {"Kode Buku","ISBN","Judul Buku","Penulis","Penerbit","Tahun Terbit","Kategori","Stok Buku"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari2.getText();
    
    try {
        String sql = "SELECT * FROM buku where id_buku like '%"+cariitem+"%' or judul like '%"+cariitem+"%' order by id_buku asc";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            tabmode.addRow(new Object[]{
                hasil.getString(1),
                hasil.getString(2),
                hasil.getString(3),
                hasil.getString(4),
                hasil.getString(5),
                hasil.getString(6),
                hasil.getString(7),
                hasil.getString(8),
            });
        }
        tabelbk.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtcari2 = new javax.swing.JTextField();
        bcari2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelbk = new javax.swing.JTable();
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

        bcari2.setText("Cari");
        bcari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari2ActionPerformed(evt);
            }
        });

        tabelbk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbk.setGridColor(new java.awt.Color(0, 0, 0));
        tabelbk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbkMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelbk);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Buku Perpustakaan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcari2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcari2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(404, 404, 404)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(bcari2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcari2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcari2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcari2KeyPressed

    private void bcari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari2ActionPerformed
        datatable();
    }//GEN-LAST:event_bcari2ActionPerformed

    private void tabelbkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbkMouseClicked
        int tabelBuku = tabelbk.getSelectedRow();
        buku.kdbk = tabelbk.getValueAt(tabelBuku, 0).toString();
        buku.isbn = tabelbk.getValueAt(tabelBuku, 1).toString();
        buku.judul = tabelbk.getValueAt(tabelBuku, 2).toString();
        buku.penulis = tabelbk.getValueAt(tabelBuku, 3).toString();
        buku.penerbit = tabelbk.getValueAt(tabelBuku, 4).toString();
        buku.tahun = tabelbk.getValueAt(tabelBuku, 5).toString();
        buku.kategori = tabelbk.getValueAt(tabelBuku, 6).toString();
        buku.stok = tabelbk.getValueAt(tabelBuku, 7).toString();
        buku.itemTerpilihBuku();
        this.dispose();
    }//GEN-LAST:event_tabelbkMouseClicked

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
            java.util.logging.Logger.getLogger(popupbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popupbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popupbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popupbuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popupbuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelbk;
    private javax.swing.JTextField txtcari2;
    // End of variables declaration//GEN-END:variables
}
