/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.User_reg.Views;

import App.modules.main_menu.model.Config;
import App.modules.users.Admin.Model.bll.Admin_BLL;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Jorge
 */
public class Change_User_reg extends javax.swing.JFrame {

    /**
     * Creates new form Create_Admin
     */
    public Change_User_reg() {
        initComponents();
        
        /*
        this.setTitle("Admin_Table");
        this.setSize(520,550);//ancho x alto
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Admin/views/img/administrator.png");
	this.setIconImage(image);   
        Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
        Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());        
        
        ////Cerrar ventana
       
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
             
                dispose();
                 new interfaz_Admin().setVisible(true); 
                                              
            }
        });
        
        */
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AdDate_birthday = new javax.swing.JLabel();
        AdMobiltext = new javax.swing.JTextField();
        AdActivity = new javax.swing.JLabel();
        AdAvatar = new javax.swing.JLabel();
        AdUsname = new javax.swing.JLabel();
        AdUsernametext = new javax.swing.JTextField();
        AdPass = new javax.swing.JLabel();
        AdId = new javax.swing.JLabel();
        AdSurname = new javax.swing.JLabel();
        AdActivitytext = new javax.swing.JTextField();
        Admobil = new javax.swing.JLabel();
        AdNametext = new javax.swing.JTextField();
        ADEmailtext = new javax.swing.JTextField();
        AdName = new javax.swing.JLabel();
        AdSurnametext = new javax.swing.JTextField();
        AdEmail = new javax.swing.JLabel();
        Addatebirthdaytext = new com.toedter.calendar.JDateChooser();
        AdIDtext = new javax.swing.JFormattedTextField();
        AdPasstext = new javax.swing.JPasswordField();
        Ad_ID_label = new javax.swing.JLabel();
        Ad_name_label = new javax.swing.JLabel();
        Ad_surname_label = new javax.swing.JLabel();
        Ad_date_birthday_label = new javax.swing.JLabel();
        Ad_mobil_label = new javax.swing.JLabel();
        Ad_email_label = new javax.swing.JLabel();
        Ad_user_name_label = new javax.swing.JLabel();
        Ad_pass_label = new javax.swing.JLabel();
        Ad_activity_label = new javax.swing.JLabel();
        Status_combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AdReturnbtn = new javax.swing.JButton();
        AdSavebtn = new javax.swing.JButton();
        AdAvartaimg = new javax.swing.JLabel();
        AdChange_Avatar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Personal information"));

        AdDate_birthday.setText("Date Birthday:");

        AdMobiltext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdMobiltextActionPerformed(evt);
            }
        });
        AdMobiltext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdMobiltextKeyReleased(evt);
            }
        });

        AdActivity.setText("Actividad:");

        AdAvatar.setText("Status");

        AdUsname.setText("User name:");

        AdUsernametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdUsernametextKeyReleased(evt);
            }
        });

        AdPass.setText("Password:");

        AdId.setText("ID:");

        AdSurname.setText("Surname");

        AdActivitytext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdActivitytextKeyReleased(evt);
            }
        });

        Admobil.setText("Mobil:");

        AdNametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdNametextActionPerformed(evt);
            }
        });
        AdNametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdNametextKeyReleased(evt);
            }
        });

        ADEmailtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADEmailtextKeyReleased(evt);
            }
        });

        AdName.setText("Name");

        AdSurnametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdSurnametextKeyReleased(evt);
            }
        });

        AdEmail.setText("Email:");

        Addatebirthdaytext.setDateFormatString("");

        AdIDtext.setEnabled(false);

        AdPasstext.setText("jPasswordField1");
        AdPasstext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AdPasstextFocusGained(evt);
            }
        });
        AdPasstext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AdPasstextKeyReleased(evt);
            }
        });

        Status_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Outline" }));
        Status_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_comboActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/utils/img_app/img/1458019522_gtk-about.png"))); // NOI18N
        jLabel3.setToolTipText("Ej: xxxx@gmail.com");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/utils/img_app/img/1458019522_gtk-about.png"))); // NOI18N
        jLabel4.setToolTipText("No mas de tres cifras");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/utils/img_app/img/1458019522_gtk-about.png"))); // NOI18N
        jLabel5.setToolTipText("8 caracteres como minimo, una mayuscula o simbolo.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AdAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(AdEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ad_email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ADEmailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AdPass, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AdActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(AdDate_birthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                                .addComponent(AdId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(AdName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(AdSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AdUsname, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Admobil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AdUsernametext)
                                        .addComponent(AdActivitytext)
                                        .addComponent(AdMobiltext)
                                        .addComponent(AdSurnametext)
                                        .addComponent(AdNametext)
                                        .addComponent(Addatebirthdaytext, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(AdIDtext)
                                        .addComponent(AdPasstext)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ad_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(Ad_ID_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ad_surname_label, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(Ad_date_birthday_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ad_mobil_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ad_user_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ad_pass_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ad_activity_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AdId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdIDtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Ad_ID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdName)
                    .addComponent(AdNametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ad_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdSurnametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ad_surname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdDate_birthday)
                    .addComponent(Addatebirthdaytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ad_date_birthday_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Admobil)
                        .addComponent(AdMobiltext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Ad_mobil_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADEmailtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AdEmail)
                        .addComponent(jLabel3))
                    .addComponent(Ad_email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdAvatar)
                    .addComponent(Status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdUsname)
                    .addComponent(AdUsernametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ad_user_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdPass)
                    .addComponent(AdPasstext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ad_pass_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ad_activity_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AdActivity)
                        .addComponent(AdActivitytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AdActivity, AdAvatar, AdDate_birthday, AdEmail, AdId, AdName, AdPass, AdSurname, AdUsname, Admobil});

        AdReturnbtn.setText("Return");
        AdReturnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdReturnbtnActionPerformed(evt);
            }
        });

        AdSavebtn.setText("Save");
        AdSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdSavebtnActionPerformed(evt);
            }
        });

        AdAvartaimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdAvartaimg.setText("Avatar");
        AdAvartaimg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AdChange_Avatar.setText("Change Avatar");
        AdChange_Avatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdChange_AvatarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdSavebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdReturnbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdAvartaimg, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(AdChange_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(AdAvartaimg, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdChange_Avatar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdSavebtn)
                        .addGap(18, 18, 18)
                        .addComponent(AdReturnbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdMobiltextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdMobiltextActionPerformed
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_AdMobiltextActionPerformed

    private void AdNametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdNametextActionPerformed
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_AdNametextActionPerformed

    private void AdSavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdSavebtnActionPerformed
        // TODO add your handling code here:
        
        /*
        
         if( Admin_BLL.change_Admin()==true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   dispose();
                  new interfaz_Admin().setVisible(true);                   
               }
           });
             
             //jLabel1.setText("Admin creado con gracia");
             
             timer.setRepeats(false);
             timer.start();
             
             AdSavebtn.setEnabled(false);
             AdCancelbtn.setEnabled(false);
             AdReturnbtn.setEnabled(false);
             AdChange_Avatar.setEnabled(false);
             jLabel1.setOpaque(true);
             jLabel1.setBackground(Color.green);
             jLabel1.setText("Admin modificado correctamente");
             
             
       //this.dispose();
     
        //new interfaz_Admin().setVisible(true);
        
         }
*/
    }//GEN-LAST:event_AdSavebtnActionPerformed

    private void Status_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_comboActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_Status_comboActionPerformed

    private void AdNametextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdNametextKeyReleased
        // TODO add your handling code here:
        
       // Admin_BLL.Change_requests_name();
        
    }//GEN-LAST:event_AdNametextKeyReleased

    private void AdSurnametextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdSurnametextKeyReleased
        // TODO add your handling code here:
        
        // Admin_BLL.Change_requests_surname();
        
    }//GEN-LAST:event_AdSurnametextKeyReleased

    private void AdMobiltextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdMobiltextKeyReleased
        // TODO add your handling code here:
        
         // Admin_BLL.Change_ask_mobil();
    }//GEN-LAST:event_AdMobiltextKeyReleased

    private void ADEmailtextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADEmailtextKeyReleased
        // TODO add your handling code here:
        
        // Admin_BLL.Change_ask_email();
        
    }//GEN-LAST:event_ADEmailtextKeyReleased

    private void AdUsernametextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdUsernametextKeyReleased
        // TODO add your handling code here:
        
        // Admin_BLL.Change_ask_username();
        
    }//GEN-LAST:event_AdUsernametextKeyReleased

    private void AdPasstextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdPasstextKeyReleased
        // TODO add your handling code here:
        
        // Admin_BLL.Change_ask_pass();
        
        
    }//GEN-LAST:event_AdPasstextKeyReleased

    private void AdActivitytextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdActivitytextKeyReleased
        // TODO add your handling code here:
        
        // Admin_BLL.Change_ask_Activity();
        
    }//GEN-LAST:event_AdActivitytextKeyReleased

    private void AdReturnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdReturnbtnActionPerformed
        // TODO add your handling code here:
        /*
        this.dispose();
        
        new interfaz_Admin().setVisible(true);
        */
    }//GEN-LAST:event_AdReturnbtnActionPerformed

    private void AdChange_AvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdChange_AvatarActionPerformed
        // TODO add your handling code here:
        
     // Admin_BLL.Change_Change_Avatar();
        
    }//GEN-LAST:event_AdChange_AvatarActionPerformed

    private void AdPasstextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AdPasstextFocusGained
        // TODO add your handling code here:
        
       // AdPasstext.setText("");
        
    }//GEN-LAST:event_AdPasstextFocusGained

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ADEmailtext;
    public static javax.swing.JLabel AdActivity;
    public static javax.swing.JTextField AdActivitytext;
    public static javax.swing.JLabel AdAvartaimg;
    public static javax.swing.JLabel AdAvatar;
    public static javax.swing.JButton AdChange_Avatar;
    public static javax.swing.JLabel AdDate_birthday;
    public static javax.swing.JLabel AdEmail;
    public static javax.swing.JFormattedTextField AdIDtext;
    public static javax.swing.JLabel AdId;
    public static javax.swing.JTextField AdMobiltext;
    public static javax.swing.JLabel AdName;
    public static javax.swing.JTextField AdNametext;
    public static javax.swing.JLabel AdPass;
    public static javax.swing.JPasswordField AdPasstext;
    public static javax.swing.JButton AdReturnbtn;
    public static javax.swing.JButton AdSavebtn;
    public static javax.swing.JLabel AdSurname;
    public static javax.swing.JTextField AdSurnametext;
    public static javax.swing.JTextField AdUsernametext;
    public static javax.swing.JLabel AdUsname;
    public static javax.swing.JLabel Ad_ID_label;
    public static javax.swing.JLabel Ad_activity_label;
    public static javax.swing.JLabel Ad_date_birthday_label;
    public static javax.swing.JLabel Ad_email_label;
    public static javax.swing.JLabel Ad_mobil_label;
    public static javax.swing.JLabel Ad_name_label;
    public static javax.swing.JLabel Ad_pass_label;
    public static javax.swing.JLabel Ad_surname_label;
    public static javax.swing.JLabel Ad_user_name_label;
    public static com.toedter.calendar.JDateChooser Addatebirthdaytext;
    public static javax.swing.JLabel Admobil;
    public static javax.swing.JComboBox<String> Status_combo;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}