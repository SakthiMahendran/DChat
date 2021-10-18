package DChatUtilities;

import java.io.*;
import java.util.Scanner;

public class DataBase {

    public static final String keyFileName = "KeyandSalt";

    public static String[] getMatching(String str) throws FileNotFoundException {
        var fileScanner = new Scanner(new File(keyFileName));

        while (fileScanner.hasNextLine()) {
            var line = fileScanner.nextLine();

            if(line.contains(str)) {
                return line.split(":");
            }
        }
        return new String[0];
    }

    public static String loadKey(String dNumber) throws FileNotFoundException {
        var keyFile = new File(keyFileName);
        var key = "";
        var fileScanner = new Scanner(keyFile);

        while (fileScanner.hasNextLine()) {
            var content = fileScanner.nextLine();

            if (content.startsWith(dNumber))
                key += content.strip().split(":")[1];
        }
        return key;
    }

    public static String loadSalt(String dNumber) throws FileNotFoundException {
        var keyFile = new File(keyFileName);
        var salt = "";
        var fileScanner = new Scanner(keyFile);

        while (fileScanner.hasNextLine()) {
            var content = fileScanner.nextLine();

            if (content.startsWith(dNumber))
                salt += content.strip().split(":")[2];
        }
        return salt;
    }

    public static void register(String dNumber, String key, String salt) throws IOException {
        var keyFile = new File(keyFileName);

        if((!keyFile.exists()) || (!keyFile.isFile()))
            keyFile.createNewFile();

        var fileWriter = new PrintWriter(keyFile);

        fileWriter.println((dNumber+":"+key+":"+salt).strip());
        fileWriter.close();
    }

    public static boolean isExist(String content) throws FileNotFoundException {
        var fileScanner = new Scanner(new File(keyFileName));

        while (fileScanner.hasNextLine()) {
            if(fileScanner.nextLine().startsWith(content))
                return true;
        }

        return false;
    }
}