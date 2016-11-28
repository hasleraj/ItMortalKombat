package input;

import entity.Entity;
import itmk.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyInput implements KeyListener {

	

	
	public KeyInput(){
		
	}
	
	public void tick(){
		
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

