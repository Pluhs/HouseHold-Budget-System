package assignments;
//-------------------------------------------------------
//Assignment 4
//For COMP 248 Section 2222-R – Fall 2022
//--------------------------------------------------------
import java.util.Scanner;

public class HouseholdBudget {
	//attributes, type Fund to hold cash breakdown and Expense[] to hold expenses
	//private to promote encapsulation
	private Fund fund;
	private Expense[] expenses;
	// code and expense_number is used for my own methods
	private static int code;
	private static int expense_number;
	// default constructor
	public HouseholdBudget() {
		fund = new Fund();
		expenses = new Expense[0];
	}
	// constructor with 2 parameters
	public HouseholdBudget(Fund f, Expense[] e) {
		expenses = new Expense[e.length];
		fund = f;
		if (e.length == 0)
			expenses = null;
		else
			for (int i = 0; i < e.length; i++)
				expenses[i] = e[i];
	}
	//accessors and mutators
	public static int getCode() {
		return code;
	}
	public static int getExpense_Number() {
		return expense_number;
	}
	public static void setExpense_Number(int e) {
		expense_number =e;
	}
	public static void setCode(int c) {
		code = c;
	}
	// returns a string clearly indicating number of each money type as well as the details of each expense of the householdBudget
	public String toString() {
		String s = "";
		if (expenses == null)
			return fund.toString() + "\nNo expenses\n";
		else
			for (int i = 0; i < expenses.length; i++) {
				s += expenses[i].toString() + "\n";
			}
		return fund.toString() + "\n" + s;
	}
	// compares the total value of the fund of two households
	public boolean equalTotal(HouseholdBudget householdbudget) {
		return (this.fund.FundTotal() == householdbudget.fund.FundTotal());
	}
	// compares the number of each fund type of two households
	public boolean equalFund(HouseholdBudget fund) {
		return (fund.fund.equals(this.fund));
	}
	// returns the totalvalue of fund of a household
	public double TotalValue() {
		return fund.FundTotal();
	}
	// returns the number of expenses of the household
	public int NumberOfExpenses() {
		if (expenses == null)
			return 0;
		else
			return expenses.length;
	}
	// makes a new array with incremented size to add the new expense
	// this method has 5 parameters to let the user implement the info needed for the expense
	public int AddExpenses(String t, double a, String n, int d, int m) {
		Expense[] temp;
		// if the household had initially no expenses, it create an array for it
		if (expenses == null) {
			temp = new Expense[1];
			temp[0] = new Expense(t, a, n, d, m);
		} else {
			temp = new Expense[expenses.length + 1];
			for (int i = 0; i < expenses.length; i++)
				temp[i] = expenses[i];
			temp[expenses.length] = new Expense(t, a, n, d, m);
		}
		expenses = temp;
		return expenses.length;
	}
	// makes a new array with 1 less element
	//once the user decides to which index to remove the code will ignore that index when copying the old array to the new array
	public boolean RemoveExpense(int m) {
		Expense[] temp = new Expense[expenses.length - 1];
		for (int i = 0, j = 0; i < expenses.length; i++) {
			if (i != m) {
				temp[j++] = expenses[i];
			}
		}
		expenses = temp;
		return true;
	}
	// a method with 3 parameters to let the user update the due date of an expense
	//the i parameter is the index of the expense
	public void NewDate(int i, int d, int m) {
		expenses[i].setDue_Day(d);
		expenses[i].setDue_Month(m);
	}
	//a method that adds fund to the householdbudget, it will return the new total
	public double addFund(int l, int t, int f, int ten, int tw) {
		fund.AddFund(l, t, f, ten, tw);
		return fund.FundTotal();
	}
	// compares the total value of fund and the number of expenses of two household
	public boolean equals(HouseholdBudget h) {
		if (h.fund.FundTotal() == this.fund.FundTotal() && expenses == null && h.expenses == null)
			return true;
		else
			return (h.fund.FundTotal() == this.fund.FundTotal() && this.expenses.length == h.expenses.length);
	}
	// a method that displays the fund breakdown of a household
	public Fund DisplayFund() {
		return fund;
	}
	// static method used in the driver class to let that asks the user to enter the number of the household he wants
	//sample only showed if code > 4, and not an actual string
	public static int LoopCode() {
		Scanner keyIn = new Scanner(System.in);
		code = keyIn.nextInt();
		while (code < 0 || code > 4) {
			System.out.print("Sorry but there is no HouseholdBudget number " + code
					+ "\n--> Try again: (Enter number 0 to 4): ");
			code = keyIn.nextInt();
		}
		return code;
	}
	// a static method used in case 3,4,5 with that returns the string of the requested command
	public static String ForLoop(int code, HouseholdBudget[] arr) {
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (code == 3 && arr[i].equalTotal(arr[j])) {
					s += "\tHouseholdBudgets " + i + " and " + j + " both have " + arr[j].TotalValue() + "\n";
				} else if (code == 4 && arr[i].equalFund(arr[j])) {
					s += "\tHouseholdBudgets " + i + " and " + j + " both have "+arr[j].DisplayFund()+"\n";
				} else if (code == 5 && arr[i].equals(arr[j])) {
					s += "\tHouseholdBudgets " + i + " and " + j+"\n";
				}

			}
		}
		return s;
	}
	// a static method used in case 7 and 8 with that returns nothing
	public static void LoopCode2(int code, HouseholdBudget[] arr) {
		Scanner keyIn = new Scanner(System.in);
		if (code == 7)
		System.out.print("Which expense do you want to remove? (Enter number 0 to " + (arr[HouseholdBudget.getCode()].NumberOfExpenses()-1) + "): ");
		if (code == 8)
			System.out.print("Which expense do you want to update? (Enter number 0 to " + (arr[HouseholdBudget.getCode()].NumberOfExpenses()-1) + "): ");
		expense_number = keyIn.nextInt();
		//uses the getter to get the code the user entered for the right household and then finds the number of expenses it has
		while ((arr[HouseholdBudget.getCode()].NumberOfExpenses()-1) < expense_number) {
			System.out.println("Sorry but there is no expense number " + expense_number);
			System.out.print("--> Try again:" + "\n(Enter number 0 to "
					+ (arr[HouseholdBudget.getCode()].NumberOfExpenses()-1) + "): ");
			expense_number = keyIn.nextInt();
		}
	}
}
