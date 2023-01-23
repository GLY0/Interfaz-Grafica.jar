//GRIZZLY ALCIVAR
package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GrizzlyDAO {// DAO Data Access Objects
    public static final String RUTA = "src/Archivo/Destino.txt";
    public static ArrayList<GrizzlyDTO> listaDestino = new ArrayList();

    public boolean escribir(String datosDestino) {
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
            bw.write(datosDestino);
            bw.newLine();
            bw.flush();
   
        } catch (IOException io) {
            System.out.println("Error al escribir Destino en archivo " + io.getMessage());
            exito = false;
        } finally {
          GrizzlyUtilesArchivos.cerrarWriters(fw, bw);
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
            GrizzlyDTO per;
            listaDestino.clear();
            while (br.ready()) {
                String linea = br.readLine();
                String[] datos = linea.split(";");
                per = new GrizzlyDTO();
                per.setPasaporte(datos[0]);// [posicion]
                per.setLugar(datos[1]);
                per.setHotel(datos[2]);
                per.setHospedaje(Boolean.parseBoolean(datos[3]));
                per.setGuia(Boolean.parseBoolean(datos[4]));
                per.setTours(Boolean.parseBoolean(datos[5]));
                per.setTraslado(Boolean.parseBoolean(datos[6]));
                per.setCuartosCompartido(Boolean.parseBoolean(datos[8]));
                per.setCuartosCompartidos(Integer.parseInt(datos[9]));
                listaDestino.add(per);
            }
        } catch (IOException io) {
            System.out.println("Error al leer Destino de archivo" + io.getMessage());
            return null;
        } finally {          
            GrizzlyUtilesArchivos.cerrarReaderss(fr, br);
        }
        return listaDestino;
    }

    public ArrayList<GrizzlyDTO> buscarTodo() {
        this.leer();
        return listaDestino;
    }

    public ArrayList<GrizzlyDTO> buscarxLugar(String lugar) {
        this.leer();
        ArrayList<GrizzlyDTO> listaEncontrados = new ArrayList();
        for (GrizzlyDTO p : listaDestino) {
            if (p.getLugar().contains(lugar)) {
                listaEncontrados.add(p);
            }
        }
        return listaEncontrados;
    }

    public GrizzlyDTO buscarXPasaporte(String pasaporte) {
        this.leer();
        GrizzlyDTO DestinoEncontrado = null;
        for (GrizzlyDTO p : listaDestino) {
            if (p.getPasaporte().equals(pasaporte)) {
                DestinoEncontrado = p;
            }
        }
        return DestinoEncontrado;
    }
}

