public class ArithmeticDemo {
    public static void main(String[] args) {
        // 1. Declare and initialize variables
        int a = 20;
        int b = 4;
        int result;

        // 2. Perform Arithmetic Operations

        // Addition (+)
        result = a + b;
        System.out.println("Addition (a + b): " + result); // Output: 24
        // 

        // Subtraction (-)
        result = a - b;
        System.out.println("Subtraction (a - b): " + result); // Output: 16

        // Multiplication (*)
        result = a * b;
        System.out.println("Multiplication (a * b): " + result); // Output: 80

        // Division (/)
        // NOTE: Integer division truncates the decimal part (20/4 = 5.0 -> 5)
        result = a / b;
        System.out.println("Division (a / b): " + result); // Output: 5

        // Modulus (%) - Remainder
        result = a % b;
        System.out.println("Modulus (a % b): " + result); // Output: 0 (20 divided by 4 has a remainder of 0)

        // 3. Example with Floating-Point Numbers for Precise Division

        double x = 20.0;
        double y = 3.0;
        double preciseResult = x / y;
        System.out.println("\nPrecise Division (x / y): " + preciseResult); // Output: 6.666...
    }
}