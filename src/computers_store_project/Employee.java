package computers_store_project;

public class Employee 
{

	private String name;
	private int id;
	private double selary;
	private LinkedQueue given_service_to;
	//a queue implemented as a linked list of costumers he gave service to.
	
public Employee(String given_name,int given_id,double given_selary,Customer given_customer)
{
		
		name = given_name;
		id = given_id;
		selary = given_selary;
		given_service_to = new LinkedQueue();
		given_service_to.Enqueue(given_customer);
}
	
	// name and id getters. seters not needed.
public String get_name()
{
		
		return name;
}


public int get_id() 
{
		return id;		
}
	
//other stuff
public double get_selary()

{
		return selary;	
}

public void set_selary(double given_selary)
{
		
		selary = given_selary;
}
	

public String toString()
{
	String ans = "";
	 ans = "name: " + name + "\n" +"Id: " + id +"\n" +"selary: " + selary + "\n" +
		   "\n" + "the queue of costumers for the employee is:" + "\n" + given_service_to.printLinkedQueue();
	return ans;
}

//chackeing if the employee is serving costumers or not. (if the q is empty )
public boolean is_costumers_getting_served()
{
	return given_service_to.isQueueEmpty();
}
	
public void enqueue_line(Customer given_costumer)
{
	//inserting the costumer to the queue
	given_service_to.Enqueue(given_costumer);
}

//looking through the queue and saying wheter a given id is in the queue
public boolean search_costumer(int given_id)
{
	LinkedQueue temp_q = new LinkedQueue();
	Customer temp_c = null;
	int counter = 0;
	boolean flag = false;
	
	/* 
	 * after you find the customer you need
	 * you need to dequeue the whole queue and requeue it back
	 * to save the order of the queue
	 * */
	while(!(given_service_to.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = given_service_to.Dequeue();
		if(temp_c.getId() == given_id)
		{
			//you found him and you are making sure he is getting sent to the temp queue
			flag = true;
			counter++;
			temp_q.Enqueue(temp_c);
		}
		else 
		{
			counter++;
			temp_q.Enqueue(temp_c);
		}	
	}
	
	/*
	 * gets the queue back in order.
	 * */
		for(int i = 0; i< counter ;i++)
		{
			given_service_to.Enqueue(temp_q.Dequeue());
		}
		return flag;
}

public Customer dequeue_line(int given_id) throws Exception
{
	
	// make sure the queue isnt empty whan you try to dequeue a costumer
	if(given_service_to.isQueueEmpty())
	{
		throw new NullPointerException("The queue is empty! cant dequeue a costumer!" + "\n");
	}
	
	
	// making sure first the customer is in the queue
	if(!(search_costumer(given_id)))
	{
		System.out.println("the customer is not in the queue");
		return null;
	}
	
	LinkedQueue temp_q = new LinkedQueue();
	Customer temp_c = null;
	Customer temp_c_2 = null;
	int counter = 0;
	
	/* 
	 * after you find the customer you need
	 * you need to dequeue the whole queue and requeue it back
	 * to save the order of the queue
	 * */
	while(!(given_service_to.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = given_service_to.Dequeue();
		if(temp_c.getId() == given_id)
		{
			temp_c_2 = temp_c;
		}
		else 
		{
			counter++;
			temp_q.Enqueue(temp_c);
		}	
	}
	
	// requeing the OG queue in order
	for(int i = 0; i< counter ;i++)
	{
		given_service_to.Enqueue(temp_q.Dequeue());
	}
	return temp_c_2;
}
	

public void PrintLine()
{
	System.out.println(given_service_to.printLinkedQueue());
}

}