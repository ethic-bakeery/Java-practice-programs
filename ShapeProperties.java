import java.util.Scanner;

public class ShapeProperties {
    // Function to calculate the area and perimeter of a circle
    static void circleProperties(double radius, double[] result) {
        final double pi = 3.14159;
        result[0] = pi * radius * radius; // Area
        result[1] = 2 * pi * radius;      // Perimeter
    }

    // Function to calculate the area and perimeter of a rectangle
    static void rectangleProperties(double length, double width, double[] result) {
        result[0] = length * width;            // Area
        result[1] = 2 * (length + width);      // Perimeter
    }

    // Function to calculate the area and perimeter of a triangle
    static void triangleProperties(double side1, double side2, double side3, double[] result) {
        double s = (side1 + side2 + side3) / 2;
        result[0] = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Area
        result[1] = side1 + side2 + side3;                                 // Perimeter
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double[] properties = new double[2]; // [0] for Area, [1] for Perimeter

        do {
            System.out.println("Select a shape to calculate properties:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    double radius;
                    System.out.print("Enter the radius of the circle: ");
                    radius = scanner.nextDouble();
                    circleProperties(radius, properties);
                    System.out.println("Area: " + properties[0]);
                    System.out.println("Perimeter: " + properties[1]);
                    break;
                }
                case 2: {
                    double length, width;
                    System.out.print("Enter the length of the rectangle: ");
                    length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    width = scanner.nextDouble();
                    rectangleProperties(length, width, properties);
                    System.out.println("Area: " + properties[0]);
                    System.out.println("Perimeter: " + properties[1]);
                    break;
                }
                case 3: {
                    double side1, side2, side3;
                    System.out.print("Enter the length of side 1 of the triangle: ");
                    side1 = scanner.nextDouble();
                    System.out.print("Enter the length of side 2 of the triangle: ");
                    side2 = scanner.nextDouble();
                    System.out.print("Enter the length of side 3 of the triangle: ");
                    side3 = scanner.nextDouble();
                    triangleProperties(side1, side2, side3, properties);
                    System.out.println("Area: " + properties[0]);
                    System.out.println("Perimeter: " + properties[1]);
                    break;
                }
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        } while (choice != 4);
    }
}
