package fr.iutvalence.java.projets.shootemup.tests;

import fr.iutvalence.java.projets.shootemup.AffichageAscii;
import fr.iutvalence.java.projets.shootemup.PartieScrollingAsynchroneDeplacementSynchrone;
import fr.iutvalence.java.projets.shootemup.PartieScrollingSynchroneDeplacementSynchrone;
import fr.iutvalence.java.projets.shootemup.JoueurAlea;
import fr.iutvalence.java.projets.shootemup.ThreadScroll;

/**
 * classe de test / créer une partie et la démarre
 * 
 * @author Deguitre & Pignet
 * 
 */
public class SimulationPartieASCIIArtAleatoireScrollingAsynchroneDeplacementSynchrone
{
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
		PartieScrollingAsynchroneDeplacementSynchrone p = new PartieScrollingAsynchroneDeplacementSynchrone("Uvuros", joueur, affichage);
		ThreadScroll t = new ThreadScroll(p);
		t.start();
		p.start();
	}

}