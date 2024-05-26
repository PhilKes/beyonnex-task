package io.github.philkes;

import io.github.philkes.feature.AnagramsFeature;
import io.github.philkes.feature.Feature;
import io.github.philkes.feature.PreviousAnagramsFeature;
import io.github.philkes.util.AnagramsUtil;
import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {

  private final AnagramsUtil anagramsUtil = new AnagramsUtil();
  private final Scanner scanner = new Scanner(System.in);
  private final AnagramsFeature anagramsFeature = new AnagramsFeature(scanner, anagramsUtil);
  private final PreviousAnagramsFeature previousAnagramsFeature = new PreviousAnagramsFeature(
      scanner,
      anagramsUtil, anagramsFeature.getFeatureInputs());
  private final List<Feature> features = List.of(
      anagramsFeature,
      previousAnagramsFeature
  );
  public final String ILLEGAL_INPUT_MESSAGE = "You have to either enter a number between 1 and %d to select a feature or enter \"e\" to exit!".formatted(
      features.size());

  public void loop() {
    while (true) {
      var selectedFeature = -1;
      do {
        System.out.println(
            "########################################################################################");
        System.out.println("Enter which feature you want to execute:");
        for (int idx = 0; idx < features.size(); idx++) {
          System.out.printf("(%d): %s%n", idx + 1, features.get(idx).getDescription());
        }
        System.out.println("(e): Exit");
        System.out.println(
            "########################################################################################");
        try {
          String input = scanner.nextLine();
          if (input.equals("e")) {
            return;
          }
          selectedFeature = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
          System.err.println(ILLEGAL_INPUT_MESSAGE);
        }
        if (selectedFeature < 1 || selectedFeature > features.size()) {
          System.err.println(ILLEGAL_INPUT_MESSAGE);
          selectedFeature = -1;
        }
      } while (selectedFeature == -1);
      features.get(selectedFeature - 1).execute();
    }

  }

}
