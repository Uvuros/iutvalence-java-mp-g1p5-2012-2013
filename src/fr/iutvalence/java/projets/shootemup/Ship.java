package fr.iutvalence.java.projets.shootemup;


//FIXME si les vaisseaux ennemis se distinguent du vaisseau du joueur par le fait qu'ils peuvent sortir de la zone de jeu ...
//FIXME .. il faudrait utiliser l'héritage ce qui simplifierait l'écriture de "deplacement" 


/**
 * Gestion des unitées
 * @author Deguitre & Pignet
 *
 */
public class Ship
{
	/**
	 * Valeur représentant la mort du joueur  
	 */
	public static final int MORT = -1;
	/**
	 * Valeur indiquant que le joueur est en vie
	 */
	public static final int VIVANT = 1;
	/**
	 * Position du vaisseau 
	 */
	public Position position;	
	/**
	 * True si le vaisseau tir False sinon
	 */
	public boolean tir;
	
	/**
	 * valeur du vaisseau joueur
	 */
	public static final int joueur = 1;
	/**
	 * valeur des vaisseaux de ennemis
	 */
	public static final int ennemi = 2;
	/**
	 * Représente le type de vaisseau
	 */
	public int type_ship;
	/**
	 * Etat du vaisseau, 1 pour VIVANT, -1 pour MORT
	 */
	public int etat;
	/**
	 * valeur des coordonnées x ou y max
	 */
	public static final int MAX = 100;
	/**
	 * valeur des coordonnées x ou y min
	 */
	public static final int MIN = 100;
	/**
	 * Valeur retournée si les coordonnées sont à l'intérieur de la zone de jeux
	 */
	public static final int IN = 1;
	/**
	 * Valeur retournée si les coordonnées sont à l'extérieur de la zone de jeux
	 */
	public static final int OUT = -1;
	/**
	 * Indique une collision
	 */
	public static final int COLLISION = -3;
	/**
	 * Initialise un vaisseau de type Joueur (type 1, situé au centre de la zone de jeux, etat = vivant)
	 */
	public Ship()
	{
		this.etat = 1;
		Position position = new Position(4,2);
		this.position = position;
		this.position.x = 4;
		this.position.y = 2;
		this.tir = false;	
		this.type_ship = 1;
	}
	
	
	/**
	 * Initialise un vaisseau de type ennemi (choix de la position de départ)
	 * @param x position sur l'axe x
	 * @param y position sur l'axe y
	 * @param terrain Zone de jeux
	 */
	public Ship(int x, int y,Zone terrain)
	{
		this.etat = 1;
		Position position = new Position(4,2);
		this.position = position;
		this.position.x = x;
		this.position.y = y;
		this.tir = false;
		this.type_ship = 2;
		terrain.modification(this.position.x,this.position.y,this.type_ship);
	}
	
	/**
	 * Modifie les coordonnées x et y de l'unité ainsi que la zone de jeux
	 * @param x mouvement sur l'axe x
	 * @param y mouvement sur l'axe y
	 * @param terrain Zone de jeux
	 * @return <tt>OUT</tt> si le mouvement effectué fait sortir l'unitée ou <tt>IN</tt> sinon
	 */
	/*public int deplacement(int x , int y,Zone terrain)
	{
		// Sorti de l'écran en x
		if ((this.coord_x == MAX && x > 0)||(this.coord_x == MIN && x < 0))
		{
			// Sorti de l'écran en x et en y
			if ((this.coord_y == MAX && y > 0)||(this.coord_y == MIN && y < 0))
			{
				// cas d'un vaisseau ennemi => le détruire
				if (this.type_ship != 1)
				{
					terrain.modification(this.coord_x,this.coord_y,0);
					this.detruire();
				}
				return OUT;
			}
			// Sorti de l'écran en x et pas en y
			else
			{
				// cas d'un vaisseau ennemi => le détruire
				if (this.type_ship != 1)
				{
					terrain.modification(this.coord_x,this.coord_y,0);
					this.detruire();
					return OUT;
				}
				// cas vaisseau joueur => déplacement uniquement en y
				else
				{
					if(terrain.modification(this.coord_x,this.coord_y+y,this.type_ship) == -1)
					{
						// détruire l'objet en x,y+y
						// puis déplacer à nouveau le joueur et retourner COLLISION
						terrain.modification(this.coord_x,this.coord_y,0);
						terrain.modification(this.coord_x,this.coord_y+y,this.type_ship);
						this.coord_y = this.coord_y + y;
						return COLLISION;
					}
					else
					{
						// pas de collision, déplacement simple
						terrain.modification(this.coord_x,this.coord_y,0);
						this.coord_y = this.coord_y + y;
						return IN;
					}
				}
			}
		}
		// ne sort pas de l'écran en x
		else
		{
			// ne sort pas de l'écran en x, sorti de l'écran en y
			if ((this.coord_y == MAX && y > 0)||(this.coord_y == MIN && y < 0))
			{
				// Cas vaisseau ennemi => détruire
				if (this.type_ship != 1)
				{
					terrain.modification(this.coord_x,this.coord_y,0);
					this.detruire();
					return OUT;
				}
				// Cas vaisseau joueur => déplacement en x et vérification collision
				else
				{
					if(terrain.modification(this.coord_x+x,this.coord_y,this.type_ship) == -1)
					{
						// détruire l'objet en x+x,y
						// puis déplacer à nouveau le joueur et retourner COLLISION
						terrain.modification(this.coord_x,this.coord_y,0);
						terrain.modification(this.coord_x+x,this.coord_y,this.type_ship);
						this.coord_x = this.coord_x + x;
						return COLLISION;
					}
					else
					{
						// pas de collision, déplacement simple
						terrain.modification(this.coord_x,this.coord_y,0);
						this.coord_x = this.coord_x + x;
						return IN;
					}
				}
			}
			else // Déplacement à l'intérieur de la zone
			{
				// vérification des collisions
				if(terrain.modification(this.coord_x+x,this.coord_y+y,this.type_ship) == -1)
				{
					if(this.type_ship != 1)
					{
						terrain.modification(this.coord_x,this.coord_y,0);
						this.detruire();
						return COLLISION;
					}
					else
					{
						// détruire l'objet en x+x,y+y
						// puis déplacer à nouveau le joueur et retourner COLLISION
						terrain.modification(this.coord_x,this.coord_y,0);
						terrain.modification(this.coord_x+x,this.coord_y+y,this.type_ship);
						this.coord_x = this.coord_x + x;
						this.coord_y = this.coord_y + y;
						return COLLISION;
					}
				}
				else
				{
					terrain.modification(this.coord_x,this.coord_y,0);
					this.coord_y = this.coord_y + y;
					this.coord_x = this.coord_x + x;
					terrain.modification(this.coord_x,this.coord_y,this.type_ship);
					return IN;
				}	
			}
		}
	}*/
	
	/**
	 * fonction permettant de détruire l'unitée
	 */
	public void detruire()
	{
		this.etat = -1;
	}
	/*public void tir()
	{
		if (this.tir == true)
		{
			this.tir = false;
		}
		else
		{
			this.tir = true;
		}
	}*/
				
}