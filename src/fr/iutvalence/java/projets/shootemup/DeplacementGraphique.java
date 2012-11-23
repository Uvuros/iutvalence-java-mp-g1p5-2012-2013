package fr.iutvalence.java.projets.shootemup;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe permettant de se déplacer en fonction du key listener sur le JFrame de l'affichage
 * @author deguitre & Pignet
 *
 */
public class DeplacementGraphique
{
	/**
	 * 
	 */
	private AffichageGraphique a;
	/**
	 * @param a affichage graphique utilisé pour récupérer le keylistener
	 * @param p partie utilisé pour appeler la fonction move
	 */
	public DeplacementGraphique(AffichageGraphique a,final PartieScrollingAsynchroneDeplacementAsynchrone p)
	{
		this.a = a;
	KeyListener k = new KeyAdapter()
    {
		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_LEFT : p.move(Direction.GAUCHE);
			break;
			case KeyEvent.VK_RIGHT : p.move(Direction.DROITE);
			break;
			case KeyEvent.VK_DOWN : p.move(Direction.BAS);
			break;
			case KeyEvent.VK_UP : p.move(Direction.HAUT);
			break;
			}
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			// TODO Auto-generated method stub
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_LEFT : p.move(Direction.GAUCHE);
			break;
			case KeyEvent.VK_RIGHT : p.move(Direction.DROITE);
			break;
			case KeyEvent.VK_DOWN : p.move(Direction.BAS);
			break;
			case KeyEvent.VK_UP : p.move(Direction.HAUT);
			break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
    };
	this.a.jf.addKeyListener(k);
	}
}
