package IntProgProj3;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.BasicStroke;
import javax.swing.JPanel;

public class Illustrating2 extends JPanel implements MouseListener, MouseMotionListener{
	
	public static int flourish = 0;
	public static int eraser = 0;
	protected int lastX;
	protected int lastY;
	protected boolean mouseIsPressed;
	protected Color lineColor;
	protected Color keyColor;
	protected String shapeType;
	protected static boolean shapeOn;
	
	public static int eraserWidth;
	public static int eraserHeight;
	public static int size;
	 public static int stroke;
	//static for now.. but remember that shares the variable among all instances
	//make sure to change the shapeOn to non-static... also think about
	//how you will access and change the values of these variables from your controls
	protected int diameter;
	static boolean smallRectOn;
	static boolean smallCircleOn;
	static boolean smallArcOn;
	static boolean bigRectOn;
	static boolean bigCircleOn;
	static boolean bigArcOn;
	static boolean LineOn;
	static boolean pencilOn;
	
	public Illustrating2(){
		stroke = 0;
		lastX = 0;
		lastY = 0;
		eraserWidth = 50;
		eraserHeight = 50;
		diameter = 30;
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(500, 500);
		setBackground(Color.WHITE);
		mouseIsPressed =false;
		size = 50;
		 
		//lineColor = Color.black;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(smallRectOn == true){//use the variable to determine if we'll draw a shape
			Graphics g = getGraphics();
			drawsmallRect(g);
		}
		if(smallCircleOn == true){
			Graphics g = getGraphics();
			drawsmallCircle(g);
		}
		if(smallArcOn == true){
			Graphics g = getGraphics();
			drawsmallArc(g);
		}
		if(bigRectOn == true){
			Graphics g = getGraphics();
			drawBigRect(g);
		}
		if(bigCircleOn == true){
			Graphics g = getGraphics();
			drawBigCircle(g);
		}
		if(bigArcOn == true){
			Graphics g = getGraphics();
			drawBigArc(g);
		}
		if(LineOn == true){
			Graphics g = getGraphics();
	 		drawLine(g);
		}
	}
	
		 

	
	private void drawsmallRect(Graphics g){
		g.setColor(lineColor);
		 g.drawRect(lastX - 10, lastY - 10, 30, 50);
		 
		 
	}
	private void drawsmallCircle(Graphics g){
		g.setColor(lineColor);
		g.drawOval(lastX - 20, lastY - 20 , 40, 40);
		
		
	}
	
    private void drawsmallArc(Graphics g) {
    	g.setColor(lineColor);
    	g.drawArc(lastX - 20, lastY - 20, diameter, diameter, 250, 130);
		
		
		
	}
    private void drawBigRect(Graphics g){
    	g.setColor(lineColor);
    	g.drawRect(lastX - 5, lastY - 5, 60, 100);
    	
    }
    private void drawBigCircle(Graphics g){
    	g.setColor(lineColor);
    	g.drawOval(lastX - 10, lastY - 10, 80, 80);
    }
    private void drawBigArc(Graphics g){
    	g.setColor(lineColor);
    	g.drawArc(lastX - 5, lastY - 5, diameter, diameter, 350, 400);
    }
    private void drawLine(Graphics g){
    	g.setColor(lineColor);
    	g.drawLine(lastX, lastY, 70, 110);
    	
    	
    }
	
		
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseIsPressed = true;
		record(e.getX(), e.getY());
		//Graphics g = getGraphics();
		//g.drawOval(lastX - 10, lastY - 10, 20, 20);
		
		
		//g.dispose();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseIsPressed = false;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		g.setColor(lineColor);
		g.drawLine(lastX, lastY, x, y);
		record(x, y);
		g.dispose();

		System.out.println("Released AT: "+x+","+y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();//request the focus on the jpanel when the mouse enters
		record(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(smallCircleOn == true){
			Graphics g = getGraphics();
			g.setColor(Color.WHITE);
			g.drawOval(lastX - 20, lastY - 20 , 40, 40);
		}
		
		
		
		
		
		
		if(pencilOn == true){
		mouseIsPressed = true;
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(lineColor);
		g2d.drawLine(lastX, lastY, x, y);
	//	g.drawLine(10, 10, 100, 100);
		record(x,y);
		System.out.println("Dragged AT: "+x+","+y);
		g.dispose();
		}
		
		
		
		
		
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
