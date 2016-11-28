/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import itmk.Controller;
import itmk.Game;
import itmk.ID;
import java.awt.Color;
import java.awt.Graphics;


public class Wall extends Tile{

	public Wall(int x, int y, int width, int height, boolean solid, ID id,
			Controller controller) {
		super(x, y, width, height, solid, id, controller);
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		//g.drawImage(Game.grass.getBufferedImage(), x, y, width, height, null);
	}

	@Override
	public void tick() {
		
		
	}
	
}

