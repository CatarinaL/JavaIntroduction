
/**
 * Driver class
 * 
 * @author (Catarina Lourenço) 
 * @v4
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
        //TODO extra functionality that givs summary of total sales
        System.out.println("\n\\\\\\\\");
        System.out.println("Your Bookshop System is shutting down... Goodbye!");
    }

    public void createBookshop()
    {
        System.out.print("\n*PUBLISHERS. How many publishers supply this Bookshop? (minimum 2)> ");
        int howManyPublishers = getValidMinimum(2);
        Publisher[] publishers = new Publisher[howManyPublishers];
        for(int i=0; i < publishers.length; i++) //fill publishers array
        {
            System.out.println("\n\\\\\\\\");
            System.out.println("PUBLISHER " + (i+1));
            System.out.print("Publisher Name> ");
            String publisherName = getValidString();
            System.out.print("Publisher Email> ");
            String publisherEmail = getValidString();
            System.out.print("Publisher Phone> ");
            String publisherPhone = getValidString();
            publishers[i] = new Publisher(publisherName, publisherEmail, publisherPhone);
        }

        System.out.print("\n*BOOKS. How many book titles are there in this Bookshop? (minimum 4)>");
        int howManyBooks = getValidMinimum(4);
        bookList = new Book[howManyBooks];
        for(int i=0; i < bookList.length; i++) //fill bookList array
        {
            System.out.println("\n\\\\\\\\");
            System.out.println("BOOK " + (i+1));
            System.out.print("Book Title> ");
            String bookTitle = getValidString();
            System.out.print("Book Author> ");
            String bookAuthor = getValidString();
            System.out.print("Book Price> ");
            double bookPrice = getValidMinimum(0.0); 
            System.out.println("Select a Publisher from the list... ");
            for(int publisher=0; publisher < publishers.length; publisher++)
            {
                System.out.println((1 + publisher) + "> " + publishers[publisher].getName());
            }
            int selectedPublisher = getValidInRange(1, publishers.length) - 1;
            Publisher bookPublisher = publishers[selectedPublisher];
            bookList[i] = new Book(bookTitle, bookAuthor, bookPrice, bookPublisher);
        }
    }

    public void storedBookshop()
    {
        bookList = new Book[4];
        Publisher[] publishers = new Publisher[2];
        // String name, email, phone
        publishers[0] = new Publisher("Liffey Publishing", "business@liffeypublishing.ie", "012238745");
        publishers[1] = new Publisher("Ambar", "contact@ambar.com", "05936713");
        //(String title, String author, double price, Publisher publisher)
        bookList[0] = new Book("One World", "Uno Primo", 11.99, publishers[1]);
        bookList[1] = new Book("2 Birds, 1 Stone", "Alan Tworing", 20.99, publishers[0]);
        bookList[2] = new Book("Third time's the charm", "Trinity Wick", 13.0, publishers[0]);
        bookList[3] = new Book("To the 4 Winds", "Iosef Quartz", 4.99, publishers[1]);
    }
    //MENUS
    public void initialMenu()
    {
        System.out.println("===================================");
        System.out.println("Welcome to your BOOKSHOP System");      
        int option;
        do{
            System.out.println("\n\t----------SETUP MENU----------");
            System.out.println("\t1> Create new books and publishers");
            System.out.println("\t2> Use stored books and publishers");
            System.out.println("\t0> Exit Bookshop System");
            System.out.println("\t------------------------------");
            System.out.print("\nSelect option and Enter> ");
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
                default: System.out.println("\n\t******Invalid option***** ");
                break;                 
            }
        }while(option != 0);
    }

    public void shopMenu()
    {
        int option;
        do{
            System.out.println("\n\t----------MAIN MENU----------");
            System.out.println("\t1> Search all books by title");
            System.out.println("\t2> Display all books in stock");
            System.out.println("\t3> Display all books low on stock");
            System.out.println("\t0> Go back");
            System.out.println("\t-----------------------------");
            System.out.print("\nSelect option and Enter> ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 0: break;
                case 1: returnBooksByTitle();
                break;
                case 2: displayBooks();
                Book selected = selectBookMenu(bookList);
                if(selected != null)
                {
                    bookMenu(selected);
                } 
                break;
                case 3: returnLowStock();
                break;
                default: System.out.println("\n\t******Invalid option***** ");
                break;                
            }
        }while(option != 0); 

    }

    public void bookMenu(Book selected)
    {
        int option;
        do{
            System.out.println("\n\t----------BOOK MENU----------");
            System.out.println("\t1> Sell this book");
            System.out.println("\t2> Change price of this book");
            System.out.println("\t3> Take delivery");
            System.out.println("\t4> Display this book's details.");
            System.out.println("\t5> Display publisher's details.");
            System.out.println("\t0> Go back");
            System.out.println("\t-----------------------------");
            System.out.print("\nSelect option and Enter> ");
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
                case 4: selected.display(); //see details of this book
                break;
                case 5: selected.getPublisher().display(); //see details of this book's publisher
                break;
                default: System.out.println("\n\t******Invalid option*****");
                break;                 
            }
        }while(option != 0); 

    }

    public Book selectBookMenu(Book[] books)
    {
        System.out.println("\n\t-------BOOK SELECTION--------");
        System.out.println("\t1 to " + (books.length) + "> Select a book from the previous list");
        System.out.println("\t0> Go back.");
        System.out.println("\t-----------------------------");
        System.out.print("\nSelect option and Enter> ");
        int option = input.nextInt();
        input.nextLine();
        while(!(option >= 0 && option <= books.length)) // TODO: DeMorgan
        {
            System.out.println("\n\t******Invalid option*****");
            System.out.println("\n\t-------BOOK SELECTION--------");
            System.out.println("\t1 to " + (books.length) + "> Select a book from the list");
            System.out.println("\t0> Go back.");
            System.out.println("\t-----------------------------");
            System.out.print("\nSelect option and Enter> ");
            option = input.nextInt();
            input.nextLine();
        }
        if(option == 0){
            return null;
        } else {
            System.out.println("\n\\\\\\\\");
            System.out.println("\nBook selected:\n" + books[(option-1)]);
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
        System.out.println("\n\\\\\\\\");
        System.out.println("\nBOOK TITLE SEARCH");
        System.out.print("Enter search term> ");
        searchTerm = getValidString();
        Book[] results = searchBookTitle(searchTerm);
        if(results.length == 0)
        {
            System.out.println("\t-----------------------------");
            System.out.println("\tSorry, no results for  " + searchTerm); 
            System.out.println("\t-----------------------------");
        }
        else
        {
            for(int i=0; i < results.length; i++) //list of results
            {
                System.out.print("\n" + (i+1) + "> ");
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

            System.out.println("\t-----------------------------");
            System.out.println("\tNo books need reordering at the moment."); 
            System.out.println("\t-----------------------------");
        }
        else
        {
            System.out.println("\t-----------------------------");
            System.out.println("\tThe following books are low on stock and need reordering: ");
            System.out.println("\t-----------------------------");
            for(int i=0; i < results.length; i++) //list of results
            {
                System.out.print("\n" + (i+1) + "> ");
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
        System.out.println("\n\\\\\\\\");
        System.out.println("\nBOOK SALE");
        System.out.println("Number of copies to sell> ");
        int amount = getValidInRange(1, selected.getStock()); 
        if(selected.getStock() < amount)
        {
            System.out.println("\n\t******Not enough copies!******");
        } else{
            selected.sellCopy(amount); 
            saleInvoice(selected, amount);
        }

    }

    public void saleInvoice(Book selected, int amount)
    {  
        double bookVat = 0.20;
        System.out.println("\n\\\\\\\\");
        System.out.println("\nSALE INVOICE");
        System.out.println("Item: " + selected.getTitle());
        System.out.println("Number of copies: " + amount);
        System.out.println("Price per copy: " + selected.getPrice());
        System.out.println("Total price (including VAT): " + ((selected.getPrice() * (bookVat + 1)) * amount)); 

    }

    public void changeBookPrice(Book selected)
    {
        System.out.println("\n\\\\\\\\");
        System.out.println("\nCHANGE BOOK PRICE");
        System.out.println("This book's present price is " + selected.getPrice() + "€.");
        System.out.print("Enter new price> ");
        double newPrice = getValidMinimum(0.0);
        if(newPrice < 0)
        {
            System.out.println("\n\t****** Invalid! Prices must be at least 0.00 (free books) or higher.*****");
        } 
        else
        {
            selected.changePrice(newPrice);
            System.out.println("The new price of " + selected.getTitle() + 
                " is " + selected.getPrice() + "€.");
        }
    }

    public void takeBookDelivery(Book selected)
    {
        System.out.println("\n\\\\\\\\");
        System.out.println("\nBOOK DELIVERY");
        //validate for negatives
        System.out.print("Number of copies to add> ");
        int amount = input.nextInt();
        input.nextLine();
        if(amount < 1)
        {
            System.out.println("\n\t******To restock this book, take delivery of 1 or more books.*****");
        } 
        else
        {
            selected.takeDelivery(amount);
            System.out.println("\nNew amount in stock: " + selected.getStock());
        }

    }

    //DISPLAY method(s)
    public void displayBooks()
    {
        for(int i=0; i < bookList.length; i++)
        {
            System.out.println();
            System.out.print((i+1) + "> ");
            bookList[i].display();
        }
    }

    //Validation methods
    public String getValidString()
    {
        String testInput = input.nextLine();
        testInput = testInput.trim();
        while (testInput.isEmpty()) 
        {
            System.out.println("\t*****Please don't leave this field blank!*****");
            System.out.print("Type and enter again> ");
            testInput = input.nextLine();
            testInput = testInput.trim();
        }
        return testInput;
    }

    public int getValidMinimum(int minimum)
    {
        int testInput = input.nextInt();
        input.nextLine();
        while (testInput < minimum) 
        {
            System.out.println("\t*****Minimum: " + minimum + "*****");
            System.out.print("Type and enter again> ");
            testInput = input.nextInt();
            input.nextLine();
        }
        return testInput;
    }

    public double getValidMinimum(double minimum)
    {
        double testInput = input.nextDouble();
        input.nextLine();
        while (testInput < minimum) 
        {
            System.out.println("\t*****Minimum: " + minimum + "*****");
            System.out.print("Type and enter again> ");
            testInput = input.nextDouble();
            input.nextLine();
        }
        return testInput;
    }

    public int getValidInRange(int minimum, int maximum)
    {
        int testInput = input.nextInt();
        input.nextLine();
        while ((testInput < minimum) || (testInput > maximum))
        {
            System.out.println("\t*****Number must be between: " + minimum + " and " + maximum + "*****");
            System.out.print("Type and enter again> ");
            testInput = input.nextInt();
            input.nextLine();
        }
        return testInput;
    }

    public static void main(String[] args)
    {
        new Bookshop();
    }
}
