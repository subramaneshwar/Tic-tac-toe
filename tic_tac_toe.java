package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class tic_tac_toe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		Scanner in = new Scanner(System.in);
		while(true) {
		Player_turn(board,in);
		if(isgamefinshed(board)) {
			break;
		}
		print_board(board);
		computerturn(board);
		if(isgamefinshed(board)) {
			break;
		}
		print_board(board);
		}
		

	}




	private static boolean isgamefinshed(char[][] board) {
		
		if(player_wins(board,'X')) {
			System.out.println("Player Wins :)");
			print_board(board);
			return true;
			
		}
		if(player_wins(board,'0')) {
			System.out.println("Computer Wins :)");
			print_board(board);
			return true;
			
		}
		
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return false;
	}




	private static boolean player_wins(char[][] board,char symbol) {
		if((board[0][0]==symbol&&board[0][1]==symbol&&board[0][2]==symbol)||
		   (board[1][0]==symbol&&board[1][1]==symbol&&board[1][2]==symbol)||
		   (board[2][0]==symbol&&board[2][1]==symbol&&board[2][2]==symbol)||
//		   vertical
		   (board[0][0]==symbol&&board[1][0]==symbol&&board[2][0]==symbol)||
		   (board[0][1]==symbol&&board[1][1]==symbol&&board[2][1]==symbol)||
		   (board[0][2]==symbol&&board[1][2]==symbol&&board[2][2]==symbol)||
//		   diagonal
		   (board[0][0]==symbol&&board[1][1]==symbol&&board[2][2]==symbol)||
		   (board[0][2]==symbol&&board[1][1]==symbol&&board[2][0]==symbol)) {
		   return true;
		}
		return false;
	}




	private static void computerturn(char[][] board) {
		Random rand = new Random();
		int computer_move;
		while(true) {
			computer_move = rand.nextInt(9) + 1;
			if(is_Valid_move(board,Integer.toString(computer_move))) {
				break;
			}
			
		}
		System.out.println("computer move: "+computer_move );
		place_move(board, Integer.toString(computer_move),'O');
	}




	private static boolean is_Valid_move(char[][] board,String position) {
		switch(position) {
		case "1":
			return(board[0][0]==' ');
			 
		case "2":
			return(board[0][1]==' ');
		
		case "3":
			return(board[0][2]==' ');
		case "4":
			return(board[1][0]==' ');
		case "5":
			return(board[1][1]==' ');
		case "6":
			return(board[1][2]==' ');
		case "7":
			return(board[2][0]==' ');
		case "8":
			return(board[2][1]==' ');
		case "9":
			return(board[2][2]==' ');
		default:
			return false;
		}
		
	}

	private static void Player_turn(char[][] board,Scanner in) {
		
//		Scanner in = new Scanner(System.in);
		String user_input;
		while(true) {
		System.out.println("Where would you like to play? (1-9)");
		user_input = in.nextLine();
		if(is_Valid_move(board,user_input)){
			break;
		}else {
			System.out.println("Is Not Valid Move");
		}
		}
		place_move(board, user_input,'X');
	}




	private static void place_move(char[][] board,String position, char symbol ) {
		switch(position) {
		case "1":
			board[0][0]=symbol;
			break;
		case "2":
			board[0][1]=symbol;
			break;
		case "3":
			board[0][2]=symbol;
			break;
		case "4":
			board[1][0]=symbol;
			break;
		case "5":
			board[1][1]=symbol;
			break;
		case "6":
			board[1][2]=symbol;
			break;
		case "7":
			board[2][0]=symbol;
			break;
		case "8":
			board[2][1]=symbol;
			break;
		case "9":
			board[2][2]=symbol;
			break;
		default:
			System.out.print(":(");
		}
	}

	
	
	private static void print_board(char[][] board) {
		System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
	}

}
