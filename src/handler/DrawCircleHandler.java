package handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import model.Circle;
import view.DrawCircle;

public class DrawCircleHandler implements MouseListener, MouseMotionListener
{
	private DrawCircle obj;

	public DrawCircleHandler( DrawCircle window )
	{
		this.obj = window;
		this.obj.addMouseListener(this);
		this.obj.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}
	
	@Override
	public void mouseMoved(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e)
	{
		this.obj.setCenterX(e.getX());
		this.obj.setCenterY(e.getY());
		this.obj.setCurrentX(e.getX());
		this.obj.setCurrentY(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		this.obj.setCurrentX(e.getX());
		this.obj.setCurrentY(e.getY());
		this.obj.setRaio(this.obj.calculaRaio());
		this.obj.addCircle(new Circle(this.obj.getCenterX(), 
									  this.obj.getCenterY(), 
									  this.obj.getRaio()));
		this.obj.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		this.obj.setCurrentX(e.getX());
		this.obj.setCurrentY(e.getY());
		this.obj.setRaio(this.obj.calculaRaio());
		this.obj.repaint();
	}
}