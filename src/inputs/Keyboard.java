package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
            panel.updateMove(-10,0);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            panel.updateMove(10,0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            panel.validTickY = true;
            panel.updateMove(0,-10);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            panel.validTickX = true;
            panel.updateMove(0,10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_S){
            panel.validTickX = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            panel.validTickY = false;
        }

    }



}
