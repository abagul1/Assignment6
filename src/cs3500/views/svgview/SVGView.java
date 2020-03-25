package cs3500.views.svgview;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import cs3500.ReadOnlyAnimation;
import cs3500.views.AbstractTextView;

/**
 * Represents the view for an svg formatted file.
 */
public class SVGView extends AbstractTextView {
  private String out;
  private FileWriter fileWriter;
  private int height;
  private int width;

  /**
   * Constructor for an svg file.
   * @param a read only animation
   * @param out output destination
   */
  public SVGView(ReadOnlyAnimation a, String out) {
    super(a);
    if (out.substring(out.length() - 4) != ".svg") {
      throw new IllegalArgumentException("SVG output file is invalid");
    }
    this.out = out;
    this.height = a.getHeight();
    this.width = a.getWidth();
  }

  /**
   * Gets the svg formatted text for a specific element's motions.
   * @param id id of the element
   * @return a string of in svg format
   */
  private String getSVGForElement(String id) {
    StringBuilder str = new StringBuilder();
    for (String k : verboseOps.get(id)) {
      int[] arr = this.motionParser(k);
      str.append("<animate attributeName=\"x\" attributeType=\"XML\"\n"
              + "             begin=\"" + arr[0] + "s\" dur=\"" + (arr[8] - arr[0])
              + "s\" fill=\"freeze\" from=\"" + arr[1] + "\" to=\"" + arr[9] + "\" />\n");
      str.append("<animate attributeName=\"y\" attributeType=\"XML\"\n"
              + "             begin=\"" + arr[0] + "s\" dur=\"" + (arr[8] - arr[0])
              + "s\" fill=\"freeze\" from=\"" + arr[2] + "\" to=\"" + arr[10] + "\" />\n");
      str.append("<animate attributeName=\"width\" attributeType=\"XML\"\n"
              + "             begin=\"" + arr[0] + "s\" dur=\"" + (arr[8] - arr[0])
              + "s\" fill=\"freeze\" from=\"" + arr[3] + "\" to=\"" + arr[11] + "\" />\n");
      str.append("<animate attributeName=\"height\" attributeType=\"XML\"\n"
              + "             begin=\"" + arr[0] + "s\" dur=\"" + (arr[8] - arr[0])
              + "s\" fill=\"freeze\" from=\"" + arr[4] + "\" to=\"" + arr[12] + "\" />\n");
      str.append("<animate attributeName=\"fill\" attributeType=\"CSS\"\n" +
              "           from=\"rgb("+ arr[5] + "," + arr[6] + "," + arr[7]
              + ")\" to=\"rgb("+ arr[13] + "," + arr[14] + "," + arr[15] +")\"\n" +
              "           begin=\"" + arr[0] + "s\" dur=\"" + (arr[8] - arr[0])
              + "s\" fill=\"freeze\" />\n");
    }
    return str.toString();
  }

  /**
   * Makes the complete svg file from the animation.
   * @return a string with the formatted svg content
   */
  private String getSVG() {
    StringBuilder str = new StringBuilder();
    str.append("<?xml version=\"1.0\" standalone=\"no\"?>\n"
            + "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n"
            + "  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
            + "<svg width=\"" + width + "cm\" height=\"" + height
            + "cm\"  viewBox=\"0 0 800 300\"\n"
            + "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");

    for (String key : elements.keySet()) {
      int[] arr;
      switch (elements.get(key).getType()) {
        case "rectangle":
          arr = this.motionParser(super.verboseOps.get(key).get(1));
          str.append("<rect id=\"" + key + "\" x=\"" + arr[1] + "\" y=\"" + arr[2]
                  + " \" width=\"" + arr[3] + "\" height=\"" + arr[4] + "\"\n"
                  + "        fill=\"rgb(" + arr[5] + "," + arr[6] + "," + arr[7] + ")\"  >\n");
          str.append(this.getSVGForElement(key));
          str.append("</rect>\n");
          break;
        case "ellipse":
          arr = this.motionParser(super.verboseOps.get(key).get(1));
          str.append("<ellipse id=\"" + key + "\" x=\"" + arr[1] + "\" y=\"" + arr[2]
                  + " \" width=\"" + arr[3] + "\" height=\"" + arr[4] + "\"\n"
                  + "        fill=\"rgb(" + arr[5] + "," + arr[6] + "," + arr[7] + ")\"  >\n");
          str.append(this.getSVGForElement(key));
          str.append("</ellipse>\n");
          break;
        default:
          throw new IllegalArgumentException("Shape doesn't exist");
      }
    }
    return str.toString();
  }

  /**
   * Parses a single motion command and stores all the key values in an array.
   * @param s string to parse
   * @return an array of shape variables
   */
  private int[] motionParser(String s) {
    int[] arr = new int[16];
    String str = s.substring(8);
    Scanner scan = new Scanner(str);
    int i = 0;
    while (scan.hasNextInt()) {
      arr[i] = scan.nextInt();
      i++;
    }
    return arr;
  }

  @Override
  public void getTextualView() {
    try {
      fileWriter = new FileWriter(out);
      fileWriter.write(this.getSVG());
      fileWriter.close();
    }
    catch (IOException e) {
      //TODO: implement error message
    }
  }

}
