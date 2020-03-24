package cs3500;

import javax.swing.*;

public class VisualView extends JFrame implements IView {
  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
