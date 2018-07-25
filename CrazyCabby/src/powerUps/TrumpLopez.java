package powerUps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;

import javax.swing.Timer;

import main.Gui;

public class TrumpLopez implements Power , ActionListener {
	private Gui g ;
	private Timer t;
	
	public TrumpLopez(Gui g) {
		this.g = g;
		t= new Timer(10000,this);
		
	}
	@Override
	public Power power() {
		// TODO Auto-generated method stub
		for(int x = 0 ; x<g.bots.size();x++) {
			g.bots.get(x).setHeight(100);
			g.bots.get(x).setWidth(100);
		}
		g.getPlayer().setHeight(100);
		g.getPlayer().setWidth(100);
		
		g.bots.add(g.makeSnake());
		
		t.start();
		return this;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int x = 0 ; x<g.bots.size();x++) {
			g.bots.get(x).setHeight(50);
			g.bots.get(x).setWidth(50);
		}
		g.getPlayer().setHeight(50);
		g.getPlayer().setWidth(50);
		g.setCurrentPower(null);	
		
		t.stop();		
	}
	public String toString() {
		return "TrumpLopez";
	}
}
