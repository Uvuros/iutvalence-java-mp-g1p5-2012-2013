package fr.iutvalence.java.projets.shootemup;

/**
 * Définit un doublet position
 * @author deguitre & Pignet
 * 
 */
public class Position
{
	/**
	 * position sur l'axe x
	 */
	private int x;
	/**
	 * position sur l'axe y
	 */
	private int y;
	
	/**
	 * Initialise la position <0,0>
	 */
	public Position()
	{
		this.x = 0;
		this.y = 0;
	}
	/**
	 * Initialise la position <x,y>
	 * @param x position en x voulue
	 * @param y position en y voulue
	 */
	public Position(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * @param x translation en x voulue
	 * @param y translation en y voulue
	 */
	public void translate(int x, int y)
	{
		this.x = this.x + x;
		this.y = this.y + y;
	}
	/**
	 * @return position x
	 */
	public int getX()
	{
		return this.x;
	}
	/**
	 * @return position y 
	 */
	public int getY()
	{
		return this.y;
	}
	
	// FIXME (FIXED) redéfinir toString
	public String toString()
	{
		String result = "("+this.x+","+this.y+")";
		return result;	
	}
	
	public boolean equals(Object o)
	{
		if (o == null) return false;
		if (o == this) return true;
		if(!(o instanceof Position)) return false;
		Position temp = (Position) o;
		return (this.x == temp.x)&&(this.y == temp.y);
	}
	
	public int hashCode()
	{
		return this.x+this.y;
	}
	// FIXME (FIXED) redéfinir equals et hashCode
	
	// FIXME (FIXED) écrire (dans une autre classe)  une application de test basique
}
