
/**
 * Write a description of class BankAccount2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankAccount2
{
    // Class members - properties (data) of an instance - itt, properties that define a banking account
    String accountName;
    String accountNumber;
    double accountBalance;
    String accountDate;
    int numberOfDeposits;
    
    // Constructor
    public BankAccount2(String name, String id, double initialBalance) {
        this.accountName = name;
        this.accountNumber = id;
        this.accountBalance = initialBalance;
        this.accountDate = "TodayMonthYear"; // initialised internally
        this.numberOfDeposits = 0;
    }
    
    public void deposit(double deposit) {
        this.accountBalance += deposit;
        this.numberOfDeposits++;
    }
    
    public String accountDuration(){
        String today = "NewTodayDate";
        // String openForDays = today - this.accountDate;
        return "openForDays";
    }
    
    public static void main(String[] args)
    {
        BankAccount2 catarinaAccount = new BankAccount2("Catarina", "ID123", 0);
        System.out.println(catarinaAccount.accountName + " " + catarinaAccount.accountBalance);
        catarinaAccount.deposit(1000);
        System.out.println(catarinaAccount.accountName + " " + catarinaAccount.accountBalance);
        catarinaAccount.deposit(1500.10);
        System.out.println(catarinaAccount.accountName + " " + catarinaAccount.accountBalance);
        
        String accountOpenForDays = catarinaAccount.accountDuration();
        
    }
}
