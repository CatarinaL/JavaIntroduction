
/**
 * Driver class for Bear and Sponsor
 *
 * @catarinalou
 * @v1
 */
import java.util.Scanner;
public class Zoo
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in); 
        int bears; //counts how many bears we create
        String[] names = {"Teddy", "Masha", "Grizzly", "Bebe"};
        Bear[] bearArray = new Bear[4]; //array of bear objects
        Sponsor newSponsor;
        
        for(bears = 0; bears < bearArray.length; bears++)
        {
            bearArray[bears] = new Bear(names[bears]);
            System.out.println("\nBear #" + (bears + 1) + " is " + bearArray[bears].getName());
            //add sponsor
            System.out.println("\nAdd a sponsor for this bear (name, email, phone number)>");
            newSponsor = new Sponsor(input.nextLine(), input.nextLine(), input.nextLine());
            bearArray[bears].addSponsor(newSponsor);
        }
        
        //kill bear 4
        System.out.println("\nKilling Bear #4...");
        bearArray[3].killBear();
        bearArray[3].display();
        
        //feed bear 3 - 90food
        System.out.println("\nFeeding Bear #3...");
        bearArray[2].eat(90);
        bearArray[2].display();
        
        // bear 2 roars x2
        if(bearArray[1].canRoar())
        {
            System.out.println("\nBear #2: RRRRRRooooooAAAAAArrrrr");
        }
        bearArray[1].roar();
        if(bearArray[1].canRoar())
        {
            System.out.println("\nBear #2: RRRRRRooooooAAAAAArrrrr");
        }
        bearArray[1].roar();
        System.out.println("\nCan Bear #2 roar now? " + bearArray[1].canRoar());
        
        //put all bears to sleep
        for(bears = 0; bears < bearArray.length; bears++)
        {
            bearArray[bears].sleep();
            System.out.println("Bear #" + bearArray[bears].getName() + " is asleep.");
        }
    }
}
