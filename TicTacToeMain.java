package com.birdgelabz.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeMain {

	public char[] board = new char[10];
	static Scanner sc=new Scanner(System.in);

	// UC1
	/**Method to create a new game board.
	 * @return new empty game board
	 */
	private char[] createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = 0;
		}
		return board;
	}

	//UC2
	/**Method to allow user to choose "x" or "o".
	 * @return character array with- <br>	
	 * 1. First element as player char <br>
	 * 2. Second element as computer char
	 */
	private char[] getInput() {
		char x='x';
		char o='o';
		char[] output=new char[2];
		System.out.println("Please enter a character-");
		String input=(sc.next()).toLowerCase();
		char mark=input.charAt(0);
		if (mark==x) {
			System.out.println("User has entered- "+x);
			output[0]=x;
			System.out.println("Computer has entered- "+o);
			output[1]=o;
		}else if(mark==o) {
			System.out.println("User has entered- "+o);
			output[0]=o;
			System.out.println("Computer has entered- "+x);
			output[1]=x;
		}else {
			System.out.println("Unknown entry.");
		}
		return output;
	}

	//UC3
	/**
	 * Method to print out board
	 */
	private void showBoard() {
		for(int i=1;i<10;i++) {
			if (i%3==0) {
				System.out.println(board[i]);
			}else {
				System.out.print(board[i]+" | ");
			}
		}
	}

	//UC4
	/**Method to check if player intended move is valid
	 * @param index where player intends to move
	 * @return 0-Invalid Move <br>
	 * Index-Valid Move
	 */
	private int checkMoveOk(int index) {
		if (index>=1 && index<=9) {
			if ((board[index])==0) {
				return index;
			}else {
				return 0;
			}
		}else {
			System.out.println("Index out of bounds!");
			return 0;
		}
	}

	//UC5
	/**Method to make player move to desired index <br>
	 * Internally Calls checkMoveOk
	 * @param CharArray containing x and o
	 * @param Player
	 * 
	 */
	private void playerMove(char[] input,int player) {
		int index;
		do {
			System.out.print("Enter position - ");
			int in=sc.nextInt();
			index=checkMoveOk(in);
			if (index==0) {
				System.out.println("Cannot make move.");
			}else {
				board[index]=input[player];
				break;
			}
		}while(index!=0);
	}

	//UC6
	/**Method to toss between Player and Comp
	 * @return 0-Computer Wins Toss <br>
	 * 1-Player Wins Toss
	 */
	private int toss() {
		Random  r=new Random();
		int randomNum=r.nextInt(2);
		if(randomNum==0) {
			System.out.println("Computer won the Toss.");
		}else {
			System.out.println("User won the Toss.");
		}
		return randomNum;
	}

	//UC7
	/**Method to check if Win/Tie/Loss Cond. is fulfilled
	 * @param CharArray containing x and o
	 * @param player
	 * @return 0-Game Continues <br>
	 * 1-Game Over Cond.
	 */
	private int getWinOrTie(char[] input,int player) {
		char playerMove=input[player];
		//Win Cond.
		if(
				//Horizontal Win Cond.
				(board[1]==playerMove && board[2]==playerMove && board[3]==playerMove) ||
				(board[4]==playerMove && board[5]==playerMove && board[6]==playerMove) ||
				(board[7]==playerMove && board[8]==playerMove && board[9]==playerMove) ||

				//Vertical Win Cond.
				(board[1]==playerMove && board[4]==playerMove && board[7]==playerMove) ||
				(board[2]==playerMove && board[5]==playerMove && board[8]==playerMove) ||
				(board[3]==playerMove && board[6]==playerMove && board[9]==playerMove) ||

				//Cross Win Cond.
				(board[1]==playerMove && board[5]==playerMove && board[9]==playerMove) ||
				(board[3]==playerMove && board[5]==playerMove && board[7]==playerMove)
				)
		{
			if (player==0) {
				System.out.println("User has won!!");
			}else {
				System.out.println("Computer has won!!");
			}
			//1 returned to show game has ended.
			return 1;
		}
		//No win - No Tie
		for(int i=1;i<10;i++) {
			if (checkMoveOk(i)!=0) {
				if (player==0) {
					System.out.println("Computer's Move.");
				}else {
					System.out.println("Player's Move");
				}
				//0 returned to switch moves
				return 0;
			}
		}
		//Last Cond-Tie
		System.out.println("Its a tie.");
		//1 returned to show game has ended.
		return 1;
	}

	//UC8
	/**Provides Comp logic to move a win posn.
	 * @param CharArray containing x and o
	 * @return true-Move completed <br>
	 * false-Move Not Possible
	 */
	private boolean compMoveToWin(char[] input) {
		//choose which char to put in board
		char compLetter=input[1];

		//makes Comp move in order to win
		if(board[1]==compLetter && board[2]==compLetter && board[3]==0)
			board[3] = compLetter;
		else if(board[1]==compLetter && board[2]==0 && board[3]==compLetter)
			board[2] = compLetter;
		else if(board[1]==0 && board[2]==compLetter && board[3]==compLetter)
			board[1] = compLetter;
		else if(board[4]==compLetter && board[5]==compLetter && board[6]==0)
			board[6] = compLetter;
		else if(board[4]==compLetter && board[5]==0 && board[6]==compLetter)
			board[5] = compLetter;
		else if(board[4]==0 && board[5]==compLetter && board[6]==compLetter)
			board[4] = compLetter;
		else if(board[7]==compLetter && board[8]==compLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[7]==compLetter && board[8]==0 && board[9]==compLetter)
			board[8] = compLetter;
		else if(board[7]==0 && board[8]==compLetter && board[9]==compLetter)
			board[7] = compLetter;
		else if(board[1]==compLetter && board[4]==compLetter && board[7]==0)
			board[7] = compLetter;
		else if(board[1]==compLetter && board[4]==0 && board[7]==compLetter)
			board[4] = compLetter;
		else if(board[1]==0 && board[4]==compLetter && board[7]==compLetter)
			board[1] = compLetter;
		else if(board[2]==compLetter && board[5]==compLetter && board[8]==0)
			board[8] = compLetter;
		else if(board[2]==compLetter && board[5]==0 && board[8]==compLetter)
			board[5] = compLetter;
		else if(board[2]==0 && board[5]==compLetter && board[8]==compLetter)
			board[2] = compLetter;
		else if(board[3]==compLetter && board[6]==compLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[3]==compLetter && board[6]==0 && board[9]==compLetter)
			board[6] = compLetter;
		else if(board[3]==0 && board[6]==compLetter && board[9]==compLetter)
			board[3] = compLetter;
		else if(board[1]==compLetter && board[5]==compLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[1]==compLetter && board[5]==0 && board[9]==compLetter)
			board[5] = compLetter;
		else if(board[1]==0 && board[5]==compLetter && board[9]==compLetter)
			board[1] = compLetter;
		else if(board[3]==compLetter && board[5]==compLetter && board[7]==0)
			board[7] = compLetter;
		else if(board[3]==compLetter && board[5]==0 && board[7]==compLetter)
			board[5] = compLetter;
		else if(board[3]==0 && board[5]==compLetter && board[7]==compLetter)
			board[3] = compLetter;
		else {
			return false;
		}
		return true;
	}

	//UC9
	/**Provides Comp logic to block player from winning.
	 * @param CharArray containing x and o
	 * @return true-Move completed <br>
	 * false-Move Not Possible
	 */
	private boolean compMoveToBlockPlayerWin(char[] input) {
		//find char of Player and Comp
		char playerLetter=input[0];
		char compLetter=input[1];

		//makes Comp move in order to block player get sequence
		if(board[1]==playerLetter && board[2]==playerLetter && board[3]==0)
			board[3] = compLetter;
		else if(board[1]==playerLetter && board[2]==0 && board[3]==playerLetter)
			board[2] = compLetter;
		else if(board[1]==0 && board[2]==playerLetter && board[3]==playerLetter)
			board[1] = compLetter;
		else if(board[4]==playerLetter && board[5]==playerLetter && board[6]==0)
			board[6] = compLetter;
		else if(board[4]==playerLetter && board[5]==0 && board[6]==playerLetter)
			board[5] = compLetter;
		else if(board[4]==0 && board[5]==playerLetter && board[6]==playerLetter)
			board[4] = compLetter;
		else if(board[7]==playerLetter && board[8]==playerLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[7]==playerLetter && board[8]==0 && board[9]==playerLetter)
			board[8] = compLetter;
		else if(board[7]==0 && board[8]==playerLetter && board[9]==playerLetter)
			board[7] = compLetter;
		else if(board[1]==playerLetter && board[4]==playerLetter && board[7]==0)
			board[7] = compLetter;
		else if(board[1]==playerLetter && board[4]==0 && board[7]==playerLetter)
			board[4] = compLetter;
		else if(board[1]==0 && board[4]==playerLetter && board[7]==playerLetter)
			board[1] = compLetter;
		else if(board[2]==playerLetter && board[5]==playerLetter && board[8]==0)
			board[8] = compLetter;
		else if(board[2]==playerLetter && board[5]==0 && board[8]==playerLetter)
			board[5] = compLetter;
		else if(board[2]==0 && board[5]==playerLetter && board[8]==playerLetter)
			board[2] = compLetter;
		else if(board[3]==playerLetter && board[6]==playerLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[3]==playerLetter && board[6]==0 && board[9]==playerLetter)
			board[6] = compLetter;
		else if(board[3]==0 && board[6]==playerLetter && board[9]==playerLetter)
			board[3] = compLetter;
		else if(board[1]==playerLetter && board[5]==playerLetter && board[9]==0)
			board[9] = compLetter;
		else if(board[1]==playerLetter && board[5]==0 && board[9]==playerLetter)
			board[5] = compLetter;
		else if(board[1]==0 && board[5]==playerLetter && board[9]==playerLetter)
			board[1] = compLetter;
		else if(board[3]==playerLetter && board[5]==playerLetter && board[7]==0)
			board[7] = compLetter;
		else if(board[3]==playerLetter && board[5]==0 && board[7]==playerLetter)
			board[5] = compLetter;
		else if(board[3]==0 && board[5]==playerLetter && board[7]==playerLetter)
			board[3] = compLetter;
		else {
			return false;
		}
		return true;
	}

	//UC10
	/**Provides Comp logic to take available corners
	 * @param CharArray containing x and o
	 * @return true-Move completed <br>
	 * false-Move Not Possible
	 */
	private boolean compMoveToTakeCorner(char[] input) {
		//choose which char to put in board
		char compLetter=input[1];

		//move to take corner
		if(checkMoveOk(1)!=0)
			board[1] = compLetter;
		else if(checkMoveOk(3)!=0)
			board[3] = compLetter;
		else if(checkMoveOk(7)!=0)
			board[7] = compLetter;
		else if(checkMoveOk(9)!=0)
			board[9] = compLetter;
		else
			return false;
		return true;
	}

	//UC11
	/**Provides Comp logic to take center and available spaces
	 * @param CharArray containing x and o
	 * 
	 */
	private void compMoveToAvailableSpace(char[] input) {
		//choose which char to put in board
		char compLetter=input[1];

		//move to take center
		if(checkMoveOk(5)!=0)
			board[5] = compLetter;
		//move to take rest positions
		else if(checkMoveOk(2)!=0)
			board[2] = compLetter;
		else if(checkMoveOk(4)!=0)
			board[4] = compLetter;
		else if(checkMoveOk(6)!=0)
			board[6] = compLetter;
		else if(checkMoveOk(8)!=0)
			board[8] = compLetter;
	}

	/**Internally calls all Comp Move sub methods
	 * @param CharArray containing x and o
	 */
	private void compMove(char[] input) {
		//Calling all computer movement sub-methods sequentially.
		if(!compMoveToWin(input)) {
			if(!compMoveToBlockPlayerWin(input)) {
				if(!compMoveToTakeCorner(input)) {
					if(!compMoveToTakeCorner(input)) {
						compMoveToAvailableSpace(input);
					}
				}
			}
		}
	}
	
	//UC12
	/**Checks for game end condition
	 * @param CharArray containing x and o
	 * @param player
	 * @return true-Game Over <br>
	 * false-Game Continues
	 */
	private boolean checkGameOver(char[] input,int player) {
		int gameStatus=getWinOrTie(input, player);
		if(gameStatus==1)
			System.out.println("-----Game Over-----");
		else
			return false;
		return true;
	}
	
	//Main Method
	public static void main(String[] args) {
		TicTacToeMain newBoard = new TicTacToeMain();
		char[] myBoard=newBoard.createBoard();

		//first entry is player and second entry is computer 
		char[] input=newBoard.getInput();

		//printing out board in console
		newBoard.showBoard();

		//trying to move
		newBoard.playerMove(input,0);
		newBoard.getWinOrTie(input, 0);

		//printing out board in console
		newBoard.showBoard();

		//Initiating toss
		newBoard.toss();
	}
}
