package fr.iutvalence.java.projets.shootemup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestionHighScoreBD implements InterfaceHighScore
{
	public Connection connection;
	public GestionHighScoreBD ( String driverJDBC,String urlBD,String login,String password)
	{

		try {Class.forName(driverJDBC);}catch (ClassNotFoundException e) {}
		this.connection = null;
		try
		{
		this.connection = DriverManager.getConnection(urlBD, login, password);
		}
		catch (SQLException e) {}
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
		try {rs = stat.executeQuery(req);}catch (SQLException e) {}
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
	public void setHighScore(Score score)
	{
		Statement stat = null;
		try {stat = this.connection.createStatement(); }catch (SQLException e) {}
		String addScore = "INSERT INTO SCORE VALUES ('"+score.pseudo+"', '"+score.score+"')";
		try
		{
		stat.executeUpdate(addScore);
		}
		catch (SQLException e) {}
		// TODO Auto-generated method stub
		
	}

}
