public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(4);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        numbers.insert(70);
        numbers.insert(80);

        numbers.removeAt(0);

        Array numbers2 = new Array(4);
        numbers2.insert(120);
        numbers2.insert(20);
        numbers2.insert(30);
        numbers2.insert(500);
        numbers2.insert(60);
        numbers2.insert(80);
        numbers2.insert(90);

        System.out.println(numbers.indexOf(80));
        System.out.println(numbers.max());
        System.out.println(numbers.intersect(numbers2).toString());
        numbers.reverse();
        numbers.insertAt(100, 0);
        System.out.println(numbers.toString());
    }
}
