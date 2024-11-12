import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;


class EnumerationIterator<T> implements Iterator<T> {
    private final Enumeration<T> enumeration;

    public EnumerationIterator(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        if (!enumeration.hasMoreElements()) {
            throw new NoSuchElementException("No more elements");
        }
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

public class Enumaration {
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        Enumeration<String> enumeration = vector.elements();

        Iterator<String> iterator = new EnumerationIterator<>(enumeration);

        System.out.println("Iterating through elements using EnumerationIterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
