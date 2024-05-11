package Compilador;

import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonat
 */
public class gui extends javax.swing.JFrame {

    public gui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg = new javax.swing.JPanel();
        pnl_title = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_codigo = new javax.swing.JTextArea();
        btn_compilar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_tabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtA_terminal = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_bg.setBackground(new java.awt.Color(0, 204, 51));
        pnl_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_title.setBackground(new java.awt.Color(255, 0, 51));
        pnl_title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Compilador");
        pnl_title.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        pnl_bg.add(pnl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        txtA_codigo.setColumns(20);
        txtA_codigo.setRows(5);
        jScrollPane1.setViewportView(txtA_codigo);

        pnl_bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 770, 140));

        btn_compilar.setBackground(new java.awt.Color(204, 255, 204));
        btn_compilar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_compilar.setText("Compilar");
        btn_compilar.setBorder(null);
        btn_compilar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compilarActionPerformed(evt);
            }
        });
        pnl_bg.add(btn_compilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 220, 90, 30));

        btn_limpiar.setBackground(new java.awt.Color(204, 255, 204));
        btn_limpiar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setBorder(null);
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        pnl_bg.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 80, 30));

        tb_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdFila", "Tipo Token", "Token", "IdColumna"
            }
        ));
        jScrollPane2.setViewportView(tb_tabla);

        pnl_bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 500, 300));

        txtA_terminal.setColumns(20);
        txtA_terminal.setRows(5);
        jScrollPane3.setViewportView(txtA_terminal);

        pnl_bg.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, 300));

        getContentPane().add(pnl_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compilarActionPerformed
        String codigo = txtA_codigo.getText();
        DefaultTableModel modeloTabla = (DefaultTableModel) tb_tabla.getModel();
        modeloTabla.setRowCount(0);
        Scanner t = new Scanner(codigo);
        int idFila = 0, idColumna = 0, idToken = 0;
        while(t.hasNextLine()){
            String linea = t.nextLine();
            if(linea.contains("//")){
                idFila++;
                idColumna = 1;
                continue;
            }
            try(Scanner lineaScanner = new Scanner(linea)){
                lineaScanner.useDelimiter("\\s+|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)|(?<=\\()|(?=\\))|(?<=\\))|(?<=;)|(?=;)|(?<=>)");
                while(lineaScanner.hasNext()){
                    String token = lineaScanner.next();
                    String tipoToken = obtenerTokens(token.trim());
                    if(!token.equals("Comentario") && !token.isEmpty()){
                        modeloTabla.addRow(new Object[]{idToken, tipoToken, token, idFila, idColumna});
                        idToken++;
                
                    }
                    idColumna += token.length();
                }
                idFila++;
                idColumna = 1;
            }   
        }
        t.close();
    }//GEN-LAST:event_btn_compilarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txtA_codigo.setText("");
        DefaultTableModel modelo =  (DefaultTableModel) tb_tabla.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    
    
    
    private String obtenerTokens(String token){
        if(token.matches("class|void|int|string|if|Pantalla|public")){
            return "palabra reservada";
        }else if(token.matches("[+\\-*/]+")){
            return "aritmetico";
        }else if(token.matches("(==|!=|>=|<=|>|<)+")){
            return "comparacion";
        }else if(token.equals("(") || token.equals(")") || token.equals("()")){
            return "parentesis";
        }else if(token.equals(";") || token.equals("/") || token.equals(",")){
            return "especiales";
        }else if(token.matches("^[a-z][a-z A-Z 0-9 \\_]*$")){
            return "idetif";
        }else if(token.matches("[0-9]+")){
            return "integer";
        }else if(token.matches("\\s+")){
            return "separador";
        }else if(token.equals("=")){
            return "asignacion";
        }else if(token.equals("{") || token.equals("}") || token.equals("{}")){
            return "llaves";
        }else if(token.equals("*/") || token.equals("/*") || token.equals("//")){
            return "separador";
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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compilar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bg;
    private javax.swing.JPanel pnl_title;
    private javax.swing.JTable tb_tabla;
    private javax.swing.JTextArea txtA_codigo;
    private javax.swing.JTextArea txtA_terminal;
    // End of variables declaration//GEN-END:variables
}
