package computers_store_project;

import java.util.Scanner;

public class Main {

	/**
	 * Displays the appropriate CLI menu depending on the user role.
	 *
	 * @param type "Employee" for service queue menu; "Manager" for warehouse operations menu.
	 */
	public static void PrintMenu(String type) {
		String a = type;
		if (a.equals("Employee")) {
			System.out.println(
					"========================================\n" +
							"              EMPLOYEE MENU              \n" +
							"========================================\n" 
							+"1. Is_costumers_getting_served?. \n" 
							+"2. Add costumer to line of costumers.\n"
							+"3. Search Customer in line. \n" 
							+"4. Remove costumer from line. \n"
							+ "5. Print the line of costumers. \n " 
							+"0. Back.\n" + "========================================\n" +
					"Please select an option:");
		}

		if (a.equals("Manager")) {
			System.out.println("========================================\n" +
					"              MANAGER MENU              \n" +
					"========================================\n" 
					+"1. Remove an existing employee from the Wearhouse\n" 
					+"2. Edit an Employee's data. \n" 
					+ "3. Add a new employee to the WearHouse\n"
					+ "4. add a new supplier to the Wearhouse\n" 
					+"5. Remove an existing supplier from the Wearhouse\n" 
					+"6. Add a new item to the warehouse from a supplier\n" 
					+"7. Update item stock / details\n" 
					+"8. Print all warehouse data (Inventory)\n" 
					+"9. Print all employees details\n" 
					+ "0. Back to Main Menu\n" +
					"========================================\n" 
					+ "Please select an option:");
		}
	}

	/**
	 * Counts and returns the number of digits in an integer.
	 *
	 * @param given_int Integer number to evaluate.
	 * @return Number of digits.
	 */
	public static int intLength(int given_int) {
		int temp = given_int;
		int counter = 0;
		do {
			temp /= 10;
			counter++;
		} while (temp != 0);
		return counter;
	}

	/**
	 * Validates and parses a 9-digit identification number string.
	 *
	 * @param input Raw ID string from user input.
	 * @return Parsed 9-digit integer, or -1 if invalid length.
	 */
	public static int HandleId(String input)
	{
		if(  input.length() != 9 ||  !input.matches("[0-9]+")) {
			System.out.println("The entered id formated incorrectly! \n" + "has to be 9 digits long!\n");
			return -1;
		}

		int id = Integer.parseInt(input);

		if(input.length() != 9)
		{
			System.out.println("The entered id formated incorrectly! \n" + "has to be 9 digits long!\n");
			return -1;
		}
		return id;

	}

	/**
	 * Validates that an input name follows the "Firstname Lastname" capitalized pattern 
	 * and stays within 1 to 70 characters using regular expressions.
	 *
	 * @param input Raw name string entered by user.
	 * @return Validated name string, or empty string if invalid.
	 */
	public static String HandleName(String input)
	{
		String name = input;
		if (name.length() > 70 ||  name.length() < 1)
		{
			System.out.println("The name  or too short! or too long");
			return "";
		}

		//we use a regex that do this:
		//[A-Z]+: One or more uppercase letters (forcing the first word to start with a capital letter).

		//[a-z]+: One or more lowercase letters (forcing the rest of the first word to be lowercase).

		//\s: Exactly one whitespace character (acting as the divider between the two words).

		//[A-Z]+: One or more uppercase letters (forcing the second word to start with a capital letter).

		//[a-z]+: One or more lowercase letters (forcing the rest of the second word to be lowercase).
		else if(name.matches("[A-Z][a-z]+\\s[A-Z][a-z]+"))
		{
			return name;
		}
		System.out.println("The name isnt formanted as First name + Last name! \n");
		return "";

	}

	/**
	 * Validates that a product type string is properly capitalized (e.g., "Keyboard", "Mouse").
	 *
	 * @param input Raw type string.
	 * @return Validated type string, or empty string if format is incorrect.
	 */
	public static String HandleType(String input)
	{
		if(input.length() <1) {
			System.out.println("The length is to short! \n");
			return "";
		}
		//Gaming Mouse
		String type = input;
		if(type.matches("[A-Z][a-z]+\\s[A-Z][a-z]+") || type.matches("[A-Z]+\\s[A-Z]+")
				|| type.matches("[A-Z][a-z]+"))
		{
			return type;
		}
		System.out.println("Wrong type format! \n");
		return "";
	}

