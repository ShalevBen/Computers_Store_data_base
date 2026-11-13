package computers_store_project;

public class Wearhouse 
{
	private Employee[] wearhouse_employees;
	private Supplier[]  wearhouse_suppliers;
	private MyLinkedStack item_stack; // stack of products

	public Wearhouse()
	{
		wearhouse_employees = new Employee[10];
		wearhouse_suppliers = new Supplier[10];
		item_stack = new MyLinkedStack();
	}

	public 	Wearhouse( Product given_product,Employee given_employee,Supplier given_supplier)
	{
		/* creating a wearhouse with defult amount of suppliers and employees*/
		wearhouse_employees = new Employee[10];
		wearhouse_suppliers = new Supplier[10];

		/*initialating the wearhosue so it wont be empty ever.
	 an empty wearhouse at the start dosent make sanse. */
		wearhouse_employees[0] = given_employee;
		wearhouse_suppliers[0] = given_supplier;
		item_stack = new MyLinkedStack(given_product);
	}
	
	public 	Wearhouse( Employee given_employee,Supplier given_supplier)
	{
		/* creating a wearhouse with defult amount of suppliers and employees*/
		wearhouse_employees = new Employee[10];
		wearhouse_suppliers = new Supplier[10];

		/*initialating the wearhosue so it wont be empty ever.
	 an empty wearhouse at the start dosent make sanse. */
		wearhouse_employees[0] = given_employee;
		wearhouse_suppliers[0] = given_supplier;
		item_stack = new MyLinkedStack();
	}

	public MyLinkedStack get_Stack()
	{
		return item_stack;
	}

	public String toString()
	{
		return "the number of Employes that can work in the wearhouse is: \n" 
				+wearhouse_employees.length +"\n" 
				+ "the Employee's are: " + "\n" 
				+ Show_employees() + "\n"
				+"the number of suppliers that can work in the wearhouse is: \n"
				+wearhouse_suppliers.length +"\n"
				+ "the suppliers's are: " + "\n"
				+ Show_suppliers() + "\n"
				+ "the items in the wearhouse are: \n"
				+ item_stack.toString() + "\n";
	}

	/**
	 * Counts the number of non-null elements currently stored in an array.
	 *
	 * @param given_array Array of objects to inspect.
	 * @return The count of occupied slots.
	 */
	public int CountArraySlots(Object[] given_array)
	{
		int count = 0;
		if(given_array[0] == null)
			return count;


		for(int i = 0;i < given_array.length; i++)
		{

			if(given_array[i] != null)
				count++;
		}

		return count;
	}
 
	/**
	 * Creates a new Employee with the provided name and ID, and adds them to the 
	 * first empty slot in the employee array if not already present.
	 *
	 * @param given_name Name of the new employee.
	 * @param given_id   Unique ID of the new employee.
	 */
	public void Add_New_employee(String given_name , int given_id)
	{
		Employee given_employee = new Employee(given_id,given_name); // create an employee
		// notice this employee has no salary and his list is empty.

		if(wearhouse_employees[0] == null)
		{
			wearhouse_employees[0] = given_employee;
			System.out.println("added: \n" + given_name + "\n" + given_id + "\n" + "to the Wearhouse \n");
			return;
		}

		if(Is_employee_in_array(given_employee.get_id()))
		{
			System.out.println("the employee already in the array!" + "\n");
			return;
		}

		// goes over the whole array adn look for an empty slot to insert.
		for(int i = 0; i <wearhouse_employees.length ; i++)
		{
			if(wearhouse_employees[i] == null)
			{
				wearhouse_employees[i] = given_employee;
				System.out.println("added: \n" + given_name + "\n" + given_id + "\n" + "to the Wearhouse \n");
				return;
			}
		}

		System.out.println("the array is full and cant add this employee!" + "\n");
		return;
	}

