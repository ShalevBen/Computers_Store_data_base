package computers_store_project;

import java.util.Scanner;

public class Main {

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

	public static int intLength(int given_int) {
		int temp = given_int;
		int counter = 0;
		do {
			temp /= 10;
			counter++;
		} while (temp != 0);
		return counter;
	}

	public static int HandleId(String input)
	{
		int id = Integer.parseInt(input);
		if(intLength(id) != 9)
		{
			System.out.println("The entered id formated incorrectly! \n" + "has to be 9 digits long!\n");
			return -1;
		}
		return id;

	}

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
		else if(name.matches("[A-Z]+[a-z]+\\s[A-Z]+[a-z]+"))
		{
			return name;
		}
		System.out.println("The name isnt formanted as First name + Last name! \n");
		return "";

	}

	public static String HandleType(String input)
	{
		String type = input;
		if(type.matches("[A-Z]+[a-z]+"))
		{
			return type;
		}
		System.out.println("Wrong type format! \n");
		return "";
	}

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

	public static String HandleCompeny(String input)
	{
		String compeny = input;
		if(compeny.matches("[A-Z]+[a-z]+"))
		{
			return compeny;
		}
		return "";
	}

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

	private static Double HandleSalery(String input) {
		Double salery = Double.parseDouble(input);
		if(salery < 0)
		{
			return -1.0;
		}
		return salery;

	}

	private static double HandlePayed(String user_input) {
		double pay = Double.parseDouble(user_input);
		if(pay < 0.01 )
			return 0.0;
		return pay;
	}

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
				System.out.println(name + "\n" + id + "\n" + "was added to the list!\n");
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
						System.out.println("Enter name: last name +  \n");
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
						if(payed == 0.0)
							continue;
						System.out.println("Enter is he a vip?: false/true \n");
						vip = s1.nextBoolean();
						s1.nextLine();
						Customer temp = new Customer(name, id, payed, vip);
						e1.enqueue_line(temp);
						System.out.println("Added the costumer to the list of: \n" + e1.get_id() + "\n");
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
								if(payed == 0.0)
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
				System.out.println("added: \n" + name + "\n" + id + "\n" + "to the Wearhouse \n");
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
				user_input = s1.nextLine();
				type = HandleType(user_input);
				if(type.equals(""))
					break;
				user_input = s1.nextLine();
				price = HandlePrice(user_input);
				if(price == -1.0)
					break;
				user_input = s1.nextLine();
				warranty = HandleWarranty(user_input);
				if(warranty == -1)
					break;
				Keyboards k = new Keyboards(id,type,price,warranty);
				w.Add_New_supplier(name, phone, compeny, k);
				System.out.println("Added: \n" + name + "\n" + phone + "\n" + compeny + "\n" + k.toString()+"\n" + "to the wearhouse! \n");
				break;

			case 5:
				System.out.println("Which supplier do you want to remove from the wearhouse? \n");
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
			System.out.println("\nLet's set up the first Product (Keyboard).");
			System.out.println("Enter ID: id needs to be 9 ints long!");
			id_input = input.nextLine();
			prodId = HandleId(id_input);
			if(prodId == -1)
				continue;

			System.out.println("Enter Type: type needs to be 1 word like: Keyboard.");
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

		Employee e1 = new Employee(empName,empId);
		Supplier s1 = new Supplier(supName,supPhone,supCompeny);
		Keyboards k1 = new Keyboards(prodId,prodType,prodPrice,prodWarranty);
		Wearhouse w1 = new Wearhouse(k1,e1,s1);

		System.out.println("\nSetup Complete! Opening the store...\n");

		String state = "";
		boolean runing = false;

		runing = true;

		while (runing) {
			System.out.println("Who are you? Employee or Manager?\n");
			System.out.println("Exit.\n");
			state = input.nextLine();

			switch (state) {
			case "Employee":
				HandleEmployee(e1, input);
				break;

			case "Manager":
				HandleManager(w1, e1, s1, input);
				break;

			case "Exit":
				System.out.println("Exiting!\n");
				runing = false;
				break;

			default:
				System.err.println("an invalid input,\n" +
						"none of the options above were selected! \n");
			}
		}
	}
}