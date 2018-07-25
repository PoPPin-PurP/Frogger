package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import players.User;

public class Move2 implements KeyListener {
	private User player;
	private int buffHoro = 100;
	private int height = 1050;
	private int speed = 20;
	
	

	public Move2(User u) {
		player = u;
		
	
	}
	
	

	@Override
	public void keyPressed(KeyEvent k) {
		int code = k.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT ){
			
				player.setVelX(-speed);
				
			
			
		}
		
			if(code == KeyEvent.VK_RIGHT) {
			

					player.setVelX(speed);
					
			
		
		}
		 if(code == KeyEvent.VK_UP) {

				
					player.setVelY(-speed);
					
		}
		 if(code == KeyEvent.VK_DOWN) {
			
				player.setVelY(speed);
				
			
	
		}
	
				
				
			
		
		
	}
	

	@Override
	public void keyReleased(KeyEvent k) {
		int code = k.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			player.setVelX(0);
			
			
		}
		
			if(code == KeyEvent.VK_RIGHT) {
				player.setVelX(0);
			
		
		}
		 if(code == KeyEvent.VK_UP) {
			player.setVelY(0);
		}
		 if(code == KeyEvent.VK_DOWN) {
			player.setVelY(0);
	
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
public void setSpeed(int speed) {
	this.speed=speed;
}
public int getSpeed() {
	return speed;
}
public void setBuff(int buff) {
	this.buffHoro = buff;
}
}
