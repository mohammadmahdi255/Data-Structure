import java.util.NoSuchElementException;

public class LinkedList {

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    private boolean isEmpty() {
        return first == null || last == null;
    }

    private Node first;
    private Node last;
    private int length = 0;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(int value) {
        first = new Node(value, first);
        last = isEmpty() ? first : last;
        length++;
    }

    public void addLast(int value) {
        var node = new Node(value, null);
        if(isEmpty())
            first = last = node;
        else
            last = last.next = node;
        length++;
    }

    public void removeFirst() {

        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)
            last = first = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        length--;
    }

    public void removeLast() {

        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)
            last = first = null;
        else {
            last = getNode(length - 2);
            last.next = null;
        }

        length--;
    }

    private Node getNode(int index) {
        if(index >= length)
            throw new ArrayIndexOutOfBoundsException();

        var current = first;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return length;
    }

    public int indexOf(int value) {
        int index = 0;
        var current = first;

        while (current != null && current.value != value) {
            current = current.next;
            index++;
        }

        return current == null ? -1 : index;
    }

    public int[] toArray() {
        int[] array = new int[length];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        Node previous = null;
        Node current = first;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {

        if (isEmpty())
            throw new IllegalStateException();

        var previous = first;
        var current = first;

        for (int i = 1; i < k; i++) {
            current = current.next;
            if (current == null) {
                throw new IllegalArgumentException();
            }
        }

        while (current != last) {
            previous = previous.next;
            current = current.next;
        }


        return previous.value;
    }

    public void printMiddle() {

        if(isEmpty())
            throw new IllegalStateException();

        var current = first;
        var middle = first;

        while (current != last && current.next != last) {
            middle = middle.next;
            current = current.next.next;
        }

        if (current == last)
            System.out.println(middle.value);
        else
            System.out.println(middle.value + ", " + middle.next.value);
    }

    public boolean hasLoop() {
        var fast = first;
        var slow = first;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {

        if(isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        var current = first;
        while (current.next != null) {
            sb.append(current.value).append(", ");
            current = current.next;
        }
        sb.append(current.value).append("]");
        return sb.toString();
    }
}
