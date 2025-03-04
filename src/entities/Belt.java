package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Belt extends Structure{
	
	private boolean selected = false;

	private int indexSpriteX, indexSpriteY, aniTick, index = 0;
	private int aniSpeed = 10;

	public Belt(int x, int y) {
		super(x,y,new Rectangle(x, y, 96, 96));
		
	}
	
	public Belt() {
		super();
		
	}

	@Override
	public void importImage() {

		InputStream is = getClass().getResourceAsStream("/Belt.png");			
		InputStream isSelect = getClass().getResourceAsStream("/Belt_Selecionado.png");		
		

		try {
			setImage(ImageIO.read(is));
			setImageSelect(ImageIO.read(isSelect));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void render(Graphics g) {	
		animation();
		if(selected) {
			g.drawImage(getImageSelect().getSubimage(indexSpriteX, 0, 32, 32), getX(), getY(), 96, 96, null);		
		} else {
			g.drawImage(getImage().getSubimage(indexSpriteX, 0, 32, 32), getX(), getY(), 96, 96, null);
		}
	}

	@Override
	public boolean isIn(MouseEvent e) {
		return getBounds().contains(e.getX(), e.getY());
	}	

	@Override
	public void animation() {
		aniTick++;

		if (aniTick >= aniSpeed) {
			if (index > 8) {
				index = 0;
			}
			aniTick = 0;
			indexSpriteX = index * 32;
			index++;
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	

}
