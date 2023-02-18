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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author adam
 */

public class FrmbarangKategori2 extends javax.swing.JDialog {

    /**
     * Creates new form Frmmaster_barang
     * @param parent
     * @param modal
     */
    inventori_barang.koneksi konek = new inventori_barang.koneksi();
    
    public FrmbarangKategori2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();
        
          
       datatable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
       datatable.getTableHeader().setOpaque(false);
       datatable.getTableHeader().setBackground(new Color(32, 136, 203));
       datatable.getRowHeight(25);
        
        txttemp_nama.hide();
        GetData();
        BtnEnabled(false);
        btnsave.setText("Simpan");
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
    
    private void TxtEmpty(){
        txtid.setText("");
        txtnama.setText("");
        txtno_rak.setText("");
        txttemp_nama.setText("");
    }
    
    private void BtnEnabled(boolean x){
        btnedit.setEnabled(x);
        btndelete.setEnabled(x);
    }
    
    private void GetData(){
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT tabelkategori.id, tabelkategori.nama, tabelkategori.no_rak FROM tabelkategori");
            datatable.setModel(DbUtils.resultSetToTableModel(sql));
            datatable.getColumnModel().getColumn(0).setPreferredWidth(5);
            datatable.getColumnModel().getColumn(1).setPreferredWidth(100);
            datatable.getColumnModel().getColumn(2).setPreferredWidth(50);

          
            String count_rows = String.valueOf(datatable.getRowCount());
            lblcount_rows.setText("Jumlah Data : " + count_rows);
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GetData_View(){
        int row = datatable.getSelectedRow();
        String row_id = (datatable.getModel().getValueAt(row, 0).toString());
        txtid.setText(row_id);
        BtnEnabled(true);
    }
    
     private void cari(){
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from tabelkategori where nama like '%"+txtcari.getText()+"%'");
            datatable.setModel(DbUtils.resultSetToTableModel(sql));
            datatable.getColumnModel().getColumn(0).setPreferredWidth(5);
            datatable.getColumnModel().getColumn(1).setPreferredWidth(100);
            datatable.getColumnModel().getColumn(2).setPreferredWidth(50);
            

          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        txtno_rak = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        txttemp_nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtid = new javax.swing.JTextPane();
        lbl_action = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblcount_rows = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(255, 255, 0));
        btnedit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Link_edit_24px.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setForeground(new java.awt.Color(245, 245, 245));
        panel.setEnabled(false);

        txtno_rak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtno_rakActionPerformed(evt);
            }
        });
        txtno_rak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtno_rakKeyTyped(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(255, 255, 255));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnsave.setText("Simpan");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setLabelFor(txtnama);
        jLabel2.setText("Nama");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setLabelFor(txtno_rak);
        jLabel4.setText("No Rak");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(255, 255, 255));
        btncancel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btncancel.setText("Batal");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnama)
                            .addComponent(txtno_rak, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(14, 14, 14))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 153, Short.MAX_VALUE)
                        .addComponent(btncancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtno_rak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancel)
                    .addComponent(btnsave))
                .addGap(586, 586, 586))
        );

        txttemp_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttemp_namaActionPerformed(evt);
            }
        });

        datatable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama", "Kategori", "Satuan", "Stok"
            }
        ));
        datatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datatableMouseReleased(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datatableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        txtid.setBorder(null);
        txtid.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(43, 152, 240));
        txtid.setToolTipText("");
        txtid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtid.setEnabled(false);
        txtid.setFocusable(false);
        jScrollPane2.setViewportView(txtid);

        lbl_action.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_action.setText("Tambah Data");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setLabelFor(txtid);
        jLabel7.setText("Terpilih : ");

        btnadd.setBackground(new java.awt.Color(63, 255, 128));
        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_file_24px.png"))); // NOI18N
        btnadd.setText("Tambah");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(220, 20, 60));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_disposal_24px.png"))); // NOI18N
        btndelete.setText("Hapus");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sorting_80px.png"))); // NOI18N
        jLabel8.setText("Data Kategori Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        lblcount_rows.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcount_rows.setText("Jumlah Data ");

        jButton2.setBackground(new java.awt.Color(25, 118, 211));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cari.setBackground(new java.awt.Color(255, 255, 255));
        cari.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_property_24px.png"))); // NOI18N
        cari.setText("Search");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(cari))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(lbl_action))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(583, 583, 583)
                .addComponent(txttemp_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblcount_rows, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(416, 416, 416)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cari)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_action, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(txttemp_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblcount_rows))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2)))
        );

        setBounds(0, 0, 1000, 625);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        String row_id = txtid.getText();
        if(!"0".equals(row_id)){
            try {
                btnsave.setText("Simpan");
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT tabelkategori.id, tabelkategori.nama, tabelkategori.no_rak FROM tabelkategori WHERE tabelkategori.id='"+row_id+"'");
                if(sql.next()){
                    lbl_action.setForeground(new Color(43, 152, 240));
                    String kode = sql.getString("nama");
                    lbl_action.setText("Edit Data | " + kode);
                    txtid.setText(sql.getString("id"));
                    txtnama.setText(sql.getString("nama"));
                    txtno_rak.setText(sql.getString("no_rak"));
                    txttemp_nama.setText(kode);
                    txtnama.requestFocus();
                }
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!");
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txtno_rakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtno_rakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtno_rakActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        
        String row_id = txtid.getText();
        String row_txttemp_kode = txttemp_nama.getText();
        String row_txtnama = txtnama.getText();
        String row_txtrak = txtno_rak.getText();
        int c_kode = 0;

        if(!"".equals(row_txtnama) && !"".equals(row_txtrak)){
             try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT COUNT(tabelkategori.id) as count FROM tabelkategori WHERE tabelkategori.nama='"+row_txtnama+"'");
                sql.next();
                c_kode = sql.getInt("count");
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if("".equals(row_id)){
                if(c_kode == 0)
                {
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO tabelkategori(nama, no_rak) VALUES ('" + row_txtnama + "', '" + row_txtrak + "')");
                        JOptionPane.showMessageDialog(null, "Berhasil menyimpan data.");
                        btnadd.doClick();
                        konek.closekoneksi();
                        GetData();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nama kategori sudah pernah disimpan.", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(c_kode == 0 || row_txtnama.equals(row_txttemp_kode))
                {
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("UPDATE tabelkategori SET nama='" + row_txtnama + "',no_rak='" + row_txtrak + "' WHERE id = '" + row_id + "'");
                        JOptionPane.showMessageDialog(null, "Berhasil mengubah data.");
                        btnadd.doClick();
                        konek.closekoneksi();
                        GetData();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nama kategori sudah pernah disimpan.", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        btnadd.doClick();
    }//GEN-LAST:event_btncancelActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        lbl_action.setForeground(Color.black);
        lbl_action.setText("Tambah Data");
        datatable.clearSelection();
        TxtEmpty();
        BtnEnabled(false);
        btnsave.setText("Simpan");
        txtnama.requestFocus();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if(ok==0) {
            try {
                String row_id = txtid.getText();
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("DELETE FROM tabelkategori WHERE id = '" + row_id + "'");
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
                btnadd.doClick();
                konek.closekoneksi();
                GetData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmbarangKategori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void datatableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datatableKeyPressed

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GetData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtno_rakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtno_rakKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)){
            JOptionPane.showMessageDialog(null, "Inputan hanya boleh angka", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtno_rakKeyTyped

    private void txttemp_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttemp_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttemp_namaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
        new mainview2().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(40);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
       cari();
    }//GEN-LAST:event_cariActionPerformed

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
            java.util.logging.Logger.getLogger(FrmbarangKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmbarangKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmbarangKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmbarangKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            FrmbarangKategori2 dialog = new FrmbarangKategori2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton cari;
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_action;
    private javax.swing.JLabel lblcount_rows;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextPane txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno_rak;
    private javax.swing.JTextField txttemp_nama;
    // End of variables declaration//GEN-END:variables
}
