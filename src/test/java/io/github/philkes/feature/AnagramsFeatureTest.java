package io.github.philkes.feature;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.github.philkes.util.AnagramsUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramsFeatureTest {

  private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  public void setup() {
    outputStream.reset();
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void executionAnagrams() {
    var anagramsUtil = mock(AnagramsUtil.class);
    when(anagramsUtil.areAnagrams("test", "stet")).thenReturn(true);
    new AnagramsFeature(null, anagramsUtil).execution(List.of("test", "stet"));
    assertEquals("test is an anagram of stet\n", outputStream.toString());
  }

  @Test
  void executionNotAnagrams() {
    var anagramsUtil = mock(AnagramsUtil.class);
    when(anagramsUtil.areAnagrams("test", "123")).thenReturn(false);
    new AnagramsFeature(null, anagramsUtil).execution(List.of("test", "123"));
    assertEquals("test is not an anagram of 123\n", outputStream.toString());
  }

}