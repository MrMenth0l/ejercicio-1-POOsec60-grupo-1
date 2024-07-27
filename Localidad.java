public class Localidad
{
    private int Espacio;
    private int Precio;


    public void setEspacio(int espacio) {
        Espacio = espacio;}
    public int getEspacio() {
        return Espacio;}

    public void setPrecio(int precio) {
        switch (precio){
            case 1:
                Precio = 250;
                break;
            case 2:
                Precio = 575;
                break;
            case 3:
                Precio = 1720;
                break;
            default:
                break;
        }}
    public int getPrecio() {
        return Precio;}
}
