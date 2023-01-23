//GRIZZLY ALCIVAR
package Vistas;
import Controlador.ControladorMenu;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
    public JLabel lbltitulo,lblimagen;
    public JMenuItem itemBuscarxCedula,itemBuscarxApellido,itemBuscarxpasporte,itemBuscarxlugar,itemDestino,itemNuevo;
    public JMenu subMenuBuscar,subMenuBuscar2,menuDestino,menuPersona;
    public Menu() {
        this.setTitle("Ventana principal");
        this.setSize(300,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Componentes();
        crearMenu();
    }
    private void Componentes(){
        JPanel general = new JPanel(new GridLayout(2,1,0,0));
        this.getContentPane().add(general);
        lbltitulo = new JLabel("Agencia de Turismo");
        lbltitulo.setFont(new Font("Colibri Light",Font.BOLD, 25));
        
        JPanel SubPanel1 = new JPanel();
        SubPanel1.add(lbltitulo, BorderLayout.PAGE_START); 
        
        lblimagen = new JLabel("", SwingConstants.CENTER);
        
        JPanel SubPanel2 = new JPanel();
        SubPanel2.add(lblimagen, BorderLayout.CENTER);
        ImageIcon icon = new ImageIcon("src/imagen/travel.png");
        lblimagen.setIcon(icon);
        
        general.add(SubPanel1);
        general.add(SubPanel2);
    }
    private void crearMenu() {
 
        JMenuBar barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);
        barraMenu.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        // menu personas
        menuPersona = new JMenu("Persona");
        barraMenu.add(menuPersona);

        itemNuevo = new JMenuItem("Registrar");
        subMenuBuscar2 = new JMenu("Buscar");
        menuPersona.add(itemNuevo);
        menuPersona.add(subMenuBuscar2);
        
        itemBuscarxCedula = new JMenuItem("Por Cedula");
        itemBuscarxApellido = new JMenuItem("Por Apellido");
        subMenuBuscar2.add(itemBuscarxCedula);
        subMenuBuscar2.add(itemBuscarxApellido);
        
        // menu Destino
        menuDestino = new JMenu("Destino");
        barraMenu.add(menuDestino);
        
        itemDestino = new JMenuItem("Registro");
        subMenuBuscar = new JMenu("Buscar");
        menuDestino.add(itemDestino);
        menuDestino.add(subMenuBuscar);

        itemBuscarxpasporte = new JMenuItem("Por Pasaporte");
        itemBuscarxlugar = new JMenuItem("Por Lugar");
        subMenuBuscar.add(itemBuscarxpasporte);
        subMenuBuscar.add(itemBuscarxlugar);
    }     
        public static void main(String[] args) {
        Menu ventana = new Menu();
        ControladorMenu controlador = new ControladorMenu(ventana);
        ventana.setVisible(true);
    } 
}
