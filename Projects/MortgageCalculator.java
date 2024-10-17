import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final byte percent = 100;
        final byte numberOfMonths = 12;
        System.out.print("Principal ($1K - $1M): ");
        double principal = input.nextDouble();
        while(principal<1000 || principal>1000000){
                System.out.println("Enter a number between 1000 to 1000000");
                System.out.print("Principal ($1K - $1M): ");
                principal = input.nextDouble();
        }
        System.out.print("Annual Interest Rate: ");
        double interestRate = input.nextDouble();
        while(interestRate<=0 || interestRate>30){
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
            System.out.print("Annual Interest Rate: ");
            interestRate = input.nextDouble();
        }
        System.out.print("Period (Years): ");
        double period = input.nextDouble();
        while(period<1 || period>30){
            System.out.println("Enter a value between 1 and 30");
            System.out.print("Period (Years): ");
            period = input.nextDouble();
        }
        interestRate = interestRate / percent / numberOfMonths ;
        period *= numberOfMonths;
        double mortgage = (principal * (interestRate*Math.pow((1+interestRate), period))) / (Math.pow((1+interestRate), period) -1);
        String result = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}
