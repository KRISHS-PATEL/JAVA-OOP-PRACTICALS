class Box<T> {
    private T value;
    void set(T value) { this.value = value; }
    T get() { return value; }
}

class Pair<A, B> {
    private A first;
    private B second;
    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    A getFirst() { return first; }
    B getSecond() { return second; }
}

public class GenericContainers {
    static <T> T first(T[] values) {
        return values[0];
    }

    public static void main(String[] args) {
        Box<String> textBox = new Box<>();
        textBox.set("Hello");
        Box<Integer> numberBox = new Box<>();
        numberBox.set(25);
        Pair<String, Integer> pair = new Pair<>("Age", 20);
        String[] names = {"Asha", "Ravi"};

        System.out.println(textBox.get());
        System.out.println(numberBox.get());
        System.out.println(pair.getFirst() + ": " + pair.getSecond());
        System.out.println(first(names));
    }
}
