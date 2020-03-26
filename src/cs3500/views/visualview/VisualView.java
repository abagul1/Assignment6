package cs3500.views.visualview;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs3500.IView;
import cs3500.ReadOnlyAnimation;
import cs3500.views.visualview.AnimationPanel;

/**
 * Parent class for visual views and their respective decorator classes.
 */
public class VisualView extends JFrame implements IView, Scrollable{
  private int speed;
  private ReadOnlyAnimation m;

  public VisualView(ReadOnlyAnimation m, int speed) {
    super();

    if (m == null) {
      JOptionPane.showMessageDialog(null, "Model cannot be null",
              "Error", JOptionPane.ERROR_MESSAGE);
      throw new IllegalArgumentException("Model cannot be null");
    }

    this.m = m;
    this.speed = speed;

    AnimationPanel animationPanel = new AnimationPanel(m);
    this.add(animationPanel);

    this.setTitle("Animation Station");
    this.setSize(m.getWidth(), m.getHeight());
    this.setLocationRelativeTo(null);
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

  @Override
  public void execute() {
    this.makeVisible();
    this.refresh();
    m.executeOneTick();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(m.getWidth(), m.getHeight());
  }

  @Override
  public Dimension getPreferredScrollableViewportSize() {
    return getPreferredSize();
  }

  @Override
  public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
    return 20;
  }

  @Override
  public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
    return 5;
  }

  @Override
  public boolean getScrollableTracksViewportWidth() {
    return false;
  }

  @Override
  public boolean getScrollableTracksViewportHeight() {
    return false;
  }
}
