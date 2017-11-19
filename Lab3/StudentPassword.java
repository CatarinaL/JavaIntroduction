
/**
 * Write a description of class StudentPassword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentPassword
{
    public static void main(String[] args){
        String course = "DT309";
        String email = "banana@email.dit.ie";
        String password = "";
        
        if(password.length() < 8 || password.length() > 20){
            password = email.substring(0, 5) + course.substring((course.length() - 3), course.length());
            System.out.println("Invalid password for " + email + ". \nYour password was reset to " + password);
        } else {
            System.out.println("Your email address is " + email + "and your password is " + password);
        }
    }
}
