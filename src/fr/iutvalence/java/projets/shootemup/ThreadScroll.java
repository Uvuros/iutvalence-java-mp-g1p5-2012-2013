package fr.iutvalence.java.projets.shootemup;

/**
 * Permet d'executer la fonction scroll() sur un objet Scrollable toute les 250 ms
 * @author deguitre & Pignet
 *
 */
public class ThreadScroll extends Thread
{
	/**
	 * objet sur lequel scroller
	 */
	private Scrollable toScroll;
	
	/**
	 * initialise un nouveau thread qui permettra de scroller sur l'objet placé en paramétre
	 * @param p objet sur lequel scroller
	 */
	public ThreadScroll(Scrollable p)
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
		while (this.toScroll.scroll())
		{
			pause(250);
		}
	}
}
