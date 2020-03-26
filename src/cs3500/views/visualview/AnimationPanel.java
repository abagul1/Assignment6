package cs3500.views.visualview;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import cs3500.ReadOnlyAnimation;
import cs3500.elements.Ellipse;

public class AnimationPanel extends JPanel {

  private ReadOnlyAnimation rom;

  public AnimationPanel(ReadOnlyAnimation m) {
    super();
    this.rom = m;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(-rom.getX(), -rom.getY());

    for (String key : rom.getElements().keySet()) {
      rom.getElement(key).paint(g2d);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(rom.getWidth(), rom.getHeight());
  }
}
