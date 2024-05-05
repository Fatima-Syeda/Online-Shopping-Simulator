//Import libraries
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.*;


public class MyStore {

	//Create global scanner class and scanner object
	static Scanner s = new Scanner(System.in);

	/**
	 * Displays the title of the program 
	 *
	 */

	public static void programTitle() {

		//(Got Ascii art from "text to Ascii art generator")
		System.out.println( "   ,___                                  __                      ");
		System.out.println( "  /   /                    o            ( /  / o   o       /     ");
		System.out.println( " /      _   __ , , , _ _  ,  _ _   _,    /--/ ,   ,  __,  /   (  ");
		System.out.println( "(___/  / (_(_)(_(_/_/ / /_(_/ / /_(_)_  /  /_ (__/|_(_/(_/_) /_)_");
		System.out.println( "                                   /|            /)              ");
		System.out.println( "                                  (/            (/               ");

		System.out.println();
		System.out.println();

	}// programTitle()
	
	/**
	 * Displays thank you message 
	 *
	 */

	public static void exitMessage() {

		//(Got Ascii art from "text to Ascii art generator")
		System.out.println("~~|~~|             |                   /~\\             '  ' | '            /~~                  '           |  |'   '    |     |"); 
		System.out.println("  |  |/~\\ /~~||/~\\ |_/  \\  //~\\|   |  -|- /~\\|/~\\  \\  /|(~|~|~||/~\\ /~~|  |   |/~\\/~\\\\    /|/~\\ ||/~\\ /~~|  |--||   |/~~||~~\\(~|"); 
		System.out.println("  |  |   |\\__||   || \\   \\/ \\_/ \\_/|   |  \\_/|      \\/ |_)| | ||   |\\__|   \\__|   \\_/ \\/\\/ |   |||   |\\__|  |  ||   |\\__||__/_)."); 
		System.out.println("                        _/                                          \\__|                              \\__|       \\__|           "); 

		System.out.println();
		System.out.println();

	}// programTitle()

	/** 
	 * Displays the headings in the program
	 * 
	 * @param heading Title to display
	 */

	public static void displayHeading(String heading) {

		//Initialize variables
		String underLine = "";
		System.out.println();

		//Display heading
		System.out.println(heading);

		//Make the underLine as long as the heading is
		for(int i = 0; i <heading.length(); i++){
			underLine+="=";
		}//end for

		//Display the underline
		System.out.println(underLine);

	}//displayTitle(String)

	/** 
	 * Taken from Mr. Milardovic's Useful methods, ICS 4UC OneNote 
	 * Used with permission. 
	 * Wait for user to Enter y or n. 
	 * 
	 * It will let the user Enter anything, but it will convert it to lower case 
	 * and then take the first character, checking if it is a 'y' or an 'n'. 
	 * @param prompt Question to ask the user
	 * @return char Answer of either 'y' or 'n'. 
	 */ 

	public static char getYorN(String prompt) { 
		char answer; 

		while (true) { 

			System.out.print(prompt);

			// reads a line, converts it to lower case, and takes 
			// the first character and stores it in answer 
			answer = s.nextLine().toLowerCase().charAt(0); 

			// get out if valid entry 
			if (answer == 'y' || answer == 'n') 
				break; 

			// otherwise give error message 
			System.out.println("Please Enter y or n."); 
		} // end while 

		// sends back the value of answer 
		return answer; 

	} //char getYorN() 

	/**
	 * makes sure sure Enters a valid option
	 *
	 * @param String prompt Prompt to display to the user
	 * @param int opt1 Starting number of option to choose from
	 * @param int opt2 Ending number of option to choose from
	 *
	 * @return int opt, the option the user Enters
	 */

	public static int validOpt(String prompt,int opt1, int opt2) {
		int opt;

		//Ask for choice
		System.out.print(prompt);
		//Error trap response
		while (true) {
			opt = s.nextInt();
			if (opt >= opt1 && opt <= opt2) {
				break;
			}//end if

			//Display error message
			System.out.println();
			System.out.printf("Please Enter a valid option between %d and %d: ", opt1, opt2);

		}// end while

		s.nextLine();
		//Return option
		return opt;
	}// int validOpt(String,int,int)

	

