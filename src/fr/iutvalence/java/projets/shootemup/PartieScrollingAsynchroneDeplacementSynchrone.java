package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingAsynchroneDeplacementSynchrone extends Partie implements Scrollable
{
	
	/**
	 * Appel au superconstructeur de la classe Partie
	 * @param pseudo pseudo du joueur
	 * @param joueur interface de controle
	 * @param affichage interface d'affichage
	 */
	public PartieScrollingAsynchroneDeplacementSynchrone(String pseudo, Joueur joueur, Affichage affichage)
	{
		super(pseudo, joueur, affichage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Débuter une partie
	 */
	public void start()
	{
		Direction deplacement;
		int i = 0;
		while (this.vies != 0)
		{
			if (i == 0)
			{
				this.zone.modification(new Position((int) (Math.random() * ((this.zone.getTaille() - 1) + 1)) + 0, 0), ContenuZone.ENNEMI);
				i = 1;
			}
			else
			{
				i = 0;
			}
			// Déplacement => gestion collision
			deplacement = this.joueur.getDeplacement();
			deplacement(deplacement);
			// Affichage
			this.affichage.afficherZone(this.zone.getZone());
			pause(250);
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projets.shootemup.Scrollable#scroll()
	 */
	@Override
	public boolean scroll()
	{
		if (this.zone.scroll())
		{
			this.affichage.afficherZone(this.zone.getZone());
			return this.vieMoins();
		}
		this.affichage.afficherZone(this.zone.getZone());
		return true;
	}


	
}
