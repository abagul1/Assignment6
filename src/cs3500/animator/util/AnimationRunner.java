package cs3500.animator.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.IAnimation;
import cs3500.model.AnimationModel;
import cs3500.views.ViewCreator;

public final class AnimationRunner {

  public static void main(String[] args) {

    String inputFileName = "";
    String outputFileName = "System.out";
    String speed = "1";
    String viewType = "visual";
    int tempo = 1;

    for (int i = 0; i < args.length - 1; i++)  {
        switch (args[i]) {
          case "-in":
            inputFileName = args[i + 1];
            i++;
            break;
          case "-out":
            outputFileName = args[i + 1];
            i++;
            break;
          case "-view":
            viewType = args[i + 1];
            i++;
            break;
          case "-speed":
            speed = args[i + 1];
            i++;
            break;
          default:
            throw new IllegalStateException("Invalid argument");
        }
      }

    try {
      tempo = Integer.parseInt(speed);
      if (tempo < 1) {
        throw new IllegalArgumentException("Tempo cannot be less than 1");
      }
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException("Tempo has to be a integer");
    }

    //Execute Program
    AnimationReader ar = new AnimationReader();
    AnimationBuilder<IAnimation> ab = new AnimationModel.Builder();
    ViewCreator vc = new ViewCreator();
    try {
      vc.create(viewType, ar.parseFile(new FileReader(inputFileName),
              ab), outputFileName, tempo).execute();
    }
    catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File is invalid");
    }
  }
}
