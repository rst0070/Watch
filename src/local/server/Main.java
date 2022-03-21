package local.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.net.*;
import java.io.*;

/**
 * '감시' 는 로컬의 서버와 원격의 클라이언트간의 연결로 로컬에서 원격 컴퓨터를 조종한다.<br>
 * <code>local.server</code>패키지는 로컬에서 서버를 열어 원격의 클라이언트와의 접속을 수행하며,<br>
 * <code>local.main.Main</code>에 접속정보를 전달하며 새로운 프로세스로 원격조종을 실행한다.
 * 
 * @author risesoft<br>
 * 
 *
 *
 */
public class Main {
	
/**
 * main-->Main(생성자)<swing설정들>
 * -->searchButton<상대컴퓨터 검색>
 * -->화면에 상대컴퓨터 접속용 버튼 생성
 * -->클릭
 * -->1:1 프로그램 실행
 * 
 * 
 * 
 * 
 * 
 */
		
		
		public static JFrame jf = new JFrame("감시자");
		JPanel Panel = new JPanel();
		JButton search = new JButton("search");
		
		
		
		
		
		public Main(){	
			
			serverSet();
			
			
			//set searchButton
			search.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					connect();
				}
			});
			
			Panel.add(search);
			
			
			
			
			/* set JFrame */
			jf.add(Panel);
			jf.setBounds(0,0,530,530);
		    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
		}
		
		
	
		

		
//***************************
// 서버 설정
//
			
		ServerSocket sv;
		void serverSet()
		{
			try
			{
				sv = new ServerSocket(Port);
				sv.setSoTimeout(5000);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			
		}
		
		
		
		
		
//***************************************
//***************************************
//***************************************
		//search 버튼에서 실행되는 부분
		//상대와 연결을 한다
		
		public static int Port = 3333;
		int nowPort = Port;
		void connect()
		{
			try
			{
				Socket get = sv.accept();
				
				
					Panel.add(new HostButton(get,nowPort+=1));
					//get.close();
					jf.setVisible(true);
					//Panel.add(new JButton("eee"));
				
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			
		}
		
		public static void main(String[] args){
			new Main();
		}

}
