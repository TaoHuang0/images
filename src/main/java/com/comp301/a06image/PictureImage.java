package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PictureImage implements Image {
  private final BufferedImage bufferedImage;
  private int layer;

  public PictureImage(String pathname) throws IOException {
    if (pathname == null) {
      throw new IllegalArgumentException();
    }
    this.bufferedImage = ImageIO.read(new File(pathname));
    this.layer = 1;
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0
        || y < 0
        || x >= this.bufferedImage.getWidth()
        || y >= this.bufferedImage.getHeight()) {
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
    return this.layer;
  }
}
