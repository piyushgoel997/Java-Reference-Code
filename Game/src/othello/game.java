package othello;

import java.util.Scanner;

public class game {

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.println("enter name of player 1 and symbol");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		int symbol = s.nextInt();
		Player a = new Player(name, symbol);
		System.out.println("enter name of player 2 and symbol");
		name = s.next();
		symbol = s.nextInt();
		Player b = new Player(name, symbol);
		Board o = new Board(a, b);
		
		o.printBoard();
		boolean aTurn = true;
		while(o.gameStatus() == Board.INCOMPLETE){
			if(aTurn){
				System.out.println("enter co-ordinates");
				int x = s.nextInt();
				int y = s.nextInt();
				boolean done = o.move(a.symbol,x,y);
				while(!done){
					System.out.println("Invalid move!! Try Again.");
					System.out.println("enter co-ordinates");
					x = s.nextInt();
					y = s.nextInt();
					done = o.move(a.symbol,x,y);
				}
				aTurn = false;
			}else{
				System.out.println("enter co-ordinates");
				int x = s.nextInt();
				int y = s.nextInt();
				boolean done = o.move(b.symbol,x,y);
				while(!done){
					System.out.println("Invalid move!! Try Again.");
					System.out.println("enter co-ordinates");
					x = s.nextInt();
					y = s.nextInt();
					done = o.move(b.symbol,x,y);
				}
				aTurn = true;
			}
			o.printBoard();
		}
		s.close();
		if(o.gameStatus() == Board.PLAYER1WINS){
			System.out.println("PLAYER 1 WINS");
			return;
		}
		if(o.gameStatus() == Board.PLAYER2WINS){
			System.out.println("PLAYER 2 WINS");
			return;
		}
		if(o.gameStatus() == Board.DRAW){
			System.out.println("DRAW");
			return;
		}
	}
	
}
