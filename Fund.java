package assignments;
//-------------------------------------------------------
//Assignment 4
//Written by: Mohammed Al assad, 40252007
//For COMP 248 Section 2222-R – Fall 2022
//--------------------------------------------------------
public class Fund {
	// variables to track how many of each cash type each household has
	// private to promote encapsulation
	private int nLoonies;
	private int nToonies;
	private int nBill_5;
	private int nBill_10;
	private int nBill_20;
	// constants for values of each cash type
	//public because they're constant and can't be modified
	// static variable to be used in a static method
	public static final int LOONIES = 1;
	public static final int TOONIES = 2;
	public static final int BILL_5 = 5;
	public static final int BILL_10 = 10;
	public static final int BILL_20 = 20;

	// default constructor
	public Fund() {
		AddFund(0, 0, 0, 0, 0);
	}

	// constructor with parameters to set the number of each fund type the household owns
	public Fund(int l, int t, int f, int ten, int tw) {
		AddFund(l, t, f, ten, tw);
	}

	// copy constructor
	public Fund(Fund fund) {
		nLoonies = fund.nLoonies;
		nToonies = fund.nToonies;
		nBill_5 = fund.nBill_5;
		nBill_10 = fund.nBill_10;
		nBill_20 = fund.nBill_20;
	}

	// accessors
	public int getnLoonies() {
		return this.nLoonies;
	}

	public int getnToonies() {
		return this.nToonies;
	}

	public int getnBill_5() {
		return this.nBill_5;
	}

	public int getnBill_10() {
		return this.nBill_10;
	}

	public int getnBill_20() {
		return this.nBill_20;
	}

	// mutators
	public void setnLoonies(int nLoonies) {
		this.nLoonies = nLoonies;
	}

	public void setnToonies(int nToonies) {
		this.nToonies = nToonies;
	}

	public void setnBill_5(int nBill_5) {
		this.nBill_5 = nBill_5;
	}

	public void setnBill_10(int nBill_10) {
		this.nBill_10 = nBill_10;
	}

	public void setnBill_20(int nBill_20) {
		this.nBill_20 = nBill_20;
	}

	// to increase the number of each fund type
	public void AddFund(int l, int t, int f, int ten, int tw) {
		nLoonies += l;
		nToonies += t;
		nBill_5 += f;
		nBill_10 += ten;
		nBill_20 += tw;
	}

	// to get the total fund possed by the household
	public double FundTotal() {
		int total = nLoonies * LOONIES + nToonies * TOONIES + nBill_5 * BILL_5 + nBill_10 * BILL_10
				+ nBill_20 * BILL_20;
		return total;
	}

	// to print the breakdown of each cash type
	public String toString() {
		return "(" + nLoonies + " x $1) + (" + nToonies + " x $2) + (" + nBill_5 + " x $5) + (" + nBill_10
				+ " x $10) + (" + nBill_20 + " x $20)";
	}

	// to compare to find equal fund breakdown of different households
	public boolean equals(Fund fund) {
		return (this.nLoonies == fund.nLoonies && this.nToonies == fund.nToonies && this.nBill_5 == fund.nBill_5
				&& this.nBill_10 == fund.nBill_10 && this.nBill_20 == fund.nBill_20);
	}
}
