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

public class master_petugas extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public master_petugas() {
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
    txttelp.setText("");
    txtalamat.setText("");
    pass.setText("");
    buttonGroup1.clearSelection();
}

//Data Tabel dan Cari
protected void datatable(){
    Object[] Baris = {"ID Petugas","Nama","Jenis Kelamin","No. Telepon","Alamat", "Password"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari.getText();
    
    try {
        String sql = "SELECT * FROM petugas where id_petugas like '%"+cariitem+"%' or nama_petugas like '%"+cariitem+"%' order by id_petugas asc";
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
            });
        }
        tabelpetugas.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
}

public void cetak() {
    try {
        String path="./src/perpustakaan/form/reportPetugas.jasper";
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
        txttelp = new javax.swing.JTextField();
        rpm = new javax.swing.JRadioButton();
        rlk = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bkembali = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpetugas = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bcetak = new javax.swing.JButton();
        txtnm = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 128, 214));
        jPanel1.setPreferredSize(new java.awt.Dimension(935, 450));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Petugas");

        txtid.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txttelp.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

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
        jLabel3.setText("Nama Petugas");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. Telepon");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alamat");

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PETUGAS");

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

        tabelpetugas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelpetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Petugas", "Nama", "Jenis Kelamin", "No. Telepon", "Alamat", "Password"
            }
        ));
        tabelpetugas.setGridColor(new java.awt.Color(0, 0, 0));
        tabelpetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpetugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpetugas);

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

        bcari.setBackground(new java.awt.Color(217, 217, 217));
        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PERPUSTAKAAN");

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sekolah Dasar Negeri Pejaten Barat 09");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Jl. Amil No. 2, Pejaten Barat, Ps. Minggu, Kota Jakarta Selatan");

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("-------------------------------------------------------------------------------------------");

        bcetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        bcetak.setText("Cetak Laporan");
        bcetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bcetak.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(12, 12, 12))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcetak))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcetak)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtnm.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmActionPerformed(evt);
            }
        });

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtalamat.setRows(5);
        jScrollPane3.setViewportView(txtalamat);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");

        pass.setText("jPasswordField1");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(56, 56, 56)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(39, 39, 39)
                                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(rlk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(50, 50, 50)
                                .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bsimpan)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(bbatal))
                            .addComponent(bubah)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(bhapus))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(bkembali)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(133, 133, 133))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(171, 171, 171)))))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rpm)
                        .addComponent(rlk)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsimpan)
                    .addComponent(bbatal)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bkembali))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
    if (ok == 0){
        String sql = "delete from petugas where id_petugas = '"+txtid.getText()+"'";
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
    String password = new String(pass.getPassword());
    try {
        String sql = "update petugas set nama_petugas=?, jk=?, no_telp=?, alamat=?, password=? where id_petugas='"+txtid.getText()+"'";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtnm.getText());
        stat.setString(2, jk);
        stat.setString(3, txttelp.getText());
        stat.setString(4, txtalamat.getText());
        stat.setString(5, password);
        
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
    String password = new String(pass.getPassword());
    String sql = "insert into petugas values (?,?,?,?,?,?)";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtid.getText());
        stat.setString(2, txtnm.getText());
        stat.setString(3, jk);
        stat.setString(4, txttelp.getText());
        stat.setString(5, txtalamat.getText());
        stat.setString(6, password);
        
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

    private void tabelpetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpetugasMouseClicked
    int bar = tabelpetugas.getSelectedRow();
    String a = tabmode.getValueAt(bar, 0).toString();
    String b = tabmode.getValueAt(bar, 1).toString();
    String c = tabmode.getValueAt(bar, 2).toString();
    String d = tabmode.getValueAt(bar, 3).toString();
    String e = tabmode.getValueAt(bar, 4).toString();
    String f = tabmode.getValueAt(bar, 5).toString();
    
    txtid.setText(a);
    txtnm.setText(b);
    if ("Laki-Laki".equals(c)){
        rlk.setSelected(true);
    } else {
        rpm.setSelected(true);
    }
    txttelp.setText(d);
    txtalamat.setText(e);
    pass.setText(f);
    }//GEN-LAST:event_tabelpetugasMouseClicked

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

    private void txtnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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
                new master_petugas().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPasswordField pass;
    private javax.swing.JRadioButton rlk;
    private javax.swing.JRadioButton rpm;
    private javax.swing.JTable tabelpetugas;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}
