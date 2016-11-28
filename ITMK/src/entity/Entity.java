
package entity;

import itmk.Controller;
import itmk.ID;
import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class Entity {
	
	public int x, y;
	public int width, height;
	public int velX, velY;
        
        protected float speed;
	protected float xMove, yMove;
	
	public boolean jumping = false;
	public boolean falling = true;
	
	public double gravity = 0.0;

	public boolean solid;
	
	public ID id;
	
	public Controller controller;
	
	public Entity(int x, int y, int width, int height, boolean solid, ID id, Controller controller){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.id = id;
		this.controller = controller;
		
	}
	
	public abstract void render(Graphics g);
	
	public abstract void tick();


	public void die(){
		controller.removeEntity(this);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(getX(),getY(),width,height);
	}
	 
	public Rectangle getBoundsTop(){
		return new Rectangle(getX()+10,getY(),width-20, 5);
	}
	
	public Rectangle getBoundsBottom(){
		return new Rectangle(getX()+10,getY()+height-5,width-20, 5);
	}
	
	public Rectangle getBoundsLeft(){
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsRight(){
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}
	
	// --------------------------- Getters and Setters
	
	public ID getId(){
		return id;
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public boolean isSolid() {
		return solid;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

//	public void setSolid(boolean solid) {
//		this.solid = solid;
//	}
	
	//--------------------------------------------------
	
}
