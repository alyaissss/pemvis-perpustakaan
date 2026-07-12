package perpustakaan.form;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import perpustakaan.form.UserSession;

public class master_anggota extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public master_anggota() {
        initComponents();
        kosong();
        aktif();
        datatable();
    }

//Method Aktif
protected void aktif(){
    txtid.requestFocus();
}

//Method Kosong
protected void kosong(){
    txtid.setText("");
    txtnm.setText("");
    cbkelas.setSelectedItem(null);
    stgl.setValue(new java.util.Date());
    buttonGroup1.clearSelection();
}

//Data Tabel dan Cari
protected void datatable(){
    Object[] Baris = {"ID Anggota","Nama","Jenis Kelamin","Kelas","Tanggal Registrasi"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari.getText();
    
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
    
public void cetak() {
    try {
        String path="./src/perpustakaan/form/reportAnggota.jasper";
        String petugasLogin = UserSession.getNamaPetugas();
        HashMap parameter = new HashMap();
        parameter.put("nama_petugas", petugasLogin);
        JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
        JasperViewer.viewReport(print, false);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        rpm = new javax.swing.JRadioButton();
        rlk = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbkelas = new javax.swing.JComboBox<>();
        stgl = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        bkembali = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelanggota = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bcetak = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 128, 214));
        jPanel1.setPreferredSize(new java.awt.Dimension(935, 450));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Anggota");

        txtid.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtnm.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        buttonGroup1.add(rpm);
        rpm.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rpm.setForeground(new java.awt.Color(255, 255, 255));
        rpm.setText("Perempuan");

        buttonGroup1.add(rlk);
        rlk.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rlk.setForeground(new java.awt.Color(255, 255, 255));
        rlk.setText("Laki-Laki");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Anggota");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kelas");

        cbkelas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        cbkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-A", "1-B", "2-A", "2-B", "3-A", "3-B", "4-A", "4-B", "5-A", "5-B", "6-A", "6-B" }));
        cbkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkelasActionPerformed(evt);
            }
        });

        stgl.setModel(new javax.swing.SpinnerDateModel());
        stgl.setPreferredSize(new java.awt.Dimension(64, 24));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tanggal Registrasi");

        bkembali.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bkembali.setText("Kembali");
        bkembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        bhapus.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bhapus.setText("Hapus");
        bhapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bbatal.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bbatal.setText("Batal");
        bbatal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bubah.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bubah.setText("Ubah");
        bubah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bsimpan.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(230, 230, 254));

        tabelanggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelanggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Anggota", "Nama", "Jenis Kelamin", "Kelas", "Tanggal Registrasi"
            }
        ));
        tabelanggota.setGridColor(new java.awt.Color(0, 0, 0));
        tabelanggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelanggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelanggota);

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        bcetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        bcetak.setText("Cetak Laporan");
        bcetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bcetak.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetakActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sekolah Dasar Negeri Pejaten Barat 09");

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PERPUSTAKAAN");

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("-------------------------------------------------------------------------------------");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Jl. Amil No. 2, Pejaten Barat, Ps. Minggu, Kota Jakarta Selatan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel9)
                .addGap(163, 164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcetak)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(64, 64, 64))))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(2, 2, 2)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari)
                    .addComponent(bcetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA ANGGOTA");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(53, 53, 53)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(rlk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(91, 91, 91)
                                .addComponent(cbkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(15, 15, 15)
                                .addComponent(stgl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bubah)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(bhapus))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(bkembali))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(bbatal)))))
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(rlk)
                    .addComponent(rpm))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(stgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bkembali)
                    .addComponent(bbatal))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok == 0){
            String sql = "delete from anggota where id_anggota = '"+txtid.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.execute();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtid.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        datatable();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        String jk = null;
        if(rlk.isSelected()){
            jk = "Laki-Laki";
        } else if(rpm.isSelected()){
            jk = "Perempuan";
        }
        String kelas = cbkelas.getSelectedItem().toString();
        java.util.Date tanggal = (java.util.Date) stgl.getValue();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String tgl = format.format(tanggal);

        try {
            String sql = "update anggota set nama_anggota=?, jk=?, kelas=?, tgl_registrasi=? where id_anggota='"+txtid.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnm.getText());
            stat.setString(2, jk);
            stat.setString(3, kelas);
            stat.setString(4, tgl);

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            txtid.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
        datatable();
    }//GEN-LAST:event_bubahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String jk = null;
        if(rlk.isSelected()){
            jk = "Laki-Laki";
        } else if (rpm.isSelected()){
            jk = "Perempuan";
        }
        String kelas = cbkelas.getSelectedItem().toString();
        java.util.Date tanggal = (java.util.Date) stgl.getValue();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String tgl = format.format(tanggal);
        String sql = "insert into anggota values (?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtid.getText());
            stat.setString(2, txtnm.getText());
            stat.setString(3, jk);
            stat.setString(4, kelas);
            stat.setString(5, tgl);

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            txtid.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tabelanggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelanggotaMouseClicked
        int bar = tabelanggota.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        txtid.setText(a);
        txtnm.setText(b);
        if ("Laki-Laki".equals(c)){
            rlk.setSelected(true);
        } else {
            rpm.setSelected(true);
        }
        cbkelas.setSelectedItem(d);
        try {
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tanggal = format.parse(e);
            stgl.setValue(tanggal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabelanggotaMouseClicked

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatable();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void cbkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkelasActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        cetak();
    }//GEN-LAST:event_bcetakActionPerformed

    
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
            java.util.logging.Logger.getLogger(master_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcetak;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkembali;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rlk;
    private javax.swing.JRadioButton rpm;
    private javax.swing.JSpinner stgl;
    private javax.swing.JTable tabelanggota;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnm;
    // End of variables declaration//GEN-END:variables
}
