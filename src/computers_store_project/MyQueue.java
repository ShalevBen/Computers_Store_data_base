package computers_store_project;

public interface MyQueue 
{

/**this function will chack if the queue is empty or not
 * @return true if the queue is empty
*/
public boolean isQueueEmpty();

/**
 *dequeue will remove an object from the head of the queue FIFO
 *@return return the Object
 */
public Object Dequeue();


/**
 * enqueue will insert an object to the queue from behind
 */
public void Enqueue(Object toAdd);

	
	

}
