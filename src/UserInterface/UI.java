package UserInterface;
import Data.Board;
import Data.Player;

public interface UI {

	//Setting the game
	void menu ();

	int askSize();

	int askPlayerNum();

	char askToken(int playerNum);


	//Printing the game
	void printBoard(Board board);

	void playerWins ();


	//Request input
	void askRoll(Player player);


	//Feedback
	void turnFeedback(int move);

	void arcFeedback (boolean good, int entry, int exit);

	void badFeedback ();

	//Testing only
	int askMovement(Board board);
}
