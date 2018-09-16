package tanvir;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import TicTacToe.GUI_TicTacToe;

public class GUI_ConnectFour extends JFrame implements ActionListener, ConnectFourInterface {
	private static final JButton EMPTY = null;
	private JPanel jpMain;
	private JPanel jpBoard;
	private JPanel jpIO;
	private JLabel displayOut;
	private JButton [][] board;
	private String currPlayer = "X";
	
	public GUI_ConnectFour(){
		this.setTitle("Connect Four");
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		jpIO = new JPanel();
		displayOut = new JLabel();
		updateOut("Let's play ! \'"+currPlayer+"\' goes first");
		jpIO.add(displayOut);
		jpMain.add(jpIO, BorderLayout.NORTH);
		
		jpBoard = new JPanel();
		jpBoard.setLayout(new GridLayout(6,7));
		displayBoard();

		jpMain.add(jpBoard, BorderLayout.CENTER);
		add(jpMain);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater( new Runnable(){
			public void run() {
				GUI_ConnectFour gui = new GUI_ConnectFour();
			}	
		});
	}
	
	public void updateOut(String msg){
		if (currPlayer == "X"){
	    displayOut.setText("<HTML><H1 color=blue>"+msg+"</H1></HTML>");
		}
		else if(currPlayer == "O"){
		displayOut.setText("<HTML><H1 color=green>"+msg+"</H1></HTML>");
		}
		else{
			System.out.println("NO");
		}
	}
		 
 


 
 
 

		 
		



	
	public void playAnotherGame(){
		int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to play another game?");
		if(yesNo == 0){
			clearBoard();
			updateOut(currPlayer+" goes first!");
		}
		else{
			updateOut("Thanks for playing");
			JOptionPane.showMessageDialog(null, "BYE");
			System.exit(EXIT_ON_CLOSE);
		}
		System.out.println(yesNo);
	}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		btnClicked.setText(currPlayer);
		btnClicked.setEnabled(false);
		if(currPlayer == "X"){
			btnClicked.setBackground(Color.BLUE);
		}
		else if(currPlayer == "O"){
			btnClicked.setBackground(Color.GREEN);
		}
		else{
			System.out.println("NO");
		}
		if(isWinner(currPlayer) || isFull()){
			displayWinner();
			playAnotherGame();
		}
		updateCurrPlayer();
		updateOut(currPlayer + " goes now");
		
	}
	
	@Override
	public void displayBoard() {
		board = new JButton[6][7];
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				board[row][col] = new JButton();
				board[row][col].setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
				board[row][col].addActionListener(this);
				board[row][col].setEnabled(true);
				jpBoard.add(board[row][col]);
			}
		}
	}
	
	@Override
	public void clearBoard() {
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				board[row][col].setText("");
				board[row][col].setEnabled(true);
				board[row][col].setBackground(null);
			}
		}
		
	}
	@Override
	public void displayWinner() {
		if(this.isWinner("X")){
			updateOut("X is the winner");
		}
		else if(this.isWinner("O")){
			updateOut("O is the winner");
		}
		else{
			updateOut("DRAW!!!");
		}
	}
	
	public boolean isWinner(String player) {
		//check rows
		for(int row=0; row<board.length;row++){
			int rowCount=0;//row match counter, resets on next row
			for(int col=0; col<board[row].length; col++){
				if(board[row][col].getText().contains(player)){
					rowCount++;//increment counter
					if(rowCount == 4){
						return true;//found 4 in same row
					}
				
				}
			
			}
			
		}
		
		//check columns
		for(int col=0; col<7; col++){
			int colCount=0;
			for(int row=0; row<6; row++){
				if(board[row][col].getText().contains(player)){
					colCount++;
					if(colCount ==4){
						return true;
					}
				}
			}
		}
		
		
		//check main diagonal [0][0],[1][1],[2][2],[3][3],[4][4],[5][5]
		int diagCount=0;
		int row=0;
		int col = 0;
		while(row <=5 && col<=5){
			if(board[row][col].getText().contains(player)){
				diagCount++;
				if(diagCount ==4){
					return true;//found 3 same across secondary diagonal
				}
			}
			row++;
			col++;
		}
		
		
		
		
		
		
		
		//check secondary diagonal [5][0],[4][1],[3][2],[2][3],[1][4],[0][5]
		int diag2Count=0;
		int row1=5;
		int col1 = 0;
		while(row1 >=0 && col1<=5){
			if(board[row1][col1].getText().contains(player)){
				diag2Count++;
				if(diag2Count ==4){
					return true;//found 3 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}
		
		
	
		
		//new code for the bottom right diagonal [5][6],[4]5],[3][4],[2][3],[1][2],[0][1]
		int diag3count = 0;
		row1 = 0;
		col1 = 1;		
		while(row1 <= 5 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag3count++;
			if(diag3count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1++;
			col1++;
		}
		
		 //[0][2],[1][3],[2][4],[3][5],[4][6]
		int diag4count = 0;
		row1 = 0;
		col1 = 2;		
		while(row1 <=5 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag4count++;
			if(diag4count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1++;
			col1++;
		}
		
		//[3][6],[2][5],[1][4],[0][3]
		int diag5count = 0;
		row1 = 0;
		col1 = 3;		
		while(row1 <=3 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag5count++;
			if(diag5count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1++;
			col1++;
		}
		
		//[5][2],[4][3],[3][4],[2][5],[1][6]
		int diag6count = 0;
		row1 = board.length-1;
		col1 = 2;		
		while(row1 <=1 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag6count++;
			if(diag6count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}
		
		
		int diag7count = 0;
		row1 = board.length-1;
		col1 = 3;		
		while(row1 <=2 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag7count++;
			if(diag7count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}
		int diag8count = 0;
		row1 = board.length-3;
		col1 = 0;		
		while(row1 >=0 && col1<=3){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag8count++;
			if(diag8count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}
		int diag9count = 0;
		row1 = board.length-2;
		col1 = 0;		
		while(row1 >=0 && col1<=4){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag9count++;
			if(diag9count ==4){
				return true;//found 4 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}
		
		int diag10count = 0;
		row1 = board.length-1;
		col1 = 1;		
		while(row1 >=0 && col1<=6){
			
			if(board[row1][col1].getText().contains(player)){
				
				diag10count++;
			if(diag10count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1--;
			col1++;
		}	
		int diag11count = 0;
		row1 = 1;
		col1 = 0;		
		while(row1 <=5 && col1<=4){
			
			if(board[row1][col1].getText().contains(player) ){
				
				diag11count++;
			if(diag11count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1++;
			col1++;
			
			}
		
		int diag13count = 0;
		row1 = board.length-4;
		col1 = 0;		
		while(row1 <=5 && col1<=3){
			
			if(board[row1][col1].getText().contains(currPlayer)){
				
				diag13count++;
			if(diag13count ==4){
				return true;//found 3 same across secondary diagonal
				}
			}
			row1++;
			col1++;
		}
		
		return false;
	}
	
	        	   
		

	@Override
	public void takeATurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCurrPlayer() {
		if(currPlayer.equalsIgnoreCase("X")){
			currPlayer = "O";
		}
		else{
			currPlayer = "X";
		}
	
}
		// TODO Auto-generated method stub
		
	

	@Override
	public boolean isFull() {
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){
				String text = board[row][col].getText();
				if( !(text.contains("X")) && !(text.contains("O")) ){
					return false;
				}
			}
		}
		return true;
	}
}

