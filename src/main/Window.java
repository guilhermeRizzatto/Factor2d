package main;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window {

    private JFrame jframe;
    
    private BufferedImage image;

    public Window(Panel panel){
    	importImage();
    	
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
    	
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setCursor(toolkit.createCustomCursor(image.getScaledInstance(32,32,0), new Point(11,7), "pointer"));
        
        jframe.addWindowFocusListener(new WindowFocusListener() {
        	
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                    panel.getGame().windowLostFocus();
            }
        });
    }
    
    private void importImage() {

	
    	InputStream is = getClass().getResourceAsStream("/cursor.png");		
		

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
    

}
