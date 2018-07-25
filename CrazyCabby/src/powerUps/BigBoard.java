package powerUps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import main.Gui;

public class BigBoard implements Power {
	private Gui g;
		
	public BigBoard(Gui g) {
		this.g= g;
	
	}
	
	@Override
	public Power power() {
		// TODO Auto-generated method stub
		
		g.bots.add(g.makeSnake());
		
		return this;
	}
	public String toString() {
		return "BigBoard";
	}

}
