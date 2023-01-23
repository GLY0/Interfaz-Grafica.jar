//GRIZZLY ALCIVAR
package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GrizzlyUtilesArchivos {
     public static  void cerrarWriters(FileWriter fw, BufferedWriter bw){
           try {
                if (fw != null) {
                    fw.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException io) {
                System.out.println(" cerrarWriters " + io.getMessage());

            }
      }
     public static  void cerrarReaderss(FileReader fr, BufferedReader br){
     
       try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException io) {
                System.out.println(" cerrarReaders " + io.getMessage());

            }
     }
}
