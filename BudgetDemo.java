package assignments;
//-------------------------------------------------------
//Assignment 4
//For COMP 248 Section 2222-R – Fall 2022
//--------------------------------------------------------
//Importing the scanner so that the user can input using his keyboard after opening the scanner
import java.util.Scanner;

public class BudgetDemo {

	public static void main(String[] args) {
		//This program allows the user to manage funds and expenses of different households.
		//It lets him add funds, remove expenses, add expenses, change the due date of an expense
		//it also lets him compare different househouldbudget's breakdown funds and expenses.
		//It also lets him view the the funds and expenses of each household.
		Scanner keyIn = new Scanner(System.in);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
				+ "\nWelcome to the COMP248 Geek's HouseholdBudget_2022 Application\n"
				+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// creating the funds of each householdbudget and the expenses
		Fund HouseholdBudget0 = new Fund(0, 1, 0, 2, 1);
		Fund HouseholdBudget1 = new Fund(0, 1, 0, 2, 1);
		Fund HouseholdBudget2 = new Fund(2, 0, 2, 1, 1);
		Fund HouseholdBudget3 = new Fund(2, 1, 2, 1, 5);
		Fund HouseholdBudget4 = new Fund(2, 1, 2, 1, 5);
		Expense[] h0expense = new Expense[2];
		h0expense[0] = new Expense("Purchase", 85.5, "IGA", 25, 11);
		h0expense[1] = new Expense("Bill", 122.75, "Videotron", 2, 12);
		Expense[] h1expense = new Expense[2];
		h1expense[0] = new Expense("Purchase", 85.5, "IGA", 25, 11);
		h1expense[1] = new Expense("Bill", 16.2, "Costco", 23, 11);
		Expense[] h2expense = new Expense[3];
		h2expense[0] = new Expense("Purchase", 50.75, "Pharmaprix", 01, 12);
		h2expense[1] = new Expense("Purchase", 16.2, "TheBay", 16, 12);
		h2expense[2] = new Expense("Bill", 65.85, "Fido", 5, 1);
		Expense[] h3expense = new Expense[0];
		Expense[] h4expense = new Expense[0];
		HouseholdBudget[] households = new HouseholdBudget[5];
		int hindex = households.length - 1;
		int expense_number;
		//creation of 5 householdbudget object
		households[0] = new HouseholdBudget(HouseholdBudget0, h0expense);
		households[1] = new HouseholdBudget(HouseholdBudget1, h1expense);
		households[2] = new HouseholdBudget(HouseholdBudget2, h2expense);
		households[3] = new HouseholdBudget(HouseholdBudget3, h3expense);
		households[4] = new HouseholdBudget(HouseholdBudget4, h4expense);
		boolean isboolean = true;
		//loops through the menu 
		while (isboolean) {
			System.out.println("\nWhat would you like to do?\n" + " 1. See the possessions of all householdBudgets\n"
					+ " 2. See the possessions of one householdBudget\n"
					+ " 3. List householdBudgets with same total amount of fund\n"
					+ " 4. List householdBudgets with same fund denomination(s)\n"
					+ " 5. List householdBudgets with same total amount of fund and same number of expenses\n"
					+ " 6. Add an expense to an existing householdBudget\n"
					+ " 7. Remove an existing expense from a householdBudget\n"
					+ " 8. Update the payment due date of an existing expense\n" + " 9. Add fund to a householdBudget\n"
					+ " 0. To quit\n");
			System.out.print("\nPlease enter your choice and press <Enter>: ");
			int code = keyIn.nextInt();
			switch (code) {
			//displays the fund and expenses of each householdbudget
			case 1: {
				System.out.println("\nContent of each HouseholdBudget:\n" + "---------------------");
				for (int i = 0; i < households.length; i++) {
					System.out.println("\nHouseholdBudget #" + i + ": ");
					//uses the toString method in HouseholdBudget class
					System.out.print(households[i]);
				}
				break;
			}
			case 2: {
				// asks the user which householdBudget they wish to see the content of and display the fund and expenses(s) info for that householdBudget
				System.out.print("Which HouseholdBudget you want to see the possessions of? (Enter number 0 to " + hindex + "): ");
				//uses my method in the HouseholdBudget class to loop through the code and uses the toString to print
				System.out.println(households[HouseholdBudget.LoopCode()]);
				break;
			}
			// Compares all housholdBudgets and display those pairs that have the same total fund value
			case 3: {
				System.out.println("List of HouseholdBudgets with same total fund:\n");
				// case code 3 of my method
				System.out.println(HouseholdBudget.ForLoop(3, households));
				break;
			}
			//Compare all householdBudgets and display the pairs that have the same fund distribution
			case 4: {
				System.out.println("List of HouseholdBudgets with same fund:\n");
				// case code 4 of my method
				System.out.println(HouseholdBudget.ForLoop(4, households));
				break;
			}
			//List all householdBudgets pairs that are equal based on the definition of equal in the class HouseholdBudget
			case 5: {
				System.out.println("List of HouseholdBudgets with same amount of money and same number of expenses: \n");
				// case code 5 of my method
				System.out.println(HouseholdBudget.ForLoop(5, households));
				break;
			}
			//Ask the user which householdBudget they want to add an expense to and its information, it creates the new expense
			// and adds it to the householdbudget
			case 6: {
				System.out.print("Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to " + hindex + "): ");
				//uses my method in the HouseholdBudget class to loop through the code
				HouseholdBudget.LoopCode();
				System.out.print("Please enter the following information so that we may complete the expense-\n" + " --> Type of expense (Bill, Purchase, etc ..): ");
				String addType = keyIn.next();
				System.out.print(" --> Amount of the expense: ");
				double addAmount = keyIn.nextDouble();
				System.out.print(" --> Name of the Business: ");
				String addBusiness = keyIn.next();
				System.out.print(" --> Payment due day number and month (seperate by a space): ");
				int addDay = keyIn.nextInt();
				int addMonth = keyIn.nextInt();
				//uses getter in the HouseholdBudget class to get the code he entered to see the household at that index
				System.out.print("You now have "+ households[HouseholdBudget.getCode()].AddExpenses(addType, addAmount, addBusiness, addDay, addMonth)+ " expense\n");
				break;
			}
			//Asks the user which householdBudget they want to remove an expense from, as well as the expense index they want removed, and removes it from the householdBudget
			case 7: {
				System.out.print("Which HouseholdBudget do you want to remove an Expense from? (Enter number 0 to " + hindex + "): ");
				HouseholdBudget.LoopCode();
				//the case where the household has no expenses
				if ((households[HouseholdBudget.getCode()].NumberOfExpenses()) == 0)
					System.out.println("Sorry that HouseholdBudget has no expenses");
				else {
					HouseholdBudget.LoopCode2(code, households);
					if (households[HouseholdBudget.getCode()].RemoveExpense(HouseholdBudget.getExpense_Number()) == true) {
						System.out.println("Expense was removed successfully");
					}
				}
				break;
			}
			//Ask the user which expense from which householdBudget they want to update
			case 8: {
				System.out.print("Which HouseholdBudget do you want to update an Expense from? (Enter number 0 to " + hindex + "): ");
				HouseholdBudget.LoopCode();
				if ((households[HouseholdBudget.getCode()].NumberOfExpenses()) == 0)
					System.out.println("Sorry that HouseholdBudget has no expenses");
				else {
					HouseholdBudget.LoopCode2(code, households);
					//uses the newDate method to update the new due date
					System.out.print("--> Enter new payment due day number and month (seperate by a space): ");
					int newDay = keyIn.nextInt();
					int newMonth = keyIn.nextInt();
					households[HouseholdBudget.getCode()].NewDate(HouseholdBudget.getExpense_Number(), newDay, newMonth);
					System.out.println("Due Date updated.");
				}
				break;
			}
			//lets the user add funds to the householdbudget
			case 9: {
				System.out.print("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to " + hindex + "): ");
				HouseholdBudget.LoopCode();
				System.out.print("How many loonies, toonies,$5,$10 and $20 bill do you want to add?\nEnter 5 numbers seperated by a space): ");
				int loonies = keyIn.nextInt();
				int toonies = keyIn.nextInt();
				int five = keyIn.nextInt();
				int ten = keyIn.nextInt();
				int twenty = keyIn.nextInt();
				//adds the fund to the householdbudget the user wanted
				households[HouseholdBudget.getCode()].addFund(loonies, toonies, five, ten, twenty);
				System.out.println("You now have " + '$'+ households[HouseholdBudget.getCode()].TotalValue());
				break;
			}
			//to exit the program
			case 0: {
				isboolean = false;
				System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
			}
				break;
				//when the user enters an invalid input
			default: {
				System.out.println("Sorry this is not a valid choice. Try again.");

			}
			}
		}
		keyIn.close();

	}

}
