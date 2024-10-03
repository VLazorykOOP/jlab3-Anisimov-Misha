// Абстрактний базовий клас Figure
abstract class Figure {
    public abstract double area();       // Абстрактний метод для обчислення площі
    public abstract double perimeter();   // Абстрактний метод для обчислення периметру

    @Override
    public abstract String toString();    // Перевантаження toString
}
// Похідний клас Rectangle
class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
    @Override
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;
        return width == other.width && height == other.height;
    }
}
// Похідний клас Circle
class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return radius == other.radius;
    }
}
// Похідний клас Trapezium
class Trapezium extends Figure {
    private double a; // Довжина однієї основи
    private double b; // Довжина другої основи
    private double h; // Висота
    public Trapezium(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }
    @Override
    public double area() {
        return (a + b) / 2 * h;
    }
    @Override
    public double perimeter() {
        // Для спрощення, розглянемо трапецію як рівнобічну, за потреби можна уточнити
        double side = Math.sqrt(h * h + ((b - a) / 2) * ((b - a) / 2));
        return a + b + 2 * side;
    }
    @Override
    public String toString() {
        return "Trapezium: a = " + a + ", b = " + b + ", height = " + h;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Trapezium)) return false;
        Trapezium other = (Trapezium) obj;
        return a == other.a && b == other.b && h == other.h;
    }
}
// Основний клас програми
public class Main2 {
    public static void main(String[] args) {
        // Масив об'єктів типу Figure
        Figure[] figures = new Figure[3];
        figures[0] = new Rectangle(5, 3);
        figures[1] = new Circle(4);
        figures[2] = new Trapezium(4, 6, 5);
        // Вивід інформації про фігури та обчислення їх площі та периметру
        for (Figure figure : figures) {
            System.out.println(figure);
            System.out.println("Area: " + figure.area());
            System.out.println("Perimeter: " + figure.perimeter());
            System.out.println();
        }
    }
}