/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_shopping_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class adminPanel extends javax.swing.JFrame {

    /**
     * Creates new form adminPanel
     */
    private static final String URL = "jdbc:mysql://localhost:3306/online_shopping_system?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@theHouseof25";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rset = null;
    int q, i, enumb, deleteItem;
    DefaultTableModel RecordTable;
    ResultSetMetaData rsmData;
    Vector columnData;

    public adminPanel() {
        initComponents();
    }

    int xMouse;
    int yMouse;

    public void customerTable() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM customer WHERE USERNAME != 'admin'");

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) custTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("CUSTOMER_ID"));
                    columnData.add(rset.getString("USERNAME"));
                    columnData.add(rset.getString("PASSWORD"));
                    columnData.add(rset.getString("LNAME"));
                    columnData.add(rset.getString("FNAME"));
                    columnData.add(rset.getString("BIRTHDATE"));
                    columnData.add(rset.getString("SEX"));
                    columnData.add(rset.getString("CUSTOMER_EMAIL"));
                    columnData.add(rset.getString("CUSTOMER_PNUMBER"));
                    columnData.add(rset.getString("ADDRESS"));
                    columnData.add(rset.getString("CITY"));
                    columnData.add(rset.getString("ZIP"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void productTable() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM product");

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) prodTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("PRODUCT_NAME"));
                    columnData.add(rset.getString("PRODUCT_PRICE"));
                    columnData.add(rset.getString("PRODUCT_STOCK"));
                    columnData.add(rset.getString("PRODUCT_BRAND"));
                    columnData.add(rset.getString("PRODUCT_CATEGORY"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cartTable() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM cart");

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) cartTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("CART_ID"));
                    columnData.add(rset.getString("CART_PRODUCTNAME"));
                    columnData.add(rset.getString("CART_PRODUCTPRICE"));
                    columnData.add(rset.getString("CART_QUANT"));
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("CUSTOMER_ID"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void paymentTable() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM payment");

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) paymentTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("PAYMENT_ID"));
                    columnData.add(rset.getString("PAYMENT_AMOUNT"));
                    columnData.add(rset.getString("CUSTOMER_ID"));
                    columnData.add(rset.getString("ADDRESS_ID"));
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("PRODUCT_NAME"));
                    columnData.add(rset.getString("PRODUCT_QUANTITY"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void orderTable() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM orders");

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) ordersTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("order_id"));
                    columnData.add(rset.getString("payment_method"));
                    columnData.add(rset.getString("payment_total"));
                    columnData.add(rset.getString("customer_id"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        HealPanel = new javax.swing.JPanel();
        jBtnClose = new javax.swing.JButton();
        jBtnMinimize = new javax.swing.JButton();
        HeadLabel = new javax.swing.JLabel();
        jLogoutBtn = new javax.swing.JButton();
        WelcomeUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        shoppingSystem = new javax.swing.JTabbedPane();
        customerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTbl = new javax.swing.JTable();
        custID = new javax.swing.JTextField();
        lblcustID = new javax.swing.JLabel();
        custUSERNAME = new javax.swing.JTextField();
        lblcustUSERNAME = new javax.swing.JLabel();
        custPASSWORD = new javax.swing.JTextField();
        lblcustPASSWORD = new javax.swing.JLabel();
        custLNAME = new javax.swing.JTextField();
        lblcustLNAME = new javax.swing.JLabel();
        custFNAME = new javax.swing.JTextField();
        lblcustFNAME = new javax.swing.JLabel();
        custBDATE = new javax.swing.JTextField();
        lblcustBDATE = new javax.swing.JLabel();
        custSEX = new javax.swing.JTextField();
        lblcustSEX = new javax.swing.JLabel();
        custEMAIL = new javax.swing.JTextField();
        lblcustEMAIL = new javax.swing.JLabel();
        custCONTACT = new javax.swing.JTextField();
        lblcustCONTACT = new javax.swing.JLabel();
        custADDRESS = new javax.swing.JTextField();
        lblcustADDRESS = new javax.swing.JLabel();
        custCITY = new javax.swing.JTextField();
        lblcustCITY = new javax.swing.JLabel();
        custZIP = new javax.swing.JTextField();
        lblcustZIP = new javax.swing.JLabel();
        custEDIT = new javax.swing.JButton();
        custADD = new javax.swing.JButton();
        custCLR = new javax.swing.JButton();
        custDEL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        custSEARCH = new javax.swing.JTextField();
        searchCUST = new javax.swing.JButton();
        productPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prodTbl = new javax.swing.JTable();
        prodID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        prodNAME = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        prodPRICE = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        prodCATEGORY = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        prodSTOCK = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        prodBRAND = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        prodEDIT = new javax.swing.JButton();
        prodADD = new javax.swing.JButton();
        prodCLR = new javax.swing.JButton();
        prodDEL = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        prodSEARCH = new javax.swing.JTextField();
        searchPROD = new javax.swing.JButton();
        cartPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTbl = new javax.swing.JTable();
        cartID = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cartNAME = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cartPRICE = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cartCustID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cartQUANT = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cartProdID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cartEDIT = new javax.swing.JButton();
        cartADD = new javax.swing.JButton();
        cartCLR = new javax.swing.JButton();
        cartDEL = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cartSEARCH = new javax.swing.JTextField();
        searchCART = new javax.swing.JButton();
        paymentPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymentTbl = new javax.swing.JTable();
        payID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        payAMOUNT = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        payCustID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        payNAME = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        payADDRESS = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        payProdID = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        payQUANT = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        payEDIT = new javax.swing.JButton();
        payADD = new javax.swing.JButton();
        payCLR = new javax.swing.JButton();
        payDEL = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        paySEARCH = new javax.swing.JTextField();
        searchPAY = new javax.swing.JButton();
        orderPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ordersTbl = new javax.swing.JTable();
        orderID = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        orderMETHOD = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        orderTOTAL = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        orderCustID = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        orderEDIT = new javax.swing.JButton();
        orderADD = new javax.swing.JButton();
        orderCLR = new javax.swing.JButton();
        orderDEL = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        orderSEARCH = new javax.swing.JTextField();
        searchORDER = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        HealPanel.setBackground(new java.awt.Color(15, 45, 66));
        HealPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HealPanelMouseDragged(evt);
            }
        });
        HealPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HealPanelMousePressed(evt);
            }
        });
        HealPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnClose.setBackground(new java.awt.Color(0, 102, 204));
        jBtnClose.setFont(new java.awt.Font("Gulim", 0, 18)); // NOI18N
        jBtnClose.setForeground(new java.awt.Color(255, 255, 255));
        jBtnClose.setText("x");
        jBtnClose.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCloseActionPerformed(evt);
            }
        });
        HealPanel.add(jBtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 24, 27, -1));

        jBtnMinimize.setBackground(new java.awt.Color(0, 102, 204));
        jBtnMinimize.setFont(new java.awt.Font("Gulim", 0, 18)); // NOI18N
        jBtnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMinimize.setText("-");
        jBtnMinimize.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMinimizeActionPerformed(evt);
            }
        });
        HealPanel.add(jBtnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 24, 27, -1));

        HeadLabel.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        HeadLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeadLabel.setText("J's JS | ADMIN PANEL");
        HealPanel.add(HeadLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLogoutBtn.setBackground(new java.awt.Color(0, 102, 204));
        jLogoutBtn.setFont(new java.awt.Font("Gulim", 0, 10)); // NOI18N
        jLogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        jLogoutBtn.setText("logout");
        jLogoutBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutBtnActionPerformed(evt);
            }
        });
        HealPanel.add(jLogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 80, -1));

        WelcomeUser.setBackground(new java.awt.Color(255, 255, 255));
        WelcomeUser.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        WelcomeUser.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_shopping_system/Assets/DIAMONDicoSMALL.gif"))); // NOI18N
        WelcomeUser.setText("Welcome, Username!");
        HealPanel.add(WelcomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 10, 270, 60));

        jPanel1.setBackground(new java.awt.Color(108, 122, 137));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        custTbl.setAutoCreateRowSorter(true);
        custTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "USERNAME", "PASSWORD", "LAST NAME", "FIRST NAME", "BIRTH DATE", "SEX", "E-MAIL", "CONTACT", "ADDRESS", "CITY", "ZIP"
            }
        ));
        custTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custTbl);
        if (custTbl.getColumnModel().getColumnCount() > 0) {
            custTbl.getColumnModel().getColumn(4).setHeaderValue("PRODUCT ID");
            custTbl.getColumnModel().getColumn(5).setHeaderValue("PRODUCT NAME");
            custTbl.getColumnModel().getColumn(6).setHeaderValue("SEX");
            custTbl.getColumnModel().getColumn(7).setHeaderValue("E-MAIL");
            custTbl.getColumnModel().getColumn(8).setHeaderValue("CONTACT");
            custTbl.getColumnModel().getColumn(9).setHeaderValue("ADDRESS");
            custTbl.getColumnModel().getColumn(10).setHeaderValue("CITY");
            custTbl.getColumnModel().getColumn(11).setHeaderValue("ZIP");
        }

        customerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 840, 140));

        custID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, -1));

        lblcustID.setText("ID");
        customerPanel.add(lblcustID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        custUSERNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custUSERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 150, -1));

        lblcustUSERNAME.setText("USERNAME");
        customerPanel.add(lblcustUSERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        custPASSWORD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 150, -1));

        lblcustPASSWORD.setText("PASSWORD");
        customerPanel.add(lblcustPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        custLNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 150, -1));

        lblcustLNAME.setText("LAST NAME");
        customerPanel.add(lblcustLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        custFNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custFNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 150, -1));

        lblcustFNAME.setText("FIRST NAME");
        customerPanel.add(lblcustFNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        custBDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custBDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 150, -1));

        lblcustBDATE.setText("BIRTHDATE");
        customerPanel.add(lblcustBDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        custSEX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custSEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 150, -1));

        lblcustSEX.setText("SEX");
        customerPanel.add(lblcustSEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        custEMAIL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 150, -1));

        lblcustEMAIL.setText("EMAIL");
        customerPanel.add(lblcustEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        custCONTACT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custCONTACT, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 140, -1));

        lblcustCONTACT.setText("CONTACT");
        customerPanel.add(lblcustCONTACT, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        custADDRESS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 140, -1));

        lblcustADDRESS.setText("ADDRESS");
        customerPanel.add(lblcustADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        custCITY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custCITY, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 140, -1));

        lblcustCITY.setText("CITY");
        customerPanel.add(lblcustCITY, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        custZIP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        customerPanel.add(custZIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 140, -1));

        lblcustZIP.setText("ZIP");
        customerPanel.add(lblcustZIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        custEDIT.setBackground(new java.awt.Color(51, 204, 0));
        custEDIT.setText("UPDATE");
        custEDIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        custEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custEDITActionPerformed(evt);
            }
        });
        customerPanel.add(custEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 80, -1));

        custADD.setBackground(new java.awt.Color(0, 102, 204));
        custADD.setText("INSERT");
        custADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        custADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custADDActionPerformed(evt);
            }
        });
        customerPanel.add(custADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 80, -1));

        custCLR.setBackground(new java.awt.Color(255, 255, 255));
        custCLR.setForeground(new java.awt.Color(0, 0, 0));
        custCLR.setText("CLEAR");
        custCLR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        custCLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custCLRActionPerformed(evt);
            }
        });
        customerPanel.add(custCLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 80, -1));

        custDEL.setBackground(new java.awt.Color(204, 0, 51));
        custDEL.setText("REMOVE");
        custDEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        custDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custDELActionPerformed(evt);
            }
        });
        customerPanel.add(custDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 80, -1));

        jLabel1.setText("SEX: ");
        customerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        custSEARCH.setForeground(new java.awt.Color(153, 153, 153));
        custSEARCH.setText("SEARCH");
        custSEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        custSEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                custSEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                custSEARCHFocusLost(evt);
            }
        });
        customerPanel.add(custSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        searchCUST.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        searchCUST.setText("SEARCH");
        searchCUST.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchCUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCUSTActionPerformed(evt);
            }
        });
        customerPanel.add(searchCUST, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        shoppingSystem.addTab("CUSTOMERS", customerPanel);

        productPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prodTbl.setAutoCreateRowSorter(true);
        prodTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PRICE", "STOCK", "BRAND", "CATEGORY"
            }
        ));
        prodTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(prodTbl);

        productPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 840, 140));

        prodID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 140, -1));

        jLabel13.setText("ID");
        productPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        prodNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        jLabel14.setText("NAME");
        productPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        prodPRICE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodPRICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 140, -1));

        jLabel15.setText("PRICE");
        productPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        prodCATEGORY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodCATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 150, -1));

        jLabel16.setText("CATEGORY");
        productPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        prodSTOCK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodSTOCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 150, -1));

        jLabel17.setText("STOCK");
        productPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        prodBRAND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productPanel.add(prodBRAND, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 150, -1));

        jLabel18.setText("BRAND");
        productPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        prodEDIT.setBackground(new java.awt.Color(51, 204, 0));
        prodEDIT.setText("UPDATE");
        prodEDIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodEDITActionPerformed(evt);
            }
        });
        productPanel.add(prodEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 80, -1));

        prodADD.setBackground(new java.awt.Color(0, 102, 204));
        prodADD.setText("INSERT");
        prodADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodADDActionPerformed(evt);
            }
        });
        productPanel.add(prodADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 80, -1));

        prodCLR.setBackground(new java.awt.Color(255, 255, 255));
        prodCLR.setForeground(new java.awt.Color(0, 0, 0));
        prodCLR.setText("CLEAR");
        prodCLR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodCLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodCLRActionPerformed(evt);
            }
        });
        productPanel.add(prodCLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 80, -1));

        prodDEL.setBackground(new java.awt.Color(204, 0, 51));
        prodDEL.setText("REMOVE");
        prodDEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prodDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodDELActionPerformed(evt);
            }
        });
        productPanel.add(prodDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 80, -1));

        jLabel2.setText("CATEGORY: ");
        productPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        prodSEARCH.setForeground(new java.awt.Color(153, 153, 153));
        prodSEARCH.setText("SEARCH");
        prodSEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prodSEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                prodSEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                prodSEARCHFocusLost(evt);
            }
        });
        productPanel.add(prodSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        searchPROD.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        searchPROD.setText("SEARCH");
        searchPROD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchPROD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPRODActionPerformed(evt);
            }
        });
        productPanel.add(searchPROD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        shoppingSystem.addTab("PRODUCTS", productPanel);

        cartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cartTbl.setAutoCreateRowSorter(true);
        cartTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PRICE", "QUANTITY", "PRODUCT ID", "CUSTOMER ID"
            }
        ));
        cartTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cartTbl);

        cartPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 840, 140));

        cartID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 140, -1));

        jLabel19.setText("ID");
        cartPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        cartNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        jLabel20.setText("NAME");
        cartPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        cartPRICE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartPRICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 140, -1));

        jLabel21.setText("PRICE");
        cartPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        cartCustID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartCustID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 150, -1));

        jLabel22.setText("CUSTOMER ID");
        cartPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        cartQUANT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartQUANT, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 150, -1));

        jLabel23.setText("QUANTITY");
        cartPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        cartProdID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartPanel.add(cartProdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 150, -1));

        jLabel24.setText("PRODUCT ID");
        cartPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        cartEDIT.setBackground(new java.awt.Color(51, 204, 0));
        cartEDIT.setText("UPDATE");
        cartEDIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cartEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartEDITActionPerformed(evt);
            }
        });
        cartPanel.add(cartEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 80, -1));

        cartADD.setBackground(new java.awt.Color(0, 102, 204));
        cartADD.setText("INSERT");
        cartADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cartADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartADDActionPerformed(evt);
            }
        });
        cartPanel.add(cartADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 80, -1));

        cartCLR.setBackground(new java.awt.Color(255, 255, 255));
        cartCLR.setForeground(new java.awt.Color(0, 0, 0));
        cartCLR.setText("CLEAR");
        cartCLR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cartCLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartCLRActionPerformed(evt);
            }
        });
        cartPanel.add(cartCLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 80, -1));

        cartDEL.setBackground(new java.awt.Color(204, 0, 51));
        cartDEL.setText("REMOVE");
        cartDEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cartDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartDELActionPerformed(evt);
            }
        });
        cartPanel.add(cartDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 80, -1));

        jLabel3.setText("CUSTOMER ID: ");
        cartPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cartSEARCH.setForeground(new java.awt.Color(153, 153, 153));
        cartSEARCH.setText("SEARCH");
        cartSEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartSEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cartSEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cartSEARCHFocusLost(evt);
            }
        });
        cartPanel.add(cartSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        searchCART.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        searchCART.setText("SEARCH");
        searchCART.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchCART.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCARTActionPerformed(evt);
            }
        });
        cartPanel.add(searchCART, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        shoppingSystem.addTab("CART", cartPanel);

        paymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentTbl.setAutoCreateRowSorter(true);
        paymentTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "AMOUNT", "CUSTOMER ID", "ADDRESS", "PRODUCT ID", "PRODUCT NAME", "PRODUCT QUANTITY"
            }
        ));
        paymentTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(paymentTbl);
        if (paymentTbl.getColumnModel().getColumnCount() > 0) {
            paymentTbl.getColumnModel().getColumn(4).setHeaderValue("PRODUCT ID");
            paymentTbl.getColumnModel().getColumn(5).setHeaderValue("PRODUCT NAME");
            paymentTbl.getColumnModel().getColumn(6).setHeaderValue("PRODUCT QUANTITY");
        }

        paymentPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 840, 140));

        payID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, -1));

        jLabel25.setText("ID");
        paymentPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        payAMOUNT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payAMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        jLabel26.setText("AMOUNT");
        paymentPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        payCustID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payCustID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 150, -1));

        jLabel27.setText("CUSTOMER ID");
        paymentPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        payNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 150, -1));

        jLabel28.setText("PRODUCT NAME");
        paymentPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        payADDRESS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 150, -1));

        jLabel29.setText("ADDRESS");
        paymentPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        payProdID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payProdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 150, -1));

        jLabel30.setText("PRODUCT ID");
        paymentPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        payQUANT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentPanel.add(payQUANT, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 150, -1));

        jLabel31.setText("QUANTITY");
        paymentPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        payEDIT.setBackground(new java.awt.Color(51, 204, 0));
        payEDIT.setText("UPDATE");
        payEDIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payEDITActionPerformed(evt);
            }
        });
        paymentPanel.add(payEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 80, -1));

        payADD.setBackground(new java.awt.Color(0, 102, 204));
        payADD.setText("INSERT");
        payADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payADDActionPerformed(evt);
            }
        });
        paymentPanel.add(payADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 80, -1));

        payCLR.setBackground(new java.awt.Color(255, 255, 255));
        payCLR.setForeground(new java.awt.Color(0, 0, 0));
        payCLR.setText("CLEAR");
        payCLR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payCLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payCLRActionPerformed(evt);
            }
        });
        paymentPanel.add(payCLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 80, -1));

        payDEL.setBackground(new java.awt.Color(204, 0, 51));
        payDEL.setText("REMOVE");
        payDEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payDELActionPerformed(evt);
            }
        });
        paymentPanel.add(payDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 80, -1));

        jLabel4.setText("CUSTOMER ID: ");
        paymentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        paySEARCH.setForeground(new java.awt.Color(153, 153, 153));
        paySEARCH.setText("SEARCH");
        paySEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paySEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                paySEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                paySEARCHFocusLost(evt);
            }
        });
        paymentPanel.add(paySEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        searchPAY.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        searchPAY.setText("SEARCH");
        searchPAY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchPAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPAYActionPerformed(evt);
            }
        });
        paymentPanel.add(searchPAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        shoppingSystem.addTab("PAYMENT", paymentPanel);

        orderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordersTbl.setAutoCreateRowSorter(true);
        ordersTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "METHOD", "TOTAL", "CUSTOMER ID"
            }
        ));
        ordersTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersTblMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ordersTbl);

        orderPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 840, 140));

        orderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderPanel.add(orderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 140, -1));

        jLabel32.setText("ID");
        orderPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        orderMETHOD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderPanel.add(orderMETHOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 140, -1));

        jLabel33.setText("METHOD");
        orderPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        orderTOTAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderPanel.add(orderTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 150, -1));

        jLabel34.setText("TOTAL");
        orderPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        orderCustID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderPanel.add(orderCustID, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 150, -1));

        jLabel36.setText("CUSTOMER ID");
        orderPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        orderEDIT.setBackground(new java.awt.Color(51, 204, 0));
        orderEDIT.setText("UPDATE");
        orderEDIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderEDITActionPerformed(evt);
            }
        });
        orderPanel.add(orderEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 80, -1));

        orderADD.setBackground(new java.awt.Color(0, 102, 204));
        orderADD.setText("INSERT");
        orderADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderADDActionPerformed(evt);
            }
        });
        orderPanel.add(orderADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 80, -1));

        orderCLR.setBackground(new java.awt.Color(255, 255, 255));
        orderCLR.setForeground(new java.awt.Color(0, 0, 0));
        orderCLR.setText("CLEAR");
        orderCLR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderCLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCLRActionPerformed(evt);
            }
        });
        orderPanel.add(orderCLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 80, -1));

        orderDEL.setBackground(new java.awt.Color(204, 0, 51));
        orderDEL.setText("REMOVE");
        orderDEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDELActionPerformed(evt);
            }
        });
        orderPanel.add(orderDEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 80, -1));

        jLabel5.setText("CUSTOMER ID: ");
        orderPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        orderSEARCH.setForeground(new java.awt.Color(153, 153, 153));
        orderSEARCH.setText("SEARCH");
        orderSEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderSEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderSEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                orderSEARCHFocusLost(evt);
            }
        });
        orderPanel.add(orderSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        searchORDER.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        searchORDER.setText("SEARCH");
        searchORDER.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchORDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchORDERActionPerformed(evt);
            }
        });
        orderPanel.add(searchORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        shoppingSystem.addTab("ORDERS", orderPanel);

        jPanel1.add(shoppingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 890, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private JFrame frame;
    private void jBtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCloseActionPerformed
        frame = new JFrame("Close");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Online Shopping",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtnCloseActionPerformed

    private void jBtnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMinimizeActionPerformed
        this.setState(frame.ICONIFIED);
    }//GEN-LAST:event_jBtnMinimizeActionPerformed

    private void jLogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutBtnActionPerformed
        frame = new JFrame("LogOut!");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Online Shopping",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            LoginSystem ls = new LoginSystem();
            ls.setVisible(true);
            ls.setLocationRelativeTo(this);
            this.dispose();
        }
    }//GEN-LAST:event_jLogoutBtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        customerTable();
        productTable();
        cartTable();
        paymentTable();
        orderTable();
    }//GEN-LAST:event_formWindowActivated

    private void custTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTblMouseClicked
        RecordTable = (DefaultTableModel) custTbl.getModel();
        int SelectedRows = custTbl.getSelectedRow();

        custID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        custUSERNAME.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        custPASSWORD.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        custLNAME.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        custFNAME.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        custBDATE.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
        custSEX.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
        custEMAIL.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
        custCONTACT.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
        custADDRESS.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
        custCITY.setText(RecordTable.getValueAt(SelectedRows, 10).toString());
        custZIP.setText(RecordTable.getValueAt(SelectedRows, 11).toString());
    }//GEN-LAST:event_custTblMouseClicked

    private void custADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custADDActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, custID.getText());
            ps.setString(2, custUSERNAME.getText());
            ps.setString(3, custPASSWORD.getText());
            ps.setString(4, custLNAME.getText());
            ps.setString(5, custFNAME.getText());
            ps.setString(6, custBDATE.getText());
            ps.setString(7, custSEX.getText());
            ps.setString(8, custEMAIL.getText());
            ps.setString(9, custCONTACT.getText());
            ps.setString(10, custADDRESS.getText());
            ps.setString(11, custCITY.getText());
            ps.setString(12, custZIP.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Customer is Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer is not Inserted");
            }
            customerTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_custADDActionPerformed

    private void custEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custEDITActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("UPDATE customer "
                    + "SET "
                    + "USERNAME = ?,         "
                    + "PASSWORD = ?,         "
                    + "LNAME = ?,            "
                    + "FNAME = ?,            "
                    + "BIRTHDATE = ?,        "
                    + "SEX = ?,              "
                    + "CUSTOMER_EMAIL = ?,   "
                    + "CUSTOMER_PNUMBER = ?, "
                    + "ADDRESS = ?,          "
                    + "CITY = ?,             "
                    + "ZIP = ?               "
                    + "WHERE CUSTOMER_ID = ? ");

            ps.setString(1, custUSERNAME.getText());
            ps.setString(2, custPASSWORD.getText());
            ps.setString(3, custLNAME.getText());
            ps.setString(4, custFNAME.getText());
            ps.setString(5, custBDATE.getText());
            ps.setString(6, custSEX.getText());
            ps.setString(7, custEMAIL.getText());
            ps.setString(8, custCONTACT.getText());
            ps.setString(9, custADDRESS.getText());
            ps.setString(10, custCITY.getText());
            ps.setString(11, custZIP.getText());
            ps.setString(12, custID.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Customer is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Customer is not updated");
            }
            customerTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_custEDITActionPerformed

    private void custDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custDELActionPerformed
        try {

            //enumb = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this Customer?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ps = conn.prepareStatement("DELETE FROM customer WHERE customer_id = ?");

                ps.setString(1, custID.getText());

                int c = ps.executeUpdate();
                if (c != 0) {
                    JOptionPane.showMessageDialog(this, "Customer Removed!");
                } else {
                    JOptionPane.showMessageDialog(this, "Customer is not Removed!");
                }
                customerTable();

                custUSERNAME.setText("");
                custPASSWORD.setText("");
                custLNAME.setText("");
                custFNAME.setText("");
                custBDATE.setText("");
                custSEX.setText("");
                custEMAIL.setText("");
                custCONTACT.setText("");
                custADDRESS.setText("");
                custCITY.setText("");
                custZIP.setText("");
                custID.setText("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_custDELActionPerformed

    private void custCLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custCLRActionPerformed
        custUSERNAME.setText("");
        custPASSWORD.setText("");
        custLNAME.setText("");
        custFNAME.setText("");
        custBDATE.setText("");
        custSEX.setText("");
        custEMAIL.setText("");
        custCONTACT.setText("");
        custADDRESS.setText("");
        custCITY.setText("");
        custZIP.setText("");
        custID.setText("");
    }//GEN-LAST:event_custCLRActionPerformed

    private void prodEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodEDITActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("UPDATE product                     "
                    + "SET                                "
                    + "PRODUCT_NAME = ?,                  "
                    + "PRODUCT_PRICE = ?,                 "
                    + "PRODUCT_STOCK = PRODUCT_STOCK + ?, "
                    + "PRODUCT_BRAND = ?,                 "
                    + "PRODUCT_CATEGORY = ?               "
                    + "WHERE PRODUCT_ID = ?               ");

            ps.setString(1, prodNAME.getText());
            ps.setString(2, prodPRICE.getText());
            ps.setString(3, prodSTOCK.getText());
            ps.setString(4, prodBRAND.getText());
            ps.setString(5, prodCATEGORY.getText());
            ps.setString(6, prodID.getText());

            ps.executeUpdate();
            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Product is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Product is not updated");
            }
            productTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_prodEDITActionPerformed

    private void prodADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodADDActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?,?)");

            ps.setString(1, prodID.getText());
            ps.setString(2, prodNAME.getText());
            ps.setString(3, prodPRICE.getText());
            ps.setString(4, prodSTOCK.getText());
            ps.setString(5, prodBRAND.getText());
            ps.setString(6, prodCATEGORY.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Product is Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Product is not Inserted");
            }
            productTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_prodADDActionPerformed

    private void prodCLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodCLRActionPerformed
        prodID.setText("");
        prodNAME.setText("");
        prodPRICE.setText("");
        prodSTOCK.setText("");
        prodBRAND.setText("");
        prodCATEGORY.setText("");
    }//GEN-LAST:event_prodCLRActionPerformed

    private void prodDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodDELActionPerformed
        try {

            //enumb = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this Product?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ps = conn.prepareStatement("DELETE FROM product WHERE product_id = ?");

                ps.setString(1, prodID.getText());

                int c = ps.executeUpdate();
                ps.executeUpdate();
                if (c != 0) {
                    JOptionPane.showMessageDialog(this, "Product Removed!");
                } else {
                    JOptionPane.showMessageDialog(this, "Product is not Removed!");
                }
                productTable();

                prodID.setText("");
                prodNAME.setText("");
                prodPRICE.setText("");
                prodSTOCK.setText("");
                prodBRAND.setText("");
                prodCATEGORY.setText("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_prodDELActionPerformed

    private void prodTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTblMouseClicked
        RecordTable = (DefaultTableModel) prodTbl.getModel();
        int SelectedRows = prodTbl.getSelectedRow();

        prodID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        prodNAME.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        prodPRICE.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        prodSTOCK.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        prodBRAND.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        prodCATEGORY.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_prodTblMouseClicked

    private void cartEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartEDITActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("UPDATE cart                "
                    + "SET                        "
                    + "CART_PRODUCTNAME = ?,      "
                    + "CART_PRODUCTPRICE = ?,     "
                    + "CART_QUANT = ?,            "
                    + "PRODUCT_ID = ?,            "
                    + "CUSTOMER_ID = ?            "
                    + "WHERE CART_ID = ?          ");

            ps.setString(1, cartNAME.getText());
            ps.setString(2, cartPRICE.getText());
            ps.setString(3, cartQUANT.getText());
            ps.setString(4, cartProdID.getText());
            ps.setString(5, cartCustID.getText());
            ps.setString(6, cartID.getText());

            ps.executeUpdate();
            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Product is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Product is not updated");
            }
            cartTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_cartEDITActionPerformed

    private void cartADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartADDActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO cart VALUES(?,?,?,?,?,?)");

            ps.setString(1, cartID.getText());
            ps.setString(2, cartNAME.getText());
            ps.setString(3, cartPRICE.getText());
            ps.setString(4, cartQUANT.getText());
            ps.setString(5, cartProdID.getText());
            ps.setString(6, cartCustID.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Product is Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Product is not Inserted");
            }
            cartTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_cartADDActionPerformed

    private void cartCLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartCLRActionPerformed
        cartID.setText("");
        cartNAME.setText("");
        cartPRICE.setText("");
        cartQUANT.setText("");
        cartProdID.setText("");
        cartCustID.setText("");
    }//GEN-LAST:event_cartCLRActionPerformed

    private void cartDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartDELActionPerformed
        try {
            deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this Product?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ps = conn.prepareStatement("DELETE FROM cart WHERE cart_id = ?");

                ps.setString(1, cartID.getText());

                int c = ps.executeUpdate();
                ps.executeUpdate();
                if (c != 0) {
                    JOptionPane.showMessageDialog(this, "Product Removed!");
                } else {
                    JOptionPane.showMessageDialog(this, "Product is not Removed!");
                }
                cartTable();

                cartID.setText("");
                cartNAME.setText("");
                cartPRICE.setText("");
                cartQUANT.setText("");
                cartProdID.setText("");
                cartCustID.setText("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cartDELActionPerformed

    private void cartTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTblMouseClicked
        RecordTable = (DefaultTableModel) cartTbl.getModel();
        int SelectedRows = cartTbl.getSelectedRow();

        cartID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        cartNAME.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        cartPRICE.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        cartQUANT.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        cartProdID.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        cartCustID.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_cartTblMouseClicked

    private void payEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payEDITActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("UPDATE payment             "
                    + "SET                        "
                    + "PAYMENT_AMOUNT = ?,        "
                    + "ADDRESS_ID = ?,            "
                    + "PRODUCT_ID = ?,            "
                    + "PRODUCT_NAME = ?,          "
                    + "PRODUCT_QUANTITY = ?,      "
                    + "CUSTOMER_ID = ?            "
                    + "WHERE PAYMENT_ID = ?       ");

            ps.setString(1, payAMOUNT.getText());
            ps.setString(2, payADDRESS.getText());
            ps.setString(3, payProdID.getText());
            ps.setString(4, payNAME.getText());
            ps.setString(5, payQUANT.getText());
            ps.setString(6, payCustID.getText());
            ps.setString(7, payID.getText());

            ps.executeUpdate();
            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Payment is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Payment is not updated");
            }
            paymentTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_payEDITActionPerformed

    private void payADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payADDActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?,?,?)");

            ps.setString(1, payID.getText());
            ps.setString(2, payAMOUNT.getText());
            ps.setString(3, payADDRESS.getText());
            ps.setString(4, payProdID.getText());
            ps.setString(5, payNAME.getText());
            ps.setString(6, payQUANT.getText());
            ps.setString(7, payCustID.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Payment is Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Payment is not Inserted");
            }
            paymentTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_payADDActionPerformed

    private void payCLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payCLRActionPerformed
        payID.setText("");
        payAMOUNT.setText("");
        payCustID.setText("");
        payADDRESS.setText("");
        payProdID.setText("");
        payNAME.setText("");
        payQUANT.setText("");
    }//GEN-LAST:event_payCLRActionPerformed

    private void payDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payDELActionPerformed
        try {
            deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this from Payment?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ps = conn.prepareStatement("DELETE FROM payment WHERE payment_id = ?");

                ps.setString(1, payID.getText());

                int c = ps.executeUpdate();
                ps.executeUpdate();
                if (c != 0) {
                    JOptionPane.showMessageDialog(this, "Payment Removed!");
                } else {
                    JOptionPane.showMessageDialog(this, "Payment is not Removed!");
                }
                paymentTable();

                payID.setText("");
                payAMOUNT.setText("");
                payCustID.setText("");
                payADDRESS.setText("");
                payProdID.setText("");
                payNAME.setText("");
                payQUANT.setText("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_payDELActionPerformed

    private void paymentTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentTblMouseClicked
        RecordTable = (DefaultTableModel) paymentTbl.getModel();
        int SelectedRows = paymentTbl.getSelectedRow();

        payID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        payAMOUNT.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        payCustID.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        payADDRESS.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        payProdID.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        payNAME.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
        payQUANT.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    }//GEN-LAST:event_paymentTblMouseClicked

    private void orderEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderEDITActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("UPDATE orders              "
                    + "SET                        "
                    + "PAYMENT_METHOD = ?,        "
                    + "PAYMENT_TOTAL = ?,         "
                    + "CUSTOMER_ID = ?            "
                    + "WHERE ORDER_ID = ?         ");

            ps.setString(1, orderMETHOD.getText());
            ps.setString(2, orderTOTAL.getText());
            ps.setString(3, orderCustID.getText());
            ps.setString(4, orderID.getText());

            ps.executeUpdate();
            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Order is Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Order is not updated");
            }
            orderTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_orderEDITActionPerformed

    private void orderADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderADDActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO orders VALUES(?,?,?,?)");

            ps.setString(1, orderID.getText());
            ps.setString(2, orderMETHOD.getText());
            ps.setString(3, orderTOTAL.getText());
            ps.setString(4, orderCustID.getText());

            int c = ps.executeUpdate();
            if (c != 0) {
                JOptionPane.showMessageDialog(this, "Order is Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Order is not Inserted");
            }
            orderTable();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_orderADDActionPerformed

    private void orderCLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCLRActionPerformed
        orderID.setText("");
        orderMETHOD.setText("");
        orderTOTAL.setText("");
        orderCustID.setText("");
    }//GEN-LAST:event_orderCLRActionPerformed

    private void orderDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDELActionPerformed
        try {
            deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this from Orders?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ps = conn.prepareStatement("DELETE FROM orders WHERE order_id = ?");

                ps.setString(1, orderID.getText());

                int c = ps.executeUpdate();
                ps.executeUpdate();
                if (c != 0) {
                    JOptionPane.showMessageDialog(this, "Order Removed!");
                } else {
                    JOptionPane.showMessageDialog(this, "Order is not Removed!");
                }
                orderTable();

                orderID.setText("");
                orderMETHOD.setText("");
                orderTOTAL.setText("");
                orderCustID.setText("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_orderDELActionPerformed

    private void ordersTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersTblMouseClicked
        RecordTable = (DefaultTableModel) ordersTbl.getModel();
        int SelectedRows = ordersTbl.getSelectedRow();

        orderID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        orderMETHOD.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        orderTOTAL.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        orderCustID.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    }//GEN-LAST:event_ordersTblMouseClicked

    private void custSEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custSEARCHFocusGained
        if (custSEARCH.getText().trim().equals("SEARCH")) {
            custSEARCH.setText("");
            custSEARCH.setForeground(Color.black);
        }
    }//GEN-LAST:event_custSEARCHFocusGained

    private void custSEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custSEARCHFocusLost
        if (custSEARCH.getText().trim().equals("")
                || custSEARCH.getText().trim().equals("SEARCH")) {
            custSEARCH.setText("SEARCH");
            custSEARCH.setForeground(Color.gray);
        }
    }//GEN-LAST:event_custSEARCHFocusLost

    private void prodSEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prodSEARCHFocusGained
        if (prodSEARCH.getText().trim().equals("SEARCH")) {
            prodSEARCH.setText("");
            prodSEARCH.setForeground(Color.black);
        }
    }//GEN-LAST:event_prodSEARCHFocusGained

    private void prodSEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prodSEARCHFocusLost
        if (prodSEARCH.getText().trim().equals("")
                || prodSEARCH.getText().trim().equals("SEARCH")) {
            prodSEARCH.setText("SEARCH");
            prodSEARCH.setForeground(Color.gray);
        }
    }//GEN-LAST:event_prodSEARCHFocusLost

    private void cartSEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cartSEARCHFocusGained
        if (cartSEARCH.getText().trim().equals("SEARCH")) {
            cartSEARCH.setText("");
            cartSEARCH.setForeground(Color.black);
        }
    }//GEN-LAST:event_cartSEARCHFocusGained

    private void cartSEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cartSEARCHFocusLost
        if (cartSEARCH.getText().trim().equals("")
                || cartSEARCH.getText().trim().equals("SEARCH")) {
            cartSEARCH.setText("SEARCH");
            cartSEARCH.setForeground(Color.gray);
        }
    }//GEN-LAST:event_cartSEARCHFocusLost

    private void paySEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paySEARCHFocusGained
        if (paySEARCH.getText().trim().equals("SEARCH")) {
            paySEARCH.setText("");
            paySEARCH.setForeground(Color.black);
        }
    }//GEN-LAST:event_paySEARCHFocusGained

    private void paySEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paySEARCHFocusLost
        if (paySEARCH.getText().trim().equals("")
                || paySEARCH.getText().trim().equals("SEARCH")) {
            paySEARCH.setText("SEARCH");
            paySEARCH.setForeground(Color.gray);
        }
    }//GEN-LAST:event_paySEARCHFocusLost

    private void orderSEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderSEARCHFocusGained
        if (orderSEARCH.getText().trim().equals("SEARCH")) {
            orderSEARCH.setText("");
            orderSEARCH.setForeground(Color.black);
        }
    }//GEN-LAST:event_orderSEARCHFocusGained

    private void orderSEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderSEARCHFocusLost
        if (orderSEARCH.getText().trim().equals("")
                || orderSEARCH.getText().trim().equals("SEARCH")) {
            orderSEARCH.setText("SEARCH");
            orderSEARCH.setForeground(Color.gray);
        }
    }//GEN-LAST:event_orderSEARCHFocusLost

    private void searchCUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCUSTActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM customer WHERE sex = ?");

            ps.setString(1, custSEARCH.getText());

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) custTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("CUSTOMER_ID"));
                    columnData.add(rset.getString("USERNAME"));
                    columnData.add(rset.getString("PASSWORD"));
                    columnData.add(rset.getString("LNAME"));
                    columnData.add(rset.getString("FNAME"));
                    columnData.add(rset.getString("BIRTHDATE"));
                    columnData.add(rset.getString("SEX"));
                    columnData.add(rset.getString("CUSTOMER_EMAIL"));
                    columnData.add(rset.getString("CUSTOMER_PNUMBER"));
                    columnData.add(rset.getString("ADDRESS"));
                    columnData.add(rset.getString("CITY"));
                    columnData.add(rset.getString("ZIP"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchCUSTActionPerformed

    private void searchPRODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPRODActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM product WHERE product_category = ?");

            ps.setString(1, prodSEARCH.getText());

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) prodTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("PRODUCT_NAME"));
                    columnData.add(rset.getString("PRODUCT_PRICE"));
                    columnData.add(rset.getString("PRODUCT_STOCK"));
                    columnData.add(rset.getString("PRODUCT_BRAND"));
                    columnData.add(rset.getString("PRODUCT_CATEGORY"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchPRODActionPerformed

    private void searchCARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCARTActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM cart WHERE customer_id = ?");

            ps.setString(1, cartSEARCH.getText());

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) cartTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("CART_ID"));
                    columnData.add(rset.getString("CART_PRODUCTNAME"));
                    columnData.add(rset.getString("CART_PRODUCTPRICE"));
                    columnData.add(rset.getString("CART_QUANT"));
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("CUSTOMER_ID"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchCARTActionPerformed

    private void searchPAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPAYActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM payment WHERE customer_id = ?");

            ps.setString(1, paySEARCH.getText());

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) paymentTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("PAYMENT_ID"));
                    columnData.add(rset.getString("PAYMENT_AMOUNT"));
                    columnData.add(rset.getString("CUSTOMER_ID"));
                    columnData.add(rset.getString("ADDRESS_ID"));
                    columnData.add(rset.getString("PRODUCT_ID"));
                    columnData.add(rset.getString("PRODUCT_NAME"));
                    columnData.add(rset.getString("PRODUCT_QUANTITY"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchPAYActionPerformed

    private void searchORDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchORDERActionPerformed
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM orders WHERE customer_id = ?");

            ps.setString(1, orderSEARCH.getText());

            rset = ps.executeQuery();
            rsmData = rset.getMetaData();

            q = rsmData.getColumnCount();

            RecordTable = (DefaultTableModel) ordersTbl.getModel();
            RecordTable.setRowCount(0);

            while (rset.next()) {
                columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rset.getString("order_id"));
                    columnData.add(rset.getString("payment_method"));
                    columnData.add(rset.getString("payment_total"));
                    columnData.add(rset.getString("customer_id"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchORDERActionPerformed

    private void HealPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HealPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HealPanelMousePressed

    private void HealPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HealPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HealPanelMouseDragged

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
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JPanel HealPanel;
    public static javax.swing.JLabel WelcomeUser;
    private javax.swing.JButton cartADD;
    private javax.swing.JButton cartCLR;
    private javax.swing.JTextField cartCustID;
    private javax.swing.JButton cartDEL;
    private javax.swing.JButton cartEDIT;
    private javax.swing.JTextField cartID;
    private javax.swing.JTextField cartNAME;
    private javax.swing.JTextField cartPRICE;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JTextField cartProdID;
    private javax.swing.JTextField cartQUANT;
    private javax.swing.JTextField cartSEARCH;
    private javax.swing.JTable cartTbl;
    private javax.swing.JButton custADD;
    private javax.swing.JTextField custADDRESS;
    private javax.swing.JTextField custBDATE;
    private javax.swing.JTextField custCITY;
    private javax.swing.JButton custCLR;
    private javax.swing.JTextField custCONTACT;
    private javax.swing.JButton custDEL;
    private javax.swing.JButton custEDIT;
    private javax.swing.JTextField custEMAIL;
    private javax.swing.JTextField custFNAME;
    private javax.swing.JTextField custID;
    private javax.swing.JTextField custLNAME;
    private javax.swing.JTextField custPASSWORD;
    private javax.swing.JTextField custSEARCH;
    private javax.swing.JTextField custSEX;
    private javax.swing.JTable custTbl;
    private javax.swing.JTextField custUSERNAME;
    private javax.swing.JTextField custZIP;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JButton jBtnClose;
    private javax.swing.JButton jBtnMinimize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jLogoutBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblcustADDRESS;
    private javax.swing.JLabel lblcustBDATE;
    private javax.swing.JLabel lblcustCITY;
    private javax.swing.JLabel lblcustCONTACT;
    private javax.swing.JLabel lblcustEMAIL;
    private javax.swing.JLabel lblcustFNAME;
    private javax.swing.JLabel lblcustID;
    private javax.swing.JLabel lblcustLNAME;
    private javax.swing.JLabel lblcustPASSWORD;
    private javax.swing.JLabel lblcustSEX;
    private javax.swing.JLabel lblcustUSERNAME;
    private javax.swing.JLabel lblcustZIP;
    private javax.swing.JButton orderADD;
    private javax.swing.JButton orderCLR;
    private javax.swing.JTextField orderCustID;
    private javax.swing.JButton orderDEL;
    private javax.swing.JButton orderEDIT;
    private javax.swing.JTextField orderID;
    private javax.swing.JTextField orderMETHOD;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JTextField orderSEARCH;
    private javax.swing.JTextField orderTOTAL;
    private javax.swing.JTable ordersTbl;
    private javax.swing.JButton payADD;
    private javax.swing.JTextField payADDRESS;
    private javax.swing.JTextField payAMOUNT;
    private javax.swing.JButton payCLR;
    private javax.swing.JTextField payCustID;
    private javax.swing.JButton payDEL;
    private javax.swing.JButton payEDIT;
    private javax.swing.JTextField payID;
    private javax.swing.JTextField payNAME;
    private javax.swing.JTextField payProdID;
    private javax.swing.JTextField payQUANT;
    private javax.swing.JTextField paySEARCH;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTable paymentTbl;
    private javax.swing.JButton prodADD;
    private javax.swing.JTextField prodBRAND;
    private javax.swing.JTextField prodCATEGORY;
    private javax.swing.JButton prodCLR;
    private javax.swing.JButton prodDEL;
    private javax.swing.JButton prodEDIT;
    private javax.swing.JTextField prodID;
    private javax.swing.JTextField prodNAME;
    private javax.swing.JTextField prodPRICE;
    private javax.swing.JTextField prodSEARCH;
    private javax.swing.JTextField prodSTOCK;
    private javax.swing.JTable prodTbl;
    private javax.swing.JPanel productPanel;
    private javax.swing.JButton searchCART;
    private javax.swing.JButton searchCUST;
    private javax.swing.JButton searchORDER;
    private javax.swing.JButton searchPAY;
    private javax.swing.JButton searchPROD;
    private javax.swing.JTabbedPane shoppingSystem;
    // End of variables declaration//GEN-END:variables
}
