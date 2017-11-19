
/**
 * Write a description of class Ex2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class Ex2
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String myList[] = new String[15];
        String addAnother = "y";
        int listItems = 0;
        int i;
        do {
            System.out.println("New item > ");
            myList[listItems] = input.nextLine();
            listItems += 1;
            System.out.println("Do you want to add another item to your list? (Y-yes, N-No) > "); 
            addAnother = input.nextLine();
        } while (addAnother.equalsIgnoreCase("Y") && listItems < myList.length);
        
        System.out.println("Today's Shopping List \nYou have " + listItems + " item(s) in your shopping list:");
        for (i=0; i < listItems; i++){
            System.out.println((i+1) + ". " + myList[i]);
        }
    }
}
