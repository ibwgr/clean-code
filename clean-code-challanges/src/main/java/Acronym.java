package main.java;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;
/**
 * Convert a phrase to its acronym.
 * <p>
 * Techies love their TLA (Three Letter Acronyms)!
 * <p>
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
public class Acronym {

  String insert;

  public Acronym(String phrase) {
    insert = phrase;
  }
  public String get() {
    insert = insert.replaceAll("[-]", " ");
    String[] words = insert.replaceAll("[^a-zA-Z ]", "").toUpperCase().split("\\s+");
    String acronym = "";
    for (int i = 0; i < words.length; i++)
      acronym += words[i].charAt(0);
    return acronym;
  }
}
