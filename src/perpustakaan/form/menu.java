package perpustakaan.form;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bkeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mpetugas = new javax.swing.JMenuItem();
        manggota = new javax.swing.JMenuItem();
        mbuku = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnota = new javax.swing.JMenu();
        mpeminjaman = new javax.swing.JMenuItem();
        mpengembalian = new javax.swing.JMenuItem();
        mdenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 128, 214));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 424));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO1.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Perpustakaan Sekolah Dasar Negeri Pejaten Barat 09");

        bkeluar.setBackground(new java.awt.Color(255, 0, 0));
        bkeluar.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        bkeluar.setForeground(new java.awt.Color(255, 255, 255));
        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        bkeluar.setText("Log Out");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jl. Amil No.2, Pejaten Barat, Ps. Minggu, Kota Jakarta Selatan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(259, 259, 259))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(90, 90, 90))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(bkeluar)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(bkeluar)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N

        jMenu3.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jMenuBar1.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/master.png"))); // NOI18N
        jMenu1.setText("Master");
        jMenu1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu1.setIconTextGap(5);
        jMenu1.setPreferredSize(new java.awt.Dimension(120, 25));

        mpetugas.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        mpetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/petugas.png"))); // NOI18N
        mpetugas.setText("Petugas");
        mpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpetugasActionPerformed(evt);
            }
        });
        jMenu1.add(mpetugas);

        manggota.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        manggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anggota.png"))); // NOI18N
        manggota.setText("Anggota");
        manggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manggotaActionPerformed(evt);
            }
        });
        jMenu1.add(manggota);

        mbuku.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        mbuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buku.png"))); // NOI18N
        mbuku.setText("Buku");
        mbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbukuActionPerformed(evt);
            }
        });
        jMenu1.add(mbuku);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("|    ");
        jMenu2.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        jMenuBar1.add(jMenu2);

        mnota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transaksi.png"))); // NOI18N
        mnota.setText("Transaksi");
        mnota.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N

        mpeminjaman.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        mpeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pinjam.png"))); // NOI18N
        mpeminjaman.setText("Peminjaman");
        mpeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpeminjamanActionPerformed(evt);
            }
        });
        mnota.add(mpeminjaman);

        mpengembalian.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        mpengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kembali.png"))); // NOI18N
        mpengembalian.setText("Pengembalian");
        mpengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpengembalianActionPerformed(evt);
            }
        });
        mnota.add(mpengembalian);

        mdenda.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        mdenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/denda.png"))); // NOI18N
        mdenda.setText("Denda");
        mdenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdendaActionPerformed(evt);
            }
        });
        mnota.add(mdenda);

        jMenuBar1.add(mnota);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbukuActionPerformed
        master_buku frmB = new master_buku();
        frmB.setVisible(true);
    }//GEN-LAST:event_mbukuActionPerformed

    private void manggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manggotaActionPerformed
        master_anggota frmP = new master_anggota();
        frmP.setVisible(true);
    }//GEN-LAST:event_manggotaActionPerformed

    private void mpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpetugasActionPerformed
        master_petugas frmK = new master_petugas();
        frmK.setVisible(true);
    }//GEN-LAST:event_mpetugasActionPerformed

    private void mpeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpeminjamanActionPerformed
        nota frmN = new nota();
        frmN.setVisible(true);
    }//GEN-LAST:event_mpeminjamanActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        login kembali = new login();
        kembali.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void mpengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpengembalianActionPerformed
        pengembalian frmN = new pengembalian();
        frmN.setVisible(true);
    }//GEN-LAST:event_mpengembalianActionPerformed

    private void mdendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdendaActionPerformed
        denda frmN = new denda();
        frmN.setVisible(true);
    }//GEN-LAST:event_mdendaActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkeluar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem manggota;
    private javax.swing.JMenuItem mbuku;
    private javax.swing.JMenuItem mdenda;
    private javax.swing.JMenu mnota;
    private javax.swing.JMenuItem mpeminjaman;
    private javax.swing.JMenuItem mpengembalian;
    private javax.swing.JMenuItem mpetugas;
    // End of variables declaration//GEN-END:variables
}
