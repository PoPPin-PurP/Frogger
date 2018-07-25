package file;

import java.util.Comparator;

public class Sort implements Comparator<player>{
/**
 * Used to Sort scores from greatest to least
 */
	

	@Override
	public int compare(player o1, player o2) {
		// TODO Auto-generated method stub
		if(o1.getScore()>o2.getScore()) {
			return -4;
		}
		if(o1.getScore()<o2.getScore()) {
			return 4;
		}
		return 0;
	}

}
