package computers_store_project;


public class LinkedQueue implements MyQueue
{
	private MyLinkedList queueNode;
	
public LinkedQueue() 
{
	queueNode  = new MyLinkedList();
}


public LinkedQueue( MyLinkedList toAdd)
{

	queueNode = toAdd;
}

public MyLinkedList getList()
{
	return queueNode; 	
}


/**
 * Checks if the queue is empty or not
 * @return true if empty.
 */
public boolean isQueueEmpty()
{
	return queueNode == null || queueNode.isEmpty();
}


/*
 * removes an object from the Queue
 *@return
 */
public Customer Dequeue()
{
	return (Customer)queueNode.removeFirst();
	
}
	
/*
 * inserts a node into the end of the queue
 */
public void Enqueue(Object node )
{
	queueNode.addLast((Customer)node);
}



public String printLinkedQueue()
{
	if(isQueueEmpty())
	{
		return "the Queue is Empty!";
		 
	}
	else
	{
		return queueNode.toString();
	}
}

}







