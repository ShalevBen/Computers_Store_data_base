package computers_store_project;

public class MyLinkedStack 
{
	private Link node;
	
//creates an empty stack
public MyLinkedStack()
{
	node = null;
}
	
//creates a stack with 1 node as a linked list 1 way
public MyLinkedStack(Object data)
{
	node = new Link(data,null);
}


//getter for the Node
public Link getNode()
{
return node;	
}

/**
 * Checks if the stack has no items.
 *
 * @return True if stack is empty; false otherwise.
 */
public boolean isStackEmpty()
{
	return (node == null);
}

/**
 * Pushes a new product onto the top of the stack.
 *
 * @param data Product object to add to the stack.
 */
public void push(Object data)
{
	//creates a new node
	Link  newNode = new Link((Product)data,null);
	Link temp = node;
	Link temp1 = null;
	
	//if stack is empty we add the node to be first down the stack
	if(isStackEmpty())
	{
		
		node = newNode;
		return;
	}
	else
	{
		// the first node is the new node.
		temp1 = temp;
		temp = newNode;
		
		//the new node is the higher node on the stack so it becomes the first on in the stack, every
		//new node will be the first node 
		temp.setNext(temp1);
	}
	node = temp;
	
}

/**
 * Pops and removes the top product from the stack (LIFO order).
 *
 * @return The Product that was on top, or null if empty.
 */
public Product pop()
{
	
	Product temp;
	
	if(isStackEmpty())
	{
        return null;
	}
	else 
	{

		//we are saying " we create obj , than we fatch the first from the stack
		//and then we adjust the pointers so the below obj will bemcome the first one again
		temp = (Product) node.getData();
		node = node.getNext();
	}
	
	return temp;
}

/**
 * Returns a string representation of all products currently on the stack from top to bottom.
 *
 * @return String of stacked elements.
 */
public String toString()
{
	
	if(node == null)
	{
		return " stack is empty!"+ "\n";
	}
	
	String ans = "";
	Link temp1 = node;
	
	
	while(temp1 != null)
	{
		ans += temp1.toString();
		temp1 = temp1.getNext();
	}
	return ans;
	
}



}
