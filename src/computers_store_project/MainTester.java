package computers_store_project;

import java.util.Scanner;

public class MainTester {

	
public static void PrintMenu(String type)
{
	String a = type;
	if(a.equals("Employee"))
	{
		System.out.println("1. Is_costumers_getting_served?. \n");
		System.out.println("2. Add to line. \n");
		System.out.println("3. Search Customer in line. \n");
		System.out.println("4. Remove from line. \n");
		System.out.println("5. Back.");
	}
	
//	if(a.equals("Manager"))
//	{
//		System.out.println("1. Edit Employee array in Wearhouse . \n");
//		System.out.println("2. Edit Supplier array in Wearhouse. \n");
//		System.out.println("3. search_item. \n");
//		System.out.println("4. Add item to Wearhouse. \n");
//		System.out.println("5. Remove item from Wearhouse. \n");
//		System.out.println("6. Print the Wearhouse Data. \n");
//	}
}
	

public static void HandleEmployee(Employee e,Customer c, Scanner s)
{
	int id;
	String name;
	int state = 1;
	
		 do
		 {
			 PrintMenu("Employee");
			 int choice = s.nextInt();
			 switch(choice)
			 {
			 case 1:
			 
				 System.out.println("is Customers getting served now?\n" +"\n" + e.is_costumers_getting_served() + "\n");
				 System.out.println("5. Back.\n");
				 break;
				 
			 case 2:
				 System.out.println("Who do you want to add to the line? \n");
				 id = s.nextInt();
				 name = s.nextLine();
				 if(c.getId() == id && c.getName().equals(name))
				 {
					 e.enqueue_line(c);			
					 e.PrintLine();
				 }
				 else
				 {
					 Customer c1 = new Customer(name,id,0,false); // creating a Customer for now.
				 	e.enqueue_line(c1);
				 }
				 	e.enqueue_line(c);
				 	System.out.println(c.getName()+ "\n" +c.getId() +"\n" + "was added to the list!\n");
				 	e.PrintLine();
				 
				 	id = 0;
				 	name = "";
				 break;
			 case 3:
				 System.out.println("Who you want to search for?\n");
				 e.search_costumer(c.getId());
				 System.out.println("The Customer we searched for is\n" + c.toString());
				 id   = s.nextInt();
				 name = s.nextLine();
				 if(e.search_costumer(id))
				 	{
				 System.out.println( id + name+ "was found! \n" );
				 	}
				 
				 //reset the variables we used
				 	id = 0;
				 	name = "";
				 break;
			 case 4:
				 System.out.println("Who you want to remove?\n");
				 id = s.nextInt();
				 
				 try {
				 e.dequeue_line(c.getId());
				 }catch(Exception e1)
				 {
					 System.out.println("exception deteced:" + e1.getMessage());
				 }
				 
				 System.out.println(c.getId() + "Was removed from the line!\n");
				 e.PrintLine();
				 id   = 0;
				 name = "";
				 break;
				 
			 case 5:
				 	System.out.println("Going back!\n");
				 	state = 0;
				 	break;
		  }
		 
		 } while(state!= 0);
		 	
       
}


public static void main(String[] args) 
{
    	
//        System.out.println("--- computers_store_project: Main Tester ---\n");
//        Scanner input = new Scanner(System.in);
//        String type = "";
//        type = input.next();
//        
        
  System.out.println("--- testing the costumer printing and the employee queue printing! ---" + "\n");
  Customer c1 = new Customer("Noa Bachash",208645769,300.0,true);
  Customer c2 = new Customer("Tom roni",287548659,600.0,false);
  Customer c3 = new Customer("Sarah Levi", 312456789, 1250.5, true);
  Customer c4 = new Customer("David Cohen", 204938475, 420.75, false);
  Employee e1 = new Employee("shalev",207160193,2500.0,c1);
        
  System.out.println("the employee's info:" + "\n");
  System.out.println(e1.toString());
        
  System.out.println("line before any changes! \n");
  e1.PrintLine();
        
      
  e1.enqueue_line(c2);
  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
  System.out.println("we have 2 people in list! " + "\n");
  e1.PrintLine();
        
  e1.enqueue_line(c3);
  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
  System.out.println("we have 3 people in list! " + "\n");
  e1.PrintLine();
        
  e1.enqueue_line(c4);
  System.out.println("line after adding the id: \n" + c2.getId() + "\n");
  System.out.println("we have 4 people in list! " + "\n");
  e1.PrintLine();
         
        
try {        
  e1.dequeue_line(c1.getId());
  System.out.println("line after removing the id: \n" + c1.getId() +"\n");
  e1.PrintLine();
        
  System.out.println("testing the toString of the employee after all the added costumers");
  System.out.println(e1.toString());
        
  e1.dequeue_line(c2.getId());
  System.out.println("line after removing the id: \n" + c2.getId() +"\n");
  e1.PrintLine();
        
  e1.dequeue_line(c3.getId());
  System.out.println("line after removing the id: \n" + c3.getId() +"\n");
  e1.PrintLine();
        
  e1.dequeue_line(c4.getId());
  System.out.println("line after removing all the id's" + "\n");
  e1.PrintLine();
  System.out.println("\n");
            
  System.out.println("trying to delete a costumer who is no longer in the line!");

	  e1.dequeue_line(c3.getId()); // this throws an exception.
}
catch(Exception e)
{
	System.err.println("Caught Excaption:" + e.getMessage());
}
        
        
        
  System.out.println("---end of testing the costumer printing and the employee queue printing!---" + "\n");
   
  System.out.println("---starting to chack the Wearhouse class!---" + "\n");
  Wearhouse w1 = new Wearhouse();
  try {
      Product p =  w1.get_stack().pop();
      System.out.println(p.toString());
      }catch(Exception e)
  {
          System.err.println("Caught Excaption:" + e.getMessage());
  }
        
        
        
        
        
        
        
//        Scanner input = new Scanner(System.in);
//        String state;
//        
        
       
        
//        	System.out.println("Who are you? Employee or Manager?\n");
//            System.out.println("Exit.\n");
//            state = input.nextLine();
//            
//        	switch(state)
//        	{
//        	case "Employee":
//        		HandleEmployee(e1,c1,input);
//        		break;
//        	
//        	case "Menager":
//        		System.out.println("work in progress");
//        		break;
//        		
//        	case "Exit":
//				 System.out.println("Exiting!\n");
//				 break;
//        
//        	}
        
//        System.out.println("\n--- End of tests ---\n");
    }
}
