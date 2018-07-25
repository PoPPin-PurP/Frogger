package players;



public class Log  {
private int x , y , height, width ;
private int velX;
private int velY;
private int speed; //Used when wanting to change direction of travel

	public Log(int x ,int y , int height, int width, int speed) {
		this.x = x ;
		this.y = y;
		this.height =height;
		this.width = width;
		this.speed = speed;
	}
	
	
	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	public void tick() {
		x+=velX;
		y+=velY;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	
	
	
}
