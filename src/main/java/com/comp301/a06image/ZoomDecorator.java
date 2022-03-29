package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  private Image image;
  private int multiplier;

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  public ZoomDecorator(Image image, int multiplier) {
    if (multiplier < 1 | image == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0
        || y < 0
        || x >= image.getWidth() * multiplier
        || y >= image.getHeight() * multiplier) {
      throw new IllegalArgumentException();
    }
    return image.getPixelColor(x / this.multiplier, y / this.multiplier);
  }

  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
