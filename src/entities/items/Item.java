package entities.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Structure;

public abstract class Item {
	
	private BufferedImage image;
	private int x,y;
	private int quantity;
	private boolean picked;
	
	private ArrayList<Structure> obj;

	public Item(int x, int y, Structure structure) {
		this.x = x;
		this.y = y;
		this.obj = new ArrayList<>();
		
		obj.add(structure);
		quantity = obj.size();
		
		importImage();
	}
	
	public abstract void importImage();
	
	public abstract void render(Graphics g);
	
	public void add(Structure structure) {
		obj.add(structure);
		quantity = obj.size();
	}
	
	public void remove() {
		obj.removeLast();
		quantity = obj.size();
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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

	public int getQuantity() {
		quantity = obj.size();
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}

	public ArrayList<Structure> getObj() {
		return obj;
	}

	public void setObj(ArrayList<Structure> obj) {
		this.obj = obj;
	}

	
	
	
	
	
	
	
	
}
