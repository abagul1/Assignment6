package cs3500.views.svgview;

import java.io.FileWriter;
import java.io.IOException;

import cs3500.ReadOnlyAnimation;
import cs3500.views.AbstractTextView;

public class SVGView extends AbstractTextView {
  private String out;
  private String fileContent;
  private FileWriter fileWriter;

  public SVGView(ReadOnlyAnimation a, String out) {
    super(a);
    this.out = out;
  }



  @Override
  public void getTextualView() {
    try {
      fileWriter = new FileWriter(out);
      fileWriter.write(fileContent);
      fileWriter.close();
    }
    catch (IOException e) {
      //TODO: implement error message
    }
  }

}