package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PictureImage implements Image {
  private BufferedImage bufferedImage;

  public PictureImage(String pathname) throws IOException {
    this.bufferedImage = ImageIO.read(getClass().getResourceAsStream(pathname));
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x > this.bufferedImage.getWidth() || y > this.bufferedImage.getHeight()) {
      throw new IllegalArgumentException();
    }
    int color = this.bufferedImage.getRGB(x, y);
    Color pixelColor = new Color(color);
    return pixelColor;
  }

  public int getWidth() {
    return this.bufferedImage.getWidth();
  }

  public int getHeight() {
    return this.bufferedImage.getHeight();
  }

  public int getNumLayers() {
    return 1;
  }
}