import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.iutvalence.java.projets.shootemup.BackGroundPanel;

public class TestFrame
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("Test");
		jf.setSize(160,160);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon mine = new ImageIcon("./images/mine_32x32.png");
		ImageIcon vaisseau = new ImageIcon("./images/vaisseau_32x32.png");
		ImageIcon vide = new ImageIcon("./images/vide_32x32.png");
		
		ImageIcon image = new ImageIcon("./images/fond_noir_etoile.png");
		BackGroundPanel bgp = new BackGroundPanel(image.getImage());
		jf.setContentPane(bgp);
		
		GridLayout gl = new GridLayout(5, 5);
		gl.preferredLayoutSize(jf);
		
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(gl);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBackground(Color.BLACK);
		
		Random r = new Random();
		boolean v = false;
		
		for (int i=1; i<25;i++)
		{
			int rand = r.nextInt(3);
			if ((rand == 0)&& (!v)) 
			{
				contentPane.add(new JLabel(vaisseau));
				System.out.println("Va");
				v = true;
			}
			else
			{
				if (rand == 1)
				{
					contentPane.add(new JLabel(mine));
					System.out.println("Mi");
				}
				else 
					{
					contentPane.add(new JLabel(vide));
					System.out.println("Vi");
					}
			}
			
		}
		
		
		
		
		jf.setVisible(true);
		
	}

}
