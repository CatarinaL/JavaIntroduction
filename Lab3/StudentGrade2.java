/**
 * Write a description of class StudentGrade1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentGrade2
{
    public static void main(String[] args){
    int studentGrade = 59;
    
    if (studentGrade >= 70 && studentGrade <= 100){
        System.out.println("Your grade is " + studentGrade + "%. \nCongratulations, you have passed the exam with distinction!");
    } else if (studentGrade >= 50 && studentGrade <= 69){
        System.out.println("Your grade is " + studentGrade + "%. \nCongratulations, you have passed the exam with credit.");
    } else if (studentGrade >= 40 && studentGrade <= 49){
        System.out.println("Your grade is " + studentGrade + "%. \nCongratulations, you have passed the exam.");
    } else if (studentGrade <= 39){
        System.out.println("Your grade is " + studentGrade + "%. \nUnfortunately, you have failed and must repeat the exam.");
    } else {
        System.out.println("Invalid");
    }
    
    }
}