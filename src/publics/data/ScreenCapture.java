package publics.data;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class ScreenCapture 
implements publics.DataModel
{
	
	

	public Object action()
	{
		Object out = null;
		
		try {
			Robot rb = new Robot();
			out = new javax.swing.ImageIcon(rb.createScreenCapture(new Rectangle(
					Toolkit.getDefaultToolkit().getScreenSize())));
		} 
		catch (AWTException e) {
			e.printStackTrace();
		}
		
		
		
		
		return out;
	}

}
