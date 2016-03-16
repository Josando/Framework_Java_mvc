/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.views;

import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.bll.First_menu_config_bll;
import App.modules.main_menu.model.dao.First_menu_config_dao;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class First_menu extends javax.swing.JFrame {

    /**
     * Creates new form Main_menu
     */
    public First_menu() {
        initComponents();

        //Config.getinstance().getTheme();
        

        this.setTitle("Main menu");
        this.setLocationRelativeTo(null);
        this.setSize(720, 500);//ancho x alto
        this.setResizable(false);
        Image image = Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/IMG_0279.JPG");
        this.setIconImage(image);
        Trasparenciabotones();

        ////Cerrar ventana
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                dispose();
                System.exit(0);

            }
        });

    }

    public void Trasparenciabotones() {

        btn_Config.setOpaque(false);
        btn_Config.setContentAreaFilled(false);
        btn_Config.setBorderPainted(false);
        btn_employees.setOpaque(false);
        btn_employees.setContentAreaFilled(false);
        btn_employees.setBorderPainted(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog_config = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        btnAplicar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        Eurobtn = new javax.swing.JRadioButton();
        Libra = new javax.swing.JRadioButton();
        Dolar = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        decimal_1 = new javax.swing.JRadioButton();
        decimal_2 = new javax.swing.JRadioButton();
        decimal_3 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        English = new javax.swing.JRadioButton();
        Español = new javax.swing.JRadioButton();
        Valencia = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        metal = new javax.swing.JRadioButton();
        gtk_windows = new javax.swing.JRadioButton();
        motif = new javax.swing.JRadioButton();
        ninbus = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        formato_1 = new javax.swing.JRadioButton();
        formato_2 = new javax.swing.JRadioButton();
        formato_3 = new javax.swing.JRadioButton();
        formato_4 = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        Json = new javax.swing.JRadioButton();
        Txt_ = new javax.swing.JRadioButton();
        Xml = new javax.swing.JRadioButton();
        buttonGroupmoneda = new javax.swing.ButtonGroup();
        buttonGroup2decimal = new javax.swing.ButtonGroup();
        buttonGroup3lenguaje = new javax.swing.ButtonGroup();
        buttonGroup4themes = new javax.swing.ButtonGroup();
        buttonGroup5fecha = new javax.swing.ButtonGroup();
        buttonGroup6guardado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_employees = new javax.swing.JButton();
        btn_Config = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        Dialog_config.setModal(true);

        btnAplicar.setText("Aplicar");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAplicar)
                .addGap(68, 68, 68)
                .addComponent(btnSalir)
                .addGap(48, 48, 48))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAplicar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Moneda"));

        buttonGroupmoneda.add(Eurobtn);
        Eurobtn.setText("€");
        Eurobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EurobtnActionPerformed(evt);
            }
        });

        buttonGroupmoneda.add(Libra);
        Libra.setText("£");

        buttonGroupmoneda.add(Dolar);
        Dolar.setText("$");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dolar)
                    .addComponent(Eurobtn)
                    .addComponent(Libra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(Eurobtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Libra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dolar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tipo moneda", jPanel3);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Decimales"));

        buttonGroup2decimal.add(decimal_1);
        decimal_1.setText("1 decimal");
        decimal_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decimal_1ActionPerformed(evt);
            }
        });

        buttonGroup2decimal.add(decimal_2);
        decimal_2.setText("2 decimal");

        buttonGroup2decimal.add(decimal_3);
        decimal_3.setText("3 decimal");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(decimal_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decimal_3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(decimal_1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(decimal_1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(decimal_2)
                .addGap(18, 18, 18)
                .addComponent(decimal_3)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Decimales", jPanel4);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Lenguaje"));

        buttonGroup3lenguaje.add(English);
        English.setText("English");
        English.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnglishActionPerformed(evt);
            }
        });

        buttonGroup3lenguaje.add(Español);
        Español.setText("Español");

        buttonGroup3lenguaje.add(Valencia);
        Valencia.setText("Valencia");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Español)
                    .addComponent(English)
                    .addComponent(Valencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(English)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Español)
                .addGap(18, 18, 18)
                .addComponent(Valencia)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lenguaje", jPanel5);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Themes"));

        buttonGroup4themes.add(metal);
        metal.setText("Metal");
        metal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metalActionPerformed(evt);
            }
        });

        buttonGroup4themes.add(gtk_windows);
        gtk_windows.setText("GTK-Windows");

        buttonGroup4themes.add(motif);
        motif.setText("Motif");

        buttonGroup4themes.add(ninbus);
        ninbus.setText("Ninbus");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motif)
                    .addComponent(metal)
                    .addComponent(ninbus)
                    .addComponent(gtk_windows))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(metal)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(gtk_windows)
                .addGap(18, 18, 18)
                .addComponent(motif)
                .addGap(18, 18, 18)
                .addComponent(ninbus))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Themes", jPanel6);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Formato"));

        buttonGroup5fecha.add(formato_1);
        formato_1.setText("dd/mm/yyyy");
        formato_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formato_1ActionPerformed(evt);
            }
        });

        buttonGroup5fecha.add(formato_2);
        formato_2.setText("dd-mm-yyyy");

        buttonGroup5fecha.add(formato_3);
        formato_3.setText("yyyy-mm-dd");

        buttonGroup5fecha.add(formato_4);
        formato_4.setText("yyyy/mm/dd");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(formato_3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formato_2)
                            .addComponent(formato_4)
                            .addComponent(formato_1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(formato_1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(formato_2)
                .addGap(18, 18, 18)
                .addComponent(formato_3)
                .addGap(18, 18, 18)
                .addComponent(formato_4))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Formato fecha", jPanel2);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Guardado"));

        buttonGroup6guardado.add(Json);
        Json.setText("json");

        buttonGroup6guardado.add(Txt_);
        Txt_.setText("txt");

        buttonGroup6guardado.add(Xml);
        Xml.setText("xml");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Json)
                    .addComponent(Txt_)
                    .addComponent(Xml))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Json)
                .addGap(18, 18, 18)
                .addComponent(Xml)
                .addGap(18, 18, 18)
                .addComponent(Txt_)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Guardado", jPanel14);

        javax.swing.GroupLayout Dialog_configLayout = new javax.swing.GroupLayout(Dialog_config.getContentPane());
        Dialog_config.getContentPane().setLayout(Dialog_configLayout);
        Dialog_configLayout.setHorizontalGroup(
            Dialog_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_configLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Dialog_configLayout.setVerticalGroup(
            Dialog_configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dialog_configLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        btn_employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/modules/main_menu/views/img/1455482441_users-add.png"))); // NOI18N
        btn_employees.setFocusPainted(false);
        btn_employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeesActionPerformed(evt);
            }
        });

        btn_Config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/modules/main_menu/views/img/1455482763_cog_edit.png"))); // NOI18N
        btn_Config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_Config, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_employees)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Config)
                .addGap(117, 117, 117))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 80, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/modules/main_menu/views/img/IMG_0279.JPG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_employeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeesActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);

        new Menu().setVisible(true);


    }//GEN-LAST:event_btn_employeesActionPerformed

    private void formato_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formato_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formato_1ActionPerformed

    private void decimal_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decimal_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decimal_1ActionPerformed

    private void EnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnglishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnglishActionPerformed

    private void metalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metalActionPerformed

    private void EurobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EurobtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EurobtnActionPerformed

    private void btn_ConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfigActionPerformed
        // TODO add your handling code here:

       charge_config();
        
        Dialog_config.setSize(550, 350);//ancho x alto

        Dialog_config.setLocationRelativeTo(null);

        Dialog_config.setVisible(true);

        
        
    }//GEN-LAST:event_btn_ConfigActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Dialog_config.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        // TODO add your handling code here:

        First_menu_config_bll.Charge_Config_to_class_config();


    }//GEN-LAST:event_btnAplicarActionPerformed

    public static void charge_config() {


       First_menu_config_bll.Charge_config();
        
        

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDialog Dialog_config;
    public static javax.swing.JRadioButton Dolar;
    public static javax.swing.JRadioButton English;
    public static javax.swing.JRadioButton Español;
    public static javax.swing.JRadioButton Eurobtn;
    public static javax.swing.JRadioButton Json;
    public static javax.swing.JRadioButton Libra;
    public static javax.swing.JRadioButton Txt_;
    public static javax.swing.JRadioButton Valencia;
    public static javax.swing.JRadioButton Xml;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btn_Config;
    private javax.swing.JButton btn_employees;
    private javax.swing.ButtonGroup buttonGroup2decimal;
    private javax.swing.ButtonGroup buttonGroup3lenguaje;
    private javax.swing.ButtonGroup buttonGroup4themes;
    private javax.swing.ButtonGroup buttonGroup5fecha;
    private javax.swing.ButtonGroup buttonGroup6guardado;
    private javax.swing.ButtonGroup buttonGroupmoneda;
    private javax.swing.JRadioButton decimal_1;
    private javax.swing.JRadioButton decimal_2;
    private javax.swing.JRadioButton decimal_3;
    public static javax.swing.JRadioButton formato_1;
    public static javax.swing.JRadioButton formato_2;
    public static javax.swing.JRadioButton formato_3;
    public static javax.swing.JRadioButton formato_4;
    public static javax.swing.JRadioButton gtk_windows;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JRadioButton metal;
    public static javax.swing.JRadioButton motif;
    public static javax.swing.JRadioButton ninbus;
    // End of variables declaration//GEN-END:variables
}
