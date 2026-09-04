package computers_store_project;

public abstract class Product 
{
	private int id;
	private String type;
	private double price;
	private int warranty;
	
	
// product constractor
public 	Product(int given_id ,String given_type ,double given_price,int given_warranty)
{
	this.id = given_id;
	this.type = given_type;
	this.price = given_price;
	this.warranty = given_warranty;
}
	
//will set and get the id for the product
public  void setId(int given_id)
{
	this.id = given_id;
}

public  int getId()
{
	return this.id;	
}

//will set and get the model of the product (keyboard , mouse , monitor...)
public  void setType(String given_type)
{
	this.type = given_type;
}

public  String getType()
{
	return this.type;
}

//will set and get the price for the product
public  void setPrice(double given_price)
{
	this.price = given_price;
}

public  double getPrice()
{
	return this.price;
}

//will set and get the number of months for warranty
public  void setWarranty( int given_warranty)
{
	this.warranty = given_warranty;
}

public  int getWarranty()
{
	return this.warranty;
}

public String toString()
{
	 String ans;
	 ans = ("Id: " + id +"\n" +"type: " + type +"\n" + "price: " + price +"\n" +"warranty: " + warranty +"\n");
	 return ans;
}

public void GiveDiscount(double dis)
{
	double precent = dis/100; //gives the amount of discount like 10% or 20%...
	double discount = getPrice()*precent; // amount of money to remove from price
	setPrice(getPrice()-discount); //new price
}
//will calculate the price after vat
public double applyVat()
{
	double VatInIsreal = 0.18;
	double amount_of_vat = price*VatInIsreal;
	double after_vat = price + amount_of_vat;
	return after_vat;
}

//will add\subtract warranty, return a massage if wasnt spacifid
public void change_warrenty(String type,int number_to_change)
{
	
	if(type.equals("add") )
	{
		warranty += number_to_change;
		return;
	}
	
	if(type.equals("subtract"))
	{
		warranty -= number_to_change;
		return;
	}
	
	System.out.println("the type of opperation wasnt spacifid");
	return;
}




}