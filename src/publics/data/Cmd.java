package publics.data;

import java.io.*;

public class Cmd 
implements publics.DataModel
{
	
	
	String para;
	
	public Cmd(String cmd)
	{
		para = cmd;
	}
	
	
	String out = "";
	public Object action()
	{
		try
		{
			Thread job = new Thread()
			{
				public void run()
				{
					int get;

					try
					{
						    InputStream is =
							    Runtime.getRuntime().
							    exec(para).getInputStream();


						    while((get=is.read())!=-1)
				            {
					            out+=(char)get;
				            }
					}
					catch(IOException e)
					{out = ""+e;}
				}
			};
			
			job.setDaemon(true);
			job.start();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{out = ""+e;}
		return out;
	}
	
	
	//
	

}
