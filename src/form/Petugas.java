package form;

import static form.Pasien.labelKd;
import static form.Pasien.labelNm;
import static form.Pasien.labelStatus;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import java.awt.Frame;
import javax.swing.JFrame;

public class Petugas extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
    public static String labelKd, labelNm, labelStatus ;

    public Petugas(String kode, String nama, String status) {
        initComponents();
        
        this.labelKd = kode;
        this.labelNm = nama;
        this.labelStatus = status;
        
        
        this.setLocationRelativeTo(null);
        kosong();
        aktif();
        if (labelKd != null) {
            btnTambah.setVisible(false);
                        btnEdit.setVisible(false);
                         
            isiField();
        }
       // datatable();
        setLocationRelativeTo(getRootPane());
        autonumber();
    }

    protected void aktif() {
        txtKdPtgs.requestFocus();;
    }
  public void isiField(){
       
        try {
           String sql  = "SELECT * FROM petugas where kd_ptgs like '%"+labelKd+"%' order by kd_ptgs asc";
        Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                txtKdPtgs.setText(hasil.getString(1));
        txtNmptgs.setText(hasil.getString(2));
         if ("Laki-Laki".equals(hasil.getString(3))) {
        rbLaki.setSelected(true);
        } else{
        rbPerempuan.setSelected(true);
        }
        txtNotlp.setText(hasil.getString(4));
                
        cbProf.setSelectedItem(5);
                txtEmail.setText(hasil.getString(6));

        txtPass.setText(hasil.getString(7));
        txtAlamat.setText(hasil.getString(8));

        
            }
        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    e.printStackTrace();
        }
        
    }
    protected void kosong() {
        txtKdPtgs.setText("");
        txtNmptgs.setText("");
        buttonGroup1.clearSelection();
        cbProf.setSelectedItem(null);
        txtNotlp.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        txtAlamat.setText("");

    }

    protected void autonumber() {
        try {
            String sql = "Select * from petugas order by kd_ptgs asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKdPtgs.setText("KP0001");
            while (rs.next()) {
                String kd_ptgs = rs.getString("kd_ptgs").substring(2);
                int an = Integer.parseInt(kd_ptgs) + 1;
                String nol = "";

                if (an < 10) {
                    nol = "000";
                } else if (an < 100) {
                    nol = "00";
                } else if (an < 1000) {
                    nol = "0";
                } else if (an < 10000) {
                    nol = "";
                }

                txtKdPtgs.setText("KP" + nol + an);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);

        }
    }
    
