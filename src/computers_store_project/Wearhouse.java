package computers_store_project;

public class Wearhouse 
{
	private Employee[] werahouse_employees;
	private Supplier[]  wearhouse_suppliers;
	private MyLinkedStack item_list; // stack of products
	
public Wearhouse()
{
	/* for now the default amount of employee's is 10 and supplier's is 3*/
	werahouse_employees = new Employee[10];
	wearhouse_suppliers = new Supplier[3];
	item_list = new MyLinkedStack();
	
}

public 	Wearhouse( int employees_num,int suppliers_num,Product given_product)
{
	/* creating a wearhouse with a specific amount of suppliers and employees*/
	werahouse_employees = new Employee[employees_num];
	wearhouse_suppliers = new Supplier[suppliers_num];
	item_list = new MyLinkedStack(given_product);
}
	

public MyLinkedStack get_stack()
{
	return item_list;
}


///* this method will take the item by its id from the Supplier and place in in the wearhouse*/
///* supplier will have an item he is suppling and this will be the item that will go to the wearhouse*/
public void Add_From_Supplier(Supplier the_supplier,int id)
{
	//looking for the product id in the list of the supplier
	if(the_supplier.searchProduct(id) == true)
	{
		//will create a temp to hold the node from the supplier and add it to the wearhouse stack
		ProductLink temp;
		temp = the_supplier.removeNode(id); //just removing from the supplier to give it to the wearhouse
	
		// i am removing the box(ProductNode) and taking the contant of the box (the actuel product)
		Product theProduct = temp.getProduct();
		item_list.push(theProduct);
	}
	
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

public Product remove_from_wearhouse(int given_id) 
{
	if(item_list.isStackEmpty())
	{
		throw new NullPointerException("cant remove beacuse the wearhouse is empty!" +"\n");
	}
	
	Link p = item_list.getNode();
	Product p1 = (Product)item_list.getNode().getData();
	while(p != null)
	{
		if (p1.getId() == given_id)
		{
			return (Product)p.getData();
		}
		else 
			p = p.getNext();
	}
	
	throw new NullPointerException("cant remove beacuse no product was found macthign the id!" +"\n");
}


public String toString()
{
	return "the number of employes in the wearhouse: \n" 
			+werahouse_employees.length +"\n" 
			+"the number of suppliers for this wearhouse is: \n "
			+wearhouse_suppliers.length +"\n" 
			+ "the items in the wearhouse are: \n"
			+ item_list.toString();
}
	

}
