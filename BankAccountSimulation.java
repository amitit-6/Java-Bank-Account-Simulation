import java.util.Scanner;
import java.util.ArrayList;

class Account{
	
	private String accountHolder;
	private int accountNumber;
	private double balance;
	private ArrayList<String> transactionHistory;

	public Account(String accountHolder, int accountNumber){
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = 0.0;
		this.transactionHistory = new ArrayList<>();
		transactionHistory.add("Account created with initial balance: Rs 0.0 ");
	}

	public void deposit(double amount){
		if(amount <= 0){
			System.out.println("Deposit amount must be greater than zero.");
			return;
		}
		balance = balance + amount;
		transactionHistory.add("Deposited: Rs " + amount + " | Balance: Rs " + balance);
        	System.out.println("Rs " + amount + " deposited successfully.");
	}
	public void withdraw(double amount){
		if(amount <= 0){
			System.out.println("Withdrawal amount must be greater than zero.");
			return;
		}

		if(amount > balance){
			System.out.println("Insufficient balance!");
			return;
		}
		balance = balance - amount;	
		transactionHistory.add("Withdrew: Rs " + amount + " | Balance: Rs " + balance);
		System.out.println("Rs " + amount + " withdrawn successfully.");
	}
		
	public void viewBalance(){
		System.out.println("Current Balance : Rs "+balance);
	}

	public void viewTransactionHistory(){
		System.out.println("\n--- Transaction History ---");
		for(String transaction : transactionHistory){
			System.out.println(transaction);
		}
	}
		
	public void displayAccountInfo(){
		System.out.println("Account Holder : "+ accountHolder);
		System.out.println("Account Number : "+ accountNumber);
		viewBalance();
	}
}

public class BankAccountSimulation{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n*** Bank Account Simulation ***");
		
		System.out.print("\nEnter Account Holder Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Account Number : ");
		int accNumber = sc.nextInt();
	
		Account account = new Account(name, accNumber);
		int choice;
		
		do{
			System.out.println("\n=== Bank Menu ===");
			System.out.println("1. View Account Info");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. View Transaction History");
			System.out.println("5. Exit");
	
			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();	
			
			switch(choice){
				case 1 : 
					account.displayAccountInfo();
					break;
				
				case 2: 
					System.out.print("\nEnter Deposit Amount : Rs ");
					double depositAmt = sc.nextDouble();
					account.deposit(depositAmt);
					break;
				
				case 3: 
					System.out.print("\nEnter Withdraw Amount : Rs ");
					double withdrawAmt = sc.nextDouble();
					account.withdraw(withdrawAmt);
					break;

				case 4:
					account.viewTransactionHistory();
					break;
					
				case 5:
					System.out.println("Thank you using our banking service!");
					break;

				default:
					System.out.println("Invalid choice. Please Try again!");
			}		
		}while(choice != 5);
		sc.close();
	}
}
