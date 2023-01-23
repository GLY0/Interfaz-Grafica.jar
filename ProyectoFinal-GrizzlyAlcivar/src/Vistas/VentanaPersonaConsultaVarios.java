//GRIZZLY ALCIVAR
package Vistas;

import Controlador.ControladorPersonaConsultaVarios;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class VentanaPersonaConsultaVarios extends JFrame {
     JLabel lblBuscar;
    public JTextField txtBuscar;
    public JButton btnBuscar, btnCancelar;
    public JTable tablePersonas;
    JPanel panelBuscar;

    public VentanaPersonaConsultaVarios() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.setTitle("Consulta de personas");
        this.setSize(700,250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //como se van a ubicar los componentes
        GridLayout grid = new GridLayout(2,1,10,10);// #filas, # columnas, separacion horizontal, separacion vertical
        this.setLayout(grid);

        //crear los componentes
        panelBuscar = new JPanel();
        panelBuscar.setLayout(new FlowLayout());
        this.add(panelBuscar);

        lblBuscar = new JLabel("Buscar:");
        panelBuscar.add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setColumns(20);
        panelBuscar.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        panelBuscar.add(btnBuscar);

        String columnas[] = {"Nombre", "Motivo de Viaje","Forma de pago"};
        String filas[][] = {{"Morgana", "Negocio","Efectivo"}, {"Julian", "Vacacional","Deposito"}, {"Hector", "Negocio","Efectivo"}, {"Juliana", "Seminario","Transferencia"}};

        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        this.tablePersonas = new JTable();
        this.tablePersonas.setModel(model);
        JScrollPane pane = new JScrollPane(tablePersonas);
        this.add(pane);
    }
    public static void main(String[] args) {
        VentanaPersonaConsultaVarios ventana = new VentanaPersonaConsultaVarios();
        ControladorPersonaConsultaVarios controlador = new ControladorPersonaConsultaVarios(ventana);
        ventana.setVisible(true);
    } 
}
