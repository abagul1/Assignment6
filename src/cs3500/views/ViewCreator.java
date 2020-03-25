package cs3500.views;

import java.util.Objects;

import cs3500.IView;
import cs3500.model.AnimationModel;
import cs3500.views.textview.TextView;

public class ViewCreator {

  public static IView create(String vt) {
    Objects.requireNonNull(vt, "Must have non-null view type");

    switch (vt) {
      case "text":
        // return new Text View
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
    //TODO: fill out return statments.
    return null;
  }

}
