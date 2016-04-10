package keyboard_warrior.util;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Reads text files..
 */
public class TextReader {

    public static String readTextFile(String fileName) {
        InputStream inputStream = TextReader.class.getResourceAsStream(fileName);

        if (inputStream == null) {
            //TODO: We should print an error message here, but its probably worth creating a Debug class that handles that
            return "";
        }

        Scanner scanner =  new Scanner(inputStream);
        String fileString = "";

        while (scanner.hasNextLine()){
            fileString += scanner.nextLine() + "\n";
        }

        scanner.close();

        return fileString;
    }
}