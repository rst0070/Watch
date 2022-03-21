package local.function;

import java.awt.BorderLayout;
import javax.swing.*;

public class Run 
extends JPanel
{
	JTextField jt = new JTextField(10);
	JButton jb = new JButton("RunOrder");
	
	public Run()
	{
		super();
		jb.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				String get = (String)
						local.main.Cm.processing(new publics.data.Run(jt.getText()));
				
				//에러 발생시 메세지창
				if(get.charAt(0)=='1')
					local.main.Tool.alert(get);
			}
		});
		add(jt);
		add(jb);
	}

}
