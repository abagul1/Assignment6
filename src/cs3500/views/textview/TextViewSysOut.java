package cs3500.views.textview;

import cs3500.ReadOnlyAnimation;
import cs3500.views.AbstractTextView;

/**
 * Represents the textual view for the animation when the output is the console.
 */
public class TextViewSysOut extends AbstractTextView {

  /**
   * Constructor for a text view from the console output.
   * @param a animation
   */
  public TextViewSysOut(ReadOnlyAnimation a) {
    super(a);
  }

  @Override
  public void execute() {
    System.out.println(super.getVerboseAnimation());
  }

  @Override
  public void refresh() {
    //Method doesn't apply
  }

  @Override
  public void makeVisible() {
    //Method doesn't apply
  }
}
