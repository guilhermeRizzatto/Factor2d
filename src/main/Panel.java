package main;

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

    private int tickX,tickY,aniTick,index = 0;

    private int aniSpeed = 10;

    public boolean validTickX,validTickY = false;

    public Panel(){
        addKeyListener(new Keyboard(this));
        setPanelSize();
        importImage();
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player-v1.png");

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

        animation();
        g.drawImage(image.getSubimage(tickX,0,32,32),xDelta,yDelta,96,96,null);

    }

    public void updateMove(int xDelta,int yDelta){
        changeXDelta(xDelta);
        changeYDelta(yDelta);
    }

    private void animation(){

        aniTick++;

        if(aniTick >= aniSpeed) {
            aniTick = 0;
            if (validTickX) {
                if (index < 3) {
                    index++;
                    tickX = index * 32;
                } else {
                    index = 0;
                    tickX = index * 32;
                }
            } else if (validTickY) {
                if (index >= 4 && index < 7) {
                    index++;
                    tickX = index * 32;
                } else {
                    index = 4;
                    tickX = index * 32;
                }
            } else {
                index = 0;
                tickX = index * 32;
            }
        }
    }


}