//
//    protected void datatable() {
//        Object[] col = {"Kode Petugas", "Nama Petugas", "Jenis Kelamin", "No Telepon", "Profesi", "Email", "Alamat"};
//        table = new DefaultTableModel(null, col);
//        String cariitem = txtCari.getText();
//        try {
//            String sql = "SELECT kd_ptgs,nama_ptgs,j_kelamin,no_tlp,profesi,email,alamat FROM petugas where kd_ptgs like '%" + labelKd + "%'";
//            Statement stat = conn.createStatement();
//            ResultSet hasil = stat.executeQuery(sql);
//            while (hasil.next()) {
//                table.addRow(new Object[]{
//                    hasil.getString(1),
//                    hasil.getString(2),
//                    hasil.getString(3),
//                    hasil.getString(4),
//                    hasil.getString(5),
//                    hasil.getString(6),
//                    hasil.getString(7),}
//                );
//            }
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
//            e.printStackTrace();
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKdPtgs = new javax.swing.JTextField();
        txtNmptgs = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        cbProf = new javax.swing.JComboBox();
        txtNotlp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        txtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(634, 694));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-name-24.png"))); // NOI18N
        jLabel2.setText("Nama Petugas");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-access-24.png"))); // NOI18N
        jLabel3.setText("Kode Petugas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-toilet-24.png"))); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-open-lock-24.png"))); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-management-24.png"))); // NOI18N
        jLabel7.setText("Profesi");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-map-marker-24.png"))); // NOI18N
        jLabel9.setText("Alamat");

        txtKdPtgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKdPtgsActionPerformed(evt);
            }
        });

        txtNmptgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmptgsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbLaki);
        rbLaki.setText("Laki - Laki ");

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        cbProf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dokter", "Bidan", "Perawat", "Admin", " " }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-phone-24.png"))); // NOI18N
        jLabel8.setText("Nomor Telepon");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-mail-24.png"))); // NOI18N
        jLabel10.setText("Email");

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-add-24.png"))); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-edit-file-24.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-delete-24.png"))); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-cancel-24.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-logout-24.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setText("Daftar");

        jLabel11.setText("Hapus");

        jLabel12.setText("Edit");

        jLabel13.setText("Batal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(692, Short.MAX_VALUE)
                        .addComponent(jButton13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNmptgs, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbLaki)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbPerempuan))
                                    .addComponent(cbProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNotlp, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKdPtgs, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTambah)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEdit)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel12)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHapus)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel13))
                                    .addComponent(jButton11))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKdPtgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNmptgs))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNotlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)))
                .addGap(133, 133, 133))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Form Data Petugas Pemeriksaan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKdPtgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKdPtgsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKdPtgsActionPerformed

    private void txtNmptgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmptgsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNmptgsActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String jenis = null;
        if (rbLaki.isSelected()) {
            jenis = "Laki-Laki";
        } else if (rbPerempuan.isSelected()) {
            jenis = "Perempuan";
        }
        String sql = "insert into petugas values (?,?,?,?,?,?,?,?)";
        String sql2 = "insert into user values (?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKdPtgs.getText());
            stat.setString(2, txtNmptgs.getText());
            stat.setString(3, jenis);
            stat.setString(4, cbProf.getSelectedItem().toString());
            stat.setString(5, txtNotlp.getText());
            stat.setString(6, txtEmail.getText());
            stat.setString(7, txtPass.getText());
            stat.setString(8, txtAlamat.getText());

            stat.executeUpdate();
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, txtKdPtgs.getText());
            stat2.setString(2, txtNmptgs.getText());
            
            stat2.setString(3, txtPass.getText());
            stat2.setString(4, cbProf.getSelectedItem().toString());

            stat2.executeUpdate();

            JOptionPane.showMessageDialog(null, "data berhasil didaftarkan\nSilahkan Login kembali");

            kosong();
            txtKdPtgs.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal didaftarkan" + e);
            e.printStackTrace();
            // TODO add your handling code here:
        }
//        datatable();
        autonumber();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
       MenuUtama utama =  new MenuUtama();
        utama.labelKd.setText(labelKd);
        utama.labelNm.setText(labelNm);
        utama.labelStatus.setText(labelStatus);
        utama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from petugas where kd_ptgs ='" + txtKdPtgs.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtKdPtgs.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
//            datatable();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String jenis = null;
        if (rbLaki.isSelected()) {
            jenis = "Laki-Laki";
        } else if (rbPerempuan.isSelected()) {
            jenis = "Perempuan";
        }
        try {
            String sql = "update petugas set nama_ptgs=?,j_kelamin=?,no_tlp = ?, profesi=?,email=?,alamat=?,password=? where kd_ptgs='" + labelKd + "'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtNmptgs.getText());
            stat.setString(2, jenis);
            stat.setString(3, txtNotlp.getText());
            stat.setString(4, cbProf.getSelectedItem().toString());
            stat.setString(5, txtEmail.getText());
            stat.setString(6, txtAlamat.getText());
            stat.setString(7, txtPass.getText());
            stat.executeUpdate();
         
            String sql2 = "update user set nama=?,password=? where kode ='"+labelKd+"'";

              PreparedStatement stat2 = conn.prepareStatement(sql2);
            
            stat2.setString(1, txtNmptgs.getText());
            
            stat2.setString(2, txtPass.getText());
            
            
            stat2.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            txtKdPtgs.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah" + e);
            e.printStackTrace();
        }
       // datatable();
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        kosong();
        //datatable();
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Petugas(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbProf;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKdPtgs;
    private javax.swing.JTextField txtNmptgs;
    private javax.swing.JTextField txtNotlp;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
