package local.main;

import java.io.*;
public class Cm {

	
	/**
	 * 
	 * @param get : DataModel
	 * @return 처리결과 , 실패시 null
	 */
	public static Object processing(Object get)
	{
		Object out = null;
		try
		{
			if(Main.s.isConnected()==false)
			{
				Tool.alert("Socket Connect false"
						+" so you can't connection with remote");
			}
			Main.oos.writeObject(get);
			out = Main.ois.readObject();
		}
		catch(IOException e)
		{Tool.alert(e+"");}
		catch(ClassNotFoundException e)
		{Tool.alert(e+"");}
		
		return out;
	}
}
