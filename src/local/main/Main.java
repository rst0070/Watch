package local.main;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.net.*;
import java.io.*;

/**
 * <pre>
 * user.work.Main
 * 새로운 프로세스로 시작되는 부분입니다
 * 
 * 
 * 
 * </pre>
 * @author risesoft
 *
 */
public class Main {
	
	public static Socket s;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	
	//BufferedInputStream it;
	//BufferedOutputStream ot;
	//InputStream it;
	//OutputStream ot;
	public static int port;
	public static JFrame jf ;
	
	
	
	public Main()
	{
		
		ioSet();
		jf = new JFrame(s.getRemoteSocketAddress()+"");
		
		tabSet();
		
		
		jf.setBounds(1,1,550,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	
	/**
	 * io 연결 설정
	 */
	void ioSet()
	{
		try
		{
			ServerSocket ss = new ServerSocket(port);
			s =  ss.accept();
			ss.close();
			
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			
			//new Main();
		}
		catch(IOException e)
		{
			Tool.alert(e+"");
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	/**
	 * set Tab
	 */
	void tabSet()
	{
		JTabbedPane jtp = new JTabbedPane();
		
		jtp.addTab("Cmd",
				new local.function.Cmd());
		jtp.addTab("run",
				new local.function.Run());
		jtp.addTab("capture",
				new local.function.ScreenCapture());
		jtp.addTab("Mouse",
				new local.function.Mouse());
		jtp.addTab("KeyBoard",
				new local.function.KeyBoard());
		jtp.addTab("FileIO",
				new local.function.FileIO());
		jtp.addTab("AddFunction",
				new local.function.AddFunction());
		
		jf.add(jtp);
	}
	
	
	
	//화면 새로고침
	public static void f5()
	{
		jf.setVisible(true);
	}
	
	
	/**
	 * 상대와 기본적인 연결을 만든다
	 * @param args : 서버소켓이 대기해야할 포트
	 */
	public static void main(String[] args)
	{
		//Tool.alert(args[0]);
		port = Integer.parseInt(args[0]);
		new Main();
	}

}
