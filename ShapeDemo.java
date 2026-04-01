abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public void displayInfo() {
        System.out.println(
                getClass().getSimpleName() +
                        " Color: " + color +
                        " Area: " + getArea() +
                        " Perimeter: " + getPerimeter()
        );
    }
}
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
public class ShapeDemo {
    public static Shape findLargest(Shape[] shapes) {
        Shape largest = shapes[0];

        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];

        shapes[0] = new Circle("Red", 3);
        shapes[1] = new Rectangle("Blue", 4, 5);
        shapes[2] = new Triangle("Green", 3, 4, 5);
        shapes[3] = new Circle("Yellow", 2.5);
        shapes[4] = new Rectangle("Black", 6, 2);
        shapes[5] = new Triangle("White", 5, 5, 6);

        double totalArea = 0;

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].displayInfo();
            totalArea = totalArea + shapes[i].getArea();
        }

        Shape largest = findLargest(shapes);

        System.out.println("Largest area shape:");
        largest.displayInfo();

        System.out.println("Total combined area: " + totalArea);
    }
}
