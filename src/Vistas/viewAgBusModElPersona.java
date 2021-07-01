/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.PatologiaData;
import Controladores.PersonaData;
import Modelos.Patologia;
import Modelos.Persona;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo2
 */
public class viewAgBusModElPersona extends javax.swing.JInternalFrame {

    private PersonaData personaData;
    private PatologiaData patologiaData;

    /**
     * Creates new form viewAgregarPersonas
     *
     * @param personaData
     * @param patologiaData
     */
    public viewAgBusModElPersona(PersonaData personaData, PatologiaData patologiaData) {
        initComponents();
        this.personaData = personaData;
        this.patologiaData = patologiaData;
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jdcFechaDeNacimiento.getDateEditor();
        editor.setEditable(false);
        rellenarComboBoxDepartamento();
        rellenarComboBoxCiudad();
        rellenarComboBoxPatologias();
        jbEliminarPersona.setEnabled(false);
        jbModificar.setEnabled(false);
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void guardarPersona() {
        try {
            LocalDate fecha = jdcFechaDeNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Integer.parseInt(jtfDNI.getText()) < 1) {
                mensaje("El DNI debe ser superior a 0.");
                jtfDNI.setText("");
                return;
            } else if (fecha.getYear() < 1900 || fecha.getYear() > 2015) {
                mensaje("El año debe encontrarse entre 1900 y 2015.");
                return;
            } else if (LocalDate.now().isBefore(fecha)) {
                mensaje("La fecha ingresada es posterior a la fecha actual, por favor modifique la fecha de nacimiento.");
                return;
            } else if (Double.parseDouble(jtfPeso.getText()) < 0) {
                mensaje("El peso no puede ser inferior a 0.");
                jtfPeso.setText("");
                return;
            } else if (Double.parseDouble(jtfAltura.getText()) < 0) {
                mensaje("La altura no puede ser inferior a 0.");
                jtfAltura.setText("");
                return;
            } else {
                String arroba = "@";
                String dominio = ".com";
                if (!jtfEmail.getText().contains(arroba) || !jtfEmail.getText().contains(dominio)) {
                    mensaje("El email debe contener '@' y '.com'");
                    jtfEmail.setText("");
                    return;
                }
            }
            String ciudad = (String) jcbCiudad.getSelectedItem();
            String departamento = (String) jcbDepartamentos.getSelectedItem();
            if (departamento.compareTo("Seleccione un departamento.") == 0) {
                mensaje("Seleccione un departamento.");
                return;
            }
            if (ciudad.compareTo("Seleccione una ciudad.") == 0) {
                mensaje("Seleccione una ciudad.");
                return;
            }
            ArrayList<Patologia> listado = patologiaData.obtenerPatologias();
            Patologia patologia = null;
            for (int i = 0; i < listado.size(); i++) {
                if (jcbPatologias.getSelectedItem().equals(listado.get(i).getNombrePatologia())) {
                    patologia = listado.get(i);
                    break;
                }
            }
            Persona persona = new Persona(patologia, Integer.parseInt(jtfDNI.getText()), jtfNombre.getText(), jtfApellido.getText(), Double.parseDouble(jtfPeso.getText()), Double.parseDouble(jtfAltura.getText()), jtfEmail.getText(), jcbTrabajadorEsencial.isSelected(), jtfCelular.getText(), fecha, ciudad, departamento);
            personaData.guardarPersona(persona);
            limpiar();
        } catch (NullPointerException npe) {
            mensaje("Por favor, seleccione una fecha de nacimiento.");
        }
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

    public void rellenarComboBoxPatologias() {
        ArrayList<Patologia> lista = patologiaData.obtenerPatologias();
        jcbPatologias.removeAllItems();
        jcbPatologias.addItem("Ninguna");
        for (int i = 0; i < lista.size(); i++) {
            jcbPatologias.addItem(lista.get(i).getNombrePatologia());
        }
    }

    public Persona buscarPersona() {
        ArrayList<Persona> lista = personaData.obtenerPersonas();
        Persona persona = null;
        if (Integer.parseInt(jtfDNI.getText()) < 1) {
            mensaje("El DNI debe ser superior a 0.");
            return persona;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (Integer.parseInt(jtfDNI.getText()) == lista.get(i).getDni()) {
                persona = lista.get(i);
                return persona;
            }
        }
        mensaje("No existe ninguna persona con el DNI: " + jtfDNI.getText());
        return persona;
    }

    public void mostrarPersona() {
        Persona persona = buscarPersona();
        if (persona != null) {
            jtfDNI.setEditable(false);
            jbBuscarPersona.setEnabled(false);
            jcbPatologias.removeAllItems();
            jcbCiudad.removeAllItems();
            jcbDepartamentos.removeAllItems();
            if (persona.getPatologia() == null) {
                jcbPatologias.addItem("Ninguna");
            } else {
                jcbPatologias.addItem(persona.getPatologia().getNombrePatologia());
            }
            jtfDNI.setText(String.valueOf(persona.getDni()));
            jtfNombre.setText(persona.getNombre());
            jtfApellido.setText(persona.getApellido());
            jtfEmail.setText(persona.getEmail());
            jtfPeso.setText(String.valueOf(persona.getPeso()));
            jtfAltura.setText(String.valueOf(persona.getAltura()));
            jcbTrabajadorEsencial.setSelected(persona.isTrabajo());
            jtfCelular.setText(persona.getCelular());
            jdcFechaDeNacimiento.setDate(Date.valueOf(persona.getFechaDeNacimiento()));
            jcbDepartamentos.addItem(persona.getDepartamento());
            jcbCiudad.addItem(persona.getCiudad());
            jbEliminarPersona.setEnabled(true);
            jbGuardar.setEnabled(false);
            jbModificar.setEnabled(true);
        }
    }

    public void eliminarPersona() {
        Persona persona = buscarPersona();
        int i = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar a esta persona?",
                "Reponder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (i) {
            case 0:
                personaData.borrarPersona(persona.getIdPersona());
                jbEliminarPersona.setEnabled(false);
                jbGuardar.setEnabled(true);
                limpiar();
                break;
            case 1:
                mensaje("La persona no ha sido borrada.");
                break;
            case -1:
                mensaje("La persona no ha sido borrada.");
                break;
        }
    }

