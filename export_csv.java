import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class export_csv
{
    public void exportData(String datos) throws IOException {
        File compras = new File("out/compra.csv");
        FileWriter fw =  new FileWriter(compras, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw. write(datos);
        bw.newLine();
        bw.close();
        fw.close();


    }
}
