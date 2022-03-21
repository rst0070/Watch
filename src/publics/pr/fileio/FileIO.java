package publics.pr.fileio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import publics.DataModel;

public class FileIO {

	
	public FileIO(int port)
	{
		setIO(port);
		while(true)
		{
			try
			{
				publics.DataModel get = (DataModel) it.readObject();
				ot.writeObject(get.action());
			}
			catch(IOException e)
			{
				
			} 
			catch (ClassNotFoundException e)
			{
				
			}
		}
		
	}
	

	
	
/**
 * set IO
 * 
 * socket
 * stream
 * 
 * 
 */
	Socket s;
	ObjectInputStream it;
	ObjectOutputStream ot;
	void setIO(int port)
	{
		try
		{
			s =
			new Socket(remote.main.Main.server,port);
			it = new ObjectInputStream(s.getInputStream());
			ot = new ObjectOutputStream(s.getOutputStream());
		}
		catch(IOException e)
		{
			
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		new FileIO( Integer.parseInt(args[0]) );
		new javax.swing.JFrame("sss").setVisible(true);
	}
}
