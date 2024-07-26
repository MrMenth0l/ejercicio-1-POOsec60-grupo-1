import java.util.Date;

public class Compra
{
    private String Nombre_Compra;
    private String Telefono;
    private Date Fecha;
    private Localidad Tipo;
    private int Cant_boletos;


    public void setNombre_Compra(String nombre_Compra) {Nombre_Compra = nombre_Compra;}
    public String getNombre_Compra() {return Nombre_Compra;}

    public void setTelefono(String telefono) {Telefono = telefono;}
    public String getTelefono() {return Telefono;}

    public void setFecha(Date fecha) {Fecha = fecha;}
    public Date getFecha() {return Fecha;}

    public void setTipo(Localidad tipo) {Tipo = tipo;}
    public Localidad getTipo() {return Tipo;}

    public void setCant_boletos(int cant_boletos) {Cant_boletos = cant_boletos;}
    public int getCant_boletos() {return Cant_boletos;}
}
