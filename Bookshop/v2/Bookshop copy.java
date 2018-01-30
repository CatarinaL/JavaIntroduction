
/**
 * Driver class
 * 
 * @author (Catarina Lourenço) 
 * @v2
 */
import java.util.Scanner;
import java.util.Arrays; //to use methods to manipulate arrays
public class Bookshop
{
    //instance variables of Bookshop
    Scanner input = new Scanner(System.in);
    Book[] bookList;

    //constructor
    public Bookshop()
    {
        initialMenu();
        //wait for initialMenu loop to finish...
        //TODO extra functionality that givs you summary of total sales
        System.out.println("Your Bookshop System is shutting down... Goodbye!");
    }

    public void createBookshop()
    {
        
    }

    public void storedBookshop()
    {
        bookList = new Book[4];
        Publisher[] publishers = new Publisher[2];
        // String name, email, phone)
        publishers[0] = new Publisher("Liffey Publishing", "business@liffeypublishing.ie", "012238745");
        publishers[1] = new Publisher("Ambar", "contact@ambar.pt", "00351 21936713");
        //(String title, String author, double price, Publisher publisher)
        bookList[0] = new Book("BookTitle1", "Author1", 14.99, publishers[1]);
        bookList[1] = new Book("BookTitle2", "Author2", 12.99, publishers[0]);
        bookList[2] = new Book("BookTitle3", "Author3", 9.99, publishers[1]);
        bookList[3] = new Book("BookTitle4", "Author4", 24.99, publishers[1]);
    }
    //MENUS
    public void initialMenu()
    {
        System.out.println("===================================");
        System.out.println("Welcome to your Bookshop System");      
        int option;
        do{
            System.out.println("\n\t===================================");
            System.out.println("\t1> Create new books and publishers");
            System.out.println("\t2> Use stored books and publishers");
            System.out.println("\t0> Exit Bookshop System");
            System.out.println("\t===================================");
            System.out.print("Select option and Enter> ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 0: break;
                case 1: createBookshop();
                shopMenu();
                break;
                case 2: storedBookshop();
                shopMenu();
                break;
                default: System.out.println("Invalid option");
                break;                 
            }
        }while(option != 0);
    }

    public void shopMenu()
    {
        int option;
        do{
            System.out.println("\n\t===================================");
            System.out.println("\t1> Search all books by title");
            System.out.println("\t2> Display all books in stock");
            System.out.println("\t3> Display all books low on stock");
            System.out.println("\t0> Go back");
            System.out.println("\t===================================");
            System.out.print("Select option and Enter> ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 0: break;
                case 1: returnBooksByTitle();
                break;
                case 2: displayBooks();
                    Book book = selectBookMenu(bookList);
                    bookMenu(book);
                break;
                case 3: returnLowStock();
                break;
                default: System.out.println("Invalid option. \n\tSelect again from menu:");
                break;                
            }
        }while(option != 0); 

    }

    public void bookMenu(Book selected)
    {
        int option;
        do{
            System.out.println("\n\t===================================");
            System.out.println("\t1> Sell this book");
            System.out.println("\t2> Change price of this book");
            System.out.println("\t3> Take delivery");
            System.out.println("\t0> Go back");
            System.out.println("\t===================================");
            System.out.print("Select option and Enter> ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 0: break;
                case 1: sellBook(selected); //sell book 
                break;
                case 2: changeBookPrice(selected); //change price of a book
                break;
                case 3: takeBookDelivery(selected); //add books to stock
                break;
                default: System.out.println("Invalid option");
                break;                 
            }
        }while(option != 0); 

    }

    public Book selectBookMenu(Book[] books)
    {
        System.out.println("\n\t===================================");
        System.out.println("\tBOOK SELECTION");
        System.out.println("\t1 to " + (books.length) + "> Select a book from the previous list");
        System.out.println("\t0> Go back.");
        System.out.print("Select option and Enter> ");
        int option = input.nextInt();
        input.nextLine();
        while(!(option >= 0 && option <= books.length)) // TODO: DeMorgan
        {
            System.out.println("\tINVALID SELECTION!");
            System.out.println("\t1 to " + (books.length) + "> Select a book from the previous list");
            System.out.println("\t0> Go back.");
            System.out.print("Select option and Enter> ");
            option = input.nextInt();
            input.nextLine();
        }
        if(option == 0){
            return null;
        } else {
            System.out.println("\nBook selected:\n\t" + books[(option-1)]);
            return books[(option-1)]; 
        } 
    }

