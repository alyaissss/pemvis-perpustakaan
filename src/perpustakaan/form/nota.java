package perpustakaan.form;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import koneksi.koneksi;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import java.util.Date;
import java.util.Calendar;

public class nota extends javax.swing.JFrame {
public String id, nama, jk, kelas, tgl_registrasi;
public String kdbk, isbn, judul, penulis, penerbit, tahun, kategori, stok;
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
    
    public nota() {
        initComponents();
        String KD = UserID.getUserLogin();
        labelID.setText(KD);
        String NM = UserID.getUserName();
        labelNama.setText(NM);
        nama();
        kosong();
        aktif();
        autonumber();
    }
    protected void nama(){
    try {
        String sql = "SELECT * FROM petugas WHERE id_petugas='"+labelID.getText( )+"'";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        if(hasil.next()){
            labelNama.setText(hasil.getString("nama_petugas"));
        }
    } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
    protected void aktif(){
        jtgl.setEditor(new JSpinner.DateEditor(jtgl, "yyyy/MM/dd"));
        Object[] Baris ={"Kode Buku", "Judul Buku", "Nama Anggota", "Kelas", "Jatuh Tempo"};
        tabmode = new DefaultTableModel(null, Baris);
        tbltransaksi.setModel(tabmode);
    }
    protected void kosong(){
        txtid.setText("");
        txtnm.setText("");
        txtkls.setText("");
        txtkdbk.setText("");
        txtisbn.setText("");
        txtjudul.setText("");
        txtpenulis.setText("");
        txtpenerbit.setText("");
        txtthn.setText("");
    }
    protected void autonumber(){
        try {
            String sql = "SELECT id_nota FROM nota order by id_nota asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtidnota.setText("MP0001");
            while(rs.next()){
                String id_nota = rs.getString("id_nota").substring(2);
                int AN = Integer.parseInt(id_nota)+1;
                String Nol = "";

                if(AN<10)
                {Nol = "000";}
                else if(AN<100)
                {Nol = "00";}
                else if(AN<1000)
                {Nol = "0";}
                else if(AN<10000)
                {Nol = "";}

                txtidnota.setText("MP" + Nol + AN);
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }
    public void itemTerpilih(){
        popupanggota Pp = new popupanggota();
        Pp.anggota = this;
        txtid.setText(id);
        txtnm.setText(nama);
        txtkls.setText(kelas);
    }
    public void itemTerpilihBuku() {
        txtkdbk.setText(kdbk);
        txtisbn.setText(isbn);
        txtjudul.setText(judul);
        txtpenulis.setText(penulis);
        txtpenerbit.setText(penerbit);
        txtthn.setText(tahun);
    }
    
    public void cetak() {
    try {
    String jrxml = "./src/perpustakaan/form/reportPeminjaman.jrxml";
    JasperReport report = JasperCompileManager.compileReport(jrxml);
    HashMap<String, Object> parameter = new HashMap<>();
    parameter.put("id_nota", txtidnota.getText().trim());
    System.out.println("ID Nota = " + txtidnota.getText().trim());
    JasperPrint print = JasperFillManager.fillReport(report, parameter, conn);
    System.out.println("Jumlah Halaman = " + print.getPages().size());
    JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidnota = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        bcarianggota = new javax.swing.JButton();
        txtkls = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        txtkdbk = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtpenulis = new javax.swing.JTextField();
        txtjudul = new javax.swing.JTextField();
        txtpenerbit = new javax.swing.JTextField();
        txtthn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bcaribk = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        bsimpan = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jtgl = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 128, 214));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Petugas");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Nota");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOTA PEMINJAMAN BUKU");

        txtidnota.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        labelID.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelID.setForeground(new java.awt.Color(255, 255, 255));
        labelID.setText("labelID");
        labelID.setPreferredSize(new java.awt.Dimension(64, 22));

        jPanel2.setBackground(new java.awt.Color(197, 211, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data Anggota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel6.setText("Nama");

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel7.setText("Kelas");

        txtnm.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txtid.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        bcarianggota.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        bcarianggota.setText("Cari");
        bcarianggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarianggotaActionPerformed(evt);
            }
        });

        txtkls.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel10.setText("ID Anggota");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtkls, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcarianggota, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcarianggota)
                    .addComponent(jLabel10)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nama Petugas");

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Peminjaman");

