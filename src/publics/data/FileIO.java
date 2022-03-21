package publics.data;

public class FileIO 
implements publics.DataModel
{
	
	int port;
	/**
	 * 
	 * @param port
	 */
	public FileIO(int port)
	{
		this.port = port;
	}
	
	
	public Object action()
	{
		String out = "0";
		
		try
		{
			Runtime.getRuntime().
		    exec("java publics.pr.fileio.FileIO "+port);
		}
		catch(Exception e)
		{
			out = "1"+e;
		}
		
		
		return out;
	}

}
