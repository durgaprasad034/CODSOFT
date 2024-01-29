package codsoft;

import java.util.Scanner;

//Class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         return true;
     } else {
         return false;
     }
 }
}

//Class to represent the ATM machine
class ATM {
 private BankAccount userAccount;

 public ATM(BankAccount userAccount) {
     this.userAccount = userAccount;
 }

 public void displayMenu() {
     System.out.println("\nATM Menu:");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void processOption(int option, Scanner scanner) {
     switch (option) {
         case 1:
             handleWithdrawal(scanner);
             break;
         case 2:
             handleDeposit(scanner);
             break;
         case 3:
             checkBalance();
             break;
         case 4:
             System.out.println("Exiting ATM. Thank you!");
             System.exit(0);
             break;
         default:
             System.out.println("Invalid option. Please choose a valid option.");
     }
 }

 private void handleWithdrawal(Scanner scanner) {
     System.out.print("Enter the amount to withdraw: ");
     double amount = scanner.nextDouble();

     if (userAccount.withdraw(amount)) {
         System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
     } else {
         System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
     }
 }

 private void handleDeposit(Scanner scanner) {
     System.out.print("Enter the amount to deposit: ");
     double amount = scanner.nextDouble();

     userAccount.deposit(amount);
     System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
 }

 private void checkBalance() {
     System.out.println("Current balance: " + userAccount.getBalance());
 }
}

public class ATM_Interface {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter initial balance: ");
     double initialBalance = scanner.nextDouble();

     BankAccount userAccount = new BankAccount(initialBalance);
     ATM atm = new ATM(userAccount);

     while (true) {
         atm.displayMenu();
         System.out.print("Choose an option (1-4): ");
         int option = scanner.nextInt();

         atm.processOption(option, scanner);
     }
 }
}

