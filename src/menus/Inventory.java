package menus;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Belt;

public class Inventory {
	
	private BufferedImage image;
	
	private ArrayList<ItemInventory> itemInventorys = new ArrayList<>();;
	
	
	public Inventory() {
		int x = 123;
		int y = 147;
		
		for(int i = 1; i <= 7; i++) {
			if(i == 1) {
				itemInventorys.add(new ItemInventory(x, y));
			} else {
				itemInventorys.add(new ItemInventory(x = x + 65, y));				
			}
			for(int e = 1; e <= 6; e++) {
				if(e == 1) {
					itemInventorys.add(new ItemInventory(x, y = 147));
				} else {
					itemInventorys.add(new ItemInventory(x, y = y + 65));				
				}
			}
		}
		
		importImage();

	}
	
	private void importImage() {
        InputStream is = getClass().getResourceAsStream("/Inventory.png");

        try {
            image = ImageIO.read(is);
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
        g.drawImage(image,100,100,500,500,null);
        
        for(ItemInventory x : itemInventorys) {	
        	x.render(g);
        }
        
        for(ItemInventory x : itemInventorys) {	
        	if(x.getItem() != null) {     		
        		x.getItem().render(g);
        	}
        }
    }


	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setItemInventorys(ArrayList<ItemInventory> itemInventorys) {
		this.itemInventorys = itemInventorys;
	}

	public ArrayList<ItemInventory> getItemInventorys() {
		return itemInventorys;
	}
	
	
    
    

}
