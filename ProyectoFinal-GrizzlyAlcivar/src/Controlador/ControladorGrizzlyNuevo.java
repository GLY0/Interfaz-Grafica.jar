//GRIZZLY ALCIVAR
package Controlador;

import Modelos.GrizzlyDAO;
import Modelos.GrizzlyDTO;
import Vistas.Menu;
import Vistas.VentanaGrizzlyNuevo;
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


public class ControladorGrizzlyNuevo {
     // comunicarse con el modelo y la vista
    GrizzlyDTO Destino;
    GrizzlyDAO GrizzlyDAO;
    VentanaGrizzlyNuevo vent;   // la vista

    public ControladorGrizzlyNuevo() {

    }

    public void setVentanaNuevo(VentanaGrizzlyNuevo vent) {
        this.vent = vent;
    }

    public ControladorGrizzlyNuevo(VentanaGrizzlyNuevo vent) {
        this.vent = vent;

        EscuchaBotones escucha = new EscuchaBotones();
        //Botones
        this.vent.btnguaradar.addActionListener(escucha);
        this.vent.btnmostrar.addActionListener(escucha);

        EscuchaTeclado escTeclado = new EscuchaTeclado();
        this.vent.txtPasaporte.addKeyListener(escTeclado);
        this.vent.txtNroHabitacion.addKeyListener(escTeclado);
        this.vent.txtCantidadCuarto.addKeyListener(escTeclado);
        
        EscuchaItem escItem = new EscuchaItem();
        this.vent.cmbtipo.addItemListener(escItem); //lugar

        EscuchaChange escChange = new EscuchaChange();
        //Tipo Hotel
        this.vent.rbuna.addChangeListener(escChange);
        this.vent.rbdos.addChangeListener(escChange);
        this.vent.rbtres.addChangeListener(escChange);
        this.vent.rbcuatro.addChangeListener(escChange);
        this.vent.rbcinco.addChangeListener(escChange);
        //opciones si y no
        this.vent.rbsi.addChangeListener(escChange);
        this.vent.rbno.addChangeListener(escChange);
        //Tipo de paquiete
        this.vent.checkop1.addChangeListener(escChange);
        this.vent.checkop2.addChangeListener(escChange);
        this.vent.checkop3.addChangeListener(escChange);
        this.vent.checkop4.addChangeListener(escChange);

    }
// CLASES INTERNAS PARA MANEJO DE EVENTOS 
   // para checkbox y radios
    class EscuchaChange implements ChangeListener {
        //Hotel
        @Override
        public void stateChanged(ChangeEvent ce) {
            if (ce.getSource() == vent.rbuna) {
                if (vent.rbuna.isSelected()) {
                }
            } else if (ce.getSource() == vent.rbdos) {
                if (vent.rbdos.isSelected()) {
                }
            } else if (ce.getSource() == vent.rbtres) {
                if (vent.rbtres.isSelected()) {
                }
            }else if (ce.getSource() == vent.rbcuatro) {
                if (vent.rbcuatro.isSelected()) {
                }
            }else if (ce.getSource() == vent.rbcinco) {
                if (vent.rbcinco.isSelected()) {
                }
            }
            //opcion de habilitar y deshabilitar campo ojo
            else if (ce.getSource() == vent.rbsi) { 
                if (vent.rbsi.isSelected()) {
                    vent.txtNroHabitacion.setEnabled(true);
                } else{
                    vent.txtNroHabitacion.setEnabled(false);
                } 
            }
            //Paqutes
            else if (ce.getSource() == vent.checkop1) {
                if (vent.checkop1.isSelected()) {
                } 
            }else if (ce.getSource() == vent.checkop2) {
                if (vent.checkop2.isSelected()) {
                }
            }else if (ce.getSource() == vent.checkop3) {
                if (vent.checkop3.isSelected()) {
                } 
            }else if (ce.getSource() == vent.checkop4) {
                if (vent.checkop3.isSelected()) {
                } 
            }
        }
    }
    // para combos JComboBox
    class EscuchaItem implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            JComboBox cmb = (JComboBox) ie.getSource();
            String lugar = cmb.getSelectedItem().toString();
        }
    }
    class EscuchaTeclado extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent ke) {
            Character c = ke.getKeyChar();
            // validacion pasaporte
            boolean valido = true;
            if (ke.getSource() == vent.txtPasaporte) {
                if (!Character.isDigit(c)) {
                    valido = false;
                }

                if (vent.txtPasaporte.getText().length() >= 10) {
                    valido = false;
                }
            }
//            //validacion cuarto
            if (ke.getSource() == vent.txtNroHabitacion) {
                if (!Character.isDigit(c)) {
                    valido = false;
                }
                if (vent.txtNroHabitacion.getText().length() >= 5) {
                    valido = false;
                }
            }
            //validacion nro de cuarto
            if (ke.getSource() == vent.txtCantidadCuarto) {
                if (!Character.isDigit(c)) {
                    valido = false;
                }

                if (vent.txtCantidadCuarto.getText().length() >= 2) {
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
    private void guardarDatos() {
        boolean valido = true;
        String m = "";
        String pasaporte = vent.txtPasaporte.getText();//getText leer texto
        if (pasaporte.length() != 10) {
            m = "El pasaporte debe tener 10 \n";
            valido = false;
        }       
        //PAIS DE DESTINO
        String lugar = vent.cmbtipo.getSelectedItem().toString();
        if (lugar.equalsIgnoreCase("Ecuador")) {
        } else if (lugar.equalsIgnoreCase("Colombia")) {
        }else if (lugar.equalsIgnoreCase("Panama")) {
        }
        //TIPO DE HOTEL
        String Hotel = "";
        boolean sel = false;
        if (vent.rbuna.isSelected() == true) {
            sel = true;
            Hotel = vent.rbuna.getText();   
        } else if (vent.rbdos.isSelected()) {
            sel = true;
            Hotel = vent.rbdos.getText();
        } else if (vent.rbtres.isSelected()) {
            sel = true;
            Hotel = vent.rbtres.getText();
        }else if (vent.rbcuatro.isSelected()) {
            sel = true;
            Hotel = vent.rbcuatro.getText();
        }else if (vent.rbcinco.isSelected()) {
            sel = true;
            Hotel = vent.rbcinco.getText();
        }
        if (!sel) {
            m += "Debe seleccionar un el tipo de Hotel \n";
            valido = false;
        }
        //TIPO DE PAQUETE
        boolean Hospedaje = false;
        if (vent.checkop1.isSelected()) {
            Hospedaje = true;
        }
        boolean guia = false; 
        if (vent.checkop2.isSelected()) {
            guia = true;
        }
        boolean tours = false; 
        if (vent.checkop3.isSelected()) {
            tours = true;
        }
        boolean traslado = false;
        if (vent.checkop4.isSelected()) {
            traslado = true;
        }
        //Nro de ahbitacion compartida
        int habitacion = Integer.parseInt(vent.txtNroHabitacion.getText());
        //cantidad de habitaciones reservadas
        int cuartos = Integer.parseInt(vent.txtCantidadCuarto.getText());
        
        if (!valido) {
            JOptionPane.showMessageDialog(null, m);
            return;
        } 
        Destino = new GrizzlyDTO();
        Destino.setPasaporte(pasaporte);
        Destino.setLugar(lugar);
        Destino.setHotel(Hotel);
        Destino.setHospedaje(Hospedaje);
        Destino.setGuia(guia);
        Destino.setTours(tours);
        Destino.setTraslado(traslado);
        Destino.setCuartosCompartidos(habitacion);
        Destino.setCuartos(cuartos);

        // guardar datos en archivo
        GrizzlyDAO = new GrizzlyDAO();
        boolean exito = GrizzlyDAO.escribir(Destino.toStringParaArchivo());
        if (exito) {
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar");
        } 
    }
}

