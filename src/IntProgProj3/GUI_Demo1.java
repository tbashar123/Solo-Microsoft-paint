package IntProgProj3;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import javax.security.auth.kerberos.KeyTab;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import IntProgProj1.Illustrating;


public class GUI_Demo1 extends JFrame implements ActionListener, MouseMotionListener, MouseListener{

    TypingAndIllustrating2 draw;
	Illustrating2 write;
	JPanel mainContent ;
	JPanel westPanel;
	protected boolean mouseIsPressed;
	protected int lastX;
	protected int lastY;
	private Font font;
	private FontMetrics fm;
	//HeartShape h;
	
	
	public GUI_Demo1(){
		lastX = 0;
		lastY = 0;
		mouseIsPressed = false;
			JButton b1 = new JButton("Clear");
			b1.addActionListener(this);
			JButton b2 = new JButton("Color");
			b2.addActionListener(this);
			JButton b3 = new JButton("Eraser");
			b3.addActionListener(this);
			JButton b4 = new JButton("small Circle");
			b4.addActionListener(this);
			JButton b5 = new JButton("Big Circle");
			b5.addActionListener(this);
			JButton b6 = new JButton("small Rect");
			b6.addActionListener(this);
			JButton b7 = new JButton("Big Rect");
			b7.addActionListener(this);
			JButton b8 = new JButton("Line");
			b8.addActionListener(this);
			JButton b9 = new JButton("small Arc");
			b9.addActionListener(this);
			JButton b10 = new JButton("Big Arc");
			b10.addActionListener(this);
			JButton b11 = new JButton("Pencil");
			b11.addActionListener(this);
			JButton b12 = new JButton("Big Text");
			b12.addActionListener(this);

	        add(b1);
	        add(b2);
	        add(b3);
	        add(b4);
	        add(b5);
	        add(b6);
	        add(b7);
	        add(b8);
	        add(b9);
	        add(b10);
	        add(b11);
	        add(b12);
			addMouseListener(this);
			addMouseMotionListener(this);
		
	
		 
		mainContent = new JPanel();
		mainContent.setLayout(new BorderLayout());
		westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3,2));
		
		//North JColorChooser
        write = new Illustrating2();
		draw = new TypingAndIllustrating2();
		//h = new HeartShape();
		//East & West controls
		//South also add your JPanel with components
		
		
	    
	    
	   mainContent.add(draw, BorderLayout.CENTER);
		westPanel.add(b1);
		westPanel.add(b2);
		westPanel.add(b3);
		westPanel.add(b4);
		westPanel.add(b5);
		westPanel.add(b6);
		westPanel.add(b7);
		westPanel.add(b8);
		westPanel.add(b9);
		westPanel.add(b10);
		westPanel.add(b11);
		westPanel.add(b12);
		mainContent.add(write, BorderLayout.NORTH);
		mainContent.add(westPanel, BorderLayout.WEST);
		
		
		add(mainContent);
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

		
	public void clear(JPanel mainContent){
				mainContent.setBackground(null);
				mainContent.setBackground(Color.WHITE);
	
	}
	public void erase(JPanel mainContent){
		
	}
	
				
	@Override 	
	public void actionPerformed(ActionEvent e) {
			
			
		
			if(e.getActionCommand().equals("Color")){
				Color bgColor = JColorChooser.showDialog(this, "choose the pigment", getBackground());
				//setBackground(bgColor);
				draw.lineColor = bgColor;
				draw.keyColor = bgColor;
		    
		   
				
		}
		
		
			
		
		
		if(e.getActionCommand().equals("Clear")){
			int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear everything");
			if(yesno == 0){
				clear(mainContent);
			}
		}
		if(e.getActionCommand().equals("Eraser")){
			Illustrating2.smallRectOn = false;
			Illustrating2.smallCircleOn = true;
			Illustrating2.LineOn = false;
			Illustrating2.smallArcOn = false;
			Illustrating2.bigRectOn = false;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.pencilOn = false;
		}
		
		
		
		 if(e.getActionCommand().equals("small Rect")){
			Illustrating2.smallRectOn = true;
			Illustrating2.smallCircleOn = false;
			Illustrating2.LineOn = false;
			Illustrating2.smallArcOn = false;
			Illustrating2.bigRectOn = false;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.pencilOn = false;

		}
		 
		if(e.getActionCommand().equals("small Circle")) {
			Illustrating2.smallCircleOn = true;
			Illustrating2.LineOn = false;
			Illustrating2.smallRectOn = false;
			Illustrating2.smallArcOn = false;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigRectOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.pencilOn = false;
		}
		if(e.getActionCommand().equals("small Arc")){
			Illustrating2.smallArcOn = true;
			Illustrating2.smallCircleOn = false;
			Illustrating2.LineOn = false;
			Illustrating2.smallRectOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigRectOn = false;
			Illustrating2.pencilOn = false;
			
		}
		if(e.getActionCommand().equals("Big Rect")){
			Illustrating2.smallArcOn = false;
			Illustrating2.smallCircleOn = false;
			Illustrating2.LineOn = false;
			Illustrating2.smallRectOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigRectOn = true;
			Illustrating2.pencilOn = false;
		}
		if(e.getActionCommand().equals("Big Circle")){
			Illustrating2.smallArcOn = false;
			Illustrating2.smallCircleOn = false;
			Illustrating2.LineOn = false;
			Illustrating2.smallRectOn = false;
			Illustrating2.bigArcOn = false;
			Illustrating2.bigCircleOn = true;
			Illustrating2.bigRectOn = false;
			Illustrating2.pencilOn = false;
		}
		if(e.getActionCommand().equals("Big Arc")){
			Illustrating2.smallArcOn = false;
			Illustrating2.smallCircleOn = false;
			Illustrating2.LineOn = false;
			Illustrating2.smallRectOn = false;
			Illustrating2.bigArcOn = true;
			Illustrating2.bigCircleOn = false;
			Illustrating2.bigRectOn = false;
			Illustrating2.pencilOn = false;
		}
	     if(e.getActionCommand().equals("Line")){
	    	 Illustrating2.smallArcOn = false;
				Illustrating2.smallCircleOn = false;
				Illustrating2.LineOn = true;
				Illustrating2.smallRectOn = false;
				Illustrating2.bigArcOn = false;
				Illustrating2.bigCircleOn = false;
				Illustrating2.bigRectOn = false;
				Illustrating2.pencilOn = false;
			
	           
		}
	     
	     if(e.getActionCommand().equals("Pencil")){
	    	 Illustrating2.smallArcOn = false;
				Illustrating2.smallCircleOn = false;
				Illustrating2.LineOn = false;
				Illustrating2.smallRectOn = false;
				Illustrating2.bigArcOn = false;
				Illustrating2.bigCircleOn = false;
				Illustrating2.bigRectOn = false;
				Illustrating2.pencilOn = true;
		    	 
			 
				
		           
			}
	     
	    
		}
	 
			
			
			
			
			
	
		
		
		// TODO Auto-generated method stub
		
	


	



	public static void main(String[] args) {
		System.out.println("Will create the gui now");
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				GUI_Demo1 gui = new GUI_Demo1();
				
			}
		});

		System.out.println("Done with the gui now");
	}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent e) {

	
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
	
	


