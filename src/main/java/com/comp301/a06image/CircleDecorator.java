package com.comp301.a06image;

import java.awt.*;

import static java.lang.Math.sqrt;

public class CircleDecorator implements Image {
  private Image image;
  private int cx;
  private int cy;
  private int radius;
  private Color color;
  private int layers;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null || radius < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.cx = cx;
    this.cy = cy;
    this.radius = radius;
    this.color = color;
    this.layers = image.getNumLayers() + 1;
  }

  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight()) {
      throw new IllegalArgumentException();
    }
    if (((x - this.cx) ^ 2 + (y - this.cy) ^ 2) >= (this.radius ^ 2)) {
      return image.getPixelColor(x, y);
    }
    return this.color;
  }

  public int getWidth() {
    return image.getWidth();
  }

  public int getHeight() {
    return image.getHeight();
  }

  public int getNumLayers() {
    return this.layers;
  }
}
