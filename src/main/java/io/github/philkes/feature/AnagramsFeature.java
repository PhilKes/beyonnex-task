package io.github.philkes.feature;

import io.github.philkes.util.AnagramsUtil;
import java.util.List;
import java.util.Scanner;

public class AnagramsFeature extends Feature {

  private final AnagramsUtil anagramsUtil;

  public AnagramsFeature(Scanner scanner, AnagramsUtil anagramsUtil) {
    super("Check if two specified strings are anagrams",
        List.of("first string", "second string"), scanner
    );
    this.anagramsUtil = anagramsUtil;
  }

  @Override
  protected void execution(List<String> inputs) {
    String s1 = inputs.get(0);
    String s2 = inputs.get(1);
    var areAnagrams = anagramsUtil.areAnagrams(s1, s2);
    System.out.println(areAnagrams ? "%s is an anagram of %s".formatted(s1, s2)
        : "%s is not an anagram of %s".formatted(s1, s2));
  }
}
