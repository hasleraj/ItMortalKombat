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
import java.awt.image.BufferedImage;
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
		getInput();
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
		
                
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, width, height);
                
                if(!isFacingRight()){
			if(controller.getKeyManager().ryu_jab){
				g.drawImage(ryu_animateJab.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 100, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, - ((width * 2) + 25), height * 2, null);	
			}else if(controller.getKeyManager().ryu_highKick){
				g.drawImage(ryu_animateHighKick.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 100, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, - ((width * 2) + 28), height * 2, null);
			}else if(controller.getKeyManager().ryu_cross){
				g.drawImage(ryu_animateCross.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 100, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, - ((width * 2) + 30), height * 2, null);
			}else if(controller.getKeyManager().ryu_roundhouse){
				g.drawImage(ryu_animateRoundHouse.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 100, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, - ((width * 2) + 30), height * 2, null);
			}else{
				g.drawImage(getCurrentAnimationFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 100, 
					(int) (y - controller.getGameCamera().getyOffset()) - 10, - (width * 2), height * 2, null);
			}
		}else if(isFacingRight()){
			if(controller.getKeyManager().ryu_jab){
				g.drawImage(ryu_animateJab.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 10, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, ((width * 2) + 25), height * 2, null);
			}else if(controller.getKeyManager().ryu_highKick){
				g.drawImage(ryu_animateHighKick.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 10, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, ((width * 2) + 28), height * 2, null);	
			}else if(controller.getKeyManager().ryu_cross){
				g.drawImage(ryu_animateCross.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 10, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, ((width * 2) + 30), height * 2, null);
			}else if(controller.getKeyManager().ryu_roundhouse){
				g.drawImage(ryu_animateRoundHouse.getCurrentFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 10, 
						(int) (y - controller.getGameCamera().getyOffset()) - 10, ((width * 2) + 30), height * 2, null);
			}else{
				g.drawImage(getCurrentAnimationFrame(), (int) (x - controller.getGameCamera().getxOffset()) + 10, 
				(int) (y - controller.getGameCamera().getyOffset()) - 10, width * 2, height * 2, null);
			}
		}	
	}
        
        private void getInput(){
            int xMove = 0;
            int yMove = 0;


            if(controller.getKeyManager().up){
                    yMove = -speed;
            }
            if(controller.getKeyManager().down){
                    yMove = speed;
            }
            if(controller.getKeyManager().left){
                    xMove = -speed;
                    facingRight = false;
            }
            if(controller.getKeyManager().right){
                    xMove = speed;
                    facingRight = true;
            }
	}
        
        private BufferedImage getCurrentAnimationFrame(){
		
		//checkAttacks();
		/*if(controller.getKeyManager().aRight){
			return animateATKRight.getCurrentFrame();
		}else if(controller.getKeyManager().aLeft){
			return animateATKLeft.getCurrentFrame();
		}else*/ 
		
		if(xMove < 0){
			return ryu_animateMove.getCurrentFrame();
		}else if(xMove > 0){
			return ryu_animateMove.getCurrentFrame();
		}else if(yMove < 0){
			return ryu_animateMove.getCurrentFrame();
		}else if(yMove > 0){
			return ryu_animateMove.getCurrentFrame();
		}else{	
			return ryu_AnimateStand.getCurrentFrame();
		}
		
		
		//--------------------Original Asset
//		if(xMove < 0){
//			return animateLeft.getCurrentFrame();
//		}else if(xMove > 0){
//			return animateRight.getCurrentFrame();
//		}else if(yMove < 0){
//			return animateUp.getCurrentFrame();
//		}else if(yMove > 0){
//			return animateDown.getCurrentFrame();
//		}else{	
//			return Assets.player_down[0];
//		}
		
	}
        
        public boolean isFacingRight() {
		return facingRight;
	}


	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}
	
}