	/**
	 * Displays the invoice
	 * 
	 * @param nameBought Array(string) of the names of items bought
	 * @param priceBought Array(double) of the prices of the items bought
	 * @param qtyBought Array(int) of the quantity of the items bought
	 * 
	 */
	public static double displayInvoice(ArrayList<String>nameBought,ArrayList<Double>priceBought, ArrayList<Integer>qtyBought){
		//Declare variables
		double subTotal = 0;
		double HST;
		double total=0;
		double totalItemCost;
		
		//(Got Ascii art from "text to Ascii art generator")
		System.out.println( "                                _____                 _          ");
		System.out.println("                                \\_   \\_ ____   _____ (_) ___ ___ ");
		System.out.println( "                                 / /\\| '_ \\ \\ / / _ \\| |/ __/ _ \\");
		System.out.println( "                              /\\/ /_ | | | \\ V | (_) | | (_|  __/");
		System.out.println( "                              \\____/ |_| |_|\\_/ \\___/|_|\\___\\___|");
		
		
		System.out.println();
		System.out.println("CROWNING HIJABS");
		System.out.println("45 Pinebush Avenue");
		System.out.println("Cambridge, ON, N2R 3L7");
		System.out.println("crowning.hijabs@gmail.com");
		System.out.println();
		
		//Source: Miguel Closa
		System.out.printf("Date: %s\n", LocalDate.now());
		System.out.printf("Time: %s\n", LocalTime.now());
		
		//Display the headings for the invoice
		System.out.println();
		System.out.printf("%-30s %20s %20s %20s \n", "Item:","Quantity:", "Unit Price($):","Total:");
		System.out.println("================================================================================================");

		//Loop through the arrayList and calculate the costs
		for(int i = 0; i < nameBought.size();i++){

			//calculate the total cost of each item
			totalItemCost = priceBought.get(i) * qtyBought.get(i);

			//Keep track of the subTotal
			subTotal +=totalItemCost;

			//Display the items, quantity purchased, individual and total cost of each item
			System.out.printf("%-30s %20d %20.2f %20.2f \n", nameBought.get(i), qtyBought.get(i), priceBought.get(i), totalItemCost);
			System.out.println("------------------------------------------------------------------------------------------------");
		}//end for

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();


		//Calculate & Display all charges formatted
		HST = subTotal*0.13;
		total = subTotal + HST;

		System.out.printf("%75s $%15.2f \n","Sub Total: ", subTotal);
		System.out.printf("%75s $%15.2f \n","HST: ", HST);
		System.out.printf("%75s $%15.2f \n","Total: ", total);


		//return total
		return total;
	}//displayInvoice(ArrayList<String>, ArrayList<Double>,ArrayList<Integer>)

	/*
	 * Lets user know about each menu option
	 * 
	 */

	public static void help() {
		displayHeading("Help");
		System.out.println();
		System.out.println("Press [Enter] to view info for 1st menu option...");
		s.nextLine();
		//Display menu options and information about each

		displayHeading("Initiate Purchase");
		System.out.println("This menu option allows you to search for items");
		System.out.println("in the store and add items to cart if you wish to");
		System.out.println("purchase them.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to view info for 2nd menu option...");
		s.nextLine();

		displayHeading("Administrative Options");
		System.out.println("This menu option allows the admin to modify the items");
		System.out.println("in the store by first entering the correct password.");
		System.out.println("The admin can also change the password.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to view info for 3rd menu option...");
		s.nextLine();

		displayHeading("JIT Inventory Monitor");
		System.out.println("This menu option allows you to view all the items");
		System.out.println("and the quantity of each item left in the store.");
		System.out.println("If the quantity of any item is at or below its JIT");
		System.out.println("trigger amount, that item is displayed in red.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to view info for 4th menu option...");
		s.nextLine();

		displayHeading("Session Sales Amount");
		System.out.println("This menu option allows you to view the total amount ");
		System.out.println("of money transacted for the day as well as the total money");
		System.out.println("made by the store since the program first started.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to view info for 5th menu option...");
		s.nextLine();

		displayHeading("Help");
		System.out.println("This menu option gives you information about");
		System.out.println("each menu option. This is where you are currently at.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to view info for 6th menu option...");
		s.nextLine();
		

		displayHeading("Exit Program");
		System.out.println("This menu option allows you to search for items");
		System.out.println("in the store and add items to cart if you wish to");
		System.out.println("purchase them.");
		System.out.println();
		System.out.println();
		System.out.println("Press [Enter] to return to main menu...");
		s.nextLine();

	}//help()

