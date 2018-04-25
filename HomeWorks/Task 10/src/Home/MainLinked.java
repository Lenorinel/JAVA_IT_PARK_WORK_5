package Home;

public class MainLinked {

    public static void main(String[] args) {
    List<String> list = new LinkedList<>();
    list.add("one");
    list.add("two");
    list.add("three");
    list.add("for");
//        System.out.println();
        System.out.println(list.size());
//        System.out.println(list.get(3));
//        list.delete(0);
        if(list.delete("two")) {
            System.out.println("Element deleted");
        } else System.err.println("Element not found");

        int i = 0;
        System.out.println(list.size());
    }
}