	/**
	 * Validates and extracts a 10-digit phone number containing only numeric digits.
	 *
	 * @param input Raw phone number string from user input.
	 * @return Validated 10-digit phone number, or empty string if invalid.
	 */
	public static String HandlePhone(String input)
	{
		String phone = input;
		if(phone.length() != 10 || !phone.matches("[0-9]+"))
		{
			System.out.println("The phone numebr dosent fit the forment! need to be 10 digits exactly! \n");
			return "";
		}
		return phone;
	}

	/**
	 * Validates that a company name starts with an uppercase letter followed by lowercase letters.
	 *
	 * @param input Raw company name string from user input.
	 * @return Validated company name, or empty string if format is incorrect.
	 */
	public static String HandleCompeny(String input)
	{
		if(input.length() < 1)
		{
			System.out.println("The length is too short! \n");
			return "";
		}
		//Tech Source TECH SOURCE Asus ASUS
		String compeny = input;
		if(compeny.matches("[A-Z][a-z]+\\s[A-Z][a-z]+") || compeny.matches("[A-Z]+") 
				|| compeny.matches("[A-Z]+\\s[A-Z]+")|| compeny.matches("[A-Z][a-z]+"))
		{
			return compeny;
		}
		System.out.println("The compeny didnt match the format of capital latter and than lower case latters");
		return "";
	}

	/**
	 * Parses and validates a product price string, ensuring it does not exceed 1000.0.
	 *
	 * @param input Raw price string (e.g., "499.90").
	 * @return Parsed price as Double, or -1.0 if greater than 1000.0.
	 */
	public static Double HandlePrice(String input)
	{
		double price = Double.parseDouble(input);
		if(price <= 1000.0)
		{
			return price;
		}
		System.out.println("The price cant be above 1000.0 \n");
		return -1.0;
	}

	/**
	 * Parses and validates warranty duration in months, ensuring it does not exceed 36 months.
	 *
	 * @param input Raw warranty string in months.
	 * @return Parsed warranty integer, or -1 if greater than 36.
	 */
	public static int HandleWarranty(String input)
	{
		int warranty = Integer.parseInt(input);
		if(warranty > 36)
		{
			System.out.println("The warranty cant be above 36 monthes");
			return -1;
		}
		return warranty;
	}

	/**
	 * Parses and validates an employee's salary input, ensuring it is a non-negative number.
	 *
	 * @param input Raw salary string from user input.
	 * @return Parsed salary as Double, or -1.0 if negative.
	 */
	private static Double HandleSalery(String input) {
		Double salery = Double.parseDouble(input);
		if(salery < 0)
		{
			return -1.0;
		}
		return salery;

	}

	/**
	 * Parses and validates payment amount from a customer, ensuring it is at least 0.01.
	 *
	 * @param user_input Raw payment string from user input.
	 * @return Parsed payment amount, or 0.0 if less than 0.01.
	 */
	private static double HandlePayed(String user_input) {
		double pay = Double.parseDouble(user_input);
		if(pay < 0.0 ) {
			System.out.println("The amount payed cannot be negative! \n");
			return -1.0;
		}
		if(pay == 0.0) {
			System.out.println("The customer hasn't payed yet (0.0) \n");
		}
		return pay;
	}

	/**
	 * Placeholder / helper method intended to authenticate or verify an employee 
	 * exists in the warehouse before granting access.
	 *
	 * @param id Employee ID to verify.
	 * @param w  The store warehouse instance.
	 */
	public static Employee LoginEmployee(Scanner s,String input,Wearhouse w)
	{
		int id = HandleId(input);
		if(id == -1)
		{
			return null;
		}
		
		if(!w.Is_employee_in_array(id))
		{
			System.out.println("The Employee is not in the wearhouse,\n"
					+ " do you want to create an employee? Yes/No \n");
			String user_input = s.nextLine();
			switch(user_input)
			{
			case "Yes":
				System.out.println("The id was already entered as: \n" + id +"\n");
				System.out.println("enter name: \n");
				user_input = s.nextLine();
				String name = HandleName(user_input);
				if(name.equals(""))
					return null;
				Employee e = new Employee(id,name);
				try {
					w.Add_employee(e);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					return null;
				}
				System.out.println("Added: \n" + e.toString() + "\n" + "to the wearhouse! \n");
				System.out.println(e.get_id() +"\n" +"Enterd the wearhouse,Welcome! \n");
				return e;
			case "No":
				System.out.println("Going back! \n");
				return null;
				default:
					return null;
					
			}
		}
		
		System.out.println(id +"\n" +"Enterd the wearhouse,Welcome! \n");
		return w.Search_employee(id);

	}

