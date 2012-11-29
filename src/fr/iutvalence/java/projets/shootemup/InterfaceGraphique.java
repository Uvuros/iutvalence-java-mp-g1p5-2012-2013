package fr.iutvalence.java.projets.shootemup;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.java.projets.shootemup.tests.TestPosition;

/**
 * Classe de controle, génère des choix aléatoires
 * 
 * @author deguitre & Pignet
 * 
 */
public class InterfaceGraphique extends JFrame implements Affichage, KeyListener
{
	private static final int ICON_SIZE = 32;
	/**
	 * 
	 */
	private final Deplacement p;
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
	 * constante, image vide
	 */
	private final static ImageIcon CINQCOEUR = new ImageIcon("./images/5coeur32.png");
	
	private JLabel scoreLabel;
	/**
	 * @param size nombre de case en hauteur / largeur
	 * @param p partie
	 */
	public InterfaceGraphique(int size, Deplacement p) 
	{
		super("Shoot'em Up");
		
		this.p = p;
		this.size = size;
		
		
		this.setSize(ICON_SIZE*size,ICON_SIZE*(size+2));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gl = new GridLayout(size, size);
		gl.preferredLayoutSize(this);
		JPanel panelZone = new BackGroundPanel(new ImageIcon("./images/fond_noir_etoile.png").getImage());
		panelZone.setLayout(gl);	
		panelZone.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelZone.setBackground(Color.BLACK);
		
		this.labels = new JLabel[size][size];
		for (int y=0; y<(size);y++)
		{
			for (int x=0; x<size;x++)
			{
					this.labels[y][x] = new JLabel(this.VIDE);
					panelZone.add(this.labels[y][x]);
			}
		}
		
		scoreLabel = new JLabel("test");
		scoreLabel.setAlignmentX(CENTER_ALIGNMENT);
		scoreLabel.setBackground(Color.GRAY);
		
		scoreLabel.setForeground(Color.GREEN);
	//	scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
	//	scoreLabel.setVerticalTextPosition(JLabel.CENTER);
	//	scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
		//score.setEditable(false);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setSize(ICON_SIZE*size,ICON_SIZE*(size));
		GridBagLayout glPrincipal = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		//c.weightx = ICON_SIZE*size;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		//glPrincipal.preferredLayoutSize(this);
		panelPrincipal.setLayout(glPrincipal);
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.add(panelZone, c);
		c.weightx = ICON_SIZE;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panelPrincipal.add(scoreLabel,c);
		
		
		
		
		
		this.setContentPane(panelPrincipal);
		this.addKeyListener(this);
		
		this.setVisible(true);
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
					
						case MISSILE : this.labels[y][x].setIcon(MINE);
							break;
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

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT : this.p.move(Direction.GAUCHE);
		break;
		case KeyEvent.VK_RIGHT : this.p.move(Direction.DROITE);
		break;
		case KeyEvent.VK_DOWN : this.p.move(Direction.BAS);
		break;
		case KeyEvent.VK_UP :this.p.move(Direction.HAUT);
		break;
		case KeyEvent.VK_SPACE :this.p.move(Direction.HAUT);// new ThreadMissile(p).start();	
		break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT : this.p.move(Direction.GAUCHE);
		break;
		case KeyEvent.VK_RIGHT : this.p.move(Direction.DROITE);
		break;
		case KeyEvent.VK_DOWN : this.p.move(Direction.BAS);
		break;
		case KeyEvent.VK_UP : this.p.move(Direction.HAUT);
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificationScore(int score)
	{
		this.scoreLabel.setText(""+score);
		
	}
	

}
