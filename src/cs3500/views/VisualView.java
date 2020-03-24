package cs3500.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import cs3500.IView;
import cs3500.ReadOnlyAnimation;
import cs3500.views.visualview.AnimationPanel;

/**
 * Parent class for visual views and their respective decorator classes.
 */
public abstract class VisualView extends JFrame implements IView {

  public VisualView(ReadOnlyAnimation m) {
    super();

    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    this.add(new AnimationPanel(m), BorderLayout.CENTER);

    this.setTitle("Animation Station");
    // this.setSize(..);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
