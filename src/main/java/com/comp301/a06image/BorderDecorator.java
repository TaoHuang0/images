package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  private Image image;
  private int thiccness;
  private Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (image == null || thiccness < 0) {
      System.out.println("abc");
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0
        || y < 0
        || x >= (image.getWidth() + 2 * thiccness)
        || y >= (image.getHeight() + 2 * thiccness)) {
      System.out.println("def");
      throw new IllegalArgumentException();
    }
    if (thiccness == 0) {
      return image.getPixelColor(x, y);
    }
    if (x < thiccness
        || x >= (image.getWidth() + thiccness)
        || y < thiccness
        || y >= (image.getHeight() + thiccness)) {
      return this.borderColor;
    }
    return image.getPixelColor(x, y);
  }

  public int getWidth() {
    return image.getWidth() + 2 * this.thiccness;
  }

  public int getHeight() {
    return image.getHeight() + 2 * this.thiccness;
  }

  public int getNumLayers() {
    if (thiccness == 0) {
      return image.getNumLayers();
    }
    return image.getNumLayers() + 1;
  }
}
