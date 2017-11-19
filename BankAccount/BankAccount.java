
/**
 * Lab sheet 1 - extra work
 *
 * @catarinalou
 * @v1 18/Set/2018
 */
public class BankAccount
{
    // PSVMA
    // void - data type - returns void - method returns nothing
    // main is the name of this method, needs to be "main" to be executable
    public static void main(String[] args)
    {
        // initialise variables
        String accountName;
        String accountNumber;
        double accountBalance;
        double deposit;
        double withdrawal;
        
        // assign values
        accountName = "Barbara Bravo";
        accountNumber = "123ABC9-Z";
        accountBalance = 2838;
        
        deposit = 1000;
        withdrawal = 253.6;
        
        // display values
        System.out.println("Account holder's name: " + accountName + ".");
        System.out.println("Account number: " + accountNumber + ".");
        System.out.println("Current balance: " + accountBalance + "€.");
        
        System.out.println("New deposit amount: " + deposit + "€.");
        // update variable accountBalance
        accountBalance += deposit;
        System.out.println( accountName + ", your new account balance is " + accountBalance + "€.");
        
        System.out.println("New withdrawal: " + withdrawal + "€.");
        // update variable accountBalance
        accountBalance -= withdrawal;
        System.out.println( accountName + ", your new account balance is " + accountBalance + "€.");
        
    }

}
