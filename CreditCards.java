package labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreditCards 
{

	public static void main(String[] args) 
	{
		List<String[]> transactions = new ArrayList<String[]>();
		String filename = "/Users/Osayi/Desktop/Files/creditcards.csv";
		String dataRow;
		double balance = 0;
		
		try
		{
			//Open the file
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			while((dataRow = br.readLine()) != null)
			{
				//Parse the data
				String[] line = dataRow.split(",");
				//add data collection 
				transactions.add(line);
				
			}
			br.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		for(String[] transaction : transactions)
		{
			String date = transaction[0];
			String type = transaction[1];
			String vendor = transaction[2];
			double amount = Double.parseDouble(transaction[3]);
			System.out.println(date + " " + type + " " + vendor + " $" + amount);
			
			if(type.equalsIgnoreCase("credit"))
			{
				//System.out.println("Add to balance");
				balance = balance + amount;
			}
			else if(type.equalsIgnoreCase("debit"))
			{
				//System.out.println("Subtract from balance");
				balance = balance - amount;
			}
			else
			{
				System.out.println("Some other transaction");
			}
			System.out.print("New Balance: " + balance + "\n");
		}
		
		//Check balance
		if(balance > 0)
		{
			System.out.println("You have a balance of: " + balance);
			System.out.println("You are charged a 10% fee of: " + balance * .10);
			System.out.println("Your new balance is: " + balance * 1.1);
		}
		else if(balance < 0)
		{
			System.out.println("Thanks for your payment");
			System.out.println("You have an overpayment of - " + balance);
		}
		else
		{
			System.out.println("Thanks for your payment");
		}
	}

}
