package keyboard_warrior.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by joshua on 07/04/2016.
 */
public class TextReader {

    public static String readTextFile(String aFileName) {
        Path path = Paths.get(aFileName);
        String fileString = "";
        try (Scanner scanner =  new Scanner(path)){
            while (scanner.hasNextLine()){
                //process each line in some way
                fileString += scanner.nextLine() + "\n";
            }
            return fileString;
        }
        catch (IOException e) {
            System.out.println("TextReader.readTextFile: Failed to scan file at - " + path);
            e.printStackTrace();
            return "";
        }
    }

//    public static void readLargerTextFileAlternate(String aFileName) throws IOException {
//        Path path = Paths.get(aFileName);
//        try (BufferedReader reader = Files.newBufferedReader(path)){
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                //process each line in some way
//               // log(line);
//            }
//        }
//    }
}
