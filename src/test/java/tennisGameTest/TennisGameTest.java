package tennisGameTest;
import junit.framework.TestCase;
import tennisGameJava.TennisGame;
/*
Rules:
1. A game is won by the first player to have won at least four points in total 
and at least two points more than the opponent.

2. The running score of each game is described in a manner peculiar to tennis:
 scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.

3. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.

4. If at least three points have been scored by each side and
 a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.
*/
public class TennisGameTest extends TestCase {
	
	TennisGame game = new TennisGame("Boris Becker" , "Bjørn Borg");
	
	public void testNewGameShouldReturnLoveAll()
	{
		String score = game.getScore();
		
		assertEquals("Love all", score);
	}
	
	public void testPlayerOneWinsFirstBall()
	{
		game.playerOneScores();

		String score = game.getScore();
		assertEquals("Fifteen,Love", score);		
	}
	
	public void testFifteenAll(){
		game.playerOneScores();
		game.playerTwoScores();
		
		String score = game.getScore();
		assertEquals("Fifteen all", score);
	}
	
	public void testPlayerTwoWinsFirstTwoBalls() {
		createScore(0, 2);
		
		String score = game.getScore();
		assertEquals("Love,Thirty", score);
	}
	
	
	public void testPlayerOneWinsFirstThreeBalls(){
		createScore(3, 0);
		String score = game.getScore();
		assertEquals("Forty,Love", score);
	}
	
	public void testPlayersAreDeuce() {
		createScore(3, 3);
		
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}
	
	public void testPlayerOneWinsGame()
	{
		createScore(4, 0);
		
		String score = game.getScore();
		assertEquals("Boris Becker wins", score);
	}
	
	public void testPlayerTwoWinsGame(){
		createScore(1,4);
		
		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}
	
	public void testPlayersAreDuce4() {
		createScore(4, 4);
		String score = game.getScore();
		assertEquals("Deuce", score);		
	}

	public void testPlayerTwoAdvantage(){
		createScore(4, 5);
		
		String score = game.getScore();
		assertEquals("Advantage Bjørn Borg", score);
	}

	public void testPlayerOneAdvantage(){
		createScore(5, 4);
		
		String score = game.getScore();
		assertEquals("Advantage Boris Becker", score);
	}
	
	public void testPlayerTwoWins(){
		createScore(2, 4);
		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}
	
	
	public void testPlayerTwoWinsAfterAdvantage() {
		createScore(6, 8);
		String score = game.getScore();
		assertEquals("Bjørn Borg wins", score);
	}
	
	
	
	public void testPlayerOneWinsAfterAdvantage() {
		createScore(8, 6);
		String score = game.getScore();
		assertEquals("Boris Becker wins", score);
	}
	
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			game.playerTwoScores();
		}
	}
	
 
}
