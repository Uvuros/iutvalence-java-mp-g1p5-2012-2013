package fr.iutvalence.java.projets.shootemup;

/**
 * Implementation de l'interface d'affichage où l'affichage est réalisé en ascii-art
 * 
 * @author deguitre & Pignet
 * 
 */
public class AffichageAscii implements Affichage
{
	/**
	 * Chaine représentant l'affichage d'une case vide
	 */
	public static final String VIDE = " ";
	/**
	 * Chaine représentant l'affichage d'une case ennemi
	 */
	public static final String ENNEMI = "|";
	
//	/**
//	 * Chaine représentant l'affichage d'une case vaisseau
//	 */
//	public static final String VAISSEAU = "A";
	
	/**
	 * Vies restantes à afficher à la place de Contenu.JOUEUR
	 */
	private int nbViesRestantes;
	
	
	/**
	 * Initialise l'affichage
	 */
	public AffichageAscii()
	{
		this.nbViesRestantes = 0;
	}
	
	/**
	 * @see fr.iutvalence.java.projets.shootemup.Affichage#afficherZone(ContenuZone[][])
	 */
	public void afficherZone(ContenuZone[][] zone)
	{
		String result = "";
		// ...
		for (int x = 0; x < zone.length; x++)
		{
			for (int y = 0; y < zone[x].length; y++)
			{
				switch (zone[x][y])
				{
					case VIDE:
						result = result + VIDE;
						break;
					case ENNEMI:		// ennemi représentés par |
						result = result + ENNEMI;
						break;
					case JOUEUR:		// Vaisseau joueur représenté par A
						result = result + this.nbViesRestantes;
						break;
					default:
						result = result + "?";
				}

			}
			result = result + "\r\n";
		}
		result += "-------------------------";
		System.out.println(result);
		System.out.println();
	}

	@Override
	public void notificationNbViesRestantes(int nbViesRestantes)
	{
		this.nbViesRestantes = nbViesRestantes;
		
	}
}
