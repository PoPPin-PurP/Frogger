package powerUps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import main.Gui;

public class SmallBoarder implements Power ,  ActionListener{
	private Gui g ;
	private Timer t;
	public SmallBoarder(Gui g) {
		this.g = g;
		t= new Timer(4000,this);
		
	}
	@Override
	public Power power() {
		// TODO Auto-generated method stub
		
			g.bots.add(g.makeSnake());
			g.moo.setSpeed(45);
			
		t.start();
		
		return this;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		g.moo.setSpeed(25);
		t.stop();		
	}
	public String toString() {
		return "SmallBoarder";
	}
}
