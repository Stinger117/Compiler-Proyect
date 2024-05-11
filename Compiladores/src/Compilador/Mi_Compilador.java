package Compilador;

import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jonat
 */
public class Mi_Compilador extends javax.swing.JFrame {

    private String title; //Nombre de mi ventana
    private Directory directorio; //
    private ArrayList<Token> tipoToken; //Almacenamiento de los tokens
    private ArrayList<ErrorLSSL> errores; //Almacenamiento de todos los posibles errores
    private ArrayList<TextColor> txtColor; //Almacenamiento de los colores de las palabras reservadas
    private Timer timerKeyReleased; //Temporizador que se ejecuatara para cuando queremos ejecutar la funcion para colorear las palabras del editor de codigo
    private ArrayList<Production> extraerIdentificadores; //Extraccion de los identificadores del analisis sintactico
    private HashMap<String, String> almacenarIdentificadores; //Almacenamiento de los identificadores del analisis sintactico
    private boolean codeHadbeenCompiled = false; //Para saber si el codigo ha sido compilado 
    
    public Mi_Compilador() {
        initComponents();
        init();   
    }

    private void init(){
         setLocationRelativeTo(null);
         title = "Compilador";
         setTitle(title);
         directorio = new Directory(this, pnlTxt_Code, title, ".cod"); //
         addWindowListener(new WindowAdapter(){ 
             @Override
             public void windowClosing(WindowEvent e){ //Se activara cuando se oprima la X
                 directorio.Exit(); //Lo que hace es que si estamos editando un codigo y pulasamos la X nos preguntara si deaseamos guardar o bien descartar los cambios
                 System.exit(0); //Indicamos que la ventana se cierre completamente
             }
         });
         Functions.setLineNumberOnJTextComponent(pnlTxt_Code); //Coloco lineas de numeros como en un editor de codigo
         
         timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> { //Inicio el timer que se ejecutara cade 300 millsegundos
            timerKeyReleased.stop(); //Paro el temporizador
            colorAnalysis(); //Metodo para analizar los colores
        });
         
        Functions.insertAsteriskInName(this, pnlTxt_Code, () -> {//Coloca un asterisco en el nombre de la ventana cuando hacemos una edicion al titulo
            timerKeyReleased.restart(); //Reiniciamos el temporizador
        });
        
        //Inicializacion de las varibles
        tipoToken = new ArrayList<>();
        errores = new ArrayList<>();
        txtColor = new ArrayList<>();
        extraerIdentificadores = new ArrayList<>();
        almacenarIdentificadores = new HashMap<>();
        
        //Mete un auto completador
        Functions.setAutocompleterJTextComponent(new String[]{"int", "String", "float"}, pnlTxt_Code, () -> {
            timerKeyReleased.restart(); //Reiniciamos el temporizador
        });
           
    }
    
    private void colorAnalysis(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        scroll_table = new javax.swing.JScrollPane();
        Jtble = new javax.swing.JTable();
        scroll_txtPanel = new javax.swing.JScrollPane();
        pnlTxt_Code = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btn_ejecutar = new javax.swing.JButton();
        btn_compilar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_guardarComo = new javax.swing.JButton();
        pnl_up = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_abrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnl_main.setBackground(new java.awt.Color(0, 153, 153));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jtble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Token", "Token", "Lexema", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jtble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scroll_table.setViewportView(Jtble);

        pnl_main.add(scroll_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 89, 470, -1));

        pnlTxt_Code.setPreferredSize(new java.awt.Dimension(232, 84));
        scroll_txtPanel.setViewportView(pnlTxt_Code);

        pnl_main.add(scroll_txtPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 500, 430));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Run:\n");
        jScrollPane3.setViewportView(jTextArea2);

        pnl_main.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 534, 452, 125));

        btn_ejecutar.setBackground(new java.awt.Color(255, 255, 153));
        btn_ejecutar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_ejecutar.setText("Execute");
        btn_ejecutar.setBorder(null);
        btn_ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ejecutarActionPerformed(evt);
            }
        });
        pnl_main.add(btn_ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 534, 140, 51));

        btn_compilar.setBackground(new java.awt.Color(255, 255, 153));
        btn_compilar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_compilar.setText("Compiler");
        btn_compilar.setBorder(null);
        btn_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compilarActionPerformed(evt);
            }
        });
        pnl_main.add(btn_compilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 534, 150, 51));

        btn_guardar.setBackground(new java.awt.Color(204, 204, 204));
        btn_guardar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_guardar.setText("Save");
        btn_guardar.setBorder(null);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        pnl_main.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 70, 56));

        btn_guardarComo.setBackground(new java.awt.Color(204, 204, 204));
        btn_guardarComo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_guardarComo.setText("Save as");
        btn_guardarComo.setBorder(null);
        btn_guardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarComoActionPerformed(evt);
            }
        });
        pnl_main.add(btn_guardarComo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 100, 56));

        pnl_up.setBackground(new java.awt.Color(204, 204, 204));

        lbl_titulo.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lbl_titulo.setText("ANALIZADOR LEXICO");

        javax.swing.GroupLayout pnl_upLayout = new javax.swing.GroupLayout(pnl_up);
        pnl_up.setLayout(pnl_upLayout);
        pnl_upLayout.setHorizontalGroup(
            pnl_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_upLayout.createSequentialGroup()
                .addContainerGap(440, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(331, 331, 331))
        );
        pnl_upLayout.setVerticalGroup(
            pnl_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_upLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addContainerGap())
        );

        pnl_main.add(pnl_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1041, -1));

        btn_nuevo.setBackground(new java.awt.Color(204, 204, 204));
        btn_nuevo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_nuevo.setText("New");
        btn_nuevo.setBorder(null);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        pnl_main.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 90, 56));

        btn_abrir.setBackground(new java.awt.Color(204, 204, 204));
        btn_abrir.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_abrir.setText("Open");
        btn_abrir.setBorder(null);
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });
        pnl_main.add(btn_abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 70, 56));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compilarActionPerformed
       if (getTitle().contains("*") || getTitle().equals(title)) { //si el codigo aun no ha sido creado(escrito) o guardado
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btn_compilarActionPerformed

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        btn_compilar.doClick();
        if (codeHadbeenCompiled) {
            if (!errores.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
            
            }
        }
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed
         if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btn_abrirActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarComoActionPerformed
        if (directorio.SaveAs()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btn_guardarComoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
         if (directorio.Save()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void compile(){
        
    }
    
    private void clearFields() {
 
    }

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
            java.util.logging.Logger.getLogger(Mi_Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mi_Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mi_Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mi_Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mi_Compilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable Jtble;
    private javax.swing.JButton btn_abrir;
    private javax.swing.JButton btn_compilar;
    private javax.swing.JButton btn_ejecutar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_guardarComo;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextPane pnlTxt_Code;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_up;
    private javax.swing.JScrollPane scroll_table;
    private javax.swing.JScrollPane scroll_txtPanel;
    // End of variables declaration//GEN-END:variables
}
