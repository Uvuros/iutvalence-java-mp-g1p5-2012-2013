package fr.iutvalence.java.projets.shootemup;

/**
 * Permet d'executer la fonction scroll() sur un objet Scrollable toute les 250 ms
 * 
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
	 * 
	 * @param p
	 *            objet sur lequel scroller
	 */
	public ThreadScroll(Scrollable p)
	{
		this.toScroll = p;
	}

	

	public void run()
	{
		int pause = 250;
		int boucle = 0;
		int valeur_boucle = 20;
		while (this.toScroll.scroll())
		{
			if (boucle == valeur_boucle)
			{
				if (pause > 80)
				{
				pause = pause -10;
				boucle = 0;
				valeur_boucle=valeur_boucle+1;
				}
			}
			boucle = boucle + 1;
			// Ajouter affichage
			try
			{
				sleep(pause);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
