/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player, grass, dirt, stone, rock, stoneWall, tree, boulder;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	//Attack animation arrays
	public static BufferedImage[] player_aRight;
	public static BufferedImage[] player_aLeft;
	
	// Ryu Animations
	public static BufferedImage[] ryu_standing;
	public static BufferedImage[] ryu_move;
	public static BufferedImage[] ryu_roundHouse;
	public static BufferedImage[] ryu_jump;
	public static BufferedImage[] ryu_jab;
	public static BufferedImage[] ryu_highKick;
	public static BufferedImage[] ryu_cross;
	
	public static BufferedImage[] btn_Start;
	
	private static final int playerWidth = 53;//35;
	private static final int playerHeight = 55;//75;
	private static final int textureWidth = 50;
	private static final int textureHeight = 50;
	
	public static void init(){
		SpriteSheetNew sheet = new SpriteSheetNew(ImageLoader.loadImage("/textures/sheet01.gif"));
		
		btn_Start = new BufferedImage[2];
		btn_Start[0] = sheet.crop(0, 260, 148, 49);
		btn_Start[1] = sheet.crop(0,  319, 148, 49);
		
		//Ryu Animation Arrays
		ryu_standing = new BufferedImage[5];
		ryu_standing[0] = sheet.crop(190, 511, 70, 100);
		ryu_standing[1] = sheet.crop(270, 511, 70, 100);
		ryu_standing[2] = sheet.crop(350, 511, 70, 100);
		ryu_standing[3] = sheet.crop(425, 511, 70, 100);
		ryu_standing[4] = sheet.crop(500, 511, 70, 100);
		
		ryu_move = new BufferedImage[6];
		ryu_move[0] = sheet.crop(60, 620, 80, 98);
		ryu_move[1] = sheet.crop(140, 620, 80, 98);
		ryu_move[2] = sheet.crop(225, 620, 80, 98);
		ryu_move[3] = sheet.crop(300, 620, 80, 98);
		ryu_move[4] = sheet.crop(375, 620, 80, 98);
		ryu_move[5] = sheet.crop(450, 620, 80, 98);
		
		ryu_jab = new BufferedImage[2];
		ryu_jab[0] = sheet.crop(430, 1080, 85, 98);
		ryu_jab[1] = sheet.crop(520, 1080, 115, 98);
		
		ryu_highKick = new BufferedImage[3];
		ryu_highKick[0] = sheet.crop(35, 1435, 75, 98);
		ryu_highKick[1] = sheet.crop(120, 1435, 70, 98);
		ryu_highKick[2] = sheet.crop(190, 1435, 126, 98);
		
		ryu_cross = new BufferedImage[3];
		ryu_cross[0] = sheet.crop(24, 1204, 70, 100);
		ryu_cross[1] = sheet.crop(105, 1204, 70, 100);
		ryu_cross[2] = sheet.crop(186, 1204, 121, 100);
		
		ryu_roundHouse = new BufferedImage[6];
		ryu_roundHouse[0] = sheet.crop(326, 1429, 70, 100);
		ryu_roundHouse[1] = sheet.crop(405, 1429, 70, 100);
		ryu_roundHouse[2] = sheet.crop(482, 1429, 95, 100);
		ryu_roundHouse[3] = sheet.crop(4, 1541, 117, 100);
		ryu_roundHouse[4] = sheet.crop(121, 1541, 100, 100);
		ryu_roundHouse[5] = sheet.crop(229, 1541, 61, 100);
		
		//--------------------------------------------------
		
		player_down = new BufferedImage[3];
		player_down[0] = sheet.crop(2, 69, playerWidth, playerHeight);
		player_down[1] = sheet.crop(57, 69, playerWidth, playerHeight);
		player_down[2] = sheet.crop(112, 69, playerWidth, playerHeight);
		
		
		player_up = new BufferedImage[3];
		player_up[0] = sheet.crop(1, 132, playerWidth, playerHeight);
		player_up[1] = sheet.crop(58, 131, playerWidth, playerHeight);
		player_up[2] = sheet.crop(114, 131, playerWidth, playerHeight);
		
		
		player_left = new BufferedImage[3];
		player_left[0] = sheet.crop(182, 0, playerWidth, playerHeight);
		player_left[1] = sheet.crop(236, 0, playerWidth, playerHeight);
		player_left[2] = sheet.crop(290, 0, playerWidth, playerHeight);
		
		player_right = new BufferedImage[3];
		player_right[0] = sheet.crop(0, 1, playerWidth, playerHeight);
		player_right[1] = sheet.crop(54, 1, playerWidth, playerHeight);
		player_right[2] = sheet.crop(110, 0, playerWidth, playerHeight);
		
		//Fill Attack Array with images from SS
		player_aRight = new BufferedImage[2];
		player_aRight[0] = sheet.crop(154, 320, (playerWidth), playerHeight);
		player_aRight[1] = sheet.crop(207, 320, (playerWidth), playerHeight);
		
		player_aLeft = new BufferedImage[2];
		player_aLeft[0] = sheet.crop(264, 320, (playerWidth + 14), playerHeight);
		player_aLeft[1] = sheet.crop(330, 320, (playerWidth + 14), playerHeight);
		
		player = sheet.crop(0, 0, playerWidth, playerHeight);
		dirt = sheet.crop(0, 200, textureWidth, textureHeight);
		stone = sheet.crop(textureWidth, 200, textureWidth, textureHeight);
		grass = sheet.crop((textureWidth * 2), 200, textureWidth, textureHeight);
		rock = sheet.crop((textureWidth * 3), 200, textureWidth, textureHeight);
		stoneWall = sheet.crop((textureWidth * 4), 200, textureWidth, textureHeight);
		tree = sheet.crop((textureWidth * 6), 150, textureWidth, textureHeight * 2);
		boulder = sheet.crop(200, 250, textureWidth, textureHeight);
	}
	
}
