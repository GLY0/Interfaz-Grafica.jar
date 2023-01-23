//GRIZZLY ALCIVAR
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Modelos.GrizzlyDAO;
import Modelos.GrizzlyDTO;
import Vistas.VentanaGrizzlyConsultaVarios;

public class ControladorGrizzlyConsultaVarios {
    
    VentanaGrizzlyConsultaVarios ven;
    GrizzlyDAO grizzlyDAO;
    
    public ControladorGrizzlyConsultaVarios() {
        
    } 
    public ControladorGrizzlyConsultaVarios(VentanaGrizzlyConsultaVarios ventana) {
        this.ven = ventana;  
        this.grizzlyDAO = new GrizzlyDAO();

        MyActionListener myAction = new MyActionListener();
        this.ven.btnBuscar.addActionListener(myAction);
        
        cargarTabla();// cargar jTable con datos leidos de archivos    
    }
    
    public void setVen(VentanaGrizzlyConsultaVarios ven) {
        this.ven = ven;
    }
    
    private void cargarTabla() {
        String criterio = ven.txtBuscar.getText();        
        ArrayList<GrizzlyDTO> lista;       
        if (criterio.equals("")) {
            lista = grizzlyDAO.buscarTodo();// obtiene todas las personas 
        } else {
            lista = grizzlyDAO.buscarxLugar(criterio); //obtiene solo las personas que cumplan con el criterio de busqueda
        }
 // cargar la lista de personas en el jTable
        DefaultTableModel modelo = new DefaultTableModel();
        
        String columnas[] = {"Pasaporte ","Lugar de Destino", "Tipo de Hotel","Hospedaje","Guia","Tours"
                ,"Traslado","Cuartos compartidos","Cuartos Reservados"};
        modelo.setColumnIdentifiers(columnas);
 
        for (GrizzlyDTO p: lista){// for each
          modelo.addRow(new Object[] { 
              p.getPasaporte(), p.getLugar(),p.getHotel(),(p.isHospedaje())?"Si":"No"
              ,p.isGuia()?"Si":"No",p.isTours()?"Si":"No",p.isTraslado()?"Si":"No"
                  ,(p.isCuartosCompartido())?"Si":"No",p.getCuartosCompartidos()});
        // establecer el modelo de datos al jTable
            this.ven.tableDestino.setModel(modelo);
        }
    }
    // clases internas
    // CLASE INTERNA PARA MANEJAR EVENTOS DE LOS BOTONES
    class MyActionListener implements ActionListener {     
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ven.btnBuscar) {
                //cargar datos en jtable
                cargarTabla();    
            }
        }
    }
}
