package computers_store_project;

public class MainTester {

	public static void main(String[] args) {

		System.out.println("--- computers_store_project: Main Tester ---\n");

		Customer c1 = new Customer("Noa Bachash", 208645769, 300.0, true);
		Customer c2 = new Customer("Tom roni",287548659,600.0,false);
		Customer c3 = new Customer("Sarah Levi", 312456789, 1250.5, true);
		Customer c4 = new Customer("David Cohen", 204938475, 420.75, false);
		Employee e1 = new Employee("shalev", 207160193, 2500.0, c1);
		Wearhouse w1 = new Wearhouse();
		
		Keyboards k1 = new Keyboards(298675093, "mechanical", 300.0, 36);
		Keyboards k2 = new Keyboards(786954325, "magnetic", 500.0, 24);
		Keyboards k3 = new Keyboards(163748295, "wireless", 450.0, 12);
		Keyboards k4 = new Keyboards(999888777, "rgb-mechanical", 400.0, 24);
		Supplier s1 = new Supplier("Amit Levi", "0501234567", "TechSource Ltd", k1);
		Supplier s2 = new Supplier("Dana Cohen", "0527654321", "MegaParts Supply", k2);
		Supplier s3 = new Supplier("Yossi Ben David", "0549876543", "ProHardware Distributors", k3);

		w1.Add_employee(e1);
		w1.get_Stack().push(k1);
		w1.get_Stack().push(k2);

		Customer[] customers = {c1,c2,c3,c4};

		System.out.println("--- testing the costumer  and the employee  ---" + "\n");
		System.out.println("The customers that are presented at the moment \n");
		System.out.println("The customers are: \n");
		for(int i =0; i < customers.length; i++)
		{
			System.out.println(customers[i].toString()+"\n");
		}

		System.out.println("Giving all the vip's discounts: \n");

		System.out.println("The customers after discounts for the vip's \n");
		for(int i =0; i < customers.length; i++)
		{
			customers[i].ApplyDisc();
			System.out.println(customers[i].toString());
		}


		System.out.println("the employee's info:" + "\n");
		System.out.println(e1.toString() + "\n");
		
		System.out.println("Chacking if customers are getting served!\n" + e1.Is_costumers_getting_served());
		
		System.out.println("Looking to see if:  \n" + c1.getId() + "is in the queue\n" + e1.search_costumer(c1.getId()));
	

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
			System.out.println("testing the toString of the employee after all the added costumers");
			System.out.println(e1.toString());

			e1.dequeue_line(c1.getId());
			System.out.println("line after removing the id: \n" + c1.getId() +"\n");
			e1.PrintLine();


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

			e1.dequeue_line(c3.getId());
		}
		catch(Exception e)
		{
			System.err.println("Caught Excaption:" + e.getMessage());
		}



		System.out.println("---end of testing the costumer printing and the employee queue printing!---" + "\n");

		System.out.println("---starting to chack the Wearhouse class!---" + "\n");

		System.out.println("Looking if an employee is in the wearhouse! \n" + w1.Is_employee_in_array(e1)+"\n");
		
		System.out.println("Looking if a supplier is in the wearhouse! \n" + w1.Is_supplier_in_array(s1.getPhone()));
		
		System.out.println("The employee array before the changes: \n" + w1.Show_employees() + "\n");
		System.out.println("Removing an employee from the wearhouse! \n");
		w1.Remove_employee("Emp1",101);
		
		System.out.println("The wearhouse array after changes");
		System.out.println(w1.Show_employees());
		
		w1.Add_supplier(s2);
	
		System.out.println("Add an iteam from one of the suppliers! \n");
		try {
			w1.Add_to_wearhouse_from_supplier("0549876543", 298675093);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("testing the Wearhouse pop function whan there is a product the wearhouse" + "\n");
		try {
			Product p =  w1.get_Stack().pop();
			System.out.println("poped: \n" + p+"\n");
		}catch(Exception e)
		{
			System.err.println("Caught Excaption:" + e.getMessage());
		}

		System.out.println("test to push to the stack" + "\n");
		if(!(w1.Is_product_in_wearhouse(k2.getId())))
		{
			w1.get_Stack().push(k2);

		}
		System.out.println("The item:" + k2.toString()+"\n" + "already in the stack! \n");
		if(!(w1.Is_product_in_wearhouse(k1.getId())))
		{
			w1.get_Stack().push(k1);	  
		}
		System.out.println("The item: \n" + k1.toString()+"\n" + " already in the stack! \n");

		System.out.println("-- test to print the stack after i poped an item --" + "\n");
		System.out.println(w1.get_Stack().toString() + "\n");
		
		System.out.println("Testing search product func! \n");
		try {
			w1.search_product(99999999);
		} catch (Exception e) {
			System.err.println("Caught Excaption: " + e.getMessage());
		}
		
		
		System.out.println("----- Supplier tests -----\n");
		
		System.out.println("Adding more items to the supplier so we can test the remove func! \n");
		s1.addLastProduct(k2);
		s1.addLastProduct(k3);
		s1.addLastProduct(k4);
		
		System.out.println("Looking at the s1 product list! \n");
		System.out.println(s1.getList().PrintList());
		
		System.out.println("The details of the supplier we trying to remove an item from! \n" + s1.toString() + "\n");
		ProductLink p = s1.removeProduct(k1.getId());
		System.out.println("The product we got from the supplier is: \n" +p.toString() + "\n");
		
	
		ProductLink p1 = s1.removeProduct(k2.getId());
		System.out.println("The product we got from the supplier is: \n" +p1.toString() + "\n");
		
		ProductLink p2 = s1.removeProduct(k3.getId());
		System.out.println("The product we got from the supplier is: \n" +p2.toString() + "\n");

		ProductLink p3 = s1.removeProduct(k4.getId());
		System.out.println("The product we got from the supplier is: \n" +p3.toString() + "\n");
		

		System.out.println("testing the show supplier method.\n");
		
		w1.Add_supplier(s1);
		w1.Add_supplier(s2);
		w1.Add_supplier(s3);
		System.out.println(w1.Show_suppliers());
		
		System.out.println("End of testing for Wearhouse");
		System.out.println("\n--- End of tests ---\n");
	}
}