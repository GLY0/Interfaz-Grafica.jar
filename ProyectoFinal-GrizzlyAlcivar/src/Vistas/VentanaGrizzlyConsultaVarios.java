//GRIZZLY ALCIVAR
package Vistas;

import Controlador.ControladorGrizzlyConsultaVarios;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class VentanaGrizzlyConsultaVarios extends JFrame {
    JLabel lblBuscar;
    public JTextField txtBuscar;
    public JButton btnBuscar ; 
    public JTable tableDestino;
    
    public VentanaGrizzlyConsultaVarios(){
        this.setTitle("Ventana de Busqueda por lugar");
        this.setSize(700,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        componenetes();
    }
    private void componenetes(){
        GridLayout grid = new GridLayout(2,1,10,10);// #filas, # columnas, separacion horizontal, separacion vertical
        this.setLayout(grid);
        
        JPanel panelBuscar = new JPanel();
        this.getContentPane().add(panelBuscar);
        panelBuscar.setLayout(new FlowLayout());
        this.add(panelBuscar);

        lblBuscar = new JLabel("Buscar:");
        panelBuscar.add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setColumns(20);
        panelBuscar.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        panelBuscar.add(btnBuscar);
        
        String columnas[] = {"Lugar de Destino", "Tipo de Hotel", "Cuartos Reservados"};
        String filas[][] = {{"Ecuador", "cinco estrellas","5"}, {"Panama", "dos estrellas","2"}, {"Panama", "tres estrellas","1"}};
        
        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        
        this.tableDestino = new JTable();
        this.tableDestino.setModel(model);
        JScrollPane pane = new JScrollPane(tableDestino);
        this.add(pane);
    }
    
    public static void main(String[] args) {
        VentanaGrizzlyConsultaVarios ventana = new VentanaGrizzlyConsultaVarios();
        ControladorGrizzlyConsultaVarios controlador = new ControladorGrizzlyConsultaVarios(ventana);
        ventana.setVisible(true);
    } 
}
