package local.function;

import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenCapture 
extends JPanel
{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	JButton get = new JButton("get");
	JButton save = new JButton("save");
	
	javax.swing.ImageIcon
	image;
	
	JScrollPane jsp = new JScrollPane();
	
	public ScreenCapture()
	{
		super();
		
		
		
		
		
		
		jp1.add(get);
		jp1.add(save);
		
		
		
		fileChooserSet();
		
		
		
		
		get.addActionListener(
				new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) 
			{
				image = (javax.swing.ImageIcon)
						local.main.Cm.processing(
								new publics.data.ScreenCapture());
				
				javax.swing.JLabel 
				lb = new javax.swing.JLabel();
				lb.setIcon(image);
				jsp.setViewportView(lb);
				add(jsp,BorderLayout.CENTER);
				
				local.main.Main.f5();
			}
			
		});
		
		save.addActionListener(
				new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) 
			{
				 save();
			}
			
		});
		
		setLayout(new BorderLayout(5,5));
		add(jp1,BorderLayout.NORTH);
		//add(lb,BorderLayout.CENTER);
		//add(jp2,BorderLayout.CENTER);
		
		
	}
	
	
	
/*************************
 * 파일 저장 설정 , 실행시 메소드
 */
	void fileChooserSet()
	{
		 fileChooser.setApproveButtonText("save");
		 fileChooser.setFileFilter(
				 new javax.swing.filechooser.FileNameExtensionFilter(
			        "JPG", "jpg"));
	}
	
	JFileChooser fileChooser = new JFileChooser();
	java.io.File file;
	void save()
	{
		
        
		
		 
	        //파일오픈 다이얼로그 를 띄움 (반환값)
	        int result = fileChooser.showOpenDialog(local.main.Main.jf);
	         
	        
	        //save 버튼 반환했을때
	       if (result == JFileChooser.APPROVE_OPTION) 
	        {
	    	   try
	    	   {
	    		   java.awt.image.BufferedImage oi = 
	    				   new java.awt.image.BufferedImage
	    				   (image.getIconWidth(),image.getIconHeight()
	    						   ,java.awt.image.BufferedImage.TYPE_INT_RGB ); //저장할 이미지 객체 생성
	    		   
                   java.awt.Graphics g = oi.getGraphics();
                   g.drawImage(image.getImage(),0,0,new java.awt.Panel());
                   
                   
	             file = fileChooser.getSelectedFile();
	             file = new java.io.File(file+".jpg");
	             javax.imageio.ImageIO.write(
	            		 oi,"jpg",file);
	    	   }
	    	   catch(Exception e)
	    	   { local.main.Tool.alert(e+"");}
	           
	        }
	}

}
