
/**
 * REDO thinking of higher number of name/grade pairs
 */
public class HighestGrade
{
    public static void main(String[] args){
        String nameA, nameB, nameC;
        nameA = "Ada";
        nameB = "Byron";
        nameC = "Charlotte";
        
        int gradeA, gradeB, gradeC;
        gradeA = 76;
        gradeB = 93;
        gradeC = 97;
        
        System.out.println(nameA + " achieved a grade of " + gradeA + ". \n" + nameB + " achieved a grade of " + gradeB + ". \n" + nameC + " achieved a grade of " + gradeC + ". \n");
        
        if(gradeA > gradeB && gradeA > gradeC){
            System.out.println(nameA + " has achieved the highest grade!");
        } else if(gradeB > gradeC){
            System.out.println(nameB + " has achieved the highest grade!");
        } else {
            System.out.println(nameC + " has achieved the highest grade!");
        }
    }
}
