//GRIZZLY ALCIVAR
package Controlador;

import Modelos.PersonasDAO;
import Modelos.PersonasDTO;
import Vistas.VentanaPersonaConsultaUnico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorPersonaConsultaUnico {
    
    // vista
    private VentanaPersonaConsultaUnico ven;
    //modelo
    private PersonasDAO personaDAO;

    public ControladorPersonaConsultaUnico() {
    }
    public ControladorPersonaConsultaUnico(VentanaPersonaConsultaUnico ventana) {
        this.ven = ventana;

        this.personaDAO = new PersonasDAO();

        // REGISTRAR LOS ESCUCHAS DE EVENTOS
        //escucha de eventos para botones
        MyActionListener myAction = new MyActionListener();
        this.ven.btnBsucar.addActionListener(myAction);
        this.ven.btnCancelar.addActionListener(myAction);
    }

    public void mostarDatos() {
        String cedula = this.ven.txtCedula.getText();
     
        PersonasDTO persona = personaDAO.buscarXCedula(cedula);
        if(persona==null){
            JOptionPane.showMessageDialog(ven, "No existe la persona buscada");
            return; // para salir del metodo y que no continue su ejecucion
        }
        //cajas de texto
        this.ven.txtNombre.setText(persona.getNombre());
        this.ven.txtApellido.setText(persona.getApellidos());
        this.ven.txtEdad.setText(persona.getEdad()+""); //conversion de int a String solo agregando un " "
        this.ven.cmbtipo.setSelectedItem(persona.getMotivo());// poner el elemento seleccionado de un combo
        
        //CHECKBOXS Vacunas 
        this.ven.checkop1.setSelected(persona.isPoliomielitis());// seleccionar si la casilla de verificacion   
        this.ven.checkop2.setSelected(persona.isFiebre());
        this.ven.checkop3.setSelected(persona.isInfluenza());

    //METODOD DE PAGO
       if (persona.getPago().equals("Tarjeta")) {
            this.ven.rbuna.setSelected(true);
        } else if (persona.getPago().equals("Efectivo")) {
            this.ven.rbdos.setSelected(true);
        } else if (persona.getPago().equals("Transferencia Bancaria")) {
            this.ven.rbtres.setSelected(true);
        }
    }
        
    // clases internas
    // CLASE INTERNA PARA MANEJAR EVENTOS DE LOS BOTONES
    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ven.btnBsucar) {
                mostarDatos();
            } else if (ae.getSource() == ven.btnCancelar) {
                ven.dispose();//cerrar la ventana
            }
        }
    }
}
