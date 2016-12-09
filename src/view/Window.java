package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends JFrame
{
	private static final long serialVersionUID = 687798684167430180L;
	private int windowWidth;
	private int windowHeight;
	private int screenWidth;
	private int screenHeight;
	private int positionX;
	private int positionY;
	
	public Window ( int windowWidth, int windowHeight )
	{
		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension screenSize = screen.getScreenSize();
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.screenWidth = screenSize.width;
		this.screenHeight = screenSize.height;
		this.positionX = ( (this.screenWidth/2) - (this.windowWidth/2) );
		this.positionY = ( (this.screenHeight/2) - (this.windowHeight/2) );
		setBounds( positionX, positionY, this.windowWidth, this.windowHeight );
		setDefaultCloseOperation ( EXIT_ON_CLOSE );
	}
	
	int getWindowWidth ()
	{
		return this.windowWidth;
	}
	
	int getWindowHeight ()
	{
		return this.windowHeight;
	}
	
	int getScreenWidth ()
	{
		return this.screenWidth;
	}
	
	int getScreenHeight ()
	{
		return this.screenHeight;
	}
	
	int getPositionX ()
	{
		return this.positionX;
	}
	
	int getPositionY ()
	{
		return this.positionY;
	}
	
}