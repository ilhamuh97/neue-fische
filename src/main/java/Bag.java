import java.util.Arrays;
import java.util.Objects;

public class Bag {
    private int[] items;
    private int size;

    public Bag() {
        this.items = new int[0];
        this.size =0;
    }

    public Bag(int[] test) {
        this.items = test;
        this.size = test.length;
    }

    private int[] transferValues(int[] from, int[] to) {
        int smallerSize = from.length;
        if(smallerSize>to.length) {
            smallerSize = to.length;
        }

        for (int i = 0; i < smallerSize; i++) {
            to[i] = items[i];
        }

        return to;
    }

    private int[] transferValues(int[] from, int[] to, int skipIndex) {
        boolean skipped = false;
        for (int i = 0; i < from.length; i++) {
            if(i == skipIndex){
                skipped = true;
                continue;
            }

            if(skipped) {
                to[i-1] = items[i];
            } else {
                to[i] = items[i];
            }
        }

        return to;
    }

    public void add(int item) {
        if(size == items.length) {
            int[] newItems = new int[items.length + 1];
            transferValues(items, newItems);
            this.items = newItems;
        }

        items[size] = item;
        size++;
    }

    public int get(int index) {
        return items[index];
    }

    public void removeLast() {
        int[] newItems = new int[items.length-1];
        this.items = transferValues(items, newItems);
        this.size--;
    }

    public void remove(int index) {
        int[] newItems = new int[items.length-1];
        this.items = transferValues(items, newItems, index);
        this.size--;
    }


    public int size() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return size == bag.size && Objects.deepEquals(items, bag.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(items), size);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }
}
