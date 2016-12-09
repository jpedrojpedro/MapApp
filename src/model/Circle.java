package model;

public class Circle
{
	private int coordX;
	private int coordY;
	private float raio;
	
	public Circle ( int x, int y, float raio )
	{
		this.coordX = x;
		this.coordY = y;
		this.raio = raio;
	}

	public int getCoordX()
	{
		return coordX;
	}

	public void setCoordX(int coordX)
	{
		this.coordX = coordX;
	}

	public int getCoordY()
	{
		return coordY;
	}

	public void setCoordY(int coordY)
	{
		this.coordY = coordY;
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