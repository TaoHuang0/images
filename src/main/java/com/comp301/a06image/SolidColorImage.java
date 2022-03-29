package com.comp301.a06image;

import java.awt.*;

public class SolidColorImage implements Image {
  private int width;
  private int height;
  private Color color;

  public SolidColorImage(int width, int height, Color color) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.color = color;
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x > width || y > height) {
      throw new IllegalArgumentException();
    }
    return this.color;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getNumLayers() {
    return 1;
  }
}
