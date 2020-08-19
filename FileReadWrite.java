import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadWrite {

    public static BufferedReader readFile(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    public static FileWriter writeFile(String fileName) throws IOException {
        return new FileWriter(fileName);
    }

    /*private static List<String> convertAnItemToRowData(String[] item, float price) {
        // int price = calculateBuyingPriceForAnItem(item);
        List<String> rowData = new ArrayList<>(Arrays.asList(item));
        String p = Float.toString(price);
        rowData.add(p);
        return rowData;
    }

    public static void writeCalculatedPricesToFile(BufferedReader br, FileWriter fw) throws IOException {
        String line = "";
        String splitBy = ",";

        BufferedReader br = FileReadWrite.readFile("data.csv");
        FileWriter fw = FileReadWrite.writeFile("selling_prices.csv");

        appendFileWriter(fw);

        while ((line = br.readLine()) != null) {
            String[] item = line.split(splitBy);
            List<String> rowData = convertAnItemToRowData(item, );
            if (!rowData.get(0).equals("ID")) {
                fw.append(String.join(",", rowData));
                fw.append("\n");
            }

        }
        fw.flush();
        fw.close();
    }*/
    public static void appendFileWriter(FileWriter fw) throws IOException {
        fw.append("ID");
        fw.append(",");
        fw.append("TYPE");
        fw.append(",");
        fw.append("MINOR STAIN");
        fw.append(",");
        fw.append("LOOSE THREAD");
        fw.append(",");
        fw.append("LINT");
        fw.append(",");
        fw.append("MAJOR FURRING");
        fw.append(",");
        fw.append("SMALL HOLE");
        fw.append(",");
        fw.append("BRANDED");
        fw.append(",");
        fw.append("HOLES/EXCESSIVE FURRING/STRETCHED/NUS LOGO");
        fw.append(",");
        fw.append("PRICE");
        fw.append("\n");
    }
}
