package Home;

import Home.nodes.Node;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Node top;
    private Node last;
    private int count;

    private class Node {
        T value;
        Node next;
        int i;


        Node(T value) {

            this.value = value;
        }
    }

    @Override
    public T get(int index) {
        if (index < count) {
            int i = 0;
            Node current = top;

            while ((i < index)) {
                current = current.next;
                i++;
            }
            return current.value;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (top == null) {
            top = newNode;
            last = newNode;

        } else {
            last.next = newNode;
            last = newNode;

        }
        count++;
    }

    @Override
    public boolean contains(T element) {

        Node current = top;

        for (int i = 0; i < count; i++) {
            if (current.value.equals(element)) {
                return true;
            } else current = current.next;
        }
        return false;
    }

    @Override
    public void delete(int index) {
        int i = 0;
        Node current = top;


        while (i < index) {
            current = current.next;
            i++;
        }
        for (int a = index; a < count - 1; a++) {

            current.value = current.next.value;
            current.next.value = null;
            current = current.next;

        }

        count--;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean delete(T element) {
        Node current = top;
        for (int i = 0; i < count; i++) {
            if (current.value.equals(element)) {
                for (int a = i; a < count - 1; a++) {
                    current.value = current.next.value;
                    current.next.value = null;
                    current = current.next;
                }
                count--;
                return true;
            } else current = current.next;
        }
        return false;
    }
}
