package Home.nodes;

import Home.LinkedList;

public class MainNodes {

    public static void main(String[] args) {
        Node a = new Node("One");
        Node b = new Node("Two");
        Node c = new Node("Three");
        Node d = new Node("For");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        Node current = a;

        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

         int i =0;
    }
}
