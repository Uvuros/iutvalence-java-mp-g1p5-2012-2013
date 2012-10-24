package fr.iutvalence.java.projets.shootemup;

public class ThreadScroll extends Thread
{
	private Scrollable toScroll;
	
	public ThreadScroll(Scrollable p)
	{
		this.toScroll = p;
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
		while (this.toScroll.scroll())
		{
			pause(250);
		}
	}
}
