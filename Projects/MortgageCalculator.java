import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        double principal = readNumber("Principal: ", 1000, 1_000_000);
        double interestRate = readNumber("Annual Interest Rate: ", 1, 30);
        double period = readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, interestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: ");
        System.out.println("Monthly Payments: " + mortgageFormatted);
        paymentSchedule(principal,period,interestRate);
    }

    public static double readNumber(
            String prompt,
            double min,
            double max){

        Scanner input = new Scanner(System.in);
        double value;
        
        while(true){
            System.out.print(prompt);
            value = input.nextDouble();
            if(value >= min && value <=max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;

    }


    public static double calculateMortgage(
            double principal,
            double interestRate,
            double period){

        final byte percent = 100;
        final byte numberOfMonths = 12;
        interestRate = interestRate / percent / numberOfMonths ;
        period *= numberOfMonths;
        return (principal * (interestRate*Math.pow((1+interestRate), period))) / (Math.pow((1+interestRate), period) -1);


    }
    public static void paymentSchedule(
            double principal,
            double numberOfPayments,
            double monthlyInterestRate){

        final byte percent = 100;
        final byte numberOfMonths = 12;
        monthlyInterestRate = monthlyInterestRate/percent/numberOfMonths;
        numberOfPayments = numberOfPayments*12;
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_____________");
        
        for(int i=1; i<=numberOfPayments; i++){
            double paymentToMade = (principal*((Math.pow((1+monthlyInterestRate),numberOfPayments))-(Math.pow((1+monthlyInterestRate),i))))/(Math.pow((1+monthlyInterestRate),numberOfPayments)-1);
            String paymentToMadeFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(paymentToMade);
            System.out.println(paymentToMadeFormatted);
        }
        
    }
}