    public void modificarPersona() {
        Persona persona = buscarPersona();
        int c = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea modificar a esta persona?",
                "Reponder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (c) {
            case 0:
//                try {
                if (jdcFechaDeNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() < 1900 || jdcFechaDeNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() > 2015) {
                    mensaje("El año debe encontrarse entre 1900 y 2015.");
                    return;
                } else if (Double.parseDouble(jtfPeso.getText()) < 0) {
                    mensaje("El peso no puede ser inferior a 0.");
                    jtfPeso.setText("");
                    return;
                } else if (Double.parseDouble(jtfAltura.getText()) < 0) {
                    mensaje("La altura no puede ser inferior a 0.");
                    jtfAltura.setText("");
                    return;
                } else {
                    String arroba = "@";
                    String dominio = ".com";
                    if (!jtfEmail.getText().contains(arroba) || !jtfEmail.getText().contains(dominio)) {
                        mensaje("El email debe contener '@' y '.com'");
                        jtfEmail.setText("");
                        return;
                    }
                }
                String ciudad = (String) jcbCiudad.getSelectedItem();
                String departamento = (String) jcbDepartamentos.getSelectedItem();
                if (departamento.compareTo("Seleccione un departamento.") == 0) {
                    mensaje("Seleccione un departamento.");
                    return;
                }
                if (ciudad.compareTo("Seleccione una ciudad.") == 0) {
                    mensaje("Seleccione una ciudad.");
                    return;
                }
                ArrayList<Patologia> listado = patologiaData.obtenerPatologias();
                Patologia patologia = null;
                for (int i = 0; i < listado.size(); i++) {
                    if (jcbPatologias.getSelectedItem().equals(listado.get(i).getNombrePatologia())) {
                        patologia = listado.get(i);
                        break;
                    }
                }
                if (((patologia == null) || (persona.getPatologia().equals(patologia))) && (persona.getNombre().compareTo(jtfNombre.getText()) == 0)
                        && (persona.getApellido().compareTo(jtfApellido.getText()) == 0) && (persona.getEmail().compareTo(jtfEmail.getText()) == 0)
                        && (persona.getPeso() == Double.parseDouble(jtfPeso.getText())) && (persona.getAltura() == Double.parseDouble(jtfAltura.getText()))
                        && (persona.isTrabajo() == jcbTrabajadorEsencial.isSelected()) && (persona.getCelular().compareTo(jtfCelular.getText()) == 0)
                        && (persona.getDepartamento().compareTo(departamento) == 0) && (persona.getCiudad().compareTo(ciudad) == 0)) {
                    mensaje("Debe modificar al menos un campo para poder modificar a la persona.");
                    break;
                } else {
                    persona.setPatologia(patologia);
                    persona.setNombre(jtfNombre.getText());
                    persona.setApellido(jtfApellido.getText());
                    persona.setEmail(jtfEmail.getText());
                    persona.setPeso(Double.parseDouble(jtfPeso.getText()));
                    persona.setAltura(Double.parseDouble(jtfAltura.getText()));
                    persona.setTrabajo(jcbTrabajadorEsencial.isSelected());
                    persona.setCelular(jtfCelular.getText());
                    persona.setFechaDeNacimiento(jdcFechaDeNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    System.out.println(persona + " 6");
                    persona.setDepartamento(departamento);
                    persona.setCiudad(ciudad);
                    personaData.actualizarPersona(persona);
                    limpiar();
                    jbGuardar.setEnabled(true);
                    jbEliminarPersona.setEnabled(false);
                    jbModificar.setEnabled(false);
                    break;
                }

//                } catch (NullPointerException npe) {
//                    mensaje("Por favor, seleccione una fecha de nacimiento.");
//                    break;
//                }
            case 1:
                mensaje("La persona no ha sido modificada.");
                break;
            case -1:
                mensaje("La persona no ha sido modificada.");
                break;
        }
    }

