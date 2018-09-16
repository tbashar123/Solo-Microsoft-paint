package IntProgProj3;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TypingAndIllustrating2 extends Illustrating2 implements KeyListener{

	private Font font;
	private FontMetrics fm;
	private int text_start_x;
	
	
	public TypingAndIllustrating2(){
		super();//call parent constructor
		//setBackground(Color.RED);
		font = new Font("Serif", Font.BOLD, 25);//default size;
		fm = getFontMetrics(font);//want to be able to measure my String to draw
		addKeyListener(this);
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		
		String s = String.valueOf(e.getKeyChar());
		if(!mouseIsPressed){
			Graphics g = getGraphics();
			g.setFont(new Font("Serif",-Font.BOLD,Illustrating2.size));
			g.setColor(lineColor);
			lastX += fm.stringWidth(s+10); //increase x by width to move next char over
			g.drawString(s, lastX, lastY);
			//going to write all the chars we type on top of each other
			g.dispose();
			
		}
		System.out.println("In key typed "+ s);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

