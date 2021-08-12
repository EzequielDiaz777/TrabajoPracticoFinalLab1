package Vistas;

import Controladores.CentroDeVacunacionData;
import Controladores.CitaDeVacunacionData;
import Controladores.DosisData;
import Controladores.LaboratorioData;
import Controladores.PatologiaData;
import Controladores.PersonaData;
/**
 *
 * @author Grupo2
 */
public class viewMenu extends javax.swing.JFrame {

    private PersonaData personaData;
    private PatologiaData patologiaData;
    private LaboratorioData laboratorioData;
    private DosisData dosisData;
    private CentroDeVacunacionData centroDeVacunacionData;
    private CitaDeVacunacionData citaDeVacunacionData;
    
    public viewMenu() {
        initComponents();
        setLocationRelativeTo(null);
        personaData = new PersonaData();
        patologiaData = new PatologiaData();
        laboratorioData = new LaboratorioData();
        dosisData = new DosisData();
        centroDeVacunacionData = new CentroDeVacunacionData();
        citaDeVacunacionData = new CitaDeVacunacionData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jmbMenu = new javax.swing.JMenuBar();
        jmPersona = new javax.swing.JMenu();
        jmiAgregarBuscarEliminarPersona = new javax.swing.JMenuItem();
        jmLaboratorio = new javax.swing.JMenu();
        jmiAgregarLaboratorio = new javax.swing.JMenuItem();
        jmiBuscarEliminarLaboratorio = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmDosis = new javax.swing.JMenu();
        jmiAgregarDosis = new javax.swing.JMenuItem();
        jmiBuscarEliminarDosis = new javax.swing.JMenuItem();
        jmiListarDosis = new javax.swing.JMenuItem();
        jmCentroDeVacunacion = new javax.swing.JMenu();
        jmiAgregarCentroDeVacunacion = new javax.swing.JMenuItem();
        jmiListarCentrosDeVacunaciones = new javax.swing.JMenuItem();
        jmCitasDeVacunaciones = new javax.swing.JMenu();
        jmiAgregarCitaDeVacunacion = new javax.swing.JMenuItem();
        jmiBuscarEliminarCitaDeVacunacion = new javax.swing.JMenuItem();
        jmiListarCitasDeVacunaciones = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jmPersona.setText("Personas");
        jmPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPersonaActionPerformed(evt);
            }
        });

        jmiAgregarBuscarEliminarPersona.setText("Agregar/Buscar/Elminar/Modificar Persona");
        jmiAgregarBuscarEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarBuscarEliminarPersonaActionPerformed(evt);
            }
        });
        jmPersona.add(jmiAgregarBuscarEliminarPersona);

        jmbMenu.add(jmPersona);

        jmLaboratorio.setText("Laboratorios");

        jmiAgregarLaboratorio.setText("Agregar laboratorio");
        jmiAgregarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarLaboratorioActionPerformed(evt);
            }
        });
        jmLaboratorio.add(jmiAgregarLaboratorio);

        jmiBuscarEliminarLaboratorio.setText("Buscar/Eliminar laboratorio");
        jmiBuscarEliminarLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarEliminarLaboratorioActionPerformed(evt);
            }
        });
        jmLaboratorio.add(jmiBuscarEliminarLaboratorio);

        jMenuItem1.setText("Listar laboratorios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmLaboratorio.add(jMenuItem1);

        jmbMenu.add(jmLaboratorio);

        jmDosis.setText("Dosis");

        jmiAgregarDosis.setText("Agregar dosis");
        jmiAgregarDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarDosisActionPerformed(evt);
            }
        });
        jmDosis.add(jmiAgregarDosis);

        jmiBuscarEliminarDosis.setText("Bucar/Eliminar dosis");
        jmiBuscarEliminarDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarEliminarDosisActionPerformed(evt);
            }
        });
        jmDosis.add(jmiBuscarEliminarDosis);

        jmiListarDosis.setText("Listar dosis");
        jmiListarDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarDosisActionPerformed(evt);
            }
        });
        jmDosis.add(jmiListarDosis);

        jmbMenu.add(jmDosis);

        jmCentroDeVacunacion.setText("Centros de vacunaciones");

        jmiAgregarCentroDeVacunacion.setText("Agregar/Eliminar/buscar centro");
        jmiAgregarCentroDeVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarCentroDeVacunacionActionPerformed(evt);
            }
        });
        jmCentroDeVacunacion.add(jmiAgregarCentroDeVacunacion);

        jmiListarCentrosDeVacunaciones.setText("Listar centros");
        jmiListarCentrosDeVacunaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarCentrosDeVacunacionesActionPerformed(evt);
            }
        });
        jmCentroDeVacunacion.add(jmiListarCentrosDeVacunaciones);

        jmbMenu.add(jmCentroDeVacunacion);

        jmCitasDeVacunaciones.setText("Citas de vacunaciones");

        jmiAgregarCitaDeVacunacion.setText("Agregar cita");
        jmiAgregarCitaDeVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgregarCitaDeVacunacionActionPerformed(evt);
            }
        });
        jmCitasDeVacunaciones.add(jmiAgregarCitaDeVacunacion);

        jmiBuscarEliminarCitaDeVacunacion.setText("Bucar/Eliminar cita");
        jmiBuscarEliminarCitaDeVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarEliminarCitaDeVacunacionActionPerformed(evt);
            }
        });
        jmCitasDeVacunaciones.add(jmiBuscarEliminarCitaDeVacunacion);

        jmiListarCitasDeVacunaciones.setText("Listar cita");
        jmCitasDeVacunaciones.add(jmiListarCitasDeVacunaciones);

        jmbMenu.add(jmCitasDeVacunaciones);

        jmSalir.setText("Salir");

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmSalir.add(jmiSalir);

        jmbMenu.add(jmSalir);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        dispose ();
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiAgregarBuscarEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarBuscarEliminarPersonaActionPerformed
        // TODO add your handling code here:
        
        escritorio.removeAll();
        escritorio.repaint();
        viewAgBusModElPersona vap = new viewAgBusModElPersona(personaData, patologiaData);
        vap.setVisible(true);
        escritorio.add(vap);
        escritorio.moveToFront(vap);
    }//GEN-LAST:event_jmiAgregarBuscarEliminarPersonaActionPerformed

    private void jmPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPersonaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jmPersonaActionPerformed

    private void jmiAgregarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarLaboratorioActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewAgregarLaboratorio val = new viewAgregarLaboratorio(laboratorioData);
        val.setVisible(true);
        escritorio.add(val);
        escritorio.moveToFront(val);
    }//GEN-LAST:event_jmiAgregarLaboratorioActionPerformed

    private void jmiBuscarEliminarLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarEliminarLaboratorioActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        viewModElimLaboratorio vml = new viewModElimLaboratorio(laboratorioData);
        vml.setVisible(true);
        escritorio.add(vml);
        escritorio.moveToFront(vml);
    }//GEN-LAST:event_jmiBuscarEliminarLaboratorioActionPerformed

    private void jmiAgregarDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarDosisActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewDosis vd = new viewDosis(dosisData,laboratorioData);
        vd.setVisible(true);
        escritorio.add(vd);
        escritorio.moveToFront(vd);
    }//GEN-LAST:event_jmiAgregarDosisActionPerformed

    private void jmiBuscarEliminarDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarEliminarDosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiBuscarEliminarDosisActionPerformed

    private void jmiAgregarCentroDeVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarCentroDeVacunacionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        viewAgBusElCentro vc = new viewAgBusElCentro(centroDeVacunacionData);
        vc.setVisible(true);
        escritorio.add(vc);
        escritorio.moveToFront(vc);
    }//GEN-LAST:event_jmiAgregarCentroDeVacunacionActionPerformed

    private void jmiAgregarCitaDeVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgregarCitaDeVacunacionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewCitas vc = new viewCitas(personaData, centroDeVacunacionData, dosisData, citaDeVacunacionData);
        vc.setVisible(true);
        escritorio.add(vc);
        escritorio.moveToFront(vc);
    }//GEN-LAST:event_jmiAgregarCitaDeVacunacionActionPerformed

    private void jmiBuscarEliminarCitaDeVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarEliminarCitaDeVacunacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiBuscarEliminarCitaDeVacunacionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        viewBuscarLaboratorio vbl = new viewBuscarLaboratorio(laboratorioData);
        vbl.setVisible(true);
        escritorio.add(vbl);
        escritorio.moveToFront(vbl);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiListarDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarDosisActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        viewListarDosis vld = new viewListarDosis(dosisData, laboratorioData);
        vld.setVisible(true);
        escritorio.add(vld);
        escritorio.moveToFront(vld);
    }//GEN-LAST:event_jmiListarDosisActionPerformed

    private void jmiListarCentrosDeVacunacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarCentrosDeVacunacionesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        viewListarCentro vcl = new viewListarCentro(centroDeVacunacionData);
        vcl.setVisible(true);
        escritorio.add(vcl);
        escritorio.moveToFront(vcl);
    }//GEN-LAST:event_jmiListarCentrosDeVacunacionesActionPerformed

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
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jmCentroDeVacunacion;
    private javax.swing.JMenu jmCitasDeVacunaciones;
    private javax.swing.JMenu jmDosis;
    private javax.swing.JMenu jmLaboratorio;
    private javax.swing.JMenu jmPersona;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiAgregarBuscarEliminarPersona;
    private javax.swing.JMenuItem jmiAgregarCentroDeVacunacion;
    private javax.swing.JMenuItem jmiAgregarCitaDeVacunacion;
    private javax.swing.JMenuItem jmiAgregarDosis;
    private javax.swing.JMenuItem jmiAgregarLaboratorio;
    private javax.swing.JMenuItem jmiBuscarEliminarCitaDeVacunacion;
    private javax.swing.JMenuItem jmiBuscarEliminarDosis;
    private javax.swing.JMenuItem jmiBuscarEliminarLaboratorio;
    private javax.swing.JMenuItem jmiListarCentrosDeVacunaciones;
    private javax.swing.JMenuItem jmiListarCitasDeVacunaciones;
    private javax.swing.JMenuItem jmiListarDosis;
    private javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables
}
