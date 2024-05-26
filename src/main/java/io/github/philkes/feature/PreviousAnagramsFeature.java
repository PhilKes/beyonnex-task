package io.github.philkes.feature;

import io.github.philkes.util.AnagramsUtil;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PreviousAnagramsFeature extends Feature {

  private final AnagramsUtil anagramsUtil;
  private final Set<String> feature1Inputs;

  public PreviousAnagramsFeature(Scanner scanner, AnagramsUtil anagramsUtil,
      Set<String> feature1Inputs) {
    super(
        "Check for which strings previously inputted into feature 1 the specified string is an anagram",
        List.of("string"), scanner
    );
    this.anagramsUtil = anagramsUtil;
    this.feature1Inputs = feature1Inputs;
  }

  @Override
  protected void execution(List<String> inputs) {
    String input = inputs.getFirst();
    var anagramsOfInput = feature1Inputs.stream()
        .filter(feature1Input -> anagramsUtil.areAnagrams(input, feature1Input)).toList();
    if (anagramsOfInput.isEmpty()) {
      System.out.printf("%s is not an anagram of any previously entered inputs to feature 1%n",
          input);
    } else {
      System.out.printf(
          "%s is an anagram of the following previously entered inputs to feature 1: %s%n", input,
          String.join(",", anagramsOfInput));
    }
  }
}
