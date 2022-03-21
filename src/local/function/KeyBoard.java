package local.function;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;




public class KeyBoard 
extends JPanel
implements ActionListener
{
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	JTextField get = new JTextField(30);
	JButton jb = new JButton("action");
	
	
	JButton[] special = 
		{new JButton("back_space"),
			new JButton("한/영")};
	//JButton jb = new JButton("action");
	//JButton jb = new JButton("action");
	
	public KeyBoard(){
		super();
		setLayout(new BorderLayout(5,5));
		jb.addActionListener(this);
		

		north.add(get);
		north.add(jb);
		add(north,BorderLayout.NORTH);
		
		
		for(int i=0;i<special.length;i++)
		{
			special[i].addActionListener(this);
			center.add(special[i]);
		}
		add(center);
		
	}
	
	
	String s;
	int[] out;
	public void actionPerformed(java.awt.event.ActionEvent e){
		JButton obj = (JButton)e.getSource();
		if(obj==jb){
			String g = get.getText();
			out = new int[g.length()];
			
			
			char tmp;
			boolean check = true;
			for(int i=0;i<out.length;i++){
				tmp = g.charAt(i);
				switch(tmp){
				
					case 'a' : out[i] = 0x41;
					break;
					case 'b' : out[i] = 0x42;
					break;
					case 'c' : out[i] = 0x43;
					break;
					case 'd' : out[i] = 0x44;
					break;
					case 'e' : out[i] = 0x45;
					break;
					case 'f' : out[i] = 0x46;
					break;
					case 'g' : out[i] = 0x47;
					break;
					case 'h' : out[i] = 0x48;
					break;
					case 'i' : out[i] = 0x49;
					break;
					case 'j' : out[i] = 0x4A;
					break;
					case 'k' : out[i] = 0x4B;
					break;
					case 'l' : out[i] = 0x4C;
					break;
					case 'm' : out[i] = 0x4D;
					break;
					case 'n' : out[i] = 0x4E;
					break;
					case 'o' : out[i] = 0x4F;
					break;
					case 'p' : out[i] = 0x50;
					break;
					case 'q' : out[i] = 0x51;
					break;
					case 'r' : out[i] = 0x52;
					break;
					case 's' : out[i] = 0x53;
					break;
					case 't' : out[i] = 0x54;
					break;
					case 'u' : out[i] = 0x55;
					break;
					case 'v' : out[i] = 0x56;
					break;
					case 'w' : out[i] = 0x57;
					break;
					case 'x' : out[i] = 0x58;
					break;
					case 'y' : out[i] = 0x59;
					break;
					case 'z' : out[i] = 0x5A;
					break;
					case ' ' : out[i] = 0x20;
					break;
					case ',' : out[i] = 0x2C;
					break;
					case '-' : out[i] = 0x2D;
					break;
					case '.' : out[i] = 0x2E;
					break;
					case '/' : out[i] = 0x2F;
					break;
					case '0' : out[i] = 0x30;
					break;
					case '1' : out[i] = 0x31;
					break;
					case '2' : out[i] = 0x32;
					break;
					case '3' : out[i] = 0x33;
					break;
					case '4' : out[i] = 0x34;
					break;
					case '5' : out[i] = 0x35;
					break;
					case '6' : out[i] = 0x36;
					break;
					case '7' : out[i] = 0x37;
					break;
					case '8' : out[i] = 0x38;
					break;
					case '9' : out[i] = 0x39;
					break;
					case ';' : out[i] = 0x3B;
					break;
					case '=' : out[i] = 0x3D;
					break;
					case '[' : out[i] = 0x5B;
					break;
				//case '\' : out[i] = 0x5C;
				//break;
					case ']' : out[i] = 0x5D;
					break;
					case '@' : out[i] = 0x0200;
					break;
					case ':' : out[i] = 0x0201;
					break;
					case '^' : out[i] = 0x0202;
					break;
					case '$' : out[i] = 0x0203;
					break;
					case '!' : out[i] = 0x0205;
					break;
					case '(' : out[i] = 0x0207;
					break;
					case '#' : out[i] = 0x0208;
					break;
					case '+' : out[i] = 0x0209;
					break;
					case ')' : out[i] = 0x020A;
					break;
					case '_' : out[i] = 0x020B;
					break;
					default : check = false;
					break;
				}
				if(check==false)
					break;	
			}
			s = (String)
					local.main.Cm.processing(new publics.data.KeyBoard(out));
			if(s.charAt(0)=='1')
				local.main.Tool.alert(s);
		}
		else
		{
			out = new int[1];
			for(int i=0;i<special.length;i++)
			{
				if(special[i]==obj)
				{
					switch(i)
					{
					case 0 : out[0] = '\b';//backspace
					break;
					case 1 : out[0] = 0x15;//한/영0x15
					break;
					default : out[0] = 0;
					break;
					}
					
					break;
				}
				local.main.Tool.alert(i+"");
			}
			s = (String)
					local.main.Cm.processing(new publics.data.KeyBoard(out));
			
			if(s.charAt(0)=='1')
				local.main.Tool.alert(s);
			
		}
		
	}
	
	
}
