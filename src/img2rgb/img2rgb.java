package img2rgb;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class img2rgb {
    private int width;
    private int height;
    private int pixelLength;
    private boolean hasAlphaChan;
    private byte[] pixels;

    public img2rgb(BufferedImage image) {
        pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        width = image.getWidth();
        height = image.getHeight();
        hasAlphaChan = image.getAlphaRaster() != null;
        pixelLength = 3;
        if (hasAlphaChan) {
            pixelLength = 4;
        }
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

    public void setPixels(int x, int y) {

    }
}
