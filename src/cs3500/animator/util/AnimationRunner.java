package cs3500.animator.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class AnimationRunner {

  public static void main(String[] args) {

    // Command line args
    String inputFileName = "";
    String outputFileName = "System.out";
    String speed = "1";
    String viewType = "";

    // Parsed arguments
    Readable inputFile;
    Appendable outputFile;
    int tempo;

    for (String arg : args) {
      Scanner scan = new Scanner(arg);

      while (scan.hasNext()) {
        try {
          switch (scan.next()) {
            case "-in":
              inputFileName = scan.next();
              break;
            case "-out":
              outputFileName = scan.next();
              break;
            case "-view":
              viewType = scan.next();
              break;
            case "-speed":
              speed = scan.next();
              break;
            default:
              throw new IllegalStateException("Invalid arg");
          }
        }
        catch (NoSuchElementException | IllegalStateException e) {
          // TODO: Open JOptionPane and show error msg
        }
      }
    }

    // Parse Input File
    File inf = new File(inputFileName);
    if (inf.exists() && inf.canRead()) {
      try {
        inputFile = new FileReader(inf);
      }
      catch (FileNotFoundException e) {
        // TODO: Open JOptionPane and show error msg
      }
    }
    else {
      // TODO: Open JOptionPane and show error msg
    }

    // Parse Output File

    // Parse View Type
    if (!(viewType.equals("text") || viewType.equals("svg") || viewType.equals("visual"))) {
      // TODO: Open JOptionPane and show error msg
    }

    // Parse Speed
    try {
      tempo = Integer.parseInt(speed);
      if (tempo < 1) {
        throw new IllegalArgumentException("Tempo cannot be less than 1");
      }
    }
    catch (IllegalArgumentException e) {
      // TODO: Open JOptionPane and show error msg
    }

  }
}
