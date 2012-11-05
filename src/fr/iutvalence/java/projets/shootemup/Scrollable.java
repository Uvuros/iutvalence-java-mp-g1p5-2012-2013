package fr.iutvalence.java.projets.shootemup;

/**
 * Interface sur laquel effectuer scroll()
 * @author deguitre & Pignet
 *
 */
public interface Scrollable
{

	/**
	 * scroll (à compléter peut etre)
	 * @return resultat du scroll
	 */
	public boolean scroll();
	/**
	 * deplacement ( à compléter)
	 * @param direction direction 
	 * @return true si vivant mort sinon ( a faire)
	 */
	public boolean mouvement(Direction direction);
	/**
	 * @return l'état du vaisseau sous forme de booléen 
	 */
	public boolean enVie();

}