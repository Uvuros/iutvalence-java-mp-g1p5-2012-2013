package fr.iutvalence.java.projets.shootemup;

public class ThreadScroll extends Thread
{
	private PartieScrollingSynchroneDeplacementSynchrone partie;
	public ThreadScroll(PartieScrollingSynchroneDeplacementSynchrone p)
	{
		this.partie = p;
	}
	public void pause(long delai)
	{
		long t = System.currentTimeMillis();
		while ((System.currentTimeMillis() - t) < delai)
		{

		}
	}
	public void run()
	{
		
		boolean colision = this.partie.zone.scroll();
		if (colision == true)
		{
			this.partie.vieMoins();
		}
		pause(250);
	}
}
