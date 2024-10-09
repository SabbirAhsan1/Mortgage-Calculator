import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final byte percent = 100;
        final byte numberOfMonths = 12;
        System.out.print("Principal: ");
        double principal = input.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double interestRate = input.nextDouble();
        System.out.print("Period (Years): ");
        double period = input.nextDouble();
        interestRate = interestRate / percent / numberOfMonths ;
        period *= numberOfMonths;
        double mortgage = (principal * (interestRate*Math.pow((1+interestRate), period))) / (Math.pow((1+interestRate), period) -1);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}
