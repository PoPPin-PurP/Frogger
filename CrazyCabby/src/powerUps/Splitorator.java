package powerUps;

import java.util.Random;

import main.Gui;
import players.Log;
/**
 * This class is a special powerup that scatters 
 * bots to the outskirts of BuffHoro
 * @author jwax
 *
 */
public class Splitorator implements Power {
	private Gui g ;
	public Splitorator(Gui g) {
		this.g=g;
	}
	@Override
	public Power power() {
		// TODO Auto-generated method stub
		
		for(Log l : g.bots) {
			Random r = new Random();
			int temp = r.nextInt(100);
			
			if(temp%4==0) {
				l.setY(temp);
				l.setX(0);
			}
			if(temp%4==1) {
				l.setY(temp);
				l.setX(g.getWidth());
			}
			if(temp%4==2) {
				l.setX(0);
				l.setY(g.getHeight());
			}
			if(temp%4==3) {
				l.setY(g.getHeight()-g.getBuffHoro()+temp);
				l.setX(g.getWidth());
			}
		}
		g.bots.add(g.makeSnake());
		
		
		return this;
	}
	public String toString() {
		return "Splitorator";
	}
}
