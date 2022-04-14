package img2rgb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

public class img2rgb {
    private int width;
    private int height;
    private int pixelLength;
    BufferedImage image;
    private boolean hasAlphaChan;
    private byte[] pixels;
    int[][] pixelRGB;
    Color[][] colors;

    public img2rgb(BufferedImage image) {
        this.image = image;
        pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        width = image.getWidth();
        height = image.getHeight();
        pixelRGB = new int[width][height];
        this.colors = new Color[width][height];
        hasAlphaChan = image.getAlphaRaster() != null;
        pixelLength = 3;
        if (hasAlphaChan) {
            pixelLength = 4;
        }
        fillRgbArrayPixels();
        fillColorArrayPixels();
    }

    public byte[] getPixels() {
        return pixels;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPixelLength() {
        return pixelLength;
    }

    private void fillRgbArrayPixels() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelRGB[x][y] = image.getRGB(x, y);
            }
        }
    }

    private void fillColorArrayPixels() {
        for(int x = 0 ; x < width ; x++) {
            for(int y = 0; y < height; y++) {
                colors[x][y] = new Color(pixelRGB[x][y],hasAlphaChan);
            }
        }
    }

    public Color[][] getColors() {
        return this.colors;
    }
    public int[][] getPixelRGB() {
        return this.pixelRGB;
    }

    public int getRedPx(int x,int y) {
        return colors[x][y].getRed();
    }

    public int getGreenPx(int x,int y) {
        return colors[x][y].getGreen();
    }

    public int getBluePx(int x,int y) {
        return colors[x][y].getBlue();
    }
    public void setNewPixel(int x, int y, Color newColor) {
        this.colors[x][y] = newColor;
        this.pixelRGB[x][y] = newColor.getRGB();
    }
    /*public void setRedPx(int x,int y, int newValue) {
        colors[x][y].getRed()
    }*/

    public void saveImage(String name) {
        try {
            File output = new File(name + ".png");
            BufferedImage bI = new BufferedImage(width,height,image.getType());
            for(int x = 0 ; x < height ; x++) {
                for(int y = 0 ; y < width ; y++) {
                    bI.setRGB(x,y,pixelRGB[x][y]);
                }
            }
            ImageIO.write(bI, "png", output);
            System.out.println("Successfully saved file");
        }
        catch (IOException e) {
            System.out.println("Failed Save");
        }
    }
}
