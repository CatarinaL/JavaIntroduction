
/**
 * Publisher for Book objects / bookshop system.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Publisher
{
    // instance variables
    private String name;
    private String email;
    private String phone;

    /**
     * Constructor for objects of class Publisher
     */
    public Publisher(String name, String email, String phone)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    //mutators
    public void changeEmail(String newEmail)
    {
        this.email = newEmail;
    }
    
    public void display()
    {
        System.out.print("n/Publisher Name: " + this.name +
                            "n/Email address: " + this.email);
    }
   
}
