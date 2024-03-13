abstract class Account 
{
    protected long balance = 0; // default values randomly given 0

    public Account(long balance) 
    {
        this.balance = balance;
    }

    public void deposit(long amount) 
    {
        balance += amount;
    }

    public abstract void withdraw(long amount);

    public long getBalance() 
    {
        return balance;
    }

    public void setBalance(long balance) 
    {
        this.balance = balance;
    }
}

class SavingsAccount extends Account 
{
    public SavingsAccount(long balance) 
    {
        super(balance);
    }

    @Override
    public void withdraw(long amount) 
    {
        if (balance >= amount) 
        {
            balance = balance - amount;
        } 
        else 
        {
            System.out.println("Error: Not Enough Money in Bank Account");
        }
    }

    public void setBalance(long balance) 
    {
        this.balance = balance;
    }

    public long getBalance() 
    {
        return balance;
    }
}

class CheckingAccount extends Account 
{
    private long overdraftLimit = 100; // random, can be changed later by getter and setters etc

    public CheckingAccount(long balance, long overdraftLimit) 
    {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(long amount) 
    {
        if (balance + overdraftLimit >= amount) 
        {
            balance -= amount;
        } 
        else 
        {
            System.out.println("Only, " + (balance + overdraftLimit) + " is available to withdraw. You cannot withdraw " + amount + " from your account.");
        }
    }

    public long getOverdraftLimit() 
    {
        return overdraftLimit;
    }

    public void setOverdraftLimit(long overdraftLimit) 
    {
        this.overdraftLimit = overdraftLimit;
    }

    public long getBalance() 
    {
        return balance;
    }

    public void setBalance(long balance) 
    {
        this.balance = balance;
    }
}

class BankOperations {
    public void transferFunds(Account fromAccount, Account toAccount, long amount) 
    {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

public class l227971_Lab06_q1 {
    public static void main(String[] args) 
    {
        Account savings = new SavingsAccount(1200);
        Account checking = new CheckingAccount(1000, 100);

        // checking balance
        System.out.println("(Newly Created) Savings Account Balance: " + savings.getBalance());
        System.out.println("(Newly Created) Checking Account Balance: " + checking.getBalance());

        BankOperations bankOperations = new BankOperations();
        bankOperations.transferFunds(savings, checking, 50);

        System.out.println("New balances are below:\n");
        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }
}