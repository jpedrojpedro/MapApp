package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Circle;

public class DrawCircle extends JPanel
{
	private static final long serialVersionUID = -4154750805139376237L;
	
	private ArrayList<Circle> circulos = new ArrayList<Circle>();
	
	/** Mouse Location */
	private int currentX = 0;
	private int currentY = 0;
	private int centerX = 0;
	private int centerY = 0;
	private float raio = 0;
	
	public DrawCircle(){}
	
	public float calculaRaio()
	{
		return (float) Math.sqrt((this.getCenterX() - this.getCurrentX())*
								 (this.getCenterX() - this.getCurrentX()) +
								 (this.getCenterY() - this.getCurrentY())*
								 (this.getCenterY() - this.getCurrentY()));
	}
	
	public void addCircle ( Circle c )
	{
		if ( c != null )
			this.circulos.add(c);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	    					RenderingHints.VALUE_ANTIALIAS_ON);
		
	    g2.setPaint(Color.blue);
	    
	    g2.setStroke(new BasicStroke(8));

	    g2.draw(new Arc2D.Double((this.getCenterX() - this.getRaio()), 
	    						 (this.getCenterY() - this.getRaio()), 
	    						 Math.round(this.getRaio()*2), 
	    						 Math.round(this.getRaio()*2), 
	    						 0, 
	    						 360, 
	    						 Arc2D.OPEN));
	    
	    g2.setPaint(Color.gray);
	    
	    for ( Circle c : circulos )
	    	g2.draw(new Arc2D.Double((c.getCoordX() - c.getRaio()), 
	    							 (c.getCoordY() - c.getRaio()), 
	    							 Math.round(c.getRaio()*2), 
	    							 Math.round(c.getRaio()*2), 
	    							 0, 
	    							 360, 
	    							 Arc2D.OPEN));
	}

	public ArrayList<Circle> getCirculos()
	{
		return circulos;
	}

	public void setCirculos(ArrayList<Circle> circulos)
	{
		this.circulos = circulos;
	}

	public int getCurrentX()
	{
		return currentX;
	}

	public void setCurrentX(int currentX)
	{
		this.currentX = currentX;
	}

	public int getCurrentY()
	{
		return currentY;
	}

	public void setCurrentY(int currentY)
	{
		this.currentY = currentY;
	}

	public int getCenterX()
	{
		return centerX;
	}

	public void setCenterX(int centerX)
	{
		this.centerX = centerX;
	}

	public int getCenterY()
	{
		return centerY;
	}

	public void setCenterY(int centerY)
	{
		this.centerY = centerY;
	}

	public float getRaio()
	{
		return raio;
	}

	public void setRaio(float raio)
	{
		this.raio = raio;
	}
}