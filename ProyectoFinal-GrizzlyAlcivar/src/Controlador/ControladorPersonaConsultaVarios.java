//GRIZZLY ALCIVAR
package Controlador;

import Modelos.PersonasDAO;
import Modelos.PersonasDTO;
import Vistas.VentanaPersonaConsultaVarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControladorPersonaConsultaVarios {
    
    VentanaPersonaConsultaVarios ven;
    PersonasDAO personaDAO;
    
    public ControladorPersonaConsultaVarios() {
        
    }
    
    public ControladorPersonaConsultaVarios(VentanaPersonaConsultaVarios ventana) {
        this.ven = ventana;  
        this.personaDAO = new PersonasDAO();

        // enlazar listeners de eventos a los componentes
        MyActionListener myAction = new MyActionListener();
        this.ven.btnBuscar.addActionListener(myAction);
        
        cargarTabla();// cargar jTable con datos leidos de archivos
        
    }
    
    public void setVen(VentanaPersonaConsultaVarios ven) {
        this.ven = ven;
    }
    
    private void cargarTabla() {
        String criterio = ven.txtBuscar.getText();        
        ArrayList<PersonasDTO> lista;       
        if (criterio.equals("")) {
            lista = personaDAO.buscarTodo();// obtiene todas las personas 
        } else {
            lista = personaDAO.buscarxNombre(criterio); //obtiene solo las personas que cumplan con el criterio de busqueda
        }
        
        // cargar la lista de personas en el jTable
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"Cedula","Nombre","Apellido",
            "Edad", "Motivo de Viaje", "Metodo de Pago", 
            "Vacuna Poliomielitis","Vacuna Fiebre Amarilla","Vacuna Influenza"};
        modelo.setColumnIdentifiers(columnas);
 
        for (PersonasDTO p: lista){// for each
          modelo.addRow(new Object[] { 
              p.getCedula(), p.getNombre(),p.getApellidos(),p.getEdad(),p.getMotivo(),p.getPago()
                 ,(p.isPoliomielitis())?"Si":"No",p.isFiebre()?"Si":"No",p.isInfluenza()?"Si":"No"});
        }
        this.ven.tablePersonas.setModel(modelo);       
    }
    // clases internas
    // CLASE INTERNA PARA MANEJAR EVENTOS DE LOS BOTONES
    class MyActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ven.btnBuscar) {
                cargarTabla();    
            }
        }
    }
}
