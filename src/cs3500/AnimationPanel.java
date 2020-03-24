package cs3500;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

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
  }
}
