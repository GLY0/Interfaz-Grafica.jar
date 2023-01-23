//GRIZZLY ALCIVAR
package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonasDAO {
    public static final String RUTA = "src/Archivo/personas.txt";
    public static ArrayList<PersonasDTO> listaPersonas = new ArrayList();

    public boolean escribir(String datosPersona) {
        boolean exito = true;
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            file = new File(RUTA);
            if (!file.exists()) {
              file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(datosPersona);
            bw.newLine();
            bw.flush();

          
        } catch (IOException io) {
            System.out.println("Error al escribir persona en archivo " + io.getMessage());
            exito = false;
        } finally {  
          PersonaUtilesArchivos.cerrarWriters(fw, bw);
        }
        return exito;
    }

    public ArrayList leer() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(RUTA);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            PersonasDTO per;
            listaPersonas.clear();
            while (br.ready()) {
                String linea = br.readLine();
                String[] datos = linea.split(";");
                
                per = new PersonasDTO();
                per.setCedula(datos[0]);
                per.setNombre(datos[1]);
                per.setApellidos(datos[2]);
                per.setPago(datos[3]);
                per.setMotivo(datos[4]);
                per.setPoliomielitis(Boolean.parseBoolean(datos[5]));
                per.setFiebre(Boolean.parseBoolean(datos[6]));
                per.setInfluenza(Boolean.parseBoolean(datos[7]));
                per.setEdad(Integer.parseInt(datos[8]));
                listaPersonas.add(per);// agregando en la lista de personas
            }

        } catch (IOException io) {
            System.out.println("Error al leer personas de archivo" + io.getMessage());
            return null;
        } finally {         
            PersonaUtilesArchivos.cerrarReaderss(fr, br);
        }
        return listaPersonas;
    }

    public ArrayList<PersonasDTO> buscarTodo() {
        this.leer();
        return listaPersonas;

    }

    public ArrayList<PersonasDTO> buscarxNombre(String nombre) {
        this.leer();
        ArrayList<PersonasDTO> listaEncontrados = new ArrayList();
        for (PersonasDTO p : listaPersonas) {
            if (p.getNombre().contains(nombre)) {// condicion de busqueda
                listaEncontrados.add(p);
            }
        }
        return listaEncontrados;
    }

    public PersonasDTO buscarXCedula(String cedula) {
        this.leer();
        PersonasDTO personaEncontrada = null;
        for (PersonasDTO p : listaPersonas) {
            if (p.getCedula().equals(cedula)) {
                personaEncontrada = p;
            }
        }
        return personaEncontrada;
    }

}
