package computers_store_project;

public class Keyboards extends Product 
{
	/**
	 * Constructor for Keyboards. Initializes a keyboard product by invoking the superclass Product constructor.
	 *
	 * @param given_id       Unique product ID.
	 * @param given_type     Keyboard type (e.g., "mechanical", "wireless").
	 * @param given_price    Price of the keyboard.
	 * @param given_warranty Warranty duration in months.
	 */
	public Keyboards(int given_id,String given_type,double given_price,int given_warranty)
	{
		super(given_id,given_type,given_price,given_warranty);
	}
	
	
	
}
