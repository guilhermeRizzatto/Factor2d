package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entities.Belt;
import entities.Structure;
import main.Panel;
import menus.ItemInventory;

public class Mouse implements MouseListener {

	private Panel panel;

	public Mouse(Panel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x=" + e.getX() + "|y=" + e.getY());

		for (ItemInventory x : panel.getGame().getInventory().getItemInventorys()) {
			if (x.getItem() != null) {
				if(e.getButton() == 3) {
					x.getItem().setPicked(false);
				}
				if (x.getItem().isPicked()) {
					if(x.getItem().getQuantity() >= 1) {
						panel.getGame().getObjects().add(new Belt(e.getX(), e.getY()));		
						x.getItem().remove();
					}
				}
			}
			if (x.isIn(e)) {
				x.setSelect(true);
				if(x.getItem()!= null) {					
					x.getItem().setPicked(true);
				}
			} else {
				x.setSelect(false);
			}
		}
		
		for(Structure obj : panel.getGame().getObjects()) {
			if (obj.isIn(e)) {
				obj.setSelected(true);
			} else {
				obj.setSelected(false);
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
