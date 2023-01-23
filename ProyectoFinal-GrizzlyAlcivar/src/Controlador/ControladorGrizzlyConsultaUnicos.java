//GRIZZLY ALCIVAR
package Controlador;

import Modelos.GrizzlyDAO;
import Modelos.GrizzlyDTO;
import Vistas.VentanaGrizzlyConsultaUnico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorGrizzlyConsultaUnicos{
 
     
    // vista
    private VentanaGrizzlyConsultaUnico ven;
    //modelo
    private GrizzlyDAO DestinoDAO;

    public ControladorGrizzlyConsultaUnicos() {
    }
    
    public ControladorGrizzlyConsultaUnicos(VentanaGrizzlyConsultaUnico ventana) {
        this.ven = ventana;

        this.DestinoDAO = new GrizzlyDAO();

        // REGISTRAR LOS ESCUCHAS DE EVENTOS

        MyActionListener myAction = new MyActionListener();
        this.ven.btnBsucar.addActionListener(myAction);
        this.ven.btnCancelar.addActionListener(myAction);
    }
    public void mostarDatos() {
        String pasaporte = this.ven.txtPasaporte.getText();
     
        GrizzlyDTO Destino = DestinoDAO.buscarXPasaporte(pasaporte);
        
        if(Destino==null){
            JOptionPane.showMessageDialog(ven, "No existe el destino buscado");
            return; // para salir del metodo y que no continue su ejecucion
        }  
        
        this.ven.cmbtipo.setSelectedItem(Destino.getLugar());// poner el elemento seleccionado de un combo
        
        //Hotel
        if (Destino.getHotel().equals("Hotel de una estrella")) {
            this.ven.rbuna.setSelected(true);
        } else if (Destino.getHotel().equals("Hotel de dos estrella")) {
            this.ven.rbdos.setSelected(true);
        } else if (Destino.getHotel().equals("Hotel de tres estrella")) {
            this.ven.rbtres.setSelected(true);
        }else if (Destino.getHotel().equals("Hotel de cuatro estrella")) {
            this.ven.rbcuatro.setSelected(true);
        }else if (Destino.getHotel().equals("Hotel de cinco estrella")) {
            this.ven.rbcinco.setSelected(true);
        }
        //CHECKBOXS paquetes 
        this.ven.checkop1.setSelected(Destino.isHospedaje());// seleccionar si la casilla de verificacion   
        ven.checkop1.setEnabled(false);
        this.ven.checkop2.setSelected(Destino.isGuia());
        ven.checkop2.setEnabled(false);
        this.ven.checkop3.setSelected(Destino.isTours());
        ven.checkop3.setEnabled(false);
        this.ven.checkop4.setSelected(Destino.isTraslado());
        ven.checkop4.setEnabled(false);
      
       //condicon para habilitar texto cyars compartidos
        this.ven.rbno.setSelected(Destino.isCuartosCompartido());
        this.ven.rbno.setSelected(true);
        ven.rbno.setEnabled(false);
        this.ven.rbsi.setSelected(Destino.isCuartosCompartido());
        this.ven.rbsi.setSelected(true);
        ven.rbsi.setEnabled(false);
        this.ven.txtcompartir.setText(Destino.getCuartosCompartidos()+"");
        ven.txtcompartir.setEnabled(false);
        this.ven.txtcuarto.setText(Destino.getCuartos()+"");
        ven.txtcuarto.setEnabled(false);
        
    }       
    // clases internas
    // CLASE INTERNA PARA MANEJAR EVENTOS DE LOS BOTONES
    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ven.btnBsucar) {
                mostarDatos();
            } else if (ae.getSource() == ven.btnCancelar) {
                ven.dispose();
            }
        }
    }   
}
