package Home.util;

public class idGeneratorInMemory implements IdGenerator {
    private static idGeneratorInMemory instance;
    private int currentId;

    static {
        instance = new idGeneratorInMemory();
    }

    private idGeneratorInMemory() {
        this.currentId = 0;
    }
     public static IdGenerator generator(){
        return instance;
     }

    @Override
    public int getNewId() {
        int lastId = currentId;
        currentId++;
        return lastId;
    }
}
