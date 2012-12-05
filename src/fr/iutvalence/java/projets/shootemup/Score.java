package fr.iutvalence.java.projets.shootemup;

import java.sql.Date;

/**
 * @author deguitre & Pignet
 *
 */
public class Score
{

	/**
	 * 
	 */
	public String pseudo;
	/**
	 * 
	 */
	public int score;
	/**
	 * @param pseudo pseudo du joueur ayant effectué ce score
	 * @param score score enregistré
	 * @param date date à laquelle le score a été effectué 
	 */
	public Score(String pseudo,int score)
	{
		this.pseudo = pseudo;
		this.score = score;
	}
}
