package fr.iutvalence.java.projets.shootemup;

/**
 * Définit un doublet position
 * 
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
	 * 
	 * @param x
	 *            position en x voulue
	 * @param y
	 *            position en y voulue
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * @param x
	 *            translation en x voulue
	 * @param y
	 *            translation en y voulue
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

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String result = "(" + this.x + "," + this.y + ")";
		return result;
	}

	// FIXME (FIXED) compléter le commentaire (dire en quoi 2 objets sont équivalents)
	/**
	 * Deux objets sont équivalents si il sont du meme type et si il on les meme valeur de x et de y
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Position))
			return false;
		Position temp = (Position) o;
		return (this.x == temp.x) && (this.y == temp.y);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return this.x + this.y;
	}
}
