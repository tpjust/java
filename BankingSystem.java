//Banking System 

import java.util.*;

// BankingAccount Interface
interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankingAccount targetAccount, double amount);
    double getBalance();
    String getAccountNumber();
    List<String> getTransactionHistory();
}

// AbstractBankingAccount Class
abstract class AbstractBankingAccount implements BankingAccount {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public AbstractBankingAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial deposit: $" + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrawal: $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transfer(BankingAccount targetAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            addTransaction("Transfer to Account " + targetAccount.getAccountNumber() + ": $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    protected void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

// SavingsAccount Class
class SavingsAccount extends AbstractBankingAccount {
    public SavingsAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// CheckingAccount Class
class CheckingAccount extends AbstractBankingAccount {
    public CheckingAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// BankingSystem Class
public class BankingSystem {
    private Map<String, BankingAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private int nextAccountNumber = 1;

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.run();
    }

    public void run() {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    viewTransactions();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account type (Savings/Checking): ");
        String accountType = scanner.nextLine().toLowerCase();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = Double.parseDouble(scanner.nextLine());

        BankingAccount account = null;
        String accountNumber = String.format("%05d", nextAccountNumber++);

        if (accountType.equals("savings")) {
            account = new SavingsAccount(accountNumber, initialDeposit);
        } else if (accountType.equals("checking")) {
            account = new CheckingAccount(accountNumber, initialDeposit);
        } else {
            System.out.println("Invalid account type. Account not created.");
            return;
        }

        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully! Account Number: " + account.getAccountNumber());
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    private void deposit() {
        BankingAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        }
    }

    private void withdraw() {
        BankingAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        }
    }

    private void transferFunds() {
        System.out.print("Enter source account number: ");
        String sourceAccountNumber = scanner.nextLine();
        BankingAccount sourceAccount = accounts.get(sourceAccountNumber);

        if (sourceAccount == null) {
            System.out.println("Invalid source account number.");
            return;
        }

        System.out.print("Enter target account number: ");
        String targetAccountNumber = scanner.nextLine();
        BankingAccount targetAccount = accounts.get(targetAccountNumber);

        if (targetAccount == null) {
            System.out.println("Invalid target account number.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        sourceAccount.transfer(targetAccount, amount);
        System.out.println("Transfer successful.");
    }

    private void viewTransactions() {
        BankingAccount account = getAccount();
        if (account != null) {
            System.out.println("Transaction History for Account " + account.getAccountNumber() + ":");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
        }
    }

    private BankingAccount getAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankingAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
        }
        return account;
    }
}

