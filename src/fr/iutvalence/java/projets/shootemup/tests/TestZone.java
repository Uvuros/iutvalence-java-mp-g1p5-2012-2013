// FIXME (FIXED) déplacer dans un autre paquetage
package fr.iutvalence.java.projets.shootemup.tests;

import fr.iutvalence.java.projets.shootemup.AffichageAscii;
import fr.iutvalence.java.projets.shootemup.Partie;
import fr.iutvalence.java.projets.shootemup.JoueurAlea;

// FIXME (FIXED) détailler le commentaire 
/**
 * classe de test / créer une partie et la démarre
 * 
 * @author Deguitre & Pignet
 * 
 */
public class TestZone
{
	// FIXME (FIXED) compléter le commentaire
	/**
	 * Permet de tester les classes Partie Ship Affichage Zone Position et Joueur, Doit afficher la zone de jeu
	 * (obstacle qui "tombe" et vaisseau qui bouge aléatoirement)
	 * 
	 * @param args
	 *            aucun
	 */
	public static void main(String[] args)
	{
		AffichageAscii affichage = new AffichageAscii();
		JoueurAlea joueur = new JoueurAlea();
		Partie p = new Partie("Uvuros", joueur, affichage);
		p.start();
	}

}