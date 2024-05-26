package io.github.philkes.util;

import java.util.Arrays;

public class AnagramsUtil {

  public boolean areAnagrams(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }
    var s1Chars = s1.toCharArray();
    var s2Chars = s2.toCharArray();
    Arrays.sort(s1Chars);
    Arrays.sort(s2Chars);

    return Arrays.equals(s1Chars, s2Chars);
  }

}
