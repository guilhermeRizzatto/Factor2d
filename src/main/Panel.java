package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import inputs.Keyboard;
import inputs.Mouse;

public class Panel extends JPanel {
	
	private Game game;

    public Panel(Game game){
        addKeyListener(new Keyboard(this));
        addMouseListener(new Mouse(this));
        setPanelSize();    
        this.game = game;
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
    
    


}
