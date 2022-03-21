package user.work.pr.fileio;

import java.io.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import local.main.Tool;

public class FileIO 
implements ActionListener{
	
	JFrame jf = new JFrame("FileIO");
	JPanel jp = new JPanel();
	JButton send = new JButton("send");
	JButton get = new JButton("get");
	
	JFileChooser fileChooser;
	
	public FileIO(int port){
		setIO(port);
		
		fileChooser = new JFileChooser("");
		fileChooser.setApproveButtonText("select");
       
		send.addActionListener(this);
		get.addActionListener(this);
		
		jp.add(send);
		jp.add(get);
		jf.add(jp);
		jf.setBounds(1,1,200,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	
	
	
/**
  * set IO
  * 
  * socket
  * stream
  */
	Socket s;
	ObjectInputStream it;
	ObjectOutputStream ot;
	void setIO(int port){
		try
		{
			s =
			new ServerSocket(port).accept();
			ot = new ObjectOutputStream(s.getOutputStream());
			it = new ObjectInputStream(s.getInputStream());
		}
		catch(IOException e)
		{
			
		}
	}
	
	
	
	
	
	
	
/**
 * 버튼 액션 이벤트
 * *******
 * ***
 * *******
 * ***
 * *******
 */
	public void actionPerformed(ActionEvent e)
	{
		JButton obj = (JButton)e.getSource();
		
		if(obj==send)
		{
			send();
		}
		
		if(obj==get)
		{
			
		}
	}
	
	
	
	
//send button event
	//
	//
	
	void send()
	{
		int result = fileChooser.showOpenDialog(jf);
        
        
       if (result == JFileChooser.APPROVE_OPTION) 
        {
    	   try
    	   {
    		  File f = fileChooser.getSelectedFile();
    		  Tool.alert(f.toString());
    		  FileInputStream r = new FileInputStream(f);
    		  
    		  
    		  byte[] out = new byte[r.available()];
    		  int tmp = r.read(out);
    		  if(tmp==-1)
    			  Tool.alert("read error");
    		  
    		  Tool.alert(out+"");
    		  
    		  r.close();
    		  Tool.alert("rrrr");
    		  String s = JOptionPane.showInputDialog("save where");
    		  Tool.alert(s);
    		  Object ob = new publics.pr.fileio.Data(s,out);
    		  ot.writeObject(ob);
    		  Tool.alert(it.readObject()+"");
    		  Tool.alert("rrrr");
    	   }
    	   catch(Exception ex)
    	   { Tool.alert("error : "+ex);}
    	   
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		new FileIO( Integer.parseInt(args[0]) );
		
	}

}
