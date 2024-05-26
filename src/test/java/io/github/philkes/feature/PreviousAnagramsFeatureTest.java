package io.github.philkes.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.github.philkes.util.AnagramsUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreviousAnagramsFeatureTest {

  private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  public void setup() {
    outputStream.reset();
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void executionPreviousAnagrams() {
    var anagramsUtil = mock(AnagramsUtil.class);
    when(anagramsUtil.areAnagrams("test", "stet")).thenReturn(true);
    new PreviousAnagramsFeature(null, anagramsUtil, Set.of("stet")).execution(List.of("test"));
    assertEquals(
        "test is an anagram of the following previously entered inputs to feature 1: stet\n",
        outputStream.toString());
  }

  @Test
  void executionNoPreviousAnagrams() {
    var anagramsUtil = mock(AnagramsUtil.class);
    when(anagramsUtil.areAnagrams("test", "123")).thenReturn(false);
    new PreviousAnagramsFeature(null, anagramsUtil, Set.of("123")).execution(List.of("test"));
    assertEquals(
        "test is not an anagram of any previously entered inputs to feature 1\n",
        outputStream.toString());
  }

  @Test
  void executionEmptyPreviousInputs() {
    var anagramsUtil = mock(AnagramsUtil.class);
    new PreviousAnagramsFeature(null, anagramsUtil, Set.of()).execution(List.of("test"));
    assertEquals(
        "test is not an anagram of any previously entered inputs to feature 1\n",
        outputStream.toString());
  }

}