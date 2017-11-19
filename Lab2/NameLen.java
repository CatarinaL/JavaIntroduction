
/**
 * Write a description of class NameLen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NameLen
{
    public static void main (String args[]){
        String firstName = "Ana";
        String lastName = "Lourenço";
        
        System.out.println("Your name is " + firstName + " " + lastName);
        System.out.println("Your initials are " + firstName.charAt(0) + lastName.charAt(0));
        System.out.println(firstName + " is " + firstName.length() + " letters and " + lastName + " is " + lastName.length() + " letters.");
    }
}
