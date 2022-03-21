package publics.pr.fileio;


import java.io.*;

public class Data
implements publics.DataModel{
	
	int index;
	
	
	
	public byte[] data;
	public String path;
	/*public static Data send(String path,byte[] data)
	{
		Data out = new Data();
		try
		{
			
		
		out.path = path;
		out.data = data;
		out.index = 1;
		}
		catch(Exception e)
		{user.work.Tool.alert(e+"wewewewe");}
		return out;
	}*/
	
	public Data(String path,byte[] data)
	{
		
		try
		{
			this.path = path;
			this.data = data;
			this.index = 1;
		
		}
		catch(Exception e)
		{local.main.Tool.alert(e+"wewewewe");}
	}
	
	
	public Object action()
	{
		Object out = null;
		
		if(index==1)
		{
			try
			{
				File f = new File(path);
				FileOutputStream o = new FileOutputStream(f);
				o.write(data);
				o.close();
			}
			catch(IOException e)
			{System.out.println(e);}
			
		}
		
		
		return out;
	}

}