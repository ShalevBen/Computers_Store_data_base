package computers_store_project;

public interface MyStack 
{

	/**
	* push - adds an element to the stack.
	* @param o the elemented to be inserted to the stack.
	*/
	public void push(Object o);
	
	/**
	 * pop - removes an element form the stack (LIFO order).
	 * @return the element from the top of the stack.
	 */
	
	public Object pop ();
	
	/**
	 * isEmpty - checks if the stack is empty or not.
	 * @return true if there is no more elements in the stack.
	 */
	public boolean isEmpty();
	
	
}