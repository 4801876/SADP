
interface Car {
    void assemble();
}

class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    @Override
    public void assemble() {
        this.decoratedCar.assemble();
    }
}

class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of a Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of a Luxury Car.");
    }
}

public class LuxuryCar_ {
    public static void main(String[] args) {
        System.out.println("Basic Car:");
        Car basicCar = new BasicCar();
        basicCar.assemble();
        System.out.println("\n");

        System.out.println("Sports Car:");
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n");

        System.out.println("Luxury Car:");
        Car luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();
        System.out.println("\n");

        System.out.println("Sports Luxury Car:");
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
        System.out.println();
    }
}
