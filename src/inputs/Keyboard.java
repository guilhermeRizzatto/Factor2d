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
            panel.player.setMoveLeft(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            panel.player.setMoveRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            panel.player.setMoveUp(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            panel.player.setMoveDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            panel.player.setMoveLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            panel.player.setMoveRight(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            panel.player.setMoveUp(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            panel.player.setMoveDown(false);
        }

    }



}
