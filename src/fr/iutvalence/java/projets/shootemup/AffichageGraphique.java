package fr.iutvalence.java.projets.shootemup;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Classe de controle, génère des choix aléatoires
 * 
 * @author deguitre & Pignet
 * 
 */
public class AffichageGraphique implements Affichage
{
	private int size;
	private JFrame jf; 
	private JLabel[][] labels;
	
	private final static ImageIcon MINE = new ImageIcon("./images/mine_32x32.png");
	private final static ImageIcon VAISSEAU = new ImageIcon("./images/vaisseau_32x32.png");
	private final static ImageIcon VIDE = new ImageIcon("./images/vide_32x32.png");
	
	public AffichageGraphique(int size) 
	{
		this.size = size;
		this.labels = new JLabel[size][size];
		JFrame jf = new JFrame("Shoot'em Up");
		jf.setSize(32*size,32*size);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf = jf;
		jf.setContentPane(new BackGroundPanel(new ImageIcon("./images/fond_noir_etoile.png").getImage()));
		GridLayout gl = new GridLayout(size, size);
		gl.preferredLayoutSize(jf);
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(gl);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBackground(Color.BLACK);
		
		Random r = new Random();
		boolean v = false;
		
		for (int y=0; y<size;y++)
		{
			for (int x=0; x<size;x++)
			{
					this.labels[y][x] = new JLabel(this.VIDE);
					contentPane.add(this.labels[y][x]);
			}
		}
		jf.setVisible(true);
	}
	
	@Override
	public void afficherZone(ContenuZone[][] zone)
	{
		for (int y=0; y<this.size;y++)
		{
			for (int x=0; x<this.size;x++)
			{
					switch(zone[y][x])
					{
						case ENNEMI : this.labels[y][x].setIcon(MINE);
							break;
						case JOUEUR : this.labels[y][x].setIcon(VAISSEAU);
							break;
						default : this.labels[y][x].setIcon(VIDE);
							break;
					}
					this.labels[y][x].repaint();
				
			}
		}
		System.out.println("aff");
		
	}
	@Override
	public void notificationNbViesRestantes(int nbViesRestantes)
	{
		// TODO Auto-generated method stub
		
	}

}
