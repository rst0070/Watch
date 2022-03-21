package local.function;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class Cmd 
extends JPanel
{
	
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	JScrollPane jsp = new JScrollPane();
	//JTextArea jta = new JTextArea(25,40);
	JTextArea jta = new JTextArea();
	JCheckBox jb = new JCheckBox("recode "+"in succession");
	
	JTextField jtf = new JTextField(20);
	JButton jbt = new JButton("start");
	JButton erase = new JButton("erase");
	
	public Cmd(){
		super();
		jsp.setViewportView(jta);
		
        //start 버튼에 대한 이벤트
		jbt.addActionListener(
			new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				action();
		    }
		});
		//erase 버튼에 대한 이벤트
		erase.addActionListener(
			new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jta.setText("");
		    }
		});

		jp1.add(jtf);
		jp1.add(jbt);
		jp1.add(erase);
		jp1.add(jb);
		
		jp2.setLayout(new GridLayout());
		jp2.add(jsp);
		setLayout(new BorderLayout(5,5));
		add(jp1,BorderLayout.NORTH);
		add(jp2,BorderLayout.CENTER);
	}
	
	
	void action(){
		String get =
				local.main.Cm.processing(new publics.data.Cmd(jtf.getText()))+"";
		
		if(jb.isSelected()==true){

             jta.setText(jta.getText()
				 +"<<<input>>>\n"+jtf.getText()+"\n\n"+"<<<return>>>\n"+
            		get
				 +"\n\n\n"+"***************next order***********************"+"\n\n\n");}
        else{
		     jta.setText("<<input>>\n"+jtf.getText()+"\n\n"+"<<return>>\n"+get);
		}

	}

}
