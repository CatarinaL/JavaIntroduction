
/**
 * This class gathers insurance applicants data 
 * and calculates the apropriate quote amount that applies to each case. 
 * It also summarizes some statistics about the collected data, 
 * such as total applicants, applicants under 25 and average of premiums quoted.
 *
 * Catarina Lourenço 
 * C17709355
 * @v1 21/10/2017
 */
//imports first, we need class Scanner from package util
import java.util.Scanner;
public class Insurance
{
    public static void main(String[] args)
    {
        String name, gender, address, carReg, hasClaimBonus, username, proceed;
        int age; 
        int totalApplicants = 0;
        int under25 = 0;
        double sumOfPremiums = 0;
        double premium;
        Scanner input = new Scanner(System.in);

        //greeting/opening instructions for user, only displayed once at start
        System.out.println("Welcome to ABC Insurance, please provide us with your details so we can calculate a tailored quote for you.");

        do 
        {
            System.out.print("\nWhat's your first and last name? > ");
            name = input.nextLine();            
            name = name.trim(); //trim - remove whitespace before and after
            // name validation at input - needs to be at least 4 characters to generate username
            while (name.length() < 4) 
            {
                System.out.print("\t// Full name needs to be at least 4 characters long! \nWhat's your first and last name? > ");
                name = input.nextLine();
                name = name.trim();
            }
            System.out.print("\nThank you, " + name + ", let's continue. \nState your gender (M - Male, F - Female). > ");
            gender = input.nextLine();
            // validate input for gender - only 4 cases accepted -> m or M or f or F
            while (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))) 
            {
                System.out.print("\t// Please type only 'F' or 'M'! \nState your gender (M - Male, F - Female). > ");
                gender = input.nextLine();
            } 
            System.out.print("\nHow old are you? Type it as a number ('25' instead of 'twenty-five'). > ");
            age = input.nextInt();
            input.nextLine(); // clear int input
            while (age < 16) 
            {
                System.out.print("\t// Sorry, you need to be over 16 to have a license and get insurance! \nHow old are you? Type it as a number ('25' instead of 'twenty-five'). > ");
                age = input.nextInt();
                input.nextLine();
            }
            System.out.print("\nWhere's your current address? \nLocation (D - Dublin, C - Cork or O - Other locations) > ");
            address = input.nextLine();
            address = address.trim();
            // validate that it's not left empty OR address.length < 0
            while (address.isEmpty()) 
            {
                System.out.print("\t// Please don't leave the address blank! \nInput D - Dublin, C - Cork, or O - Other locations. > ");
                address = input.nextLine();
                address = address.trim();
            }
            System.out.print("\nPlease input your car registration number without whitespaces or dashes. > ");
            carReg = input.nextLine();
            carReg = carReg.trim();
            // needs to be at least 3 chars long, and not contain spaces or dashes
            while (carReg.contains(" ") || carReg.contains("-") || carReg.contains("_") || (carReg.length() < 3)) 
            {
                System.out.print("\t// Please input only the digits/letters in your car registration!" +
                    "\nWrite your registration without using spaces or dashes, i.e., '122D111'. > ");
                carReg = input.nextLine();
                carReg = carReg.trim();
            }
            System.out.print("\nAre you eligible for a 'No Claim Bonus'? (Y - Yes, N - No) > ");
            hasClaimBonus = input.nextLine();
            hasClaimBonus = hasClaimBonus.trim();
            // could be a boolean but it's probably more natural for a user to answer yes or no, 
            // and I couldn't see a huge benefit in translating that into a boolean afterwards
            while (!(hasClaimBonus.equalsIgnoreCase("y") || hasClaimBonus.equalsIgnoreCase("n") || 
                hasClaimBonus.equalsIgnoreCase("yes") || hasClaimBonus.equalsIgnoreCase("no"))) 
            {
                System.out.print("\t// Please, answer only 'yes' or 'no'! \nAre you eligible for a 'No Claim Bonus'? > ");
                hasClaimBonus = input.nextLine();
                hasClaimBonus = hasClaimBonus.trim();
            }

            // generate and display username
            username = carReg + name.substring(0, 4);
            username = username.replace(' ', '_');
            System.out.println("\nYour username is: " + username + "\nHit Enter to generate your quote."); //replace whitespace with underscore
            input.nextLine();

            // calculate quote - business logic
            premium = 250; // reset premium to basic value
            if(gender.equalsIgnoreCase("f"))
            {
                premium = premium - (premium * 0.04); // discount 4%
            }
            if (age < 25) 
            {
                premium = premium * 1.25; //add 25%
                under25 += 1;
            }
            if (address.equalsIgnoreCase("d") || address.equalsIgnoreCase("dublin")) //accepting d or dublin as well 
            {
                premium = premium * 1.08; // add 8%
                address = "Dublin"; // for readibility further down when I'm displaying entered information
            } else if (address.equalsIgnoreCase("c") || address.equalsIgnoreCase("cork")) {
                premium = premium * 1.05; // add 5%
                address = "Cork";
            } else {
                premium = premium * 1.02; // add 2%
            }
            if (hasClaimBonus.equalsIgnoreCase("no") || hasClaimBonus.equalsIgnoreCase("n")) 
            {
                premium = premium * 1.4; //add 40%
            }

            // display quote
            System.out.println("\fYour quote is: " + premium + "€.");
            System.out.println("Generated for: " + username + ". \nName> " + name + "\nAge> " + age + "\nGender> " + gender + "\nLocation> " + address + "\nCar registration> " + carReg + "\nHas claim bonus> " + hasClaimBonus);

            // stats so far...
            sumOfPremiums = sumOfPremiums + premium;
            totalApplicants += 1; 
            System.out.println("\nQuote #" + totalApplicants + ". Total of applicants under 25: " + under25 + ". \nAverage cost of insurance: " + (sumOfPremiums / totalApplicants) + "€.");

            //user prompt to continue
            System.out.println("\nDo you wish to get a new quote? (Y - to continue, or type any key to leave)");
            proceed = input.nextLine();
        } while(proceed.equalsIgnoreCase("y")); //end main loop

        System.out.println("\nThank you for choosing ABC Insurance. Goodbye!");
    }
}
