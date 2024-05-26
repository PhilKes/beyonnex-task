package io.github.philkes.util;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramsUtilTest {

  @ParameterizedTest
  @MethodSource("areAnagramsArguments")
  void areAnagrams(String s1, String s2, boolean expected) {
    assertEquals(expected, new AnagramsUtil().areAnagrams(s1, s2));
  }

  private static Stream<Arguments> areAnagramsArguments() {
    return Stream.of(
        Arguments.of("test", "test", true),
        Arguments.of("test", "TEST", false),
        Arguments.of("stet", "test", true),
        Arguments.of("", "", true),
        Arguments.of("1234", "123", false),
        Arguments.of(null, "123", false),
        Arguments.of("123", null, false),
        Arguments.of(null, null, false)
    );
  }
}