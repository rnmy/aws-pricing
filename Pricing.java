import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
//import com.opencsv.CSVReader;

public class Pricing {
    public static void main(String args[]) throws Exception {
//        Scanner sc = new Scanner(new File("data.csv"));
//        sc.useDelimiter(",");
//        while (sc.hasNext()) {
//            System.out.print(sc.next());
//        }
//        sc.close();

        String[] BASE_FOUR = {"bralette", "tank", "cami", "tube", "cropped"};
        String[] BASE_SIX = {"midi skirt", "culottes"};
        String[] BASE_EIGHT = {"maxi dress", "long dress"};

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            line = br.readLine();

            FileWriter fw = new FileWriter("prices.csv");
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
            fw.append("PRICE");
            fw.append("\n");

            while ((line = br.readLine()) != null) {
                int price = 0;
                String[] item = line.split(splitBy);

                // check base price
                if (Arrays.asList(BASE_FOUR).contains(item[1])) {
                    price += 4;
                } else if (Arrays.asList(BASE_SIX).contains(item[1])) {
                    price += 6;
                } else if (Arrays.asList(BASE_EIGHT).contains(item[1])) {
                    price += 8;
                }

                // check for defects
                for (int i = 2; i < 7; i++) {
                    if (Boolean.parseBoolean(item[i])) {
                        price -= 1;
                    }
                }

                // check if branded
                if (Boolean.parseBoolean(item[7])) {
                    price += 1;
                }
                System.out.println(price);

                List<String> rowData = new ArrayList<String>();
                for(int j = 0; j < item.length; j++) {
                    rowData.add(item[j]);
                }
                String p = Integer.toString(price);
                rowData.add(p);
                fw.append(String.join(",", rowData));
                fw.append("\n");

            }
            fw.flush();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Read existing file
//        CSVReader reader = new CSVReader(new FileReader(new File("data.csv")), ',');
//        List<String[]> csvBody = reader.readAll();
//        // get CSV row column and replace with by using row and column
//        for(int i=0; i<csvBody.size(); i++){
//            String[] strArray = csvBody.get(i);
//            for(int j=0; j<strArray.length; j++){
//                if(strArray[j].equalsIgnoreCase("Update_date")){ //String to be replaced
//                    csvBody.get(i)[j] = "Updated_date"; //Target replacement
//                }
//            }
//        }
//        reader.close();
//
//        // Write to CSV file which is open
//        CSVWriter writer = new CSVWriter(new FileWriter(new File("data.csv")), ',');
//        writer.writeAll(csvBody);
//        writer.flush();
//        writer.close();
    }
}