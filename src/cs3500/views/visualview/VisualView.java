package cs3500.views.visualview;

import java.awt.BorderLayout;

import javax.swing.*;

import cs3500.IView;
import cs3500.ReadOnlyAnimation;
import cs3500.views.visualview.AnimationPanel;

/**
 * Parent class for visual views and their respective decorator classes.
 */
public class VisualView extends JFrame implements IView {

  public VisualView(ReadOnlyAnimation m) {
    super();

    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    this.add(new JScrollPane(new AnimationPanel(m), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

    this.setTitle("Animation Station");
    this.setSize(AnimationPanel.DEFAULT_WIDTH, AnimationPanel.DEFAULT_HEIGHT);
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
