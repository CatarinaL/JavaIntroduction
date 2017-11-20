
/**
 * Write a description of class Sponsor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sponsor
{
    // instance variables - replace the example below with your own
    private String name;
    private String email;
    private String phoneNumber;

    /**
     * Constructor for objects of class Sponsor
     */
    public Sponsor(String name, String email, String phoneNumber)
    {
        // initialise instance variables
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * methods
     */
    public String getName()
    {
        return this.name; 
    }
    
    public String getEmail()
    {
        return this.email; 
    }
    
    public String getPhoneNumber()
    {
        return this.phoneNumber; 
    }
    
    //maybe a method to return an array with these 3 pieces of info?
}
