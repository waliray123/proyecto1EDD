/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controladores.ControlDatos;
import controladores.ControlGenImagen;
import estructuras.ListaEnlSim;
import javax.swing.JOptionPane;
import objetos.Capa;
import objetos.Imagen;
import objetos.Usuario;

/**
 *
 * @author user-ubunto
 */
public class JFGenerarImagen extends javax.swing.JFrame {

    private ControlDatos controlDatos;
    private String pathGuardado;
    private ListaEnlSim<Imagen> imagenes;
    private int cant;

    /**
     * Creates new form JFGenerarImagen
     */
    public JFGenerarImagen(ControlDatos controlDatos, String path) {
        initComponents();
        this.controlDatos = controlDatos;
        this.pathGuardado = path;
        this.jPanel1.setVisible(false);
        this.jPanel2.setVisible(false);
        this.jComboBox1.removeAllItems();
        this.buttonGroup1.add(this.jRadioButton1);
        this.buttonGroup1.add(this.jRadioButton2);
        this.buttonGroup1.add(this.jRadioButton3);
        this.jRadioButton1.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Generacion de Imagenes");

        jButton1.setText("Por recorrido Lim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Por usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Por capa");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione Imagen");

        jButton4.setText("Enviar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 197, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton5.setText("Enviar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de Recorrido");

        jRadioButton1.setText("inOrden");

        jRadioButton2.setText("preOrder");

        jRadioButton3.setText("postOrder");

        jLabel4.setText("Ingrese las capas ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jLabel3)
                                    .addComponent(jRadioButton1))
                                .addGap(0, 53, Short.MAX_VALUE))))
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Por recorrido Limitado
        cant = 0;
        this.jPanel1.setVisible(false);        
        this.jComboBox1.removeAllItems();
        this.jPanel2.setVisible(true);       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Por capa
        this.jPanel1.setVisible(false);
        this.jPanel2.setVisible(false);
        this.jComboBox1.removeAllItems();
        String idCapa = JOptionPane.showInputDialog("Ingrese el id de la capa");
        Capa capaN = this.controlDatos.buscarCapaEnArbol(idCapa);
        if (capaN != null) {
            //Si existe la capa 
            ControlGenImagen controlImg = new ControlGenImagen(this.controlDatos, this.pathGuardado);
            controlImg.generarImagenPorCapa(capaN);
            JOptionPane.showMessageDialog(null, "La capa si existe");
        } else {
            JOptionPane.showMessageDialog(null, "La capa con ese id no existe");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jPanel2.setVisible(false);
        this.jComboBox1.removeAllItems();
        String idUsuario = JOptionPane.showInputDialog("Ingrese el id del usuario");
        Usuario usuarioN = this.controlDatos.buscarUsuarioEnArbol(idUsuario);
        if (usuarioN != null) {
            imagenes = usuarioN.getImagenes();
            ListaEnlSim<Imagen> ultimo = imagenes;
            while (ultimo != null) {
                Imagen img = ultimo.getVal();
                if (img != null) {
                    this.jComboBox1.addItem(String.valueOf(img.getIdImagen()));                    
                }
                ultimo = ultimo.getSig();
            }
            this.jPanel1.setVisible(true);
        } else {
            this.jPanel1.setVisible(false);
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Enviar imagen
        String idImg = String.valueOf(this.jComboBox1.getSelectedItem());
//        JOptionPane.showMessageDialog(null, "El id imagen es: " + idImg);
        ListaEnlSim<Imagen> ultimo = imagenes;
        Imagen imgIns = null;
        while (ultimo != null) {
            Imagen img = ultimo.getVal();
            if (img != null) {
                String idImg2 = String.valueOf(img.getIdImagen());
                if (idImg2.equals(idImg)) {
                    imgIns = img;
//                    JOptionPane.showMessageDialog(null, "Se encontro la imagen");
                }
            }
            ultimo = ultimo.getSig();
        }
        if (imgIns != null) {
            ControlGenImagen controlImg = new ControlGenImagen(this.controlDatos, this.pathGuardado);
            controlImg.generarImagenPorIdImagen(imgIns);
            JOptionPane.showMessageDialog(null, "IMAGEN CREADA");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Enviar Capas a graficar
        String entrada = this.jTextField1.getText();
        ListaEnlSim<String> idCapas = leerCapasArbol(entrada);
        if (idCapas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingreso ninguna capa");
        }else{
            String tipo = getTipoRecorrido();
            ControlGenImagen controlImg = new ControlGenImagen(this.controlDatos, this.pathGuardado);
            controlImg.generarArbolCapas(tipo, idCapas);
            //JOptionPane.showMessageDialog(null, "Tipo de recorrido" + tipo );
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    
    private ListaEnlSim<String> leerCapasArbol(String entrada){
        ListaEnlSim<String> idCapas = new ListaEnlSim<>();        
        String idC = "";
        for (int i = 0; i < entrada.length(); i++) {
            char caracter = entrada.charAt(i);            
            if (caracter == ',') {
                idCapas.add(idCapas, idC);
                idC = "";
            }else{
                idC += caracter;
            }
        }
        idCapas.add(idCapas, idC);
        return idCapas;
    }
    
    private String getTipoRecorrido(){
        String tipo = "";
        if (this.jRadioButton1.isSelected() == true) {
            return "inOrder";
        }else if (this.jRadioButton2.isSelected() == true) {
            return "preOrder";
        }else if (this.jRadioButton3.isSelected() == true) {
            return "postOrder";
        }
        return tipo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
