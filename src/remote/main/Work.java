package remote.main;

import java.net.Socket;
import java.io.*;

public class Work {

	
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	//BufferedInputStream it;
	//BufferedOutputStream ot;
	InputStream it;
	OutputStream ot;
	
	public Work(int port)
	{
		ioSet(port);
		
		
		while(true)
		{
			start();
		}
		
	}
	
	
	
	void ioSet(int port){
		
		try{
			s = new Socket(Main.server,port);
			System.out.println("ddd");
			
			it = s.getInputStream();
			ot = s.getOutputStream();
			/*
			 * 스트림 정의
			 */
			       ois = new ObjectInputStream(it);
			       System.out.println("input stream ok");
			       oos = new ObjectOutputStream(ot);
			       System.out.println("output stream ok");
		}
		catch(IOException e){
			ioSet(port);
		}
    }
	
	
	/*
	 * 통신 하는 부분
	 * 객체를 가져와 정의된 메소드 실행후
	 * 리턴값 되돌려줌
	 */
	void start(){
		
		
		try
		{
			publics.DataModel get = (publics.DataModel)ois.readObject();
			oos.writeObject(get.action());
			//oos.writeObject("ddd");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(EOFException e)
		{
			System.out.println(e);
			System.exit(0);
		}
		catch(java.net.SocketException e)
		{
			System.out.println(e);
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