	/**
	 * Adds an existing Employee object to the first available slot in the warehouse 
	 * employee array.
	 *
	 * @param given_employee The Employee instance to add.
	 * @throws RuntimeException If the employee array is full.
	 */
	public void Add_employee(Employee given_employee)
	{

		if(wearhouse_employees[0] == null)
		{
			wearhouse_employees[0] = given_employee;
			return;
		}

		if(Is_employee_in_array(given_employee.get_id()))
		{
			System.out.println("the employee already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < wearhouse_employees.length; i++)
		{
			if(wearhouse_employees[i] == null)
			{
				wearhouse_employees[i] = given_employee;
				return;
			}
		}

		throw new RuntimeException("the array is full and cant add this employee!" + "\n");

	}
	
	/**
	 * Searches for an employee in the employee array by their unique ID.
	 *
	 * @param given_id The ID of the employee to look up.
	 * @return The Employee object if found; null otherwise.
	 */
	public Employee Search_employee(int given_id) 
	{
		for(int i = 0; i< CountArraySlots(wearhouse_employees); i++)
		{
			if(wearhouse_employees[i].get_id() == given_id)
			{
				return wearhouse_employees[i];
			}
		}

		return null; // we didnt find the employee


	}
	
	/**
	 * Checks whether a specific employee exists in the warehouse employee array by matching ID.
	 *
	 * @param given_employee The employee to search for.
	 * @return true if the employee is found; false otherwise.
	 */
	public boolean Is_employee_in_array(int given_id)
	{
		if(wearhouse_employees[0] == null)
		{
			return false;
		}

		for(int i = 0; i < wearhouse_employees.length; i++)
		{
			if(wearhouse_employees[i] != null)
			{
				if(wearhouse_employees[i].get_id() == given_id)
				{
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Removes an employee matching the given name and ID, shifting all subsequent
	 * elements to the left to maintain continuous array order without gaps.
	 *
	 * @param given_name Name of the employee to remove.
	 * @param given_id   ID of the employee to remove.
	 */
	public void Remove_employee(String given_name , int given_id)
	{

		int index = 0;
		Employee temp = new Employee(given_id,given_name);

		if(!Is_employee_in_array(temp.get_id()))
		{
			System.out.println("The requested employe is not in the wearhouse ! \n");
			return;
		}

		if(CountArraySlots(wearhouse_employees)== 0)
		{
			System.out.println("Cant remove the requested Employee the array is empty! \n");
			return;	
		}

		// we can use this way,find the  index of the correct obj,
		//than after that make a shift for all the other 
		//or go with the approch below whice does the finding the right obj and sorting the array both in the same loop
		for(int i = 0; i < wearhouse_employees.length ; i++)
		{

			if(wearhouse_employees[i] != null) 
			{

				if(wearhouse_employees[i].get_id() == given_id && wearhouse_employees[i].get_name().equals(given_name))
				{
					wearhouse_employees[i] = null;
					index =i;
					break;
				}
			}
		}

		for(int i = index; i < wearhouse_employees.length-1; i++)
		{
			if(wearhouse_employees[i] == null && wearhouse_employees[i+1] != null)
			{
				wearhouse_employees[i] = wearhouse_employees[i+1];
				wearhouse_employees[i+1] = null;
			}
		}
		if(Is_employee_in_array(temp.get_id()))
		{
			System.out.println("The requested Employee: \n" + given_id + "\n" + given_name
			+"\n" +"was not removed from the wearhouse! \n");
			return;
		}
		System.out.println("The requested Employee: \n" + given_id + "\n" + given_name
				+"\n" +"was removed from the wearhouse! \n");
		return;
	}

	/**
	 * Generates a string listing all registered employees in the warehouse.
	 *
	 * @return A string containing all employee details, or a message if empty.
	 */
	public String Show_employees()
		{

			if(wearhouse_employees[0] == null)
			{
				return "No employees in the wearhouse still!" + "\n";
			}
			String ans = "";

			for(int i = 0; i <CountArraySlots(wearhouse_employees) ; i++)
			{

				if(wearhouse_employees[i] != null)
				{
					ans += wearhouse_employees[i].toString();
				} 
				else
				{

					ans += "null";
				}

			}
			return ans;
		}
	
	/**
	 * Creates and adds a new Supplier (without an initial product) into the first available 
	 * slot in the suppliers array.
	 *
	 * @param given_name    Name of the supplier.
	 * @param given_phone   Phone number of the supplier.
	 * @param given_compeny Company name of the supplier.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_New_supplier(String given_name,String given_phone,String given_compeny)
	{
		Supplier given_supplier = new Supplier(given_name,given_phone,given_compeny); // create an employee
		// notice this employee has no salary and his list is empty.

		if(wearhouse_suppliers[0] == null)
		{
			wearhouse_suppliers[0] = given_supplier;
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < wearhouse_suppliers.length; i++)
		{
			if(wearhouse_suppliers[i] == null)
			{
				wearhouse_suppliers[i] = given_supplier;
				return;
			}
		}

		throw new RuntimeException("the array is full and cant add this supplier!" + "\n");

	}

	/**
	 * Creates and adds a new Supplier (without an initial product) into the first available 
	 * slot in the suppliers array.
	 *
	 * @param given_name    Name of the supplier.
	 * @param given_phone   Phone number of the supplier.
	 * @param given_compeny Company name of the supplier.
	 * @param given_product the product that the supplier supply.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_New_supplier(String given_name,String given_phone,String given_compeny,Product given_Product)
	{
		Supplier given_supplier = new Supplier(given_name,given_phone,given_compeny,given_Product); // create an employee
		// notice this employee has no salary and his list is empty.

		if(wearhouse_suppliers[0] == null)
		{
			wearhouse_suppliers[0] = given_supplier;
			System.out.println("Added: \n" + given_name + "\n" + given_phone + "\n" + given_compeny + "\n" + given_Product.toString()+"\n" + "to the wearhouse! \n");
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < wearhouse_suppliers.length; i++)
		{
			if(wearhouse_suppliers[i] == null)
			{
				wearhouse_suppliers[i] = given_supplier;
				System.out.println("Added: \n" + given_name + "\n" + given_phone + "\n" + given_compeny + "\n" + given_Product.toString()+"\n" + "to the wearhouse! \n");
				return;
			}
		}

		throw new RuntimeException("the array is full and cant add this supplier!" + "\n");


	}

	/**
	 * Adds an existing Supplier object into the warehouse suppliers array if not already present.
	 *
	 * @param given_supplier The Supplier instance to add.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_supplier(Supplier given_supplier)
	{


		if(wearhouse_suppliers[0] == null)
		{
			wearhouse_suppliers[0] = given_supplier;
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < wearhouse_suppliers.length; i++)
		{
			if(wearhouse_suppliers[i] == null)
			{
				wearhouse_suppliers[i] = given_supplier;
				return;
			}
		}

		throw new RuntimeException("the array is full and cant add this supplier!" + "\n");

	}

	/**
	 * Checks whether a supplier exists in the warehouse supplier array by matching their phone number.
	 *
	 * @param given_phone Unique phone number of the supplier.
	 * @return true if the supplier is present; false otherwise.
	 */
	public boolean Is_supplier_in_array(String given_phone)
	{
		if(wearhouse_suppliers[0] == null)
		{
			System.out.println("The array is empty so no employee is in it! \n");
			return false;
		}

		for(int i = 0; i < CountArraySlots(wearhouse_suppliers); i++)
		{
			if(wearhouse_suppliers[i] != null) 
			{
				if(wearhouse_suppliers[i].getPhone().equals(given_phone))
				{
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Removes a supplier by their phone number and shifts subsequent array elements 
	 * left to prevent null gaps.
	 *
	 * @param given_phone Phone number of the supplier to remove.
	 */
	public void Remove_supplier(String given_phone)
	{
		int index =0;
		if(!Is_supplier_in_array(given_phone))
		{
			System.out.println("The supplier is not in the array! cant remove him ! \n");
			return;

		}

		if(wearhouse_suppliers[0] == null)
		{
			System.out.println("Cant remove the requested Supplier the array is empty! \n");
			return;	
		}

		// will remove the employee and sort the array back in order.
		for(int i = 0; i < wearhouse_suppliers.length ; i++)
		{

			if(wearhouse_suppliers[i] != null) 
			{

				if(wearhouse_suppliers[i].getPhone().equals(given_phone))
				{
					wearhouse_suppliers[i] = null;
					index = i;
					break;
				}
			}
		}

		for(int i = index; i< wearhouse_suppliers.length-1; i++)
			if(wearhouse_suppliers[i] == null && wearhouse_suppliers[i+1] != null)
			{
				wearhouse_suppliers[i] = wearhouse_suppliers[i+1];
				wearhouse_suppliers[i+1] = null;
			}
		
		
		if(Is_supplier_in_array(given_phone))
		{
			System.out.println("The requested Supplier: \n" + given_phone + "\n"
					+"\n" +"was not removed from the wearhouse! \n");
					return;
				}
				System.out.println("The requested Supplier: \n" + given_phone 
						+"\n" +"was removed from the wearhouse! \n");
				return;
		}

	/**
	 * Generates a string listing all registered suppliers in the warehouse.
	 *
	 * @return A string containing all supplier details, or a message if empty.
	 */
	public String Show_suppliers()
	{
		if(wearhouse_suppliers[0] == null)
		{
			return "No suppliers in the wearhouse still!" + "\n";
		}

		String ans = "";

		for(int i = 0; i < CountArraySlots(wearhouse_suppliers); i++)
		{
			if(wearhouse_suppliers[i] != null) 
			{
				ans += wearhouse_suppliers[i].toString();
			}
			else
			{

				ans += "null";
			}
		}
		return ans;
	}

	/**
	 * Transfers a product from a specific supplier's inventory into the warehouse.
	 * Removes the product from the supplier's list and pushes it onto the warehouse stack.
	 *
	 * @param given_phone   The phone number identifying the supplier.
	 * @param given_item_id The product ID to receive from the supplier.
	 * @throws Exception If the item is not found or cannot be supplied.
	 */
	public void Add_to_wearhouse_from_supplier(String given_phone,int given_item_id) throws Exception
	{

		if(wearhouse_suppliers[0] == null)
		{
			System.out.println("The suppliers array is empty! \n");
			return;
		}

		if(!(Is_supplier_in_array(given_phone)))
		{
			System.out.println("The requested supplier is not in the supplier array! \n");
			return;
		}
		ProductLink temp = new ProductLink();

		for(int i = 0; i < wearhouse_suppliers.length; i++)
		{
			if(wearhouse_suppliers[i] == null)
			{
				continue;
			}

			if(wearhouse_suppliers[i].getPhone().equals(given_phone))
			{
				if(wearhouse_suppliers[i].Is_Product_in_the_list(given_item_id))
				{
					//this is the BOX not the PRODUCT
					if(!(Is_product_in_wearhouse(given_item_id))) {
						temp = wearhouse_suppliers[i].removeProduct(given_item_id);
						if(temp != null)
						{
							item_stack.push(temp.getProduct());
							System.out.println(temp + "\n" + "was added to the stack.");
							return;
						}
					}
					else
					{
						System.out.println("The item is already in the wearhouse !\n");
						return;
					}


				}

			}

		}

		throw new Exception("The requested item from the spacific supplier \n" + "can not be found! \n");



	}

	/**
	 * Checks whether a product with the specified ID currently exists in the warehouse stack.
	 *
	 * @param given_id The product ID to search for.
	 * @return true if the product exists in the warehouse; false otherwise.
	 */
	public boolean Is_product_in_wearhouse(int given_id) 
	{
		if(item_stack.isStackEmpty())
		{
			return false;
		}

		Link p = item_stack.getNode();
		Product p1 = null;
		while(p != null)
		{
			p1 = (Product) p.getData();
			if(p1.getId() == given_id)
			{
				return true;
			}
			else 
			{
				p = p.getNext();

			}
		}
		return false;
	}

	/**
	 * Traverses the warehouse product stack to find and return the product with the given ID
	 * without removing it.
	 *
	 * @param given_id ID of the product to find.
	 * @return The matching Product instance.
	 * @throws Exception If the product ID is not present in the warehouse.
	 */
	public Product search_product(int given_id) throws Exception
	{
		if(!(Is_product_in_wearhouse(given_id)))
		{
			throw new Exception("The requested id is not in the wearhouse! \n");

		}

		Link temp = item_stack.getNode();
		Product temp1 = (Product)item_stack.getNode().getData();
		while(temp != null)
		{
			temp1 = (Product)temp.getData();
			if (temp1.getId() == given_id)
			{
				return temp1;
			}
			else 
			{
				temp = temp.getNext();
			}
		}
		throw new NullPointerException("The requested id was not found! \n");
	}

	/**
	 * Searches for and removes a product by ID from the warehouse stack using a temporary stack 
	 * to preserve the original order of the remaining items.
	 *
	 * @param given_id ID of the product to remove.
	 * @return The removed Product object, or null if not found.
	 * @throws NullPointerException If the warehouse stack is empty.
	 */
	public Product remove_product_from_wearhouse(int given_id) 
	{
		if(item_stack.isStackEmpty())
		{
			throw new NullPointerException("cant remove beacuse the wearhouse is empty!" +"\n");
		}

		MyLinkedStack temp_stack = new MyLinkedStack();
		Product temp_p = null;


		//if the stack is not empty we pop an item to chack
		//if the item is matching with the id, than we go and return all the items
		// that we poped out back into the og stack.
		while(!item_stack.isStackEmpty())
		{
			temp_p = item_stack.pop();

			if(temp_p.getId() == given_id)
			{
				while(!temp_stack.isStackEmpty())
				{
					item_stack.push(temp_stack.pop());

				}
				return temp_p;
			}
			temp_stack.push(temp_p);
		}

		//if we dont find the requested item we return the stack to place.
		temp_p = temp_stack.pop();
		while(temp_p != null)
		{
			item_stack.push(temp_p);
			temp_p = temp_stack.pop();
		}



		System.out.println("We didnt find the requested product! \n");
		return temp_p;
	}



	

}
