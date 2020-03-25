package cs3500.views;

import java.util.Objects;

import cs3500.IView;
import cs3500.ReadOnlyAnimation;
import cs3500.views.svgview.SVGView;
import cs3500.views.textview.TextView;
import cs3500.views.textview.TextViewSysOut;
import cs3500.views.visualview.VisualView;

public class ViewCreator {

  public static IView create(String vt, ReadOnlyAnimation a, String out) {
    Objects.requireNonNull(vt, "Must have non-null view type");

    switch (vt) {
      case "text":
        if (out.equals("System.out")) {
          return new TextViewSysOut(a);
        }
        else {
          return new TextView(a, out);
        }
      case "svg":
        return new SVGView(a, out);
      case "visual":
        return new VisualView(a);
      default:
        throw new IllegalArgumentException("Invalid view type");
    }
  }

}
