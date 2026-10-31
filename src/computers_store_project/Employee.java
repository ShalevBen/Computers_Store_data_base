package computers_store_project;

public class Employee 
{

	private String name;
	private int id;
	private double selary;
	private LinkedQueue costumer_line;
	//a queue implemented as a linked list of costumers he gave service to.
	
public Employee(String given_name,int given_id,double given_selary,Customer given_customer)
{
		
		name = given_name;
		id = given_id;
		selary = given_selary;
		costumer_line = new LinkedQueue();
		costumer_line.Enqueue(given_customer);
}
 /*
  * a constructor that will build a basic employee */
public Employee(String given_name,int given_id)
{
		
		name = given_name;
		id = given_id;
		selary = 0;
		costumer_line = new LinkedQueue();
}
public Employee (Employee given_employee)
{
	name = given_employee.get_name();
	id = given_employee.get_id();
	selary = given_employee.get_selary();
	costumer_line = given_employee.getLine();

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

public LinkedQueue getLine()
{
	return costumer_line;
}
	
public String toString()
{
	String ans = "";
	 ans = "name: " + name + "\n" +"Id: " + id +"\n" +"selary: " + selary + "\n" +
		   "\n" + "the queue of costumers for the employee is:" + "\n" + costumer_line.printLinkedQueue() + "\n";
	return ans;
}

//chackeing if the employee is serving costumers or not. (if the q is empty )
public boolean Is_costumers_getting_served()
{
	return !(costumer_line.isQueueEmpty());
}

public boolean Is_costumer_in_line(int given_id)
{
	Link node = costumer_line.getList().getNode();
	if(node == null)
	{
		System.out.println("Cant search Line while its empty! \n");
		return false;
	}
	Customer temp = null;
	
	while(node != null)
	{
		temp = (Customer) node.getData();
		if(temp.getId() == given_id)
		{
			return true;
		}
		node = node.getNext();
	}
	return false;
	
	
}
	
public void enqueue_line(Customer given_costumer)
{
	if(Is_costumer_in_line(given_costumer.getId()))
	{
		System.out.println("The costumer is already in the Line! \n");
		return;
	}
	//inserting the costumer to the queue
	costumer_line.Enqueue(given_costumer);
}

//looking through the queue and bringing the costumer.
public Customer search_costumer(int given_id)
{
	LinkedQueue temp_q = new LinkedQueue();
	Customer temp_c = null;
	Customer temp_c1 = null;
	int counter = 0;
	
	/* 
	 * after you find the customer you need
	 * you need to dequeue the whole queue and requeue it back
	 * to save the order of the queue
	 * */
	while(!(costumer_line.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = costumer_line.Dequeue();
		if(temp_c.getId() == given_id)
		{
			temp_c1 = temp_c;
			//you found him and you are making sure he is getting sent to the temp queue
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
			costumer_line.Enqueue(temp_q.Dequeue());
		}
		return temp_c1;
}

public Customer dequeue_line(int given_id) throws Exception
{
	
	// make sure the queue isnt empty whan you try to dequeue a costumer
	if(costumer_line.isQueueEmpty())
	{
		throw new Exception("The queue is empty! cant dequeue a costumer!" + "\n");
	}
	
	
	// making sure first the customer is in the queue
	if(!(Is_costumer_in_line(given_id)))
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
	while(!(costumer_line.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = costumer_line.Dequeue();
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
		costumer_line.Enqueue(temp_q.Dequeue());
	}
	return temp_c_2;
}
	
public void PrintLine()
{
	System.out.println(costumer_line.printLinkedQueue());
}

}