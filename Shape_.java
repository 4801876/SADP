interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a regular Rectangle.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a regular Square.");
    }
}

class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rounded Rectangle.");
    }
}

class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rounded Square.");
    }
}

interface AbstractFactory {
    Shape createRectangle();

    Shape createSquare();
}

class RegularShapeFactory implements AbstractFactory {
    @Override
    public Shape createRectangle() {
        return new Rectangle();
    }

    @Override
    public Shape createSquare() {
        return new Square();
    }
}

class RoundedShapeFactory implements AbstractFactory {
    @Override
    public Shape createRectangle() {
        return new RoundedRectangle();
    }

    @Override
    public Shape createSquare() {
        return new RoundedSquare();
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new RegularShapeFactory();
        }
    }
}

public class Shape_ {
    public static void main(String[] args) {
        AbstractFactory regularFactory = FactoryProducer.getFactory(false);
        Shape rectangle = regularFactory.createRectangle();
        Shape square = regularFactory.createSquare();

        System.out.println("Regular Shapes:");
        rectangle.draw();
        square.draw();

        AbstractFactory roundedFactory = FactoryProducer.getFactory(true);
        Shape roundedRectangle = roundedFactory.createRectangle();
        Shape roundedSquare = roundedFactory.createSquare();

        System.out.println("\nRounded Shapes:");
        roundedRectangle.draw();
        roundedSquare.draw();
    }
}
