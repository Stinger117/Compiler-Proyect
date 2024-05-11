package Compilador;

import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.LineNumberUpdater;

/**
 *
 * @author jonat
 */
public class Interfaz_Analizis_Lexico extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tipoToken; //Almacenamiento de los tokens
    private ArrayList<ErrorLSSL> errores; //Almacenamiento de todos los posibles errores
    private ArrayList<TextColor> txtColor; //Almacenamiento de los colores de las palabras reservadas
    private Timer timerKeyRelased; //Variable que se ejecuatara para cuando queremos ejecutar una funcion para colorear las palabras del editor de codigo
    private ArrayList<Production> identificador; //Extraccion de los identificadores del analisis sintactico
    private HashMap<String, String> identificadores; //Almacenamiento de los identificadores del analisis sintactico
    private boolean codeHadbeenCompiled = false; //Para saber si el codigo ha sido compilado 
    
    public Interfaz_Analizis_Lexico() {
        initComponents();
        init();
        
        // Inicializo la JTextArea de los números de línea
        txtA_lineNumberArea = new JTextArea(); //Creo un objeto de JTextArea para que acceder a sus metodos
        txtA_lineNumberArea.setEditable(false); //Mi JTextArea no puede ser editable
        scroll_txtA.setRowHeaderView(txtA_lineNumberArea); // Asigno la JTextArea de los números de línea al RowHeaderView como encabezado de linea  del JScrollPane
        txtA_main.getDocument().addDocumentListener(new DocumentListener() { //Obtengo lo que esta en el txtarea y lo agrego a un escuchador en donde creo un objeto para usar los metodos
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers(); //Actualiza los numeros de linea cuando se inserta texto
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers(); //Elimina los numeros de linea cuando no se 
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });
    }

    //Metodo para colocar el numero de fila en el JTxtArea
    private void updateLineNumbers() {
        int totalLines = txtA_main.getLineCount();
        StringBuilder numbersText = new StringBuilder();
        for (int i = 1; i <= totalLines; i++) {
            numbersText.append(i).append("\n");
        }
        txtA_lineNumberArea.setText(numbersText.toString());
    }

    private void init(){
         setLocationRelativeTo(null);
         title = "Compilador";
         setTitle(title);
         directorio = new Directory(this, txtA_main, title, ".cod"); //
         addWindowListener(new WindowAdapter(){ 
             @Override
             public void windowClosing(WindowEvent e){ //Se activara cuando se oprima la X
                 directorio.Exit(); //Lo que hace es que si estamos editando un codigo y pulasamos la X nos preguntara si deaseamos guardar o bien descartar los cambios
                 System.exit(0); //Indicamos que la ventana se cierre completamente
             }
         });
         Functions.setLineNumberOnJTextComponent(txtA_main);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        scroll_txtA = new javax.swing.JScrollPane();
        txtA_main = new javax.swing.JTextArea();
        scroll_table = new javax.swing.JScrollPane();
        Jtble = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btn_limpiar = new javax.swing.JButton();
        btn_compilar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_abrir = new javax.swing.JButton();
        pnl_up = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_X = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_lineNumberArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnl_main.setBackground(new java.awt.Color(0, 153, 153));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtA_main.setColumns(20);
        txtA_main.setRows(5);
        scroll_txtA.setViewportView(txtA_main);

        pnl_main.add(scroll_txtA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 490, 427));

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

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Run:\n");
        jScrollPane3.setViewportView(jTextArea2);

        pnl_main.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 534, 452, 125));

        btn_limpiar.setBackground(new java.awt.Color(255, 255, 153));
        btn_limpiar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setBorder(null);
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        pnl_main.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 534, 140, 51));

        btn_compilar.setBackground(new java.awt.Color(255, 255, 153));
        btn_compilar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_compilar.setText("Compilar");
        btn_compilar.setBorder(null);
        btn_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compilarActionPerformed(evt);
            }
        });
        pnl_main.add(btn_compilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 534, 150, 51));

        btn_guardar.setBackground(new java.awt.Color(204, 204, 204));
        btn_guardar.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_guardar.setText("Guardar ");
        btn_guardar.setBorder(null);
        pnl_main.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 603, 135, 56));

        btn_abrir.setBackground(new java.awt.Color(204, 204, 204));
        btn_abrir.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_abrir.setText("Abrir");
        btn_abrir.setBorder(null);
        pnl_main.add(btn_abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 603, 138, 56));

        pnl_up.setBackground(new java.awt.Color(204, 204, 204));

        lbl_titulo.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lbl_titulo.setText("ANALIZADOR LEXICO");

        lbl_X.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_X.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_X.setText("X");
        lbl_X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_XMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_upLayout = new javax.swing.GroupLayout(pnl_up);
        pnl_up.setLayout(pnl_upLayout);
        pnl_upLayout.setHorizontalGroup(
            pnl_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_upLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(300, 300, 300)
                .addComponent(lbl_X, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_upLayout.setVerticalGroup(
            pnl_upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_upLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addContainerGap())
            .addGroup(pnl_upLayout.createSequentialGroup()
                .addComponent(lbl_X, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_main.add(pnl_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1041, -1));

        btn_nuevo.setBackground(new java.awt.Color(204, 204, 204));
        btn_nuevo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(null);
        pnl_main.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 603, 161, 56));

        txtA_lineNumberArea.setColumns(20);
        txtA_lineNumberArea.setRows(5);
        jScrollPane1.setViewportView(txtA_lineNumberArea);

        pnl_main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 425));

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
        String codigo = txtA_main.getText();
        DefaultTableModel modelo = (DefaultTableModel) Jtble.getModel();
        modelo.setRowCount(0); // Limpiamos la tabla
        LineNumberUpdater updater = new LineNumberUpdater(txtA_main, txtA_lineNumberArea); // txtA_lineNumberArea es el JTextArea donde muestro los números de línea.
        txtA_main.getDocument().addDocumentListener(updater);

        Scanner scanner = new Scanner(codigo);
        int idToken = 1, idLinea = 1, idColumna = 1;
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            if (linea.contains("//") || linea.contains("/") || linea.contains("/*")) {
                idLinea++;
                idColumna = 1;
                continue;
            }
            try (Scanner lineaScanner = new Scanner(linea)) {
                lineaScanner.useDelimiter("\\s+|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)|(?<=\\()|(?=\\))|(?<=\\))|(?<=;)|(?=;)|(?<=>)");
                while (lineaScanner.hasNext()) { //bucle que itera sobre todos los tokens en la linea 
                    String token = lineaScanner.next();//Lee el siguiente token de la linea 
                    String tipoToken = obtenerTokens(token.trim());
                    if (!tipoToken.equals("Comentario") && !token.isEmpty()) {
                        modelo.addRow(new Object[]{idToken, tipoToken, token, idLinea, idColumna});
                        idToken++;
                    }
                    idColumna += token.length();
                }
                idLinea++;
                idColumna = 1; // Reiniciar la columna para la nueva línea
            }
        }
        scanner.close();
    }//GEN-LAST:event_btn_compilarActionPerformed


    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) Jtble.getModel();
        modelo.setRowCount(0); // Limpiamos la tabla
        txtA_main.setText("");
    }//GEN-LAST:event_btn_limpiarActionPerformed

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

    private void lbl_XMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_XMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_XMouseClicked

    private String obtenerTokens(String codigo) {
        if (codigo.matches("class|void|int|string|if|Pantalla|public")) {
            return "Palabras Reservadas";
        } else if (codigo.matches("[+\\-*/]+")) {
            return "Aritmeticos";
        } else if (codigo.matches("(==|!=|>=|<=|>|<)+")) {
            return "Comparacion";
        } else if (codigo.equals("(") || codigo.equals(")") || codigo.equals("()")) {
            return "Paréntesis";
        } else if (codigo.equals(";") || codigo.equals(",") || codigo.equals("\"")) {
            return "Especiales";
        } else if (codigo.matches("^[a-z][a-z A-Z 0-9 \\_]*$")) {
            return "IDENTIF";
        } else if (codigo.matches("[0-9]+")) {
            return "INTEGER";
        } else if (codigo.equals("=")) {
            return "Asignación";
        } else if (codigo.equals("{") || codigo.equals("}") || codigo.equals("{}")) {
            return "Llaves";
        } else if (codigo.equals("*/") || codigo.equals("/*") || codigo.equals("//")) {
            return "separador";
        } else if (codigo.matches("\\s+")) {
            return "Separador";
        }
        return "Error";
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
            java.util.logging.Logger.getLogger(Interfaz_Analizis_Lexico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Analizis_Lexico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Analizis_Lexico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Analizis_Lexico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Analizis_Lexico().setVisible(true);
            }
        });
    }

    public JTextArea getTxtA() {
        return txtA_main;
    }

    public void setTxtA(JTextArea txtA) {
        this.txtA_main = txtA;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable Jtble;
    private javax.swing.JButton btn_abrir;
    private javax.swing.JButton btn_compilar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbl_X;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_up;
    private javax.swing.JScrollPane scroll_table;
    private javax.swing.JScrollPane scroll_txtA;
    private javax.swing.JTextArea txtA_lineNumberArea;
    private javax.swing.JTextArea txtA_main;
    // End of variables declaration//GEN-END:variables
}
