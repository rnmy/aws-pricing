import java.io.*;

public class FileReadWrite {

    public static BufferedReader readFile(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    public static FileWriter writeFile(String fileName) throws IOException {
        return new FileWriter(fileName);
    }

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
