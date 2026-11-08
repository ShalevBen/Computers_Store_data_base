package computers_store_project;

public class Wearhouse 
{
	private Employee[] wearhouse_employees;
	private Supplier[]  wearhouse_suppliers;
	private MyLinkedStack item_list; // stack of products

	public Wearhouse()
	{
		wearhouse_employees = new Employee[10];
		wearhouse_suppliers = new Supplier[10];
		item_list = new MyLinkedStack();
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
		item_list = new MyLinkedStack(given_product);
	}

	public MyLinkedStack get_Stack()
	{
		return item_list;
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
				+ item_list.toString() + "\n";
	}

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

	public boolean Is_employee_in_array(Employee given_employee)
	{
		if(wearhouse_employees[0] == null)
		{
			System.out.println("The array is empty! so no employee is in it \n");
			return false;
		}

		for(int i = 0; i < wearhouse_employees.length; i++)
		{
			if(wearhouse_employees[i] != null)
			{
				if(wearhouse_employees[i].get_id() == given_employee.get_id())
				{
					return true;
				}
			}
		}

		return false;
	}
	//identify the supplier by a uniqe identifier.
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

	public void Add_New_employee(String given_name , int given_id)
	{
		Employee given_employee = new Employee(given_name,given_id); // create an employee
		// notice this employee has no salary and his list is empty.

		if(wearhouse_employees[0] == null)
		{
			wearhouse_employees[0] = given_employee;
			return;
		}

		if(Is_employee_in_array(given_employee))
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
				return;
			}
		}

		System.out.println("the array is full and cant add this employee!" + "\n");
		return;
	}

	public void Add_employee(Employee given_employee)
	{

		if(wearhouse_employees[0] == null)
		{
			wearhouse_employees[0] = given_employee;
			return;
		}

		if(Is_employee_in_array(given_employee))
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

	public void Remove_employee(String given_name , int given_id)
	{
	
		int index = 0;
		Employee temp = new Employee(given_name,given_id);

		if(!Is_employee_in_array(temp))
		{
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



//		// will remove the employee and sort the array back in order.
//		for(int i = 0; i < wearhouse_employees.length-2 ; i++)
//		{
//
//			if(wearhouse_employees[i] != null) 
//			{
//
//				if(wearhouse_employees[i].get_id() == given_id && wearhouse_employees[i].get_name().equals(given_name))
//				{
//					wearhouse_employees[i] = null;
//				}
//			}
//
//			if(wearhouse_employees[i] == null && wearhouse_employees[i+1] != null)
//			{
//				wearhouse_employees[i] = wearhouse_employees[i+1];
//				wearhouse_employees[i+1] = null;
//			}
//			
//			if(wearhouse_employees[i] == null && wearhouse_employees[i+1] == null)
//			{
//				wearhouse_employees[i+1] = wearhouse_employees[i+2];
//				wearhouse_employees[i+2] = null;
//				wearhouse_employees[i] = wearhouse_employees[i+1];
//			}
//		}
//		
//		if(wearhouse_employees[9] != null && wearhouse_employees[8] == null)
//		{
//			wearhouse_employees[8] = wearhouse_employees[9];
//			wearhouse_employees[9] = null;
//			
//		}






	}

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

	public void Remove_supplier(String given_phone)
	{
		
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
				for(int i = 0; i < wearhouse_suppliers.length-1 ; i++)
				{

					if(wearhouse_suppliers[i] != null) 
					{

						if(wearhouse_suppliers[i].getPhone().equals(given_phone))
						{
							wearhouse_suppliers[i] = null;
						}
					}

					if(wearhouse_suppliers[i] == null && wearhouse_suppliers[i+1] != null)
					{
						wearhouse_suppliers[i] = wearhouse_suppliers[i+1];
						wearhouse_suppliers[i+1] = null;
					}
				}
		



	}

	///* this method will take the item by its id from the Supplier and place in in the wearhouse*/
	///* supplier will have an item he is suppling and this will be the item that will go to the wearhouse*/
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
					temp = wearhouse_suppliers[i].removeProduct(given_item_id);
					if(temp != null)
					{
						item_list.push(temp.getProduct());
						System.out.println(temp + "\n" + "was added to the stack.");
						return;
					}
				}

			}

		}

         throw new Exception("The requested item from the spacific supplier" + "can not be found! \n");



	}

	///* this meathod will chack by id if an  item is already in the wearhouse*/
	public boolean Is_product_in_wearhouse(int given_id) 
	{
		if(item_list.isStackEmpty())
		{
			throw new NullPointerException("the stack is empty!\n ");
		}

		Link p = item_list.getNode();
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

	public Product search_product(int given_id) throws Exception
	{
		if(!(Is_product_in_wearhouse(given_id)))
		{
			throw new Exception("The requested id is not in the wearhouse! \n");

		}

		Link temp = item_list.getNode();
		Product temp1 = (Product)item_list.getNode().getData();
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

	public Product remove_product_from_wearhouse(int given_id) 
	{
		if(item_list.isStackEmpty())
		{
			throw new NullPointerException("cant remove beacuse the wearhouse is empty!" +"\n");
		}

		else
		{
			Link p = item_list.getNode();
			Product p1 = (Product)item_list.getNode().getData();
			while(p != null)
			{
				if (p1.getId() == given_id)
				{
					return p1;
				}
				else 
					p = p.getNext();
			}

		}

		throw new NullPointerException("cant remove beacuse no product was found macthign the id!" +"\n");
	}

	// printing the whole Employee's array
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

	//printing the whole Suplliers's array
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

}
