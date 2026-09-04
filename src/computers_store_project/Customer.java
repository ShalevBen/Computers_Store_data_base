package computers_store_project;

public class Customer 
{
	private String name;
	private int id;
	private double amount_payed;
	private boolean is_vip;


//constructor with params
public Customer(String given_name,int given_id,double given_payment,boolean given_vip)
{
	name = given_name;
	id = given_id;
	amount_payed = given_payment;
	is_vip = given_vip;

}

//will get the name
public String getName()
{
	return name;
}

//will get the id
public int getId()
{
return id;	
}

//setter and getter for the amount_payed
public void setAmount_payed(double given_pay)
{
		amount_payed = given_pay;
}
public double getAmount_payed()
{
	return amount_payed;	
}

//setter and getter for is_vip
public void setIs_vip(boolean given_status)
{
	is_vip = given_status;
}

public boolean getIs_vip()
{
	return is_vip;	
}

public String toString()
{
	String ans;
	ans = "name: " + name +"\n" + "Id: " + id +"\n" +"amount_payed: " +amount_payed + "\n"+ "is vip? : " +is_vip +"\n";
	return ans;
}


}

