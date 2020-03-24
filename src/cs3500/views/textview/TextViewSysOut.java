package cs3500.views.textview;

import cs3500.ReadOnlyAnimation;
import cs3500.views.AbstractTextView;

public class TextViewSysOut extends AbstractTextView {

  public TextViewSysOut(ReadOnlyAnimation a) {
    super(a);
  }

  @Override
  public void getTextualView() {
    System.out.println(super.getVerboseAnimation());
  }
}
