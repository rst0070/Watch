package publics.data;

import java.io.*;

public class AddFunction 
implements publics.DataModel
{
	String savePath;
	byte[] content;
	
	public AddFunction(String Path,byte[] c)
	{
		this.savePath = Path;
		content = c;
	}
	
	public Object action()
	{
		String rt = "0";
		
		
		System.out.println(savePath);
		File f = new File(savePath);
		
		//String path = savePath;
		//String classPath = "";
		//char tmp;
		try
		{
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(content);
			fo.close();
			
			/*for(int i=0;i<path.length();i++)
			{
				tmp = path.charAt(i);
				if(tmp=='/')
				{
					classPath+=".";
				}
				else
				{
					classPath+=tmp;
				}
				
			}
			
			Class.forName(classPath);*/
		}
		/*catch(ClassNotFoundException e)
		{
			rt = "1"+e;
			System.out.println(e);
		}*/
		catch(java.io.IOException e)
		{
			try
			{
				f.createNewFile();
				FileOutputStream fo = new FileOutputStream(f);
				fo.write(content);
				fo.close();
			}
			catch(IOException ex)
			{
				rt = "1"+ex;
				System.out.println(ex);
			}
			
		}
		return rt;
	}

}
