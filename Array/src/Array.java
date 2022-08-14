public class Array {

    private int[] items;
    private int length = 0;

    public Array(int initialSize) {
        items = new int[initialSize];
    }

    public void insert(int item) {
        insertAt(item, length);
    }

    public void removeAt(int index) {
        if(index >= length || index < 0)
            throw new IllegalArgumentException();

        System.arraycopy(items, index+1, items, index, length - index - 1);
        length--;
    }

    public int indexOf(int item) {
        for(int i = 0; i < length; i++)
            if(items[i] == item)
                return i;
        return -1;
    }

    // Problem 1
    // O(n)
    public int max() {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < length ; i++)
            largest = Math.max(largest, items[i]);
        return largest;
    }

    // Problem 2
    public Array intersect(Array array) {
        Array intersectItems = new Array(length);
        for(int i = 0; i < length; i++) {
            if(array.indexOf(items[i]) != -1)
                intersectItems.insert(items[i]);
        }
        return intersectItems;
    }

    // Problem 3
    public void reverse() {
        int[] newItems = new int[items.length];
        for (int i = 0; i < length ; i++)
            newItems[length - i - 1] = items[i];
        items = newItems;
    }

    // Problem 4
    public void insertAt(int item, int index) {
        if(index > length || index < 0)
            throw new IllegalArgumentException();

        if(length == items.length) {
            int[] newItems = new int[2 * length];
            System.arraycopy(items, 0, newItems, 0, length);
            items = newItems;
        }

        System.arraycopy(items, index, items, index+1, length - index);
        items[index] = item;
        length++;
    }

    @Override
    public String toString() {
        String output = "[";
        for (int i = 0; i < length ; i++)
            output = output.concat(String.valueOf(items[i])).concat(", ");
        return output.substring(0, Math.max(output.length() - 2, 1)).concat("]");
    }

}
