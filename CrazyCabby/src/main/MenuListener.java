package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuListener implements KeyListener{
	private Panel p ;

	public MenuListener(Panel p) {
		this.p = p;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_1) {
			p.start1();
		}
		if(arg0.getKeyCode() == KeyEvent.VK_2) {
			p.start2();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		

}
}