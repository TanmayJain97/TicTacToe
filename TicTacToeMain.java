package com.birdgelabz.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeMain {

	public char[] board = new char[10];
	static Scanner sc=new Scanner(System.in);

	// UC1
	private char[] createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = 0;
		}
		return board;
	}

	//UC2
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

	public int getWinOrTie(char[] input,int player) {
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
