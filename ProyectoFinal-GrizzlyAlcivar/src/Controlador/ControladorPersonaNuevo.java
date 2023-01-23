//GRIZZLY ALCIVAR
package Controlador;

import Modelos.PersonasDAO;
import Modelos.PersonasDTO;
import Vistas.Menu;
import Vistas.VentanaPersonaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControladorPersonaNuevo {
    
     // comunicarse con el modelo y la vista
    PersonasDTO persona; // el modelo
    PersonasDAO personaDao;
    VentanaPersonaNuevo vent;   // la vista

    public ControladorPersonaNuevo() {

    }
    public void setVentanaNuevo(VentanaPersonaNuevo vent) {
        this.vent = vent;
    }
    public ControladorPersonaNuevo(VentanaPersonaNuevo vent) {
        this.vent = vent;

        EscuchaBotones escucha = new EscuchaBotones();
        //Botones
        this.vent.btnguaradar.addActionListener(escucha);
        this.vent.btnmostrar.addActionListener(escucha);

        EscuchaTeclado escTeclado = new EscuchaTeclado();
        this.vent.txtNombre.addKeyListener(escTeclado);
        this.vent.txtCedula.addKeyListener(escTeclado);
        this.vent.txtApellido.addKeyListener(escTeclado);
        this.vent.txtEdad.addKeyListener(escTeclado);

        EscuchaItem escItem = new EscuchaItem();
        //Motivo de viaje
        this.vent.cmbtipo.addItemListener(escItem);

        EscuchaChange escChange = new EscuchaChange();
        this.vent.rbdos.addChangeListener(escChange);
        this.vent.rbuna.addChangeListener(escChange);
        this.vent.rbtres.addChangeListener(escChange);
        //Vacunas
        this.vent.checkop1.addChangeListener(escChange);
        this.vent.checkop2.addChangeListener(escChange);
        this.vent.checkop3.addChangeListener(escChange);
    }
// CLASES INTERNAS PARA MANEJO DE EVENTOS 
    // para checkbox y radios
    class EscuchaChange implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            if (ce.getSource() == vent.rbuna) {
                if (vent.rbuna.isSelected()) {
                }
            } else if (ce.getSource() == vent.rbdos) {
                if (vent.rbdos.isSelected()) {
                }
                }else if (ce.getSource() == vent.rbtres) {
                if (vent.rbtres.isSelected()) {
                }
            } else if (ce.getSource() == vent.checkop1) {
                if (vent.checkop1.isSelected()) {
                } 
            }else if (ce.getSource() == vent.checkop2) {
                if (vent.checkop2.isSelected()) {
                }
            }else if (ce.getSource() == vent.checkop3) {
                if (vent.checkop3.isSelected()) {
                } 
            }
        }
    }
    // para combos JComboBox
    class EscuchaItem implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            JComboBox cmb = (JComboBox) 
            ie.getSource();
            String MotivoViaje = cmb.getSelectedItem().toString();
        }
    }
    // para caja de texto, text area, spinner
    class EscuchaTeclado extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent ke) {
            Character c = ke.getKeyChar();// obtener el caracter presionado
            // validacion
            boolean valido = true;
            if (ke.getSource() == vent.txtNombre) {
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    valido = false;
                }
            }
            if (ke.getSource() == vent.txtCedula) {
                if (!Character.isDigit(c)) {
                    valido = false;
                }

                if (vent.txtCedula.getText().length() >= 10) {
                    valido = false;
                }
            }
            if (ke.getSource() == vent.txtApellido) {
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    valido = false;
                }
            }if (ke.getSource() == vent.txtEdad) {
                if (!Character.isDigit(c)) {
                    valido = false;
                }

                if (vent.txtEdad.getText().length() >= 2) {
                    valido = false;
                }
            }
            if (!valido) {
                ke.consume();
            }
        }
    }
    // para botones
    class EscuchaBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == vent.btnguaradar) {
                guardarDatos();
            } else if (ae.getSource() == vent.btnmostrar) {
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        } 
    }
    public void guardarDatos() {
        boolean valido = true;
        String m = "";
        //CAJAS DE TEXTO
        String ced = vent.txtCedula.getText();
        if (ced.length() != 10) {
            m = "cedula debe tener 10 \n";
            valido = false;
        }
        String nombre = vent.txtNombre.getText();
        String apellido = vent.txtApellido.getText();
        int edad = Integer.parseInt(vent.txtEdad.getText());
        
        //Motivo de viaje
        String Motivo = vent.cmbtipo.getSelectedItem().toString();
        if (Motivo.equalsIgnoreCase("Vacacional")) {
        } else if (Motivo.equalsIgnoreCase("Negocio")) {
        }else if (Motivo.equalsIgnoreCase("Seminario")) {
        }
        //Pago
        String pago = "";
        boolean sel = false;
        if (vent.rbuna.isSelected()) {
            sel = true;
            pago = vent.rbuna.getText();
        } else if (vent.rbdos.isSelected()) {
            sel = true;
            pago = vent.rbdos.getText();
        } else if (vent.rbtres.isSelected()) {
            sel = true;
            pago = vent.rbtres.getText();
        }
        if (!sel) {
            m += "Debe seleccionar un metdod de pago \n";
            valido = false;
        }
        //vacunas 
        boolean vacuna1 = false;
        if (vent.checkop1.isSelected()) {
            vacuna1 = true;
        }
        boolean vacuna2 = false;
        if (vent.checkop2.isSelected()) {
            vacuna2 = true;
        }
        boolean vacuna3 = false;
        if (vent.checkop3.isSelected()) {
            vacuna3 = true;
        }
        if (!valido) {
            JOptionPane.showMessageDialog(null, m);
            return;
        }
        persona = new PersonasDTO();
        persona.setCedula(ced);
        persona.setNombre(nombre);
        persona.setApellidos(apellido);
        persona.setEdad(edad);
        persona.setMotivo(Motivo);
        persona.setPago(pago);
        persona.setPoliomielitis(vacuna1);
        persona.setFiebre(vacuna2);
        persona.setInfluenza(vacuna3);
        
        // guardar datos en archivo
        personaDao = new PersonasDAO();
        boolean exito = personaDao.escribir(persona.toStringParaArchivo());
        if (exito) {
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar");
        }
    }  
}         
