
/**
 * Write a description of class ClinicManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ClinicManager
{
    // instance variables 
    Patient[] patients;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor for objects of class ClinicManager
     */
    public ClinicManager()
    {
        // initialise instance variables
        createPatients();
        /*
         * //fill patients array by user input later
        patients = new Patient[3];
        patients[0] = new Patient("Jack Daniels", "00911", "911Daniels");
        patients[1] = new Patient("Joanna", "22912", "912Jojo");
        patients[2] = new Patient("Piotr Vladescu", "33913", "913Piotr");
        */
        //menu
        mainMenu();
        //goodbye
        System.out.println("Aperture Science Clinic Manager 2.0 is shutting down... \n\n\nAnd when you're dead I will be still alive!");
    }
    
    public void createPatients()
    {
        int total;
        System.out.print("How many patients do you wish to you wish to add? (min 4) > ");
        total = scan.nextInt();
        scan.nextLine();
        while(total < 4)
        {
          System.out.println("You must add at least 4 patients > "); 
          total = scan.nextInt();
          scan.nextLine();
        }
        patients = new Patient[total];
        arrayFill(patients);
    }
    
    public void arrayFill(Patient[] array)
    {
        String patientId = "";
        for(int i = 0; i < array.length; i++)
        {
            patientId = "00" + (i+1);
            System.out.println("\nPlease fill the data for patient " + patientId);
            System.out.print("Name > ");
            String name = scan.nextLine();
            while(!(validLength(name, 2)))
            {
                System.out.println("\tName should be at least 2 characters!"); 
                System.out.print("\nName > ");
                name = scan.nextLine();
            }
            System.out.print("\nPhone number > ");
            String phone = scan.nextLine();
            while(!(validLength(phone, 6)))
            {
                System.out.println("\tPhone number should be at least 6 characters!"); 
                System.out.print("\nPhone number > ");
                phone = scan.nextLine();
            }
            patients[i] = new Patient(name, phone, patientId);
        }
    }
    
    public boolean validLength(String toValidate, int min)
    {
        if(toValidate.trim().length() < min)
        {
            return false;
        }
        return true;
    }

    /**
     * menu loop methods
     */
    public void mainMenu()
    {
        int selection;
        do{
            System.out.println("\nMenu");
            System.out.println("1> List Patients \n2> List Diagnosis \n0> Exit");
            System.out.println("Menu selection> ");
            selection = scan.nextInt();
            scan.nextLine();
            switch(selection)
            {
                case 0: break;
                case 1: listPatients();
                break;
                default: System.out.println("\nInvalid selection, try a different input.");
            }
            System.out.println();
        }while(selection != 0);
    }

    /**
     * other methods
     */
    public void listPatients()
    {
        for(int i = 0; i < patients.length; i++)
        {
            System.out.println(patients[i].toString());
        }
    }

    public static void main(String[] args)
    {
        new ClinicManager();
    }
}
