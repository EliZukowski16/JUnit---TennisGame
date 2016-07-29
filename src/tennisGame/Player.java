package tennisGame;

public class Player
{
	private String name;
	private Integer ballsWon;

	public Player(String name)
	{
		this.name = name;
		ballsWon = 0;
	}

	public void winBall()
	{
		ballsWon++;
		
	}
	
	public Integer getBallsWon()
	{
		return ballsWon;
	}


}
