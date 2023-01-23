//GRIZZLY ALCIVAR
package Vistas;

import Controlador.ControladorGrizzlyNuevo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class VentanaGrizzlyNuevo extends JFrame{
    //VARIBLES 
    JLabel lbltitulo,lbltipo,lblpaquete,lblHotel,lblcuarto,lblImagen,lblcompartir,lblPasaporte,lblNroCuarto;
    public JComboBox cmbtipo;
    public JCheckBox checkop1,checkop2,checkop3,checkop4;
    public JRadioButton rbuna,rbdos, rbtres,rbcuatro,rbcinco,rbsi,rbno;
    public ButtonGroup GpHotel,Gpcompartir;
    public JButton btnguaradar,btnmostrar;
    public JTextField txtCantidadCuarto,txtNroHabitacion,txtPasaporte;
    
    public VentanaGrizzlyNuevo(){  
        this.setSize(500,700);
        this.setTitle("ventana de Registro de destino ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        componentes();
    }
    private void componentes() {
        JPanel General = new JPanel();
        this.getContentPane().add(General);
        General.setLayout(new FlowLayout(FlowLayout.CENTER));
        General.setSize(400, 600);
        
        GridLayout grid = new GridLayout(9,2,10,10);
        General.setLayout(grid);
        this.add(General);
         
//Primer panel - titulo
        lbltitulo = new JLabel("Registro de Destino ");
        lbltitulo.setFont(new Font("Colibri Light",Font.BOLD, 25));
        JPanel SubPanel1 = new JPanel();
        SubPanel1.add(lbltitulo, BorderLayout.PAGE_START);       
//Segundo Panel - componenetes 
        
        //Pasaporte (busqueda unica)
        lblPasaporte = new JLabel("Ingrese los digitos de su pasaporte");
        txtPasaporte = new JTextField(10);
        JPanel SubPanel0 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel0.add(lblPasaporte); 
        SubPanel0.add(txtPasaporte); 
        //Lugar (busqueda varia)
        lbltipo = new JLabel("Pais de destino : ");
        String[] tipo = {"Ecuador", "Colombia", "Panama"};
        cmbtipo = new JComboBox(tipo);
        JPanel SubPanel2 = new JPanel(new GridLayout(1,2,50,50));
        SubPanel2.add(lbltipo);
        SubPanel2.add(cmbtipo);
        //Tipo de hotel
        lblHotel = new JLabel("Tipo de Servicio del Hotel : ");
        rbuna = new JRadioButton("Hotel de una estrella");
        rbdos = new JRadioButton("Hotel de dos estrella");
        rbtres = new JRadioButton("Hotel de tres estrella"); 
        rbcuatro = new JRadioButton("Hotel de cuatro estrella"); 
        rbcinco = new JRadioButton("Hotel de cinco estrella"); 
        
        GpHotel = new ButtonGroup();
        GpHotel.add(rbuna);
        GpHotel.add(rbdos);
        GpHotel.add(rbtres);
        GpHotel.add(rbcuatro);
        GpHotel.add(rbcinco);
        
        JPanel SubPanel4 = new JPanel(new GridLayout(6,1,5,1));
        SubPanel4.add(lblHotel);
        SubPanel4.add(rbuna);
        SubPanel4.add(rbdos);
        SubPanel4.add(rbtres);
        SubPanel4.add(rbcuatro);
        SubPanel4.add(rbcinco);
        //Tipo de paquete
        lblpaquete = new JLabel("Tipo de paquete: ");
        checkop1 = new JCheckBox("Hospedaje");
        checkop2 = new JCheckBox("Guia turistico");
        checkop3 = new JCheckBox("Tours o Actividades");
        checkop4 = new JCheckBox("Traslado compartido o privado");
        JPanel SubPanel3 = new JPanel(new GridLayout(5,1,5,1));
        SubPanel3.add(lblpaquete);
        SubPanel3.add(checkop1);
        SubPanel3.add(checkop2);
        SubPanel3.add(checkop3);
        SubPanel3.add(checkop4);
        //cuartos compartidos o separados ? si si se activa el text, sino no se activa
        lblcompartir = new JLabel("Habran cuartos compartidos : ");
        rbsi = new JRadioButton("si");
        rbno = new JRadioButton("No");       
        Gpcompartir = new ButtonGroup();
        Gpcompartir.add(rbsi);
        Gpcompartir.add(rbno);
        JPanel SubPanel7 = new JPanel(new GridLayout(3,1,50,1));
        SubPanel7.add(lblcompartir);
        SubPanel7.add(rbno);
        SubPanel7.add(rbsi);
        
        JPanel SubPanel8 = new JPanel(new GridLayout(1,1,50,1));
        txtNroHabitacion = new JTextField();
        lblNroCuarto = new JLabel("Digite el numero de la habitacion:");
        SubPanel8.add(lblNroCuarto);
        SubPanel8.add(txtNroHabitacion);
        
        //Cantidad de cuartos
        lblcuarto = new JLabel("Cantidad de cuartos a reservar : ");
        txtCantidadCuarto = new JTextField(10);
        
        JPanel SubPanel5 = new JPanel();
        SubPanel5.setLayout(new GridLayout(1,2,50,50));        

        SubPanel5.add(lblcuarto);
        SubPanel5.add(txtCantidadCuarto);
        //Boton de guaradar y mostrar
        btnguaradar = new JButton("Guaradar");
        btnmostrar = new JButton("Regresar al Menu");
        JPanel SubPanel6 = new JPanel();
        SubPanel6.add(btnguaradar,BorderLayout.PAGE_END);
        SubPanel6.add(btnmostrar,BorderLayout.PAGE_END); 
        //Agrupacion de paneles 
        General.add(SubPanel1);
        General.add(SubPanel0);
        General.add(SubPanel2);
        General.add(SubPanel4);
        General.add(SubPanel3);
        General.add(SubPanel7);
        General.add(SubPanel8);
        General.add(SubPanel5);
        General.add(SubPanel6);      
     }
    public static void main(String[] args) {
        VentanaGrizzlyNuevo ventana = new VentanaGrizzlyNuevo();
        ControladorGrizzlyNuevo controlador = new ControladorGrizzlyNuevo(ventana);
        ventana.setVisible(true);
    } 
}
