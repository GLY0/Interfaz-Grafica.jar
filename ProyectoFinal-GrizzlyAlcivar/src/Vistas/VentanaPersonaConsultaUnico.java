//GRIZZLY ALCIVAR
package Vistas;

import Controlador.ControladorPersonaConsultaUnico;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class VentanaPersonaConsultaUnico extends JFrame{
    JLabel lbltitulo,lbltipo,lblNombre,lblApellido,lblCedula,lblPago,lblVacunas,lblEdad;
    public JComboBox cmbtipo;
    public JTextField txtNombre,txtApellido,txtCedula,txtEdad;
    public JRadioButton rbuna,rbdos,rbtres;
    public ButtonGroup GpPago;
    public JButton btnBsucar,btnCancelar;
    public JCheckBox checkop1,checkop2,checkop3;
    public VentanaPersonaConsultaUnico(){  
        this.setSize(430, 600);
        this.setTitle("ventana de Registro de Persona ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        componentes();
    }
    private void componentes() {
        JPanel General = new JPanel();
        this.getContentPane().add(General);
        General.setLayout(new FlowLayout(FlowLayout.CENTER));
        General.setSize(400, 500);
        
        GridLayout grid = new GridLayout(9,1,10,10);
        General.setLayout(grid);
        this.add(General);   
//Primer panel - titulo
        lbltitulo = new JLabel("Registro de Persona");
        lbltitulo.setFont(new Font("Colibri Light",Font.BOLD, 25));
        JPanel SubPanel1 = new JPanel();
        SubPanel1.add(lbltitulo, BorderLayout.PAGE_START);   
//Segundo Panel - componenetes 
        //Nomnbre - texto (busqueda varia)
        lblNombre = new JLabel("Ingrese su Nombre: ");
        txtNombre = new JTextField(10);
        JPanel SubPanel2 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel2.add(lblNombre); 
        SubPanel2.add(txtNombre); 
        //Apellidos -  texto
        lblApellido = new JLabel("Ingrese sus Apellido: ");
        txtApellido = new JTextField(10);
        JPanel SubPanel3 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel3.add(lblApellido); 
        SubPanel3.add(txtApellido);
        //Edad -  texto
        lblEdad = new JLabel("Ingrese su Edad: ");
        txtEdad = new JTextField(10);
        JPanel SubPanel9 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel9.add(lblEdad); 
        SubPanel9.add(txtEdad); 
        //Cedula - texto (busqueda unica)    
        lblCedula = new JLabel("Ingrese los digitos de su Cedula");
        txtCedula = new JTextField(10);
        JPanel SubPanel4 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel4.add(lblCedula); 
        SubPanel4.add(txtCedula);
        
        JPanel panelD = new JPanel();
        btnBsucar = new JButton("Buscar");
        panelD.add(btnBsucar);
        panelD.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnCancelar = new JButton("Cancelar");
        panelD.add(btnCancelar);
        //tipo de pago - eleccion
        lblPago = new JLabel("Metodo de Pago : ");
        rbuna = new JRadioButton("Tarjeta");
        rbdos = new JRadioButton("Efectivo");
        rbtres = new JRadioButton("Transferencia Bancaria"); 
        
        GpPago = new ButtonGroup();
        GpPago.add(rbuna);
        GpPago.add(rbdos);
        GpPago.add(rbtres);
        
        JPanel SubPanel5 = new JPanel(new GridLayout(4,1,5,1));
        SubPanel5.add(lblPago);
        SubPanel5.add(rbuna);
        SubPanel5.add(rbdos);
        SubPanel5.add(rbtres);
        //Vacunas - opciones multiples 
        lblVacunas = new JLabel("Que vacunas Posee? : ");
        checkop1 = new JCheckBox("Vacuna contra la Poliomielitis");
        checkop2 = new JCheckBox("Vacuna contra la Fiebre Amarilla");
        checkop3 = new JCheckBox("Vacuna contra la Influenza");
        
        JPanel SubPanel6 = new JPanel(new GridLayout(4,1,5,1));
        SubPanel6.add(lblVacunas);
        SubPanel6.add(checkop1);
        SubPanel6.add(checkop2);
        SubPanel6.add(checkop3);
        //Motivo de viaje
        lbltipo = new JLabel("Motivo de viaje:    ");
        String[] tipo = {"Vacacional", "Negocio", "Seminario"};
        cmbtipo = new JComboBox(tipo);
        JPanel SubPanel7 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
        SubPanel7.add(lbltipo);
        SubPanel7.add(cmbtipo);

        //Agrupacion de paneles 
        General.add(SubPanel1);
        General.add(SubPanel4);
        General.add(panelD);
        General.add(SubPanel2);
        General.add(SubPanel3);
        General.add(SubPanel9);
        General.add(SubPanel7);
        General.add(SubPanel5);
        General.add(SubPanel6);

     }
    
    public static void main(String[] args) {
        VentanaPersonaConsultaUnico ventana = new VentanaPersonaConsultaUnico();
      ControladorPersonaConsultaUnico controlador = new ControladorPersonaConsultaUnico(ventana);
        ventana.setVisible(true);
    } 
}
