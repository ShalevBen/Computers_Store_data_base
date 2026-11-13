package computers_store_project;


//will handle the list for the products
public class ProductLink 
{
	private Product product;
	private ProductLink nextNode;
	
//creates an empty list
public ProductLink()
{
	product = null;
	nextNode = null;
}
	
//creates a node with given product
public ProductLink (Product given_data)
{
	product = given_data;
	nextNode = null;
}

public ProductLink (ProductLink l)
{
	product = l.product;
	nextNode = l.nextNode;
}

//setter and getter for the data (product)
public Product getProduct()
{
	return product;
}

public void setProduct(Product given_product)
{
	product = given_product;
}

//setter and getter for the ProductNode
public ProductLink getNextNode()
{
	return nextNode;	
}
	
public void setNextNode(ProductLink given_node)
{

	nextNode = given_node;
}

public String toString()
{
	if(product == null)
	{
		return "list is Empty! \n";
		
	}
	
	String ans = "" ;
	ans = "The prod: \n" + product+ "\n" + "the next: \n" + nextNode + "\n";
	return ans;
	

}
/**
 * Traverses and prints the entire linked list of products from this node forward.
 *
 * @return String containing all chained products.
 */
public String PrintList()
{
	if(product == null)
	{
		return "list is Empty! \n";
		
	}
	
	
	String ans = product.toString() + "\n";
	
	if(nextNode == null)
	{
		
		ans+=  "\n" + "next one is empty.";
	}
	
	else 
	{
		ans += nextNode.toString();
		
	}
	return ans;
}

}