    public void limpiar() {
        jtfDNI.setEditable(true);
        jtfAltura.setText("");
        jtfApellido.setText("");
        jtfCelular.setText("");
        jtfDNI.setText("");
        jtfEmail.setText("");
        jtfNombre.setText("");
        jtfPeso.setText("");
        rellenarComboBoxDepartamento();
        rellenarComboBoxCiudad();
        rellenarComboBoxPatologias();
        jdcFechaDeNacimiento.setDate(Date.valueOf(LocalDate.now()));
        jcbTrabajadorEsencial.setSelected(false);
        jbEliminarPersona.setEnabled(false);
        jbGuardar.setEnabled(true);
        jbModificar.setEnabled(false);
        jbBuscarPersona.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlPeso = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlAltura = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfPeso = new javax.swing.JTextField();
        jtfAltura = new javax.swing.JTextField();
        jlPersona = new javax.swing.JLabel();
        jlCelular = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlFechaDeNacimiento = new javax.swing.JLabel();
        jlTrabajadorEsencial = new javax.swing.JLabel();
        jlDepartamento = new javax.swing.JLabel();
        jtfCelular = new javax.swing.JTextField();
        jcbTrabajadorEsencial = new javax.swing.JCheckBox();
        jlPatologia = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jlApellido = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jlDNI = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jlCiudad = new javax.swing.JLabel();
        jdcFechaDeNacimiento = new com.toedter.calendar.JDateChooser();
        jcbDepartamentos = new javax.swing.JComboBox<>();
        jcbCiudad = new javax.swing.JComboBox<>();
        jcbPatologias = new javax.swing.JComboBox<>();
        jbEliminarPersona = new javax.swing.JButton();
        jbBuscarPersona = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jlPeso.setText("Peso:");

        jlEmail.setText("Email:");

        jlAltura.setText("Altura:");

        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
            }
        });
        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEmailKeyTyped(evt);
            }
        });

        jtfPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesoKeyTyped(evt);
            }
        });

        jtfAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfAlturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAlturaKeyTyped(evt);
            }
        });

        jlPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlPersona.setText("Agregar persona");

        jlCelular.setText("Celular:");

        jlNombre.setText("Nombre:");

        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jlFechaDeNacimiento.setText("Fec. de nac:");

        jlTrabajadorEsencial.setText("¿Es un trabajador esencial?");

        jlDepartamento.setText("Departamento:");

        jtfCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCelularKeyTyped(evt);
            }
        });

        jcbTrabajadorEsencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTrabajadorEsencialActionPerformed(evt);
            }
        });
        jcbTrabajadorEsencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbTrabajadorEsencialKeyPressed(evt);
            }
        });

        jlPatologia.setText("Si posee alguna patologia de riesgo indique cual:");

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        jbGuardar.setToolTipText("");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jbGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbGuardarKeyPressed(evt);
            }
        });

        jlApellido.setText("Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyTyped(evt);
            }
        });

        jlDNI.setText("DNI:");

        jtfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDNIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDNIKeyTyped(evt);
            }
        });

        jlCiudad.setText("Ciudad:");

        jdcFechaDeNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcFechaDeNacimientoPropertyChange(evt);
            }
        });

        jcbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDepartamentos.setToolTipText("");
        jcbDepartamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbDepartamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbDepartamentosItemStateChanged(evt);
            }
        });
        jcbDepartamentos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDepartamentosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDepartamentosPopupMenuWillBecomeVisible(evt);
            }
        });
        jcbDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDepartamentosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcbDepartamentosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcbDepartamentosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbDepartamentosMouseReleased(evt);
            }
        });
        jcbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartamentosActionPerformed(evt);
            }
        });

        jcbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCiudad.setToolTipText("");
        jcbCiudad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbCiudad.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbCiudadPopupMenuWillBecomeVisible(evt);
            }
        });
        jcbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCiudadActionPerformed(evt);
            }
        });

        jcbPatologias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPatologias.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPatologiasPopupMenuWillBecomeVisible(evt);
            }
        });

        jbEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        jbEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarPersonaActionPerformed(evt);
            }
        });

        jbBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa miniatura.png"))); // NOI18N
        jbBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarPersonaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jbSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbSalirKeyPressed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        jbLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbLimpiarKeyPressed(evt);
            }
        });

        jLabel1.setText("Para agregar a una persona llene todos los campos y presione 'enter' o haga click en el boton 'más'.");

        jLabel2.setText("Para buscar una persona llene el campo 'DNI' y haga click en la lupa para poder visualizar todos sus datos.");

        jLabel3.setText("Para poder volver a agregar a una persona haga click en el botón 'limpiar'.");

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Para modificar una persona primero debe buscarla y luego editar las celdas que desea modificar.");

        jLabel5.setText("Por ultimo para guardar los cambios debe hacer click en el botón 'Modificar'.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jlEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfEmail))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfNombre))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jlDepartamento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlApellido)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfApellido))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlCiudad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbCiudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jdcFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlDNI)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfDNI))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlAltura)
                                .addComponent(jlCelular))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlPeso)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jlTrabajadorEsencial)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbTrabajadorEsencial))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlPatologia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcbPatologias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbGuardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbBuscarPersona)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbEliminarPersona)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jbModificar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbLimpiar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbSalir))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap()))
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlPersona)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlPersona)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombre)
                            .addComponent(jlApellido)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDepartamento)
                            .addComponent(jcbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCiudad)
                            .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlFechaDeNacimiento)
                                .addComponent(jlDNI)
                                .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdcFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPeso)
                            .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlAltura)
                            .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCelular)
                            .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTrabajadorEsencial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcbTrabajadorEsencial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPatologia)
                    .addComponent(jcbPatologias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBuscarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyPressed

    }//GEN-LAST:event_jtfEmailKeyPressed

    private void jtfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailKeyTyped

    private void jtfPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyPressed

    }//GEN-LAST:event_jtfPesoKeyPressed

    private void jtfPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyTyped
        if (!(Character.isDigit(evt.getKeyChar())) && !(evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPesoKeyTyped

    private void jtfAlturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAlturaKeyPressed

    }//GEN-LAST:event_jtfAlturaKeyPressed

    private void jtfAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAlturaKeyTyped
        if (!(Character.isDigit(evt.getKeyChar())) && !(evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAlturaKeyTyped

    private void jtfNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyPressed

    }//GEN-LAST:event_jtfNombreKeyPressed

    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNombreKeyTyped

    private void jtfCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCelularKeyPressed

    }//GEN-LAST:event_jtfCelularKeyPressed

    private void jtfCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCelularKeyTyped
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCelularKeyTyped

    private void jcbTrabajadorEsencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTrabajadorEsencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTrabajadorEsencialActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (jtfAltura.getText().trim().length() == 0 || jtfApellido.getText().trim().length() == 0 || jtfCelular.getText().trim().length() == 0 || jtfDNI.getText().trim().length() == 0 || jtfEmail.getText().trim().length() == 0 || jtfNombre.getText().trim().length() == 0 || jtfPeso.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan rellenar campos.");
        } else {
            guardarPersona();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbGuardarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jtfAltura.getText().trim().length() == 0 || jtfApellido.getText().trim().length() == 0 || jtfCelular.getText().trim().length() == 0 || jtfDNI.getText().trim().length() == 0 || jtfEmail.getText().trim().length() == 0 || jtfNombre.getText().trim().length() == 0 || jtfPeso.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Faltan rellenar campos.");
            } else {
                guardarPersona();
            }
        }
    }//GEN-LAST:event_jbGuardarKeyPressed

    private void jtfApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyPressed

    }//GEN-LAST:event_jtfApellidoKeyPressed

    private void jtfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfApellidoKeyTyped

    private void jtfDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyPressed

    }//GEN-LAST:event_jtfDNIKeyPressed

    private void jtfDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyTyped
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfDNIKeyTyped

    private void jcbTrabajadorEsencialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbTrabajadorEsencialKeyPressed

    }//GEN-LAST:event_jcbTrabajadorEsencialKeyPressed

    private void jdcFechaDeNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFechaDeNacimientoPropertyChange

    }//GEN-LAST:event_jdcFechaDeNacimientoPropertyChange

    private void jcbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCiudadActionPerformed

    }//GEN-LAST:event_jcbCiudadActionPerformed

    private void jcbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartamentosActionPerformed

    }//GEN-LAST:event_jcbDepartamentosActionPerformed

    private void jcbDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDepartamentosMouseClicked

    }//GEN-LAST:event_jcbDepartamentosMouseClicked

    private void jcbDepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDepartamentosMousePressed

    }//GEN-LAST:event_jcbDepartamentosMousePressed

    private void jcbDepartamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDepartamentosMouseExited

    }//GEN-LAST:event_jcbDepartamentosMouseExited

    private void jcbDepartamentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDepartamentosMouseReleased

    }//GEN-LAST:event_jcbDepartamentosMouseReleased

    private void jcbDepartamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbDepartamentosItemStateChanged

    }//GEN-LAST:event_jcbDepartamentosItemStateChanged

    private void jcbDepartamentosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDepartamentosPopupMenuWillBecomeInvisible
        rellenarComboBoxCiudad();
    }//GEN-LAST:event_jcbDepartamentosPopupMenuWillBecomeInvisible

    private void jbEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarPersonaActionPerformed
        eliminarPersona();
    }//GEN-LAST:event_jbEliminarPersonaActionPerformed

    private void jbBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarPersonaActionPerformed
        if (jtfDNI.getText().trim().length() == 0) {
            mensaje("Ingrese un DNI para buscar.");
        } else {
            mostrarPersona();
        }
    }//GEN-LAST:event_jbBuscarPersonaActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbSalirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
    }//GEN-LAST:event_jbSalirKeyPressed

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost

    }//GEN-LAST:event_jtfEmailFocusLost

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLimpiarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
    }//GEN-LAST:event_jbLimpiarKeyPressed

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jcbDepartamentosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDepartamentosPopupMenuWillBecomeVisible
        rellenarComboBoxDepartamento();
    }//GEN-LAST:event_jcbDepartamentosPopupMenuWillBecomeVisible

    private void jcbCiudadPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbCiudadPopupMenuWillBecomeVisible
        rellenarComboBoxCiudad();
    }//GEN-LAST:event_jcbCiudadPopupMenuWillBecomeVisible

    private void jcbPatologiasPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPatologiasPopupMenuWillBecomeVisible
        rellenarComboBoxPatologias();
    }//GEN-LAST:event_jcbPatologiasPopupMenuWillBecomeVisible

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        modificarPersona();
    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscarPersona;
    private javax.swing.JButton jbEliminarPersona;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbCiudad;
    private javax.swing.JComboBox<String> jcbDepartamentos;
    private javax.swing.JComboBox<String> jcbPatologias;
    private javax.swing.JCheckBox jcbTrabajadorEsencial;
    private com.toedter.calendar.JDateChooser jdcFechaDeNacimiento;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlCiudad;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFechaDeNacimiento;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPatologia;
    private javax.swing.JLabel jlPersona;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlTrabajadorEsencial;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCelular;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPeso;
    // End of variables declaration//GEN-END:variables
}
