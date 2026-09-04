package computers_store_project;

public class MyLinkedList 
{
	private Link first;

//creates an empty
public MyLinkedList ()
{
		first = null;
}

public MyLinkedList (Object data)
{
	first = new Link(data, null);
}

public Link getFirstNode()
{
	return first;

}

public int length()
{
	Link temp = first;
	int counter = 1;
	
	while(temp.getNext() != null)
	{
		counter++;
		temp = temp.getNext();
	}
	
	return counter;
}

public boolean isEmpty() 
{
	return (first == null);
}

public void addLast(Object data) 
{
	Link newLink = new Link(data, null);
	if (isEmpty()) 
	{
		first = newLink;
	}
	else
	{
		Link temp = first;
		while (temp.getNext() != null)
			{
				temp = temp.getNext();
			}
		
			temp.setNext(newLink);
		}
	}

public Object removeFirst(){
	Object ans;
	
	if (isEmpty()) 
	{
        System.out.println("the following list is empty!");
		return null;
	}
	
	else 
	{
		ans = first.getData();
		first = first.getNext();
	}
	return ans;
}

public String toString()
{
	String ans = "";
	Link temp = first;
	
	if(length() == 1 )
	{
		ans += temp.toString();
		return ans;
	}
	
	else
	{
			if(temp.getNext() != null)
			{
				ans += temp.toString();
				temp = temp.getNext();
			}
		return ans;
	}
}

}