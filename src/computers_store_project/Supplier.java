package computers_store_project;

public class Supplier
{

	private String name;
	private String phone_number;
	private String compeny_name;
	private ProductLink product_list; //a linked list of products.
	
public Supplier()
{
	name = "";
	phone_number ="";
	compeny_name = "";
	product_list = new ProductLink();
	product_list = null;
}
	
public Supplier(String given_name,String given_phone,String given_compeny,Product given_product)
{
	
	//this will handle the supplier stuff
	name = given_name;
	phone_number = given_phone;
	compeny_name = given_compeny;
	product_list = new ProductLink(given_product);
}

public Supplier(String given_name,String given_phone,String given_compeny)
{
	
	//this will handle the supplier stuff
	name = given_name;
	phone_number = given_phone;
	compeny_name = given_compeny;
	product_list = new ProductLink();
    product_list = null;
	
}

//getter and setters
public String getName()
{
return name;	
}

public String getPhone()
{
return phone_number;	
}

public String getCompenyName()
{
return compeny_name;	
}

public ProductLink getList()
{
	return product_list;
}

// we have to take in concidiration that the product list can be null so we cant print a list 
// that is null.
public String toString()
{
	String ans;
	
	ans = "name: " + name + "\n" +"phone number: " +phone_number +"\n" + "compeny_name: " +compeny_name 
			+"\n"+"Suppliers Products: \n" +"\n"+
			(product_list == null ? "null \n" : product_list.PrintList()+"\n") + "\n";
	return ans;
}

//chacks if the list is empty
public boolean isListEmpty()
{
	return product_list == null; 	
}

/* this function goes in the list and look inside it
 * @return true if the given id is in the list
 */
public boolean Is_Product_in_the_list( int product_id)
{
	if(isListEmpty() == true)
	{
		System.out.println("the list is empty");
		return false;
	}
	
    
	ProductLink current = product_list;
	
	while(current != null)
	{
		if(current.getProduct().getId() == product_id)
		{
			return true;
		}
		//if we didnt we will continue to the next product in line.
		else 
		{
			current = current.getNextNode();
		}
		
	}
	// if we didnt find the product at all we return false
	return false;
}

//insert a Product to the end of the list.
public void addLastProduct(Product given_product)
{
	// if the list is empty we will create a new list and set its item as the given item..
	if (isListEmpty())
	{
		product_list = new ProductLink(given_product);
		return;
		
	}
	//create a new link to insert to the list
	ProductLink newProd = new ProductLink(given_product);
	
	    //the list is not empty and we need to insert the product into it
		if(Is_Product_in_the_list(given_product.getId()))
		{
			System.out.println("the product is already in the list! " + "\n");
			return;
		}
		else 
		{
			ProductLink temp = product_list;
			
			while(temp != null)
			{
				if(temp.getNextNode() == null)
				{
					 temp.setNextNode(newProd);
					 return;
				}
				else
				{
					temp = temp.getNextNode();
					
				}
			}
			
		}
}

//remove the node in the list and return him, it handels the connection in between nodes.
public ProductLink removeProduct(int given_id)
{
	
	if(isListEmpty())
	{
		return null;
	}
	
	//you must create a new obj with new to prevent changing the original list.
	//and to prevent the other nodes aside from the first to change.
	ProductLink curr = product_list; 
	ProductLink ans = null;
	ProductLink prev = curr;
	
	//for the case where the first node is the one we look for.
	if(curr.getProduct().getId() == given_id)
	{
		ans = curr;
		product_list = product_list.getNextNode();
		ans.setNextNode(null);
		return ans;
	}
	
	// this is the case where we are looking for a suitability.
	while(curr != null)
	{
		if(curr.getProduct().getId() == given_id)
		{
			//this way of connecting we dont need to do curr = curr.getNext()
			ans = curr;
			prev.setNextNode(curr.getNextNode());//connecting the list in a way
												// where the node is  "deleted".
			ans.setNextNode(null);
			return ans;
		}
		else 
		{
			prev = curr;
			curr = curr.getNextNode();
		}
	}
	
	
	
	System.out.println("the requested item is not in the list! \n");
	return null;
}

}
