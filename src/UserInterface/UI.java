package UserInterface;

import Data.Board;

import java.util.Scanner;

public interface UI {

	//Setting the game
	void menu ();

	int askSize();

	char askToken();


	//Printing the game
	void printBoard(Board board);

	void playerWins ();


	//Request input
	void askRoll();


	//Feedback
	void turnFeedback(int move);

	void arcFeedback (boolean good, int entry, int exit);

	void badFeedback ();

	//Testing only
	int askMovement(Board board);
}
