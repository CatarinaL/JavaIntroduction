
/**
 * Write a description of class Ex4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ex4
{
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        double pi = 3.14159265359;
        System.out.println("Calculate the Volume of a sphere from its radius (in cm). Radius: ");
        double raio = userIn.nextDouble();
        double cubedRadius = Math.pow(raio, 3);
        // aprox. 4.19cubedRadius
        System.out.println("The Volume (in cubic cm) of a sphere of radius " + raio + " is " + (4.19 * cubedRadius));
        System.out.println("The Volume (in cubic cm) of a sphere of radius " + raio + " is " + (4.0 / 3.0* pi * cubedRadius));
    }
}
