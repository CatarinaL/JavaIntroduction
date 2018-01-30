
/**
 * Book represents books for sale in a bookshop.
 * It has a price, name, author, publisher and stock quantity.
 * 
 * @author (Ana Catarina Lourenço - C17709355) 
 * @version (13 December 2017)
 */
public class Book
{
    // instance variables
    private String title;
    private String author;
    private double price;
    private Publisher publisher;
    private int stockAmount; // amount in stock
    private final int LOWSTOCK; // CONSTANT minimum stock to trigger reorder warning

    /**
     * Constructor for objects of class Book
     */
    public Book(String title, String author, double price, Publisher publisher)
    {
       this.title = title;
       this.author = author;
       this.price = price;
       this.publisher = publisher;
       this.stockAmount = 5;
       this.LOWSTOCK = 3;
    }

    /**
     * accessor methods 
     */
    public String getTitle()
    {
        return this.title;
    }
    
    public String getAuthor()
    {
        return this.author;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public Publisher getPublisher()
    {
        return this.publisher;
    }
    
    public String getPublisherEmail()
    {
        return this.publisher.getEmail();
    }
    
    public int getStock()
    {
        return this.stockAmount;
    }
    
    public boolean isLowStock()
    {   
        boolean isLowStock = false;
        if(stockAmount <= LOWSTOCK)
        {
           isLowStock = true;
        }
        return isLowStock;
    }
        
    public String toString()
    {
        String details;
        details =   "\n Title:" + this.title +
                    "\n Author: " + this.author +
                    "\n Publisher: " + this.publisher.getName() +
                    "\n Price: " + this.price +
                    "\n Stock quantity: " + this.stockAmount;
        if(isLowStock())
        { 
            details = details + "\n*REORDER: this book is low in stock!";
        }
        return details;
    }
    
    /**
     * mutator methods 
     */
    public void changePrice(double newPrice) 
    {
        this.price = newPrice;
    }
    
    public void sellCopy(int amount)
    {
        if((stockAmount > 0) && (amount <= stockAmount)) 
        {
            stockAmount -= amount;
        }
    }
    
    public void takeDelivery(int quantity)
    {
        if(quantity > 0)
        {
            this.stockAmount += quantity;
        }
    }
   
    public void display()
    {
        System.out.println(this.toString()); 
    }
}
