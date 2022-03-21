package publics.data;


public class Mouse 
implements publics.DataModel
{
	
	int index;//moveMouse:1
	          //clickMouse:2
	  
	
	
	
//*****************************************************
	//moveMouse 용 생성자
	int x,y;
	
	public Mouse(int x,int y)
	{
		index = 1;
		this.x = x;
		this.y = y;
	}
	
	
	String moveMouse()
	{

		String out = "0";
		
		
		 try
		 {
			 java.awt.Robot r = new java.awt.Robot();
		      r.mouseMove(x,y);
		 }
		 catch (java.awt.AWTException ae)
		 {
		    	out = "1"+ae;
		      
		    	System.out.println(ae);
		  }
		
		return out;
	}
	
	
	
//*****************************************************
	//clickMouse 용 생성자
	

	boolean isLeft;
	
	public Mouse(int rl)
	{
		if(rl==0)
			isLeft = false;
		else
			isLeft = true;
	}
	
	
	

	
	
	
	
	
//*****************************************************	
	//원격에서 실행되는 메소드
	//0 리턴 시 오류없음
	//1 리턴시 오류있음
	
	
	public Object action()
	{
		String out = "";
		out = moveMouse();
		/*if(index==1)
		{
			out = moveMouse();
		}
		else
		{
			
		}*/
		return out;
	}
	
}
