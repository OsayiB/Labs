package labs;

public class BankAccountApp 
{

	public static void main(String[] args) 
	{
		BankAccount acc1 = new BankAccount("123456789", 1000);
		BankAccount acc2 = new BankAccount("639874489", 3000);
		BankAccount acc3 = new BankAccount("837264323", 4500);
		
		acc1.setName("Joe");
		System.out.println(acc1.getName());
		acc1.makeDeposit(500);
		acc1.makeDeposit(400);
		acc1.payBill(600);
		acc1.accrue();
		System.out.println(acc1.toString());

	}
}
class BankAccount implements IInterest
{
	//Properties of bank account
	private static int iD = 1000;
	private String accountNumber;
	private static final String routingNumber = "004578230";
	private String name;
	private String SSN;
	private double balance;
	
	
	//Constructor
	public BankAccount(String ssn, double initDeposit)
	{
		balance = initDeposit;
		this.SSN = ssn;
		iD++;
		setAccountNumber();
	}
	
	private void setAccountNumber()
	{
		int random = (int) (Math.random()* 100);
		accountNumber = iD + "" + random + SSN.substring(0,2);
		System.out.println("Your Account Number: " + accountNumber);
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void payBill(double amount)
	{
		balance = balance - amount;
		System.out.println("Make a payment: " + amount);
		showBalance();
	}
	public void makeDeposit(double amount)
	{
		balance = balance + amount;
		System.out.println("Make a deposit: " + amount);
		showBalance();
	}
	
	public void showBalance()
	{
		System.out.println("Balance: " + balance);
	}

	@Override
	public void accrue() 
	{
		balance = balance * (1+ rate/100);
		showBalance();
		
	}
	
	@Override
	public String toString()
	{
		return "[ Name: " + name + " ]\n[Account Number: " + accountNumber + " ]\n" + "[Routing Number: " + routingNumber + "]\n" + "[Balance: " + balance + " ]";
	}
	
}


