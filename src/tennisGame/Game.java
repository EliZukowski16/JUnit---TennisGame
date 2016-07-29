package tennisGame;

public class Game
{
	
	Integer[] score = new Integer[2];
	
	String[] scoreDescription  = new String[4];
	
	
	Player playerOne;
	Player playerTwo;

	public Game(Player playerOne, Player playerTwo)
	{
		// TODO Auto-generated constructor stub
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		score[0] = 0;
		score[1] = 0;
		
		scoreDescription[0] = "love";
		scoreDescription[1] = "fifteen";
		scoreDescription[2] = "thirty";
		scoreDescription[3] = "forty";
		
	}

	public String getScore()
	{
		score[0] = playerOne.getBallsWon();
		score[1] = playerTwo.getBallsWon();
		String scoreString = "";


		scoreString = scoreString.concat(scoreDescription[score[0]]);
		scoreString = scoreString.concat(", ");
		scoreString = scoreString.concat(scoreDescription[score[1]]);

		return scoreString;
	}

	
}
