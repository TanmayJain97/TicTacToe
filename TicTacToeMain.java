package com.birdgelabz.TicTacToe;

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
	private int checkMoveOk() {
		System.out.print("Enter position - ");
		int index=sc.nextInt();
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
	private void playerMove(char[] input) {
		int index;
		do {
			index=checkMoveOk();
			if (index==0) {
				System.out.println("Cannot make move.");
			}else {
				board[index]=input[0];
				break;
			}
		}while(index!=0);
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
		newBoard.playerMove(input);
		
		//printing out board in console
		newBoard.showBoard();
	}
}
