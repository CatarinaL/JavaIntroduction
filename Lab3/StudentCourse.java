/**
 * Write a description of class StudentGrade1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentCourse
{
    public static void main(String[] args){
    String studentCourse = "DT302";
    String firstName = "Ada";
    
    if (studentCourse.equals("DT211") || studentCourse.equals("DT228")){
        System.out.println("Hello, " + firstName + ". \nYour course is " + studentCourse + ". \nPlease register with the School of Computing in Kevin Street.");
    } else if (studentCourse.equals("DT302")){
        System.out.println("Hello, " + firstName + ". \nYour course is " + studentCourse + ". \nPlease register with the School of Management in Aungier Street.");
    } else {
        System.out.println("Hello, " + firstName + ". \nYour course is " + studentCourse + ". \nPlease note that this is not a computing ");
    }
    
    }
}