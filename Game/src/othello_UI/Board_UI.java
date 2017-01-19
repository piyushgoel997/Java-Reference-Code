package othello_UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Board_UI extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public int[][] board;
	public final Player_UI first;
	public final Player_UI second;
	public static int BLACKWINS = 1;
	public static int WHITEWINS = 2;
	public static int DRAW = 3;
	public static int INCOMPLETE = 4;
	public static int dirArr[] = {-9,-8,-7,-1,1,7,8,9};

	JPanel[] row = new JPanel[8];
	JButton[] buttons = new JButton[64];

	Dimension buttonDimension = new Dimension(30, 30);
	Dimension rowDimension = new Dimension(250, 32);


	public boolean aTurn = true;


	public Board_UI(String a, String b) {

		// UI

		super("Othello");
		setDesign();
		setSize(300, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(8, 8);
		setLayout(grid);
		for(int i = 0; i < 64; i++){
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(buttonDimension);
			buttons[i].setBackground(Color.BLUE);
			buttons[i].addActionListener(this);
		}
		int k = 0;
		for(int i = 0; i < 8; i++){
			row[i] = new JPanel();
			row[i].setPreferredSize(rowDimension);
			for(int j = 0; j < 8; j++){
				row[i].add(buttons[k]);
				k++;
			}
			add(row[i]);
		}
		first = new Player_UI(a, Color.BLACK);
		second = new Player_UI(a, Color.WHITE);
		buttons[27].setBackground(Color.BLACK);
		buttons[36].setBackground(Color.BLACK);
		buttons[28].setBackground(Color.WHITE);
		buttons[35].setBackground(Color.WHITE);
		setVisible(true);
	}

	private void setDesign() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {   
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0; 
		while(i < 64){
			if(e.getSource() == buttons[i]){
				break;
			}
			i++;
		}
		if(aTurn){
			//			buttons[i].setBackground(Color.BLACK);
			boolean temp = move(i, Color.BLACK);
			if(temp){
				aTurn = false;
			}
		}else{
			//			buttons[i].setBackground(Color.WHITE);
			boolean temp = move(i, Color.WHITE);
			if(temp){
				aTurn = true;
			}
		}
		
	}

	public boolean move(int ptr, Color currColor) {
		if(buttons[ptr].getBackground() != Color.BLUE){
			return false;
		}
		int dirCt = 0;
		for(int i = 0; i < 8; i++){
			int temp = ptr;
			boolean encounter = false;
			temp += dirArr[i];
			int ct = 0;			
			while(temp >= 0 && temp < 64 && buttons[temp].getBackground() != Color.BLUE){
				if(buttons[temp].getBackground() == currColor){
					encounter = true;
					break;
				}else{
					temp += dirArr[i];
					ct++;
				}				 
			}
			if(ct > 0 && encounter){
				temp -= dirArr[i];
				while(temp != ptr){
					buttons[temp].setBackground(currColor);
					temp -= dirArr[i];
				}
				buttons[temp].setBackground(currColor);
				dirCt++;
			}
		}
		
		
		
		if(dirCt > 0){
			return true;
		}
		return false;
	}

	public int gameStatus(){
		int blackCount = 0, whiteCount = 0;
		for(int i = 0; i < 64; i++){
			if(buttons[i].getBackground() == Color.BLACK){
				blackCount++;
			}else if(buttons[i].getBackground() == Color.WHITE){
				whiteCount++;
			}
		}
		if(blackCount == 0){
			return WHITEWINS; 
		}
		if(whiteCount == 0){
			return BLACKWINS; 
		}
		boolean blackMove = false, whiteMove = false;
		if(aTurn){
			for(int i = 0; i < 64; i++){
				if(buttons[i].getBackground() == Color.BLUE){
					if(checkMove(i, Color.BLACK)){
						blackMove = true;
						break;
					}
				}
			}
		}
		
		if(!aTurn){
			for(int i = 0; i < 64; i++){
				if(buttons[i].getBackground() == Color.BLUE){
					if(checkMove(i, Color.WHITE)){
						whiteMove = true;
						break;
					}
				}
			}
		}
		if(!whiteMove && !blackMove){
			return DRAW;
		}
		if(!whiteMove){
			return BLACKWINS;
		}
		if(!blackMove){
			return WHITEWINS;
		}
		return INCOMPLETE;
	}
	
	public boolean checkMove(int ptr, Color currColor){
		int dirCt = 0;
		for(int i = 0; i < 8; i++){
			int temp = ptr;
			boolean encounter = false;
			temp += dirArr[i];
			int ct = 0;			
			while(buttons[temp].getBackground() != Color.BLUE && temp >= 0 && temp <= 64){
				if(buttons[temp].getBackground() == currColor){
					encounter = true;
					break;
				}else{
					temp += dirArr[i];
					ct++;
				}				 
			}
			if(ct > 0 && encounter){
				temp -= dirArr[i];
				while(temp != ptr){
					temp -= dirArr[i];
				}
				dirCt++;
			}
		}
		if(dirCt > 0){
			return true;
		}
		return false;
	}


}
