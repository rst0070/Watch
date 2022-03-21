package local.function;

import javax.swing.*;

import java.io.*;

public class AddFunction 
extends JPanel
implements java.awt.event.ActionListener
{
	
	JFileChooser fileChooser = new JFileChooser("");
	JButton jb = new JButton("select(publics/data)");
	
	
	public AddFunction()
	{
		super();

		fileChooser.setCurrentDirectory(new File("publics/data/"));
		fileChooser.setApproveButtonText("select");
		fileChooser.setFileFilter(
				 new javax.swing.filechooser.
				 FileNameExtensionFilter("class", "class"));
		 
		 
		 
		 
		 //when click select button
		 jb.addActionListener(this);
		 
		 
		 add(jb);
		
	}

	
	String get;
	
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		JButton event = (JButton)e.getSource();
		if(event==jb)
		{
			 action(JOptionPane.showInputDialog(
						"save where of remote?\n"
						+ "ex) publics/data/"));
		}
		
	 }
	
	
	/**
	 * 직접적으로 객체 보내고 반환값 받는곳
	 * @param path : 원격컴퓨터에 저장할 경로
	 */
	void action(String path)
	{
		int result = fileChooser.showOpenDialog(local.main.Main.jf);
        
        
        //save 버튼 반환했을때
       if (result == JFileChooser.APPROVE_OPTION) 
        {
    	   try
    	   {
    		  File f = fileChooser.getSelectedFile();
    		  local.main.Tool.alert(f.toString());
    		  FileInputStream r = new FileInputStream(f);
    		  
    		  
    		  byte[] out = new byte[r.available()];
    		  
    		  if((r.read(out))==-1)
    			  local.main.Tool.alert("read error");
    		 
    		  
    		  local.main.Tool.alert(path+f.getName());
    		  get = (String)
    				  local.main.Cm.processing(new publics.data.AddFunction(path+f.getName(),out));
    		  if(get.charAt(0)=='1')
    			  local.main.Tool.alert(get);
    	   }
    	   catch(Exception ex)
    	   { local.main.Tool.alert(ex+"");}
    	   
        }
	}
}
