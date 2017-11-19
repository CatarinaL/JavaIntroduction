
/**
 * Write a description of class Ex1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex1
{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int myArray[] = new int[10];
        int i;
        
        System.out.println("Array of 10 integer numbers.");
        
        for (i = 0; i < myArray.length; i++) {
            System.out.println("Input a number > ");
            myArray[i] = userInput.nextInt();
        }
        System.out.println("This is your array, reversed: ");
        for (i = (myArray.length - 1); i >= 0; i--) {
            System.out.println(myArray[i]);
        }
        
        
    }
}
