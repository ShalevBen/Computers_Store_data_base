package computers_store_project;
import java.util.Scanner;

public class Main {

	public static void PrintMenu(String type) {
		String a = type;
		if (a.equals("Employee")) {
			System.out.println(
					"========================================\n" +
							"              EMPLOYEE MENU              \n"
							+ "========================================\n"
							+ "	1. Is_costumers_getting_served?. \n"
							+ "	2. Add to line of costumers.\n"
							+ "	3. Search Customer in line. \n"
							+ "	4. Remove from line. \n"
							+ "	5. Print the line of costumers. \n "
							+ "	0. Back.\n"
							+ "========================================\n"
							+ "Please select an option:");
		}

		if (a.equals("Manager")) {
			System.out
			.println("========================================\n"+
					"              MANAGER MENU              \n"
					+ "========================================\n"
					+ "1. Remove an existing employee from the Wearhouse\n"
					+ "2. Edit an Employee's data. \n"
					+ "3. Add a new employee to the WearHouse\n"
					+ "4. add a new supplier to the Wearhouse\n"
					+ "5. Remove an existing supplier from the Wearhouse\n"
					+ "6. Add a new item to the warehouse from a supplier\n"
					+ "7. Update item stock / details\n"
					+ "8. Print all warehouse data (Inventory)\n"
					+ "9. Print all employees details\n"
					+ "0. Back to Main Menu\n"
					+ "========================================\n"
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

	public static void HandleEmployee(Employee e, Scanner s) {
		int id;
		String name;
		int state = 1;

		do {
			PrintMenu("Employee");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				// added ! beacuse the func returned false whan the list is not empty. beacuse
				// the list is really not empty and it means there are people in the list
				// with no ! the answer to our quastion " is Customers getting served now? would
				// be false. but its true beacuse the list is not empty
				// it means people are getting served now. so the right answer is true , people
				// are getting served now.

				System.out.println("is Customers getting served now?\n" + "\n" + e.Is_costumers_getting_served() + "\n");
				break;

			case 2:
				System.out.println("Who do you want to add to the line? \n");
				s.nextLine();// consomes the \n from the prviuos nextInt.
				System.out.println("enter id: \n");
				id = s.nextInt();
				s.nextLine();// consomes the \n from the prviuos nextInt
				System.out.println("enter name: \n");
				name = s.nextLine();

				if (!(intLength(id) <= 9 && name.contains(" "))) {
					System.out.println("the id and name are not in the correct formet\n");
					break;
				}

				//chack if the costumer is  already in the line.
				if (e.Is_costumer_in_line(id) ) {
					System.out.println("A customer with this ID and Name is already in the line!\"\n");
					break;
				} else {
					Customer c1 = new Customer(name, id, 0, false); // creating a Customer for now.
					e.enqueue_line(c1);
				}
				System.out.println(name + "\n" + id + "\n" + "was added to the list!\n");
				System.out.println("the current list is: \n");
				e.PrintLine();
				System.out.println("\n");

				id = 0;
				name = "";
				s.nextLine();
				break;
			case 3:
				System.out.println("Who you want to search for?\n");
				id = s.nextInt();
				s.nextLine();
				Customer c = e.search_costumer(id);
				if(c == null)
				{
					System.out.println("The requested costumer wasnt found! \n");
					break;
				}
				System.out.println("The Customer we searched for is\n" + c.getId() + "\n");
				if (e.Is_costumer_in_line(id)) {
					System.out.println(id + "was found! \n");
				}
				break;
			case 4:
				System.out.println("Who you want to remove?\n");
				id = s.nextInt();
				Customer c1 = new Customer();

				try {
					c1 = e.dequeue_line(id);
					System.out.println(c1.getId() + " Was removed from the line!\n");
					System.out.println("the list after the removel" + "\n");
					e.PrintLine();
					System.out.println("\n");
					break;
				} catch (Exception e1) {
					System.out.println("exception deteced:" + e1.getMessage());
					break;
				}
			case 5:
				System.out.println("Printing the customer list for:\n" +e.get_name()+ "\n" +e.get_id()+ "\n");
				e.PrintLine();
				break;

			case 0:
				System.out.println("Going back!\n");
				state = 0;
				s.nextLine(); // need to clear the scanner from previous useage.
				break;
			}

		} while (state != 0);

	}

	public static void HandleManager(Wearhouse w,Employee e , Supplier sup1 , Scanner s1)
	{
		//all the variables we use for this function
		int state = 1;
		int id = 0;
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
		boolean vip = false;

		do {
			PrintMenu("Manager");
			int choice = s1.nextInt();
			switch(choice){

			case 1:
				System.out.println("Whice employee you want to remove? \n");
				s1.nextLine();// consomes the \n from the prviuos nextInt.
				System.out.println("Enter the id: \n");
				id = s1.nextInt();
				s1.nextLine();
				System.out.println("Enter the name: \n");
				name = s1.nextLine();
				try {
					w.Remove_employee(name, id);
				} catch (Exception e1) {
					System.out.println("The requested employee is not in the wearhouse! \n");
					break;
				}
				System.out.println(name + "\n" + id + "\n" +"Was removed from the wearhouse\n");
				break;
			case 2:
				System.out.println("Who do you want to edit? \n");
				s1.nextLine();
				id = s1.nextInt();
				Employee e1 = w.Search_employee(id);
				if(e1 == null)
				{
					System.out.println("Couldnt find the requested employee! \n");
					break;
				}

				System.out.println("What do you want to update for the Employee?:  selary/costumer_line \n");
				s1.nextLine();
				change_for_employee = s1.nextLine();
				if(change_for_employee.contentEquals("selary"))
				{
					System.out.println("What is the selary you want to set to? \n");
					salery = s1.nextDouble();
					e1.set_selary(salery);
					System.out.println("The salery updated to: \n" + salery + "\n");
					break;
				}

				if(change_for_employee.contentEquals("costumer_line"))
				{
					System.out.println("What do you want to do?: add costumer /Edit costumer in line/ remove costumer \n");
					change_for_employee = s1.nextLine();
					if(change_for_employee.contentEquals("add costumer"))
					{
						System.out.println("Who do you want to add? \n");
						System.out.println("Enter name: \n");
						name = s1.nextLine();
						System.out.println("Enter id: \n");
						id = s1.nextInt();
						s1.nextLine();
						System.out.println("Enter how much he payed: \n");
						payed = s1.nextDouble();
						s1.nextLine();
						System.out.println("Enter is he a vip?: false/true \n");
						vip =s1.nextBoolean();
						Customer temp = new Customer(name,id,payed,vip);
						e1.enqueue_line(temp);
						System.out.println("Added the costumer tot he list of: \n" + e1.get_id() + "\n");
						break;
					}
					if(w.Search_employee(id).Is_costumers_getting_served() == false)
					{
						System.out.println("Cant edit or remove the line of costumers,"
								+ "beacuse there are not costumers to begin with! \n");
						break;
					}

					else if(change_for_employee.contentEquals("remove costumer"))
					{
						System.out.println("Who do you want to remove? \n");
						System.out.println("Enter name: \n");
						name = s1.nextLine();
						System.out.println("Enter id: \n");
						id = s1.nextInt();
						s1.nextLine();
						try {
							e1.dequeue_line(id);
						} catch (Exception e2) {
							e2.getMessage();
						}
						System.out.println("Removed " +id +"from the costumer list of the employee " +e1.get_id() + "\n");
						break;
					}
					else if(change_for_employee.contentEquals("Edit costumer in line"))
					{
						System.out.println("Who do you want to edit in the line? \n");
						id = s1.nextInt();
						s1.nextLine();
						if(e1.Is_costumer_in_line(id) == true)
						{
							Customer temp1 = e1.search_costumer(id);
							System.out.println("What do you want to change for this customer?: vip/amount payed \n");
							change_for_customer = s1.nextLine();
							if(change_for_customer.contentEquals("vip"))
							{
								System.out.println("What do you want to change it to?: true/false \n");
								vip = s1.nextBoolean();
								temp1.setIs_vip(vip);
								System.out.println("Changed the costumer's vip status! \n");
								break;
							}
							else if(change_for_customer.contentEquals("amount payed"))
							{

								System.out.println("To what amount you want to change the amount payed for this customer? \n");
								payed =s1.nextDouble();
								temp1.setAmount_payed(payed);
								System.out.println("Changed the amount the customer payed! \n");
								break;
							}
							else
							{
								System.out.println("None of the options above sas selected! \n");
								break;
							}
						}
						else
						{
							System.out.println("The requested costumer is not in line! \n");
							break;
						}
					}
				}

			case 3:
				System.out.println("Whice new employee do you want to add to the WearHouse \n");
				s1.nextLine();// consomes the \n from the prviuos nextInt.
				System.out.println("Enter the id: \n");
				id =s1.nextInt();
				s1.nextLine();// consomes the \n from the prviuos nextInt.
				System.out.println("Enter the name: \n");
				name = s1.nextLine();
				// creating the new employee. be sure to notice inside this method,
				//the employee has nothing but a name and id.
				w.Add_New_employee(name,id);
				System.out.println("added: \n" + name  + "\n" + id + "\n" + "to the Wearhouse \n");
				break;
			case 4:
				System.out.println("Which new supplier do you want to add to the wearhouse? \n");
				s1.nextLine();
				System.out.println("Enter his name: \n");
				name = s1.nextLine();
				s1.nextLine();
				System.out.println("Enter his phone: \n");
				phone = s1.nextLine();
				s1.nextLine();
				System.out.println("Enter his compny: \n");
				compeny = s1.nextLine();
				//make sure to understand that this supplier dosent have his product list , its null.
				w.Add_New_supplier(name, phone,compeny);
				System.out.println("Added: \n" + name +"\n"+ id +"\n"+ compeny +"\n" + "to the wearhouse! \n");
				break;
			case 5:
				System.out.println("Which supplier do you want to remove from the wearhouse? \n");
				s1.nextLine();
				phone = s1.nextLine();
				try {
					w.Remove_supplier(phone);
				} catch (Exception e2) {
					System.out.println("The requested supplier is not in the wearhouse! \n");
					break;
				}
				System.out.println("Removed the supplier with the Phone number: \n" + phone +"\n" + "from the wearhouse! \n");
				break;
				
			case 6:
				System.out.println("Whice product do you want to add to the wearhouse from whice supplier? \n");
				System.out.println(" Enter Supplier phone number: \n");
				s1.nextLine();
				phone = s1.nextLine();
				System.out.println("Enter the item id: \n");
				id =s1.nextInt();
				s1.nextLine();
				try {
					w.Add_to_wearhouse_from_supplier(phone, id);
				} catch (Exception e2) {
					System.out.println("The requested item from the spacific supplier"
							+ "can not be found! \n");
					e2.printStackTrace();
				}
				System.out.println("the following item id was added to the wearhouse: \n" + id + "\n");
				break;
				
			case 7:
				System.out.println("Whice item do you want to change? \n");
				s1.nextLine();
				id = s1.nextInt();
				if(!(w.Is_product_in_wearhouse(id))) // will chack if the requested item is in the wearhouse.
				{
					System.out.println("The item is not in the wearhouse! \n");
					break;
				}
				System.out.println("What do you want to change? price / warranty \n");
				s1.nextLine();
				str_choice = s1.nextLine();
				if(str_choice.equals("price"))
				{
					System.out.println("What is the price you want to change to?: make sure its a floting point price \n");
					price = s1.nextDouble();
					try {
						w.search_product(id).setPrice(price);
					} catch (Exception e2) {
						e2.getMessage();
					}
					break;
				}
				else if(str_choice.equals("warranty"))
				{
					warranty = s1.nextInt();
					try {
						w.search_product(id).setWarranty(warranty);
					} catch (Exception e2) {
						e2.getMessage();
					}
					break;
				}
				else
					break;
				
			case 8 :
				System.out.println("Printing item in wearhouse right now: \n");
				System.out.println(w.get_stack().toString());
				break;
			case 9 :
				System.out.println("Printing the employees in the wearhouse. \n");
				System.out.println(w.Show_employees());
				break;
			case 0:
				System.out.println("Going back!\n");
				state = 0;
				s1.nextLine(); // need to clear the scanner from previous useage.
				break;
			}
		}
		while(state !=0);
	}
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("========================================\n" +
				"          STORE SETUP WIZARD            \n" +
				"========================================");

		System.out.println("Let's set up the first Employee.");
		System.out.println("Enter ID: id need to be 9 ints long!");
		int empId = input.nextInt();

		input.nextLine();
		System.out.println("Enter Name: name need to be first name + last name!");
		String empName = input.nextLine();
		Employee e1 = new Employee(empName, empId);

		System.out.println("\nLet's set up the first Supplier.");
		System.out.println("Enter Name: name need to be first name + last name!");
		String supName = input.nextLine();
		System.out.println("Enter Phone: phone number need to be 9 ints long!");
		String supPhone = input.nextLine();
		System.out.println("Enter Company Name: need to have a capital first char! ");
		String supCompany = input.nextLine();
		Supplier s1 = new Supplier(supName, supPhone, supCompany);

		System.out.println("\nLet's set up the first Product (Keyboard).\n");
		System.out.println("Enter ID: id needs to be 9 ints long!");
		int prodId = input.nextInt();
		input.nextLine();
		System.out.println("Enter Type: type needs to be 1 word like: Keyboard.");
		String prodType = input.nextLine();
		System.out.println("Enter Price: price is a double so like 300.9");
		double prodPrice = input.nextDouble();
		System.out.println("Enter Warranty (months): cant be more than a 36");
		int prodWarranty = input.nextInt();
		input.nextLine();
		Keyboards k1 = new Keyboards(prodId, prodType, prodPrice, prodWarranty);

		// Initialize the Wearhouse using the constructor you already built
		Wearhouse w1 = new Wearhouse(k1, e1, s1);

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
				HandleManager(w1,e1,s1,input);
				break;

			case "Exit":
				System.out.println("Exiting!\n");
				runing = false;
				break;
			default:
				System.err.println("an invalid input,\n"
						+ "none of the options above were selected! \n");
			}

		}

	}

}
