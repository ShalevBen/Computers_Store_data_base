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

//Checks if we have an empty stack
public boolean isStackEmpty()
{
	return (node == null);
}


public void push(Object data)
{
	//creates a new node
	Link  newNode = new Link((Product)data,null);
	
	//if stack is empty we add the node to be first down the stack
	if(isStackEmpty())
	{
		
		node = newNode;
	}
	
	else
	{
		//we basically say " OK you are above the first one we had in"
		//[Blue] -> (Next: null)        Stack Top
		//   ^                             |
		//   |                             V
		//newNode                      [Orange] -> (Next: null)
		 //                           (firstNode points to Orange)
		newNode.setNext(node);
		
		//the new node is the higher node on the stack so it becomes the first on in the stack, every
		//new node will be the first node 
		node = newNode;
	}
	
}

public Product pop()  throws Exception
{
	
	Product temp;
	
	if(node == null)
	{
		throw new NullPointerException ("cant pop beacuse stack is empty! " + "\n");
	}
	
	if(isStackEmpty())
	{
        System.out.println("The stack is empty!");
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


public String toString()
{
	return node.toString();
}



}
