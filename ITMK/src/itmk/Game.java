package itmk;

import entity.Player;
import gfx.Sprite;
import gfx.SpriteSheet;
import input.KeyInput;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;



public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 270;
	public static final int HEIGHT = WIDTH/14*10;
	public static final int SCALE = 4;
	public static final String TITLE = "Side Scroller";
	
	
	private Thread thread;
	private boolean running = false;
	
	public static Controller controller;
	
	public static SpriteSheet sheet;
	
	public static Sprite grass;
	public static Sprite player;
	
	public Game(){
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	private void init(){
		controller = new Controller();
		addKeyListener(new KeyInput());
		//sheet = new SpriteSheet("/spritesheet.png");
		//grass = new Sprite(sheet, 2, 1); 
		//player = new Sprite(sheet, 1, 1);
		
		controller.addEntity(new Player(300, 515, 64, 64, true, ID.player, controller));
		//controller.addTile(new Wall(200, 200, 64, 64, true, Id.wall, controller));
		
	}
	
	private synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000.0/60.0;
		int frames = 0;
		int update = 0;
		
		while(running){
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			while(delta>=1){
				tick();
				update++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				System.out.println(frames + " Frames Per Second " + update + " Updates Per Second ");
				frames = 0;
				update = 0;
			}
		}
		stop();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//g.setColor(Color.MAGENTA);
		//g.setColor(new Color(124, 28, 97));
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		controller.render(g);
		g.dispose();
		bs.show();
	}
	
	public void tick(){
		controller.tick();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}

	
	
}
