import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = input.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double interestRate = input.nextDouble();
        System.out.print("Period (Years): ");
        double period = input.nextDouble();
        interestRate /= 100;
        interestRate /= 12;
        period *= 12;
        double mortgage = (principal * (interestRate*Math.pow((1+interestRate), period))) / (Math.pow((1+interestRate), period) -1);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}