package main;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Belt;
import entities.Player;
import entities.Structure;
import entities.items.BeltItem;
import menus.Inventory;

public class Game implements Runnable {

	private Window window;
	private Panel panel;
	private Thread gameThread;

	private final int FPS_SET = 60;

	private Player player;
	private ArrayList<Structure> objects;
	private Inventory inventory;

	public Game() {
		initClasses();
		panel = new Panel(this);
		window = new Window(panel);

		panel.setFocusable(true);
		panel.requestFocus();

		startGameLoop();

	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void initClasses() {
		player = new Player(0, 0);
		inventory = new Inventory();
		inventory.getItemInventorys().get(0).setItem(new BeltItem(139, 162, new Belt()));
		objects = new ArrayList<>();
	}

	public void render(Graphics g) {
		inventory.render(g);
		player.updateMove();
		player.animation();
		player.render(g);
				
		for(Structure x : objects) {
			x.animation();
			x.render(g);
		}
		
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		double frames = 0;
		long lastCheck = System.currentTimeMillis();

		while (true) {
			long now = System.nanoTime();

			if (now - lastFrame >= timePerFrame) {
				panel.repaint();
				lastFrame = now;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}

		}
	}

	public void windowLostFocus() {
		player.setMoveUp(false);
		player.setMoveDown(false);
		player.setMoveRight(false);
		player.setMoveLeft(false);
	}

	public void windowGainFocus() {

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Structure> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Structure> objects) {
		this.objects = objects;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	
	

}
