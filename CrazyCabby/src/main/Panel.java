package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JFrame {
	private JPanel j = new JPanel();
	private KeyListener k;
public Panel(){
	
	this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	//this.setUndecorated(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("Cage MAtch");
	this.getContentPane().setBackground(Color.BLACK);
	this.setLocationRelativeTo(null);
	makeMenu();
	this.addKeyListener(k =new MenuListener(this));
	
	this.setVisible(true);
	
	
}
public void makeMenu() {
	JLabel Title = new JLabel();
	ArrayList<BufferedImage> image = new ArrayList<BufferedImage>();
	j.setBackground(Color.WHITE);
	
	//this.setFocusable(true);
	BufferedImage ronaldo = null;
	BufferedImage piccolo = null;
	BufferedImage meme = null;
	BufferedImage oldman = null;
	j.setLayout(new BoxLayout(j,BoxLayout.Y_AXIS));
	Title.setText("Bamp Sienna's Great Adventure");
	Title.setForeground(Color.BLUE);
	Title.setFont(new Font("Arial", Font.BOLD, 100));
	j.add(Title);
	try {
		piccolo = ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/piccolo.png"));
		 ronaldo = ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/Ronaldini.jpg"));
		 meme =ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/crainum.jpg"));
		 oldman = ImageIO.read(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/oldman.jpg"));
		 image.add(meme);
		 image.add(oldman);
		 image.add(piccolo);
		 image.add(ronaldo);
		 Collections.shuffle(image);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		j.add(new JLabel(new ImageIcon(image.get(0))));
	
	
	this.setFocusable(true);
	
	this.add(j);
}
public void start1() {
	
	this.remove(j);
	this.removeKeyListener(k);
	Gui g = new Gui(true);
	this.add(g);
	this.pack();
	this.revalidate();
	
	
}
public void start2() {
	this.remove(j);
	this.removeKeyListener(k);
	Gui g =new Gui(false);
	this.add(g);
	this.pack();
	this.revalidate();
}
}

