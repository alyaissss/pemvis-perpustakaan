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

public class master_buku extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

    public master_buku() {
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
    txtisbn.setText("");
    txtjudul.setText("");
    txtpenulis.setText("");
    txtpenerbit.setText("");
    txttahun.setText("");
    cbkategori.setSelectedItem(null);
    sstok.setValue(0);
}

//Data Tabel dan Cari
protected void datatable(){
    Object[] Baris = {"Kode Buku","ISBN","Judul Buku","Penulis","Penerbit","Tahun Terbit","Kategori","Stok Buku"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari.getText();
    
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
        tabelbuku.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
}

public void cetak() {
    try {
        String path="./src/perpustakaan/form/reportBuku.jasper";
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtjudul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbuku = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bcetak = new javax.swing.JButton();
        txtisbn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtpenulis = new javax.swing.JTextField();
        txtpenerbit = new javax.swing.JTextField();
        txttahun = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sstok = new javax.swing.JSpinner();
        cbkategori = new javax.swing.JComboBox<>();
        bkembali = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 128, 214));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Buku");

        txtid.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtjudul.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Judul Buku");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Penulis");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kategori");

        jPanel3.setBackground(new java.awt.Color(230, 230, 254));

        tabelbuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelbuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Buku", "ISBN", "Judul Buku", "Penulis", "Penerbit", "Tahun Terbit", "Kategori", "Stok Buku"
            }
        ));
        tabelbuku.setGridColor(new java.awt.Color(0, 0, 0));
        tabelbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbuku);

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

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sekolah Dasar Negeri Pejaten Barat 09");

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Jl. Amil No. 2, Pejaten Barat, Ps. Minggu, Kota Jakarta Selatan");

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("------------------------------------------------------------------------------------------------------");

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
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(12, 12, 12))
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(126, 126, 126))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcetak)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcetak)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtisbn.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisbnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BUKU");

        txtpenulis.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtpenerbit.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtpenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpenerbitActionPerformed(evt);
            }
        });

        txttahun.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Penerbit");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tahun Terbit");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Stok Buku");

        sstok.setModel(new javax.swing.SpinnerNumberModel());
        sstok.setPreferredSize(new java.awt.Dimension(64, 24));

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ilmu Sosial", "Agama", "Bahasa", "Sastra", "Sains & Matematika", "Teknologi", "Kesenian & Olahraga", "Sejarah & Geografi", "Karya Umum" }));
        cbkategori.setPreferredSize(new java.awt.Dimension(72, 24));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid)
                                    .addComponent(txtisbn)
                                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                        .addComponent(bkembali))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttahun)
                                    .addComponent(txtpenerbit)
                                    .addComponent(sstok, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsimpan)
                    .addComponent(bbatal)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bkembali))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbukuMouseClicked
        int bar = tabelbuku.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();

        txtid.setText(a);
        txtisbn.setText(b);
        txtjudul.setText(c);
        txtpenulis.setText(d);
        txtpenerbit.setText(e);
        txttahun.setText(f);
        cbkategori.setSelectedItem(g);
        sstok.setValue(Integer.parseInt(h));
    }//GEN-LAST:event_tabelbukuMouseClicked

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

    private void txtisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtisbnActionPerformed

    private void txtpenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpenerbitActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok == 0){
            String sql = "delete from buku where id_buku = '"+txtid.getText()+"'";
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
        String kategori = cbkategori.getSelectedItem().toString();
        try {
            String sql = "update buku set isbn=?, judul=?, penulis=?, penerbit=?, tahun=?, kategori=?, stok=? where id_buku='"+txtid.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtisbn.getText());
            stat.setString(2, txtjudul.getText());
            stat.setString(3, txtpenulis.getText());
            stat.setString(4, txtpenerbit.getText());
            stat.setString(5, txttahun.getText());
            stat.setString(6, kategori);
            stat.setInt(7, (Integer) sstok.getValue());

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
        String kategori = cbkategori.getSelectedItem().toString();
        String sql = "insert into buku values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtid.getText());
            stat.setString(2, txtisbn.getText());
            stat.setString(3, txtjudul.getText());
            stat.setString(4, txtpenulis.getText());
            stat.setString(5, txtpenerbit.getText());
            stat.setString(6, txttahun.getText());
            stat.setString(7, kategori);
            stat.setInt(8, (Integer) sstok.getValue());

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
            java.util.logging.Logger.getLogger(master_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_buku().setVisible(true);
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
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner sstok;
    private javax.swing.JTable tabelbuku;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtpenerbit;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JTextField txttahun;
    // End of variables declaration//GEN-END:variables
}