        labelNama.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("labelNama");
        labelNama.setPreferredSize(new java.awt.Dimension(64, 22));

        jPanel3.setBackground(new java.awt.Color(197, 211, 239));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data Buku", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Kode Buku");

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel12.setText("ISBN");

        jLabel13.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel13.setText("Judul Buku");

        txtisbn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txtkdbk.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        btambah.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel14.setText("Penerbit");

        txtpenulis.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txtjudul.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txtpenerbit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtpenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpenerbitActionPerformed(evt);
            }
        });

        txtthn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel15.setText("Penulis");

        jLabel16.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel16.setText("Tahun Terbit");

        bcaribk.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        bcaribk.setText("Cari");
        bcaribk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtkdbk, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcaribk, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtjudul)
                            .addComponent(txtpenulis, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtpenerbit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtisbn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtthn)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtkdbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaribk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtthn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(btambah)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(197, 211, 239));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Transaksi Peminjaman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbltransaksi.setGridColor(new java.awt.Color(0, 0, 0));
        tbltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbltransaksi);

        bsimpan.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        bsimpan.setText("Simpan & Cetak");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bkeluar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        bbatal.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bhapus.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bbatal)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus)
                        .addGap(18, 18, 18)
                        .addComponent(bkeluar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bkeluar)
                    .addComponent(bhapus)
                    .addComponent(bbatal)
                    .addComponent(bsimpan))
                .addGap(26, 26, 26))
        );

        jtgl.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jtgl.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Data Anggota");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcarianggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarianggotaActionPerformed
        popupanggota Pp = new popupanggota();
        Pp.anggota = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcarianggotaActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        try {
            String kode = txtkdbk.getText();
            String judul = txtjudul.getText();
            String nama = txtnm.getText();
            String kelas = txtkls.getText();
            int tahun = Integer.parseInt(txtthn.getText());
            
            Calendar cal = Calendar.getInstance();
                cal.setTime((Date) jtgl.getValue());
                cal.add(Calendar.DAY_OF_MONTH, 7);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String jatuh = sdf.format(cal.getTime());

                tabmode.addRow(new Object[]{kode, judul, nama, kelas, jatuh});
                tbltransaksi.setModel(tabmode);

            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
    }//GEN-LAST:event_btambahActionPerformed

    private void txtpenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpenerbitActionPerformed
        
    }//GEN-LAST:event_txtpenerbitActionPerformed

    private void bcaribkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribkActionPerformed
        popupbuku Pb = new popupbuku();
        Pb.buku = this;
        Pb.setVisible(true);
        Pb.setResizable(false);
    }//GEN-LAST:event_bcaribkActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.setTime((java.util.Date) jtgl.getValue());
    cal.add(java.util.Calendar.DAY_OF_MONTH, 7);
        
    String tgl_nota = sdf.format(jtgl.getValue());
    String jatuh_tempo = sdf.format(cal.getTime());
    String sql = "insert into nota values (?, ?, ?, ?, ?)";
    String zsql = "insert into isi values (?, ?)";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtidnota.getText());
        stat.setString(2, tgl_nota);
        stat.setString(3, txtid.getText());
        stat.setString(4, labelID.getText());
        stat.setString(5, jatuh_tempo);
        stat.executeUpdate();

        int t = tbltransaksi.getRowCount();
        for (int i = 0; i < t; i++) {
            String kode = tbltransaksi.getValueAt(i, 0).toString();

            PreparedStatement stat2 = conn.prepareStatement(zsql);
            stat2.setString(1, txtidnota.getText());
            stat2.setString(2, kode);

            stat2.executeUpdate();
        }
        
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        cetak(); 
        txtidnota.setText("");
        txtid.setText("");
        
    } catch (Exception e) {
        System.out.println("Error : " + e);
        JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
    }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int index = tbltransaksi.getSelectedRow();
        tabmode.removeRow(index);
        tbltransaksi.setModel(tabmode);
    }//GEN-LAST:event_bhapusActionPerformed

    private void tbltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbltransaksiMouseClicked

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
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcarianggota;
    private javax.swing.JButton bcaribk;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNama;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidnota;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtkdbk;
    private javax.swing.JTextField txtkls;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtpenerbit;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JTextField txtthn;
    // End of variables declaration//GEN-END:variables
}
