//GRIZZLY ALCIVAR
package Modelos;

public class PersonasDTO {
    private String cedula, nombre, Apellidos, pago, Motivo;
    private boolean Poliomielitis,Fiebre,Influenza;
    private int edad;
    
    public PersonasDTO() {
    }
    public PersonasDTO(String cedula, String nombre, String Apellidos, String pago, String Motivo, boolean Poliomielitis, boolean Fiebre, boolean Influenza, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.pago = pago;
        this.Motivo = Motivo;
        this.Poliomielitis = Poliomielitis;
        this.Fiebre = Fiebre;
        this.Influenza = Influenza;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getPago() {
        return pago;
    }

    public String getMotivo() {
        return Motivo;
    }

    public boolean isPoliomielitis() {
        return Poliomielitis;
    }

    public boolean isFiebre() {
        return Fiebre;
    }

    public boolean isInfluenza() {
        return Influenza;
    }

    public int getEdad() {
        return edad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public void setPoliomielitis(boolean Poliomielitis) {
        this.Poliomielitis = Poliomielitis;
    }

    public void setFiebre(boolean Fiebre) {
        this.Fiebre = Fiebre;
    }

    public void setInfluenza(boolean Influenza) {
        this.Influenza = Influenza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "PersonasDTO{" + "cedula=" + cedula + ", nombre=" + nombre + ", Apellidos=" 
                + Apellidos + ", pago=" + pago + ", Motivo=" + Motivo + ", Poliomielitis=" 
                + Poliomielitis + ", Fiebre=" + Fiebre + ", Influenza=" + Influenza + ", edad=" + edad;
    }
    public String toStringParaArchivo() {
        return  cedula+ ";" + nombre+ ";" + Apellidos+ ";" + pago+ ";" + Motivo+ ";" + Poliomielitis+ ";" 
                + Fiebre+ ";" + Influenza+ ";" + edad;
    }
    
}
