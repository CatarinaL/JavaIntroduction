
/**
 * Write a description of class Ex3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex3
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String weekDays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        double rainfall[] = new double[7];
        int index;
        int maxIndex = 0;
        int minIndex = 0; 
        double rainfallSum = 0;
        double max = 0; 
        double min = 100000000; // ? better way?
        
        for (index = 0; index < weekDays.length; index++) {
            System.out.println("Input rainfall amount (mm) for " + weekDays[index] + ": ");
            rainfall[index] = input.nextDouble();
            if (rainfall[index] < min) {
                minIndex = index;
                min = rainfall[index];
            }
            if (rainfall[index] > max) {
                maxIndex = index;
                max = rainfall[index];
            }
            rainfallSum = rainfallSum + rainfall[index];
        }
        
        System.out.println("The average rainfall amount for the week is " + (rainfallSum/7) 
                            + "mm. \nMaximum rainfall (" + rainfall[maxIndex] +"mm) was recorded on " + weekDays[maxIndex]
                            + " and the minimum (" + rainfall[minIndex] +"mm) on " + weekDays[minIndex]);
    }
}
