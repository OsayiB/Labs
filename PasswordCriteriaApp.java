package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordCriteriaApp 
{

	public static void main(String[] args) 
	{
		String filename = "/Users/Osayi/Desktop/Files/Passwords.txt";
		File file = new File(filename);
		String[] passwords = new String[13];
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(int i = 0; i<passwords.length; i++)
			{
				passwords [i] = br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: File cannot be found");
			
		}
		catch(IOException e)
		{
			System.out.println("ERROR: Could not read file");
		}
		for(String password : passwords)
		{
			System.out.println("*******\n " + password);
			boolean hasNumber = false;
			boolean hasLetter = false;
			boolean hasSpecialChar = false;
			for(int n =0; n < password.length(); n++)
			{
				//Valid Passwords
				//1. a number
				if("0123456789".contains(password.substring(n,n+1)))
				{
					hasNumber = true;
					//System.out.println("Position " + n + " contains a number ");
				}
				//2. a letter
				else if("abcdefghijklmnopqrsuvwxyz".contains(password.substring(n, n+1).toLowerCase()))
				{
					hasLetter = true;
					//System.out.println("Position " + n + " contains a letter ");
				}
				//3. a special character
				else if("@#$%*{}=;+-_.".contains(password.substring(n,n+1)))
				{
					hasSpecialChar = true;
					//System.out.println("Position " + n + " contains a special character ");
				}
				
			}
			//Test and Exception handling
			try
			{
				if(!hasNumber)
				{
					throw new NumberCriteriaException(password);
				}
				else if(!hasLetter)
				{
					throw new LetterCriteriaException(password);
				}
				else if(!hasSpecialChar)
				{
					throw new SpecialCharacterException(password);
				}
				else
				{
					System.out.println("Valid password");
				}
					
			}
			catch(NumberCriteriaException | LetterCriteriaException | SpecialCharacterException e)
			{
				System.out.println("Invalid password");
				System.out.println(e.toString());
			}
		}
		
	}

}


class InvalidCharacterException extends Exception
{
	String ch;
	public InvalidCharacterException(String ch)
	{
		this.ch =ch;
	}
	
	public String toString()
	{
		return "InvalidCharacterException: " + ch;
	}
}

class NumberCriteriaException extends Exception
{
	String password;
	public NumberCriteriaException(String password)
	{
		this.password = password;
	}
	public String toString()
	{
		return "NumberCriteriaException: " + password;
	}
}

class LetterCriteriaException extends Exception
{
	String password;
	public LetterCriteriaException(String password)
	{
		this.password = password;
	}
	public String toString()
	{
		return "LetterCriteriaException: " + password;
	}
}

class SpecialCharacterException extends Exception
{
	String password;
	public SpecialCharacterException(String password)
	{
		this.password = password;
	}
	public String toString()
	{
		return "SpecialCharacterException: " + password;
	}
}

