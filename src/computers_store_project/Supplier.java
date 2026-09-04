package computers_store_project;

public class Supplier
{

	private String name;
	private String phone_number;
	private String compeny_name;
	private ProductLink first_Product_Node; //a linked list of products.
	
// 
public Supplier(String given_name,String given_phone,String given_compeny,Product given_product)
{
	
	//this will handle the supplier stuff
	name = given_name;
	phone_number = given_phone;
	compeny_name = given_compeny;
	first_Product_Node = new ProductLink(given_product);
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


public String toString()
{
	String ans;
	
	ans = "name: " + name + "\n" +"phone number: " +phone_number +"\n" + "compeny_name: " +compeny_name 
			+"\n"+"Suppliers Products: " +"\n" + first_Product_Node.PrintList();
	return ans;
}

//chacks if the list is empty
public boolean isEmpty()
{
	return first_Product_Node == null; 	
}

/* this function goes in the list and look inside it
 * @return true if the given id is in the list
 */
public boolean searchProduct( int product_id)
{
	if(isEmpty() == true)
	{
		System.out.println("the list is empty");
		return false;
	}
	
	ProductLink current = first_Product_Node;
	
	while(current != null)
	{
		if(current.getProduct().getId() == product_id)
		{
			return true;
		}
		//if we didnt we will continue to the next product in line.
		else 
		{
			current = current.getNext();
		}
		
	}
	// if we didnt find the product at all we return false
	return false;
}

//insert a Product to the end of the list.
public void addLastProduct(Product given_product)
{
	//create a new link to insert to the list
	ProductLink newProd = new ProductLink(given_product);
	
	    //the list is not empty and we need to insert the product into it
		if(searchProduct(given_product.getId()))
		{
			System.out.println("the product is already in the list! " + "\n");
			return;
		}
		else 
		{
			ProductLink temp = first_Product_Node;
			
			while(temp != null)
			{
				if(temp.getNext() == null)
				{
					 temp.setNext(newProd);
					 return;
				}
				else
				{
					temp = temp.getNext();
					
				}
			}
		}
}

//remove the first node in the list and return him, it handels the connection in between nodes.
public ProductLink removeNode(int given_id)
{
	
	ProductLink ans = null;
	ProductLink temp = first_Product_Node;

	if(isEmpty())
	{
		return null;
	}
	
	//we find the one we need and we return it.
	while(temp != null)
	{
		if(temp.getProduct().getId() == given_id)
		{
			ans = temp;
			temp = temp.getNext();
			return ans;
		}
		else 
		{
			temp = temp.getNext();
		}
	}
	
	System.out.println("the requested item is not in the list! \n");
	return null;
}

}