	/*
	 * Displays the dollar value of how much was transacted for the day
	 * and the grand total since the program started
	 * 
	 */

	public static void sessionSales()throws IOException{

		//Declare variables
		double dailyValue;
		double grandTotal;
		char rollOver;
		PrintWriter out;
		BufferedReader in;

		//Display Heading
		displayHeading("Session Sales");

		//open the sales-daily file to read 
		in = new BufferedReader(new FileReader("sales-daily.txt"));

		//Store the amount of money in the sails-daily file to a variable
		dailyValue = Double.parseDouble(in.readLine());

		//Close file
		in.close();

		//Open the sales-total file to read 
		in = new BufferedReader(new FileReader("sales-total.txt"));

		//Store the amount of money in the sails-daily file to a variable
		grandTotal = Double.parseDouble(in.readLine());

		//Close file
		in.close();


		//Display the amounts
		System.out.printf("%-30s $%10.2f\n","Today's Total Transactions: ",dailyValue);
		System.out.printf("%-30s $%10.2f\n","Grand Total: ",grandTotal);
		System.out.println();

		//Ask user if they want to roll over to a new day
		rollOver = getYorN("Would you like to 'roll over' to a new day (y/n)? ");

		//If user Enters 'y'
		if(rollOver=='y') {

			//Add dailyValue to the sales total value
			out = new PrintWriter(new FileWriter("sales-total.txt"));
			out.printf("%.2f",grandTotal+dailyValue);

			//Close file
			out.close();

			//Clear the sales daily file
			out = new PrintWriter(new FileWriter("sales-daily.txt"));
			out.printf("%.2f",0.00);

			//Close file
			out.close();
		}//end if


	}//sessionSales()


	/*
	 * Displays all the items with the quantities remaining
	 * Displays item in red if the quantity of item is at or below
	 * the jitTrigger amount.
	 * 
	 * @param items Array of objects that contains my product
	 */

	public static void JITMonitor(MyProduct[]items) throws InterruptedException{

		//Display the headings
		displayHeading("JIT Inventory Monitor");
		
		System.out.println("Items low in stock will be printed in red.");
		System.out.println();
		System.out.println();
		
		System.out.printf("%-30s %20s  \n", "Item Name:","Quantity:");
		System.out.println("==================================================================================");
		
		
		
		//loop through the items 
		for(int i = 0; i<items.length; i++){
			
			//Allows delay
			System.err.flush();
			System.out.flush();
			Thread.sleep(200);
			

			//Check if the quantity left of an item it or below the jitTrigger amount
			if(items[i].getQty()<= items[i].getJIT()){

				//Print the item and quantity left in red
				System.err.printf("%-30s %20d\n",items[i].getName(),items[i].getQty());
					
			}//end if

			//Else print the name and quantity of item normally(not in red)
			else{
				System.out.printf("%-30s %20d\n",items[i].getName(),items[i].getQty());
				

			}//end else
			System.out.println("--------------------------------------------------------------------------------");
			
			
		}//end for

		System.out.println();
		System.out.println("Press [Enter] to continue...");
		s.nextLine();
	}//vJITMonitor(MyProduct[])


	/*
	 * Allows user to select one of the object from the list and
	 * change any variables
	 * 
	 * @param items Array of objects that contains my product
	 */

