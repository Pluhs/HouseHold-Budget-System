package assignments;
//-------------------------------------------------------
//Assignment 4
//Written by: Mohammed Al assad, 40252007
//For COMP 248 Section 2222-R – Fall 2022
//--------------------------------------------------------
public class Expense {
	//the different attributes
	//private to promote encapsulation
	private String type;
	private double amount;
	private String name_business;
	private int due_month;
	private int due_day;
	//default constructor
	public Expense() {
		type = "";
		amount = 0;
		name_business = "";
		due_month = 0;
		due_day = 0;
	}
	//constructor with paremeters
	public Expense(String t, double a, String n, int d, int m) {
		type=t;
		amount=a;
		name_business=n;
		if (d<1 || d>31)
			d = 0;
		if (m<1 || m>12)
			m = 0;
		due_day=d;
		due_month=m;
		
	}
	//copy constructor
	public Expense(Expense expense) {
		type = expense.type;
		amount = expense.amount;
		name_business = expense.name_business;
		due_month = expense.due_month;
		due_day = expense.due_day;
	}
	//accessors
	public String getType() {
		return this.type;
	}
	public double getAmount() {
		return this.amount;
	}

	public String getName_Business() {
		return this.name_business;
	}
	public int getDue_Day() {
		return this.due_day;
	}
	public int getDue_Month() {
		return this.due_month;
	}
	//mutators for due_day and due_month
	public void setDue_Month(int m) {
		if (m<1 || m>12)
			m = 0;
		due_month = m;
	}
	public void setDue_Day(int d) {
		if (d<1 || d>31)
			d = 0;
		due_day = d;
	}
	//returns a string indicating the type of the expense, the name of the business and the due date
	public String toString() {
		//turned day and month into strings so I can add a 0 for the formatting when needed
		String day = Integer.toString(due_day);
		String month = Integer.toString(due_month);
		if (due_day >0 && due_day <10)
			day = '0'+day;
		if (due_month >0 && due_month <10) 
			month = '0'+month;
		if (type == "")
			return "No Expenses";
		else return type + " - " + "$" + amount+" - " + name_business + " - " + day +"/"+month;
	}
	//compares if two expenses are identical to each other
	//did not do equalsIgnoreCase, because it was not asked to do so!
	public boolean equals(Expense expense) {
		return (this.type.equals(expense.type) && this.amount == expense.amount && this.name_business.equals(expense.name_business) && this.due_day == expense.due_day && this.due_month == expense.due_month);
	}
}
