package fr.iutvalence.java.projets.shootemup;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


/**
 * @author deguitre & Pignet
 *
 * Format de la BDD:
 *table : SCORE
 *champs: pseudo varchar(50)
 *		  score int
 */
public class GestionHighScoreBD implements InterfaceHighScore
{
	/**
	 * 
	 */
	public Connection connection;
	/**
	 * @param driverJDBC driver JDBC
	 * @param urlBD url de la BD
	 * @param login login
	 * @param password password
	 */
	public GestionHighScoreBD ( String driverJDBC,String urlBD,String login,String password)
	{

		try {Class.forName(driverJDBC);}catch (ClassNotFoundException e) 
		{JOptionPane.showMessageDialog(new Frame(),"Attention !\n Le driver de base de donnée est introuvable \n la gestion du score ne fonctionnera pas !"," erreur driver manquant ",JOptionPane.WARNING_MESSAGE);/*e.printStackTrace();*/}
		this.connection = null;
		try
		{
		this.connection = DriverManager.getConnection(urlBD, login, password);
		}
		catch (SQLException e) 
		{JOptionPane.showMessageDialog(new Frame(),"Attention !\n La connection à la base de donnée à échoué\n la gestion du score ne fonctionnera pas !"," erreur connection bdd ",JOptionPane.WARNING_MESSAGE);/*e.printStackTrace();*/}
		//try {this.connection.close(); } catch (SQLException e) {}
	}

	@Override
	public Score getHighScore()
	{
		String req = "SELECT MAX(score) as score,pseudo FROM SCORE";
		Statement stat = null;
		String pseudo = "";
		int score =0;
		try
		{
			stat = this.connection.createStatement();
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {rs = stat.executeQuery(req);}catch (SQLException e) {e.printStackTrace();}
		try
		{
			while (rs.next())
			{
			pseudo = rs.getString("pseudo");
			score = rs.getInt("score");
			}
			return new Score(pseudo,score);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addScore(Score score)
	{
		Statement stat = null;
		try {stat = this.connection.createStatement(); }catch (SQLException e) {e.printStackTrace();}
		String addScore = "INSERT INTO SCORE(pseudo,score) VALUES ('"+score.pseudo+"', '"+score.score+"')";
		try
		{
		stat.executeUpdate(addScore);
		}
		catch (SQLException e) {e.printStackTrace();}
		// TODO Auto-generated method stub
		
	}

}
