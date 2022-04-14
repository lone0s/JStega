package img2rgb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class testImg {
    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("src/img/whitesquare.png"));
        //System.out.println("Loaded File");

        img2rgb img2rgb = new img2rgb(bufferedImage);
        for(int i = 0 ; i < img2rgb.getWidth() ; i++) {
            for(int j = 0 ; j < img2rgb.getHeight()/2; j++) {
                img2rgb.setNewPixel(i,j, Color.BLUE);
            }
        }

        img2rgb.saveImage("Result_Black");
    }
}
