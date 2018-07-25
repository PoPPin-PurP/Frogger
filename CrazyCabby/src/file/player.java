package file;

public class player {
	/**
	 * Class holds the name and score of players
	 */
	private String name;
	private int score;
	public player(String name, int score) {
		this.name = name;
		this.score =score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
