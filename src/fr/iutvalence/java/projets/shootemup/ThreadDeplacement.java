package fr.iutvalence.java.projets.shootemup;

/**
 * Permet d'executer la fonction scroll() sur un objet Scrollable toute les 250 ms
 * @author deguitre & Pignet
 *
 */
public class ThreadDeplacement extends Thread
{
	/**
	 * objet sur lequel scroller
	 */
	private Scrollable toScroll;
	
	/**
	 * initialise un nouveau thread qui permettra de scroller sur l'objet placé en paramétre
	 * @param p objet sur lequel scroller
	 */
	public ThreadDeplacement(Scrollable p)
	{
		this.toScroll = p;
	}
	/**
	 * créer un delai
	 * @param delai durée du délai
	 */
	public void pause(long delai)
	{
		long t = System.currentTimeMillis();
		while ((System.currentTimeMillis() - t) < delai)
		{

		}
	}
	public void run()
	{
		Direction mouvement = Direction.FIXE;
		while (this.toScroll.mouvement(mouvement)&&(this.toScroll.enVie()))
		{
				int alea = (int) (Math.random() * 5);
				switch (alea)
				{
				case 0:  mouvement = Direction.FIXE;break;
				
				case 1: mouvement = Direction.GAUCHE;break;

				case 2 : mouvement = Direction.DROITE;break;
				
				case 3 : mouvement = Direction.HAUT;break;
				
				case 4 : mouvement = Direction.BAS;break;
				
				default: mouvement = Direction.FIXE;break;
				}
				
			pause(150);
		}
	}
}