	public static void administrativeOptions( MyProduct[] items)throws IOException{
		int itemChoice;
		int changeVar;
		String name;
		double price;
		String colour;
		int qty;
		String description;
		String origin;
		int JIT;
		String pwd;
		String validPwd;
		int adminOpt;
		int tries;

		System.out.println();
		System.out.println();

		while(true) {
			//Read in valid password from file
			BufferedReader in = new BufferedReader(new FileReader("AdminPass.txt"));
			validPwd = in.readLine();


			//Display heading and options for user
			displayHeading("Administrative Options");

			System.out.println("1-Enter Password");
			System.out.println("2-Change Password");
			System.out.println("0-Return to main menu");

			System.out.println();

			//Store user's choice in a variable
			adminOpt=validOpt("Enter choice: ",0,2);
			System.out.println();

			//If they enter 0, return to main menu
			if(adminOpt==0) {
				break;
			}//end if

			if(adminOpt ==2) {

				//Get user to enter new password and save to file
				System.out.print("Enter New Password: ");

				PrintWriter newPwd = new PrintWriter(new FileWriter("AdminPass.txt"));
				newPwd.println(s.nextLine());

				//Close file
				newPwd.close();

				System.out.println();
				System.out.println("Password Changed Successfully");
			}//end if

			if(adminOpt == 1) {
				
				//Reset number of tries
				tries = 3;
				
				//Get user to enter password and error trap
				System.out.print("Enter password: ");

				while(true) {
					pwd = s.nextLine();
					
					//Keep track of tries left
					tries-=1;
					
					//break if user enters correct password within 3 tries
					if(pwd.equals(validPwd)|| tries==0) {
						break;
					}//end if

					
					//Source: Stack overflow
					//Link: https://stackoverflow.com/questions/7166328/when-why-to-call-system-out-flush-in-java
					System.out.flush();
					System.err.flush();
					
					//Display error message 
					System.out.println();
					System.err.println("Incorrect Password!");
					System.out.printf("%d tries left\n",tries);
					System.out.println();
					System.out.print("Try again: ");
					

				}//end while

				//If password entered is correct, allow admin to make changes
				if(pwd.equals(validPwd)) {
					while(true) {

						displayHeading("List of all items in the store");

						//Display all the items to the user
						for(int i = 0; i<items.length;i++) {
							System.out.printf("%d. %s\n",i+1,items[i].getName());
						}//end for

						System.out.println();
						//Ask them which item why want to modify

						//Call method to get a valid input from the user
						System.out.println("Which item would you like to make changes to?");
						itemChoice = validOpt("Enter number matching the item or 0 to return to Admin Options: ",0,20);

						//If they enter 0, return to main menu
						if(itemChoice==0) {
							break;
						}//end if

						System.out.println();
						System.out.println();

						//When user picks an item to modify, display the items information
						displayHeading("Item #"+itemChoice);
						System.out.println(items[itemChoice-1].toStringAdmin());
						System.out.println();

						while(true) {
							//Display the variable they can change 
							displayHeading("Variables to Modify:");
							System.out.println();
							System.out.printf("%4d -> %-50s \n",1,"Change Name");
							System.out.printf("%4d -> %-50s \n",2,"Change Price");
							System.out.printf("%4d -> %-50s \n",3,"Change Colour");
							System.out.printf("%4d -> %-50s \n",4,"Change Quantity");
							System.out.printf("%4d -> %-50s \n",5,"Change Description");
							System.out.printf("%4d -> %-50s \n",6,"Change Origin");
							System.out.printf("%4d -> %-50s \n",7,"Change JIT Trigger");
							System.out.printf("%4d -> %-50s \n",0,"To view all items list");
							System.out.println();


							//ask them which variable they want to modify
							changeVar = validOpt("Which of the variables would you like to change? ",0,7);
							System.out.println();

							//If user enters 0, break out of loop
							if(changeVar==0) {
								break;
							}//end if


							//Call the method to change the variables based on what variable the user chooses to change
							if(changeVar==1) {
								//Get user to Enter a new name
								System.out.printf("Enter new name for item #%d: ",itemChoice);
								name = s.nextLine();
								System.out.println();

								//Set the name of the items chosen to the new name the user enters
								items[itemChoice-1].setName(name);

								System.out.printf("Name of item #%d changed to %s.\n", itemChoice,name);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());

							}//end if

							if(changeVar==2) {
								//Get user to Enter a new price
								System.out.printf("Enter new price for item #%d: ",itemChoice);
								
								while(true){
								price = s.nextDouble();
								
								if(price>0){
									break;
								}//end if
								
								System.out.println();
								System.out.print("Please enter a valid price:");
								}//end while
								
								//Set the price of the item chosen to the new price the user Enters
								items[itemChoice-1].setPrice(price);

								System.out.printf("Price of item #%d changed to %.2f.\n", itemChoice,price);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());


							}//end if

							if(changeVar==3) {
								//Get user to Enter a new colour
								System.out.printf("Enter new colour for item #%d: ",itemChoice);
								colour = s.nextLine();
								System.out.println();

								//Set the colour of the item chosen to the new colour the user Enters
								items[itemChoice-1].setColour(colour);

								System.out.printf("Colour of item #%d changed to %s.\n", itemChoice,colour);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());


							}//end if

							if(changeVar==4) {
								//Get user to Enter a new quantity
								System.out.printf("Enter new quantity for item #%d: ",itemChoice);
								
								while(true){
								qty = s.nextInt();
								
								if(qty>0){
									break;
								}//end if
								
								System.out.println();
								System.out.print("Please enter a valid quantity:");
								}//end while
								//Set the name of the items chosen to the new name the user Enters
								items[itemChoice-1].setQty(qty);

								System.out.printf("Quantity of item #%d changed to %d.\n", itemChoice,qty);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());



							}//end if

							if(changeVar==5) {
								//Get user to Enter a new description
								System.out.printf("Enter new description for item #%d: ",itemChoice);
								description = s.nextLine();
								System.out.println();

								//Set the description of the items chosen to the new description the user Enters
								items[itemChoice-1].setDescription(description);

								System.out.printf("Description of item #%d changed to %s.\n", itemChoice,description);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());

							}//end if

							if(changeVar==6) {
								//Get user to Enter a new origin
								System.out.printf("Enter new origin for item #%d: ",itemChoice);
								origin = s.nextLine();
								System.out.println();

								//Set the origin of the items chosen to the new origin the user Enters
								items[itemChoice-1].setOrigin(origin);

								System.out.printf("Origin of item #%d changed to %s.\n", itemChoice,origin);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());
							}//end if

