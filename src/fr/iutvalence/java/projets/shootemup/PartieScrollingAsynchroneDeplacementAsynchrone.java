package fr.iutvalence.java.projets.shootemup;

/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingAsynchroneDeplacementAsynchrone extends Partie implements Scrollable
{
		
		/**
		 * appel au super constructeur de la classe partie
		 * @param pseudo pseudo du joueur
		 * @param joueur interface de controle
		 * @param affichage interface d'affichage
		 */
		public PartieScrollingAsynchroneDeplacementAsynchrone(String pseudo, Joueur joueur, Affichage affichage)
	{
		super(pseudo, joueur, affichage);
		// TODO Auto-generated constructor stub
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
					this.zone.modification(new Position((int) (Math.random() * ((this.zone.getTaille() - 1) + 1)) + 0, 0), ContenuZone.ENNEMI);
					i = 1;
				}
				else
				{
					i = 0;
				}
				pause(250);
			}
		}
		
		/* (non-Javadoc)
		 * @see fr.iutvalence.java.projets.shootemup.Scrollable#scroll()
		 */
		public boolean mouvement(Direction move)
		{
			if (! this.deplacement(move))
			{	
				this.vieMoins();
				this.affichage.afficherZone(this.zone.getZone());
				if(this.vies == 0)
					return false;
				else
					return true;
			}
			this.affichage.afficherZone(this.zone.getZone());
			if(this.vies == 0)
				return false;
			else
				return true;
			
		}

		public boolean scroll()
		{
			if (this.zone.scroll())
			{
				boolean res = this.vieMoins();
				this.affichage.afficherZone(this.zone.getZone());
				return res;
			}
			this.affichage.afficherZone(this.zone.getZone());
			return true;
		}
		
	}
