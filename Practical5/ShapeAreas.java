abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private double length, width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    double area() { return length * width; }
}

class Triangle extends Shape {
    private double base, height;
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    double area() { return 0.5 * base * height; }
}

public class ShapeAreas {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Triangle(6, 4)};
        double total = 0, largest = 0;

        for (Shape shape : shapes) {
            double area = shape.area();
            System.out.println(shape.getClass().getSimpleName() + ": " + area);
            total += area;
            if (area > largest) largest = area;
        }
        System.out.println("Total area: " + total);
        System.out.println("Largest area: " + largest);
    }
}
