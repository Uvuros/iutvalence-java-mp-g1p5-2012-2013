package fr.iutvalence.java.projets.shootemup;


/**
* 
* Interface sur laquelle effectuer deplacement()
* 
* @author deguitre & Pignet
* 
*/
public interface Deplacement
{

	/**
	 * scroll (à compléter peut etre)
	 * @param d direction dans laquelle se déplacer
	 */
	public boolean move(Direction d);
}