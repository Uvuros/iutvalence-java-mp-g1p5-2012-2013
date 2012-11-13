package fr.iutvalence.java.projets.shootemup;

//FIXME préciser la particularité de cette implémentation
/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingSynchroneDeplacementSynchrone extends Partie
{
	/**
	 * @param pseudo
	 *            pseudo du joueur
	 * @param joueur
	 *            interface de controle
	 * @param affichage
	 *            interface d'affichage
	 */
	public PartieScrollingSynchroneDeplacementSynchrone(String pseudo, Joueur joueur, Affichage affichage)
	{
		super(pseudo, joueur, affichage);
	}

	/**
	 * Débuter une partie
	 */
	public void start()
	{
		int i = 0;
		while (this.vies != 0)
		{
			if (i == 0)
			{
				this.zone.modification(new Position((int) (Math.random() * ((this.zone.getTaille() - 1) + 1)) + 0, 0),
						ContenuZone.ENNEMI);
				i = 1;
			}
			else
			{
				i = 0;
			}
			// Déplacement => gestion collision
			if (!this.mouvement(this.joueur.getDeplacement()))
				continue;

			// Scroll => gestion collision
			if (!this.scroll())
				continue;

			// Affichage
			this.affichage.afficherZone(this.zone.getZone());
			pause(250);
		}
	}
}
