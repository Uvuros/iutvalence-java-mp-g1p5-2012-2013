package fr.iutvalence.java.projets.shootemup;

public class ThreadMissile extends Thread
{
	private PartieScrollingAsynchroneDeplacementAsynchrone partie;
	
	private boolean etat;
	
	private Position position;
	
	public ThreadMissile(PartieScrollingAsynchroneDeplacementAsynchrone p)
	{
		this.partie = p;
		this.position = new Position(p.getShip().getPosition().getX(),p.getShip().getPosition().getY()-1);
		this.etat = true;
	}
	
	/**
	 * créer un delai
	 * 
	 * @param delai
	 *            durée du délai
	 */
	public void pause(long delai)
	{
		long t = System.currentTimeMillis();
		while ((System.currentTimeMillis() - t) < delai)
		{

		}
	}
	
	public void run()
	{
		if (this.partie.zone.estDansZone(this.position))
		{
		try // n'arrive jamais
		{
			switch (this.partie.zone.contenu(this.position))
			{
				case VIDE: 
					this.partie.zone.modification(this.position,ContenuZone.MISSILE);
					this.partie.affichage.afficherZone(this.partie.zone.getZone());
				break;
				case ENNEMI: 
					this.partie.zone.modification(this.position,ContenuZone.VIDE);
					this.etat=false;
					this.partie.ajoutPoints(50);
					this.partie.affichage.afficherZone(this.partie.zone.getZone());
				break;
				//case JOUEUR: this.partie.zone.modification(this.position,ContenuZone.MISSILE_VAISSEAU);
				//break;
				//je traiterai ce cas plus tard car il nécessite certaines modifications
			}
			while(this.etat)
			{
				pause(100);
				Position newPos = new Position(this.position.getX(),this.position.getY()-1);
				if (this.partie.zone.estDansZone(newPos))
				{
					switch(this.partie.zone.contenu(newPos))
					{
						case VIDE: 
							this.partie.zone.modification(newPos,ContenuZone.MISSILE);
							this.partie.zone.modification(this.position,ContenuZone.VIDE);
							this.partie.affichage.afficherZone(this.partie.zone.getZone());
						break;
						case ENNEMI:
							this.partie.zone.modification(this.position,ContenuZone.VIDE);
							this.partie.zone.modification(newPos,ContenuZone.VIDE);
							this.etat = false;
							this.partie.ajoutPoints(50);
						break;
						//case JOUEUR: 
							//this.partie.zone.modification(this.position,ContenuZone.VIDE);
							//this.partie.zone.modification(newPos,ContenuZone.MISSILE_VAISSEAu);
					}
					this.partie.affichage.afficherZone(this.partie.zone.getZone());
				}
				else
				{
					this.etat = false;
				}
			}
		}
		catch (HorsZoneException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}