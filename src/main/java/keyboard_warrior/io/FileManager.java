package keyboard_warrior.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import keyboard_warrior.world.Story;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Manages game files
 */
public class FileManager {

    private static Gson jsonSerializer;

    public static void saveStory(Story story, String fileName) throws IOException
    {
        saveToJson(story, fileName);
    }

    public static Story loadStory(String fileName) throws IOException
    {
        return loadFromJson(fileName, Story.class);
    }

    public static <T> T loadFromJson(String fileName, Class<T> tClass) throws IOException
    {
        String json = readFileAsString(getSaveDirPath(), fileName, Charset.defaultCharset());
        return getJsonSerializer().fromJson(json, tClass);
    }

    public static void saveToJson(Object object, String fileName) throws IOException
    {
        String json = getJsonSerializer().toJson(object);
        writeStringToFile(getSaveDirPath(), fileName, json);
    }

    private static Gson getJsonSerializer() //we only need to create one jsonSerializer object
    {
        if (jsonSerializer == null)
            jsonSerializer = new GsonBuilder().setPrettyPrinting().create(); //this will print out formatted json
            //jsonSerializer = new Gson(); //more efficient but it's all good

        return jsonSerializer;
    }

    private static Path getSaveDirPath()
    {
        String home = System.getProperty("user.home");
        return Paths.get(home, "keyboard-warrior", "save-data");
    }

    private static void writeStringToFile(Path dirPath, String fileName, String stringToWrite) throws IOException
    {
        Files.createDirectories(dirPath);
        Path filePath = dirPath.resolve(fileName);
        Files.write(filePath, stringToWrite.getBytes());
    }

    private static String readFileAsString(Path dirPath, String fileName, Charset encoding) throws IOException
    {
        Path filePath = dirPath.resolve(fileName);
        byte[] encoded = Files.readAllBytes(filePath);
        return new String(encoded, encoding);
    }
}
