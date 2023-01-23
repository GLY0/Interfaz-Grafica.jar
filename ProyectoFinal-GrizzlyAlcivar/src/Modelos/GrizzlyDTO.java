//GRIZZLY ALCIVAR
package Modelos;

public class GrizzlyDTO {
    private String Pasaporte, lugar, hotel;
    private boolean CuartosCompartido,Hospedaje,Guia,Tours,Traslado;
    private int NroCuartos,NroCuarto;

    public GrizzlyDTO() {
    }
    public GrizzlyDTO(String Pasaporte, String lugar, String hotel, int CuartosCompartidos, boolean CuartosCompartido, boolean Hospedaje, boolean Guia, boolean Tours, boolean Traslado, int cuartos) {
        this.Pasaporte = Pasaporte;
        this.lugar = lugar;
        this.hotel = hotel;
        this.NroCuarto = CuartosCompartidos;
        this.CuartosCompartido = CuartosCompartido;
        this.Hospedaje = Hospedaje;
        this.Guia = Guia;
        this.Tours = Tours;
        this.Traslado = Traslado;
        this.NroCuartos = cuartos;
    }

    public String getPasaporte() {
        return Pasaporte;
    }

    public String getLugar() {
        return lugar;
    }

    public String getHotel() {
        return hotel;
    }

    public int getCuartosCompartidos() {
        return NroCuarto;
    }

    public boolean isCuartosCompartido() {
        return CuartosCompartido;
    }

    public boolean isHospedaje() {
        return Hospedaje;
    }

    public boolean isGuia() {
        return Guia;
    }

    public boolean isTours() {
        return Tours;
    }

    public boolean isTraslado() {
        return Traslado;
    }

    public int getCuartos() {
        return NroCuartos;
    }

    public void setPasaporte(String Pasaporte) {
        this.Pasaporte = Pasaporte;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setCuartosCompartidos(int CuartosCompartidos) {
        this.NroCuarto = CuartosCompartidos;
    }

    public void setCuartosCompartido(boolean CuartosCompartido) {
        this.CuartosCompartido = CuartosCompartido;
    }

    public void setHospedaje(boolean Hospedaje) {
        this.Hospedaje = Hospedaje;
    }

    public void setGuia(boolean Guia) {
        this.Guia = Guia;
    }

    public void setTours(boolean Tours) {
        this.Tours = Tours;
    }

    public void setTraslado(boolean Traslado) {
        this.Traslado = Traslado;
    }

    public void setCuartos(int cuartos) {
        this.NroCuartos = cuartos;
    }

    @Override
    public String toString() {
        return "Destino" + "\n Pasaporte=" + Pasaporte + "\n lugar=" + lugar 
                + "\n hotel=" + hotel + "\n CuartosCompartidos=" + NroCuarto 
                + "\n CuartosCompartido=" + CuartosCompartido + "\n Hospedaje=" + Hospedaje 
                + "\n Guia=" + Guia + "\n Tours=" + Tours + "\n Traslado=" + Traslado + "\n cuartos=" + NroCuartos ;
    }
    public String toStringParaArchivo() {
        return  Pasaporte +";"+lugar+";"+ hotel +";"+Hospedaje 
               +";"+Guia+";"+Tours+";"+Traslado+";"+CuartosCompartido+";"+NroCuarto+";"+NroCuartos;
    }
}
