package input;

import entity.Entity;
import itmk.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyInput implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aRight, aLeft;
	public boolean ryu_punch, ryu_jab, ryu_cross, ryu_kick, ryu_highKick, ryu_roundhouse;

	
	public KeyInput(){
		keys = new boolean[256];
	}
	
	public void tick(){
            ryu_jab = keys[KeyEvent.VK_U];
            ryu_cross = keys[KeyEvent.VK_I];
            ryu_punch = keys[KeyEvent.VK_O];
            ryu_highKick = keys[KeyEvent.VK_J];
            ryu_kick = keys[KeyEvent.VK_K];
            ryu_roundhouse= keys[KeyEvent.VK_L];
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.controller.entity){
			switch(key){
			case KeyEvent.VK_W:
				//en.setVelY(-5);
				System.out.println(key + " W Key Pressed " + "Speed: " + en.getVelY());
				if(!en.jumping) {
					en.jumping = true;
					en.gravity = 10.0;
				}
				break;
			/*case KeyEvent.VK_S:
				//en.setVelY(5);
				System.out.println(key + " S Key Pressed " + "Speed: " + en.getVelY());
				break;*/
			case KeyEvent.VK_A:
				en.setVelX(-5);
				System.out.println(key + " A Key Pressed " + "Speed: " + en.getVelX());
				break;
			case KeyEvent.VK_D:
				en.setVelX(5);
				System.out.println(key + " D Key Pressed " + "Speed: " + en.getVelX());
				break;
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.controller.entity){
			switch(key){
			case KeyEvent.VK_W:
				en.setVelY(0);
				break;
			case KeyEvent.VK_S:
				en.setVelY(0);
				break;
			case KeyEvent.VK_A:
				en.setVelX(0);
				break;
			case KeyEvent.VK_D:
				en.setVelX(0);
				break;
			}
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// not using
		
	}
	
}

