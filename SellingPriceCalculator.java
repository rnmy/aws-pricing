import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellingPriceCalculator {
    private static float calculateSellingPrice(int buyingPrice) {
        return (float) (buyingPrice * 1.5);
    }

    private static List<String> convertAnItemToRowData(String[] item) {
        float price = calculateSellingPrice(BuyingPriceCalculator.calculateBuyingPriceForAnItem(item));
        List<String> rowData = new ArrayList<>(Arrays.asList(item));
        String p = Float.toString(price);
        rowData.add(p);
        return rowData;
    }

    public static void writingSellingPriceToFile() throws IOException {
        String line = "";
        String splitBy = ",";

        BufferedReader br = FileReadWrite.readFile("data.csv");
        FileWriter fw = FileReadWrite.writeFile("buying_prices.csv");

        FileReadWrite.appendFileWriter(fw);

        while ((line = br.readLine()) != null) {
            String[] item = line.split(splitBy);
            List<String> rowData = convertAnItemToRowData(item);
            fw.append(String.join(",", rowData));
            fw.append("\n");
        }
        fw.flush();
        fw.close();
    }
}
