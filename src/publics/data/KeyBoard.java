package publics.data;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyBoard 
implements publics.DataModel
{
	int index;
	
	
//******************************************
	//일반문자 사용시 
	int[] order;
	public KeyBoard(int[] str)
	{
		index = 1;
		order = str;
	}
	
	String key1()
	{
		String out = "";
		try
		{
			Robot r = new Robot();
			for(int i=0;i<order.length;i++)
			{
				r.keyPress(order[i]);
		        r.keyRelease(order[i]);
			}
		}
		catch(Exception e)
		{
			out = "1 "+e;
			System.out.println(e);
		}
		
		
		return out;
	}
	
	
	
//******************************************
	//특수문자사용시
	public KeyBoard(int value)
	{
		index = 2;
		order[0] = value;
	}
	
	String key2()
	{
		String out = "";
		try
		{
			Robot r = new Robot();
			r.keyPress(order[0]);
	       r.keyRelease(order[0]);
		}
		catch(Exception e)
		{
			out = "1 "+e;
			System.out.println(e);
		}
		return out;
	}
	
	
	
	
	
	public Object action()
	{
		String out = "";
		switch(index)
		{
		case 1 : out = key1();
		break;
		case 2 : out = key2();
		break;
		default : out = "1 invalid";
		break;
		}
		
		
		return out;
	}

}