	/**
	 * Handles the interactive console session for an Employee.
	 * Offers options to check queue status, add a new customer to the service line,
	 * search for a customer in line, remove/serve a customer, or print the line.
	 *
	 * @param e The Employee currently handling customer service.
	 * @param s Scanner instance for reading console inputs.
	 */
	public static void HandleEmployee(Employee e, Scanner s) {
		int id;
		String name;
		String user_input ="";
		int state = 1;

		do {
			PrintMenu("Employee");
			int choice = s.nextInt();
			s.nextLine();
			switch (choice) {
			case 1:
				System.out.println("is Customers getting served now?\n" + "\n" +
						e.Is_costumers_getting_served() + "\n");
				break;

			case 2:
				System.out.println("Who do you want to add to the line? \n");
				System.out.println("enter id: \n");
				user_input = s.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					continue;
				System.out.println("enter name: \n");
				user_input = s.nextLine();
				name = HandleName(user_input);
				if(name.equals(""))
					continue;

				if (e.Is_costumer_in_line(id)) {
					System.out.println("A customer with this ID and Name is already in the line!\"\n");
					break;
				}

				Customer c1 = new Customer(name, id, 0, false);
				e.enqueue_line(c1);
				System.out.println("the current list is: \n");
				e.PrintLine();
				System.out.println("\n");
				break;

			case 3:
				System.out.println("Which costumer you want to search for?\n");
				System.out.println("Enter id to search: \n");
				user_input = s.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					continue;
				Customer c = e.search_costumer(id);
				if (c == null) {
					System.out.println("The requested costumer wasnt found! \n");
					break;
				}
				System.out.println("The Customer we searched for is\n" + c.getId() + "\n");
				if (e.Is_costumer_in_line(id)) {
					System.out.println(id + " was found! \n");
				}
				break;

			case 4:
				if(!e.Is_costumers_getting_served()) 
				{
					System.out.println("cant remove anyone whanm thre list is empty! \n");
					break;
				}
				else
				{
					System.out.println("Who you want to remove?\n");
					System.out.println("Enter id: \n");
					user_input = s.nextLine();
					id = HandleId(user_input);
					if(id == -1)
						continue;
					Customer c2 = new Customer();

					try {
						c2 = e.dequeue_line(id);
						if(c2 == null)
						{
							break;
						}
						System.out.println(c2.getId() + " Was removed from the line!\n");
						System.out.println("the list after the removel" + "\n");
						e.PrintLine();
						System.out.println("\n");
					} catch (Exception e1) {
						System.out.println("exception deteced:" + e1.getMessage());
					}
					break;
				}
			case 5:
				System.out.println("Printing the customer list for:\n" + e.get_name() + "\n" + e.get_id() + "\n");
				e.PrintLine();
				break;

			case 0:
				System.out.println("Going back!\n");
				state = 0;
				break;
			}
		} while (state != 0);
	}

