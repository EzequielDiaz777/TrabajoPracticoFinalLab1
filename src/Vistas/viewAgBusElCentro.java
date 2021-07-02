/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.CentroDeVacunacionData;
import Modelos.CentroDeVacunacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class viewAgBusElCentro extends javax.swing.JInternalFrame {

    private CentroDeVacunacionData centroVacunacion;
    
    /**
     * Creates new form viewAgBusElCentro
     */
    public viewAgBusElCentro(CentroDeVacunacionData centroVacunacion) {
        initComponents();
        this.centroVacunacion = centroVacunacion;
        rellenarComboBoxDepartamento();
        rellenarComboBoxCiudad();
    }
    
//    public CentroDeVacunacion guardarCentro() {
//    CentroDeVacunacion centro = new CentroDeVacunacion(jtfNombreCentro.getText(), jtfCiudad.getText(), jtfDepartamento.getText());
//            return centro;
//    }
    
    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public void rellenarComboBoxDepartamento() {
        jcbDepartamentos.removeAllItems();
        jcbDepartamentos.addItem("Seleccione un departamento.");
        jcbDepartamentos.addItem("Ayacucho");
        jcbDepartamentos.addItem("Belgrano");
        jcbDepartamentos.addItem("Chacabuco");
        jcbDepartamentos.addItem("Coronel Pringles");
        jcbDepartamentos.addItem("General Pedernera");
        jcbDepartamentos.addItem("Gobernador Dupuy");
        jcbDepartamentos.addItem("Juan Martín de Pueyrredón");
        jcbDepartamentos.addItem("Junín");
        jcbDepartamentos.addItem("Libertador General San Martín");
    }
    
    
    public void rellenarComboBoxCiudad() {
        jcbCiudad.removeAllItems();
        jcbCiudad.addItem("Seleccione una ciudad.");
        switch ((String) jcbDepartamentos.getSelectedItem()) {
            case "Juan Martín de Pueyrredón": {
                jcbCiudad.addItem("San Luis (capital provincial)");
                jcbCiudad.addItem("Alto Pencoso");
                jcbCiudad.addItem("Balde");
                jcbCiudad.addItem("Beazley");
                jcbCiudad.addItem("Cazador");
                jcbCiudad.addItem("Chosmes");
                jcbCiudad.addItem("Desaguadero");
                jcbCiudad.addItem("El Volcán");
                jcbCiudad.addItem("Jarilla");
                jcbCiudad.addItem("Juana Koslay");
                jcbCiudad.addItem("La Punta");
                jcbCiudad.addItem("Mosmota");
                jcbCiudad.addItem("Potrero de los Funes");
                jcbCiudad.addItem("Salinas del Bebedero");
                jcbCiudad.addItem("San Gerónimo");
                jcbCiudad.addItem("Desaguadero");
                jcbCiudad.addItem("Zanjitas");
                break;
            }
            case "Belgrano": {
                jcbCiudad.addItem("La Calera ");
                jcbCiudad.addItem("Nogolí ");
                jcbCiudad.addItem("Villa de la Quebrada ");
                jcbCiudad.addItem("Villa General Roca");
                break;
            }
            case "Ayacucho": {
                jcbCiudad.addItem("Candelaria");
                jcbCiudad.addItem("La Majada");
                jcbCiudad.addItem("Leandro N. Alem");
                jcbCiudad.addItem("Luján");
                jcbCiudad.addItem("Quines");
                jcbCiudad.addItem("Río Juan Gómez");
                jcbCiudad.addItem("San Francisco del Monte de Oro");
                break;
            }
            case "Chacabuco": {
                jcbCiudad.addItem("Concarán");
                jcbCiudad.addItem("Cortaderas");
                jcbCiudad.addItem("Naschel");
                jcbCiudad.addItem("Papagayos");
                jcbCiudad.addItem("Renca");
                jcbCiudad.addItem("San Pablo");
                jcbCiudad.addItem("Tilisarao");
                jcbCiudad.addItem("Villa del Carmen");
                jcbCiudad.addItem("Villa Larca");
                break;
            }
            case "Coronel Pringles": {
                jcbCiudad.addItem("Carolina");
                jcbCiudad.addItem("El Trapiche");
                jcbCiudad.addItem("Fraga");
                jcbCiudad.addItem("La Bajada");
                jcbCiudad.addItem("La Florida");
                jcbCiudad.addItem("La Toma");
                jcbCiudad.addItem("Riocito");
                jcbCiudad.addItem("Saladillo");
                jcbCiudad.addItem("Estancia Grande");
                break;
            }
            case "General Pedernera": {
                jcbCiudad.addItem("Juan Jorba");
                jcbCiudad.addItem("Juan Llerena");
                jcbCiudad.addItem("Justo Daract");
                jcbCiudad.addItem("La Esquina");
                jcbCiudad.addItem("La Punilla");
                jcbCiudad.addItem("Lavaisse");
                jcbCiudad.addItem("San José del Morro");
                jcbCiudad.addItem("Villa Mercedes");
                break;
            }
            case "Gobernador Dupuy": {
                jcbCiudad.addItem("Anchorena");
                jcbCiudad.addItem("Arizona");
                jcbCiudad.addItem("Bagual");
                jcbCiudad.addItem("Batavia");
                jcbCiudad.addItem("Buena Esperanza");
                jcbCiudad.addItem("Fortín El Patria");
                jcbCiudad.addItem("Fortuna");
                jcbCiudad.addItem("La Maroma");
                jcbCiudad.addItem("Martín de Loyola");
                jcbCiudad.addItem("Nahuel Mapá");
                jcbCiudad.addItem("Navia");
                jcbCiudad.addItem("Nueva Galia");
                jcbCiudad.addItem("Unión");
                break;
            }
            case "Junín": {
                jcbCiudad.addItem("Carpintería");
                jcbCiudad.addItem("Cerro de Oro");
                jcbCiudad.addItem("Lafinur");
                jcbCiudad.addItem("Los Cajones");
                jcbCiudad.addItem("Los Molles");
                jcbCiudad.addItem("Merlo");
                jcbCiudad.addItem("Santa Rosa de Conlara");
                jcbCiudad.addItem("Talita");
                break;
            }
            case "Libertador General San Martín": {
                jcbCiudad.addItem("Las Aguadas");
                jcbCiudad.addItem("Las Chacras");
                jcbCiudad.addItem("Las Lagunas");
                jcbCiudad.addItem("Las Vertientes");
                jcbCiudad.addItem("Paso Grande");
                jcbCiudad.addItem("San Martín");
                jcbCiudad.addItem("Villa de Praga");
                break;
            }
        }
    }
    
    public CentroDeVacunacion buscarCentro() {
        ArrayList<CentroDeVacunacion> lista = centroVacunacion.obtenerCentrosDeVacunaciones();
        CentroDeVacunacion Centro = null;
        if (jtfNombreCentro.getText().isEmpty()) {
            mensaje("El DNI debe ser superior a 0.");
            return Centro;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (jtfNombreCentro.getText() == lista.get(i).getNombreCentroDeVacunacion()) {
                Centro = lista.get(i);
                return Centro;
            }
        }
        mensaje("No existe ninguna persona con el Nombre: " + jtfNombreCentro.getText());
        return Centro;
    }
    
    public void agregarCentro(){
        CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion(jtfNombreCentro.getText(), (String) jcbCiudad.getSelectedItem().toString(), (String) jcbDepartamentos.getSelectedItem().toString());
        centroVacunacion.guardarCentroDeVacunacion(centroDeVacunacion);
    }
    
//     public void limpiar() {
//        jtfNombreCentro.setText("");
//        jtfDepartamento.setText("");
//        jtfCiudad.setText("");
//     }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNombreCentro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbAgregarCentro = new javax.swing.JButton();
        jbBuscarCentro = new javax.swing.JButton();
        jbEliminarCentro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jcbDepartamentos = new javax.swing.JComboBox<>();
        jcbCiudad = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Gestor de centro de vacunacion");

        jLabel2.setText("Nombre Centro de Vacunacion:");

        jtfNombreCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreCentroActionPerformed(evt);
            }
        });

        jLabel3.setText("Ciudad:");

        jLabel4.setText("Departamento:");

        jbAgregarCentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        jbAgregarCentro.setText("Agregar");
        jbAgregarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarCentroActionPerformed(evt);
            }
        });

        jbBuscarCentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa miniatura.png"))); // NOI18N
        jbBuscarCentro.setText("Buscar");
        jbBuscarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCentroActionPerformed(evt);
            }
        });

        jbEliminarCentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        jbEliminarCentro.setText("Eliminar");
        jbEliminarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarCentroActionPerformed(evt);
            }
        });

        jLabel6.setText("Para agregar un centro de vacunacion llene todos los campos y  haga click en el boton 'Agregar'.");

        jLabel7.setText("Para buscar un centro llene el campo Nombre y haga click en la 'Buscar' para poder visualizar todos sus datos.");

        jLabel8.setText("Para eliminar un centro primero busquelo y luego haga click en el botón 'Eliminar'.");

        jcbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDepartamentos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDepartamentosPopupMenuWillBecomeVisible(evt);
            }
        });

        jcbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCiudad.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbCiudadPopupMenuWillBecomeVisible(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(262, 262, 262))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombreCentro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbBuscarCentro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAgregarCentro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEliminarCentro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarCentro)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscarCentro)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminarCentro)
                    .addComponent(jLabel8))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreCentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreCentroActionPerformed

    private void jbEliminarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarCentroActionPerformed
        // TODO add your handling code here:
        centroVacunacion.borrarCentroDeVacunacion(Integer.parseInt(buscarCentro().getNombreCentroDeVacunacion()));
    }//GEN-LAST:event_jbEliminarCentroActionPerformed

    private void jbBuscarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCentroActionPerformed

    }//GEN-LAST:event_jbBuscarCentroActionPerformed

    private void jbAgregarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarCentroActionPerformed
        // TODO add your handling code here:
//        centroVacunacion.guardarCentroDeVacunacion(guardarCentro());
//        limpiar();
    agregarCentro();
    }//GEN-LAST:event_jbAgregarCentroActionPerformed

    private void jcbDepartamentosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDepartamentosPopupMenuWillBecomeVisible
        rellenarComboBoxDepartamento();
    }//GEN-LAST:event_jcbDepartamentosPopupMenuWillBecomeVisible

    private void jcbCiudadPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbCiudadPopupMenuWillBecomeVisible
        rellenarComboBoxCiudad();
    }//GEN-LAST:event_jcbCiudadPopupMenuWillBecomeVisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregarCentro;
    private javax.swing.JButton jbBuscarCentro;
    private javax.swing.JButton jbEliminarCentro;
    private javax.swing.JComboBox<String> jcbCiudad;
    private javax.swing.JComboBox<String> jcbDepartamentos;
    private javax.swing.JTextField jtfNombreCentro;
    // End of variables declaration//GEN-END:variables
}
