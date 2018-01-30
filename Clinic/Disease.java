
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease
{
    // instance variables 
    private int severity;
    private String name;

    /**
     * Constructor for objects of class Disease
     */
    public Disease(String name, int severity)
    {
        this.name = name;
        this.severity = severity;
    }

    /**
     * methods
     */
    public int getSeverity()
    {
        // put your code here
        return this.severity;
    }
    public String getName()
    {
        // put your code here
        return this.name;
    }
}
