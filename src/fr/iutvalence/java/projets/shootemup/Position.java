package fr.iutvalence.java.projets.shootemup;

/**
 * @author deguitre & Pignet
 * Défini un doublet position
 */
public class Position
{
	/**
	 * position sur l'axe x
	 */
	public int x;
	/**
	 * position sur l'axe y
	 */
	public int y;
	
	/**
	 * Initialise la posuition <0,0>
	 */
	public Position()
	{
		this.x = 0;
		this.y = 0;
	}
	/**
	 * Initialise la posuition <x,y>
	 * @param x position en x voulue
	 * @param y position en y voulue
	 */
	public Position(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}
