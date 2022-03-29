package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    Image baseImage = new PictureImage("img/kmp.jpg");
    Color redBorderColor = new Color(255, 0, 0);
    Color blueBorderColor = new Color(0, 0, 255);
    Color yellowCircleColor = new Color(255, 255, 0);
    Color orangeSquareColor = new Color(200, 80, 10);
    baseImage = new BorderDecorator(baseImage, 5, redBorderColor);
    baseImage = new BorderDecorator(baseImage, 50, blueBorderColor);
    baseImage = new CircleDecorator(baseImage, 50, 50, 40, yellowCircleColor);
    baseImage = new SquareDecorator(baseImage, 100, 100, 40, orangeSquareColor);
    baseImage = new ZoomDecorator(baseImage);
    return baseImage;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
