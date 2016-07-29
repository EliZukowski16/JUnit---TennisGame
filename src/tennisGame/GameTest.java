package tennisGame;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class GameTest
{

	Player victor;
    Player sarah;
    Game game;
 
    @Before
    public void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }
 
    @Test
    public void loveShouldBeDescriptionForScore0() {
        Game game = new Game(victor, sarah);
        assertEquals(game.getScore(), "love, love");
    }
 
    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertEquals(game.getScore(), "love, fifteen");
    }
 
    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertEquals(game.getScore(), "thirty, fifteen");
    }
 
    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                victor.winBall();
        });
        assertEquals(game.getScore(), "forty, love");
    }
 
    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winBall();
        });
        assertEquals(game.getScore(), "advantage Sarah");
    }
 
    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
        assertEquals(game.getScore(), "deuce");
        victor.winBall();
        assertNotEquals(game.getScore(), "deuce");
        sarah.winBall();
        assertEquals(game.getScore(), "deuce");
    }
 
    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        for(int index = 1; index <= 4; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
        assertNotEquals(game.getScore(), "Victor won");
        assertNotEquals(game.getScore(), "Sarah won");
        victor.winBall();
        assertEquals(game.getScore(), "Victor won");
    }

}
