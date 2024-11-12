import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int number);
}

class NumberSubject {
    private List<Observer> observers = new ArrayList<>();
    private int number;

    public void setNumber(int number) {
        this.number = number;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(number);
        }
    }
}

class HexadecimalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
    }
}

class OctalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class BinaryObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

public class Number_ {
    public static void main(String[] args) {
        NumberSubject subject = new NumberSubject();


        subject.addObserver(new HexadecimalObserver());
        subject.addObserver(new OctalObserver());
        subject.addObserver(new BinaryObserver());

        System.out.println("Converting the decimal number 15:");
        subject.setNumber(15);

        System.out.println("\nConverting the decimal number 42:");
        subject.setNumber(42);

        System.out.println("\nConverting the decimal number 100:");
        subject.setNumber(100);
    }
}
