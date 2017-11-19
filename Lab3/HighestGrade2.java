
/**
 * Write a description of class HighestGrade2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HighestGrade2
{
    public static void main(String[] args){
        int[] grades = {1, 2, 3, 4, 5, 44, 67, 222, 2, 55};
        String[] names = {"To", "Mi", "Ni", "Gi", "Ze", "Lo", "Fe", "Ra", "De", "Du"};
        int arrayIndex = 0;

        for(int i=0; i < grades.length; i++) {
            if (grades[i] > grades[arrayIndex]){
    		arrayIndex = i;
            }
            
            System.out.println(names[i] + " has a grade of " + grades[i] + ". \n");
        }
        
        System.out.println(names[arrayIndex] + " achieved the highest grade - " + grades[arrayIndex]);

    }
 
}
