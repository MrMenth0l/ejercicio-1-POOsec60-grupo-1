import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.io.File;


class Main {
    public static void main(String[] args) throws IOException {

        export_csv exportador = new export_csv();
        exportador.exportData("Nombre, Telefono, Cantidad de Tickets,Precio, Numero de ticket");
        var i = 0;
        Localidad localidad1 = new Localidad();
        localidad1.setPrecio(1);
        localidad1.setEspacio(100);
        Localidad localidad5 = new Localidad();
        localidad5.setPrecio(2);
        localidad5.setEspacio(100);
        Localidad localidad10 = new Localidad();
        localidad10.setPrecio(3);
        localidad10.setEspacio(100);

        int Num_compra = 1;
        String Num_ticket = "";

        Caja caja = new Caja();caja.setTotal(0); //Definir caja, como no hay ventas todavia, la caja esta vacia
        while(i < 1)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Que desea Realizar: \n1. Nueva Compra \n2. Revisar disponibilidad Total \n3. Revisar disponibilidad por seccion\n4. Revisar la caja \n5. Salir");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Comprador comprador = new Comprador();
                    System.out.println("Ingrese su nombre: ");
                    comprador.setNombre_Compra(sc.next());
                    System.out.println("Ingrese su Telefono: ");
                    comprador.setTelefono(sc.next());
                    System.out.println("Ingrese su presupuesto para boletos: ");
                    comprador.setPresupuesto(sc.nextInt());
                    Compra compra = new Compra();
                    System.out.println("Cuantos boletos desea comprar?");
                    comprador.setCant_boletos(sc.nextInt());
                    if (comprador.getCant_boletos() > 6){System.out.println("No puede comprar mas de 6 boletos"); return;}
                    compra.setComprador(comprador);
                    System.out.println("Que localidad: \n1. Localidad 1 (250$) \n2. Localidad 5 (575$) \n3. Localidad 10 (1720)");
                    switch (sc.nextInt()){
                        case 1:
                            if (localidad1.getEspacio()> comprador.getCant_boletos()){
                                compra.setTipo(localidad1);
                                localidad1.setEspacio(localidad1.getEspacio() - comprador.getCant_boletos());
                                if (compra.getPrecio() > comprador.getPresupuesto()){System.out.println("Estan muy caras bro :("); return;}
                            } else {System.out.println("No hay disponibilidad en esta seccion"); return;}
                            break;
                        case 2:
                            if (localidad5.getEspacio()> comprador.getCant_boletos()){
                                compra.setTipo(localidad5);
                                localidad5.setEspacio(localidad5.getEspacio() - comprador.getCant_boletos());
                                if (compra.getPrecio() > comprador.getPresupuesto()){System.out.println("Estan muy caras bro :("); return;}
                            } else {System.out.println("No hay disponibilidad en esta seccion"); return;}
                            break;
                        case 3:
                            if (localidad10.getEspacio()> comprador.getCant_boletos()){
                                compra.setTipo(localidad10);
                                localidad10.setEspacio(localidad10.getEspacio() - comprador.getCant_boletos());
                                if (compra.getPrecio() > comprador.getPresupuesto()){System.out.println("Estan muy caras bro :("); return;}
                            } else {System.out.println("No hay disponibilidad en esta seccion"); return;}
                            break;
                        default:
                            break;
                    }

                    compra.setFecha(Date.from(Instant.now()));

                    Num_compra += comprador.getCant_boletos()-1;

                    Num_ticket = String.valueOf(100 +compra.getFecha().getMonth() + 1)+ String.valueOf(compra.getFecha().getYear() + 1900) + String.valueOf(compra.getFecha().getDate()) + String.valueOf(Num_compra);
                    caja.setTotal(caja.getTotal() + compra.getPrecio());
                    caja.setCompra(compra);
                    System.out.println("Factura: "
                            + "\nNombre: " + comprador.getNombre_Compra()
                            + "\nTelefono:" + comprador.getTelefono()
                            + "\nCantidad de boletos: " + comprador.getCant_boletos()
                            + "\nPrecio: " + compra.getPrecio()
                            + "\nSu numero de compra: " + Num_compra
                            + "\nLa compra fue realizada el: " + compra.getFecha()
                            + "\nSu numero de ticket: " + Num_ticket);
                    exportador.exportData(comprador.getNombre_Compra() + "," + comprador.getTelefono() + "," + comprador.getCant_boletos() + "," + compra.getPrecio() + "," + Num_ticket);
                    break;
                case 2:
                    System.out.println("la disponibilidad total es: " + (localidad10.getEspacio()+localidad5.getEspacio()+ localidad1.getEspacio()) + " boletos en el estadio");
                    break;
                case 3:
                    System.out.println("La disponibilidad por seccion : "
                            + "\nSeccion 1: " + localidad1.getEspacio() + " boletos disponibles"
                            + "\nSeccion 5: " + localidad5.getEspacio() + " boletos disponibles"
                            + "\nSeccion 10: " + localidad10.getEspacio() + " boletos disponibles");
                    break;
                case 4:
                    System.out.println("En la caja hay un total de: " + caja.getTotal());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;

            }
        }

    }
}
