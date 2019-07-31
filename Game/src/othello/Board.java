package othello;

public class Board {
	
	public int[][] board;
	public final Player first;
	public final Player second;
	public static int PLAYER1WINS = 1;
	public static int PLAYER2WINS = 2;
	public static int DRAW = 3;
	public static int INCOMPLETE = 4;
	public static int xDir[] = {-1,-1,-1,0,1,1,1,0};
	public static int yDir[] = {-1,0,1,1,1,0,-1,-1};

	public Board(Player a, Player b) {
		board = new int[8][8];
		first = a;
		second = b;
		//		for(int i = 0; i < board.length; i++){
		//			for(int j = 0; j < board[i].length; j++){
		//				board[i][j] = -1;
		//			}
		//		}
		board[3][3] = a.symbol;
		board[4][4] = a.symbol;
		board[4][3] = b.symbol;
		board[3][4] = b.symbol;
	}

	public int gameStatus() {
		int i = 0, j = 0;


		for(i = 0; i < board.length; i++){
			for(j = 0; j < board[0].length; j++){
				if(board[i][j] == second.symbol){
					break;
				}
			}
			if(j < board[0].length){
				break;
			}
		}
		if(i == board.length && j == board[0].length){
			return PLAYER1WINS;
		}


		for(i = 0; i < board.length; i++){
			for(j = 0; j < board[0].length; j++){
				if(board[i][j] == first.symbol){
					break;
				}
			}
			if(j < board[0].length){
				break;
			}
		}
		if(i == board.length && j == board[0].length){
			return PLAYER2WINS;
		}

		for(i = 0; i < board.length; i++){
			for(j = 0; j < board[0].length; j++){
				if(checkMove(first.symbol, i, j)){
					break;
				}
				if(checkMove(second.symbol, i, j)){
					break;
				}
			}
			if(j < board[0].length){
				break;
			}
		}
		if(i == board.length && j == board[0].length){
			return DRAW;
		}

		return INCOMPLETE;
	}

	public boolean move(int symbol, int x, int y) {
		if(x < 0 || x > 7 || y < 0 || y > 7 || board[x][y] != 0){
			return false;
		}
		boolean ans = false;
		for(int k = 0; k < xDir.length; k++){
			int stepX = xDir[k];
			int stepY = yDir[k];

			int i = x + stepX;
			int j = y + stepY;
			int count = 0;
			while(i >= 0 && i < 8 && j >= 0 && j < 8){
				if(board[i][j] == 0){
					break;
				}else if(board[i][j] != symbol){
					i += stepX;
					j += stepY;
					count++;
				}else{
					while(i != x || j != y){
						board[i][j] = symbol;
						i -= stepX;
						j -= stepY;
					}
					board[i][j] = symbol;
					break;
				}				
			}
			if(count > 0){
				ans = true;
			}
		}
		return ans;

	}

	private boolean checkMove(int symbol, int x, int y) {
		if(x < 0 || x > 7 || y < 0 || y > 7 || board[x][y] != 0){
			return false;
		}
		boolean ans = false;
		for(int k = 0; k < xDir.length; k++){
			int stepX = xDir[k];
			int stepY = yDir[k];

			int i = x + stepX;
			int j = y + stepY;
			int count = 0;
			while(i >= 0 && i < 8 && j >= 0 && j < 8){
				if(board[i][j] == 0){
					break;
				}else if(board[i][j] != symbol){
					i += stepX;
					j += stepY;
					count++;
				}else{
					while(i != x || j != y){
						i -= stepX;
						j -= stepY;
					}
					break;
				}				
			}
			if(count > 0){
				ans = true;
			}
		}
		return ans;

	}

	public void printBoard(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(" | "+ board[i][j]+" | ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