							if(changeVar==7) {
								//Get user to Enter a new JIT Trigger
								System.out.printf("Enter new JIT Trigger for item #%d: ",itemChoice);
								
								while(true){
								JIT = s.nextInt();
								
								if(JIT>0){
									break;
								}//end if
								
								System.out.println();
								System.out.print("Please enter a valid JIT Trigger Amount:");
									
								}//end while
								
								//Set the JIT Trigger of the items chosen to the new JIT Trigger the user Enters
								items[itemChoice-1].setJIT(JIT);

								System.out.printf("Jit Trigger of item #%d changed to %d.\n",itemChoice,JIT);
								System.out.println();
								System.out.println(items[itemChoice-1].toStringAdmin());
							}//end if

							//Allow for pause
							System.out.println();
							System.out.println("Press [Enter] to continue...");
							s.nextLine();
						}//end while

						//Write back to the items file to update the information changed
						//Open file to write
						PrintWriter out = new PrintWriter(new FileWriter("itemsList.csv"));

						//Loop through the item array
						for(int i = 0; i<items.length;i++) {
							out.println(items[i].toCSV());
						}//end for

						//close file
						out.close();
					}//end while
				}//end if 
			}//end if

		}//end while (main)

	}// administrativeOptions(MyProduct[])


	/**
	 * Allows user to initiate a purchase
	 * 
	 *
	 * @param items array of objects that contains my product
	 * 
	 */

	public static void initiatePurchase(MyProduct[] items)throws IOException{
		//Initialize and declare variables
		int count = 0;
		String searchName;
		int validItem = 0;
		int qtyBought = 0;
		double runningTotal=0;
		double grandRunningTotal=0;
		double dailyTotal;
		String itemBought;


		PrintWriter out;
		BufferedReader in;


		//create three arrayLists for the name, price and quantity purchased of an item
		ArrayList<String> nameBought= new ArrayList<String>();
		ArrayList<Double> priceBought= new ArrayList<Double>();
		ArrayList<Integer> quantityBought= new ArrayList<Integer>();

		//Create an arrayList to store the index of items found
		ArrayList<Integer> indexItemsFound= new ArrayList<Integer>();

		//Create an arrayList to store all the items
		ArrayList<String> itemsFound= new ArrayList<String>();

		//Display the heading
		displayHeading("INITIATE PURCHASE");

		//In a loop ask user which item they want to purchase
		while(true){

			//reset count and clear the arrays that store items and the index
			count = 0;
			itemsFound.clear();
			indexItemsFound.clear();

			System.out.println();
			System.out.print("Search for item or press [Enter] to view invoice: ");
			searchName = s.nextLine();

			//If user presses Enter, break
			if(searchName.equals(""))
				break;

			//Loop through the array of objects and check if the 
			//search matches any item name
			for(int i = 0; i < items.length;i++){

				//If the search matches the item name:
				if(items[i].contains(searchName)){

					//Add the index of item from the items array to an arrayList
					indexItemsFound.add(i);

					//Add 1 to count
					count++;

					//Print the items found
					itemsFound.add(items[i].getName());
				}//end if
			}// end for

			//Display the number of items found
			System.out.println();
			System.out.printf("%d item%s found.%n%n",count,(count==1?"":"s"));


			//If items are found/count does not equal 0
			if(count!=0) {

				//Start Loop
				while(true) {
					System.out.println();
					System.out.println();

					//Display the items found
					for(int i = 0; i <itemsFound.size();i++) {
						System.out.printf("%d. %s\n",i+1,itemsFound.get(i));
					}//end for

					System.out.println();

					//Give customer the options when presented with the list of items
					System.out.println("Options:");
					System.out.println("--------");
					System.out.println();
					System.out.printf("%4d -> %-50s \n",-1,"To get description of a product");
					System.out.printf("%4d -> %-50s \n",0,"To return back to search");
					System.out.printf("%4s -> %-50s \n","1-"+count,"Enter number matching the product to add to cart");
					System.out.println();


					//Call validVal to make sure user Enters the right options
					validItem = validOpt("Enter your choice: ",-1,count);

					//If user Enters -1, ask them which product they want the description of 
					if(validItem == -1) {
						System.out.println();
						validItem = validOpt("Please enter the number matching the product to get the description: ",1,count);

						System.out.println();
						System.out.println();

						displayHeading("Item #"+validItem);

						System.out.println();

						//Display the information of the item picked
						System.out.println(items[indexItemsFound.get(validItem-1)].toString());
					}//end if

					System.out.println();
					System.out.println("Press [Enter] to continue...");
					s.nextLine();



					//If user Enters 0, break out of loop
					//to return back to search
					if(validItem == 0){
						break;
					}//end if

					//If they Enter a number matching the item, store it in a arrayList
					else{

						//Store the name of the item in a variable
						itemBought = items[indexItemsFound.get(validItem-1)].getName();

						//Ask them how much of the item they want to buy and error trap
						// to check if it's in stock
						System.out.printf("How many %ss would you like to buy? ",itemBought);


						//Error trap quantity as user cannot buy more then there is in stock
						while(true){

							qtyBought = s.nextInt();

							//Check if the quantity of that item is greater than or equal to how much the customer wants to buy
							if(qtyBought >= 0 && qtyBought <= items[indexItemsFound.get(validItem-1)].getQty()){
								break;
							}//end if

							

							//Display error message
							System.out.println();
							System.out.printf("Sorry you cannot buy more than %d of this item.\n",items[indexItemsFound.get(validItem-1)].getQty());
							System.out.println();
							System.out.print("Please Enter a valid quantity: ");

						}//end while; error trap for valid qtyBought

						s.nextLine();


						//If user Enters 0, it will not add it to cart
						if(qtyBought>0) {

							//If User buys an item, display that it has been added to cart
							System.out.println();
							System.out.printf("%d %s%s added to cart.",qtyBought,itemBought,(qtyBought==1?"":"s"));
							System.out.println();

							System.out.println();
							System.out.println("Press [Enter] to continue...");
							s.nextLine();

							//Set the quantity by subtracting how much the user 
							//wants to buy from the original quantity
							int qtyOriginal  = items[indexItemsFound.get(validItem-1)].getQty();
							items[indexItemsFound.get(validItem-1)].setQty(qtyOriginal-qtyBought);

							//Store the name, price and quantity of items bought into their arrays
							nameBought.add(items[indexItemsFound.get(validItem-1)].getName());
							priceBought.add(items[indexItemsFound.get(validItem-1)].getPrice());
							quantityBought.add(qtyBought);

							//Write back to the items file to update the quantity of items
							//Open file to write
							out = new PrintWriter(new FileWriter("itemsList.csv"));

							//Loop through the item array
							for(int i = 0; i<items.length;i++) {
								out.println(items[i].toCSV());
							}//end for

							//close file
							out.close();

						}//end if
					}//end else

				}//end while
			}//end if (count!=0)
		}// end while

		//Call the method to display the invoice
		runningTotal = displayInvoice(nameBought,priceBought,quantityBought);

		//Keep track of the running total for the day
		grandRunningTotal+=runningTotal;

		//Open the sales-daily text file to read the value saved
		in = new BufferedReader(new FileReader("sales-daily.txt"));

		//Store the amount of money in the sails-daily file to a variable
		dailyTotal = Double.parseDouble(in.readLine());

		//Close file
		in.close();

		//Add grandRunningTotal to the dailyTotal value stored in the file
		dailyTotal+=grandRunningTotal;

		//Save the updated dailyTotal to the sales-daily.txt file
		out = new PrintWriter(new FileWriter("sales-daily.txt"));
		out.printf("%.2f",dailyTotal);

		//Close file
		out.close();

		//Allow for a pause
		System.out.println();
		System.out.print("Press [Enter] to continue...");
		s.nextLine();

	}//initiatePurchase(MyProduct[])

	public static void main(String[] args)throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int opt;

		//Create variable for the data in object
		String data;

		//declare the array of MyStore objects with 20 items
		MyProduct[] items = new MyProduct[20];

		//Read object from file into the array
		BufferedReader in = new BufferedReader(new FileReader("itemsList.csv"));

		for(int i = 0; i <items.length;i++){
			data = in.readLine();
			items[i] = new MyProduct(data);
		}//end for

		in.close();

		//Display Store name and welcome message
		programTitle();
		displayHeading("Welcome to Crowning Hijabs!");


		//Print a small message for the user to use instruction manual
		System.out.println("Please read the user manual provided if ");
		System.out.println("you are confused or need help navigating");
		System.out.println("through this virtual store at any time.");

		System.out.println();
		System.out.println("Press [Enter] to view the main menu...");
		s.nextLine();

		while(true){
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			//Display the menu
			System.out.println("MAIN MENU:");
			System.out.println("==========");
			System.out.println();
			System.out.println("1 - Initiate a Purchase");
			System.out.println("2 - Administrative Options");
			System.out.println("3 - JIT Inventory Monitor");
			System.out.println("4 - Session Sales Amount");
			System.out.println("5 - Help");
			System.out.println("6 - Exit Program");
			System.out.println();
			System.out.println();

			//Call the valid option method to make sure user chooses a valid option
			opt = validOpt("Enter your menu option choice: ",1, 6);
			System.out.println();
			System.out.println();

			//Call the methods based on what option user chooses

			//If option is 1, call initiatePurchase
			if (opt == 1) {
				initiatePurchase(items);
			}//end if

			//If option is 2, call administrativeOptions
			else if (opt == 2) {
				administrativeOptions(items);
			}//end else if

			//If option is 3, call JITmonitor
			else if (opt == 3) {
				JITMonitor(items);
			}// end else if

			//If option is 4, call SessionSales
			else if(opt == 4) {
				sessionSales();
			}//end else if

			//If option is 5, call help
			else if (opt == 5){
				help();
			}//end else if

			//Otherwise, break out of loop
			else{
				break;
			}//end else*/

		}//end while

		//Display thank you message
		exitMessage();
	}//end main




}//end class
