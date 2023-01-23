//GRIZZLY ALCIVAR
package Controlador;

import Vistas.*;
import Vistas.VentanaPersonaConsultaVarios;
import Vistas.VentanaPersonaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu {
    
    Menu Venrtanamenu; 
    
    public ControladorMenu(){       
    }

    public void setControladorMenu(Menu Venrtanamenu) {
        this.Venrtanamenu = Venrtanamenu;
    }
    
    public ControladorMenu(Menu Venrtanamenu){
        this.Venrtanamenu = Venrtanamenu;
        //Persona
        EscuchaBotones escucha = new EscuchaBotones();
        this.Venrtanamenu.itemBuscarxApellido.addActionListener(escucha);
        this.Venrtanamenu.itemBuscarxCedula.addActionListener(escucha);
        this.Venrtanamenu.itemNuevo.addActionListener(escucha);
        //Destino
        this.Venrtanamenu.itemBuscarxlugar.addActionListener(escucha);
        this.Venrtanamenu.itemBuscarxpasporte.addActionListener(escucha);
        this.Venrtanamenu.itemDestino.addActionListener(escucha);
    }
    class EscuchaBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Venrtanamenu.itemBuscarxApellido) {
                VentanaPersonaConsultaVarios ven = new VentanaPersonaConsultaVarios();
                ven.setVisible(true);
            } else if (ae.getSource() == Venrtanamenu.itemBuscarxCedula) {
                VentanaPersonaConsultaUnico ven = new VentanaPersonaConsultaUnico();
                ven.setVisible(true);  
            }else if (ae.getSource() == Venrtanamenu.itemNuevo) {
                VentanaPersonaNuevo ven = new VentanaPersonaNuevo();
                ven.setVisible(true);
            }else if (ae.getSource() == Venrtanamenu.itemBuscarxlugar) {
                VentanaGrizzlyConsultaVarios ven = new VentanaGrizzlyConsultaVarios();
                ven.setVisible(true);
            }else if (ae.getSource() == Venrtanamenu.itemBuscarxpasporte) {
                VentanaGrizzlyConsultaUnico ven = new VentanaGrizzlyConsultaUnico();
                ven.setVisible(true);
            }else if (ae.getSource() == Venrtanamenu.itemDestino) {
                VentanaGrizzlyNuevo ven = new VentanaGrizzlyNuevo();
                ven.setVisible(true);
            }
        }
    }
}
