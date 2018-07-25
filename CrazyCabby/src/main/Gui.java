package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import file.Reader;
import players.Log;
import players.User;
import powerUps.BigBoard;
import powerUps.Power;
import powerUps.SmallBoarder;
import powerUps.Splitorator;
import powerUps.TrumpLopez;
public class Gui extends JPanel implements ActionListener{
	
	private User player;
	private User player2;
	public ArrayList<Log> bots;
	public ArrayList<Log> bots2;
	public Move moo;
	private boolean run ;
	private Timer t;
	private Timer powerTime;
	private Log snake;
	
	private ArrayList<Power> power;
	private int x = 0;
	private BufferedImage trump = null;
	private BufferedImage lopez = null;
	private Power currentPower = null;
	private int score;
	private boolean mode;
	//if you change this then go to move class
	private  int height = 1050, width = 1850 ,buffHoro = 100, buffVert =3 , numBOt = 1;
	

	
	public Gui(boolean b) {
		mode = b;
		
		t = new Timer(60, this);
		score = 0;
		
		bots = new ArrayList<Log>();
		
		
		this.setSize(width,height);
		
		this.setLayout(new FlowLayout());
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setIgnoreRepaint(true);
		
		if(mode) {
			set1();
		}
		else {
			set2();
		}
		
		run = true;
		t.setCoalesce(true);
		t.start();
	
		powerTime = new Timer(7000, new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          //...Perform a task...
		    	  Random r = new Random();
		    	 x=3+r.nextInt(6);
		    	 
					buffVert = r.nextInt(width-(2*buffHoro)-player.getHeight());
		      }
						});
		
		powerTime.start();
		
		
	}
	
	public void set1() {
		player = new User(800,(height -2*buffHoro)/2);
		moo = new Move(player);
		makePower();
		this.addKeyListener(moo);
		snake = makeSnake();
		bots.add(snake);
		makeTrump();
	}
	public void set2() {
		player = new User(800,(height -2*buffHoro)/2);
		player.setTeam("Red");
		 player2 = new User(1000,(height -2*buffHoro)/2);
		 player2.setTeam("Blue");
		 bots2 = new ArrayList<Log>();
		 bots.add(makeSnake());
		 bots2.add(makeSnake());
		 this.addKeyListener(new Move(player));
		 this.addKeyListener(new Move2(player2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void makeTrump() {
		
		try {
			trump = ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/trump.png"));
			lopez = ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/lopez.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void paintPlayer(Graphics g) {
		
		
		g.drawImage(trump, player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);
		for(int x = 0 ; x<bots.size();x++) {
			g.drawImage(lopez, bots.get(x).getX(), bots.get(x).getY(), bots.get(x).getWidth(), bots.get(x).getHeight(), null);
		}
	}
	
	
	
	
	
	
	
	
	
	public Log makeSnake() {
		Random r = new Random();
		int rando = r.nextInt(100);
		
		if(rando%3==0) {
		return new Log(0,(height -2*buffHoro)/2,50,50,4+(int)(Math.random()*1));
		}
		if(rando%3==1) {
		return new Log(width,(height -2*buffHoro)/2,50,50,4+(int)(Math.random()*1) );
		}
		return new Log(width/2,buffHoro,50,50,15+(int)(Math.random()*1) );
	}
	public int calcX(int x, User player, ArrayList<Log>bots) {
		return player.getX()-bots.get(x).getX();
	}
	public int calcY(int x, User player, ArrayList<Log>bots) {
		return player.getY()-bots.get(x).getY();
	}
	public double Pythag(int x ,User u, ArrayList<Log>bots) {
		double distance = ((Math.pow(calcX(x,u,bots), 2)+Math.pow(calcY(x,u,bots), 2)));
		return  Math.sqrt(distance);
	}
		public int SpedX(int x ,User u ,ArrayList<Log>bots) {
		return (int)((calcX(x,u,bots)/Pythag(x,u,bots))*bots.get(x).getSpeed());
	}
	public int SpedY(int x, User u ,ArrayList<Log>bots) {
		return (int)((calcY(x,u,bots)/Pythag(x ,u,bots))*bots.get(x).getSpeed());
	}
	public void moveSnK(int x,User u ,ArrayList<Log>bots) {
		bots.get(x).setVelY(SpedY(x,u,bots));
		bots.get(x).setVelX(SpedX(x,u,bots));
		bots.get(x).tick();
	
	}
	
	
	
	
	
	public void makePower() {
		power = new ArrayList<Power>();
		Power small = new SmallBoarder(this);
		Power big = new BigBoard(this);
		Power lopez = new TrumpLopez(this);
		Power jah = new Splitorator(this);
		power.add(small);
		power.add(big);
		
		power.add(lopez);
		
		power.add(jah);
	}
	public Power choosePower() {
		Random r = new Random();
		int rando =r.nextInt(100);
		rando = rando%power.size();
		return power.get(rando);
	}
	
	
	public void backGround(Graphics G) {
		//Paints the boarder  		
   		//Grass
   		G.setColor(Color.BLUE);
   		G.fillRect(0, 0 , width, buffHoro);
   		G.fillRect(0,0, buffHoro, width);
   		G.fillRect(0, height-buffHoro, width, buffHoro);
   		G.fillRect(width-buffHoro, 0, buffHoro, height);
   		//Draw Score
   		G.setColor(Color.DARK_GRAY);
		G.drawString("Score: "+score, 40, 40);
   		//Dotted lines
   		G.setColor(Color.WHITE);
   		for(int y = 2 ; y<16 ; y++) {
   		for(int x = 2 ; x<24 ;x++) {
   			if(50*y>buffHoro && 50*y<height-buffHoro) {
   		G.fillRect( 75*x,60*y , 20, 2);
   			}
   		}
   	}
	}
	
	
	
	public void paint(Graphics G) {
		if(score == 0) {
		this.setFocusable(true);
		this.requestFocus();
		}
		super.paint(G);
		
		
		   backGround(G);
		   		
					
		   		if(mode) {
		   			if(x > 0) {
						
			   			
						int vish = buffHoro*x;
						int vishx = buffVert+buffHoro;
						G.setColor(Color.WHITE);
						G.fillOval(vishx, vish, 50, 50);
						if(Math.abs(player.getX() - vishx)<=30 && Math.abs(player.getY()-vish)<=30) {
							x=0;
							score++;
						currentPower =	choosePower().power();
						}
						
			   		}	
		   			for(int x = 0 ; x<bots.size();x++) {
						moveSnK(x, player, bots);
						if(intersectBot(bots.get(x),player)) {
							t.stop();
						
							
						
						}
						}
		   			if(currentPower!=null&&currentPower.toString().equals("TrumpLopez")) {
		   				paintPlayer(G);
		   			
		   			
		   			}
		   			else {
		   				G.setColor(Color.CYAN);
		   				
		   				G.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		   				G.setColor(Color.RED );// TODO Auto-generated method stub
		   				for(int x = 0 ; x<bots.size();x++) {
		   				G.fillOval(bots.get(x).getX(), bots.get(x).getY(), bots.get(x).getWidth(), bots.get(x).getHeight());
		   				}
		   			}
		   			
		   		}
		   		else {
		   			if(x > 0) {
						
			   			
			   			
						int vish = buffHoro*x;
						int vishx = buffVert+buffHoro;
						G.setColor(Color.WHITE);
						G.fillOval(vishx, vish, 50, 50);
						if((Math.abs(player.getX() - vishx)<=30 && Math.abs(player.getY()-vish)<=30)) {
							
								bots2.add(makeSnake());
							
							x =0;
								
							
							
							
							
						}
						if((Math.abs(player2.getX() - vishx)<=30 && Math.abs(player2.getY()-vish)<=30)) {
							bots.add(makeSnake());
							x= 0;
						}
						
			   		}	
		   			for(int x = 0 ; x<bots.size();x++) {
						moveSnK(x, player, bots);
						if(intersectBot(bots.get(x),player)) {
							t.stop();
						
							
						
						}
						}
		   			for(int x = 0 ; x<bots2.size();x++) {
						moveSnK(x, player2, bots2);
						if(intersectBot(bots2.get(x),player2)) {
							t.stop();
						
							
						
						}
						}
		   			paintPP(G);
		   		}
		   		
		   		
					

		   
		
		
		
		
		
		
		
		
		
		

	}
	public void paintPP(Graphics G) {
		G.setColor(Color.CYAN);
			G.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			G.setColor(Color.RED);
			G.fillRect(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());
			G.setColor(Color.red);// TODO Auto-generated method stub
			for(int x = 0 ; x<bots.size();x++) {
			G.fillOval(bots.get(x).getX(), bots.get(x).getY(), bots.get(x).getWidth(), bots.get(x).getHeight());
			}
			G.setColor(Color.BLUE);
			for(int x = 0 ; x<bots2.size();x++) {
				G.fillOval(bots2.get(x).getX(), bots2.get(x).getY(), bots2.get(x).getWidth(), bots2.get(x).getHeight());
				}
		}
		
	
	
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getBuffHoro() {
		return buffHoro;
	}
	public void gameOver() {
		run = false;
		
	}
	public int randoMove() {
		Random r = new Random();
		int pick = r.nextInt(3);
		return pick;
	
	}
	
	public void makeEnd(User player) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(300, 300);
		if(mode) {
		Reader n = new Reader(p, score, f);
		p.setBackground(Color.lightGray);
		JLabel lose = new JLabel("You Lost, Try again Your Score was "+ score);
		p.add(lose);
		f.add(p);
		}
		else {
			JLabel lose = new JLabel(player.getTeam() + " Won!");	
			p.add(lose);
			f.add(p);
		}
		f.setMinimumSize(new Dimension(300,300));
		f.pack();
		f.setLocationRelativeTo(null);	
		f.setVisible(true);
	}
	public boolean intersectBot(Log a , User player) {
		if(player.getX()<buffHoro||player.getX()>(width-buffHoro-player.getHeight()/2)||player.getY()<buffHoro||player.getY()>(height-buffHoro-player.getHeight()/2)) {
			makeEnd(player);
			return true;
		}
			if(Math.abs(player.getX() - a.getX())<=30) {
				
				if(Math.abs(player.getY()-a.getY())<=30) {
					makeEnd(player);
					return true;
				}
			}
		
		return false;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mode) {
		player.tick();
		}
		else {
			player.tick();
			player2.tick();
		}
		repaint();
		
		//Add this and lag magically goes away 
		Toolkit.getDefaultToolkit().sync();
		
		
	
	}

	public void setBuff(int buff) {
		this.buffHoro =buff;
		moo.setBuff(buff);
	}
	public User getPlayer() {
		return player;
	}
	public void setPlayer(User player) {
		this.player = player;
	}
	public Power getCurrentPower() {
		return currentPower;
	}
	public void setCurrentPower(Power currentPower) {
		this.currentPower = currentPower;
	}
	
	}	

		





