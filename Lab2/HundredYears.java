
/**
 * Write a description of class hundredYears here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HundredYears
{
    public static void main (String args[]){
    
        int birthDay = 21; // could it be a String here?
        String birthMonth = "April";
        int birthYear = 1990;
        
        System.out.println("You were born on " + birthMonth + " " + birthDay + ", " + birthYear);
        System.out.println("You will be 100 on " + birthMonth + " " + birthDay + ", " + (birthYear + 100));
    }   
}

