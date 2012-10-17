package fr.iutvalence.java.projets.shootemup;


/**
 * Affichage de la zone de jeu
 * @author deguitre & Pignet
 * 
 */
public class Affichage
{
	/**
	 * Affichage de la zone
	 * @param zone 
	 */
	public void afficher(int[][] zone)
	{
		String result="";
		// ...
		for (int x = 0; x < zone.length; x++) 
	    { 
		  for (int y = 0; y < zone[x].length; y++) 
		  { 
			  switch(zone[x][y])
		        {
		            case 0:
		            	result = result + " ";
		            break;
		            case 2:		// ennemi représentés par |
		                result = result + "|";
		            break;
		            case 1:		// Vaisseau joueur représenté par A
		            	result = result + "A";
		            break;
		            default: result = result + "?";
		        }

		  }
		  result = result + "\r\n";
		}
		System.out.println(result);
		System.out.println(); 
	}
}
