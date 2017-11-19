
/**
 * Write a description of class StudentMail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentMail
{
    public static void main(String args[]){
        String progCode = "DT302";
        String studentCode = "C17709355";
        
        int lastPositions = progCode.length() - 3;
        String lastChars = progCode.substring(lastPositions);
        // another substring method with two parameters, end(incl) and begining(excl)
        // String lastChars = progCode.substring(2, 5);
        
        String mailCode = lastChars + studentCode;
        String studentEmail = mailCode + "@mydit.ie";
        
        System.out.println(studentEmail);
    }
}
