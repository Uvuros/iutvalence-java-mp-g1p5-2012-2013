package fr.iutvalence.java.projets.shootemup;

/**
 * Permet d'executer la fonction scroll() sur un objet Scrollable toute les 250 ms
 * 
 * @author deguitre & Pignet
 * 
 */
public class ThreadDeplacement extends Thread
{
	/**
	 * objet sur lequel scroller
	 */
	private Deplacement deplacement;
	private Joueur joueur;

	/**
	 * initialise un nouveau thread qui permettra de scroller sur l'objet placé en paramétre
	 * 
	 * @param p
	 *            objet sur lequel scroller
	 */
	public ThreadDeplacement(Deplacement d,Joueur j)
	{
		this.deplacement = d;
		this.joueur = j;
	}



	public void run()
	{
		Direction mouvement = Direction.FIXE;
		while (this.deplacement.move(this.joueur.getDeplacement()))
		{
			try
			{
				sleep(10);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}