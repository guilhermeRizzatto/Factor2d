package menus;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import entities.items.Item;

public class ItemInventory {
	
	private BufferedImage image;
	private BufferedImage imageSelect;
	private int x,y;
	private Rectangle bounds;
	private boolean select;
	
	private Item item;
	
	
	
	public ItemInventory(int x, int y) {
		this.x = x;
		this.y = y;		
		importImage();
		bounds = new Rectangle(x,y,64,64);
	}
	
	private void importImage() {		
		InputStream is = getClass().getResourceAsStream("/item_inventory.png");			
		InputStream isSelect = getClass().getResourceAsStream("/item_inventory_select.png");		
		
        try {
            image = ImageIO.read(is);
            imageSelect = ImageIO.read(isSelect);
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
    
    public void render(Graphics g) {
    	if(select) {
    		g.drawImage(imageSelect,x,y,64,64,null); //123,147 
    	} else {
    		g.drawImage(image,x,y,64,64,null);
    	}
    	

    	
    	
        
    }
    
    public boolean isIn(MouseEvent e) {
		return bounds.contains(e.getX(), e.getY());
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
    

}