	/**
	 * Handles the interactive console session for a Store Manager.
	 * Provides management capabilities including:
	 * - Adding and removing warehouse employees.
	 * - Updating employee salaries and editing customer queue entries.
	 * - Adding and removing suppliers.
	 * - Transferring stock from suppliers into the warehouse stack.
	 * - Updating item prices and warranty periods.
	 * - Printing warehouse inventory and employee rosters.
	 *
	 * @param w    The warehouse instance being managed.
	 * @param e    The store employee instance.
	 * @param sup1 The supplier instance.
	 * @param s1   Scanner instance for reading console inputs.
	 */
	public static void HandleManager(Wearhouse w, Employee e, Supplier sup1, Scanner s1) {

		int state = 1;
		int 	id = 0;
		String type = "";
		String name = "";
		String phone = "";
		String str_choice = "";
		String compeny = "";
		double price = 0.0;
		int warranty = 0;
		double salery = 0.0;
		String change_for_employee = "";
		String change_for_customer = "";
		double payed = 0.0;
		boolean  vip = false;
		String user_input ="";


		do {
			PrintMenu("Manager");
			int choice = s1.nextInt();
			s1.nextLine();
			switch (choice) {

			case 1:
				System.out.println("Whice employee you want to remove? \n");
				System.out.println("Enter the id: \n");
				user_input = s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
				{
					// a massage will be printed from the function.
					break;	
				}
				System.out.println("Enter the name: \n");
				user_input = s1.nextLine();
				name = HandleName(user_input);
				if(name.equals(""))
					continue;
				try {
					w.Remove_employee(name, id);
					
				} catch (Exception e1) {
					System.out.println("The requested employee is not in the wearhouse! \n");
					break;
				}
				break;

			case 2:
				System.out.println("Who do you want to edit? \n");
				System.out.println("Enter the employee's id: \n");
				user_input =s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					continue;
				Employee e1 = w.Search_employee(id);
				if (e1 == null) {
					System.out.println("Couldnt find the requested employee! \n");
					break;
				}

				System.out.println("What do you want to update for the Employee?:  selary/costumer_line \n");
				change_for_employee = s1.nextLine();
				if (change_for_employee.equals("selary")) {
					System.out.println("What is the selary you want to set to? \n");
					user_input = s1.nextLine();
					salery = HandleSalery(user_input);
					if(salery == -1.0)
						continue;
					e1.set_selary(salery);
					System.out.println("The salery updated to: \n" + salery + "\n");
					break;
				}
				else if (change_for_employee.equals("costumer_line")) {
					System.out.println("What do you want to do?: add costumer/edit costumer in line/remove costumer \n");
					change_for_employee = s1.nextLine();
					switch(change_for_employee)
					{
					case "add costumer":
						System.out.println("Who do you want to add? \n");
						System.out.println("Enter name: first name + last name with capitel letters!  \n");
						user_input = s1.nextLine();
						name = HandleName(user_input);
						if(name.equals(""))
							continue;
						System.out.println("Enter id: 9 digits long \n");
						user_input = s1.nextLine();
						id = HandleId(user_input);
						if(id == -1)
							continue;
						System.out.println("Enter how much he payed: like 300.0 \n");
						user_input = s1.nextLine();
						payed = HandlePayed(user_input); 
						if(payed == -1.0)
							continue;
						System.out.println("Enter is he a vip?: false/true \n");
						vip = s1.nextBoolean();
						s1.nextLine();
						Customer temp = new Customer(name, id, payed, vip);
						if(e1.Is_costumer_in_line(id))
						{
							System.out.println("The costumer is already in the Line! \n");
							break;
						}
						e1.enqueue_line(temp);
						System.out.println("Added the costumer: \n" + temp.toString() + "\nto the line! \n");
						break;


					case "remove costumer":
						System.out.println("Who do you want to remove? \n");
						System.out.println("Enter id: \n");
						user_input = s1.nextLine();
						id = HandleId(user_input);
						if(id == -1)
							continue;
						try {
							Customer c = e1.dequeue_line(id);
							if(c != null) {
								System.out.println("Removed: \n" + c.getId() + "\nfrom the costumer list of the employee " + e1.get_id() + "\n");
								break;
							}
							System.out.println("The requested id for removel is not in the costumer line! \n");
							break;
						} catch (Exception e2) {
							System.out.println(e2.getMessage() + "\n");
							break;
						}

					case "edit costumer in line":
						System.out.println("Enter the id of the costumer you want to edit in the line? \n");
						user_input = s1.nextLine();
						id = HandleId(user_input);
						if(id == -1)
							break;
						if (e1.Is_costumer_in_line(id) == true) {
							Customer temp1 = e1.search_costumer(id);
							System.out.println("What do you want to change for this customer?: vip/amount payed \n");
							change_for_customer = s1.nextLine();
							if (change_for_customer.contentEquals("vip")) {
								System.out.println("What do you want to change vip to?: true/false \n");
								vip = s1.nextBoolean();
								s1.nextLine();
								temp1.setIs_vip(vip);
								System.out.println("Changed the costumer's vip status! \n");
								break;
							}
							else if (change_for_customer.equals("amount payed")) {
								System.out.println("whice amount payed you want to set for the customer! \n");
								user_input = s1.nextLine();
								payed = HandlePayed(user_input);
								if(payed == -1.0)
									continue;
								temp1.setAmount_payed(payed);
								System.out.println("Changed the amount payed for the customer! \n");
								break;
							}

							else {
								System.out.println("None of the options above was selected! \n");
								break;
							}
						}
						else
						{
							System.out.println("The costumer is not in line! \n");
							break;
						}

					default:
					{
						System.out.println("None of the options above was selected! \n");
						break;
					}

					}
				}

				else
				{
					System.out.println("None of the options above was selected! \n");
					break;
				}
				break;

			case 3:
				System.out.println("Whice new employee do you want to add to the WearHouse \n");
				System.out.println("Enter the id: \n");
				user_input = s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					continue;
				System.out.println("Enter the name: \n");
				user_input = s1.nextLine();
				name = HandleName(user_input);
				if(name.equals(""))
					continue;
				w.Add_New_employee(name, id);
				break;

			case 4:
				System.out.println("Which new supplier do you want to add to the wearhouse? \n");
				System.out.println("Enter his name: \n");
				user_input = s1.nextLine();
				name = HandleName(user_input);
				if(name.equals(""))
					continue;
				System.out.println("Enter his phone: \n");
				user_input = s1.nextLine();
				phone = HandlePhone(user_input);
				if(phone.equals(""))
					continue;
				System.out.println("Enter his compny: \n");
				user_input = s1.nextLine();
				compeny = HandleCompeny(user_input);
				if(compeny.equals(""))
					continue;
				System.out.println("Now we build the product for the supplier! \n");
				System.out.println("Enter prodct id: \n");
				user_input = s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					break;
				System.out.println("Enter the product type: \n");
				user_input = s1.nextLine();
				type = HandleType(user_input);
				if(type.equals(""))
					break;
				System.out.println("Enter the product price: \n");
				user_input = s1.nextLine();
				price = HandlePrice(user_input);
				if(price == -1.0)
					break;
				System.out.println("Enter the product warranty: \n");
				user_input = s1.nextLine();
				warranty = HandleWarranty(user_input);
				if(warranty == -1)
					break;
				System.out.println("Creating the product! \n");
				Keyboards k = new Keyboards(id,type,price,warranty);
				System.out.println("Created the product and now adding the new supplier into the wearhouse!  \n");
				try {
					w.Add_New_supplier(name, phone, compeny, k);
					break;
				} catch (Exception e2) {
					e2.getMessage();
					break;
				}

			case 5:
				System.out.println("Which supplier do you want to remove from the wearhouse? \n");
				System.out.println("Enter the phone of the requested supplier! \n");
				user_input = s1.nextLine();
				phone = HandlePhone(user_input);
				if(phone.equals(""))
					continue;
				try {
					w.Remove_supplier(phone);
				} catch (Exception e2) {
					System.out.println("The requested supplier is not in the wearhouse! \n");
					break;
				}
				break;

			case 6:
				System.out.println("Whice product do you want to add to the wearhouse from whice supplier? \n");
				System.out.println(" Enter Supplier phone number: \n");
				user_input = s1.nextLine();
				phone = HandlePhone(user_input);
				if(phone.equals(""))
					continue;
				System.out.println("Enter the item id: \n");
				user_input = s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					continue;
				try {
					w.Add_to_wearhouse_from_supplier(phone, id);
					break;
				} catch (Exception e2) {

					System.out.println(e2.getMessage());
					break;
				}

			case 7:
				System.out.println("Whice item do you want to change? \n");
				System.out.println("Enter id: \n");
				user_input = s1.nextLine();
				id = HandleId(user_input);
				if(id == -1)
					break;
				if (!(w.Is_product_in_wearhouse(id))) {
					System.out.println("The item is not in the wearhouse! \n");
					break;
				}
				System.out.println("What do you want to change? price / warranty \n");
				str_choice = s1.nextLine();
				if (str_choice.equals("price")) {
					System.out.println("What is the price you want to change to?: make sure its a floting point price \n");
					user_input = s1.nextLine();
					price = HandlePrice(user_input);
					if(price == -1.0)
						break;
					try {
						Product p = w.search_product(id);
						p.setPrice(price);
						System.out.println("The price of: \n" + p.getId() + "is set to : \n" +p.getPrice() + "\n");
						break;
					} catch (Exception e2) {
						e2.getMessage();
						break;
					}
				} else if (str_choice.equals("warranty")) {
					System.out.println("What is the warranty you want to set to? \n");
					user_input = s1.nextLine();					
					warranty = HandleWarranty(user_input);
					if(warranty == -1)
						break;
					try {
						Product p = w.search_product(id);
						p.setWarranty(warranty);
						System.out.println("The warranty of: \n" + p.getId() + "is set to : \n" +p.getWarranty() + "\n");
						break;
					} catch (Exception e2) {
						e2.getMessage();
						break;
					}
				}
				else
				{
					System.out.println("None of the options above was selected! \n");
					break;
				}



			case 8:
				System.out.println("Printing item in wearhouse right now: \n");
				System.out.println(w.get_Stack().toString());
				break;

			case 9:
				System.out.println("Printing the employees in the wearhouse. \n");
				System.out.println(w.Show_employees());
				break;

			case 0:
				System.out.println("Going back!\n");
				state = 0;
				break;
			}
		} while (state != 0);
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);


