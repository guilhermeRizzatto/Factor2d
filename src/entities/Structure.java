package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Structure {
	
	private BufferedImage image;
	private BufferedImage imageSelect;
	
	private int x,y;

	private Rectangle bounds;

	private boolean selected = false;
	
	public Structure(int x, int y, Rectangle bounds) {
		this.x = x;
		this.y = y;
		
		this.bounds = bounds;
		
		importImage();
	}
	
	public Structure() {
		importImage();
	}
	
	public abstract void importImage();
	
	public abstract void render(Graphics g);
	
	public abstract boolean isIn(MouseEvent e);
	
	public abstract void animation();

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImageSelect() {
		return imageSelect;
	}

	public void setImageSelect(BufferedImage imageSelect) {
		this.imageSelect = imageSelect;
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

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
