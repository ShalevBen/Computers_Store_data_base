package computers_store_project;

public class MyLinkedList 
{
	private Link Node;

//creates an empty
public MyLinkedList ()
{
		Node = null;
}

public MyLinkedList (Object data)
{
	Node = new Link(data, null);
}

public Link getNode()
{
	return Node;

}

/**
 * Counts and returns the total number of nodes in the linked list.
 *
 * @return Size of the list.
 */
public int length()
{
	Link temp = Node;
	int counter = 1;
	
	if(Node == null)
	{
		counter = 0;
		return counter;
		
	}
	
	while(temp.getNext() != null)
	{
		counter++;
		temp = temp.getNext();
	}
	
	return counter;
}

/**
 * Checks whether the linked list is empty (head node is null).
 *
 * @return True if empty; false otherwise.
 */
public boolean isEmpty()
{ //make sure to see that if the first == null. it dosent mean it dont exist, it exist but its empty.
  // you can see it in your deafult constructor, in it first == null. whice mean it exist but its empty.
	if(Node == null)
	{
		return true;
	}
	return false;
	
}

/**
 * Appends a new node containing the specified data to the end of the list.
 *
 * @param data Object to add at the end.
 */
public void addLast(Object data) 
{
	Link newLink = new Link(data, null);
	
	if (Node == null)
	{
		Node = newLink;
	}
	else
	{
		Link temp = Node;
		while (temp.getNext() != null)
			{
				temp = temp.getNext();
			}
		
			temp.setNext(newLink);
		}
	
	}

/**
 * Removes and returns data from the first (head) node of the list.
 *
 * @return Data from the removed head node, or null if list is empty.
 */
public Object removeFirst(){
	Object ans;
	
	if (isEmpty()) 
	{
        System.out.println("the following list is empty!");
		return null;
	}
	
	else 
	{
		ans = Node.getData();
		Node = Node.getNext();
	}
	return ans;
}

/**
 * Traverses and converts all elements in the linked list into a formatted string.
 *
 * @return String representation of the entire list.
 */
public String toString()
{
	String ans = "";
	Link temp = Node;

	if(temp == null)
	{
		ans = "the list is empty";
		return ans;
	}
	
	if(length() == 1 )
	{
		ans += temp.toString();
		return ans;
	}
	
	else
	{
			while(temp != null)
			{
				ans += temp.toString();
				temp = temp.getNext();
			}
	}
	return ans;
}

}