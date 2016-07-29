package tennisGame;

public class Game
{
	
	Integer[] gameScore = new Integer[2];
	
	String[] scoreDescription  = new String[6];
	
	Player playerOne;
	Player playerTwo;

	public Game(Player playerOne, Player playerTwo)
	{
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		gameScore[0] = 0;
		gameScore[1] = 0;
		
		scoreDescription[0] = "love";
		scoreDescription[1] = "fifteen";
		scoreDescription[2] = "thirty";
		scoreDescription[3] = "forty";
		scoreDescription[4] = "forty";
		scoreDescription[5] = "forty";
		
	}

	public String getScore()
	{
		gameScore[0] = playerOne.getBallsWon();
		gameScore[1] = playerTwo.getBallsWon();
		String scoreString = "";
		
		if(gameScore[0] >= 3 && gameScore[1] >= 3)
		{
			switch(gameScore[0] - gameScore[1])
			{
			case -2:
				scoreString = String.format("%s won", playerTwo.getName());
				break;
			case -1:
				scoreString = String.format("advantage %s", playerTwo.getName());
				break;
			case 0:
				scoreString = "deuce";
				break;
			case 1:
				scoreString = String.format("advantage %s", playerOne.getName());
				break;
			case 2:
				scoreString = String.format("%s won", playerOne.getName());
				break;
			}
		}
		else if(gameScore[0] < 3 && gameScore[1] < 3)
		{
			scoreString = scoreString.concat(scoreDescription[gameScore[0]]);
			scoreString = scoreString.concat(", ");
			scoreString = scoreString.concat(scoreDescription[gameScore[1]]);
		}
	
		return scoreString;
	}

	
}
