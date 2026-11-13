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
 * Checks if the queue currently contains any elements.
 *
 * @return True if empty; false otherwise.
 */
public boolean isQueueEmpty()
{
	return queueNode.isEmpty();
}


/**
* Removes and returns the Customer at the front of the queue (FIFO order).
*
* @return Customer at the head of the queue.
*/
public Customer Dequeue()
{
	return (Customer)queueNode.removeFirst();
	
}
	
/**
 * Inserts a Customer at the rear of the queue.
 *
 * @param node Customer object to append.
 */
public void Enqueue(Object node )
{
	queueNode.addLast((Customer)node);
}

/**
 * Generates and returns a string of all elements currently waiting in the queue.
 *
 * @return String of queued customers, or a message if empty.
 */
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