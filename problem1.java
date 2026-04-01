import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number (or 'exit'): ");
                String input1 = sc.nextLine();

                if (input1.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }

                int num1 = Integer.parseInt(input1);

                System.out.print("Enter second number: ");
                String input2 = sc.nextLine();
                int num2 = Integer.parseInt(input2);

                int result = num1 / num2;

                System.out.println("Result: " + num1 + " / " + num2 + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid integers only.");
            }
        }

        sc.close();
    }
}