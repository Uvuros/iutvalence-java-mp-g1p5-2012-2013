import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestFrame
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("Test");
		jf.setSize(640,480);

		jf.setResizable(false);

		ImageIcon icon = new ImageIcon("./images/Troll.png", "troll");
		GridLayout gl = new GridLayout(2, 2);
		jf.getContentPane().setLayout(gl);
		
		JLabel label1 = new JLabel("Image and Text", icon, JLabel.CENTER);
		JLabel label2 = new JLabel("Image and Text", icon, JLabel.CENTER);
		jf.getContentPane().add(label1);
		
		jf.getContentPane().add(label2);
		jf.setVisible(true);
		
	}

}
