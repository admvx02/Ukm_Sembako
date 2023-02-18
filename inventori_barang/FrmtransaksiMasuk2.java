/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventori_barang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author adam
 */

public class FrmtransaksiMasuk2 extends javax.swing.JDialog {

    /**
     * Creates new form Frmmaster_barang
     * @param parent
     * @param modal
     */
    inventori_barang.PetugasSession PetugasSession = new inventori_barang.PetugasSession();
    inventori_barang.koneksi konek = new inventori_barang.koneksi();
    
    public FrmtransaksiMasuk2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();
        
       datatable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
       datatable.getTableHeader().setOpaque(false);
       datatable.getTableHeader().setBackground(new Color(25, 118, 211));
       datatable.getRowHeight(25);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        
        txttgl.setText(dateFormat.format(cal.getTime()));
        txtnm_petugas.setText(PetugasSession.getU_nama());
        txtid_petugas.setText(Integer.toString(PetugasSession.getU_id()));
        
        SelectPelanggan();
        TxtEmpty();
    }
    
    private void initUI(){ 
        getContentPane().setBackground(new Color(255, 255, 255));
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
    
    private void SelectPelanggan(){
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tabelsupplier");
            
            cmbid_pelanggan.addItem("Pilih");
            while(rs.next()){
                cmbid_pelanggan.addItem(rs.getString("kode") + " " + rs.getString("nama"));
            }
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void TxtEmpty(){
        TableEmpty();
        BtnEnabled(false);
        lblnama_barang.setText("-");
        txtid_selected.setText("");
        txtid_pelanggan.setVisible(false);
        txtid_petugas.setVisible(false);
        txtid_barang.setVisible(false);
        txtjumlah_barang_max.setVisible(false);
        cmbid_pelanggan.setSelectedItem("Pilih");
        cmbid_pelanggan.requestFocus();
    }
    
    private void TableEmpty(){
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    private void BtnEnabled(boolean x){
        btnDelRow.setEnabled(x);
    }
    
    
    private void GetData_View(){
        String row = Integer.toString(datatable.getSelectedRow());
        txtid_selected.setText(row);
        BtnEnabled(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtjumlah_barang = new javax.swing.JTextField();
        btnok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        btnTableEmpty = new javax.swing.JButton();
        lblnama_barang = new javax.swing.JLabel();
        txtkode_barang = new javax.swing.JTextField();
        txtid_barang = new javax.swing.JTextField();
        txtjumlah_barang_max = new javax.swing.JTextField();
        btnDelRow = new javax.swing.JButton();
        txtid_selected = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnm_petugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        txtid_pelanggan = new javax.swing.JTextField();
        txtid_petugas = new javax.swing.JTextField();
        cmbid_pelanggan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 596, -1, -1));

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8_nft_transaction_64px.png"))); // NOI18N
        jLabel8.setText("Transaksi Barang Masuk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Kode Barang");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Jumlah");

        txtjumlah_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlah_barangKeyTyped(evt);
            }
        });

        btnok.setBackground(new java.awt.Color(25, 118, 211));
        btnok.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnok.setForeground(new java.awt.Color(255, 255, 255));
        btnok.setText("OK");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama Barang", "Jumlah"
            }
        ));
        datatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datatableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        btnTableEmpty.setBackground(new java.awt.Color(255, 255, 255));
        btnTableEmpty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTableEmpty.setText("Hapus Semua");
        btnTableEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableEmptyActionPerformed(evt);
            }
        });

        lblnama_barang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblnama_barang.setText("Nama Barang");

        txtkode_barang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtkode_barangFocusLost(evt);
            }
        });
        txtkode_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkode_barangActionPerformed(evt);
            }
        });

        btnDelRow.setBackground(new java.awt.Color(255, 255, 255));
        btnDelRow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelRow.setText("Hapus Yang Terpilih");
        btnDelRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelRowActionPerformed(evt);
            }
        });

        txtid_selected.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtid_selected.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTableEmpty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(lblnama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtjumlah_barang_max, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 245, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok)
                    .addComponent(lblnama_barang)
                    .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjumlah_barang_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTableEmpty)
                    .addComponent(btnDelRow)
                    .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 156, 970, 370));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Tanggal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, -1, -1));

        txttgl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txttgl.setEnabled(false);
        getContentPane().add(txttgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Nama Petugas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtnm_petugas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnm_petugas.setEnabled(false);
        getContentPane().add(txtnm_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Nama Supplier");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        btnsave.setBackground(new java.awt.Color(25, 118, 211));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Simpan Transaksi");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 165, 46));

        txtid_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_pelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txtid_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 22, -1));

        txtid_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_petugasActionPerformed(evt);
            }
        });
        getContentPane().add(txtid_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 22, -1));

        cmbid_pelanggan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbid_pelanggan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbid_pelangganItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbid_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 154, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Bersihkan inputan transaksi");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jButton1.setBackground(new java.awt.Color(25, 118, 211));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 100, -1));

        setBounds(0, 0, 1001, 625);
    }// </editor-fold>//GEN-END:initComponents

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        String data1 = txtid_barang.getText();
        String data2 = txtkode_barang.getText();
        String data3 = lblnama_barang.getText();
        String data4 = txtjumlah_barang.getText();
        
        if(!(data1.equals("")) && !(data2.equals("")) && !(data3.equals("")) && !(data4.equals(""))){
            int jumlah = Integer.parseInt(data4);
            int jumlah_max = Integer.parseInt(txtjumlah_barang_max.getText());
            //if(jumlah <= jumlah_max){
                Object[] row = { data1, data2, data3, data4 };
                DefaultTableModel model = (DefaultTableModel) datatable.getModel();
                model.addRow(row);
                txtid_barang.setText("");
                txtkode_barang.setText("");
                lblnama_barang.setText("-");
                txtjumlah_barang.setText("");
                txtjumlah_barang_max.setText("");
                txtkode_barang.requestFocus();
            // }else{
            //    JOptionPane.showMessageDialog(null, "Jumlah melebihi stok barang.");  
            //}
        }else{
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnokActionPerformed

    private void cmbid_pelangganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_pelangganItemStateChanged
        // TODO add your handling code here:
        String[] nama_kategori = cmbid_pelanggan.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];
        if(!kode.equals("Pilih")){
            
            
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT id FROM tabelsupplier WHERE kode='"+kode+"'");
                    if(sql.next()){
                        txtid_pelanggan.setText(sql.getString("id"));
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else{
            txtid_pelanggan.setText("");
        }
    }//GEN-LAST:event_cmbid_pelangganItemStateChanged

    private void txtkode_barangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtkode_barangFocusLost
        // TODO add your handling code here:
        String kode = txtkode_barang.getText();
        if(!kode.equals("")){

                //--------- Cek In jtable
            Integer same_kode = 0;
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                if(kode.equals(datatable.getModel().getValueAt(i, 1).toString())){
                    same_kode = 1;
                }
            }
            
            if(same_kode == 0){
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tabelbarang WHERE kode='"+kode+"'");
                    if(sql.next()){
                        txtid_barang.setText(sql.getString("id"));
                        lblnama_barang.setText(sql.getString("nama"));
                        txtjumlah_barang_max.setText(sql.getString("stok"));
                    }else{
                        JOptionPane.showMessageDialog(null, "Kode barang tidak ditemukan.");
                        txtid_barang.setText("");
                        lblnama_barang.setText("-");
                        txtkode_barang.setText("");
                        txtjumlah_barang_max.setText("");
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Kode barang sudah pernah ditambah.");
                txtkode_barang.setText("");
            }
        }else{
            txtid_barang.setText("");
            lblnama_barang.setText("-");
            txtjumlah_barang_max.setText("");
        }
    }//GEN-LAST:event_txtkode_barangFocusLost

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String row_tgl = txttgl.getText();
        String row_idpelanggan = txtid_pelanggan.getText();
        String row_idpetugas = txtid_petugas.getText();
        
        String id, kode;
        Integer id_barang_masuk = 0, jumlah, stok, not_found, empty = 0;
        
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();
        
        if(rowCount > 0 && !"".equals(row_tgl) && !"".equals(row_idpelanggan) && !"".equals(row_idpetugas)){
            
                //------- Memasukan pada tabel transaksi lihat [trbarang_] dan mengeluarkan id terakhir
            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO tblbarang_masuk(tgl, id_petugas, id_supplier) VALUES ('" + row_tgl + "', '" + row_idpetugas + "', '" + row_idpelanggan + "')");
                konek.closekoneksi();
                 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT MAX(id) as max FROM tblbarang_masuk");
                sql.next();
                id_barang_masuk = sql.getInt("max");
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            for (int i = 0; i < rowCount; i++) {
                not_found = 0;
                stok = 0;
                id = (datatable.getModel().getValueAt(i, 0).toString());
                kode = (datatable.getModel().getValueAt(i, 1).toString());
                jumlah = Integer.parseInt((String) datatable.getModel().getValueAt(i, 3));
            
                    //------- Menjumlahkan stok dengan data jumlah
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT stok FROM tabelbarang WHERE id = '" + id + "'");

                    sql.next();
                    //sql.last();
                    if (sql.getRow() == 1){
                        stok = jumlah + sql.getInt("stok");
                    } else {
                       not_found = 1;
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                if(not_found == 0){
                
                        //------- Mengupdate jumlah stok barang
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("UPDATE tabelbarang SET stok='" + stok + "' WHERE id = '" + id + "'");
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        //------- Memasukan pada table transaksi detail
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO tblbarang_masuk_detail(id_barang_masuk, id_barang, jumlah) VALUES ('" + id_barang_masuk + "', '" + id + "', '" + jumlah + "')");
                        empty = 1;
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Sistem tidak menemukan barang dengan kode = " + kode , "Barang " + kode + " Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
                
                    //------- Opsi jika terdapat barang yang belum satupun di masukan
                if(empty == 0){
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("DELETE FROM tblbarang_masuk WHERE id = '" + id_barang_masuk + "'");
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                }
            }
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data transaksi");
            
            try {
                HashMap hash = new HashMap();
                hash.put("nm_supplier", cmbid_pelanggan.getSelectedItem().toString());
                hash.put("id", id_barang_masuk);
                        
                File file = new File("src/report/report_transaksiMasuk.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(file);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, konek.openkoneksi());
                JasperViewer.viewReport(jasperPrint, false);
                new mainview().setVisible(true);
            }catch (ClassNotFoundException | JRException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
            this.hide();
        }else{
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        TxtEmpty();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnTableEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableEmptyActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus semua baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if(ok==0) {
            TableEmpty();
        }
    }//GEN-LAST:event_btnTableEmptyActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void btnDelRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelRowActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if(ok==0) {
            int row = Integer.parseInt(txtid_selected.getText());
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            model.removeRow(row);
            BtnEnabled(false);
        }
    }//GEN-LAST:event_btnDelRowActionPerformed

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void txtjumlah_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlah_barangKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)){
            JOptionPane.showMessageDialog(null, "Inputan hanya boleh angka", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlah_barangKeyTyped

    private void txtkode_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkode_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkode_barangActionPerformed

    private void txtid_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_petugasActionPerformed

    private void txtid_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_pelangganActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.dispose();
        new mainview2().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(40);
            }catch(Exception e){
                
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmtransaksiMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            FrmtransaksiMasuk2 dialog = new FrmtransaksiMasuk2(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelRow;
    private javax.swing.JButton btnTableEmpty;
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbid_pelanggan;
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnama_barang;
    private javax.swing.JTextField txtid_barang;
    private javax.swing.JTextField txtid_pelanggan;
    private javax.swing.JTextField txtid_petugas;
    private javax.swing.JTextField txtid_selected;
    private javax.swing.JTextField txtjumlah_barang;
    private javax.swing.JTextField txtjumlah_barang_max;
    private javax.swing.JTextField txtkode_barang;
    private javax.swing.JTextField txtnm_petugas;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}
