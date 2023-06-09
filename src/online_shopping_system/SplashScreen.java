/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_shopping_system;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author MIRAFLORES, JOHN PAUL S. - BSIT 2F
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */

    public SplashScreen() {
        initComponents();
        loadingBar.setUI(new BasicProgressBarUI(){});

    }
    
    int xMouse;
    int yMouse;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        chkTitle = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        loadingValue = new javax.swing.JLabel();
        loadingText = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        GIFbg = new javax.swing.JLabel();
        bgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelBG.setBackground(new java.awt.Color(0, 204, 255));
        jPanelBG.setForeground(new java.awt.Color(0, 0, 0));
        jPanelBG.setPreferredSize(new java.awt.Dimension(926, 546));
        jPanelBG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelBGMouseDragged(evt);
            }
        });
        jPanelBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBGMousePressed(evt);
            }
        });
        jPanelBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkTitle.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        chkTitle.setForeground(new java.awt.Color(255, 255, 255));
        chkTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_shopping_system/Assets/DIAMONDicoSMALL.gif"))); // NOI18N
        jPanelBG.add(chkTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));

        title3.setFont(new java.awt.Font("Goudy Stout", 3, 36)); // NOI18N
        title3.setForeground(new java.awt.Color(51, 204, 255));
        title3.setText("JP's");
        jPanelBG.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        title1.setFont(new java.awt.Font("Goudy Stout", 3, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(0, 153, 255));
        title1.setText("Jewelry");
        jPanelBG.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        title2.setFont(new java.awt.Font("Goudy Stout", 3, 36)); // NOI18N
        title2.setForeground(new java.awt.Color(0, 102, 204));
        title2.setText("SHOPPING");
        jPanelBG.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        loadingValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadingValue.setForeground(new java.awt.Color(0, 255, 255));
        loadingValue.setText("100 %");
        jPanelBG.add(loadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        loadingText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadingText.setForeground(new java.awt.Color(51, 255, 255));
        loadingText.setText("Loading...");
        jPanelBG.add(loadingText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        loadingBar.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        loadingBar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 204, 255)));
        jPanelBG.add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 500, -1));

        GIFbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_shopping_system/Assets/shha.gif"))); // NOI18N
        GIFbg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        GIFbg.setMaximumSize(new java.awt.Dimension(926, 546));
        GIFbg.setPreferredSize(new java.awt.Dimension(926, 546));
        jPanelBG.add(GIFbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 500, 250));

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_shopping_system/Assets/bg1.png"))); // NOI18N
        bgImage.setPreferredSize(new java.awt.Dimension(926, 546));
        jPanelBG.add(bgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelBGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBGMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanelBGMousePressed

    private void jPanelBGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBGMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanelBGMouseDragged

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       SplashScreen load = new SplashScreen();
       load.setVisible(true);

       try{
           for(int loading = 0;loading <= 100; loading++){
               //Thread.sleep(100);
               load.loadingValue.setText(loading + "%");
               
               if(loading <= 10){
                   Thread.sleep((long)(Math.random()*150));
                   load.loadingText.setText("Loading panels...");
               }else if(loading <= 20){
                   Thread.sleep((long)(Math.random()*200));
                   load.loadingText.setText("Preparing screens...");
               }else if(loading <= 50){
                   Thread.sleep((long)(Math.random()*300));
                   load.loadingText.setText("Connecting to the database...");
               }else if(loading <= 75){
                   Thread.sleep((long)(Math.random()*500));
                   load.loadingText.setText("Connected successfully...");
               }else if(loading <= 80){
                   Thread.sleep((long)(Math.random()*1000));
                   loading = loading + 2;
                   load.loadingText.setText("Launching application...");
               }else if(loading <= 90){
                   Thread.sleep((long)(Math.random()*1000));
                   load.loadingText.setText("Launching application... Please wait.");
               }else if(loading == 100){
                   LoginSystem ls = new LoginSystem();
                   ls.setVisible(true);
                   ls.setLocationRelativeTo(load);
                   ls.setSize(926,546);
                   load.dispose();
               }
               load.loadingBar.setValue(loading);
           }
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);           
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GIFbg;
    private javax.swing.JLabel bgImage;
    private javax.swing.JLabel chkTitle;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel loadingText;
    private javax.swing.JLabel loadingValue;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables
}
