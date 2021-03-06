package fr.iutvalence.java.projets.shootemup;

// FIXME préciser la particularité de cette implémentation
/**
 * Classe partie
 * 
 * @author Deguitre & Pignet
 * 
 */
public class PartieScrollingAsynchroneDeplacementAsynchrone extends Partie implements Deplacement
{

	/**
	 * appel au super constructeur de la classe partie
	 * 
	 * @param pseudo
	 *            pseudo du joueur
	 * @param joueur
	 *            interface de controle
	 * @param affichage
	 *            interface d'affichage
	 */
	public PartieScrollingAsynchroneDeplacementAsynchrone(String pseudo, Joueur joueur, Affichage affichage)
	{
		super(pseudo, joueur, affichage);
	}
	/**
	 * @param pseudo
	 * @param joueur
	 */
	public PartieScrollingAsynchroneDeplacementAsynchrone(String pseudo, Joueur joueur)
	{
		super(pseudo,joueur);
	}
	public Ship getShip()
	{
		return this.shipJoueur;
	}
	public PartieScrollingAsynchroneDeplacementAsynchrone(String pseudo, Joueur joueur, InterfaceHighScore interfaceHighScore)
	{
		super(pseudo,joueur,interfaceHighScore);
	}
	/**
	 * Débuter une partie
	 */
	public void start()
	{
		while (this.vies > 0)
		{	
			System.out.println();
		}
		System.out.println("GAME OVER");
		this.interfaceHighScore.addScore(new Score(this.pseudo, this.score));
		System.out.println(this.interfaceHighScore.getHighScore().pseudo+" : "+this.interfaceHighScore.getHighScore().score);
		this.affichage.bestScore(this.interfaceHighScore.getHighScore());
	}

	@Override
	public boolean move(Direction d)
	{
		if(!this.deplacement(d))
		{
			this.vieMoins();
		}
		return (this.vies >0);
	}
	public void setAffichage(Affichage a)
	{
		this.affichage = a;
	}
}
