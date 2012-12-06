package fr.iutvalence.java.projets.shootemup;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * @author deguitre & Pignet
 *
 */
public class BackGroundPanel extends JPanel {
	private Image image;
	    
	public BackGroundPanel(Image image) {
	        this.image = image;
	    }
	
	@Override
	protected void paintComponent(Graphics g) {
	        g.drawImage(image, 0, 0, null);
	    }
	}

