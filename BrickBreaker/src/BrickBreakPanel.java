import java.awt.Container;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;


public class BrickBreakPanel extends JPanel implements KeyListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Brick> bricks=new ArrayList<Brick>();
	ArrayList<Brick> ball=new ArrayList<Brick>();
	PlaySound Crash=new PlaySound("sound//click.mp3");
	
	  Counter c1=new Counter();
	  JFrame jfrm=new JFrame("Brick Breaker");
	
	
	int size=25;
	Brick paddle;
	Thread thread;
	Animate animate;
	
	

	
	
	 BrickBreakPanel() {
		
		init();
	
	}
	
public void init()
{
	paddle=new Brick(175,480,150,25,"images/black.png");
	for(int i=0;i<8;i++)
	{
		bricks.add(new Brick((i*60+2), 25, 60, 25, "images/blue.png"));
	}
	for(int i=0;i<8;i++)
	{
		bricks.add(new Brick((i*60+2), 50, 60, 25, "images/red.png"));
	}
	for(int i=0;i<8;i++)
	{
		bricks.add(new Brick((i*60+2), 75, 60, 25, "images/green.png"));
	}
	for(int i=0;i<8;i++)
	{
		bricks.add(new Brick((i*60+2), 100, 60, 25, "images/yellow.png"));
	}
	
	
	
	ball.add(new Brick(237,437,25,25,"images/ball.png"));
	addKeyListener(this);
	setFocusable(true);
	
	
	
	
	
}
public void NewGame()
{
	
	
	BrickBreakPanel Bpanel=new BrickBreakPanel();
    jfrm.getContentPane().add(Bpanel);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setVisible(true);
    jfrm.setSize(490,600);
 
     
}



	 public void paintComponent(Graphics g)

	{
		super.paintComponent(g);
		for(Brick b :bricks)
		b.draw(g, this);
		for(Brick b :ball)
			b.draw(g, this);
		paddle.draw(g, this);
	}
	
	
	
 	public void update() throws FileNotFoundException, JavaLayerException
	{
		for(Brick ba:ball)
		{
			ba.x+=ba.dx;
			if(ba.x>(getWidth()-size)&&ba.dx>0||ba.x<0)
				ba.dx*=-1;
			
			if(ba.y<0||ba.intersects(paddle))
				ba.dy*=-1;
			
			ba.y+=ba.dy;
			
			
			for(Brick b:bricks)
			{
				if(ba.intersects(b)&&!b.destroyed)
				{ 
					 
					b.destroyed=true;
					
					ba.dy*=-1;
					
					Crash.CrashSound();
					c1.decrement();
					
					if(c1.getNum()==0)
					{
					     JOptionPane.showMessageDialog(null, "Tebrikler ! Tüm kutularý kýrdýnýz ! Yeni oyun baþlatýlacaktýr.");
					     //Yöntem 1 || NewGame(); // Yeni frame oluþurken eski frameýn kaybolmama sorunu
					     //Yöntem 2 || buda olmadý
					     /*  jfrm.getContentPane().removeAll();
					       init();
					      break;*/
					 
						}
				}
				
				//topu tutamadýðýnda kaybetmiþ olunuyor.
				// bunu döngüden kurtarman gerek
				//Kýsmen çözüldü. olmadý oyun baþlatýlmadý
				//Oyunu tekrar baþlatmak lazým
			/*
				if((ba.y-paddle.y)==5)
				{
				     JOptionPane.showMessageDialog(null, "Kaybettiniz :(");
				     jfrm.getContentPane().removeAll();
				     init();
				     break;
				       
				}
				*/
			}
		}
		repaint();
	}



	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			animate=new Animate(this);
			thread=new Thread(animate);
			thread.start();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT&&paddle.x>0){
			paddle.x-=15;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT&&paddle.x<(getWidth()-paddle.width)){
			paddle.x+=15;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		
	}

	public void keyTyped(KeyEvent e) {
	
		
	}
	
	

}
