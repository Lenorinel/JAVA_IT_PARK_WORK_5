package Home.util;

import java.io.*;
import java.util.Scanner;

public class idGenerationFileBased implements IdGenerator {
    private static idGenerationFileBased instance;
    private int currentId;

    static {
        instance = new idGenerationFileBased();
    }

    private idGenerationFileBased() {
        try {
            Scanner scanner = new Scanner(new File("user_id_value.txt"));
            currentId = scanner.nextInt();
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public int getNewId() {
    try {
    Writer writer = new FileWriter("user_id_value.txt");
    currentId++;
    writer.write(String.valueOf(currentId));
    writer.close();
    return currentId;
    } catch(IOException ex) {
        throw new IllegalStateException(ex);
    }
    }

    public static  IdGenerator generator() {
        return instance;
    }
}
