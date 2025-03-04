package entities.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import entities.Belt;

public class BeltItem extends Item {
	
	public BeltItem(int x, int y, Belt obj) {
		super(x, y, obj);
	}

	@Override
	public void importImage() {
		InputStream is = getClass().getResourceAsStream("/Belt_item.png");

		try {
			setImage(ImageIO.read(is));
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
		g.drawImage(getImage(),getX(),getY(),32,32,null); //139, 162 posicao padrao do primeiro slot
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("SF MONO", 0, 13));
		if(getQuantity() > 9) {
			g.drawString(String.valueOf(getQuantity()), getX() + 27, getY() + 42);
		} else {
			g.drawString(String.valueOf(getQuantity()), getX() + 32, getY() + 42);			
		}

	}

}
