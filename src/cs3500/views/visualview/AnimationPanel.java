package cs3500.views.visualview;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import cs3500.ReadOnlyAnimation;
import cs3500.elements.Ellipse;

public class AnimationPanel extends JPanel {

  public static final int DEFAULT_WIDTH = 500;
  public static final int DEFAULT_HEIGHT = 500;

  private ReadOnlyAnimation rom;

  public AnimationPanel(ReadOnlyAnimation m) {
    super();
    this.rom = m;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    for (String key : rom.getElements().keySet()) {
      rom.getElement(key).paint(g2d);
    }
  }
}
