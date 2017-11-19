
/**
 * Write a description of class PrimeSieve here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class PrimeSieve
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String continueInput;
        boolean notPrime = true;
        int i;
        double number, halfNumber;
        do{
            System.out.println("Input an integer number to check if it is a prime > ");
            number = input.nextDouble();
            input.nextLine(); // clear
            
            // sieve loop to test if Prime number
            // to improve: doesnt have to loop through ALL, only lower half
            halfNumber = number / 2;
            for (i = 2; i < number; i++) {
                notPrime = number % i == 0; // notPrime is true when the remainder is zero
                if (notPrime) {
                    System.out.println("False, " + number + " is not a prime (divisible by " + i + ").");
                    break; // as soon as we find notPrime we can jump out
                }
            }
            
            if (notPrime == false) {
                System.out.println("True, " + number + " is a prime number (only divisible by itself, 1 and 0).");
                
            } 
            
            System.out.println("Do you wish to continue? (Y/N)");
            continueInput = input.nextLine();
        } while(continueInput.equalsIgnoreCase("y"));
        
        System.out.println("END");
    } // end of main class
} // end of PrimeSieve class (public)
