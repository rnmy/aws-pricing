//import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Pricing {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BuyingPriceCalculator.writingBuyingPriceToFile();
        SellingPriceCalculator.writingSellingPriceToFile();
    }
}