import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyingPriceCalculator {

    public static int calculateBuyingPriceForAnItem(String[] item) {
        int price = 0;
        String[] BASE_FOUR = {"bralette", "tank", "cami", "tube", "cropped"};
        String[] BASE_SIX = {"midi skirt", "culottes"};
        String[] BASE_EIGHT = {"maxi dress", "long dress"};

        // check base price
        if (Arrays.asList(BASE_FOUR).contains(item[1])) {
            price += 4;
        } else if (Arrays.asList(BASE_SIX).contains(item[1])) {
            price += 6;
        } else if (Arrays.asList(BASE_EIGHT).contains(item[1])) {
            price += 8;
        }

        // check for defects
        for (int i = 2; i < 8; i++) {
            if (Boolean.parseBoolean(item[i])) {
                price -= 1;
            }
        }

        // check if branded
        if (Boolean.parseBoolean(item[7])) {
            price += 1;
        }

        // check if must be recycled (no price)
        if (Boolean.parseBoolean(item[8])) {
            price = 0;
        }
        System.out.println(price);

        return price;
    }

    private static List<String> convertAnItemToRowData(String[] item) {
        int price = calculateBuyingPriceForAnItem(item);
        List<String> rowData = new ArrayList<>(Arrays.asList(item));
        String p = Integer.toString(price);
        rowData.add(p);
        return rowData;
    }


    public static void writingBuyingPriceToFile() throws IOException {
        String line = "";
        String splitBy = ",";

        BufferedReader br = FileReadWrite.readFile("data.csv");
        FileWriter fw = FileReadWrite.writeFile("selling_prices.csv");

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
