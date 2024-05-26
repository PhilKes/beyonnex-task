package io.github.philkes.feature;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public abstract class Feature {

  private final String description;
  private final Set<String> featureInputs = new HashSet<>();
  private final List<String> inputDescriptions;
  private final Scanner scanner;

  public Feature(String description, List<String> inputDescriptions, Scanner scanner) {
    this.description = description;
    this.inputDescriptions = inputDescriptions;
    this.scanner = scanner;
  }

  protected List<String> inputs() {
    return inputDescriptions.stream()
        .map(inputDescription -> {
          System.out.printf("Enter %s: ", inputDescription);
          return scanner.nextLine();
        }).toList();
  }

  public void execute() {
    List<String> inputs = inputs();
    this.featureInputs.addAll(inputs);
    execution(inputs);
  }

  protected abstract void execution(List<String> inputs);

  public Set<String> getFeatureInputs() {
    return featureInputs;
  }

  public String getDescription() {
    return description;
  }
}
