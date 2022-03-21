package publics.data;

public class Run 
implements publics.DataModel
{
	String order;
	
	public Run(String order)
	{
		this.order = order;
	}
	
	public Object action()
	{
		String rt = "0";
		try
		{
			Runtime.getRuntime().
		    exec(order);
		}
		catch(java.io.IOException e)
		{
			rt = 1+""+e;
			System.out.println(e);
		}
		return rt;
	}

}
