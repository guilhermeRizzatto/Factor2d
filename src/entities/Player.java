package entities;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player {

    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveUp = false;
    private boolean moveDown = false;
    
    private BufferedImage image;

    private int x,y;
    private int speed = 3;
    private int indexSpriteX,indexSpriteY,aniTick,index = 0;
    private int aniSpeed = 10;

    public Player(int x,int y){
        this.x = x;
        this.y = y;
        
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
    
    public void render(Graphics g) {
    	updateMove();
        animation();
        g.drawImage(image.getSubimage(indexSpriteX,0,32,32),x,y,96,96,null);
    }



    public void changeX(int value){
        this.x += value;
    }

    public void changeY(int value){
        this.y += value;
    }

    public void updateMove(){
        if(isMoveLeft()){
            changeX(speed * -1);
        }
        if(isMoveRight()){
            changeX(speed);
        }
        if(isMoveUp()){
            changeY(speed * -1);
        }
        if(isMoveDown()){
            changeY(speed);
        }

    }

    public void animation(){

        aniTick++;

        if(aniTick >= aniSpeed) {
            aniTick = 0;
            if (isMoveDown()) {
                if (index < 3) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 0;
                    indexSpriteX = index * 32;
                }
            } else if (isMoveUp()) {
                if (index >= 4 && index < 7) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 4;
                    indexSpriteX = index * 32;
                }
            } else if (isMoveLeft()) {
                if (index >= 8 && index < 11) {
                    index++;
                    indexSpriteX = index * 32;
                } else {
                    index = 8;
                    indexSpriteX = index * 32;
                }
            } else if (isMoveRight()) {
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
 

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveUp() {
        return moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }
    
    
}
