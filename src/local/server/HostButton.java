package local.server;


import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 * 
 * @author risesoft
 *
 */
public class HostButton 
extends JButton{
	
	
	
	Socket s;
	int port;
	
	
	
	public HostButton(Socket get,int port){
		
		
		this.port = port;
		s = get;
		setText(get.getRemoteSocketAddress()+"");
		addActionListener(al);
				
	}

	
	/**
	 * 이 클래스의
	 * 액션 처리 객체
	 */
	ActionListener al
	= new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			start();
		}
	};
	
	
	
	
	
	/**
	 * 1:1 프로그램 실행
	 */
	public void start(){
		
		try
		{
			/*
			 * 상대에게 접속해야할 포트 알려줌
			 */
			ObjectOutputStream ins = new ObjectOutputStream(s.getOutputStream());
			ins.writeObject(new Integer(port));
			ins.close();
			s.close();
			
			/*
			 * 1:1 프로그램 실행
			 */
			//Runtime.getRuntime().exec("notepad");
		    Runtime.getRuntime().exec("java local.main.Main "+port);
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		
		
		
	}
}
