package fr.iutvalence.java.projets.shootemup.tests;

import fr.iutvalence.java.projets.shootemup.Position;

/**
 * classe de test / créer deux position les affiche, les compare les translate
 * @author Deguitre & Pignet
 *
 */
public class TestPosition
{
	/**
	 * Permet de tester la classe Position 
	 * Doit afficher les positions créer et les compare
	 * @param args aucun
	 */
	public static void main(String[] args)
	{
		Position p1 = new Position();
		System.out.println(p1);
		Position p2 = new Position(5,2);
		System.out.println(p2);
		if(p1.equals(p2))
		{
			System.out.print("p1 = p2 \n");
		}
		else
		{
			System.out.print("p1 != p2 \n");
		}
		System.out.print("translation de 5,2 de p1 \n");
		p1.translate(5,2);
		
		System.out.println(p1);
		if(p1.equals(p2))
		{
			System.out.print("p1 = p2");
		}
		else
		{
			System.out.print("p1 != p2");
		}
	}

}
