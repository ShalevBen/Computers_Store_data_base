package computers_store_project;

import java.util.Scanner;

public class MainTester {

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
				  + "	6. Back.\n"
                  + "========================================\n"
				  + "Please select an option:");
		}

		if (a.equals("Manager")) {
			System.out
					.println("========================================\n"+
			                 "              MANAGER MENU              \n"
							+ "========================================\n"
			                + "1. Add a new employee to the WearHouse\n"
							+ "2. Remove an existing employee from the Wearhouse\n"
			                + "3. Add a new item to the warehouse from a supplier\n"
							+ "4. Update item stock / details\n"
			                + "5. Print all warehouse data (Inventory)\n"
							+ "6. Print all employees details\n"
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

public static void HandleEmployee(Employee e, Customer c, Scanner s) {
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

				System.out
						.println("is Customers getting served now?\n" + "\n" + !e.is_costumers_getting_served() + "\n");
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
				if (e.search_costumer(id) ) {
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
				e.search_costumer(id);
				System.out.println("The Customer we searched for is\n" + c.toString());

				if (e.search_costumer(id)) {
					System.out.println(id + "was found! \n");
				}

				// reset the variables we used
				id = 0;
				name = "";
				s.nextLine();
				break;
			case 4:
				System.out.println("Who you want to remove?\n");
				id = s.nextInt();

				try {
					e.dequeue_line(c.getId());
				} catch (Exception e1) {
					System.out.println("exception deteced:" + e1.getMessage());
				}

				System.out.println(c.getId() + " Was removed from the line!\n");
				System.out.println("the list after the removel" + "\n");
				e.PrintLine();
				System.out.println("\n");
				id = 0;
				name = "";
				break;
			case 5:
				System.out.println("Printing the customer list for:\n" +e.get_name()+ "\n" +e.get_id()+ "\n");
				e.PrintLine();
				break;

			case 6:
				System.out.println("Going back!\n");
				state = 0;
				s.nextLine(); // need to clear the scanner from previous useage.
				break;
			}

		} while (state != 0);

	}

public static void HandleManager(Wearhouse w,Employee e , Scanner s)
{
	int state = 1;
	int id = 0;
	String name = "";
	
	
	do {
		PrintMenu("Menager");
		int choice =s.nextInt();
		switch(choice){
		case 1:
			System.out.println("Who do you want to add to the WearHouse \n");
			s.nextLine();// consomes the \n from the prviuos nextInt.
			System.out.println("Enter the id: \n");
			id =s.nextInt();
			s.nextLine();// consomes the \n from the prviuos nextInt.
			System.out.println("Enter the name: \n");
			name = s.nextLine();
			Employee e1 = new Employee(id,name); // creating the new employee.
			w.Add_employee(e1);
			System.out.println("added: \n" + name  + "\n" + id + "\n" + "to the Wearhouse \n");
			break;
			
		case 2:
			System.out.println("Whice employee you want to remove? \n");
			s.nextLine();// consomes the \n from the prviuos nextInt.
			System.out.println("Enter the id: \n");
			id = s.nextInt();
			s.nextLine();
			System.out.println("Enter the name: \n");
			name = s.nextLine();
			w.Remove_employee(id, name);
			System.out.println(name + "\n" + id + "\n" +"Was removed from the wearhouse\n");
			break;
		case 3:
			System.out.println("Whice product do you want to add to the wearhouse from whice supplier? \n");
			
		
		
		
		}
		
		
	}
	while(state !=0);
	
}
	public static void main(String[] args) {

//        System.out.println("--- computers_store_project: Main Tester ---\n");
//        Scanner input = new Scanner(System.in);
//        String type = "";
//        type = input.next();
//        

//  System.out.println("--- testing the costumer printing and the employee queue printing! ---" + "\n");
		Customer c1 = new Customer("Noa Bachash", 208645769, 300.0, true);
//  Customer c2 = new Customer("Tom roni",287548659,600.0,false);
//  Customer c3 = new Customer("Sarah Levi", 312456789, 1250.5, true);
//  Customer c4 = new Customer("David Cohen", 204938475, 420.75, false);
		Employee e1 = new Employee("shalev", 207160193, 2500.0, c1);
//        
//  System.out.println("the employee's info:" + "\n");
//  System.out.println(e1.toString());
//        
//  System.out.println("line before any changes! \n");
//  e1.PrintLine();
//        
//      
//  e1.enqueue_line(c2);
//  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
//  System.out.println("we have 2 people in list! " + "\n");
//  e1.PrintLine();
//        
//  e1.enqueue_line(c3);
//  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
//  System.out.println("we have 3 people in list! " + "\n");
//  e1.PrintLine();
//        
//  e1.enqueue_line(c4);
//  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
//  System.out.println("we have 4 people in list! " + "\n");
//  e1.PrintLine();
//         
//        
//try {        
//  e1.dequeue_line(c1.getId());
//  System.out.println("line after removing the id: \n" + c1.getId() +"\n");
//  e1.PrintLine();
//        
//  System.out.println("testing the toString of the employee after all the added costumers");
//  System.out.println(e1.toString());
//        
//  e1.dequeue_line(c2.getId());
//  System.out.println("line after removing the id: \n" + c2.getId() +"\n");
//  e1.PrintLine();
//        
//  e1.dequeue_line(c3.getId());
//  System.out.println("line after removing the id: \n" + c3.getId() +"\n");
//  e1.PrintLine();
//        
//  e1.dequeue_line(c4.getId());
//  System.out.println("line after removing all the id's" + "\n");
//  e1.PrintLine();
//  System.out.println("\n");
//            
//  System.out.println("trying to delete a costumer who is no longer in the line!");
//
//	  e1.dequeue_line(c3.getId()); // this throws an exception.
//}
//catch(Exception e)
//{
//	System.err.println("Caught Excaption:" + e.getMessage());
//}
//        
//        
//        
//  System.out.println("---end of testing the costumer printing and the employee queue printing!---" + "\n");
//   
//  System.out.println("---starting to chack the Wearhouse class!---" + "\n");
//  
//  
//  
//  System.out.println("initializing the wearhouse!" + "\n");
//  Keyboards  k1 = new Keyboards(298675093,"machanical", 300.0,36);
//  Keyboards  k2 = new Keyboards(786954325,"magnatic",500.0,36);
//  Supplier s1 = new Supplier("oran","0505622144","Asus",k1);
//  Wearhouse w1 = new Wearhouse();
//  w1.Add_From_Supplier(s1, k1.getId());
//  w1.Add_employee(e1);
//  
//  
//  
//  System.out.println("testin the Wearhouse pop function whan there is a product the wearhouse" + "\n");
//  ;
//  try {
//      Product p =  w1.get_stack().pop();
//      System.out.println(p.toString());
//      }catch(Exception e)
//  {
//          System.err.println("Caught Excaption:" + e.getMessage());
//  }
//  
//  System.out.println("test to push to the stack" + "\n");
//  w1.get_stack().push(k2);
//  w1.get_stack().push(k1);
//  
//  System.out.println("-- test to print the stack whan it have items in it --" + "\n");
//  System.out.println(w1.get_stack().toString() + "\n");
//  
//  
//  System.out.println("-- test to print the wearhouse with the new item in it --" + "\n");
//  System.out.println(w1.toString());

		Scanner input = new Scanner(System.in);
		String state = "";
		boolean runing = false;

		runing = true;

		while (runing) {
			System.out.println("Who are you? Employee or Manager?\n");
			System.out.println("Exit.\n");
			state = input.nextLine();

			switch (state) {
			case "Employee":
				HandleEmployee(e1, c1, input);
				break;

			case "Menager":
				System.out.println("work in progress");
				break;
			case "Exit":
				System.out.println("Exiting!\n");
				runing = false;
				break;

			}

		}

		System.out.println("\n--- End of tests ---\n");
	}
}
