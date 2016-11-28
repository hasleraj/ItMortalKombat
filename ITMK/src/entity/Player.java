/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import gfx.Animation;
import gfx.Assets;
import itmk.Controller;
import itmk.Game;
import itmk.ID;
import java.awt.Color;
import java.awt.Graphics;
import tile.Tile;


public class Player extends Entity {

    // ------------------------------RYU Animations
    private Animation ryu_AnimateStand, ryu_animateMove, ryu_animateJab, ryu_animateHighKick, ryu_animateCross, ryu_animateRoundHouse;
    //Attack Timer 
    private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
    private boolean facingRight = true;
    private boolean modifier = false; 

	public Player(int x, int y, int width, int height, boolean solid, ID id,
			Controller controller) {
		super(x, y, width, height, solid, id, controller);
		
                // Ryu Animation Constructors
		ryu_AnimateStand = new Animation(150, Assets.ryu_standing);
		ryu_animateMove = new Animation(250, Assets.ryu_move);
		ryu_animateJab = new Animation(100, Assets.ryu_jab);
		ryu_animateHighKick = new Animation(125, Assets.ryu_highKick);
		ryu_animateCross = new Animation(100, Assets.ryu_cross);
		ryu_animateRoundHouse = new Animation(150, Assets.ryu_roundHouse);
                
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		if(x<=0) x = 0;
		if(x+width>=1080) x = 1080 - width;
		if(y+height>=771) y = 771 - height;
		for(Tile t: controller.tile){
			if(!t.solid) break;
			if(t.getId()==ID.wall){
				if(getBoundsTop().intersects(t.getBounds())){
					setVelY(0);
					if(jumping) {
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
					//y = t.getX()+t.height;
				}
				if(getBoundsBottom().intersects(t.getBounds())){
					setVelY(0);
					if(falling) falling = false;
					//y = t.getX()-t.height;
				}else {
					if(!falling && !jumping){
						gravity = 0.0;
						falling = true;
					}
				}
				if(getBoundsLeft().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()+t.width;
				}
				if(getBoundsRight().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()-t.width;
				}
			}
		}
		
		if(jumping){
			gravity -= 0.1;
			setVelY((int)-gravity);
			if (gravity <= 0.0){
				jumping = false;
				falling = true;
			}
		}
		if(falling){
			gravity += 0.1;
			setVelY((int)gravity);
		}
	}
	
	@Override
	public void render(Graphics g) {
		//g.drawImage(Game.player.getBufferedImage(), x, y, width, height, null);
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}
