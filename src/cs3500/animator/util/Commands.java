package cs3500.animator.util;

public enum Commands {
  IN("-in"), VIEW("-view"), OUT("-out"), SPEED("-speed");

  String cmd;

  Commands(String cmd) {
    this.cmd = cmd;
  }

  public String getTextCommand() {
    return this.cmd;
  }
}
