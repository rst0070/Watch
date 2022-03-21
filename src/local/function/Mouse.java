package local.function;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Mouse 
extends JPanel
implements ActionListener
{
	JButton j3 = new JButton("move");
	JButton j4 = new JButton("ClickLeft");
	JButton j5 = new JButton("ClickRight");
	
	
	JTextField j1 = new JTextField(5);
	JTextField j2 = new JTextField(5);
	
	String j1s = j1.getText();
	String j2s = j2.getText();
	
	
//****************************
	//버튼 엑션
	
		public void actionPerformed(ActionEvent e)
		{
			JButton ob = (JButton)e.getSource();
			
			//move
			if(ob==j3)
			{
				local.main.Tool.alert(j1.getText()+","+j2.getText());
				String get = (String)
						local.main.Cm.processing(new publics.data.Mouse(
						Integer.getInteger(j1.getText()),Integer.getInteger(j2.getText())));
				
				
				if(get.charAt(0)=='1')
					local.main.Tool.alert(get);
			}
			//click
			if(ob==j4)
			{
				
			}
		}
		

	
	public Mouse()
	{
		super();
		
		j3.addActionListener(this);
		
		add(new JLabel("x :"));
		add(j1);
		add(new JLabel("y :"));
		add(j2);
		add(j3);
	}

}
