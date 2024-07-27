import java.util.Date;

public class Compra
{
    private Comprador Comprador;
    private Date Fecha;
    private Localidad Tipo;
    private int Precio;


    public void setComprador(Comprador comprador) {Comprador = comprador;}
    public Comprador getComprador() {return Comprador;}

    public void setFecha(Date fecha) {Fecha = fecha;}
    public Date getFecha() {return Fecha;}

    public void setTipo(Localidad tipo) {Tipo = tipo;}
    public Localidad getTipo() {return Tipo;}

    public void setPrecio(int precio) {Precio = precio;}
    public int getPrecio() {return getTipo().getPrecio()*getComprador().getCant_boletos();}
}
