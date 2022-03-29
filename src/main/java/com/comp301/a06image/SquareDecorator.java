package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {
  private Image image;
  private int squareX;
  private int squareY;
  private int squareSize;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0) {
      System.out.println("abc");
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  public Color getPixelColor(int x, int y) {
    System.out.println("x is: " + x);
    System.out.println("y is: " + y);
    System.out.println("squareSize is: " + this.squareSize);
    System.out.println("squareX is: " + squareX);
    System.out.println("squareY is: " + squareY);
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException();
    }
    if (x > squareSize + squareX
        || y > squareSize + squareY
        || x < squareX - squareSize
        || y < squareY - squareSize) {
      System.out.println("abc");
      return image.getPixelColor(x, y);
    }
    System.out.println("def");
    return this.color;
  }

  public int getWidth() {
    return image.getWidth();
  }

  public int getHeight() {
    return image.getHeight();
  }

  public int getNumLayers() {
    return 2;
  }
}
