package main;

import entities.Player;
import inputs.Keyboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Panel extends JPanel {

    private int xDelta, yDelta = 0;

    private BufferedImage image;

    private int indexSpriteX,indexSpriteY,aniTick,index = 0;

    private int aniSpeed = 10;

    public Player player;

    public Panel(){
        this.player = new Player();

        addKeyListener(new Keyboard(this));
        setPanelSize();
        importImage();
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player-v1.5.png");

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

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateMove(player);
        animation();
        g.drawImage(image.getSubimage(indexSpriteX,0,32,32),xDelta,yDelta,96,96,null);

    }

    public void updateMove(Player player){
        if(player.isMoveLeft()){
            changeXDelta(-5);
        }
        if(player.isMoveRight()){
            changeXDelta(5);
        }
        if(player.isMoveUp()){
            changeYDelta(-5);
        }
        if(player.isMoveDown()){
            changeYDelta(5);
        }

    }

    private void animation(){

        aniTick++;

        if(aniTick >= aniSpeed) {
            aniTick = 0;
            if (player.isMoveDown()) {
                if (index < 3) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 0;
                    indexSpriteX = index * 32;
                }
            } else if (player.isMoveUp()) {
                if (index >= 4 && index < 7) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 4;
                    indexSpriteX = index * 32;
                }
            } else if (player.isMoveLeft()) {
                if (index >= 8 && index < 11) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 8;
                    indexSpriteX = index * 32;
                }
            } else if (player.isMoveRight()) {
                if (index >= 12 && index < 15) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 12;
                    indexSpriteX = index * 32;
                }
            } else {
                index = 0;
                indexSpriteX = index * 32;
            }
        }
    }


}
