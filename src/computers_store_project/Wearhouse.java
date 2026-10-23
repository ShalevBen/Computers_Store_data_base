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
	
public MyLinkedStack get_stack()
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

public boolean Is_employee_in_array(Employee given_employee)
{
	for(int i = 0; i < wearhouse_employees.length; i++)
	{
		
		if(wearhouse_employees[i].equals(given_employee))
		{
			return true;
		}
	}
	
	return false;
}
//identify the supplier by a uniqe identifier.
public boolean Is_supplier_in_array(String given_phone)
{
	for(int i = 0; i < wearhouse_suppliers.length; i++)
	{
		
		if(wearhouse_suppliers[i].getPhone().equals(given_phone))
		{
			return true;
		}
	}
	
	return false;
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
		
		throw new RuntimeException("the arrya is full and cant add this employee!" + "\n");
		
}

public void Remove_employee(int given_id , String given_name)
{
	if(wearhouse_employees.length == 0)
	{
		System.out.println("Cant remove the requested Employee the array is empty! \n");
		return;	
	}
	// will remove the employee and sort the array back in order.
	for(int i = 0; i < wearhouse_employees.length; i++)
	{
		
		if(wearhouse_employees[i].get_id() == given_id && wearhouse_employees[i].equals(given_name))
		{
			wearhouse_employees[i] = null;
		}
		
		if(wearhouse_employees[i] == null && wearhouse_employees[i+1] != null)
		{
			wearhouse_employees[i] = wearhouse_employees[i+1];
			wearhouse_employees[i+1] = null;
		}
	}
	
	
	

}

///* this method will take the item by its id from the Supplier and place in in the wearhouse*/
///* supplier will have an item he is suppling and this will be the item that will go to the wearhouse*/
public void Add_to_wearhouse_From_Supplier(String given_phone,int given_item_id)
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
				if(wearhouse_suppliers[i].searchProduct(given_item_id))
				{
					//this is the BOX not the PRODUCT
					temp = wearhouse_suppliers[i].removeProduct(given_item_id);
				}
				
			}
		
	}
	
	//will hold the product and push it into the stack.
	 item_list.push(temp.getProduct());
	System.out.println(temp + "\n" + "was added to the stack.");
}

///* this meathod will chack by id if an  item is already in the wearhouse*/
public boolean is_in_wearhouse(int given_id) 
{
	Link p = item_list.getNode();
	Product p1 = (Product)item_list.getNode().getData();
	while(p != null)
	{
		if (p1.getId() == given_id)
		{
			return true;
		}
		else 
			p = p.getNext();
	}
	return false;
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
	
	for(int i = 0; i < wearhouse_employees.length; i++)
	{
		
		if(wearhouse_employees[i] != null)
		{
			ans += wearhouse_employees[i].toString();
			break;
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
	
	for(int i = 0; i < wearhouse_suppliers.length; i++)
	{
		if(wearhouse_suppliers != null) 
		{
			ans += wearhouse_suppliers[i].toString();
			break;
		}
	}
	return ans;
}

}
