
/**
 * Publisher for Book objects / in bookshop system.
 * 
 * @author (Ana Catarina Lourenço - C17709355) 
 * @version (13 December 2017)
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
        System.out.print("\nPublisher Name: " + this.name +
                            "\nEmail address: " + this.email +
                            "\nPhone number: " + this.phone);
    }
   
}