    // Search methods for book in bookList[] array - a) by title, b) by low stock
    public Book[] searchBookTitle(String searchTerm)
    {
        Book[] results = new Book[bookList.length]; //need array to store results, in order to search for all that Book objects contain my search term
        int resultCount = 0; //to keep track and fill results array  
        for(int i=0; i < bookList.length; i++)
        {
            if(bookList[i].getTitle().toLowerCase().contains(searchTerm.toLowerCase()))
            {
                results[resultCount] = bookList[i];
                resultCount += 1; 
            }
        }
        return Arrays.copyOf(results, resultCount); //using a method from class Arrays to return a copy of that list with only result values, no nulls etc
    }

    public void returnBooksByTitle()
    {
        String searchTerm;
        System.out.println("SEARCH: Enter search term> ");
        searchTerm = input.nextLine();
        Book[] results = searchBookTitle(searchTerm);
        if(results.length == 0)
        {
            System.out.println("Sorry, no results for  " + searchTerm); 
            
        }
        else
        {
            for(int i=0; i < results.length; i++) //list of results
            {
                System.out.print((i+1) + "> ");
                results[i].display();
            }
            //contextual selectBookMenu() here that leads to bookMenu()
            Book selected = selectBookMenu(results);
            if(selected != null)
            {
                bookMenu(selected);
            } 
        }
        
    }

    public Book[] searchBooksLowStock()
    {
        Book[] results = new Book[bookList.length]; //need array to store results, in order to search for all that Book objects contain my search term
        int resultCount = 0; //to keep track and fill results array  
        for(int i=0; i < bookList.length; i++)
        {
            if(bookList[i].isLowStock())
            {
                results[resultCount] = bookList[i];
                resultCount += 1; 
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    public void returnLowStock()
    {
        Book[] results = searchBooksLowStock();
        if(results.length == 0)
        {
            System.out.println("No books need reordering at the moment.");
            shopMenu();
        }
        else
        {
            System.out.println("The following books are low on stock and need reordering: ");
            for(int i=0; i < results.length; i++) //list of results
            {
                System.out.print((i+1) + "> ");
                results[i].display();
                System.out.println("\tPlease contact the publisher at " + results[i].getPublisherEmail());
            }
            //contextual selectBookMenu() here that leads to bookMenu()
            Book selected = selectBookMenu(results);
            if(selected != null)
            {
            bookMenu(selected);
            } 
            
        }
    }
    
    //Shop actions - from book menu: sell, take delivery, change price...
    
    public void sellBook(Book selected)
    {  
        System.out.println("Number of copies to sell> ");
        int amount = input.nextInt();
        input.nextLine();
        //TODO validate for 0 or less
        if(selected.getStock() < amount)
        {
            System.out.println("Not enough copies.");
        } else{
            selected.sellCopy(amount); 
            saleInvoice(selected, amount);
        }
        
    }
    
    public void saleInvoice(Book selected, int amount)
    {  
        double bookVat = 0.20;
        System.out.println("SALE INVOICE");
        System.out.println("Item: " + selected.getTitle());
        System.out.println("Number of copies: " + amount);
        System.out.println("Price per copy: " + selected.getPrice());
        System.out.println("Total price (including VAT): " + ((selected.getPrice() * (bookVat + 1)) * amount)); 
        
    }
    
    public void changeBookPrice(Book selected)
    {
        //validate for negatives
        System.out.print("This book's present price is " + selected.getPrice() + "€.");
        System.out.print("Enter new price> ");
        double newPrice = input.nextDouble();
        input.nextLine();
        if(newPrice < 0)
        {
            System.out.println("Invalid! Prices must be at least 0.00 (free books) or higher.");
        } 
        else
        {
            selected.changePrice(newPrice);
            System.out.print("The new price of " + selected.getTitle() + 
                            " is " + selected.getPrice() + "€.");
        }
    }
    
    public void takeBookDelivery(Book selected)
    {
        //validate for negatives
        System.out.print("Number of copies to add> ");
        int amount = input.nextInt();
        input.nextLine();
        if(amount < 1)
        {
            System.out.println("Invalid! To restock this book, take delivery of 1 or more books.");
        } 
        else
        {
            selected.takeDelivery(amount);
            System.out.print("New amount in stock: " + selected.getStock());
        }
        
    }

    //DISPLAY method(s)
    public void displayBooks()
    {
        for(int i=0; i < bookList.length; i++)
        {
            System.out.print((i+1) + "> ");
            bookList[i].display();
        }
    }

    public static void main(String[] args)
    {
        new Bookshop();
    }
}
