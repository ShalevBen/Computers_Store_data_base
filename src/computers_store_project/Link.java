package computers_store_project;

public class Link 
{
		private Object data;
		private Link next;
		
public Link(Object Newdata, Link Newnext) 
{
	data = Newdata;
	next = Newnext;
}

public Link(Object data) 
{
		this(data, null);
}

public Object getData()
{
	return data;
}

public void setData(Object data)
{
	this.data = data;

}

public Link getNext()
{
		return next;
}

public void setNext(Link next) 
{
	this.next = next;
}
	

public String toString()
{

	String ans;
	ans =   data + "\n" + "next is: " +"\n" + next + "\n";
	return ans;
			
}

}
