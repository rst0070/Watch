package local.function;

import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class FileIO 
extends JPanel
implements ActionListener
{
	JButton start = new JButton("start");
	
	public FileIO()
	{
		super();
		start.addActionListener(this);
		add(start);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
			try
			{
				String Str = "";
				Str = JOptionPane.showInputDialog(
						"please input what do you use number of port");
				
				
				String st = (String)
						local.main.Cm.processing(new publics.data.FileIO(Integer.parseInt(Str)));
				if(st.charAt(0)=='1')
					local.main.Tool.alert(st);
				
				
				Runtime.getRuntime().
			    exec("java user.work.pr.fileio.FileIO "+Str);
			}
			catch(Exception ex)
			{
				local.main.Tool.alert(ex+"");
			}
		
		
	}
	
	
	


}