		int empId =0 ,prodId =0,prodWarranty = 0;
		String empName ="" ,supName ="",supPhone ="",supCompeny="",prodType ="";
		double prodPrice = 0.0;

		System.out.println(
				"========================================\n" +
						"          STORE SETUP WIZARD            \n" +
				"========================================");
		int flag = 0;

		do {
			System.out.println("Let's set up the first Employee.");
			System.out.println("Enter ID: id need to be 9 ints long!");
			String id_input = input.nextLine();
			empId = HandleId(id_input);
			if(empId == -1)
				// with continue you go to the next iteration of the loop,
				//with break you go out of the loop entierly.
				continue;

			System.out.println("Enter Name: name need to be first name + last name!");
			String name_input = input.nextLine();
			empName = HandleName(name_input);
			if(empName.equals(""))
				continue;

			//=============================================================================
			System.out.println("\nLet's set up the first Supplier.");
			System.out.println("Enter Name: name need to be first name + last name!");
			name_input = input.nextLine();
			supName = HandleName(name_input);
			if(supName.equals(""))
				continue;

			System.out.println("Enter Phone: phone number need to be 10 ints long!");
			String phone_input = input.nextLine();
			supPhone = HandlePhone(phone_input);
			if(supPhone.equals(""))
				continue;

			System.out.println("Enter Company Name: need to have a capital first char! ");
			String compeny_input = input.nextLine();
			supCompeny = HandleCompeny(compeny_input);
			if(supCompeny.equals(""))
				continue;

			//======================================================================================
			System.out.println("\nLet's set up the first Product.");
			System.out.println("Enter ID: id needs to be 9 ints long!");
			id_input = input.nextLine();
			prodId = HandleId(id_input);
			if(prodId == -1)
				continue;

			System.out.println("Enter Type: type needs to be like: (Keyboard,Gaming Mouse,exc..).");
			String prod_input = input.nextLine();
			prodType = HandleType(prod_input);
			if(prodType.equals(""))
				continue;

			System.out.println("Enter Price: price is a double so like 300.9");
			String price_input = input.nextLine();
			prodPrice = HandlePrice(price_input);
			if(prodPrice == -1.0)
				continue;

			System.out.println("Enter Warranty (months): cant be more than a 36");
			String warranty_input = input.nextLine();
			prodWarranty = HandleWarranty(warranty_input);
			if(prodWarranty == -1)
				continue;

			flag = 1;
		}while(flag == 0);

		Employee e1 = new Employee(empId,empName);
		Keyboards k1 = new Keyboards(prodId,prodType,prodPrice,prodWarranty);
		Supplier s1 = new Supplier(supName,supPhone,supCompeny,k1);
		Wearhouse w1 = new Wearhouse(e1,s1);

		System.out.println("\nSetup Complete! Opening the store...\n");

		String state = "";
		boolean runing = false;
		String user_input = "";

		runing = true;

		while (runing) {
			System.out.println("Who are you? Employee or Manager?\n");
			System.out.println("Exit.\n");
			state = input.nextLine();

			switch (state) {
			case "Employee":
				System.out.println("Enter the id of the employee you want to handle: \n");
				user_input = input.nextLine();
				Employee temp = LoginEmployee(input,user_input,w1);
				if( temp != null)
				{
				HandleEmployee(temp, input);
				}
				break;

			case "Manager":
				HandleManager(w1, e1, s1, input);
				break;

			case "Exit":
				System.out.println("Exiting!\n");
				input.close();
				runing = false;
				break;

			default:
				System.err.println("an invalid input,\n" +
						"none of the options above were selected! \n");
			}
		}
	}
}