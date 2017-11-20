
/**
 * Write a description of class Bear here.
 *
 * @Catarina
 * @version 1 - 19 11 2017
 */
public class Bear
{
    // instance variables
    private String name;
    private double energy;
    private boolean alive;
    private Sponsor sponsor;

    /**
     * Constructor for objects of class Bear
     */
    public Bear(String name)
    {
        // initialise instance variables
        this.name = name;
        this.energy = 50.0;
        this.alive = true;
        this.sponsor = null;
    }

    /**
     * Methods
     */
    // accessors
    public String getName()
    {
        return this.name;
    }
    
    public boolean canRoar()
    {
        return (this.energy > 60);
    }
    
    public boolean isAlive()
    {
        return (this.alive);
    }
    
    // mutators
    public void addSponsor(Sponsor newSponsor)
    {
        this.sponsor = newSponsor; //add a new sponsor (sponsor object) to this bear
    }
    
    public void changeName(String newName)
    {
        this.name = newName;
    }
    
     public void eat(double foodAmount)
    {
        this.energy += (foodAmount / 2);
    }
    
    public void sleep()
    {
        this.energy *= (1.33); // *= is actually a thing, yey
    }
    
    public void roar()
    {
        if (canRoar()){
            this.energy -= 30; 
        }
    }
    
    public void growl(int howManyGrowls)
    {
        this.energy -= (5 * howManyGrowls);
    }
    
    public void killBear()
    {
        if(isAlive()){
            this.energy = 0;
            this.alive = false;
        }
    }
    
    //display method
    public void display()
    {
        System.out.println("Name: " + this.name +
                            "\nEnergy level: " + this.energy +
                            "\nIs this bear alive? " + this.alive +
                            "\nSponsored by " + this.sponsor.getName());
    }
}
