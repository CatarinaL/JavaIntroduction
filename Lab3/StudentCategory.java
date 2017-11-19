
/**
 * Write a description of class StudentPassword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentCategory
{
    public static void main(String[] args){
        char category = 'i';
        
        switch (category) {
            case 'f':
              System.out.println("Full-time student.");
              break;
            case 'p':
              System.out.println("Part-time student.");
              break; 
            case 'i':
              System.out.println("Internship work programme student.");
              break; 
            default:
             System.out.println(category + " is an invalid student category.");
        }
    }
}