package fr.iutvalence.java.projets.shootemup;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
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
	/**
	 * taille de la zone de jeu (en case)
	 */
	private int size;
	/**
	 * tableau à deux dimenssions de label utilisé pour remplir la GridLayout
	 */
	private JLabel[][] labels;
	
	/**
	 * constante, image mine
	 */
	private final static ImageIcon MINE = new ImageIcon("./images/mine_32x32.png");
	/**
	 * constante, image vaisseau
	 */
	private final static ImageIcon VAISSEAU = new ImageIcon("./images/vaisseau_32x32.png");
	/**
	 * constante, image vide
	 */
	private final static ImageIcon VIDE = new ImageIcon("./images/vide_32x32.png");
	
	/**
	 * @param size nombre de case en hauteur / largeur
	 */
	public AffichageGraphique(int size) 
	{
		this.size = size;
		this.labels = new JLabel[size][size];
		JFrame jf = new JFrame("Shoot'em Up");
		jf.setSize(32*size,32*size);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setContentPane(new BackGroundPanel(new ImageIcon("./images/fond_noir_etoile.png").getImage()));
		GridLayout gl = new GridLayout(size, size);
		gl.preferredLayoutSize(jf);
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(gl);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBackground(Color.BLACK);
		
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
	}
	@Override
	public void notificationNbViesRestantes(int nbViesRestantes)
	{
		// TODO Auto-generated method stub
		
	}

}
