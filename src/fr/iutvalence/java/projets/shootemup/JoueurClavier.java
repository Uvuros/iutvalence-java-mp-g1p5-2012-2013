package fr.iutvalence.java.projets.shootemup;
import java.util.Scanner;

// FIXME préciser la particularité de cette implementation
/**
 * Classe de controle interface entre l'utilisateur et la partie
 * 
 * @author deguitre & Pignet
 * 
 */
public class JoueurClavier implements Joueur
{
	/**
	 * @see fr.iutvalence.java.projets.shootemup.Joueur#getDeplacement()
	 * @Override
	 */
	public Direction getDeplacement()
	{
		Scanner sc = new Scanner(System.in);
	    int choix = sc.nextInt();
	    // FIXME pour l'instant utiliser un Scanner
	    switch(choix)
	    {
	    	case 8: return Direction.HAUT;
	    	case 5: return Direction.BAS;
	    	case 4: return Direction.GAUCHE;
	    	case 6: return Direction.DROITE;
	    	default : return Direction.FIXE;
	    }
	    
	}
}
