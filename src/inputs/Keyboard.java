package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;
import main.Panel;

public class Keyboard implements KeyListener {

    private Panel panel;


    public Keyboard(Panel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A){
            panel.getGame().getPlayer().setMoveLeft(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
        	panel.getGame().getPlayer().setMoveRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
        	panel.getGame().getPlayer().setMoveUp(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
        	panel.getGame().getPlayer().setMoveDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
        	panel.getGame().getPlayer().setMoveLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
        	panel.getGame().getPlayer().setMoveRight(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
        	panel.getGame().getPlayer().setMoveUp(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
        	panel.getGame().getPlayer().setMoveDown(false);
        }

    }



}
