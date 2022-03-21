package remote.main;

import java.io.*;
import java.net.Socket;

public class Main {
	
	public static String server;
	
	
	
	/**
	 * 서버에 접속해 
	 * 1:1프로그램이 대기하고
	 * 있는 포트번호를 받아 work 생성자에 넘겨줌
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		server = args[0];
		try
		{
			Socket s = new Socket(server,Integer.parseInt(args[1]));
			//s.connect(s.getRemoteSocketAddress());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			int get = ((Integer)ois.readObject()).intValue();
			s.close();
			
			new Work(get);
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
