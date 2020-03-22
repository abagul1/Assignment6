package cs3500;

import java.util.Objects;

public class ViewCreator {

  public static IView create(String vt) {
    Objects.requireNonNull(vt, "Must have non-null view type");

    switch (vt) {
      case "text":
        // return new TextView
        break;
      case "svg":
        // return new SVGView
        break;
      case "visual":
        // return new VisualView
        break;
      default:
        throw new IllegalArgumentException("Invalid view type");
    }
  }

}
