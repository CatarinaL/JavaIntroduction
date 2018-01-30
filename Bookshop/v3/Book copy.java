
/**
 * Book represents books for sale in a bookshop.
 * It has a price, name, (author?), publisher and stock quantity.
 * 
 * @catarinalou
 * @v1
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
    
    public String getPublisher()
    {
        return this.publisher.getName();
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
        details =   this.title +
                    "\n\t Author: " + this.author +
                    "\n\t Publisher: " + this.publisher.getName() +
                    "\n\t Price: " + this.price +
                    "\n\t Stock quantity: " + this.stockAmount;
        if(isLowStock())
        { 
            details = details + "\n\t REORDER: this book is low in stock!";
        }
        return details;
    }
    
    /**
     * mutator methods 
     */
    public void changePrice(double newPrice) //TODO: validate to exclude negative numbers (OR in driver?)
    {
        this.price = newPrice;
    }
    
    public void sellCopy(int amount)//dont sell negative books, also check if amount is >0
    {
        if((stockAmount > 0) && (amount < stockAmount)) //validate here?
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
