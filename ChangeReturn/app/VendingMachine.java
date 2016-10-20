package change_return.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	public static void main(String args[]) {
		VendingMachine vm = new VendingMachine();
		Scanner scanner = new Scanner(System.in);
		boolean endProgramFlag = false;
		
		// prepare items to sell
		List<Item> itemList = new ArrayList<Item>();
		vm.prepareItem(itemList);
		
		// vending machine running
		while (!endProgramFlag) {
			// print out menu
			System.out.println("*********************************************");
			vm.printMenu(itemList);
			
			// take user input
			System.out.println("Enter your selection, press 0 to exit: ");
			int selection = scanner.nextInt();
			if (selection == 0) {
				endProgramFlag = true;
				break;
			}
			
			// validate input selection
			if (itemList.size() < selection) {
				System.out.println("No such item, transaction aborted.");
				continue;
			}
			
			// validate input cash format
			System.out.println("Enter your cash: ");
			double cash = scanner.nextDouble();
			if (!vm.validateCash(cash)){
				System.out.println("Cash not accepted, transaction aborted.");
				continue;
			}
			
			// calculate change return
			int[] change = vm.changeReturnCalculation(selection-1, itemList, cash);
			
			// change return
			if (change[0] == 1) {
				System.out.println("Transaction complelte, your change is: " +
						(change[1]==0 ? "" : change[1] + " of $25, ") + 
						(change[2]==0 ? "" : change[2] + " of $10, ") + 
						(change[3]==0 ? "" : change[3] + " of $5, ") + 
						(change[4]==0 ? "" : change[4] + " of $1, ") + 
						(change[5]==0 ? "" : change[5] + " of $0.25, ") + 
						(change[6]==0 ? "" : change[6] + " of $0.1, ") + 
						(change[7]==0 ? "" : change[7] + " of $0.01.") +
						(change[1]==0 && change[2]==0 && change[3]==0 
						 && change[4]==0 && change[5]==0 && change[6]==0 && change[7]==0 ? "0" : ""));
			} else if (change[0] == 2) {
				System.out.println("Not enough cash, transaction aborted.");
			} else if (change[0] == 3) {
				System.out.println("System error, transaction aborted.");
			}
		}
		scanner.close();
	}
	
	private void prepareItem(List<Item> itemList) {
		Item item1 = new Item(1, "soda", 5.50);
		Item item2 = new Item(2, "apple", 8.31);
		Item item3 = new Item(3, "book", 9.99);
		Item item4 = new Item(4, "earphone", 10.49);
		Item item5 = new Item(5, "pen", 15.25);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
	}
	
	private void printMenu(List<Item> itemList) {
		Iterator<Item> ite = itemList.iterator();
		while (ite.hasNext()){
			Item e = ite.next();
			System.out.println(e.getTag()+". "+e.getName()+": $"+e.getPrice());
		}
	}
	
	private int[] changeReturnCalculation(int selection, List<Item> itemList, double cash) {
		int[] change = new int[8];
		//0 - txn complete flag
		//1 - number of 25
		//2 - number of 10
		//3 - number of 5
		//4 - number of 1
		//5 - number of 0.25
		//6 - number of 0.1
		//7 - number of 0.01
		if (itemList.get(selection) != null) {
			double formattedPrice = toTwoDigits(itemList.get(selection).getPrice());
			double formattedCash = toTwoDigits(cash);
			if (formattedPrice <= formattedCash) {
				double changeReturn = toTwoDigits(formattedCash-formattedPrice);
				while (changeReturn>=25) {
					change[1]++;
					changeReturn-=25;
				}
				while (changeReturn>=10) {
					change[2]++;
					changeReturn-=10;
				}
				while (changeReturn>=5) {
					change[3]++;
					changeReturn-=5;
				}
				while (changeReturn>=1) {
					change[4]++;
					changeReturn-=1;
				}
				while (changeReturn>=0.25) {
					change[5]++;
					changeReturn = toTwoDigits(changeReturn-0.25);
				}
				while (changeReturn>=0.1) {
					change[6]++;
					changeReturn = toTwoDigits(changeReturn-0.1);
				}
				while (changeReturn>=0.01) {
					change[7]++;
					changeReturn = toTwoDigits(changeReturn-0.01);
				}
				change[0] = 1;
			} else {
				change[0] = 2;
			}
		} else {
			change[0] = 3;
		}
		return change;
	}
	private boolean validateCash(double cash) {
		if (cash<=0) {
			return false;
		}
		if (cash*100-(int)(cash*100/1) != 0) {  // not two digits
			return false;
		}
		return true;
	}
	private double toTwoDigits(double input) {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(input));
	}
}
