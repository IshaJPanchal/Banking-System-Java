import java.util.*;
class Detials
{
	static String branch="Borivali";
	static String bank="MUMBAI BANK";
	static String ifsc="MUMB000058";
	
}

class Account extends Detials
{
	protected int accountNumber;
	protected float accountBalance;
	protected String accountHolder;
	protected String name,surname,middleName;
}


class Bank extends Account
{
		public Bank(int count)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Account Holder details:-");
		System.out.print("First name : ");
		name=sc.next();
		System.out.print("Middle name : ");
		middleName=sc.next();
		System.out.print("Last name : ");
		surname=sc.next();
		accountHolder=name+" "+middleName+" "+surname;
		accountHolder=accountHolder.toUpperCase();
		accountNumber=count;
		System.out.println("Minimum balance to be kept = 1000");
		accountBalance=0;
		do
		{
			System.out.print("Deposit amount = ");
			accountBalance=sc.nextFloat();
		}while(accountBalance<1000);
		System.out.println("Account "+accountNumber+" Successfully created for "+accountHolder);
		System.out.println("Account balance = "+accountBalance);	
	}
	public void updateName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(accountNumber+ "\t"+accountHolder);
		System.out.println("Account Holder details:-");
		System.out.print("First name : ");
		name=sc.nextLine();
		System.out.print("Middle name : ");
		middleName=sc.nextLine();
		System.out.print("Last name : ");
		surname=sc.nextLine();
		accountHolder=name+" "+middleName+" "+surname;
		accountHolder=accountHolder.toUpperCase();
		System.out.println("Account "+accountNumber+" Name updated to "+accountHolder);
	}
	public void deposit()
	{
		float amount;
		System.out.print("Enter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		amount=sc.nextFloat();
		accountBalance = accountBalance + amount;
		System.out.println(amount+ " credited successfully to account number "+accountNumber+", updated account balance is "+accountBalance);
	}
	public boolean checkName(String str)
	{
		if(accountHolder.equals(str)) return true;
		else return false;
	}
	public void withdraw()
	{
		float amount;
		System.out.println("Balance = "+accountBalance+"\tMaintain minimum balance of 1000");
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("Enter amount to withdraw : ");
			amount=sc.nextFloat();
		}while(amount>accountBalance-1000);
		accountBalance = accountBalance - amount;
		System.out.println(amount+ " debited successfully from account number "+accountNumber+", updated account balance is "+accountBalance);
	}
	public void checkBalance()
	{
		System.out.println("A/c "+accountNumber+"\n"+accountHolder+"\nAccount Balance : "+accountBalance+"\n");
	}


	public void showaccountdetails()
	{
		System.out.println("Account Number:"+accountNumber);
		System.out.println("Account Holder:"+accountHolder);
		System.out.println("Balance:"+accountBalance);
		System.out.println("Branch:"+branch);
		System.out.println("IFSC Code:"+ifsc);
		System.out.println("Bank:"+bank);				
	}

}

public class Banking
{
	public static void main(String args[])
	{
		int i,choice,count,copy;
		String str,str1;
		count=0;
		Scanner sc = new Scanner(System.in);
		Bank b[] = new Bank[100];
		do
		{
			System.out.println("\n1 : Add account\n2 : Change account holder name\n3 : Deposit\n4 : Withdraw\n5 : Check account balance\n6 : Show account details\n7 : exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: count=count+1;
					b[count-1] = new Bank(count);
					break;
				case 2: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].updateName();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].updateName();
					}
					break;
				case 3: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].deposit();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].deposit();
					}
					break;
				case 4: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].withdraw();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].withdraw();
					}
					break;
				case 5: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						copy=copy-1;
						b[copy].checkBalance();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].checkBalance();
					}
					break;
				case 6: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].showaccountdetails();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].showaccountdetails();
					}
					break;
				case 7:break;
			}
		}while(choice!=7);
	}
} 