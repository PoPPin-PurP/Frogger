package players;

public class User {
	private int height;
	private int width ;
	private int x;
	private int y;
	private int velX=0;
	private int velY=0;
	private String team;
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public User(int x , int y) {
		height = 50;
		width = 50;
		this.x = x;
		this.y =y;
		
		
	}
		
	public void tick() {
		x+=velX;
		y+=velY;
	}

	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
