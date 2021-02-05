import java.util.Scanner;
// https://en.wikipedia.org/wiki/Toads_and_Frogs

public class ToadsAndFrogsSolver {
	public static final char TOAD = 'T', FROG = 'F', EMPTY = '-';

	public static void main(String[] args) {
  	  Scanner in = new Scanner(System.in);
  	  System.out.print("Board position (using TF-)? ");
  	  String board = in.nextLine().trim().toUpperCase();
  	  System.out.print("Current player (T/F)? ");
  	  char currentPlayer = in.nextLine().trim().toUpperCase().charAt(0);
  	  System.out.println("Winner: " + getWinner(board.toCharArray(), currentPlayer));
  	  in.close();
	}

	public static char getWinner(char[] board, char currentPlayer) {
  	  if (currentPlayer == FROG) {
  		  for(int i = board.length - 1; i > 0; i--)
  			  if (board[i] == FROG)
  				  if(i - 1 >= 0 && board[i - 1] == EMPTY) {
  					  board[i] = EMPTY;
  					  board[i - 1] = FROG;
  					  char winner = getWinner(board, 'T');
  					  board[i] = FROG;
  					  board[i - 1] = EMPTY;
  					  if ( winner == currentPlayer)
  						  return currentPlayer;
  				  }
   		  else
   			  if(i - 2 >= 0 && board[i - 2] == EMPTY && board[i - 1] == TOAD) {
   				  board[i] = EMPTY;
   				  board[i - 2] = FROG;    
   				  char winner = getWinner(board, 'T');
   				  board[i] = FROG;
   				  board[i - 2] = EMPTY;
   				  if ( winner == currentPlayer)
   					  return currentPlayer;
   			  }

  	  }
  	  if (currentPlayer == TOAD) {
  		  for(int i = 0; i < board.length; i++ )
  			  if (board[i] == TOAD)
  				  if(i + 1 < board.length && board[i + 1] == EMPTY) {
  					  board[i] = EMPTY;
  					  board[i + 1] = TOAD;    
  					  char winner = getWinner(board, 'F');
  					  board[i] = TOAD;
  					  board[i + 1] = EMPTY;
  					  if ( winner == currentPlayer)
  						  return currentPlayer;
  				  }
   		  else
   			  if(i + 2 < board.length && board[i + 2] == EMPTY && board[i + 1] == FROG) {
   				  board[i] = EMPTY;
   				  board[i + 2] = TOAD;    
   				  char winner = getWinner(board, 'F');
   				  board[i] = TOAD;
   				  board[i + 2] = EMPTY;
   				  if ( winner == currentPlayer)
   					  return currentPlayer;
   			  }  			 
  	  }
  	  return (currentPlayer == TOAD ? FROG : TOAD );
	}
}




