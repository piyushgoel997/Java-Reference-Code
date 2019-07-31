package othello_UI;

public class Game_UI {

	public static void main(String[] args) {
		start();
	}

	private static void start() {
//		System.out.println("enter name of player 1");
//		Scanner s = new Scanner(System.in);
//		String a = s.next();
//		System.out.println("enter name of player 2");
//		String b = s.next();
		Board_UI o = new Board_UI("a", "b");
		//TODO inside while loop.
		
		if(o.gameStatus() == Board_UI.BLACKWINS){
			System.out.println("Black Wins");
		}
		else if(o.gameStatus() == Board_UI.WHITEWINS){
			System.out.println("White Wins");
		}
		else if(o.gameStatus() == Board_UI.DRAW){
			System.out.println("Draw");
		}
		
	}

}
