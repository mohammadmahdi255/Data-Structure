import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(60);
        list.addLast(70);
        list.addLast(40);
        list.addFirst(0);
        list.addFirst(-10);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        System.out.println(list.indexOf(30));
        System.out.println(list.contains(10));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(Arrays.toString(list.toArray()));

        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(list.getKthFromTheEnd(-1));

        list.printMiddle();

        System.out.println(list.hasLoop());
    }
}
