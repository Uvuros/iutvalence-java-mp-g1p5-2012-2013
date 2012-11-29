package fr.iutvalence.java.projets.shootemup.tests;

import fr.iutvalence.java.projets.shootemup.InterfaceGraphique;
import fr.iutvalence.java.projets.shootemup.JoueurClavier;
import fr.iutvalence.java.projets.shootemup.PartieScrollingAsynchroneDeplacementAsynchrone;
import fr.iutvalence.java.projets.shootemup.ThreadDeplacement;
import fr.iutvalence.java.projets.shootemup.ThreadScroll;

/**
 * classe de test / créer une partie et la démarre
 * 
 * @author Deguitre & Pignet
 * 
 */
public class SimulationPartieGraphiqueAleatoireScrollingAsynchroneDeplacementAsynchrone
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
		
		JoueurClavier joueur = new JoueurClavier();
		PartieScrollingAsynchroneDeplacementAsynchrone  p = new PartieScrollingAsynchroneDeplacementAsynchrone("Uvuros",joueur);
		InterfaceGraphique affichage = new InterfaceGraphique(8,p);
		p.setAffichage(affichage);
		ThreadScroll s = new ThreadScroll(p);
		ThreadDeplacement d = new ThreadDeplacement(p,joueur);
		
		s.start();
		d.start();
		p.start();
	}

}