import java.util.*;
abstract class Bank {
protected String name,temp;
protected float balance,withdraw,deposit;
protected int accno,choice;
protected long no;
abstract public void withdraw();
public void deposit() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
System.out.print("Enter amount to be deposited:");
deposit=sc.nextFloat();
balance=balance+deposit;
System.out.println("Deposited successfully!!");}
else System.out.println("Invalid entry!!");}

public void display() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
System.out.println("Account holder name:"+name+"\tAccount No.:"+accno+"\nContact No.:"+no+"\tBalance:"+balance);}
else System.out.println("Invalid entry!!");}

public void balance() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
System.out.println("Current balance :"+balance);}
else System.out.println("Invalid entry!!");}

public void edit() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
do {
System.out.println("Edit\n1.Name\n2.Contact number\n3.View details\n4.Exit\nEnter your choice:");
choice=sc.nextInt();
if(choice==1) {
System.out.print("Enter new name:");
this.accept();}
else if(choice==2) {
System.out.print("Enter new contact number:");
no=sc.nextLong();}
else if(choice==3) this.display();
else if(choice==4) break;
else System.out.println("Invalid choice");
}while(choice!=4);
}
else {
System.out.println("Invalid entry!!");
}
}

public void accept(){
Scanner sc=new Scanner(System.in);
name=sc.nextLine();}
}

class Saving extends Bank {
public Saving(){
Scanner sc=new Scanner(System.in);
System.out.print("Enter Account holder name:");
name=sc.nextLine();
System.out.println("Enter Account number displayed on the screen:");
accno=sc.nextInt();
System.out.print("Enter contact number:");
no=sc.nextLong();}
	
public void withdraw() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter Account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
System.out.print("Enter amount:");
withdraw=sc.nextFloat();
balance=balance-withdraw;
if(balance<0) {
balance=balance+withdraw;
System.out.println("Low balance! Current Balance="+balance+"\nWithdraw unsuccessfull!!");}
}
else System.out.println("Invalid entry!!");}
}

class Current extends Bank{
public Current() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter Account holder name:");
name=sc.nextLine();
System.out.println("Enter Account number displayed on the screen:");
accno=sc.nextInt();
System.out.print("Enter contact number:");
no=sc.nextLong();
System.out.println("Minimum balance of Rs. 1000 required");
this.deposit();}
	
public void withdraw() {
Scanner sc=new Scanner(System.in);
System.out.print("Enter account holder name:");
temp=sc.nextLine();
if(temp.equalsIgnoreCase(name)) {
System.out.print("Enter amount:");
withdraw=sc.nextFloat();
balance=balance-withdraw;
if(balance<=1000) {
balance=balance+withdraw;
System.out.println("Low balance! Current Balance="+balance+"\nWithdraw unsuccessfull!!");}
else {
System.out.println("Withdrawed Successfully!");}
}
else System.out.println("Invalid entry!!");}
}

public class BankAccountSystem {
public static void main(String[] args) {
int choice,i=0,j=0,ch,t;
Scanner sc=new Scanner(System.in);
Current c[]=new Current[100];
Saving s[]=new Saving[100];
do {
System.out.print("1.Create new account\n2.View details\n3Edit account info\n4.View Balance\n5.Withdraw\n6.Deposit\n7.Exit\nEnter your choice:");
choice=sc.nextInt();
switch(choice) {
case 1: System.out.print("1.Current Account\n2.Savings Account\nEnter your choice:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.println("Sr.No. ="+i);
	c[i]=new Current();
	i++;}
	else if(ch==2) {
	System.out.println("Sr.No. ="+j);
	s[j]=new Saving();
	j++;}
	else System.out.println("Invalid choice");
	break;
case 2: System.out.print("1.Current Account\n2.Savings Account\nEnter your Account type:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	c[t].display();}
	else if(ch==2) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	s[t].display();}
	else System.out.println("Invalid choice");
	break;
case 3: System.out.print("1.Current Account\n2.Savings Account\nEnter your Account type:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	c[t].edit();}
	else if(ch==2) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	s[t].edit();}
	else System.out.println("Invalid choice");
	break;
case 4: System.out.print("1.Current Account\n2.Savings Account\nEnter your Account type:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	c[t].balance();}
	else if(ch==2) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	s[t].balance();}
	else System.out.println("Invalid choice");
	break;
case 5: System.out.print("1.Current Account\n2.Savings Account\nEnter your Account type:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	c[t].withdraw();}
	else if(ch==2) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	s[t].withdraw();}
	else System.out.println("Invalid choice");
	break;
case 6: System.out.print("1.Current Account\n2.Savings Account\nEnter your Account type:");
	ch=sc.nextInt();
	if(ch==1) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	c[t].deposit();}
	else if(ch==2) {
	System.out.print("Enter Sr.No.:");
	t=sc.nextInt();
	s[t].deposit();}
	else System.out.println("Invalid choice");
	break;
case 7: break;
default:System.out.println("Invalid choice");
	break;}
}while(choice!=7);
}
}